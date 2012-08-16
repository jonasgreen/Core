package com.jg.core.server;

import javax.servlet.ServletContext;

/**
 *
 */
public class Logger {
    private static ServletContext context;

    private static String POSSIBLE_DATA_ERROR = "POSSIBLE_DATA_ERROR";

    public static void init(ServletContext sc) {
        context = sc;
    }

    public static void log(String text) {
        if (context != null) {
            context.log(text);
        }
    }

    public static void logPossibleDataError(String text) {
        if (context != null) {
            context.log(POSSIBLE_DATA_ERROR + " " + text);
        }
    }


    public static void log(String text, Throwable t) {
        if (context != null) {
            context.log(text, t);
        }
    }
}
