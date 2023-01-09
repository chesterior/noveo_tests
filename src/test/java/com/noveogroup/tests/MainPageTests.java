package com.noveogroup.tests;

import io.qameta.allure.Description;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.File;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverRunner.url;
import static io.qameta.allure.Allure.step;
import static org.assertj.core.api.Assertions.assertThat;

public class MainPageTests extends TestBase {

    @Test
    @Description("First test")
    @DisplayName("Logo Noveo should exist")
    void logoShouldBeVisible() {
        step("Open https://noveogroup.com/", () -> {
            pageWebSiteNoveo.openPage();
        });

        step("check logo", () -> {
            $(".logo").shouldBe(visible);
        });
    }

    @Test
    @Description("Second test")
    @DisplayName("Page title should have header text")
    void titleTest() {
        step("Open https://noveogroup.com/", () -> {
            pageWebSiteNoveo.openPage();
        });

        step("Noveo | noveo", () -> {
            String expectedTitle = "Noveo | noveo";
            String actualTitle = title();

            assertThat(actualTitle).isEqualTo(expectedTitle);
        });
    }

    @Test
    @Description("Third test")
    @DisplayName("Contact Us Page")
    void contactUs() {
        step("Open https://noveogroup.com/", () -> {
            pageWebSiteNoveo.openPage();
        });

        step("Click 'Contact Us' button", () -> {
            $(".btn--secondary").click();
        });

        step("https://noveogroup.com/contact_us", () -> {
            String expectedContactUs = "https://noveogroup.com/contact_us";

            assertThat(url()).isEqualTo(expectedContactUs);
        });

    }

    @Test
    @Description("Fourth test")
    @DisplayName("Contact Us filling form")
    void contactUsForm() {
        step("Open https://noveogroup.com/", () -> {
            pageWebSiteNoveo.openPage();
        });

        step("Click 'Contact Us' button", () -> {
            $(".btn--secondary").click();
        });

        step("First Name", () -> {
            pageWebSiteNoveo.typeFirstName("Aleksandr");
        });

        step("Last Name", () -> {
            pageWebSiteNoveo.typeLastName("Safronov");
        });

        step("Company", () -> {
            pageWebSiteNoveo.typeCompany("Docdoc");
        });

        step("Email", () -> {
            pageWebSiteNoveo.typeEmail("chester1.1@mail.ru");
        });

        step("Phone Number", () -> {
            pageWebSiteNoveo.typePhoneNumber("89215625866");
        });

        step("Attach file", () -> {
            $("#edit-attach-file-upload")
                    .uploadFile(new File("src/test/resources/pdf/Resume-Aleksandr-Safronov.pdf"));
        });

        step("Checkbox I accept Terms and Conditions", () -> {
            $(".custom-checkbox").click();
        });

        step("Checkbox I accept Terms and Conditions", () -> {
            $("#edit-actions-submit").shouldBe(visible);
        });
    }
}
