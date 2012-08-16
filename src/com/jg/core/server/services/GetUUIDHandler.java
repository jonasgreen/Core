package com.jg.core.server.services;

import com.jg.core.client.appcontrol.*;
import com.jg.core.client.service.*;

import java.util.*;

/**
 *
 */
public class GetUUIDHandler extends ActionHandler<GetUUIDAction, UUIDResult> {
	

    public UUIDResult execute(GetUUIDAction action) throws ApplicationException {
        return createUserAccount(action);
    }


    private UUIDResult createUserAccount(GetUUIDAction action) throws ApplicationException {

        int i = 0;
        List<String> ids = new ArrayList<String>();

        while (i <= action.getNumberOfIds()) {
            i++;
            ids.add(UUID.randomUUID().toString());
        }

        return new UUIDResult(ids);
    }


    public Class<GetUUIDAction> getActionType() {
        return GetUUIDAction.class;
    }


	


	

	


}
