package com.lee.thinking.chapter20.util;

import com.lee.thinking.chapter20.anno.UserCase;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by mingzhu on 2016/7/13.
 */
public class UseCaseTracker {
    public static void trackUseCase(List<Integer> useCases, Class<?> cls){
        for(Method m : cls.getDeclaredMethods()){
            UserCase u = m.getAnnotation(UserCase.class);
            if(u != null){
                System.out.println("Found Use Case:" + u.id() + " " + u.description());
                useCases.remove(new Integer(u.id()));
            }
        }
        for(int i : useCases){
            System.out.println("Warning: Missing use case-" + i);
        }
    }

    public static void main(String[] args) {
        List<Integer> useCases = new ArrayList<>();
        Collections.addAll(useCases, 47,48,49,50);
        UseCaseTracker.trackUseCase(useCases, PasswordUtils.class);
    }
}
