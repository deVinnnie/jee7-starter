package com.realdolmen.course.service;

import com.realdolmen.course.domain.Silly;
import com.realdolmen.course.domain.NumberGenerator;

import javax.annotation.PostConstruct;
import javax.enterprise.context.Conversation;
import javax.inject.Inject;
import javax.inject.Named;

@Named
public class BookService {
    @Inject @Silly
    private NumberGenerator numberGenerator;



    @PostConstruct
    public void init(){
        System.out.println("---------------------------------------------------------");
        System.out.println("---------------------------------------------------------");
        System.out.println("---------------------------------------------------------");


        System.out.println("NumberGenerator " + numberGenerator.getClass().getName());

        System.out.println("---------------------------------------------------------");
        System.out.println("---------------------------------------------------------");
        System.out.println("---------------------------------------------------------");
    }

    public String getGeneratorName(){
        return numberGenerator.getClass().getName();
    }




}
