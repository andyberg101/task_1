package com.example.pages;
import com.example.context.TestContext;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class MainPage extends BasePage {
    @FindBy(xpath = "//h1[contains(@class, 'mantine-Title-root')]")
    public WebElement labelMainPage;

    @FindBy(xpath = "//div[contains(@class,'mantine-Button-inner')]")
    public WebElement newTaskButton;

    @FindBy(xpath = "//input[contains(@class,'mantine-TextInput-input')]")
    public WebElement  taskTitleInput;

    @FindBy(xpath = "//input[@placeholder='Task Summary']")
    public WebElement  summaryTaskInput;

    @FindBy(xpath = "//button[contains(@class,'mantine-Button-root mantine-Group')][2]")
    public WebElement  createTaskButton;

    @FindBy(xpath = "//div[2]/div[2]")
    public WebElement  creatingTask;

    @FindBy(xpath = "//div[contains(@class,'mantine-Card-root')]")
    public List<WebElement> allTasks;

    @FindBy(xpath = "//button[contains(@class,'mantine-ActionIcon-transparent')]")
    public WebElement iconBin;

    @FindBy(xpath = "//button[contains(@class,'mantine-ActionIcon-transparent')]")
    public List<WebElement> allIconBin;


    public MainPage(TestContext context) {
        super(context);
    }
}
