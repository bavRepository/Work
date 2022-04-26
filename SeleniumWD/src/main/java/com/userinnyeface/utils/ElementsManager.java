package com.userinnyeface.utils;

import aquality.selenium.core.logging.Logger;
import aquality.selenium.elements.interfaces.IButton;
import aquality.selenium.elements.interfaces.ICheckBox;

import java.util.List;

public class ElementsManager {

    private static int index;

    public static void selectCheckBoxElements(List<ICheckBox> list, int count){
        Logger.getInstance().info("Select " + count +" elements");
        for(int i = 0; i < count; i ++){
            index =  0 + (int) (Math.random() * list.size() - 1);
            if(list.get(index).isChecked()) {
                i--;
                continue;
            }
            list.get(index).click();
        }
    }

    public static void clickRandomButton(List<IButton> list){
        Logger.getInstance().info("Get elements from drop list");
        index =  0 + (int) (Math.random() * list.size() - 1);
        list.get(index).click();
    }
}