package com.jg.core.server.services;

import com.jg.core.client.appcontrol.ApplicationException;
import com.jg.core.client.service.Action;
import com.jg.core.client.service.DefaultAction;
import com.jg.core.client.service.Result;
import com.jg.core.server.repository.Repository;

/**
 *
 */
public abstract class ActionHandler<A extends Action<?>, R extends Result> {
    private Integer clientLanguage;
    private Repository repository;

    public Integer getClientLanguage() {
        return clientLanguage;
    }

    public void setClientLanguage(Integer clientLanguage) {
        this.clientLanguage = clientLanguage;
    }

    public Repository getRepository() {
        return repository;
    }

    public void setRepository(Repository repository) {
        this.repository = repository;
    }

    public abstract R execute(A action) throws ApplicationException;

    public abstract Class<A> getActionType();
}
