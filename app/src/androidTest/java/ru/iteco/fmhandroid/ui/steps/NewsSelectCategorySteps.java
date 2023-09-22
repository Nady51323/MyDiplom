package ru.iteco.fmhandroid.ui.steps;


import static androidx.test.espresso.action.ViewActions.clearText;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.closeSoftKeyboard;

import androidx.test.espresso.matcher.RootMatchers;

import io.qameta.allure.kotlin.Allure;
import ru.iteco.fmhandroid.ui.screenElements.NewsScreen;

public class NewsSelectCategorySteps {
    public static void selectNewsCategoryAd() throws InterruptedException {

        Allure.step("Выбор категории новостей 'Объявление'");
       // NewsScreen.categoryTextInputOfNews.check(matches(isDisplayed())); ??
        NewsScreen.categoryTextInputOfNews.perform(clearText());
        NewsScreen.categoryTextInputOfNews.perform(click(), closeSoftKeyboard());
        NewsScreen.moveThroughCategory1.inRoot(RootMatchers.isPlatformPopup()).perform(click());
        //NewsScreen.categoryTextInputOfNews.check(matches(withText("Объявление"))); можно убрать!? это проверка?
        Thread.sleep(500);


       //ViewInteraction clickCategoryAd = onView(
       //         allOf(withId(R.id.news_item_category_text_auto_complete_text_view)));
       // clickCategoryAd.check(matches(isDisplayed()));
       // clickCategoryAd.perform(clearText());
       // clickCategoryAd.perform(click(), closeSoftKeyboard());

       // ViewInteraction moveThroughCategory1 =
        //        onView(withText("Объявление"))
        //                .inRoot(RootMatchers.isPlatformPopup())
       //                 .perform(click());
       // clickCategoryAd.check(matches(withText("Объявление")));

    }

    public static void selectNewsCategoryBirthday() throws InterruptedException {

        Allure.step("Выбор категории новостей 'День рождения'");
        // NewsScreen.categoryTextInputOfNews.check(matches(isDisplayed())); ??
        NewsScreen.categoryTextInputOfNews.perform(clearText());
        NewsScreen.categoryTextInputOfNews.perform(click(), closeSoftKeyboard());
        NewsScreen.moveThroughCategory2.inRoot(RootMatchers.isPlatformPopup()).perform(click());
        //NewsScreen.categoryTextInputOfNews.check(matches(withText("День рождения"))); можно убрать!? это проверка?
        Thread.sleep(500);

        /*ViewInteraction clickCategoryBirthday = onView(
                allOf(withId(R.id.news_item_category_text_auto_complete_text_view)));
        clickCategoryBirthday.check(matches(isDisplayed()));
        clickCategoryBirthday.perform(clearText());
        clickCategoryBirthday.perform(click(), closeSoftKeyboard());

        ViewInteraction moveThroughCategory2 =
                onView(withText("День рождения"))
                        .inRoot(RootMatchers.isPlatformPopup())
                        .perform(click());
        clickCategoryBirthday.check(matches(withText("День рождения")));
        Thread.sleep(500);*/
    }

    public static void selectNewsCategorySalary() throws InterruptedException {

        Allure.step("Выбор категории новостей 'Зарплата'");
        // NewsScreen.categoryTextInputOfNews.check(matches(isDisplayed())); ??
        NewsScreen.categoryTextInputOfNews.perform(clearText());
        NewsScreen.categoryTextInputOfNews.perform(click(), closeSoftKeyboard());
        NewsScreen.moveThroughCategory3.inRoot(RootMatchers.isPlatformPopup()).perform(click());
        //NewsScreen.categoryTextInputOfNews.check(matches(withText("Зарплата"))); можно убрать!? это проверка?
        Thread.sleep(500);

       /* ViewInteraction clickCategorySalary = onView(
                allOf(withId(R.id.news_item_category_text_auto_complete_text_view)));
        clickCategorySalary.check(matches(isDisplayed()));
        clickCategorySalary.perform(clearText());
        clickCategorySalary.perform(click(), closeSoftKeyboard());

        ViewInteraction moveThroughCategory3 =
                onView(withText("Зарплата"))
                        .inRoot(RootMatchers.isPlatformPopup())
                        .perform(click());
        clickCategorySalary.check(matches(withText("Зарплата")));
        Thread.sleep(500);*/
    }

    public static void selectNewsCategoryTradeUnion() throws InterruptedException {

        Allure.step("Выбор категории новостей 'Профсоюз'");
        // NewsScreen.categoryTextInputOfNews.check(matches(isDisplayed())); ??
        NewsScreen.categoryTextInputOfNews.perform(clearText());
        NewsScreen.categoryTextInputOfNews.perform(click(), closeSoftKeyboard());
        NewsScreen.moveThroughCategory4.inRoot(RootMatchers.isPlatformPopup()).perform(click());
        //NewsScreen.categoryTextInputOfNews.check(matches(withText("Профсоюз"))); можно убрать!? это проверка?
        Thread.sleep(500);

      /*  ViewInteraction clickCategoryTradeUnion = onView(
                allOf(withId(R.id.news_item_category_text_auto_complete_text_view)));
        clickCategoryTradeUnion.check(matches(isDisplayed()));
        clickCategoryTradeUnion.perform(clearText());
        clickCategoryTradeUnion.perform(click(), closeSoftKeyboard());

        ViewInteraction moveThroughCategory4 =
                onView(withText("Профсоюз"))
                        .inRoot(RootMatchers.isPlatformPopup())
                        .perform(click());
        clickCategoryTradeUnion.check(matches(withText("Профсоюз")));
        Thread.sleep(500);*/
    }

