package com.jg.core.client.util;

/**
 *
 */
public class UrlCommand {

    private static native void openUrlNative(String url, String name)/*-{
        $wnd.open(url, name);
    }-*/;

    
    public static void openUrl(String paramString, String name) {
        try {
            openUrlNative(UrlUtil.getBaseUrl()+"#"+paramString, name);
        }
        catch (Throwable t) {
            t.printStackTrace();
        }
    }

}
