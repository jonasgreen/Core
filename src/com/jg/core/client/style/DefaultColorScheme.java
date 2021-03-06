package com.jg.core.client.style;

/**
 *
 */
public class DefaultColorScheme implements ColorScheme{




    private final String BASE = "#8E8E8E";
    private final String BASE_LIGHT = "#638e52";
    private final String BASE_DARK = "#333333";

    private final String COMPL = "#FFb200";
    private final String COMPL_LIGHT = "#FFC94D";
    private final String COMPL_DARK = "#CC8F00";


    //BASE COLOR
    P BackgroundBase = new P(Name.BACKGROUND, BASE);
    P backgroundBaseLight = new P(Name.BACKGROUND, BASE_LIGHT);
    P backgroundBaseDark = new P(Name.BACKGROUND, BASE_DARK);

    P colorBase = new P(Name.COLOR, BASE);
    P colorBaseLight = new P(Name.COLOR, BASE_LIGHT);
    P colorBaseDark = new P(Name.COLOR, BASE_DARK);


    //CONTRA COLOR
    P backgroundCompl = new P(Name.BACKGROUND, COMPL);
    P backgroundComplLight = new P(Name.BACKGROUND, COMPL_LIGHT);
    P backgroundComplDark = new P(Name.BACKGROUND, COMPL_DARK);

    P colorCompl = new P(Name.COLOR, COMPL);
    P colorComplLight = new P(Name.COLOR, COMPL_LIGHT);
    P colorComplDark = new P(Name.COLOR, COMPL_DARK);

    public P backgroundBase() {
        return BackgroundBase;
    }

    public P backgroundBaseLight() {
        return backgroundBaseLight;
    }

    public P backgroundBaseDark() {
        return backgroundBaseDark;
    }

    public P textBase() {
        return colorBase;
    }

    public P textBaseLight() {
        return colorBaseLight;
    }

    public P textBaseDark() {
        return colorBaseDark;
    }

    public P backgroundCompl() {
        return backgroundCompl;
    }

    public P backgroundComplLight() {
        return backgroundComplLight;
    }

    public P backgroundComplDark() {
        return backgroundComplDark;
    }

    public P textCompl() {
        return colorCompl;
    }

    public P textComplLight() {
        return colorComplLight;
    }

    public P textComplDark() {
        return colorComplDark;
    }
}
