package com.jg.core.client.util;

import com.google.gwt.dom.client.Document;
import com.google.gwt.user.client.History;

import java.util.HashMap;
import java.util.Map;

/**
 * TODO - make generel
 */
public class UrlUtil {

    public static String TOKEN = "token";

    private static String baseUrl;
    private static boolean initialized = false;

    private static String DOMAIN_PROD = "http://www.xxx.appspot.com";
    private static String DOMAIN_LOCALHOST = "http://127.0.0.1:8888/xxx.html?gwt.codesvr=127.0.0.1:9997";


    public static void init(String appid) {
        String domain = Document.get().getDomain();
        if (domain == null || domain.contains("bracketbird.appspot")) {
            baseUrl = DOMAIN_PROD.replace("xxx", appid);
        }
        else {
            baseUrl = DOMAIN_LOCALHOST.replace("xxx", appid);
        }
        initialized = true;
    }


    public static String getBaseUrl() {
        if(!initialized){
            throw new RuntimeException("Not initialized - please do as one of the first things in entry class.");
        }
        return baseUrl;
    }

    public static Map<String, String> getParameters() {
        String token = History.getToken();

        HashMap<String, String> pMap = new HashMap<String, String>();

        pMap.put(TOKEN, token);

        //if parameters exist
        if (token.contains("?")) {
            String parameters = token.split("\\?")[1];

            if (parameters.contains("&")) {
                String[] ss = parameters.split("&");
                for (String s : ss) {
                    String[] kv = s.split("=");
                    pMap.put(kv[0], kv[1]);
                }
            }
            //only one parameter
            else {
                String[] kv = parameters.split("=");
                pMap.put(kv[0], kv[1]);
            }

        }

        //TODO - catch error and show errorpage with option for goin to onlineclubmaster

        return pMap;
    }


}
