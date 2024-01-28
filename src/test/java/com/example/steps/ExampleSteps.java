package com.example.steps;

import com.example.context.TestContext;
//import com.example.pages.LoginPage;
import com.example.pages.MainPage;
import com.example.utils.ConfigurationReader;
import com.example.utils.DriverFactory;
import io.cucumber.java.*;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.qameta.allure.Allure;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.List;
import java.util.Map;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ExampleSteps {
    TestContext context;
    StringBuilder logs;

    @Before
    public void beforeMethod() {
        context = new TestContext();
        context.driver = DriverFactory.get();
        context.wait = new WebDriverWait(context.driver, Duration.ofSeconds(Long.parseLong(ConfigurationReader.get("timeout"))));
        context.actions = new Actions(context.driver);
        context.js = (JavascriptExecutor) context.driver;
        context.driver.get(ConfigurationReader.get("base_url"));
        logs = new StringBuilder();
    }

    @After
    public void afterMethod() {
        Allure.addAttachment("Console log: ", String.valueOf(logs));
        if (context.driver != null) {
            context.driver.quit();
        }
    }

    @BeforeStep
    public void beforeEveryStep() {
        logs.append(context.driver.getCurrentUrl());
    }

    @Given("user is on the main page")
    public void userOpenMainPage() {
        MainPage mp = new MainPage(context);
        assertTrue(mp.titleTask.isDisplayed());
    }

    @When("user click new task button")
    public void clicks_NewTasks_button() {
        MainPage mp = new MainPage(context);
        mp.newTasksButton.click();
    }

    @And("create new task")
    public void createNewTask() {
        MainPage mp = new MainPage(context);
        mp.taskTitleInput.sendKeys("car repairs");
        mp.taskTitleInput.sendKeys(Keys.TAB);
        mp.summaryTaskInput.sendKeys("take the car to a service center");
    }

//    @Then("new task is generate")
//    public void newTaskIsGenerate() {
//        assertEquals("take the car to a service center",
//                new MainPage(context)
//                        .creatingTask.getText());
//    }
    @Then("new task is generate")
    public void expectedText(String expectedText) {
        String actualText = new MainPage(context).creatingTask.getText();
        logs.append(String.format("actualText: %s", actualText));
        assertTrue(actualText.contains(expectedText));
    }
}

