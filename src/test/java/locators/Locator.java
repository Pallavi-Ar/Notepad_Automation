package locators;

import org.openqa.selenium.By;

public class Locator {
    public static final By skip = By.id("com.socialnmobile.dictapps.notepad.color.note:id/btn_start_skip");
    public static final By add = By.id("com.socialnmobile.dictapps.notepad.color.note:id/main_btn1");
    public static final By noteType = By.xpath("//*[@text='Text']");
    public static final By editNote = By.id("com.socialnmobile.dictapps.notepad.color.note:id/edit_note");
    public static final By doneButton = By.id("com.socialnmobile.dictapps.notepad.color.note:id/back_btn");
    public static final By backButton = By.id("com.socialnmobile.dictapps.notepad.color.note:id/back_btn");
    public static final By note1 = By.xpath("(//*[@class='android.widget.TextView'])[3]");
    public static final By note2 = By.xpath("(//*[@class='android.widget.TextView'])[5]");
    public static final By note3 = By.xpath("(//*[@class='android.widget.TextView'])[7]");
    public static final By note4 = By.xpath("(//*[@class='android.widget.TextView'])[9]");
    public static final By note5 = By.xpath("(//*[@class='android.widget.TextView'])[11]");

    // RED, ORANGE, YELLOW, BLUE, PURPLE
    public static final By color = By.xpath("//android.widget.LinearLayout[@content-desc=\"Color\"]/android.widget.TextView");
    public static final By color1 = By.id("com.socialnmobile.dictapps.notepad.color.note:id/txt1");
    public static final By color2 = By.id("com.socialnmobile.dictapps.notepad.color.note:id/txt2");
    public static final By color3 = By.id("com.socialnmobile.dictapps.notepad.color.note:id/txt3");
    public static final By color4 = By.id("com.socialnmobile.dictapps.notepad.color.note:id/txt5");
    public static final By color5 = By.id("com.socialnmobile.dictapps.notepad.color.note:id/txt6");
    public static final By menu = By.id("com.socialnmobile.dictapps.notepad.color.note:id/icon_nav");
    public static final By settings = By.xpath("//*[@text='Settings']");
    public static final By day = By.xpath("//*[@text='Monday']");
    public static final By settingsBack = By.xpath("//android.widget.ImageButton[@content-desc=\"Navigate up\"]");
    public static final By searchBtn = By.id("com.socialnmobile.dictapps.notepad.color.note:id/main_btn2");
    public static final By searchField = By.id("com.socialnmobile.dictapps.notepad.color.note:id/edit_search");
    public static final By searched = By.xpath("(//*[@text='How was your day?'])[3]");
    public static final By searchBack = By.id("com.socialnmobile.dictapps.notepad.color.note:id/search_back");
    public static final By deleteBtn = By.xpath("//android.widget.LinearLayout[@content-desc=\"Delete\"]/android.widget.TextView");
    public static final By okBtn = By.id("android:id/button1");
    public static final By trashCan = By.xpath("//*[@text='Trash Can']");
    public static final By notesBtn = By.xpath("//*[@text='Notes']");
    public static final By archiveBtn = By.xpath("//android.widget.LinearLayout[@content-desc=\"Archive\"]/android.widget.TextView");
    public static final By archiveTab = By.xpath("//*[@text='Archive']");
    public static final By archived = By.xpath("(//*[@class='android.widget.TextView'])[5]");
}
