package ru.iteco.fmhandroid.ui.steps;


import static androidx.test.espresso.action.ViewActions.clearText;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.closeSoftKeyboard;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

import androidx.test.espresso.matcher.RootMatchers;

import io.qameta.allure.kotlin.Allure;
import ru.iteco.fmhandroid.ui.screenElements.NewsScreen;

public class NewsSelectCategorySteps {
    public static void selectNewsCategoryAd() throws InterruptedException {

        Allure.step("Выбор категории новостей 'Объявление'");
        NewsScreen.categoryTextInputOfNews.check(matches(isDisplayed()));
        NewsScreen.categoryTextInputOfNews.perform(clearText());
        NewsScreen.categoryTextInputOfNews.perform(click(), closeSoftKeyboard());
        NewsScreen.moveThroughCategory1.inRoot(RootMatchers.isPlatformPopup()).perform(click());
        NewsScreen.categoryTextInputOfNews.check(matches(withText("Объявление")));

    }

    public static void selectNewsCategoryBirthday() throws InterruptedException {

        Allure.step("Выбор категории новостей 'День рождения'");
        NewsScreen.categoryTextInputOfNews.check(matches(isDisplayed()));
        NewsScreen.categoryTextInputOfNews.perform(clearText());
        NewsScreen.categoryTextInputOfNews.perform(click(), closeSoftKeyboard());
        NewsScreen.moveThroughCategory2.inRoot(RootMatchers.isPlatformPopup()).perform(click());
        NewsScreen.categoryTextInputOfNews.check(matches(withText("День рождения")));

    }

    public static void selectNewsCategorySalary() throws InterruptedException {

        Allure.step("Выбор категории новостей 'Зарплата'");
        NewsScreen.categoryTextInputOfNews.check(matches(isDisplayed()));
        NewsScreen.categoryTextInputOfNews.perform(clearText());
        NewsScreen.categoryTextInputOfNews.perform(click(), closeSoftKeyboard());
        NewsScreen.moveThroughCategory3.inRoot(RootMatchers.isPlatformPopup()).perform(click());
        NewsScreen.categoryTextInputOfNews.check(matches(withText("Зарплата")));

    }

    public static void selectNewsCategoryTradeUnion() throws InterruptedException {

        Allure.step("Выбор категории новостей 'Профсоюз'");
        NewsScreen.categoryTextInputOfNews.check(matches(isDisplayed()));
        NewsScreen.categoryTextInputOfNews.perform(clearText());
        NewsScreen.categoryTextInputOfNews.perform(click(), closeSoftKeyboard());
        NewsScreen.moveThroughCategory4.inRoot(RootMatchers.isPlatformPopup()).perform(click());
        NewsScreen.categoryTextInputOfNews.check(matches(withText("Профсоюз")));

    }

    public static void selectNewsCategoryCelebration() throws InterruptedException {

        Allure.step("Выбор категории новостей 'Праздник'");
        NewsScreen.categoryTextInputOfNews.check(matches(isDisplayed()));
        NewsScreen.categoryTextInputOfNews.perform(clearText());
        NewsScreen.categoryTextInputOfNews.perform(click(), closeSoftKeyboard());
        NewsScreen.moveThroughCategory5.inRoot(RootMatchers.isPlatformPopup()).perform(click());
        NewsScreen.categoryTextInputOfNews.check(matches(withText("Праздник")));

    }

    public static void selectNewsCategoryMassage() throws InterruptedException {

        Allure.step("Выбор категории новостей 'Массаж'");
        NewsScreen.categoryTextInputOfNews.check(matches(isDisplayed()));
        NewsScreen.categoryTextInputOfNews.perform(clearText());
        NewsScreen.categoryTextInputOfNews.perform(click(), closeSoftKeyboard());
        NewsScreen.moveThroughCategory6.inRoot(RootMatchers.isPlatformPopup()).perform(click());
        NewsScreen.categoryTextInputOfNews.check(matches(withText("Массаж")));

    }

    public static void selectNewsCategoryGratitude() throws InterruptedException {

        Allure.step("Выбор категории новостей 'Благодарность'");
        NewsScreen.categoryTextInputOfNews.check(matches(isDisplayed()));
        NewsScreen.categoryTextInputOfNews.perform(clearText());
        NewsScreen.categoryTextInputOfNews.perform(click(), closeSoftKeyboard());
        NewsScreen.moveThroughCategory7.inRoot(RootMatchers.isPlatformPopup()).perform(click());
        NewsScreen.categoryTextInputOfNews.check(matches(withText("Благодарность")));

    }

    public static void selectNewsCategoryNeedHelp() throws InterruptedException {

        Allure.step("Выбор категории новостей 'Нужна помощь'");
        NewsScreen.categoryTextInputOfNews.check(matches(isDisplayed()));
        NewsScreen.categoryTextInputOfNews.perform(clearText());
        NewsScreen.categoryTextInputOfNews.perform(click(), closeSoftKeyboard());
        NewsScreen.moveThroughCategory8.inRoot(RootMatchers.isPlatformPopup()).perform(click());
        NewsScreen.categoryTextInputOfNews.check(matches(withText("Нужна помощь")));

    }
}
