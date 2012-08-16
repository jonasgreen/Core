package com.jg.core.client.service;

import com.google.gwt.user.client.rpc.AsyncCallback;
import com.jg.core.client.appcontrol.ApplicationException;

/**
 *
 */
public abstract class CallBack<T> implements AsyncCallback<T> {

    public void onFailure(Throwable caught) {
        fail(caught);
    }


    public void onSuccess(T result) {
        success(result);
    }

    public abstract void success(T result);

    public abstract void fail(Throwable t);
}
