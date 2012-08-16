package com.jg.core.client.service;

import com.jg.core.client.model.*;


/**
 *
 */
public class SingleResult<M extends Model> implements Result{
    private static final long serialVersionUID = -2615108262997306218L;

    private M result;

    public SingleResult(M result) {
        this.result = result;
    }

    public SingleResult() {
    }

    public M getResult() {
        return result;
    }

    public void setResult(M result) {
        this.result = result;
    }
}