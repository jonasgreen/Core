package com.jg.core.server;

import com.jg.core.client.CoreService;
import com.jg.core.server.services.*;
import com.google.gwt.user.server.rpc.*;
import com.jg.core.client.service.*;


/**
 * The server side implementation of the RPC service.
 */
@SuppressWarnings("serial")
public abstract class CoreServlet extends RemoteServiceServlet implements CoreService {

    protected ActionHandlerRegistry registry = null;
    
    public Result execute(Action<?> action) throws Exception {
       return getRegistry().executeAction(action);
    }

    public void init() {
        getRegistry();
    }

    private synchronized ActionHandlerRegistry getRegistry() {
        if (registry == null) {
            registry = new ActionHandlerRegistry(getServletContext());
            initCoreHandlers(registry);
            init(registry);
        }
        return registry;
    }


    private void initCoreHandlers(ActionHandlerRegistry registry) {
        registry.add(new GetUUIDHandler());

        //GENERICS
        registry.add(new GetAllHandler());
        registry.add(new GetHandler());
        registry.add(new FindByHandler());
        registry.add(new DeleteHandler());
        registry.add(new UpdateHandler());

        //LOG
        registry.add(new LogHandler());



    }

    protected abstract void init(ActionHandlerRegistry registry);


}
