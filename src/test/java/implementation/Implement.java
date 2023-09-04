package implementation;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.LongPressOptions;
import io.appium.java_client.touch.offset.ElementOption;
import io.appium.java_client.touch.offset.PointOption;
import io.cucumber.java.en_old.Ac;
import locators.Locator;
import notes.NoteData;
import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import static notes.NoteData.note1;
import static notes.NoteData.note5;

public class Implement {
    public static AppiumDriver driver = null;
    public static String deviceName;
    public static String udid;
    public static String platformName;
    public static String appPath;
    static Properties properties = new Properties();
    public static void properties() {
        try (InputStream inputStream = new FileInputStream("C:\\Users\\Pallavi.Arora\\IdeaProjects\\colornoteAssignment\\src\\test\\config.properties")) {
            properties.load(inputStream);
            //getting resources from config.properties file
            deviceName = properties.getProperty("appium.deviceName");
            udid = properties.getProperty("appium.udid");
            platformName = properties.getProperty("appium.platformName");
            appPath = properties.getProperty("appium.app");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void launchApp() throws IOException {
        try {
            //calling properties method
            properties();
            //setting the desired capabilites
            DesiredCapabilities cap = new DesiredCapabilities();
            cap.setCapability("deviceName",deviceName);
            cap.setCapability("udid", udid);
            cap.setCapability("platformName", platformName);
            cap.setCapability("app",appPath);
            //allowing all permissions
            cap.setCapability("autoGrantPermissions","true");

            //getting the hub
            URL url = new URL(properties.getProperty("appium.hub"));

            //setting the driver
            driver = new AndroidDriver(url, cap);
            //adding implicit wait
            driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        screenshot("appOpens.jpg");
        //clicking on skip button
        WebElement skipButton = driver.findElement(Locator.skip);
        skipButton.click();
        screenshot("skipButton.jpg");
    }

    public static void createNotes(String note) {
        try {
            //clicking on add button
            WebElement addButton = driver.findElement(Locator.add);
            addButton.click();
            //adding a note
            WebElement noteType = driver.findElement(Locator.noteType);
            noteType.click();
            WebElement noteField = driver.findElement(Locator.editNote);
            noteField.sendKeys(note);

            screenshot("noteAdded.jpg");

            WebElement done = driver.findElement(Locator.doneButton);
            done.click();
            WebElement back = driver.findElement(Locator.backButton);
            back.click();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void changeColor() {
        try {
            //changing colors of notes
            //note 1 - red
            WebElement note1 = driver.findElement(Locator.note1);
            TouchAction action = new TouchAction(driver);
            action.longPress(PointOption.point(note1.getLocation().x, note1.getLocation().y)).release().perform();
            driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
            WebElement color = driver.findElement(Locator.color);
            color.click();
            WebElement red = driver.findElement(Locator.color1);
            red.click();

            //note 2 - orange
            WebElement note2 = driver.findElement(Locator.note2);
            action.longPress(PointOption.point(note2.getLocation().x, note2.getLocation().y)).release().perform();
            WebElement colorTab = driver.findElement(Locator.color);
            colorTab.click();
            WebElement orange = driver.findElement(Locator.color2);
            orange.click();

            //note 3 - yellow
            WebElement note3 = driver.findElement(Locator.note3);
            action.longPress(PointOption.point(note3.getLocation().x, note3.getLocation().y)).release().perform();
            WebElement colorTab1 = driver.findElement(Locator.color);
            colorTab1.click();
            WebElement yellow = driver.findElement(Locator.color3);
            yellow.click();

            //note 4 - blue
            WebElement note4 = driver.findElement(Locator.note4);
            action.longPress(PointOption.point(note4.getLocation().x, note4.getLocation().y)).release().perform();
            WebElement colorTab2 = driver.findElement(Locator.color);
            colorTab2.click();
            WebElement blue = driver.findElement(Locator.color4);
            blue.click();

            //note 5 - purple
            WebElement note5 = driver.findElement(Locator.note5);
            action.longPress(PointOption.point(note5.getLocation().x, note5.getLocation().y)).release().perform();
            WebElement colorTab3 = driver.findElement(Locator.color);
            colorTab3.click();
            WebElement purple = driver.findElement(Locator.color5);
            purple.click();

            screenshot("colors.jpg");
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void time() {
        //printing time of each note
        WebElement time1 = driver.findElement(Locator.note1);
        System.out.println(time1.getText());
        WebElement time2 = driver.findElement(Locator.note2);
        System.out.println(time2.getText());
        WebElement time3 = driver.findElement(Locator.note3);
        System.out.println(time3.getText());
        WebElement time4 = driver.findElement(Locator.note4);
        System.out.println(time4.getText());
        WebElement time5 = driver.findElement(Locator.note5);
        System.out.println(time5.getText());
    }

    public static void changeDay() {
        try {
            //changing the first day of week to Monday
            WebElement menu = driver.findElement(Locator.menu);
            menu.click();
            WebElement settings = driver.findElement(Locator.settings);
            settings.click();
            WebElement firstDay = driver.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textContains(\"First day of week\").instance(0))"));
            firstDay.click();
            WebElement monday = driver.findElement(Locator.day);
            monday.click();

            screenshot("monday.jpg");
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void verifyDay() {
        //verifying that the day has been changed
        WebElement monday = driver.findElement(Locator.day);
        String day = monday.getText();
        Assert.assertEquals("Monday", day);
    }

    public static void searchNote() {
        try {
            //searching for the third note
            WebElement backBtn = driver.findElement(Locator.settingsBack);
            backBtn.click();
            WebElement sideClick = driver.findElement(Locator.note2);
            sideClick.click();
            WebElement searchBtn = driver.findElement(Locator.searchBtn);
            searchBtn.click();
            WebElement search = driver.findElement(Locator.searchField);
            search.sendKeys(NoteData.note3);

            screenshot("searched.jpg");
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void verifySearch() {
        //verifying the note searched
        WebElement searched = driver.findElement(Locator.searched);
        String searchText = searched.getText();
        Assert.assertEquals(NoteData.note3, searchText);
    }

    public static void deleteNotes() {
        try {
            //deleting second and fourth note
            WebElement searchBack = driver.findElement(Locator.searchBack);
            searchBack.click();
            WebElement note2 = driver.findElement(Locator.note2);
            TouchAction action = new TouchAction(driver);
            action.longPress(PointOption.point(note2.getLocation().x, note2.getLocation().y)).release().perform();
            WebElement delete = driver.findElement(Locator.deleteBtn);
            delete.click();
            WebElement ok = driver.findElement(Locator.okBtn);
            ok.click();
            WebElement note4 = driver.findElement(Locator.note4);
            action.longPress(PointOption.point(note4.getLocation().x,note4.getLocation().y)).release().perform();
            WebElement deleteNote = driver.findElement(Locator.deleteBtn);
            deleteNote.click();
            WebElement okBtn = driver.findElement(Locator.okBtn);
            okBtn.click();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void verifyDelete() {
        try {
            //verifying that the notes have been deleted
            WebElement menu = driver.findElement(Locator.menu);
            menu.click();
            WebElement trash = driver.findElement(Locator.trashCan);
            trash.click();

            screenshot("trashcan.jpg");
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void archiveNote() {
        try {
            //archiving the first note
            WebElement menu = driver.findElement(Locator.menu);
            menu.click();
            WebElement notesTab = driver.findElement(Locator.notesBtn);
            notesTab.click();
            WebElement note1 = driver.findElement(Locator.note1);
            TouchAction action = new TouchAction(driver);
            action.longPress(PointOption.point(note1.getLocation().x,note1.getLocation().y)).release().perform();
            WebElement archive = driver.findElement(Locator.archiveBtn);
            archive.click();
            WebElement ok = driver.findElement(Locator.okBtn);
            ok.click();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void verifyArchive() {
        try {
            //verifying that the first note has been archived
            WebElement menu = driver.findElement(Locator.menu);
            menu.click();
            WebElement archive = driver.findElement(Locator.archiveTab);
            archive.click();
            WebElement archivedNote = driver.findElement(Locator.archived);
            String archivedTitle = archivedNote.getText();
            Assert.assertEquals(note5,archivedTitle);
            screenshot("archive.jpg");
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static void screenshot(String fileName) throws IOException {
        File srcFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(srcFile, new File("C:\\Users\\Pallavi.Arora\\IdeaProjects\\colornoteAssignment\\src\\images\\" + fileName));
    }
}
