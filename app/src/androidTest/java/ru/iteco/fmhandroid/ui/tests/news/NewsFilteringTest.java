package ru.iteco.fmhandroid.ui.tests.news;


import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.replaceText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.anyOf;

import androidx.test.espresso.ViewInteraction;
import androidx.test.filters.LargeTest;
import androidx.test.rule.ActivityTestRule;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import io.qameta.allure.android.runners.AllureAndroidJUnit4;
import io.qameta.allure.kotlin.Description;
import io.qameta.allure.kotlin.junit4.DisplayName;
import ru.iteco.fmhandroid.R;
import ru.iteco.fmhandroid.ui.AppActivity;
import ru.iteco.fmhandroid.ui.steps.AuthorizationSteps;
import ru.iteco.fmhandroid.ui.steps.ButtonSteps;
import ru.iteco.fmhandroid.ui.steps.NewsSelectCategorySteps;
import ru.iteco.fmhandroid.ui.steps.NewsSteps;


@LargeTest
@RunWith(AllureAndroidJUnit4.class)
public class NewsFilteringTest {

    @Rule
    public ActivityTestRule<AppActivity> mActivityScenarioRule =
            new ActivityTestRule<>(AppActivity.class);

    @Before
    public void ThreadSleep() throws InterruptedException {
        Thread.sleep(7000);

        AuthorizationSteps.logIn();
    }


    @Test
    @DisplayName("Фильтрация новостей.")
    @Description("Выбор категорий и успешная работа полей.")

    public void newsFilteringTest() throws InterruptedException {

        NewsSteps.goToNewsScreen();
        NewsSteps.newsScreenVisible();
        ButtonSteps.buttonFilterNews();
        NewsSteps.newsFilterScreen();
        NewsSelectCategorySteps.selectNewsCategoryAd();
        NewsSelectCategorySteps.selectNewsCategoryBirthday();
        NewsSelectCategorySteps.selectNewsCategorySalary();
        NewsSelectCategorySteps.selectNewsCategoryTradeUnion();
        NewsSelectCategorySteps.selectNewsCategoryCelebration();
        NewsSelectCategorySteps.selectNewsCategoryMassage();
        NewsSelectCategorySteps.selectNewsCategoryGratitude();
        NewsSelectCategorySteps.selectNewsCategoryNeedHelp();


        ViewInteraction clickDateStart = onView(
                allOf(withId(R.id.news_item_publish_date_start_text_input_edit_text)));
        clickDateStart.perform(replaceText("01.05.2023"));
        Thread.sleep(1000);

        ViewInteraction clickDateEnd = onView(
                allOf(withId(R.id.news_item_publish_date_end_text_input_edit_text)));
        clickDateEnd.perform(replaceText("01.06.2023"));
        Thread.sleep(1000);

        ButtonSteps.newsFilterButton();
        ButtonSteps.editNewsButton();

        ViewInteraction checkText1 = onView(
                anyOf(withText("Control panel"), withText("Панель управления")));
        checkText1.check(matches(isDisplayed()));

        ButtonSteps.buttonFilterNews();

        ViewInteraction checkText2 = onView(
                anyOf(withText("Filter news"), withText("Фильтровать новости")));
        checkText2.check(matches(isDisplayed()));

        //нажимаем категории , удостоверяемся в их наличии.
        NewsSelectCategorySteps.selectNewsCategoryAd();

        //вводим даты

        ViewInteraction clickDateStart1 = onView(
                allOf(withId(R.id.news_item_publish_date_start_text_input_edit_text)));
        clickDateStart1.perform(replaceText("01.05.2023"));
        Thread.sleep(1000);

        ViewInteraction clickDateStart2 = onView(
                allOf(withId(R.id.news_item_publish_date_end_text_input_edit_text)));
        clickDateStart2.perform(replaceText("01.06.2023"));
        Thread.sleep(1000);

        NewsSteps.selectFilterNewsCheckBoxActive();
        NewsSteps.selectFilterNewsCheckBoxActive();
        NewsSteps.selectFilterNewsCheckBoxInactive();
        NewsSteps.selectFilterNewsCheckBoxInactive();
        ButtonSteps.newsFilterButton();
        ButtonSteps.buttonFilterNews();
        ButtonSteps.buttonCancel();

        AuthorizationSteps.logOut();
    }


}

