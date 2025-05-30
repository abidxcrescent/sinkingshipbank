package com.abid.sinkingship.customAnnotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/*
    This is a custom annotation.
    To write a meaningful custom annotation we need:
    a. RetentionPolicy
        SOURCE(it removed when code is compiled)
        CLASS(it is present after code is compiled .java to .class)
        RUNTIME(it is present )
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface MyCustomAnnotation {

    String value() default "interceptor annotation";

}
