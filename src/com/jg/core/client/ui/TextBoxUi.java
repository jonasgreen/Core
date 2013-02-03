package com.jg.core.client.ui;

import com.google.gwt.dom.client.Style;
import com.google.gwt.event.dom.client.*;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.TextBox;

/**
 *
 */
public class TextBoxUi extends FlowPanel{

    private TextBox textBox;
    private Label label;

    public TextBoxUi(String emptyText){
        setStyleName("textBoxUi");
        add(getLabel());
        add(getTextBox());
        getLabel().setText(emptyText);
    }

    public TextBoxUi() {
        this("");
    }


    public TextBox getTextBox() {
        if (textBox == null) {
            textBox = new TextBox();
            textBox.setStyleName("textBoxUi_textBox");
            textBox.addKeyDownHandler(new KeyDownHandler() {
                public void onKeyDown(KeyDownEvent event) {
                    if(isEmpty()){
                        getLabel().setVisible(false);
                    }
                }
            });

            textBox.addKeyUpHandler(new KeyUpHandler() {
                public void onKeyUp(KeyUpEvent event) {
                    if(isEmpty()){
                        getLabel().setVisible(true);
                    }
                }
            });

            textBox.addBlurHandler(new BlurHandler() {
                public void onBlur(BlurEvent event) {
                    if(isEmpty()){
                        getLabel().setVisible(true);
                    }
                }
            });
        }
        return textBox;
    }

    public boolean isEmpty(){
        return getTextBox().getText() == null || getTextBox().getText().equals("");
    }

    public Label getLabel() {
        if (label == null) {
            label = new Label();
            label.setStyleName("textBoxUi_label");
        }
        return label;
    }

    public void setText(String s) {
        getTextBox().setText(s);
    }

    public String getText(){
        return getTextBox().getText();
    }

    public void setEmptyText(String s) {
        getLabel().setText(s);
    }
}
