package com.jg.core.server.services;

import com.jg.core.server.Logger;
import com.jg.core.client.appcontrol.*;
import com.jg.core.client.service.*;

/**
 *
 */public class LogHandler  extends ActionHandler<LogAction, VoidResult> {


    public VoidResult execute(LogAction action) throws ApplicationException {
        log(action);
        return new VoidResult();
    }

    private void log(LogAction a) {
        StringBuffer sb = new StringBuffer("CLIENT_LOG: ");
        sb.append(a.getType().name()).append(" ").append(a.getLogMessage());

        @SuppressWarnings({"ThrowableResultOfMethodCallIgnored"})
        Throwable t = a.getThrowable();
        if (t != null) {
            Logger.log(sb.toString(), t);
        }
        else {
            Logger.log(sb.toString());
        }

    }


    public Class<LogAction> getActionType() {
        return LogAction.class;
    }


}