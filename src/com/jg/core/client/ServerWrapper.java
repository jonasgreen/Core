package com.jg.core.client;

import com.google.gwt.core.client.*;
import com.google.gwt.user.client.rpc.*;
import com.jg.core.client.service.Action;
import com.jg.core.client.service.Result;

/**
 *
 */
public class ServerWrapper implements ServerWrapperAsync {

    private static final CoreServiceAsync server = GWT.create(CoreService.class);


    public ServerWrapper() {
    }

    public <A extends Action<R>, R extends Result> void execute(A action, final AsyncCallback<R> callback ) {

        server.execute( action, new AsyncCallback<Result>() {
            public void onFailure( Throwable caught ) {
                callback.onFailure( caught );
            }

            public void onSuccess( Result result ) {
                callback.onSuccess( ( R ) result );
            }
        } );
    }

}
