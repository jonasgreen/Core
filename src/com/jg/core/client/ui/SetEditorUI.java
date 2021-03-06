package com.jg.core.client.ui;

import com.google.gwt.dom.client.Style;
import com.google.gwt.event.dom.client.*;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.TextBox;
import com.jg.core.client.model.*;
import com.jg.core.client.style.StyleIt;
import com.jg.core.client.style.TextLayout;
import com.jg.core.client.style.Vertical;
import com.jg.core.client.util.KeyUtil;

import java.util.ArrayList;
import java.util.List;

/**
 *
 */
public class SetEditorUI extends FlowPanel {
    private SetEditorState.State state = SetEditorState.State.unknown;

    private List<SetEditorListener> listeners = new ArrayList<SetEditorListener>();
    private TextBoxUi textComponent;
    private List<SetItem> items = new ArrayList<SetItem>();



    public SetEditorUI() {
        super();
        items.add(new StartItem());
        add(getTextBox());
    }



    public void addListener(SetEditorListener l) {
        listeners.add(l);
    }

    public void setFocus(boolean b) {
        textComponent.getTextBox().setFocus(true);
    }

    public void load(Result r) {
        reset();
        if (r == null) {
            return;
        }
        List<Integer> scoresHome = r.getScoresHome();
        List<Integer> scoresOut = r.getScoresOut();

        StringBuffer sb = new StringBuffer();
        int index = 0;
        for (Integer home : scoresHome) {
            if (index > 0) {
                items.add(new SetSepItem());
                sb.append(SetSepItem.SEP_VALUE);
            }
            items.addAll(getNumberItems(true, home));
            sb.append(home);

            items.add(new NumberSepItem());
            sb.append(NumberSepItem.SEP_VALUE);

            items.addAll(getNumberItems(false, scoresOut.get(index)));
            sb.append(scoresOut.get(index));
            index++;
        }
        textComponent.setText(sb.toString());
        textComponent.getTextBox().setFocus(true);

    }

    private List<NumberItem> getNumberItems(boolean isHome, Integer value) {
        String s = String.valueOf(value);
        List<NumberItem> list = new ArrayList<NumberItem>();

        int index = 0;
        while (index < s.length()) {
            list.add(new NumberItem(isHome));
            index++;
        }

        return list;

    }


    public void reset() {
        textComponent.setText("");
    }


    public TextBoxUi getTextBox() {
        if (textComponent == null) {
            textComponent = new TextBoxUi();
            textComponent.setEmptyText("Result");
            textComponent.getTextBox().addKeyDownHandler(new KeyDownHandler() {
                public void onKeyDown(KeyDownEvent event) {
                    keyPressed(event);
                }
            });


            textComponent.getTextBox().addKeyUpHandler(new KeyUpHandler() {
                public void onKeyUp(KeyUpEvent event) {
                    if (event.getNativeKeyCode() == KeyCodes.KEY_TAB) {
                        getTextBox().getTextBox().setSelectionRange(0, 0);

                        return;
                    }
                    if (KeyUtil.isArrow(event.getNativeKeyCode())) {
                        return;
                    }
                    if (items.size() != textComponent.getTextBox().getText().length() + 1) {
                        removeDoubleSpaces();
                        rebuild();
                    }
                    changesMade();
                }
            });

        }
        return textComponent;
    }

    private void removeDoubleSpaces() {
        int index = 0;
        StringBuffer sb = new StringBuffer();
        String text = textComponent.getTextBox().getText().trim();
        boolean dontAddNextIfSpace = false;
        while (index < text.length()) {
            char c = text.charAt(index++);
            if (c == ' ') {
                if (dontAddNextIfSpace) {
                    //ignore
                }
                else {
                    sb.append(c);
                    dontAddNextIfSpace = true;
                }
            }
            else {
                sb.append(c);
                dontAddNextIfSpace = false;
            }
        }
        textComponent.setText(sb.toString());
    }

    private void rebuild() {
        items = new ArrayList<SetItem>();
        items.add(new StartItem());

        String text = textComponent.getText();
        int index = 0;
        boolean isHome = true;
        SetItem lastItem;
        while (index < text.length()) {
            char c = text.charAt(index++);
            if (c == ' ') {
                items.add(new SetSepItem());
                isHome = true;

            }
            else if (c == '-') {
                items.add(new NumberSepItem());
                isHome = false;
            }
            else {
                items.add(new NumberItem(isHome));
            }
        }

    }

