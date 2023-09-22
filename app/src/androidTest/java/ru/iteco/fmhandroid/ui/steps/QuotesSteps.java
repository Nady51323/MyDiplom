package ru.iteco.fmhandroid.ui.steps;


import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.contrib.RecyclerViewActions.actionOnItemAtPosition;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;

import io.qameta.allure.kotlin.Allure;
import ru.iteco.fmhandroid.R;
import ru.iteco.fmhandroid.ui.screenElements.QuotesScreen;

public class QuotesSteps {

    public static void loveIsAllButton() {

        Allure.step("Клик по кнопке перехода в блоке 'Тематические цитаты' c id:" + (R.id.our_mission_image_button));
        QuotesScreen.missionImageButton.check(matches(isDisplayed()));
        QuotesScreen.missionImageButton.perform(click());
    }

    public static void listRecyclerOurMission() {

        Allure.step("Выбор первой цитаты в блоке 'Тематические цитаты'");
        QuotesScreen.missionItemListRecyclerView.perform(actionOnItemAtPosition(0, click()));

    }
}
