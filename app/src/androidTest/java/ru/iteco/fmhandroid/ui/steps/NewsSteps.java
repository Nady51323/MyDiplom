package ru.iteco.fmhandroid.ui.steps;


import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.pressKey;
import static androidx.test.espresso.action.ViewActions.replaceText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.contrib.RecyclerViewActions.actionOnItemAtPosition;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.isRoot;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

import static ru.iteco.fmhandroid.utils.CustomViewActions.waitDisplayed;

import io.qameta.allure.kotlin.Allure;
import ru.iteco.fmhandroid.R;
import ru.iteco.fmhandroid.ui.screenElements.MainScreen;
import ru.iteco.fmhandroid.ui.screenElements.NewsScreen;

public class NewsSteps {
    public static void goToNewsScreen() throws InterruptedException {

        Allure.step("Переход на экран новостей");
        MainScreen.mainMenuButton.perform(click());
        MainScreen.newsOfMenu.check(matches(isDisplayed()));
        MainScreen.newsOfMenu.perform(click());

    }

    public static void newsScreenVisible() throws InterruptedException {

        Allure.step("Проверка отображения экрана с новостями");
        NewsScreen.newsScreenIsVisible.check(matches(isDisplayed()));


    }

    public static void checkTextControlPanelIsVisible() throws InterruptedException {

        Allure.step("Проверка отображения текста 'Панель управления'.");
        NewsScreen.controlPanel.check(matches(isDisplayed()));


    }

    public static void checkTextFilterNewsIsVisible() throws InterruptedException {

        Allure.step("Проверка отображения текста 'Фильтровать новости'.");
        NewsScreen.filterNews.check(matches(isDisplayed()));


    }

    public static void newsFilterScreen() throws InterruptedException {

        Allure.step("Проверка отображения экрана фильтра новостей");
        NewsScreen.newsFilterScreenIsVisible.check(matches(isDisplayed()));


    }

    public static void buttonFilterNews() throws InterruptedException {

        Allure.step("Клик по кнопке 'Фильтрация новостей' c id:" + (R.id.filter_news_material_button));
        NewsScreen.filterNewsMaterialButton.check(matches(isDisplayed()));
        NewsScreen.filterNewsMaterialButton.perform(click());


    }

    public static void newsFilterButton() throws InterruptedException {

        Allure.step("Клик по кнопке 'Фильтровать' новости c id:" + (R.id.filter_button));
        NewsScreen.filterButton.check(matches(isDisplayed()));
        NewsScreen.filterButton.perform(click());


    }
    public static void filteringNewsSelectedPeriod(String DateStart, String DateEnd) throws InterruptedException {

        Allure.step("Фильтрация новостей по выбранному периоду.");
        NewsScreen.publicationDateStartTextInputOfNews.perform(replaceText(DateStart));
        NewsScreen.publicationDateStartTextInputOfNews.check(matches(withText(DateStart)));
        NewsScreen.publicationDateEndTextInputOfNews.perform(replaceText(DateEnd));
        NewsScreen.publicationDateEndTextInputOfNews.check(matches(withText(DateEnd)));


    }

    public static void selectFirstNewsCard() throws InterruptedException {

        Allure.step("Выбрать первую карточку новостей");
        NewsScreen.newsRecyclerView.perform(actionOnItemAtPosition(0, click()));


    }


    public static void selectCurrentNewsDate() throws InterruptedException {

        Allure.step("Выбрать текущую дату новости");
        NewsScreen.publicationDateTextInputOfNews.perform(click());
        ButtonSteps.buttonОк();


    }

    public static void selectCurrentNewsTime() throws InterruptedException {

        //выбор текущего времени новости
        Allure.step("Выбрать текущее время новости");
        NewsScreen.timeTextInputOfNews.perform(click());
        ButtonSteps.buttonОк();


    }

    public static void selectFilterNewsCheckBoxActive() throws InterruptedException {

        Allure.step("Выбрать чек-бокс 'Фильтр новостей активен'");
        NewsScreen.checkBoxActive.check(matches(isDisplayed()));
        NewsScreen.checkBoxActive.perform(click());


    }

    public static void selectFilterNewsCheckBoxInactive() throws InterruptedException {

        Allure.step("Выбрать чек-бокс 'Фильтр новостей неактивен'");
        NewsScreen.checkBoxInactive.check(matches(isDisplayed()));
        NewsScreen.checkBoxInactive.perform(click());



    }

    public static void deleteFirstNewsCard() throws InterruptedException {

        Allure.step("Удаление первой карточки в списке новостей'");
        NewsScreen.controlPanel.check(matches(isDisplayed()));
        NewsScreen.controlPanel.perform(pressKey(61), pressKey(61), pressKey(61),
                pressKey(61), pressKey(61), pressKey(61));
        NewsScreen.controlPanel.perform(pressKey(61), pressKey(61), pressKey(66));

    }

    public static void errorDeleteMessage() throws InterruptedException {

        Allure.step("Cообщение об ошибке при удалении новости.");
        NewsScreen.errorMessageWhenDeletingNews.check(matches(isDisplayed()));

    }

    public static void waitIdElementEditNews() {
        Allure.step("Ожидание отображения кнопки добавить комментарий");
        onView(isRoot()).perform(waitDisplayed(R.id.edit_news_item_image_view, 7000));
    }


}
