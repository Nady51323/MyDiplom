package ru.iteco.fmhandroid.ui.tests.news;


import static androidx.test.espresso.action.ViewActions.replaceText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

import androidx.test.espresso.NoMatchingViewException;
import androidx.test.filters.LargeTest;
import androidx.test.rule.ActivityTestRule;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import io.qameta.allure.android.runners.AllureAndroidJUnit4;
import io.qameta.allure.kotlin.Description;
import io.qameta.allure.kotlin.junit4.DisplayName;
import ru.iteco.fmhandroid.ui.AppActivity;
import ru.iteco.fmhandroid.ui.data.DataHelper;
import ru.iteco.fmhandroid.ui.screenElements.NewsScreen;
import ru.iteco.fmhandroid.ui.steps.AboutAppSteps;
import ru.iteco.fmhandroid.ui.steps.AuthorizationSteps;
import ru.iteco.fmhandroid.ui.steps.ButtonSteps;
import ru.iteco.fmhandroid.ui.steps.NewsCreationSteps;
import ru.iteco.fmhandroid.ui.steps.NewsSelectCategorySteps;
import ru.iteco.fmhandroid.ui.steps.NewsSteps;

@LargeTest
@RunWith(AllureAndroidJUnit4.class)
public class NewsCreationValidDataSectionControlPanelTest {

    @Rule
    public ActivityTestRule<AppActivity> mActivityScenarioRule =
            new ActivityTestRule<>(AppActivity.class);

    String Title = "Enter Title:13  !@#$%^&*(-+){}<>12345678910123456789";
    String Description = "Description:13 !@#$%^&*(-+){}<>12345678910123456789";

    @Before

    public void waitElement() throws InterruptedException {

        AboutAppSteps.waitIdEnterButton(); // предполагаем, что мы авторизованы

        try {
            AuthorizationSteps.isAuthorizationScreen();
        } catch (NoMatchingViewException e) {
            AuthorizationSteps.logOut();
        }

        DataHelper.logIn();
    }

    @Test
    @DisplayName("Блок Новости, раздел Панель управления новостями. Создание новости.")
    @Description("Ввод валидных значений.")

    public void checkingControlPanelCreatingNewsValidData() throws InterruptedException {

        NewsSteps.goToNewsScreen();//перейти в раздел новостей
        NewsCreationSteps.editNewsButton(); //добавить новость +
        NewsCreationSteps.addNewsButton();
        NewsSelectCategorySteps.selectNewsCategoryAd();
        NewsScreen.titleTextInputOfNews.perform(replaceText(Title)); //заполнить заголовок
        NewsScreen.titleTextInputOfNews.check(matches(withText(Title)));
        NewsSteps.selectCurrentNewsDate();  //выбрать текущую дату
        NewsSteps.selectCurrentNewsTime();  //выбрать текущее время
        NewsScreen.descriptionTextInputOfNews.perform(replaceText(Description));   //заполнить описание
        NewsScreen.descriptionTextInputOfNews.check(matches(withText(Description)));
        ButtonSteps.saveButton();
        NewsScreen.checkCreationNews.check(matches(isDisplayed()));  //проверка, что новость появилась
        Thread.sleep(2000);
        AuthorizationSteps.logOut();
    }


}

