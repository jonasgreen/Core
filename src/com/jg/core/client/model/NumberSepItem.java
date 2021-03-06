package com.jg.core.client.model;

import java.util.List;

/**
 *
 */
public class NumberSepItem extends SetItem{

    public static final String SEP_VALUE = "-";
    @Override
    public SetItem next(int key, List<SetItem> items, int index) {
         if(isDigit(key)){
             return new NumberItem(false);
         }
         return null;
    }


    @Override
    public String getStringForReplace() {
        return SEP_VALUE;
    }


    @Override
    public boolean isNextItemValid(SetItem next) {
        return next instanceof NumberItem && !((NumberItem) next).isHome();
    }


    @Override
    public String toString() {
        return "NumberSepItem";
    }

}
