package com.jg.core.client.service;

import com.jg.core.client.model.*;


/**
 *
 */
public class UpdateAction <M extends Model> extends GenericModelAction<M, SingleResult>{
    private static final long serialVersionUID = -8239767251624196685L;

    private M model;

    public UpdateAction() {
    }

    public UpdateAction(Class<M> modelClass, M model) {
        //super(modelClass);
        this.model = model;
    }


    public M getModel() {
        return model;
    }

    public void setModel(M model) {
        this.model = model;
    }
}