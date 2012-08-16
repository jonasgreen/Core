package com.jg.core.client.service;


import com.jg.core.client.model.EntityId;
import com.jg.core.client.model.Model;

/**
 *
 */
public class DeleteAction<M extends Model> extends GenericModelAction<M, VoidResult>{
    private static final long serialVersionUID = -6917837239422306676L;
    private EntityId indexKey;

    private DeleteAction() {
    }

    public DeleteAction(EntityId indexKey) {
        super();
        this.indexKey = indexKey;
    }


    public EntityId getIndexKey() {
        return indexKey;
    }

    public void setIndexKey(EntityId indexKey) {
        this.indexKey = indexKey;
    }
}