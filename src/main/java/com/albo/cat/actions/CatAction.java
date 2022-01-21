package com.albo.cat.actions;

import com.albo.cat.data.base.PossibleActionsDataBase;
import com.albo.cat.entity.Cat;

import java.util.Map;

public interface CatAction {

    Map<String, String> doAction(Cat cat, String previousAction, PossibleActionsDataBase possibleActionsDataBase);

}
