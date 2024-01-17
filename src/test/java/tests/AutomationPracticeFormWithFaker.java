package tests;

import org.junit.jupiter.api.Test;
import pages.RegistrationPage;

public class AutomationPracticeFormWithFaker extends TestBase {
    RegistrationPage registrationPage = new RegistrationPage();
    TestData testData = new TestData();
    @Test
    void fillFormTest() {
        registrationPage.openPage()
                .setFirstName(testData.userFirstName)
                .setLastName(testData.userLastName)
                .setEmail(testData.userEmail)
                .setGender(testData.userGender)
                .setUserNumber(testData.userNumber)
                .setDateOfBirth(testData.userDayOfBirth, testData.userMonthOfBirth, testData.userYearOfBirth)
                .setSubjects(testData.userSubjects)
                .setHobbies(testData.userHobbies)
                .uploadPicture(testData.userPicture)
                .setCurrentAddress(testData.userCurrentAddress)
                .setStateAndCity(testData.userState, testData.userCity)
                .clickSubmit()
                .modalDialog("Thanks for submitting the form")
                .checkResult("Student Name", testData.userFirstName + " " + testData.userLastName)
                .checkResult("Student Email", testData.userEmail)
                .checkResult("Gender", testData.userGender)
                .checkResult("Mobile", testData.userNumber)
                .checkResult("Date of Birth", testData.userDayOfBirth + " " + testData.userMonthOfBirthText + "," + testData.userYearOfBirth)
                .checkResult("Subjects", testData.userSubjects)
                .checkResult("Hobbies", testData.userHobbies)
                .checkResult("Address", testData.userCurrentAddress)
                .checkResult("State and City", testData.userState + " " + testData.userCity)
                .closeModalPopUp();
    }
}