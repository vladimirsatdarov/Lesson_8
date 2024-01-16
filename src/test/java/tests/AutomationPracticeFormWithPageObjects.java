package tests;

import org.junit.jupiter.api.Test;
import pages.RegistrationPage;

public class AutomationPracticeFormWithPageObjects extends TestBase {
    RegistrationPage registrationPage = new RegistrationPage();
    @Test
    void fillFormTest() {
        String userName = "Oleg";
        registrationPage.openPage()
                .setFirstName(userName)
                .setLastName("Olegov")
                .setEmail("oleg@olegov.ru")
                .setGender("Female")
                .setUserNumber("1234567890")
                .setDateOfBirth("30", "6", "2008")
                .setSubjects("Maths")
                .setHobbies("Music")
                .uploadPicture("img/1.png")
                .setCurrentAddress("Some Str. 1")
                .setStateAndCity("NCR", "Delhi")
                .clickSubmit()
                .modalDialog("Thanks for submitting the form")
                .checkResult("Student Name", "Oleg Olegov")
                .checkResult("Student Email", "oleg@olegov.ru")
                .checkResult("Gender", "Female")
                .checkResult("Mobile", "1234567890")
                .checkResult("Date of Birth", "30 July,2008")
                .checkResult("Subjects", "Maths")
                .checkResult("Hobbies", "Music")
                .checkResult("Address", "Some Str. 1")
                .checkResult("State and City", "NCR Delhi")
                .closeModalPopUp();
    }
    @Test
    void minimumRegistration() {
        String userName = "Oleg";
        registrationPage.openPage()
                .setFirstName(userName)
                .setLastName("Olegov")
                .setGender("Female")
                .setUserNumber("1234567890")
                .clickSubmit()
                .modalDialog("Thanks for submitting the form")
                .checkResult("Student Name", "Oleg Olegov")
                .checkResult("Gender", "Female")
                .checkResult("Mobile", "1234567890")
                .closeModalPopUp();
    }

    @Test
    void failedRegistration() {
        registrationPage.openPage()
                .clickSubmit()
                .noModalDialog();
    }
}