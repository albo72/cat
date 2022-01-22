package com.albo.cat.actions;

import com.albo.cat.entity.Cat;
import com.albo.cat.exception.ActionNotFoundException;
import com.albo.cat.util.CheckerCatParameters;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


@Component
public class ActionProcessor {

    private final CheckerCatParameters checkerCatParameters;
    private final BeanFactory beanFactory;


    public ActionProcessor(BeanFactory beanFactory, CheckerCatParameters checkerCatParameters) {
        this.beanFactory = beanFactory;
        this.checkerCatParameters = checkerCatParameters;
    }

    public List<Action> doProcess(Cat cat, String action) throws ActionNotFoundException {
        List<Action> listOfAvailableActions = null;
        if (action == null) {
            listOfAvailableActions = new ArrayList<>(Arrays.asList(Action.values()));
        } else {
            boolean isDone = false;
            for (Action value : Action.values()) {
                if (action.equals(value.toString())) {
                    cat.setCatAction(beanFactory.getBean(action, CatAction.class));
                    listOfAvailableActions = cat.doAction();
                    isDone = true;
                }
            }
            if (!isDone) {
                throw new ActionNotFoundException("Action not found! Error");
            }
            checkerCatParameters.checkAndEdit(cat);
            cat.setCatAvatar(Action.valueOf(action.toUpperCase()).getAvatar());
        }
        return listOfAvailableActions;
    }

}

