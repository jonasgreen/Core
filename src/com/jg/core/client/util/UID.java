package com.jg.core.client.util;


import com.google.gwt.user.client.Window;

/**
 *
 */
public class UID {
    public static String getUID(){
        return Window.Location.getHostName() + " "+ System.currentTimeMillis();
    }
}
