package com.jg.core.client.service;

import java.io.Serializable;


/**
 *
 */
public class StringSingleFinder extends SingleFinder implements Serializable {
    private static final long serialVersionUID = -9201660323650579466L;

    private String value;

    public StringSingleFinder() {
        super();
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public StringSingleFinder(String colNam, String value) {
        this("String", colNam, SingleFinder.Operator.EQUAL_TO, value);
    }

    public StringSingleFinder(String paramClass, String colNam, SingleFinder.Operator operator, String value) {
        super(paramClass, colNam, operator);
        this.value = value;
    }



}