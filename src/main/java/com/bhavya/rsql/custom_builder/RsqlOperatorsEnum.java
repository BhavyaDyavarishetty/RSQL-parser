package com.bhavya.rsql.custom_builder;

import cz.jirutka.rsql.parser.ast.ComparisonOperator;
import cz.jirutka.rsql.parser.ast.RSQLOperators;
import lombok.Getter;

@Getter
public enum RsqlOperatorsEnum {
  EQUAL(RSQLOperators.EQUAL), //"=="
  NOT_EQUAL(RSQLOperators.NOT_EQUAL), //"!="
  IN(RSQLOperators.IN), //"=in="
  NOT_IN(RSQLOperators.NOT_IN), //"=out="
  GREATER_THAN(RSQLOperators.GREATER_THAN), //"=gt="
  GREATER_THAN_OR_EQUAL(RSQLOperators.GREATER_THAN_OR_EQUAL), //"=ge="
  LESS_THAN(RSQLOperators.LESS_THAN), //"=lt="
  LESS_THAN_OR_EQUAL(RSQLOperators.LESS_THAN_OR_EQUAL); //"=le="

  private ComparisonOperator operator;

  RsqlOperatorsEnum(ComparisonOperator operator) {
    this.operator = operator;
  }

  public static RsqlOperatorsEnum getRsqlOperator(ComparisonOperator operator) {
    for (RsqlOperatorsEnum operation : values()) {
      if (operation.getOperator() == operator) {
        return operation;
      }
    }
    return null;
  }
}
