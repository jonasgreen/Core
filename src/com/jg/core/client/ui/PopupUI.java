package com.jg.core.client.ui;

import com.google.gwt.dom.client.Style;
import com.google.gwt.user.client.ui.PopupPanel;
import com.jg.core.client.appcontrol.PopupManager;

/**
 *
 */
public class PopupUI extends PopupPanel{

    public PopupUI() {
        super();
        removeStyleName("gwt-PopupPanel");
        setGlassEnabled(true);
        setModal(true);
        PopupManager.setPopup(this);
    }

    @Override
    public void show(){
        super.show();
        center();
        getElement().getStyle().setPosition(Style.Position.FIXED);
        getElement().getStyle().setTop(150, Style.Unit.PX);

    }







}
