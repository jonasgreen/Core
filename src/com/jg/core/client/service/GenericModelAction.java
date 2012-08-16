package com.jg.core.client.service;

import com.jg.core.client.model.Model;

import java.io.Serializable;

/**
 *
 */
public abstract class GenericModelAction<M extends Model, R extends Result> extends DefaultAction<R> {
    private static final long serialVersionUID = -6345103274608935009L;

    protected GenericModelAction() {
    }

}
