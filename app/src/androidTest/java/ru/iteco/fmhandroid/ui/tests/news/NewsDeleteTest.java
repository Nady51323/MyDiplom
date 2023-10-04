package ru.iteco.fmhandroid.ui.tests.news;


import androidx.test.espresso.NoMatchingViewException;
import androidx.test.rule.ActivityTestRule;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import io.qameta.allure.kotlin.junit4.DisplayName;
import ru.iteco.fmhandroid.ui.AppActivity;
import ru.iteco.fmhandroid.ui.data.TestData;
import ru.iteco.fmhandroid.ui.steps.AboutAppSteps;
import ru.iteco.fmhandroid.ui.steps.AuthorizationSteps;
import ru.iteco.fmhandroid.ui.steps.ButtonSteps;
import ru.iteco.fmhandroid.ui.steps.NewsCreationSteps;
import ru.iteco.fmhandroid.ui.steps.NewsSteps;

public class NewsDeleteTest {


    @Rule
    public ActivityTestRule<AppActivity> mActivityScenarioRule =
            new ActivityTestRule<>(AppActivity.class);

    String Login = TestData.ValidLogin;
    String Password = TestData.ValidPassword;

    @Before
    public void waitElement() throws InterruptedException {

        try {
            AboutAppSteps.waitIdElementMenu();
        } catch (NoMatchingViewException e) {
            AuthorizationSteps.isAuthorizationScreen();
            AuthorizationSteps.logIn(Login, Password);
        }
    }

    @Test
    @DisplayName("Блок Новости, раздел Панель управления новостями. Удаление новости.")


    public void checkingControlPanelDeleteNews() throws InterruptedException {

        NewsSteps.goToNewsScreen();
        NewsCreationSteps.editNewsButton();
        NewsSteps.selectFirstNewsCard();
        NewsSteps.deleteFirstNewsCard();
        NewsSteps.errorDeleteMessage();
        ButtonSteps.buttonОк();


    }

}
