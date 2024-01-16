package tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.File;

import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.files.DownloadActions.click;

public class AutomationPracticeForm {

    @BeforeAll
    static void beforeAll() {
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = "1519x800";
        Configuration.pageLoadStrategy = "eager";
        Configuration.holdBrowserOpen = true;
    }

    @Test
    void fillFormTest() {
        String userName = "Oleg";

        open("/automation-practice-form");

        executeJavaScript("$('footer').remove()");
        executeJavaScript("$('#fixedban').remove()");

        $("#firstName").setValue("Oleg");
        $("#lastName").setValue("Olegov");
        $("#userEmail").setValue("oleg@olegov.ru");

        $("#genterWrapper").$(byText("Female")).click(); // best option
//        $("#gender-radio-2").parent().click(); // also should work

        $("#userNumber").setValue("1234567890");

        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").$(byText("May"));
        $(".react-datepicker__year-select").$(byText("1999"));
        $(".react-datepicker__day--030:not(react-datepicker__day--outside-month)").click();



        $("#subjectsInput").setValue("Maths").pressEnter();
        $("#hobbiesWrapper").$(byText("Music")).click();


//        $("#uploadPicture").uploadFile(new File("src/test/resources/img/1.png")); // full path
        $("#uploadPicture").uploadFromClasspath("img/1.png"); // if file is in the resources folder

        $("#currentAddress").setValue("Some Str. 1");

        $("#state").click();
        $("#stateCity-wrapper").$(byText("NCR")).click();
        $("#city").click();
        $("#stateCity-wrapper").$(byText("Delhi")).click();

        $("#submit").click();

        $(".modal-dialog").should(appear);
        $("#example-modal-sizes-title-lg").shouldHave(text("Thanks for submitting the form"));
        $(".table-responsive").shouldHave(text(userName), text("Olegov"), text("oleg@olegov.ru"));
    }
}
