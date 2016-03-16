package com.animations.sample;

import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.DecelerateInterpolator;

import com.animations.indanimator.actions.property.PropertyAction;

/**
 * Class for storing a set of predefined animations.
 */
public class PredefinedPropertyActions {

    public static PropertyAction getFabAction(View view) {
        return PropertyAction.getPropertyBuilder(view).scaleX(0).scaleY(0).duration(750).interpolator(new AccelerateDecelerateInterpolator()).build();
    }

    public static PropertyAction getHeaderAction(View view) {
        return PropertyAction.getPropertyBuilder(view).interpolator(new DecelerateInterpolator()).translationY(-200).duration(550).alpha(0.4f).build();
    }

    public static PropertyAction getBottomAction(View view) {
        return PropertyAction.getPropertyBuilder(view).translationY(500).duration(750).alpha(0f).build();
    }
}
