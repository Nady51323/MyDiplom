package ru.iteco.fmhandroid.ui.steps;


import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.clearText;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.closeSoftKeyboard;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;

import androidx.test.espresso.ViewInteraction;
import androidx.test.espresso.matcher.RootMatchers;

import ru.iteco.fmhandroid.R;

public class NewsSelectCategorySteps {
    public static void selectNewsCategoryAd() throws InterruptedException {

        //раздел новости, выбор категории "объявление".

        ViewInteraction clickCategoryAd = onView(
                allOf(withId(R.id.news_item_category_text_auto_complete_text_view)));
        clickCategoryAd.check(matches(isDisplayed()));
        clickCategoryAd.perform(clearText());
        clickCategoryAd.perform(click(), closeSoftKeyboard());

        ViewInteraction moveThroughCategory1 =
                onView(withText("Объявление"))
                        .inRoot(RootMatchers.isPlatformPopup())
                        .perform(click());
        clickCategoryAd.check(matches(withText("Объявление")));
        Thread.sleep(500);
    }

    public static void selectNewsCategoryBirthday() throws InterruptedException {

        ViewInteraction clickCategoryBirthday = onView(
                allOf(withId(R.id.news_item_category_text_auto_complete_text_view)));
        clickCategoryBirthday.check(matches(isDisplayed()));
        clickCategoryBirthday.perform(clearText());
        clickCategoryBirthday.perform(click(), closeSoftKeyboard());

        ViewInteraction moveThroughCategory2 =
                onView(withText("День рождения"))
                        .inRoot(RootMatchers.isPlatformPopup())
                        .perform(click());
        clickCategoryBirthday.check(matches(withText("День рождения")));
        Thread.sleep(500);
    }

    public static void selectNewsCategorySalary() throws InterruptedException {

        ViewInteraction clickCategorySalary = onView(
                allOf(withId(R.id.news_item_category_text_auto_complete_text_view)));
        clickCategorySalary.check(matches(isDisplayed()));
        clickCategorySalary.perform(clearText());
        clickCategorySalary.perform(click(), closeSoftKeyboard());

        ViewInteraction moveThroughCategory3 =
                onView(withText("Зарплата"))
                        .inRoot(RootMatchers.isPlatformPopup())
                        .perform(click());
        clickCategorySalary.check(matches(withText("Зарплата")));
        Thread.sleep(500);
    }

    public static void selectNewsCategoryTradeUnion() throws InterruptedException {

        ViewInteraction clickCategoryTradeUnion = onView(
                allOf(withId(R.id.news_item_category_text_auto_complete_text_view)));
        clickCategoryTradeUnion.check(matches(isDisplayed()));
        clickCategoryTradeUnion.perform(clearText());
        clickCategoryTradeUnion.perform(click(), closeSoftKeyboard());

        ViewInteraction moveThroughCategory4 =
                onView(withText("Профсоюз"))
                        .inRoot(RootMatchers.isPlatformPopup())
                        .perform(click());
        clickCategoryTradeUnion.check(matches(withText("Профсоюз")));
        Thread.sleep(500);
    }

    public static void selectNewsCategoryCelebration() throws InterruptedException {

        ViewInteraction clickCategoryCelebration = onView(
                allOf(withId(R.id.news_item_category_text_auto_complete_text_view)));
        clickCategoryCelebration.check(matches(isDisplayed()));
        clickCategoryCelebration.perform(clearText());
        clickCategoryCelebration.perform(click(), closeSoftKeyboard());

        ViewInteraction moveThroughCategory5 =
                onView(withText("Праздник"))
                        .inRoot(RootMatchers.isPlatformPopup())
                        .perform(click());
        clickCategoryCelebration.check(matches(withText("Праздник")));
        Thread.sleep(500);
    }

    public static void selectNewsCategoryMassage() throws InterruptedException {

        ViewInteraction clickCategoryMassage = onView(
                allOf(withId(R.id.news_item_category_text_auto_complete_text_view)));
        clickCategoryMassage.check(matches(isDisplayed()));
        clickCategoryMassage.perform(clearText());
        clickCategoryMassage.perform(click(), closeSoftKeyboard());

        ViewInteraction moveThroughCategory6 =
                onView(withText("Массаж"))
                        .inRoot(RootMatchers.isPlatformPopup())
                        .perform(click());
        clickCategoryMassage.check(matches(withText("Массаж")));
        Thread.sleep(500);
    }

    public static void selectNewsCategoryGratitude() throws InterruptedException {

        ViewInteraction clickCategoryGratitude = onView(
                allOf(withId(R.id.news_item_category_text_auto_complete_text_view)));
        clickCategoryGratitude.check(matches(isDisplayed()));
        clickCategoryGratitude.perform(clearText());
        clickCategoryGratitude.perform(click(), closeSoftKeyboard());

        ViewInteraction moveThroughCategory7 =
                onView(withText("Благодарность"))
                        .inRoot(RootMatchers.isPlatformPopup())
                        .perform(click());
        clickCategoryGratitude.check(matches(withText("Благодарность")));
        Thread.sleep(500);
    }

    public static void selectNewsCategoryNeedHelp() throws InterruptedException {

        ViewInteraction clickCategoryNeedHelp = onView(
                allOf(withId(R.id.news_item_category_text_auto_complete_text_view)));
        clickCategoryNeedHelp.check(matches(isDisplayed()));
        clickCategoryNeedHelp.perform(clearText());
        clickCategoryNeedHelp.perform(click(), closeSoftKeyboard());

        ViewInteraction moveThroughCategory8 =
                onView(withText("Нужна помощь"))
                        .inRoot(RootMatchers.isPlatformPopup())
                        .perform(click());
        clickCategoryNeedHelp.check(matches(withText("Нужна помощь")));
        Thread.sleep(1000);
    }
}
