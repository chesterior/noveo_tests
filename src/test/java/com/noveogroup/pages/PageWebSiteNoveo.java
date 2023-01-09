package com.noveogroup.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class PageWebSiteNoveo {
    // Elements & locators

    private final String LOGO_SITE = "Noveo";

    private SelenideElement
            logoSite = $(".main-nav"),
            firstNameInput = $("#edit-name"),
            lastNameInput = $("#edit-surname"),
            companyInput = $("#edit-company"),
            emailInput = $("#edit-email"),
            phoneNumberInput = $("#edit-tel");

    // actions
    public PageWebSiteNoveo openPage() {
        open("https://noveogroup.com/");
        logoSite.shouldHave(text(LOGO_SITE));

        return this;
    }

    public PageWebSiteNoveo typeFirstName(String value) {
        firstNameInput.setValue(value);

        return this;
    }

    public PageWebSiteNoveo typeLastName(String value) {
        lastNameInput.setValue(value);

        return this;
    }

    public PageWebSiteNoveo typeCompany(String value) {
        companyInput.setValue(value);

        return this;
    }

    public PageWebSiteNoveo typeEmail (String value) {
        emailInput.setValue(value);

        return this;
    }

    public PageWebSiteNoveo typePhoneNumber (String value) {
        phoneNumberInput.setValue(value);

        return this;
    }
}
