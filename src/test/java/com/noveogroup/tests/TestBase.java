package com.noveogroup.tests;

import com.codeborne.selenide.Configuration;
//import guru.qa.pages.RegistrationsPage;
import com.noveogroup.pages.PageWebSiteNoveo;
import org.junit.jupiter.api.BeforeAll;

public class TestBase {

    PageWebSiteNoveo pageWebSiteNoveo = new PageWebSiteNoveo();

    @BeforeAll
    static void beforeAll() {
        Configuration.startMaximized = true;
    }

}
