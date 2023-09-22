package ru.iteco.fmhandroid.ui.steps;


import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.pressKey;
import static androidx.test.espresso.action.ViewActions.replaceText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.contrib.RecyclerViewActions.actionOnItemAtPosition;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

import io.qameta.allure.kotlin.Allure;
import ru.iteco.fmhandroid.R;
import ru.iteco.fmhandroid.ui.screenElements.MainScreen;
import ru.iteco.fmhandroid.ui.screenElements.NewsScreen;

public class NewsSteps {
    public static void goToNewsScreen() throws InterruptedException { // перенести в конторол панель??

        Allure.step("Переход на экран новостей");
        MainScreen.mainMenuButton.perform(click());
        MainScreen.newsOfMenu.check(matches(isDisplayed()));
        MainScreen.newsOfMenu.perform(click());
        Thread.sleep(2000);

        /*перейти в раздел новости

        ViewInteraction clickMainMenuButton = onView(
                allOf(withId(R.id.main_menu_image_button)));
        clickMainMenuButton.check(matches(isDisplayed()));
        clickMainMenuButton.perform(click());
        Thread.sleep(2000);

        ViewInteraction clickNews = onView(
                anyOf(withText("News"), withText("Новости")));
        clickNews.check(matches(isDisplayed()));
        clickNews.perform(click());
        Thread.sleep(2000);*/
    }

    public static void newsScreenVisible() throws InterruptedException {

        Allure.step("Проверка отображения экрана с новостями");
        NewsScreen.newsScreenIsVisible.check(matches(isDisplayed()));
        Thread.sleep(2000);

        //проверка отображения экрана с новостями

        //ViewInteraction newsScreenVisible = onView(
        //        allOf(withId(R.id.all_news_cards_block_constraint_layout)));
       // newsScreenVisible.check(matches(isDisplayed()));
    }

    public static void checkTextControlPanelIsVisible() throws InterruptedException {

        Allure.step("Проверка отображения текста 'Панель управления'.");
        NewsScreen.controlPanel.check(matches(isDisplayed()));
        Thread.sleep(2000);

    }

    public static void checkTextFilterNewsIsVisible() throws InterruptedException {

        Allure.step("Проверка отображения текста 'Фильтровать новости'.");
        NewsScreen.filterNews.check(matches(isDisplayed()));
        Thread.sleep(2000);

    }

    public static void newsFilterScreen() throws InterruptedException {

        Allure.step("Проверка отображения экрана фильтра новостей");
        NewsScreen.newsFilterScreenIsVisible.check(matches(isDisplayed()));
        Thread.sleep(2000);

        //проверка отображения экрана фильтра новостей

     //   ViewInteraction newsFilterScreen = onView(
     //           allOf(withId(R.id.filter_news_title_text_view)));
     //   newsFilterScreen.check(matches(isDisplayed()));

    }

    public static void buttonFilterNews() throws InterruptedException {

        Allure.step("Клик по кнопке 'Фильтрация новостей' c id:" + (R.id.filter_news_material_button));
        NewsScreen.filterNewsMaterialButton.check(matches(isDisplayed()));
        NewsScreen.filterNewsMaterialButton.perform(click());
        Thread.sleep(3000);

        //  ViewInteraction clickButtonNewsFilters = onView(
        //         allOf(withId(R.id.filter_news_material_button)));
        // clickButtonNewsFilters.check(matches(isDisplayed()));
        // clickButtonNewsFilters.perform(click());

    }

    public static void newsFilterButton() throws InterruptedException {

        Allure.step("Клик по кнопке 'Фильтровать' новости c id:" + (R.id.filter_button));
        NewsScreen.filterButton.check(matches(isDisplayed()));
        NewsScreen.filterButton.perform(click());
        Thread.sleep(3000);

        //  ViewInteraction clickFilter = onView(
        //         allOf(withId(R.id.filter_button)));
        // clickFilter.check(matches(isDisplayed()));
        // clickFilter.perform(click());

    }
    public static void filteringNewsSelectedPeriod(String DateStart, String DateEnd) throws InterruptedException {

        Allure.step("Фильтрация новостей по выбранному периоду.");
        NewsScreen.publicationDateStartTextInputOfNews.perform(replaceText(DateStart));
        NewsScreen.publicationDateStartTextInputOfNews.check(matches(withText(DateStart)));
        NewsScreen.publicationDateEndTextInputOfNews.perform(replaceText(DateEnd));
        NewsScreen.publicationDateEndTextInputOfNews.check(matches(withText(DateEnd)));
        Thread.sleep(2000);

    }

