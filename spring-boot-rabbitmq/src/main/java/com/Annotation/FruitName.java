package com.Annotation;

import java.lang.annotation.*;



    /**
     8  * 水果名称注解
     9  */
 @Target(ElementType.FIELD)
 @Retention(RetentionPolicy.RUNTIME)
 @Documented
 public @interface FruitName {
     String value() default "";
 }


