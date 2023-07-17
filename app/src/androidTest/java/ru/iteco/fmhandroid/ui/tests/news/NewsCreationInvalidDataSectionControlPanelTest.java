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
public class NewsCreationInvalidDataSectionControlPanelTest {

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
    @Description("Ввод невалидных значений. Поле Категория.")

    public void checkingCreatingNewsInvalidCategory() throws InterruptedException {

        //перейти в раздел новостей
        NewsSteps.goToNewsScreen();

        ButtonSteps.editNewsButton();

        //добавить новость +
        ButtonSteps.addNewsButton();

        NewsCreationSteps.inputNewsInvalidDataCategory();
        ButtonSteps.saveButton();

        //не сохранено
        pressBack();
        Thread.sleep(2000);
        AuthorizationSteps.logOut();

    }


    @Test
    @DisplayName("Блок Новости, раздел Панель управления новостями. Создание новости.")
    @Description("Ввод невалидных значений. Поле Заголовок и Дата.")

    public void checkingControlPanelCreatingNewsInvalidTitle() throws InterruptedException {

        //перейти в раздел новостей
        NewsSteps.goToNewsScreen();

        ButtonSteps.editNewsButton();

        //нажимаем кнопку добавить новость +
        ButtonSteps.addNewsButton();
        NewsCreationSteps.inputNewsInvalidDataTitleDate();
        ButtonSteps.saveButton();

        pressBack();
        Thread.sleep(2000);
        AuthorizationSteps.logOut();

    }


    @Test
    @DisplayName("Блок Новости, раздел Панель управления новостями. Создание новости.")
    @Description("Ввод невалидных значений. Поле Время")

    public void checkingControlPanelCreatingNewsInvalidTime() throws InterruptedException {

        //перейти в раздел новостей
        NewsSteps.goToNewsScreen();

        // cоздать новость
        ButtonSteps.editNewsButton();

        //добавить новость +
        ButtonSteps.addNewsButton();
        NewsCreationSteps.inputNewsInvalidDataTime();
        ButtonSteps.buttonCancelNews();

        //не сохранено
        pressBack();
        AuthorizationSteps.logOut();

    }
}


