package com.kony.automation.serenity.pages;

import com.kony.automation.serenity.utils.DateHelper;
import net.serenitybdd.core.pages.PageObject;
import net.thucydides.core.webdriver.WebDriverFacade;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class BasePage extends PageObject {

    private static final String UI_DATE_FORMAT = "MMMM dd yyyy";
    private static final String DATE_PICKER_FORMAT = "dd/MM/yyyy";
    private String platform;

    @FindBy(name = "Cancel")
    private WebElement cancel;

    @FindBy(id = "button1")
    private WebElement done;

    public BasePage(WebDriver driver) {
        super(driver);
        platform = getPlatformName();
    }

    public String getPlatformName() {
        return ((WebDriverFacade) getDriver()).getCapabilities()
                .getCapability("platformName").toString();
    }

    public void setDatePicker(WebElement element, String date) {
        Date dt = DateHelper.getDateFromString(date);
        element.click();

        if ("Android".equals(platform)) {
            setDatePickerAndroid(element, dt);
        } else if ("iOS".equals(platform)) {
            setDatePickerIOS(element, dt);
        }
    }

    private void setDatePickerIOS(WebElement element, Date date) {
        String[] dateFormatted  = new SimpleDateFormat(UI_DATE_FORMAT, Locale.ENGLISH)
                .format(date).split(" ");
        List<WebElement> pickerWheels = getDriver().findElements(By
                .xpath("//XCUIElementTypePickerWheel"));
        pickerWheels.get(0).sendKeys(dateFormatted[0]);
        pickerWheels.get(1).sendKeys(dateFormatted[1].replaceFirst("^0+(?!$)", ""));
        pickerWheels.get(2).sendKeys(dateFormatted[2]);
        cancel.click();
    }

    private void setDatePickerAndroid(WebElement element, Date date) {
        String[] dateFormatted  = new SimpleDateFormat(UI_DATE_FORMAT, Locale.ENGLISH)
                .format(date).split(" ");
        List<WebElement> numberPicker = getDriver().findElements(By
                .className("android.widget.NumberPicker"));
        selectString(numberPicker.get(0), dateFormatted[0].substring(0, 3));
        selectNumber(numberPicker.get(1), dateFormatted[1]);
        selectNumber(numberPicker.get(2), dateFormatted[2]);
        done.click();
    }

    private void selectString(WebElement numberPicker, String value) {
        WebElement button = numberPicker.findElement(By.className("android.widget.Button"));
        WebElement input = numberPicker.findElement(By.className("android.widget.EditText"));
        int i = 0;
        while (!value.equals(input.getText()) && (i < 100)) {
            button.click();
            i++;
        }
    }

    private void selectNumber(WebElement numberPicker, String value) {
        WebElement input = numberPicker.findElement(By.className("android.widget.EditText"));
        int current = Integer.parseInt(input.getText());
        int target = Integer.parseInt(value);

        int diff = target - current;
        WebElement button = numberPicker.findElements(By.className("android.widget.Button"))
                .get(diff <= 0 ? 0 : 1);

        for (int i = 0; i < Math.abs(diff); i++) {
            button.click();
        }
    }

    protected boolean checkDatePickerValue(WebElement element, Date date) {
        String dt = new SimpleDateFormat(DATE_PICKER_FORMAT).format(date);
        if ("Android".equals(platform)) {
            WebElement text = element.findElement(By.className("android.widget.TextView"));
            return text.getText().equals(dt);
        } else if ("iOS".equals(platform)) {
            return element.getText().equals(dt);
        }
        throw new Error("Platform not supported");
    }
}
