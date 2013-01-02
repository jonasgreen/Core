package com.jg.core.client.model;

import java.util.List;

/**
 *
 */
public class StartItem extends SetItem{


    @Override
    public SetItem next(int key, List<SetItem> items, int index) {
        if(isDigit(key)){
            return new NumberItem(true);
        }
        return null;
    }


    @Override
    public String getStringForReplace() {
        return null;
    }


    @Override
    public boolean isNextItemValid(SetItem next) {
        return next instanceof NumberItem;
    }


    @Override
    public String toString() {
        return "StartItem";
    }


}
