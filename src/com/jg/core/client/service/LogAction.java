package com.jg.core.client.service;


/**
 *
 */
public class LogAction extends DefaultAction<VoidResult> {

    private static final long serialVersionUID = 2210150240885850407L;



    public enum Type{
        info,
        address_not_found,
        load_first_page,
        system_error,
    }

    private Throwable throwable;
    private String logMessage;
    private Type type;




    public LogAction() {
    }

    public LogAction(String logMessage, Type type) {
        this(logMessage, type, null);
    }

    public LogAction(String logMessage, Type type, Throwable t) {
        this.logMessage = logMessage;
        this.type = type;
        this.throwable = t;
    }

    public String getLogMessage() {
        return logMessage;
    }

    public void setLogMessage(String logMessage) {
        this.logMessage = logMessage;
    }

    public Throwable getThrowable() {
        return throwable;
    }

    public void setThrowable(Throwable throwable) {
        this.throwable = throwable;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }
}
