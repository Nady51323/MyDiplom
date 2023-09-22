package ru.iteco.fmhandroid.ui.tests.news;


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
import ru.iteco.fmhandroid.ui.steps.AboutAppSteps;
import ru.iteco.fmhandroid.ui.steps.AuthorizationSteps;
import ru.iteco.fmhandroid.ui.steps.ButtonSteps;
import ru.iteco.fmhandroid.ui.steps.NewsCreationSteps;
import ru.iteco.fmhandroid.ui.steps.NewsSelectCategorySteps;
import ru.iteco.fmhandroid.ui.steps.NewsSteps;


@LargeTest
@RunWith(AllureAndroidJUnit4.class)
public class NewsFilteringTest {

    @Rule
    public ActivityTestRule<AppActivity> mActivityScenarioRule =
            new ActivityTestRule<>(AppActivity.class);

    String DateStart = "01.05.2023";
    String DateEnd = "01.06.2023";

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
    @DisplayName("Фильтрация новостей.")
    @Description("Выбор категорий и успешная работа полей.")

    public void newsFilteringTest() throws InterruptedException {

        NewsSteps.goToNewsScreen();
        NewsSteps.newsScreenVisible();
        NewsSteps.buttonFilterNews();
        NewsSteps.newsFilterScreen();
        NewsSelectCategorySteps.selectNewsCategoryAd();
        NewsSelectCategorySteps.selectNewsCategoryBirthday();
        NewsSelectCategorySteps.selectNewsCategorySalary();
        NewsSelectCategorySteps.selectNewsCategoryTradeUnion();
        NewsSelectCategorySteps.selectNewsCategoryCelebration();
        NewsSelectCategorySteps.selectNewsCategoryMassage();
        NewsSelectCategorySteps.selectNewsCategoryGratitude();
        NewsSelectCategorySteps.selectNewsCategoryNeedHelp();

        NewsSteps.filteringNewsSelectedPeriod(DateStart, DateEnd);

        NewsSteps.newsFilterButton();
        NewsCreationSteps.editNewsButton();

        NewsSteps.checkTextControlPanelIsVisible();


        NewsSteps.buttonFilterNews();
        NewsSteps.checkTextFilterNewsIsVisible();

        //нажимаем категории , удостоверяемся в их наличии.
        NewsSelectCategorySteps.selectNewsCategoryAd();

        //вводим даты
        NewsSteps.filteringNewsSelectedPeriod(DateStart, DateEnd);
        Thread.sleep(1000);

        NewsSteps.selectFilterNewsCheckBoxActive();
        NewsSteps.selectFilterNewsCheckBoxActive();

        NewsSteps.selectFilterNewsCheckBoxInactive();
        NewsSteps.selectFilterNewsCheckBoxInactive();

        NewsSteps.newsFilterButton();
        NewsSteps.buttonFilterNews();
        ButtonSteps.buttonCancel();

        AuthorizationSteps.logOut();
    }


}

