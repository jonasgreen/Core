package com.jg.core.client.appcontrol;

import com.google.gwt.user.client.ui.FlowPanel;

/**
 *
 */
public abstract class Page<C extends PageController> extends FlowPanel{

    private C controller;

    public void setController(C controller){
        this.controller = controller;
    }

    public C getController() {
        return controller;
    }

    public abstract void init();

    public void setFocus(){}



}
