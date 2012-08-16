package com.jg.core.server.services;

import com.jg.core.server.Logger;
import com.jg.core.server.repository.*;
import com.jg.core.client.appcontrol.*;
import com.jg.core.client.service.*;

import javax.servlet.*;
import javax.servlet.http.*;
import java.util.*;

/**
 *
 */
public class ActionHandlerRegistry {

    private ServletContext context;
    private String baseUrl;

    private Map<Class, ActionHandler> handlers = new HashMap<Class, ActionHandler>();
    private Map<Class, Repository> repositories = new HashMap<Class, Repository>();

    public ActionHandlerRegistry(ServletContext servletContext) {
        context = servletContext;
        Logger.init(servletContext);
    }



    public void add(ActionHandler handler) {
        handlers.put(handler.getActionType(), handler);
    }

    public void add(Repository rep){
        repositories.put(rep.getRepositoryType(), rep);
    }


    public Result executeAction(Action<?> a) throws ApplicationException {
        try {
            ActionHandler actionHandler = getHandler(a);
            if (actionHandler == null) {
                String s = a.getClass().getName() + " has no ActionHandler";
                Logger.log(s);
                throw new SystemException(s);
            }
            if (a instanceof GenericModelAction) {
                Repository rep = null;//repositories.get(((GenericModelAction<?,?>) a).getModelClass());
                if (rep == null) {
                    //String s = "GenricModelAction for model " + ((GenericModelAction<?,?>) a).getModelClass().getName() + " has no Repository set op for it";
                    //Logger.log(s);
                    //throw new SystemException(s);
                }
                actionHandler.setRepository(rep);
            }
            actionHandler.setClientLanguage(a.getLanguage());
            return actionHandler.execute(a);
        }
        catch (Throwable t) {
            String s = "Error caught in Servlet: " + t.getClass().getName();
            Logger.log(s, t);
            if (t instanceof SystemException) {
                throw (SystemException) t;
            }
            if (t instanceof ApplicationException) {
                throw (ApplicationException) t;
            }
            throw new SystemException(t.getMessage());
        }
    }

    private ActionHandler getHandler(Action<?> a) {
        ActionHandler handler = handlers.get(a.getClass());
        if (handler == null) {
            throw new SystemException("ActionHandler not setup for Action: " + a.getClass());
        }
        return handler;
    }


    public ServletContext getContext() {
        return context;
    }

    public String getBaseUrl() {
        return baseUrl;
    }

    public void setRequestSettings(HttpServletRequest r) {
        if (baseUrl == null) {
            if (r.getServerName().indexOf("http://") != -1) {
                baseUrl = r.getServerName();
            }
            else if (r.getServerName().indexOf("www") != -1) {
                baseUrl = "http://" + r.getServerName();
            }
            else {
                baseUrl = "http://www." + r.getServerName();
            }
        }
    }


}