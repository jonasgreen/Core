package com.jg.core.client.ui;

import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.HTML;

/**
 *
 */
public class SpinnerUI extends FlowPanel{
    public SpinnerUI() {

        HTML html = new HTML();
        add(html);

        html.setHTML("<style>\n" +
                "#floatingBarsG{\n" +
                "position:relative;\n" +
                "width:40px;\n" +
                "height:50px}\n" +
                "\n" +
                ".blockG{\n" +
                "position:absolute;\n" +
                "background-color:#FFFFFF;\n" +
                "width:3px;\n" +
                "height:16px;\n" +
                "-moz-border-radius:3px 3px 0 0;\n" +
                "-moz-transform:scale(0.2);\n" +
                "-moz-animation-name:fadeG;\n" +
                "-moz-animation-duration:1.04s;\n" +
                "-moz-animation-iteration-count:infinite;\n" +
                "-moz-animation-direction:linear;\n" +
                "-webkit-border-radius:3px 3px 0 0;\n" +
                "-webkit-transform:scale(0.2);\n" +
                "-webkit-animation-name:fadeG;\n" +
                "-webkit-animation-duration:1.04s;\n" +
                "-webkit-animation-iteration-count:infinite;\n" +
                "-webkit-animation-direction:linear;\n" +
                "-ms-border-radius:3px 3px 0 0;\n" +
                "-ms-transform:scale(0.2);\n" +
                "-ms-animation-name:fadeG;\n" +
                "-ms-animation-duration:1.04s;\n" +
                "-ms-animation-iteration-count:infinite;\n" +
                "-ms-animation-direction:linear;\n" +
                "-o-border-radius:3px 3px 0 0;\n" +
                "-o-transform:scale(0.2);\n" +
                "-o-animation-name:fadeG;\n" +
                "-o-animation-duration:1.04s;\n" +
                "-o-animation-iteration-count:infinite;\n" +
                "-o-animation-direction:linear;\n" +
                "border-radius:3px 3px 0 0;\n" +
                "transform:scale(0.2);\n" +
                "animation-name:fadeG;\n" +
                "animation-duration:1.04s;\n" +
                "animation-iteration-count:infinite;\n" +
                "animation-direction:linear;\n" +
                "}\n" +
                "\n" +
                "#rotateG_01{\n" +
                "left:0;\n" +
                "top:18px;\n" +
                "-moz-animation-delay:0.39s;\n" +
                "-moz-transform:rotate(-90deg);\n" +
                "-webkit-animation-delay:0.39s;\n" +
                "-webkit-transform:rotate(-90deg);\n" +
                "-ms-animation-delay:0.39s;\n" +
                "-ms-transform:rotate(-90deg);\n" +
                "-o-animation-delay:0.39s;\n" +
                "-o-transform:rotate(-90deg);\n" +
                "animation-delay:0.39s;\n" +
                "transform:rotate(-90deg);\n" +
                "}\n" +
                "\n" +
                "#rotateG_02{\n" +
                "left:5px;\n" +
                "top:6px;\n" +
                "-moz-animation-delay:0.52s;\n" +
                "-moz-transform:rotate(-45deg);\n" +
                "-webkit-animation-delay:0.52s;\n" +
                "-webkit-transform:rotate(-45deg);\n" +
                "-ms-animation-delay:0.52s;\n" +
                "-ms-transform:rotate(-45deg);\n" +
                "-o-animation-delay:0.52s;\n" +
                "-o-transform:rotate(-45deg);\n" +
                "animation-delay:0.52s;\n" +
                "transform:rotate(-45deg);\n" +
                "}\n" +
                "\n" +
                "#rotateG_03{\n" +
                "left:17px;\n" +
                "top:2px;\n" +
                "-moz-animation-delay:0.65s;\n" +
                "-moz-transform:rotate(0deg);\n" +
                "-webkit-animation-delay:0.65s;\n" +
                "-webkit-transform:rotate(0deg);\n" +
                "-ms-animation-delay:0.65s;\n" +
                "-ms-transform:rotate(0deg);\n" +
                "-o-animation-delay:0.65s;\n" +
                "-o-transform:rotate(0deg);\n" +
                "animation-delay:0.65s;\n" +
                "transform:rotate(0deg);\n" +
                "}\n" +
                "\n" +
                "#rotateG_04{\n" +
                "right:5px;\n" +
                "top:6px;\n" +
                "-moz-animation-delay:0.78s;\n" +
                "-moz-transform:rotate(45deg);\n" +
                "-webkit-animation-delay:0.78s;\n" +
                "-webkit-transform:rotate(45deg);\n" +
                "-ms-animation-delay:0.78s;\n" +
                "-ms-transform:rotate(45deg);\n" +
                "-o-animation-delay:0.78s;\n" +
                "-o-transform:rotate(45deg);\n" +
                "animation-delay:0.78s;\n" +
                "transform:rotate(45deg);\n" +
                "}\n" +
                "\n" +
                "#rotateG_05{\n" +
                "right:0;\n" +
                "top:18px;\n" +
                "-moz-animation-delay:0.9099999999999999s;\n" +
                "-moz-transform:rotate(90deg);\n" +
                "-webkit-animation-delay:0.9099999999999999s;\n" +
                "-webkit-transform:rotate(90deg);\n" +
                "-ms-animation-delay:0.9099999999999999s;\n" +
                "-ms-transform:rotate(90deg);\n" +
                "-o-animation-delay:0.9099999999999999s;\n" +
                "-o-transform:rotate(90deg);\n" +
                "animation-delay:0.9099999999999999s;\n" +
                "transform:rotate(90deg);\n" +
                "}\n" +
                "\n" +
                "#rotateG_06{\n" +
                "right:5px;\n" +
                "bottom:5px;\n" +
                "-moz-animation-delay:1.04s;\n" +
                "-moz-transform:rotate(135deg);\n" +
                "-webkit-animation-delay:1.04s;\n" +
                "-webkit-transform:rotate(135deg);\n" +
                "-ms-animation-delay:1.04s;\n" +
                "-ms-transform:rotate(135deg);\n" +
                "-o-animation-delay:1.04s;\n" +
                "-o-transform:rotate(135deg);\n" +
                "animation-delay:1.04s;\n" +
                "transform:rotate(135deg);\n" +
                "}\n" +
                "\n" +
                "#rotateG_07{\n" +
                "bottom:0;\n" +
                "left:17px;\n" +
                "-moz-animation-delay:1.1700000000000002s;\n" +
                "-moz-transform:rotate(180deg);\n" +
                "-webkit-animation-delay:1.1700000000000002s;\n" +
                "-webkit-transform:rotate(180deg);\n" +
                "-ms-animation-delay:1.1700000000000002s;\n" +
                "-ms-transform:rotate(180deg);\n" +
                "-o-animation-delay:1.1700000000000002s;\n" +
                "-o-transform:rotate(180deg);\n" +
                "animation-delay:1.1700000000000002s;\n" +
                "transform:rotate(180deg);\n" +
                "}\n" +
                "\n" +
                "#rotateG_08{\n" +
                "left:5px;\n" +
                "bottom:5px;\n" +
                "-moz-animation-delay:1.3s;\n" +
                "-moz-transform:rotate(-135deg);\n" +
                "-webkit-animation-delay:1.3s;\n" +
                "-webkit-transform:rotate(-135deg);\n" +
                "-ms-animation-delay:1.3s;\n" +
                "-ms-transform:rotate(-135deg);\n" +
                "-o-animation-delay:1.3s;\n" +
                "-o-transform:rotate(-135deg);\n" +
                "animation-delay:1.3s;\n" +
                "transform:rotate(-135deg);\n" +
                "}\n" +
                "\n" +
                "@-moz-keyframes fadeG{\n" +
                "0%{\n" +
                "background-color:#000000}\n" +
                "\n" +
                "100%{\n" +
                "background-color:#FFFFFF}\n" +
                "\n" +
                "}\n" +
                "\n" +
                "@-webkit-keyframes fadeG{\n" +
                "0%{\n" +
                "background-color:#000000}\n" +
                "\n" +
                "100%{\n" +
                "background-color:#FFFFFF}\n" +
                "\n" +
                "}\n" +
                "\n" +
                "@-ms-keyframes fadeG{\n" +
                "0%{\n" +
                "background-color:#000000}\n" +
                "\n" +
                "100%{\n" +
                "background-color:#FFFFFF}\n" +
                "\n" +
                "}\n" +
                "\n" +
                "@-o-keyframes fadeG{\n" +
                "0%{\n" +
                "background-color:#000000}\n" +
                "\n" +
                "100%{\n" +
                "background-color:#FFFFFF}\n" +
                "\n" +
                "}\n" +
                "\n" +
                "@keyframes fadeG{\n" +
                "0%{\n" +
                "background-color:#000000}\n" +
                "\n" +
                "100%{\n" +
                "background-color:#FFFFFF}\n" +
                "\n" +
                "}\n" +
                "\n" +
                "</style>\n" +
                "<div id=\"floatingBarsG\">\n" +
                "<div class=\"blockG\" id=\"rotateG_01\">\n" +
                "</div>\n" +
                "<div class=\"blockG\" id=\"rotateG_02\">\n" +
                "</div>\n" +
                "<div class=\"blockG\" id=\"rotateG_03\">\n" +
                "</div>\n" +
                "<div class=\"blockG\" id=\"rotateG_04\">\n" +
                "</div>\n" +
                "<div class=\"blockG\" id=\"rotateG_05\">\n" +
                "</div>\n" +
                "<div class=\"blockG\" id=\"rotateG_06\">\n" +
                "</div>\n" +
                "<div class=\"blockG\" id=\"rotateG_07\">\n" +
                "</div>\n" +
                "<div class=\"blockG\" id=\"rotateG_08\">\n" +
                "</div>\n" +
                "</div>"
        );

        html.getElement().getStyle().setProperty("scale", "0.5");
    }

}
