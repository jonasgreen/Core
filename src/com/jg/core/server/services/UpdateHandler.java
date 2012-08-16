package com.jg.core.server.services;


import com.jg.core.server.repository.*;
import com.jg.core.client.appcontrol.*;
import com.jg.core.client.model.*;
import com.jg.core.client.service.*;

/**
 *
 */
public class UpdateHandler extends ActionHandler<UpdateAction, SingleResult> {

	
    public SingleResult execute(UpdateAction action) throws ApplicationException {
        Repository r = getRepository();
        return new SingleResult<Model>(r.update(action.getModel()));
    }


    public Class<UpdateAction> getActionType() {
        return UpdateAction.class;
    }


}