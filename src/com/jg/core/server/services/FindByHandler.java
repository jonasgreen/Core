package com.jg.core.server.services;


import com.jg.core.server.repository.*;
import com.jg.core.client.appcontrol.*;
import com.jg.core.client.service.*;

/**
 *
 */
public class FindByHandler extends ActionHandler<FindByAction, ListResult> {

    public ListResult execute(FindByAction action) throws ApplicationException {
        Repository r = getRepository();
        return new ListResult(r.findBy(action.getFinder()));
    }


    public Class<FindByAction> getActionType() {
        return FindByAction.class;
    }


}