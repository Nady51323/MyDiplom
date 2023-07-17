package ru.iteco.fmhandroid.ui.tests.news;


import static androidx.test.espresso.Espresso.pressBack;

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
import ru.iteco.fmhandroid.ui.steps.AuthorizationSteps;
import ru.iteco.fmhandroid.ui.steps.ButtonSteps;
import ru.iteco.fmhandroid.ui.steps.NewsCreationSteps;
import ru.iteco.fmhandroid.ui.steps.NewsSteps;

@LargeTest
@RunWith(AllureAndroidJUnit4.class)
public class NewsCreationEmptyFieldSectionControlPanelTest {

    @Rule
    public ActivityTestRule<AppActivity> mActivityScenarioRule =
            new ActivityTestRule<>(AppActivity.class);

    @Before
    public void ThreadSleep() throws InterruptedException {
        Thread.sleep(7000);

        AuthorizationSteps.logIn();
    }

    @Test
    @DisplayName("Блок Новости, раздел Панель управления новостями.")
    @Description("Создание новости без категории.")

    public void checkingControlPanelCreatingNewsWithEmptyCategory() throws InterruptedException {

        //перейти в новости
        NewsSteps.goToNewsScreen();

        //создать новость
        ButtonSteps.editNewsButton();

        //добавить новость
        ButtonSteps.addNewsButton();

        NewsCreationSteps.inputNewsEmptyCategory();
        ButtonSteps.saveButton();
        pressBack();
        AuthorizationSteps.logOut();

    }
}

