package com.bhavya.rsql.custom_builder;

import cz.jirutka.rsql.parser.ast.AndNode;
import cz.jirutka.rsql.parser.ast.ComparisonNode;
import cz.jirutka.rsql.parser.ast.OrNode;
import cz.jirutka.rsql.parser.ast.RSQLVisitor;
import org.springframework.data.jpa.domain.Specification;

public class CustomRsqlVisitor<T> implements RSQLVisitor<Specification<T>, Void> {

  private RsqlSpecificationBuilder<T> builder;

  public CustomRsqlVisitor(RsqlSpecificationBuilder<T> builder) {
    this.builder = builder;
  }

  @Override public Specification<T> visit(AndNode node, Void param) {
    return builder.createSpecification(node);
  }

  @Override public Specification<T> visit(OrNode node, Void param) {
    return builder.createSpecification(node);
  }

  @Override public Specification<T> visit(ComparisonNode node, Void param) {
    return builder.createSpecification(node);
  }
}
