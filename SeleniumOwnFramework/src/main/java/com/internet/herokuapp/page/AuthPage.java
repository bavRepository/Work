package com.internet.herokuapp.page;

    import com.internet.herokuapp.page.uniqelement.ImageElement;
    import com.internet.herokuapp.page.uniqelement.ParagraphElement;
    import com.internet.herokuapp.page.wrapper.BaseForm;
    import org.openqa.selenium.By;

    public class AuthPage extends BaseForm {

        private ParagraphElement checkResultParagraph = new ParagraphElement(By.xpath("//div[@class='example']//p"), "Paragraph of result text checking");

        public AuthPage() {
            super(new ImageElement(By.xpath("//img[@alt='Fork me on GitHub']"), "Img logo"), "basic_auth page");
        }

        public String getResultText() {
            checkResultParagraph.waitForPresenceOfElementLocated();
            return checkResultParagraph.getText();
        }

    }

