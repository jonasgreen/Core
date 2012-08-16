package com.jg.core.server.services;


import com.jg.core.server.repository.*;
import com.jg.core.client.appcontrol.*;
import com.jg.core.client.service.*;

/**
 *
 */
public class GetAllHandler extends ActionHandler<GetAllAction, ListResult> {

    public ListResult execute(GetAllAction action) throws ApplicationException {
        Repository r = getRepository();
        return new ListResult(r.getAll());
    }


    public Class<GetAllAction> getActionType() {
        return GetAllAction.class;
    }


}