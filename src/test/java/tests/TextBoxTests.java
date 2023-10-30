package tests;
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class TextBoxTests {

    @BeforeAll
    static void beforeAll(){
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.pageLoadStrategy = "eager";
        Configuration.holdBrowserOpen = true;
        Configuration.timeout = 5000;
    }



    @Test

    void fillFormTest() {
        open("/text-box");
        $("#userName").setValue("Ksenia");
        $("#userEmail").setValue("Ksenia@mail.ru");
        $("#currentAddress").setValue("Street 19");
        $("#permanentAddress").setValue("Another Streen 19");
        $("#submit").click();

       $("#output").$("#name").shouldHave(text("Ksenia"));
       $("#output").$("#email").shouldHave(text("Ksenia@mail.ru"));
       $("#output").$("#currentAddress").shouldHave(text("Street 19"));
       $("#output").$("#permanentAddress").shouldHave(text("Another Streen 19"));

    }

}