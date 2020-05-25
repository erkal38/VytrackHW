package com.vytrack.pages;

import com.vytrack.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class CalendarEventsPage extends BasePage{
    public CalendarEventsPage() {
        PageFactory.initElements(Driver.get(), this);

    }

    @FindBy(xpath = "//div[@class='btn btn-link dropdown-toggle']")
    public WebElement calendarPageSubtitle;
    @FindBy(xpath = "//input[@class='input-widget']")
    public WebElement pageNumber;
    @FindBy(xpath = "(//a[@class='dropdown-item'])[2]")
    public WebElement viewPerPage;
}