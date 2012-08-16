package com.jg.core.client.service;

import com.jg.core.client.model.Model;

/**
 *
 */
public class FindByAction<M extends Model, R extends ListResult<M>> extends GenericModelAction<M, R>{
    private static final long serialVersionUID = -5730956869371851311L;

    private Finder finder;

    public FindByAction() {
    }

    public FindByAction(Finder f) {
        this.finder = f;
    }

    public Finder getFinder() {
        return finder;
    }

    public void setFinder(Finder finder) {
        this.finder = finder;
    }
}