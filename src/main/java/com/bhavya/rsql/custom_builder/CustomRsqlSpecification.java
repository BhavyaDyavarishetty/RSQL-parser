package com.bhavya.rsql.custom_builder;

import cz.jirutka.rsql.parser.ast.ComparisonOperator;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.*;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class CustomRsqlSpecification<T> implements Specification<T> {

  private String property;
  private ComparisonOperator operator;
  private List<String> arguments;

  CustomRsqlSpecification(String property, ComparisonOperator operator, List<String> arguments) {
    this.property = property;
    this.operator = operator;
    this.arguments = arguments;
  }

  @Override public Predicate toPredicate(Root<T> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
    Path<String> path = root.get(property);
    Class<? extends Object> type = path.getJavaType();
    List<Object> args = castArguments(type);
    Object argument = args.get(0);

    switch (Objects.requireNonNull(RsqlOperatorsEnum.getRsqlOperator(operator))) {
    case EQUAL: {
      if (argument instanceof String) {
        return criteriaBuilder.like(path, argument.toString().replace('*', '%'));
      } else if (argument == null) {
        return criteriaBuilder.isNull(path);
      } else {
        return criteriaBuilder.equal(path, argument);
      }
    }
    case NOT_EQUAL: {
      if (argument instanceof String) {
        return criteriaBuilder.notLike(path, argument.toString().replace('*', '%'));
      } else if (argument == null) {
        return criteriaBuilder.isNotNull(path);
      } else {
        return criteriaBuilder.notEqual(path, argument);
      }
    }
    case GREATER_THAN: {
      return criteriaBuilder.greaterThan(path, argument.toString());
    }
    case GREATER_THAN_OR_EQUAL: {
      return criteriaBuilder.greaterThanOrEqualTo(path, argument.toString());
    }
    case LESS_THAN: {
      return criteriaBuilder.lessThan(path, argument.toString());
    }
    case LESS_THAN_OR_EQUAL: {
      return criteriaBuilder.lessThanOrEqualTo(path, argument.toString());
    }
    case IN: {
      return path.in(args);
    }
    case NOT_IN: {
      return criteriaBuilder.not(path.in(args));
    }
    }

    return null;
  }

  private List<Object> castArguments(Class type) {

    return arguments.stream().map(arg -> {
      if (type.equals(Integer.class)) {
        return Integer.parseInt(arg);
      } else if (type.equals(Long.class)) {
        return Long.parseLong(arg);
      } else if (type.equals(Double.class)) {
        return Double.parseDouble(arg);
      } else {
        return arg;
      }
    }).collect(Collectors.toList());

  }

}
