package com.animations.indanimator.actions;

import android.view.View;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;

/**
 * Base Action with some mandatory fields.
 */
public abstract class BaseAction implements Action {

    /**
     * The {@link View} to perform the action.
     */
    private View view;

    /**
     * The duration of the action.
     */
    private int duration = 300;

    /**
     * The delay of the action.
     */
    private int delay = 0;

    /**
     * Boolean value for animating alone.
     */
    private boolean animateAlone;

    /**
     * The {@link Interpolator} for the animations.
     */
    private Interpolator interpolator = new LinearInterpolator();

    /**
     * Constructor for this class.
     *
     * @param view the {@link View}.
     */
    public BaseAction(final View view) {
        this.view = view;
    }

    /**
     * Method for getting the {@link View}.
     *
     * @return the {@link View}.
     */
    public View getView() {
        return view;
    }

    /**
     * Method for getting the duration of the {@link BaseAction}.
     *
     * @return the duration.
     */
    public int getDuration() {
        return duration;
    }

    /**
     * Method for setting the duration for this {@link BaseAction}.
     *
     * @param duration the duration to set.
     */
    public void setDuration(int duration) {
        this.duration = duration;
    }

    /**
     * Method for getting the delay of the {@link BaseAction}.
     *
     * @return the delay.
     */
    public int getDelay() {
        return delay;
    }

    /**
     * Method for setting the delay for this {@link BaseAction}.
     *
     * @param delay the delay to set.
     */
    public void setDelay(int delay) {
        this.delay = delay;
    }

    /**
     * Boolean value for animating alone the {@link BaseAction}.
     *
     * @return true if yes, otherwise false.
     */
    public boolean isAnimateAlone() {
        return animateAlone;
    }

    /**
     * Method for setting to animate alone the {@link View}.
     *
     * @param animateAlone the boolean value.
     */
    public void setAnimateAlone(boolean animateAlone) {
        this.animateAlone = animateAlone;
    }

    /**
     * Method for getting the {@link Interpolator}.
     *
     * @return the {@link Interpolator}.
     */
    public Interpolator getInterpolator() {
        return interpolator;
    }

    /**
     * Method for setting the {@link Interpolator}.
     *
     * @param interpolator the {@link Interpolator} to set.
     */
    public void setInterpolator(Interpolator interpolator) {
        this.interpolator = interpolator;
    }
}
