package com.example.pages;
import com.example.context.TestContext;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class MainPage extends InternalPage {
    @FindBy(css = ".inventory_container")
    public List<WebElement> addToCartButtons;

    @FindBy(css = ".inventory_item")
    public WebElement firstDescriptionContainer;

    @FindBy(css="button[class='btn_primary btn_inventory']")
    public WebElement addToCartFirstProduct;

    public MainPage(TestContext context) {
        super(context);
    }
}
