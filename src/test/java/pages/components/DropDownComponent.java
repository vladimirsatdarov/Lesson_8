package pages.components;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class DropDownComponent {
    public void setDropDown (String art, String name) {
        $(art).click();
        $("#stateCity-wrapper").$(byText(name)).click();
    }
}
