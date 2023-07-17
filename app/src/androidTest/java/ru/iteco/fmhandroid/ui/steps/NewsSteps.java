package ru.iteco.fmhandroid.ui.steps;


import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.pressKey;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.contrib.RecyclerViewActions.actionOnItemAtPosition;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.anyOf;

import androidx.test.espresso.ViewInteraction;

import ru.iteco.fmhandroid.R;

public class NewsSteps {
    public static void goToNewsScreen() throws InterruptedException {

        //перейти в раздел новости

        ViewInteraction clickMainMenuButton = onView(
                allOf(withId(R.id.main_menu_image_button)));
        clickMainMenuButton.check(matches(isDisplayed()));
        clickMainMenuButton.perform(click());
        Thread.sleep(2000);

        ViewInteraction clickNews = onView(
                anyOf(withText("News"), withText("Новости")));
        clickNews.check(matches(isDisplayed()));
        clickNews.perform(click());
        Thread.sleep(2000);
    }

    public static void newsScreenVisible() {

        //проверка отображения экрана с новостями

        ViewInteraction newsScreenVisible = onView(
                allOf(withId(R.id.all_news_cards_block_constraint_layout)));
        newsScreenVisible.check(matches(isDisplayed()));
    }

    public static void newsFilterScreen() throws InterruptedException {

        //проверка отображения экрана фильтра новостей

        ViewInteraction newsFilterScreen = onView(
                allOf(withId(R.id.filter_news_title_text_view)));
        newsFilterScreen.check(matches(isDisplayed()));
        Thread.sleep(2000);
    }
    public static void selectNewsFromList() {

        //выбор новости из списка новостей

        ViewInteraction clickRecyclerView = onView(
                allOf(withId(R.id.news_list_recycler_view)));
        clickRecyclerView.perform(actionOnItemAtPosition(0, click()));
    }

    public static void newsDate() throws InterruptedException {

        //выбор текущей даты новости

        ViewInteraction chooseDate = onView(
                allOf(withId(R.id.news_item_publish_date_text_input_edit_text)));
        chooseDate.perform(click());
        ButtonSteps.buttonОк();
        Thread.sleep(500);
    }

    public static void newsTime() throws InterruptedException {

        //выбор текущего времени новости

        ViewInteraction chooseTime = onView(
                allOf(withId(R.id.news_item_publish_time_text_input_edit_text)));
        chooseTime.perform(click());
        ButtonSteps.buttonОк();
        Thread.sleep(500);
    }

    public static void errorDeleteMessage() {

        ViewInteraction textView = onView(
                anyOf(withText("Are you sure you want to permanently delete the document? These changes cannot be reversed in the future."),
                        withText("Вы уверены, что хотите безвозвратно удалить документ? Данные изменения нельзя будет отменить в будущем.")));
        textView.check(matches(isDisplayed()));
    }

    public static void selectFilterNewsCheckBoxActive() throws InterruptedException {

        ViewInteraction materialCheckBoxActive = onView(
                allOf(withId(R.id.filter_news_active_material_check_box)));
        materialCheckBoxActive.check(matches(isDisplayed()));
        materialCheckBoxActive.perform(click());
        Thread.sleep(2000);
    }

    public static void selectFilterNewsCheckBoxInactive() throws InterruptedException {

        ViewInteraction materialCheckBoxNotActive = onView(
                allOf(withId(R.id.filter_news_inactive_material_check_box)));
        materialCheckBoxNotActive.check(matches(isDisplayed()));
        materialCheckBoxNotActive.perform(click());
        Thread.sleep(2000);
    }

    public static void deleteNews() throws InterruptedException {

        //удаление новости

        ViewInteraction clickDeleteNewsListStep = onView(
                anyOf(withText("Control panel"), withText("Панель управления")));
        clickDeleteNewsListStep.check(matches(isDisplayed()));
        clickDeleteNewsListStep.perform(pressKey(61), pressKey(61), pressKey(61),
                pressKey(61), pressKey(61), pressKey(61));
        clickDeleteNewsListStep.perform(pressKey(61), pressKey(61), pressKey(66));
        Thread.sleep(2000);

    }

}
