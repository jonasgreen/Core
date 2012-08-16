package com.jg.core.server.services;


import com.jg.core.server.repository.*;
import com.jg.core.client.appcontrol.*;
import com.jg.core.client.service.*;

/**
 *
 */
public class GetHandler extends ActionHandler<GetAction, SingleResult> {

    public SingleResult execute(GetAction action) throws ApplicationException {
        Repository r = getRepository();
        return new SingleResult(r.get(action.getIndexKey()));
    }


    public Class<GetAction> getActionType() {
        return GetAction.class;
    }


}