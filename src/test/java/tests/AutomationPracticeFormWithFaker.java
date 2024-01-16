package tests;

import org.junit.jupiter.api.Test;
import pages.RegistrationPage;

import static tests.TestData.*;

public class AutomationPracticeFormWithFaker extends TestBase {
    RegistrationPage registrationPage = new RegistrationPage();
    @Test
    void fillFormTest() {
        registrationPage.openPage()
                .setFirstName(userFirstName)
                .setLastName(userLastName)
                .setEmail(userEmail)
                .setGender(userGender)
                .setUserNumber(userNumber)
                .setDateOfBirth(userDayOfBirth, userMonthOfBirth, userYearOfBirth)
                .setSubjects(userSubjects)
                .setHobbies(userHobbies)
                .uploadPicture(userPicture)
                .setCurrentAddress(userCurrentAddress)
                .setStateAndCity(userState, userCity)
                .clickSubmit()
                .modalDialog("Thanks for submitting the form")
                .checkResult("Student Name", userFirstName + " " + userLastName)
                .checkResult("Student Email", userEmail)
                .checkResult("Gender", userGender)
                .checkResult("Mobile", userNumber)
                .checkResult("Date of Birth", userDayOfBirth + " " + userMonthOfBirthText + "," + userYearOfBirth)
                .checkResult("Subjects", userSubjects)
                .checkResult("Hobbies", userHobbies)
                .checkResult("Address", userCurrentAddress)
                .checkResult("State and City", userState + " " + userCity)
                .closeModalPopUp();
    }
}