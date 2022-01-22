package com.albo.cat.actions;

import com.albo.cat.data.base.PossibleActionsDataBase;
import com.albo.cat.entity.Cat;

import java.util.List;

public interface CatAction {

    List<Action> doAction(Cat cat);

}
