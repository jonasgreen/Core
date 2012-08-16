package com.jg.core.server.services;


import com.jg.core.server.dao.*;
import com.jg.core.client.appcontrol.*;
import com.jg.core.client.service.*;

/**
 *
 */
public class DeleteHandler extends ActionHandler<DeleteAction, VoidResult> {

    public VoidResult execute(DeleteAction action) throws ApplicationException {

        try {
            PMF.startTransaction();
            getRepository().delete(action.getIndexKey());
            PMF.commitTransaction();
            return new VoidResult();

        }
        finally {
            PMF.endTransaction();
        }
    }


    public Class<DeleteAction> getActionType() {
        return DeleteAction.class;
    }


}