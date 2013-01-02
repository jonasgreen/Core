package com.jg.core.client.appcontrol;

import com.jg.core.client.ui.PopupUI;

/**
 *
 */
public class PopupManager {
    private static PopupUI latestPopup;


    public static void setPopup(PopupUI popup){
        latestPopup = popup;
    }

    public static void closePopup() {
        if(latestPopup != null && latestPopup.isShowing()){
            latestPopup.hide();
        }
        latestPopup = null;
    }
}
