package tests;
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

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
        open("/automation-practice-form");
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove");
        $("#firstName").setValue("Ksenia");
        $("#lastName").setValue("Mitrofanova");
        $("#userEmail").setValue("KMitrofanova@mail.ru");
        $("#userNumber").setValue("8999123456");
        $("[for='gender-radio-2']").click();
        //$("#subjectsContainer").setValue("Russia");
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOption("June");
        $(".react-datepicker__year-select").selectOption("1997");
        $(".react-datepicker__day--003").click();
        $("#subjectsInput").val("Computer Science").pressEnter();
        $("[for='hobbies-checkbox-1']").click();
        $("[for='hobbies-checkbox-2']").click();
        $("[for='hobbies-checkbox-3']").click();
        $("#uploadPicture").uploadFromClasspath("QA.jpeg");
        $("#currentAddress").setValue("Penza, Central street 132");
        $("#react-select-3-input").val("NCR").pressEnter();
        $("#react-select-4-input").val("Noida").pressEnter();
        $("#submit").pressEnter();

        $(".table-responsive").shouldHave(text("Ksenia Mitrofanova"));
        $(".table-responsive").shouldHave(text("KMitrofanova@mail.ru"));
        $(".table-responsive").shouldHave(text("Female"));
        $(".table-responsive").shouldHave(text("8999123456"));
        $(".table-responsive").shouldHave(text("3 June,1997"));
        $(".table-responsive").shouldHave(text("Computer Science"));
        $(".table-responsive").shouldHave(text("Sports, Reading, Music"));
        $(".table-responsive").shouldHave(text("QA.jpeg"));
        $(".table-responsive").shouldHave(text("Penza, Central street 132"));
        $(".table-responsive").shouldHave(text("NCR Noida"));
    }

}