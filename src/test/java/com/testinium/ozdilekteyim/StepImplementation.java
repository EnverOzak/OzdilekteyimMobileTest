package com.testinium.ozdilekteyim;

import com.thoughtworks.gauge.Step;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.By;
import com.testinium.ozdilekteyim.backend.BackEnd;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class StepImplementation extends BaseTest {

    Logger logger = LogManager.getLogger(StepImplementation.class);

    @Step("Manage Wait")
    public void testManageWait(){
        appiumDriver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    }

    @Step("Click on element <key> by id in <page>")
    public void ClickById(String key,String pageObject) throws IOException {
        appiumDriver.findElement(By.id(BackEnd.findMobileElementByKey(key,pageObject))).click();
        logger.info("clicked on " + key);
    }

    @Step("Click on element <key> by xpath in <page>")
    public void ClickByXpath(String key,String pageObject) throws IOException {
        appiumDriver.findElement(By.xpath(BackEnd.findMobileElementByKey(key,pageObject))).click();
        logger.info("clicked on " + key);
    }

    @Step("Wait <number> seconds")
    public void waitForSeceond(int number) throws InterruptedException {
        Thread.sleep(number * 1000L);
    }

    @Step("Check if <key> is visible by id in <page> and print <text>")
    public void CheckIfDisplayedById(String key, String pageObject, String text) {
        try {
            appiumDriver.findElement(By.id(BackEnd.findMobileElementByKey(key, pageObject))).isSelected();
            logger.info(text);
        } catch (Exception e) {
            logger.info(e);
        }
    }

    @Step("Swipe <num> times")
    public void Swipe(Integer num){
        while (num > 0)
        {
            TouchAction<?> action = new TouchAction<>(appiumDriver);
            action.press(PointOption.point(540, 1900))
                    .moveTo(PointOption.point(540, -1900))
                    .release()
                    .perform();
            num = num - 1;
            logger.info("swiped");
        }
    }
}
