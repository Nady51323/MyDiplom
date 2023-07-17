package ru.iteco.fmhandroid.ui.tests.news;


import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;

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
import ru.iteco.fmhandroid.ui.steps.NewsCreationSteps;
import ru.iteco.fmhandroid.ui.steps.NewsSteps;

@LargeTest
@RunWith(AllureAndroidJUnit4.class)
public class NewsCreationValidDataSectionControlPanelTest {

    @Rule
    public ActivityTestRule<AppActivity> mActivityScenarioRule =
            new ActivityTestRule<>(AppActivity.class);

    @Before
    public void ThreadSleep() throws InterruptedException {
        Thread.sleep(7000);

        AuthorizationSteps.logIn();
    }

    @Test
    @DisplayName("Блок Новости, раздел Панель управления новостями. Создание новости.")
    @Description("Ввод валидных значений.")

    public void checkingControlPanelCreatingNewsValidData() throws InterruptedException {

        //перейти в новости
        NewsSteps.goToNewsScreen();

        //создать новость
        ButtonSteps.editNewsButton();

        //добавить новость +
        ButtonSteps.addNewsButton();

        NewsCreationSteps.inputNewsValidData();
        ButtonSteps.saveButton();

        //проверка, что новость появилась
        ViewInteraction newsCreationCheck = onView(
                allOf(withId(R.id.news_item_title_text_view), withText("Enter Title:13  !@#$%^&*(-+){}<>12345678910123456789")));
        newsCreationCheck.check(matches(isDisplayed()));
        Thread.sleep(2000);

        NewsSteps.selectNewsFromList();
        NewsSteps.deleteNews();
        NewsSteps.errorDeleteMessage();
        ButtonSteps.buttonОк();
        AuthorizationSteps.logOut();
    }


}

