package ru.iteco.fmhandroid.ui.screenElements;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

import androidx.test.espresso.ViewInteraction;

import ru.iteco.fmhandroid.R;

public class QuotesScreen {

    public static ViewInteraction missionTitle = onView(withId(R.id.our_mission_title_text_view));
    public static ViewInteraction missionImageButton = onView(withId(R.id.our_mission_image_button));
    public static ViewInteraction missionItemListRecyclerView = onView(withId(R.id.our_mission_item_list_recycler_view));
    public static ViewInteraction checkTextLoveIsAll = onView(withText("Love is all"));



}
