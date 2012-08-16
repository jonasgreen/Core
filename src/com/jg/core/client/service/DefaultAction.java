package com.jg.core.client.service;


/**
 *
 */
public abstract class DefaultAction<R extends Result>  implements Action<R> {
    private static final long serialVersionUID = -6345103274608935009L;

    private Integer language;

    public Integer getLanguage() {
        return language;
    }

    public void setLanguage(Integer language) {
        this.language = language;
    }
}
