package com.albo.cat.actions;

import com.albo.cat.entity.Cat;
import com.albo.cat.exception.ActionNotFoundException;
import com.albo.cat.util.CheckerCatParameters;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.stereotype.Component;

import java.util.List;


@Component
public class ActionProcessor {

    private final CheckerCatParameters checkerCatParameters;
    private final BeanFactory beanFactory;


    public ActionProcessor(BeanFactory beanFactory, CheckerCatParameters checkerCatParameters) {
        this.beanFactory = beanFactory;
        this.checkerCatParameters = checkerCatParameters;
    }

    public List<Action> doProcess(Cat cat, Action action) {
        List<Action> listOfAvailableActions = beanFactory.getBean(action.toString(), CatAction.class).doAction(cat);
        checkerCatParameters.checkAndEdit(cat);
        return listOfAvailableActions;
    }
}

