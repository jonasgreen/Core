package com.jg.core.client.ui;

import com.google.gwt.event.dom.client.*;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.SuggestBox;
import com.google.gwt.user.client.ui.TextBox;

/**
 *
 */
public class SuggestionBoxUi extends FlowPanel {

    private SuggestBox suggestionBox;
    private Label label;

    public SuggestionBoxUi(SuggestBox suggestBox, String emptyText) {
        this.suggestionBox = initSuggestionBox(suggestBox);
        setStyleName("sugBoxUi");
        add(getLabel());
        add(suggestionBox);
        getLabel().setText(emptyText);
    }


    public SuggestBox initSuggestionBox(SuggestBox suggestBox) {
        suggestBox.getValueBox().setStyleName("sugBoxUi_textBox");
        suggestBox.getValueBox().addKeyDownHandler(new KeyDownHandler() {
            public void onKeyDown(KeyDownEvent event) {
                if (isEmpty()) {
                    getLabel().setVisible(false);
                }
            }
        });

        suggestBox.getValueBox().addKeyUpHandler(new KeyUpHandler() {
            public void onKeyUp(KeyUpEvent event) {
                if (isEmpty()) {
                    getLabel().setVisible(true);
                }
            }
        });

        suggestBox.getValueBox().addBlurHandler(new BlurHandler() {
            public void onBlur(BlurEvent event) {
                if (isEmpty()) {
                    getLabel().setVisible(true);
                }
            }
        });

        return suggestBox;
    }

    public boolean isEmpty() {
        return suggestionBox.getValueBox().getText() == null || suggestionBox.getValueBox().getText().equals("");
    }

    public Label getLabel() {
        if (label == null) {
            label = new Label();
            label.setStyleName("sugBoxUi_label");
        }
        return label;
    }

    public void setText(String s) {
        suggestionBox.getValueBox().setText(s);
    }

    public String getText() {
        return suggestionBox.getValueBox().getText();
    }

    public void setEmptyText(String s) {
        getLabel().setText(s);
    }
}
