package util;

import org.openqa.selenium.Alert;
import org.openqa.selenium.NoAlertPresentException;

public abstract class AlertManager {

    private static Alert alert = Wait.alertIsPresentWait();

    public static void enterRandomText(){
        Log.infoLogger("Enter random text in modal window");
        alert.sendKeys(String.valueOf(DataMathWork.getRandomValue()));
    }

    public static String getModalWindowText() {
        Log.infoLogger("Get modal window text");
        return alert.getText();
    }

    public static void clickOk() {
        Log.infoLogger("Click Ok on the open modal window");
        alert.accept();
    }

    public static boolean isModalWindowClosed() {
        try {
            Log.infoLogger("Check if modal Window is closed");
            BrowserManager.getDriver().switchTo().alert();
            return false;
        } catch (NoAlertPresentException e) {
            return true;
        }
    }
}
