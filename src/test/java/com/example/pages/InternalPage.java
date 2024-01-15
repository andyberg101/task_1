package com.example.pages;
import com.example.context.TestContext;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class InternalPage extends BasePage{
    @FindBy(css = ".login_logo")
    public WebElement logo;

    @FindBy(css = ".footer_copy")
    public WebElement footer;


    InternalPage(TestContext context) {
        super(context);
    }
}
