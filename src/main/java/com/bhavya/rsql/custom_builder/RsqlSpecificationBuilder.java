package com.bhavya.rsql.custom_builder;

import cz.jirutka.rsql.parser.ast.ComparisonNode;
import cz.jirutka.rsql.parser.ast.LogicalNode;
import cz.jirutka.rsql.parser.ast.LogicalOperator;
import cz.jirutka.rsql.parser.ast.Node;
import org.springframework.data.jpa.domain.Specification;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static org.springframework.data.jpa.domain.Specification.where;

class RsqlSpecificationBuilder<T> {

  private Specification<T> createSpecification(Node node) {
    if (node instanceof LogicalNode) {
      return createSpecification((LogicalNode) node);
    }
    if (node instanceof ComparisonNode) {
      return createSpecification((ComparisonNode) node);
    }
    return null;
  }

  Specification<T> createSpecification(LogicalNode logicalNode) {
    List<Specification> specs = logicalNode.getChildren()
        .stream()
        .map(this::createSpecification)
        .filter(Objects::nonNull)
        .collect(Collectors.toList());

    Specification<T> result = specs.get(0);
    if (logicalNode.getOperator() == LogicalOperator.AND) {
      for (int i = 1; i < specs.size(); i++) {
        result = where(result).and(specs.get(i));
      }
    } else if (logicalNode.getOperator() == LogicalOperator.OR) {
      for (int i = 1; i < specs.size(); i++) {
        result = where(result).or(specs.get(i));
      }
    }

    return result;
  }

  public Specification<T> createSpecification(ComparisonNode comparisonNode) {
    return where(new CustomRsqlSpecification<T>(comparisonNode.getSelector(), comparisonNode.getOperator(),
        comparisonNode.getArguments()));
  }
}