    public static void selectNewsCategoryCelebration() throws InterruptedException {

        Allure.step("Выбор категории новостей 'Праздник'");
        // NewsScreen.categoryTextInputOfNews.check(matches(isDisplayed())); ??
        NewsScreen.categoryTextInputOfNews.perform(clearText());
        NewsScreen.categoryTextInputOfNews.perform(click(), closeSoftKeyboard());
        NewsScreen.moveThroughCategory5.inRoot(RootMatchers.isPlatformPopup()).perform(click());
        //NewsScreen.categoryTextInputOfNews.check(matches(withText("Праздник"))); можно убрать!? это проверка?
        Thread.sleep(500);

       /* ViewInteraction clickCategoryCelebration = onView(
                allOf(withId(R.id.news_item_category_text_auto_complete_text_view)));
        clickCategoryCelebration.check(matches(isDisplayed()));
        clickCategoryCelebration.perform(clearText());
        clickCategoryCelebration.perform(click(), closeSoftKeyboard());

        ViewInteraction moveThroughCategory5 =
                onView(withText("Праздник"))
                        .inRoot(RootMatchers.isPlatformPopup())
                        .perform(click());
        clickCategoryCelebration.check(matches(withText("Праздник")));
        Thread.sleep(500);*/
    }

    public static void selectNewsCategoryMassage() throws InterruptedException {

        Allure.step("Выбор категории новостей 'Массаж'");
        // NewsScreen.categoryTextInputOfNews.check(matches(isDisplayed())); ??
        NewsScreen.categoryTextInputOfNews.perform(clearText());
        NewsScreen.categoryTextInputOfNews.perform(click(), closeSoftKeyboard());
        NewsScreen.moveThroughCategory6.inRoot(RootMatchers.isPlatformPopup()).perform(click());
        //NewsScreen.categoryTextInputOfNews.check(matches(withText("Массаж"))); можно убрать!? это проверка?
        Thread.sleep(500);

      /*  ViewInteraction clickCategoryMassage = onView(
                allOf(withId(R.id.news_item_category_text_auto_complete_text_view)));
        clickCategoryMassage.check(matches(isDisplayed()));
        clickCategoryMassage.perform(clearText());
        clickCategoryMassage.perform(click(), closeSoftKeyboard());

        ViewInteraction moveThroughCategory6 =
                onView(withText("Массаж"))
                        .inRoot(RootMatchers.isPlatformPopup())
                        .perform(click());
        clickCategoryMassage.check(matches(withText("Массаж")));
        Thread.sleep(500);*/
    }

    public static void selectNewsCategoryGratitude() throws InterruptedException {

        Allure.step("Выбор категории новостей 'Благодарность'");
        // NewsScreen.categoryTextInputOfNews.check(matches(isDisplayed())); ??
        NewsScreen.categoryTextInputOfNews.perform(clearText());
        NewsScreen.categoryTextInputOfNews.perform(click(), closeSoftKeyboard());
        NewsScreen.moveThroughCategory7.inRoot(RootMatchers.isPlatformPopup()).perform(click());
        //NewsScreen.categoryTextInputOfNews.check(matches(withText("Благодарность"))); можно убрать!? это проверка?
        Thread.sleep(500);

      /*  ViewInteraction clickCategoryGratitude = onView(
                allOf(withId(R.id.news_item_category_text_auto_complete_text_view)));
        clickCategoryGratitude.check(matches(isDisplayed()));
        clickCategoryGratitude.perform(clearText());
        clickCategoryGratitude.perform(click(), closeSoftKeyboard());

        ViewInteraction moveThroughCategory7 =
                onView(withText("Благодарность"))
                        .inRoot(RootMatchers.isPlatformPopup())
                        .perform(click());
        clickCategoryGratitude.check(matches(withText("Благодарность")));
        Thread.sleep(500);*/
    }

    public static void selectNewsCategoryNeedHelp() throws InterruptedException {

        Allure.step("Выбор категории новостей 'Нужна помощь'");
        // NewsScreen.categoryTextInputOfNews.check(matches(isDisplayed())); ??
        NewsScreen.categoryTextInputOfNews.perform(clearText());
        NewsScreen.categoryTextInputOfNews.perform(click(), closeSoftKeyboard());
        NewsScreen.moveThroughCategory8.inRoot(RootMatchers.isPlatformPopup()).perform(click());
        //NewsScreen.categoryTextInputOfNews.check(matches(withText("Нужна помощь"))); можно убрать!? это проверка?
        Thread.sleep(500);

      /*  ViewInteraction clickCategoryNeedHelp = onView(
                allOf(withId(R.id.news_item_category_text_auto_complete_text_view)));
        clickCategoryNeedHelp.check(matches(isDisplayed()));
        clickCategoryNeedHelp.perform(clearText());
        clickCategoryNeedHelp.perform(click(), closeSoftKeyboard());

        ViewInteraction moveThroughCategory8 =
                onView(withText("Нужна помощь"))
                        .inRoot(RootMatchers.isPlatformPopup())
                        .perform(click());
        clickCategoryNeedHelp.check(matches(withText("Нужна помощь")));
        Thread.sleep(1000);*/
    }
}
