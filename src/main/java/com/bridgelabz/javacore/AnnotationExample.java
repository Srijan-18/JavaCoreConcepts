package com.bridgelabz.javacore;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

public class AnnotationExample {
    @Override
    @MethodInfo(author = "Srijan", comments = "Main Method", date = "June 24 2020", revision = 1)
    public String toString() {
        return "Overriddein toString Method";
    }

    @Deprecated
    @MethodInfo(comments = "Depricated Method", date = "June24 2020")
    public static void oldMethod() {
        System.out.println("Old Method don't use it.");
    }

    public static void main(String[] args) {
        try {
            for (Method method: AnnotationExample.class.getMethods()) {
                if(method.isAnnotationPresent(MethodInfo.class)){
                    try {
                        for (Annotation anno: method.getDeclaredAnnotations()) {
                            System.out.println("Annotation in method "+method+" is :"+anno);
                        }
                        MethodInfo methodAnnotation=method.getAnnotation(MethodInfo.class);
                        if(methodAnnotation.revision()==1)
                            System.out.println("Method with revision number 1 ="+method);
                    }catch (Throwable ex){
                        ex.printStackTrace();
                    }
                }

            }
        }catch (SecurityException e){
            e.printStackTrace();
        }
    }
}