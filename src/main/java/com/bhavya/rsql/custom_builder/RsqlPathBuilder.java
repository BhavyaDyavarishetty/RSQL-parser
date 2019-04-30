package com.bhavya.rsql.custom_builder;

import javax.persistence.EntityManager;
import javax.persistence.criteria.From;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.Path;
import javax.persistence.metamodel.Attribute;
import javax.persistence.metamodel.ManagedType;
import javax.persistence.metamodel.Metamodel;
import javax.persistence.metamodel.PluralAttribute;
import java.lang.reflect.Field;

public class RsqlPathBuilder {

  private final EntityManager entityManager;

  public RsqlPathBuilder(EntityManager entityManager) {
    this.entityManager = entityManager;
  }

  /**
   * Construct query path by traversing through entity graph
   * Supports only one join per class for now
   */
  public Path<?> getAttributePath(String property, Path path) throws Exception {

    String[] segments = property.split("\\.");

    Path<?> classPath = path;
    Metamodel metaModel = entityManager.getMetamodel();
    ManagedType<?> metaData = metaModel.managedType(classPath.getJavaType());

    for (String segment : segments) {
      Attribute attribute = metaData.getAttribute(segment);
      if (attribute.isAssociation()) {
        Class<?> associationType = findPropertyType(segment, metaData);
        metaData = metaModel.managedType(associationType);

        if (classPath instanceof Join) {
          classPath = classPath.get(segment);
        } else {
          //Sub-entity type
          Field field = path.getClass().getSuperclass().getDeclaredField("joins");
          field.setAccessible(true);
          classPath = ((From) classPath).join(segment);

        }
      } else {
        //Property
        classPath = classPath.get(segment);
      }
    }

    return classPath;
  }

  private Class<?> findPropertyType(String property, ManagedType<?> metaModel) {
    return metaModel.getAttribute(property).isCollection() ?
        ((PluralAttribute) metaModel.getAttribute(property)).getBindableJavaType() :
        metaModel.getAttribute(property).getJavaType();
  }

}
