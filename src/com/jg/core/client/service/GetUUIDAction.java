package com.jg.core.client.service;


/**
 *
 */
public class GetUUIDAction extends DefaultAction<UUIDResult> {

    private static final long serialVersionUID = 8408382113295327465L;

    private int numberOfIds;

    public GetUUIDAction() {
    }

    public GetUUIDAction(int numberOfIds) {
        this.numberOfIds = numberOfIds;
    }

    public int getNumberOfIds() {
        return numberOfIds;
    }

    public void setNumberOfIds(int numberOfIds) {
        this.numberOfIds = numberOfIds;
    }
}