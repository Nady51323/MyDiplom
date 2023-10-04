package ru.iteco.fmhandroid.ui.tests.news;


import static ru.iteco.fmhandroid.ui.data.TestData.DateEndNews;
import static ru.iteco.fmhandroid.ui.data.TestData.DateStartNews;

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
import ru.iteco.fmhandroid.ui.data.TestData;
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

    String Login = TestData.ValidLogin;
    String Password = TestData.ValidPassword;
    String DateStart = DateStartNews;
    String DateEnd = DateEndNews;

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
        NewsSelectCategorySteps.selectNewsCategoryAd();

        NewsSteps.filteringNewsSelectedPeriod(DateStart, DateEnd);
        NewsSteps.selectFilterNewsCheckBoxActive();
        NewsSteps.selectFilterNewsCheckBoxActive();
        NewsSteps.selectFilterNewsCheckBoxInactive();
        NewsSteps.selectFilterNewsCheckBoxInactive();

        NewsSteps.newsFilterButton();
        NewsSteps.buttonFilterNews();
        ButtonSteps.buttonCancel();

    }


}

