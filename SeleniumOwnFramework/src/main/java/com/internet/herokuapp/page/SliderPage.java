package com.internet.herokuapp.page;

import com.internet.herokuapp.page.uniqelement.ImageElement;
import com.internet.herokuapp.page.uniqelement.InputElement;
import com.internet.herokuapp.page.uniqelement.SpanElement;
import com.internet.herokuapp.page.wrapper.BaseForm;
import org.openqa.selenium.By;

public class SliderPage extends BaseForm {

    private InputElement sliderInput = new InputElement(By.xpath("//input[@type='range']"), "Input slider element");
    private SpanElement resultValueSpan = new SpanElement(By.xpath("//span[@id='range']"), "Span result value");

    public SliderPage() {
        super(new ImageElement(By.xpath("//img[@alt='Fork me on GitHub']"),
                "Img logo"), "slider page");
    }

    public void randomSliderDragAndDropAction() {
        sliderInput.waitForPresenceOfElementLocated();
        sliderInput.dragAndDropSlider();
    }

    public String getDragAndDropSpanValue() {
        return resultValueSpan.getText();
    }
}
