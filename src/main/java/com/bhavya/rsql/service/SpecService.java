package com.bhavya.rsql.service;

import com.bhavya.rsql.custom_builder.CustomRsqlVisitor;
import com.bhavya.rsql.custom_builder.RsqlPathBuilder;
import com.bhavya.rsql.custom_builder.RsqlSpecificationBuilder;
import cz.jirutka.rsql.parser.RSQLParser;
import cz.jirutka.rsql.parser.ast.Node;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.EntityManager;

public class SpecService<E> {

  @Autowired
  private RSQLParser parser;

  @Autowired
  private EntityManager entityManager;

  public Specification<E> getSpec(String filter){
    Node rootNode = parser.parse(filter);
    return rootNode.accept(new CustomRsqlVisitor<>(new RsqlSpecificationBuilder<>(new RsqlPathBuilder(entityManager))));
  }

}
