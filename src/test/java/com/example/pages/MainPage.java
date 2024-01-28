package com.example.pages;
import com.example.context.TestContext;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class MainPage extends BasePage {
    @FindBy(css = "h1[class='mantine-Title-root mantine-Group-child mantine-ozp7z9']")
    public WebElement titleTask;

    @FindBy(css = "button[type='button']")
    public WebElement newTasksButton;

    @FindBy(css = "#mantine-f38s9a9bs-title")
    public WebElement newTasksTable;

    @FindBy(css = "#mantine-pfj9p2a6x")
    public WebElement  taskTitleInput;

    @FindBy(css = "#mantine-hmuvdpwi6")
    public WebElement  summaryTaskInput;

    @FindBy(css = ".mantine-Text-root mantine-1htc9ja")
    public WebElement  creatingTask;


    public MainPage(TestContext context) {
        super(context);
    }
}
