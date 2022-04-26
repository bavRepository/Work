package com.internet.herokuapp.page;

import com.internet.herokuapp.page.uniqelement.DivElement;
import com.internet.herokuapp.page.uniqelement.HeadingElement;
import com.internet.herokuapp.page.uniqelement.ImageElement;
import com.internet.herokuapp.page.uniqelement.LinkElement;
import com.internet.herokuapp.page.wrapper.BaseForm;
import org.openqa.selenium.By;
import util.DataMathWork;

public class HoversPage extends BaseForm {

    private static final String XPATH_TO_HEADING_USER_NAME = "//h5[contains(text(), 'name: user%s')]";
    private static final String XPATH_TO_USER_LINK = "//a[contains(@href, '/users/%s')]";
    private static final String XPATH_TO_USER_IMG = "//img[..//h5[text()='name: user%s']]";
    private static final String XPATH_TO_USER_DIV_DISPLAY_NONE = "//div[@class='figcaption' and ./h5[text()='name: user%s']]";

    public HoversPage() {
        super(new ImageElement(By.xpath("//img[@alt='Fork me on GitHub']"),
                "Img logo"), "Hovers page");
    }

    public void moveToUserImg(String userNum){
        ImageElement userImg = new ImageElement(By.xpath(String.format(XPATH_TO_USER_IMG, userNum)), String.format("img user%s",  userNum));
        userImg.waitForPresenceOfElementLocated();
        userImg.moveToElement();
    }
    public void waitForUserDivDisplayed(String userNum){
        DivElement userDivDisplayNone = new DivElement(By.xpath(String.format(XPATH_TO_USER_DIV_DISPLAY_NONE, userNum)), String.format("Div invisible wrapper user%s", userNum));
        userDivDisplayNone.waitForElementVisibilityAndLocated();
    }
    public String userCompareName(String userNum) {
        HeadingElement headingUserName = new HeadingElement(By.xpath(String.format(XPATH_TO_HEADING_USER_NAME, userNum)), String.format("H5 user%s", userNum));
        return DataMathWork.userNameCut(headingUserName.getAttribute("innerHTML"));
    }
    public boolean isUserLinkDisplayed(String userNum) {
        LinkElement userLink = new LinkElement(By.xpath(String.format(XPATH_TO_USER_LINK, userNum)), String.format("Link user%s",  userNum));
        return userLink.isDisplayed();
    }
    public String getUserLinkHref(String userNum) {
        LinkElement userLink = new LinkElement(By.xpath(String.format(XPATH_TO_USER_LINK, userNum)), String.format("Link user%s",  userNum));
        return userLink.getAttribute("href");
    }
    public void clickUserProfileLink(String userNum) {
        LinkElement userLink = new LinkElement(By.xpath(String.format(XPATH_TO_USER_LINK, userNum)), String.format("Link user%s",  userNum));
        userLink.click();
    }
}
