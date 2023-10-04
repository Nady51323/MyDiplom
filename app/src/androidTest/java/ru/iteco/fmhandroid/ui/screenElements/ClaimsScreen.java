package ru.iteco.fmhandroid.ui.screenElements;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.matcher.ViewMatchers.withHint;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withParent;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

import static org.hamcrest.Matchers.allOf;

import androidx.test.espresso.ViewInteraction;

import ru.iteco.fmhandroid.R;

public class ClaimsScreen {

    // Смена статуса претензии
    public static ViewInteraction changeStatusButtonOfClaim = onView(withId(R.id.status_processing_image_button));

    // Редактирование претензии

    public static ViewInteraction editClaimButton = onView(withId(R.id.edit_processing_image_button));
    public static ViewInteraction throwOffStatusButton = onView(withText("Throw off"));
    public static ViewInteraction addComment = onView(withHint("Comment"));
    public static ViewInteraction addCommentButton = onView(withId(R.id.add_comment_image_button));
    public static ViewInteraction selectFromList = onView(withId(R.id.executor_drop_menu_auto_complete_text_view));
    public static ViewInteraction claimStatusOpen = onView(withText("Open"));
    public static ViewInteraction claimStatusToExecute = onView(withText("To execute"));
    public static ViewInteraction claimStatusExecuted = onView(withText("Executed"));
    public static ViewInteraction claimValidationMessage = onView(withId(android.R.id.message));
    public static ViewInteraction errorMessage = onView(withText("The changes won't be saved, do you really want to log out?"));
    public static ViewInteraction containerForClaims = onView(withId(R.id.claim_list_recycler_view));
    public static ViewInteraction takeToWorkButton = onView(withText("take to work"));
    public static ViewInteraction addNewClaimButton = onView(withId(R.id.add_new_claim_material_button));
    public static ViewInteraction closeClaimButton = onView(withId(R.id.close_image_button));
    public static ViewInteraction cancelButton = onView(withId(R.id.cancel_button));
    public static ViewInteraction saveButton = onView(withId(R.id.save_button));

    // Фильтрация претензий
    public static ViewInteraction buttonForClaimsFiltering = onView(withId(R.id.filters_material_button));
    public static ViewInteraction titleOfFilterDialog = onView(withId(R.id.claim_filter_dialog_title));
    public static ViewInteraction buttonRefresh = onView(allOf(withId(R.id.claim_retry_material_button),
            withParent(allOf(withId(R.id.all_claims_cards_block_constraint_layout),
                    withParent(withId(R.id.container_list_claim_include))))));
    public static ViewInteraction okButton = onView(withId(R.id.claim_list_filter_ok_material_button));
    public static ViewInteraction inProgress = onView(withId(R.id.item_filter_in_progress));
    public static ViewInteraction open = onView(withId(R.id.item_filter_open));
    public static ViewInteraction executed = onView(withId(R.id.item_filter_executed));
    public static ViewInteraction cancelled = onView(withId(R.id.item_filter_cancelled));


}
