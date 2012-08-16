package com.jg.core.client;


import com.google.gwt.user.client.rpc.*;
import com.jg.core.client.service.Action;
import com.jg.core.client.service.Result;

/**
 *
 */
public interface ServerWrapperAsync {

    <A extends Action<R>, R extends Result> void execute( A action, AsyncCallback<R> callback );

}
