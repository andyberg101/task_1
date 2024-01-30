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
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.List;
import java.util.Map;

import static java.lang.Thread.sleep;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ExampleSteps {
    TestContext context;
    StringBuilder logs;

    public void createNewTask(String title, String summary)  {
        MainPage mp = new MainPage(context);
        mp.newTaskButton.click();
        mp.taskTitleInput.sendKeys(title);
        mp.taskTitleInput.sendKeys(Keys.TAB);
        mp.summaryTaskInput.sendKeys(summary);
        mp.createTaskButton.click();

    }
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

//    @BeforeStep
//    public void beforeEveryStep() {
//        logs.append(context.driver.getCurrentUrl());
//    }

    @Given("user is on the main page")
    public void userOpenMainPage()  {
        MainPage mp = new MainPage(context);
        assertTrue(mp.labelMainPage.isDisplayed());
    }

    @When("create new task")
    public void createSingleTask()  {
        createNewTask("Title", "take the car to a service center");

    }

    @Then("new task is generate")
    public void newTaskIsGenerate() {
        assertEquals("take the car to a service center",
                new MainPage(context)
                        .creatingTask.getText());
    }

    @When("user add 2 tasks on the board")
        public void createTwoTasks() {
        createNewTask("buy tickets", "buy my father tickets to the bulls game");
        createNewTask("Tires", "replace tires on a motorcycle");

    }
    @Then("{int} tasks on the board")
    public void tasksOnTheBoard(Integer amount) {
        assertEquals(amount, new MainPage(context).allTasks.size());

    }

    @When("user delete a task")
    public void userDeleteTask() {
        createTwoTasks();
        new MainPage(context).iconBin.click();

    }

    @Then("left {int} task on the board")
    public void leftTaskOnTheBoard(int amount) {
        assertEquals(amount, new MainPage(context).allTasks.size());
    }

    @When("user delete all tasks")
    public void userDeleteAllTasks(){
        createTwoTasks();
        int amountOfBins = new MainPage(context).allIconBin.size();
        for (int i = 0; i < amountOfBins; i++) {
            new MainPage(context).iconBin.click();
        }
    }

    @Then("the board is empty")
    public void theBoardIsEmpty() {
        assertEquals(0, new MainPage(context).allIconBin.size());
    }

    @When("user create a empty task")
    public void userCreateAEmptyTask() {
        MainPage mp = new MainPage(context);
        mp.newTaskButton.click();
        mp.createTaskButton.click();
    }

    @Then("new task can not generate")
    public void newTaskCanNotGenerate() {
        assertEquals();
    }
}

