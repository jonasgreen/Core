package com.jg.core.client.service;


import com.jg.core.client.model.EntityId;
import com.jg.core.client.model.Model;

/**
 *
 */
public class GetAction<M extends Model> extends GenericModelAction<M, VoidResult>{
    private static final long serialVersionUID = -645574886263670093L;
    private EntityId indexKey;

    public GetAction() {
    }

    public GetAction(Class<M> cl, EntityId indexKey) {
       // super(cl);
        this.indexKey = indexKey;
    }


    public EntityId getIndexKey() {
        return indexKey;
    }

    public void setIndexKey(EntityId indexKey) {
        this.indexKey = indexKey;
    }
}