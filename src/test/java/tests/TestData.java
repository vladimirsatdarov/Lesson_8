package tests;
import com.github.javafaker.Faker;

import java.util.Locale;

public class TestData {
    Faker faker = new Faker(new Locale("de"));
    public String userFirstName = faker.name().firstName(),
            userLastName = faker.name().lastName(),
            userEmail = faker.internet().emailAddress(),
            userGender = faker.options().option("Male", "Female", "Other"),
            userNumber = faker.phoneNumber().subscriberNumber(10),
            userDayOfBirth = Integer.toString(faker.number().numberBetween(1, 28)),
            userMonthOfBirth = String.valueOf(faker.number().numberBetween(0, 11)),
            userMonthOfBirthText = userMonthOfBirthLetters(userMonthOfBirth),
            userYearOfBirth = String.valueOf(faker.number().numberBetween(1900, 2024)),
            userSubjects = faker.options().option("Maths", "Biology", "Physics", "Chemistry"),
            userHobbies = faker.options().option("Sports", "Reading", "Music"),
            userPicture = "img/1.png",
            userCurrentAddress = faker.address().streetAddress(),
            userState = faker.options().option("NCR", "Uttar Pradesh", "Haryana", "Rajasthan"),
            userCity = setCity(userState);


    public String setCity(String userState) {
        switch (userState) {
            case "NCR":
                return faker.options().option("Delhi", "Gurgaon", "Noida");
            case "Uttar Pradesh":
                return faker.options().option("Agra", "Lucknow", "Merrut");
            case "Haryana":
                return faker.options().option("Karnal", "Panipat");
            case "Rajasthan":
                return faker.options().option("Jaipur", "Jaiselmer");
            default:
                return userState;
        }
    }

    public static String userMonthOfBirthLetters(String userDayOfBirth) {
        switch (userDayOfBirth) {
            case "0":
                return "January";
            case "1":
                return "February";
            case "2":
                return "March";
            case "3":
                return "April";
            case "4":
                return "May";
            case "5":
                return "June";
            case "6":
                return "July";
            case "7":
                return "August";
            case "8":
                return "September";
            case "9":
                return "October";
            case "10":
                return "November";
            case "11":
                return "December";
            default:
                return "0";
        }
    }
}