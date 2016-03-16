package com.animations.indanimator.actions;

import android.view.View;

/**
 * Animation action for a view.
 */
public interface Action {

    /**
     * Method for initializing the animation.
     *
     * @param view the {@link View} to init
     */
    void init(final View view);

    /**
     * Method for animating the {@link View}.
     *
     * @param view the {@link View} to animate.
     */
    void animate(final View view);
}