    public static void selectFirstNewsCard() throws InterruptedException {

        Allure.step("Выбрать первую карточку новостей");
        NewsScreen.newsRecyclerView.perform(actionOnItemAtPosition(0, click()));
        Thread.sleep(2000);

       // ViewInteraction clickRecyclerView = onView(
       //         allOf(withId(R.id.news_list_recycler_view)));
       // clickRecyclerView.perform(actionOnItemAtPosition(0, click()));
    }


    public static void selectCurrentNewsDate() throws InterruptedException {

        Allure.step("Выбрать текущую дату новости");
        NewsScreen.publicationDateTextInputOfNews.perform(click());
        ButtonSteps.buttonОк();
        Thread.sleep(500);

        // ViewInteraction chooseDate = onView(
        //          allOf(withId(R.id.news_item_publish_date_text_input_edit_text)));
        // chooseDate.perform(click());
        // ButtonSteps.buttonОк();

    }

    public static void selectCurrentNewsTime() throws InterruptedException {

        //выбор текущего времени новости
        Allure.step("Выбрать текущее время новости");
        NewsScreen.timeTextInputOfNews.perform(click());
        ButtonSteps.buttonОк();
        Thread.sleep(500);

      //  ViewInteraction chooseTime = onView(
      //          allOf(withId(R.id.news_item_publish_time_text_input_edit_text)));
      //  chooseTime.perform(click());
      //  ButtonSteps.buttonОк();

    }

    public static void selectFilterNewsCheckBoxActive() throws InterruptedException {

        Allure.step("Выбрать чек-бокс 'Фильтр новостей активен'");
        NewsScreen.checkBoxActive.check(matches(isDisplayed()));
        NewsScreen.checkBoxActive.perform(click());
        Thread.sleep(2000);


    //    ViewInteraction materialCheckBoxActive = onView(
    //            allOf(withId(R.id.filter_news_active_material_check_box)));
     //   materialCheckBoxActive.check(matches(isDisplayed()));
    //    materialCheckBoxActive.perform(click());

    }

    public static void selectFilterNewsCheckBoxInactive() throws InterruptedException {

        Allure.step("Выбрать чек-бокс 'Фильтр новостей неактивен'");
        NewsScreen.checkBoxInactive.check(matches(isDisplayed()));
        NewsScreen.checkBoxInactive.perform(click());
        Thread.sleep(2000);


       // ViewInteraction materialCheckBoxNotActive = onView(
      //          allOf(withId(R.id.filter_news_inactive_material_check_box)));
      //  materialCheckBoxNotActive.check(matches(isDisplayed()));
      //  materialCheckBoxNotActive.perform(click());

    }

    public static void deleteFirstNewsCard() throws InterruptedException {

        Allure.step("Удаление первой карточки в списке новостей'");
        NewsScreen.controlPanel.check(matches(isDisplayed()));
        NewsScreen.controlPanel.perform(pressKey(61), pressKey(61), pressKey(61),
                pressKey(61), pressKey(61), pressKey(61));
        NewsScreen.controlPanel.perform(pressKey(61), pressKey(61), pressKey(66));
        Thread.sleep(2000);


    /*   ViewInteraction clickDeleteNewsListStep = onView(
                anyOf(withText("Control panel"), withText("Панель управления")));
        clickDeleteNewsListStep.check(matches(isDisplayed()));
        clickDeleteNewsListStep.perform(pressKey(61), pressKey(61), pressKey(61),
                pressKey(61), pressKey(61), pressKey(61));
        clickDeleteNewsListStep.perform(pressKey(61), pressKey(61), pressKey(66));
        Thread.sleep(2000);*/

    }

    public static void errorDeleteMessage() throws InterruptedException {

        Allure.step("Cообщение об ошибке при удалении новости.");
        NewsScreen.errorMessageWhenDeletingNews.check(matches(isDisplayed()));
        Thread.sleep(2000);

        //ViewInteraction textView = onView(
        //     anyOf(withText("Are you sure you want to permanently delete the document? These changes cannot be reversed in the future."),
        //               withText("Вы уверены, что хотите безвозвратно удалить документ? Данные изменения нельзя будет отменить в будущем.")));
        // textView.check(matches(isDisplayed()));
    }

}
