package ru.iteco.fmhandroid.ui.screenElements;


import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

import androidx.test.espresso.ViewInteraction;

import ru.iteco.fmhandroid.R;

public class ClaimCreationScreen {

    // Создание/редактирование претензии
    public static ViewInteraction titleTextInputOfClaim = onView(withId(R.id.title_edit_text));
    public static ViewInteraction selectExecutorFromList = onView(withText("Ivanov Ivan Ivanovich"));
    public static ViewInteraction dateOfClaim = onView(withId(R.id.date_in_plan_text_input_edit_text));
    public static ViewInteraction timeOfClaim = onView(withId(R.id.time_in_plan_text_input_edit_text));
    public static ViewInteraction descriptionTextInputOfClaim = onView(withId(R.id.description_edit_text));
    public static ViewInteraction okButton = onView(withId(android.R.id.button1));
    public static ViewInteraction saveButton = onView(withId(R.id.save_button));
    public static ViewInteraction checkTitleOfClaim = onView(withText("Title NewClaim:13 !@#$%^&*(-+){}<>123456789101234"));
    public static ViewInteraction checkAddComment = onView(withText("Add comment :13@#$%()&"));
}
