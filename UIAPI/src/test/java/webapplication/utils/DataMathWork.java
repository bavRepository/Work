package webapplication.utils;

import aquality.selenium.elements.interfaces.ITextBox;
import webapplication.model.TestTable;
import java.util.ArrayList;
import java.util.List;

public class DataMathWork {

    public static int intVariantValueCutFromString(String name) {
        return Integer.valueOf(name.substring(name.lastIndexOf(" ") + 1));
    }

    public static String projectIdValueCutFromLink(String link) {
        return link.substring(link.lastIndexOf("=") + 1);
    }

    public static List<String> addDateToList(List<ITextBox> elemList) {
        List<String> dateList = new ArrayList<>();
        for (int i = 0; i < elemList.size(); i++) {
            dateList.add(elemList.get(i).getText());
        }
        return dateList;
    }

    public static boolean isTestObjectsEquals(List<TestTable> apiObjList, List<TestTable> uiObjList) {
        boolean isObjectEqual = true;
        for (TestTable obj : uiObjList) {
            if (!apiObjList.contains(obj)) {
                isObjectEqual = false;
                break;
            }
        }
        return isObjectEqual;
    }
}