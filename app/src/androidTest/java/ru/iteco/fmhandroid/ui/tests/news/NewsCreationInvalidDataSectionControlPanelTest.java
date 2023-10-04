package ru.iteco.fmhandroid.ui.tests.news;


import static androidx.test.espresso.Espresso.pressBack;
import static androidx.test.espresso.action.ViewActions.closeSoftKeyboard;
import static androidx.test.espresso.action.ViewActions.replaceText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static ru.iteco.fmhandroid.ui.data.TestData.DescriptionNews;
import static ru.iteco.fmhandroid.ui.data.TestData.InvalidDataCategoryNews;
import static ru.iteco.fmhandroid.ui.data.TestData.InvalidDataTitleNews;
import static ru.iteco.fmhandroid.ui.data.TestData.InvalidPublishDateNews;
import static ru.iteco.fmhandroid.ui.data.TestData.TitleNews;

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
import ru.iteco.fmhandroid.ui.screenElements.NewsScreen;
import ru.iteco.fmhandroid.ui.steps.AboutAppSteps;
import ru.iteco.fmhandroid.ui.steps.AuthorizationSteps;
import ru.iteco.fmhandroid.ui.steps.ButtonSteps;
import ru.iteco.fmhandroid.ui.steps.NewsCreationSteps;
import ru.iteco.fmhandroid.ui.steps.NewsSelectCategorySteps;
import ru.iteco.fmhandroid.ui.steps.NewsSteps;

@LargeTest
@RunWith(AllureAndroidJUnit4.class)
public class NewsCreationInvalidDataSectionControlPanelTest {


    @Rule
    public ActivityTestRule<AppActivity> mActivityScenarioRule =
            new ActivityTestRule<>(AppActivity.class);

    String Login = TestData.ValidLogin;
    String Password = TestData.ValidPassword;
    String InvalidDataCategory = InvalidDataCategoryNews;
    String Title = TitleNews;
    String Description = DescriptionNews;
    String InvalidDataTitle = InvalidDataTitleNews;
    String InvalidPublishDate = InvalidPublishDateNews;

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
    @DisplayName("Блок Новости, раздел Панель управления новостями. Создание новости.")
    @Description("Ввод невалидных значений. Поле Категория.")

    public void checkingCreatingNewsInvalidCategory() throws InterruptedException {

        NewsSteps.goToNewsScreen();
        NewsCreationSteps.editNewsButton();
        NewsCreationSteps.addNewsButton();
        NewsScreen.categoryTextInputOfNews.perform(replaceText(InvalidDataCategory), closeSoftKeyboard());
        NewsScreen.checkCategoryOfNews.check(matches(isDisplayed()));
        NewsScreen.titleTextInputOfNews.perform(replaceText(Title));
        NewsScreen.titleTextInputOfNews.check(matches(withText(Title)));
        NewsSteps.selectCurrentNewsDate();
        NewsSteps.selectCurrentNewsTime();
        NewsScreen.descriptionTextInputOfNews.perform(replaceText(Description));
        NewsScreen.descriptionTextInputOfNews.check(matches(withText(Description)));
        ButtonSteps.saveButton();
        pressBack();

    }


    @Test
    @DisplayName("Блок Новости, раздел Панель управления новостями. Создание новости.")
    @Description("Ввод невалидных значений. Поле Заголовок и Дата.")

    public void checkingControlPanelCreatingNewsInvalidTitle() throws InterruptedException {

        NewsSteps.goToNewsScreen();
        NewsCreationSteps.editNewsButton();
        NewsCreationSteps.addNewsButton();
        NewsSelectCategorySteps.selectNewsCategoryAd();
        NewsScreen.titleTextInputOfNews.perform(replaceText(InvalidDataTitle));
        NewsScreen.titleTextInputOfNews.check(matches(withText(InvalidDataTitle)));
        NewsScreen.publicationDateTextInputOfNews.perform(replaceText(InvalidPublishDate));
        NewsSteps.selectCurrentNewsTime();
        NewsScreen.descriptionTextInputOfNews.perform(replaceText(Description));
        NewsScreen.descriptionTextInputOfNews.check(matches(withText(Description)));
        ButtonSteps.saveButton();
        pressBack();


    }

    @Test
    @DisplayName("Блок Новости, раздел Панель управления новостями.")
    @Description("Создание новости без категории.")

    public void checkingControlPanelCreatingNewsWithEmptyCategory() throws InterruptedException {

        NewsSteps.goToNewsScreen();
        NewsCreationSteps.editNewsButton();
        NewsCreationSteps.addNewsButton();
        NewsScreen.titleTextInputOfNews.perform(replaceText(Title));
        NewsScreen.titleTextInputOfNews.check(matches(withText(Title)));
        NewsSteps.selectCurrentNewsDate();
        NewsSteps.selectCurrentNewsTime();
        NewsScreen.descriptionTextInputOfNews.perform(replaceText(Description));
        NewsScreen.descriptionTextInputOfNews.check(matches(withText(Description)));
        ButtonSteps.saveButton();
        pressBack();

    }

}


