package com.jg.core.client.service;

import com.jg.core.client.model.Model;

/**
 *
 */
public class GetAllAction<M extends Model> extends GenericModelAction<M, ListResult>{

    private static final long serialVersionUID = -645574886263670093L;

    public GetAllAction() {
    }

    public GetAllAction(Class<M> mClass) {
       // super(mClass);
    }

}