    private void keyPressed(KeyDownEvent event) {
        if (getTextBox().getText().startsWith("E")) {
            getTextBox().setText("");
            getTextBox().getElement().getStyle().setFontStyle(Style.FontStyle.NORMAL);
            getTextBox().getElement().getStyle().setColor("rgb(51,51,51)");
        }
        int cursorPos = getTextBox().getTextBox().getCursorPos();
        int key = event.getNativeKeyCode();

        //prevent selection
        if (textComponent.getTextBox().getSelectionLength() > 0) {
            return;
        }

        if (KeyUtil.isTab(key)) {
            return;
        }

        if (KeyUtil.isArrow(key)) {
            return;
        }
        if (KeyUtil.isBackSpace(key)) {
            handleBackspace(cursorPos);
            return;
        }
        if (KeyUtil.isDelete(key)) {
            handleDelete(cursorPos);
            return;
        }

        SetItem setItem = items.get(cursorPos);
        SetItem next = setItem.next(key, items, cursorPos);

        if (next == null) {
            event.preventDefault();
        }
        else {
            items.add(cursorPos + 1, next);
            String replaceStr = next.getStringForReplace();
            if (replaceStr != null) {
                event.preventDefault();
                String text = textComponent.getText();
                textComponent.setText(text.substring(0, cursorPos) + replaceStr + text.substring(cursorPos));
            }
        }
    }


    private void handleDelete(int cursorPos) {
        removeItem(cursorPos + 1);
    }


    private void handleBackspace(int cursorPos) {
        removeItem(cursorPos);
    }

    private void removeItem(int cursorPos) {
        if (cursorPos == 0 || cursorPos == items.size()) {
            return;
        }
        SetItem removed = items.remove(cursorPos);
        if (removed instanceof NumberSepItem) {
            convertRestToHomeResult(cursorPos);
        }
        if (removed instanceof SetSepItem) {
            convertRestToOutResult(cursorPos);

        }
    }

    private void convertRestToHomeResult(int index) {
        if (index == items.size()) {
            return;
        }
        SetItem item = items.get(index++);
        while (item instanceof NumberItem) {
            NumberItem ni = (NumberItem) item;
            if (ni.isHome()) {
                return;
            }
            ni.setHome(true);
            if (index == items.size()) {
                return;
            }
            item = items.get(index++);
        }
    }

    private void convertRestToOutResult(int index) {
        if (index == items.size()) {
            return;
        }
        SetItem item = items.get(index++);
        while (item instanceof NumberItem) {
            NumberItem ni = (NumberItem) item;
            if (!ni.isHome()) {
                return;
            }
            ni.setHome(false);
            if (index == items.size()) {
                return;
            }
            item = items.get(index++);
        }
    }


    private void changesMade() {
        SetEditorState.State newState = calculateNewState();
        if (newState != state) {
            SetEditorListener.SetEditorEvent event = new SetEditorListener.SetEditorEvent(newState, state);
            this.state = newState;
            for (SetEditorListener listener : listeners) {
                listener.onChange(event);
            }
        }
    }

    private SetEditorState.State calculateNewState() {
        SetEditorState setEditorState = new SetEditorState(textComponent.getText(), items);
        return setEditorState.getState();

    }

    public SetEditorState.State getState() {
        return state;
    }

    public Result getResult() {

        if (state == SetEditorState.State.reset || state == SetEditorState.State.unknown) {
            return null;
        }

        List<Integer> homeResult = new ArrayList<Integer>();
        List<Integer> outResult = new ArrayList<Integer>();
        String text = textComponent.getText();
        int index = 0;
        StringBuffer sb = new StringBuffer();
        boolean home = true;
        while (index < text.length()) {
            char c = text.charAt(index++);
            if (Character.isDigit(c)) {
                sb.append(c);
            }
            else {
                if (sb.length() != 0) {
                    Integer value = Integer.valueOf(sb.toString());
                    if (home) {
                        homeResult.add(value);
                        home = false;
                    }
                    else {
                        outResult.add(Integer.valueOf(sb.toString()));
                        home = true;
                    }

                    sb = new StringBuffer();
                }
            }
        }
        //in case out has not been emptied
        if (sb.length() != 0) {
            outResult.add(Integer.valueOf(sb.toString()));
        }
        return Result.newInstance(homeResult, outResult);
    }
}
