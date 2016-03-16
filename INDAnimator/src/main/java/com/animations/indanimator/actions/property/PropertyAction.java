package com.animations.indanimator.actions.property;

import android.view.View;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;

import com.animations.indanimator.actions.BaseAction;

import android.support.v4.view.ViewCompat;

/**
 * Action that animates the properties of the view.
 */
public class PropertyAction extends BaseAction {

    private float fromTranslationX = 0;
    private float toTranslationX = 0;
    private float fromTranslationY = 0;
    private float toTranslationY = 0;
    private float fromScaleY = 1f;
    private float toScaleY = 1f;
    private float fromScaleX = 1f;
    private float toScaleX = 1f;
    private float fromAlpha = 1f;
    private float toAlpha = 1f;
    private float fromRotation;
    private float toRotation;


    @Override
    public void init(View view) {
        setToTranslationX(ViewCompat.getTranslationX(view));
        ViewCompat.setTranslationX(view, getTranslationX());
        setToTranslationY(ViewCompat.getTranslationY(view));
        ViewCompat.setTranslationY(view, getTranslationY());
        setToScaleX(ViewCompat.getScaleX(view));
        ViewCompat.setScaleX(view, getScaleX());
        setToScaleY(ViewCompat.getScaleY(view));
        ViewCompat.setScaleY(view, getScaleY());
        setToAlpha(ViewCompat.getAlpha(view));
        ViewCompat.setAlpha(view, getAlpha());
        setToRotation(ViewCompat.getRotation(view));
        ViewCompat.setRotation(view, getRotation());
    }

    @Override
    public void animate(View view) {
        view
                .animate()
                .translationX(toTranslationX).
                translationY(toTranslationY).
                scaleY(toScaleY).
                scaleX(toScaleX).
                alpha(toAlpha).
                rotation(toRotation).
                setDuration(getDuration()).
                setStartDelay(getDelay()).
                setInterpolator(getInterpolator()).
                start();
    }

    /**
     * Constructor for this class.
     *
     * @param propertyBuilder the builder to support this constructor.
     */
    private PropertyAction(PropertyBuilder propertyBuilder) {
        super(propertyBuilder.view);
        setDuration(propertyBuilder.duration);
        setDelay(propertyBuilder.delay);
        setAnimateAlone(propertyBuilder.animateAlone);
        setInterpolator(propertyBuilder.interpolator);
        this.fromTranslationX = propertyBuilder.fromTranslationX;
        this.toTranslationX = propertyBuilder.toTranslationX;
        this.fromTranslationY = propertyBuilder.fromTranslationY;
        this.toTranslationY = propertyBuilder.toTranslationY;
        this.fromScaleY = propertyBuilder.fromScaleY;
        this.toScaleY = propertyBuilder.toScaleY;
        this.fromScaleX = propertyBuilder.fromScaleX;
        this.toScaleX = propertyBuilder.toScaleX;
        this.fromAlpha = propertyBuilder.fromAlpha;
        this.toAlpha = propertyBuilder.toAlpha;
        this.fromRotation = propertyBuilder.rotation;
    }

    /**
     * Method for getting an instance of the {@link PropertyBuilder}.
     *
     * @param view the {@link View}
     * @return the {@link PropertyBuilder}.
     */
    public static PropertyBuilder getPropertyBuilder(final View view) {
        return new PropertyBuilder(view);
    }

    /**
     * Method for getting the translation on X.
     *
     * @return the value of x translation.
     */
    public float getTranslationX() {
        return fromTranslationX;
    }

    /**
     * Method for setting the translation to x.
     *
     * @param toTranslationX the value of x translation.
     */
    private void setToTranslationX(float toTranslationX) {
        this.toTranslationX = toTranslationX;
    }

    /**
     * Method for setting the translation from x.
     *
     * @param fromTranslationX the from translation on x to set.
     */
    private void setFromTranslationX(float fromTranslationX) {
        this.fromTranslationX = fromTranslationX;
    }

    /**
     * Method for getting the translation of y.
     *
     * @return the translation of y.
     */
    public float getTranslationY() {
        return fromTranslationY;
    }

    /**
     * The method for setting the translation from y.
     *
     * @param fromTranslationY the translation from y.
     */
    private void setFromTranslationY(float fromTranslationY) {
        this.fromTranslationY = fromTranslationY;
    }

    /**
     * Method for setting the translation to y.
     *
     * @param toTranslationY the translation to y.
     */
    private void setToTranslationY(float toTranslationY) {
        this.toTranslationY = toTranslationY;
    }

    /**
     * Method for getting the scale on x.
     *
     * @return the scale on x.
     */
    public float getScaleX() {
        return fromScaleX;
    }

    /**
     * Method for setting the scale from x.
     *
     * @param fromScaleX the scale from x.
     */
    private void setFromScaleX(float fromScaleX) {
        this.fromScaleX = fromScaleX;
    }

    /**
     * Method for setting the scale to x.
     *
     * @param toScaleX
     */
    private void setToScaleX(float toScaleX) {
        this.toScaleX = toScaleX;
    }

    /**
     * Method for getting the scale on y.
     *
     * @return the value of scale on y.
     */
    public float getScaleY() {
        return fromScaleY;
    }

    /**
     * Method for setting the scale from y.
     *
     * @param fromScaleY the value of scale from y.
     */
    private void setFromScaleY(float fromScaleY) {
        this.fromScaleY = fromScaleY;
    }

    /**
     * Method for setting the scale to y.
     *
     * @param toScaleY the value of scale to y.
     */
    private void setToScaleY(float toScaleY) {
        this.toScaleY = toScaleY;
    }

    /**
     * Method for getting the alpha.
     *
     * @return the alpha value.
     */
    public float getAlpha() {
        return fromAlpha;
    }

    /**
     * Method for setting the from alpha.
     *
     * @param fromAlpha the from alpha to set.
     */
    private void setFromAlpha(float fromAlpha) {
        this.fromAlpha = fromAlpha;
    }

    /**
     * Method for setting the to alpha value.
     *
     * @param toAlpha the value of to alpha.
     */
    private void setToAlpha(float toAlpha) {
        this.toAlpha = toAlpha;
    }

    /**
     * Method for getting the rotation.
     *
     * @return the rotation value.
     */
    public float getRotation() {
        return fromRotation;
    }

    /**
     * Method for setting the from rotation.
     *
     * @param fromRotation the from rotation.
     */
    private void setFromRotation(float fromRotation) {
        this.fromRotation = fromRotation;
    }

    /**
     * Method for setting the to rotation value.
     *
     * @param toRotation the to rotation.
     */
    private void setToRotation(float toRotation) {
        this.toRotation = toRotation;
    }

    /**
     * Builder class for {@link PropertyAction}.
     */
    public static final class PropertyBuilder {
        private View view;
        private boolean animateAlone;
        private int duration = 300;
        private int delay = 0;
        private Interpolator interpolator = new LinearInterpolator();
        private float fromTranslationX = 0;
        private float toTranslationX = 0;
        private float fromTranslationY = 0;
        private float toTranslationY = 0;
        private float fromScaleY = 1f;
        private float toScaleY = 1f;
        private float fromScaleX = 1f;
        private float toScaleX = 1f;
        private float fromAlpha = 1f;
        private float toAlpha = 1f;
        private float rotation;

        /**
         * Constructor for {@link PropertyBuilder} class.
         *
         * @param view the {@link View} to use.
         */
        private PropertyBuilder(final View view) {
            this.view = view;
        }

        /**
         * Method for creating an instance of a {@link PropertyBuilder}.
         *
         * @return a new instance of a {@link PropertyBuilder}
         */
        public PropertyAction build() {
            return new PropertyAction(this);
        }

        /**
         * Method for setting the duration.
         *
         * @param duration the duration to set.
         * @return the builder to enable chaining.
         */
        public PropertyBuilder duration(int duration) {
            this.duration = duration;
            return this;
        }

        /**
         * Method for setting the delay.
         *
         * @param delay the delay to set.
         * @return the builder to enable chaining.
         */
        public PropertyBuilder delay(int delay) {
            this.delay = delay;
            return this;
        }

        /**
         * Method for setting the translation on x.
         *
         * @param fromTranslationX the translation on x.
         * @return this builder to enable chaining.
         */
        public PropertyBuilder translationX(float fromTranslationX) {
            this.fromTranslationX = fromTranslationX;
            return this;
        }

        /**
         * Method for setting the translation on y.
         *
         * @param fromTranslationY the translation on y.
         * @return this builder to enable chaining.
         */
        public PropertyBuilder translationY(float fromTranslationY) {
            this.fromTranslationY = fromTranslationY;
            return this;
        }

        /**
         * Method for scaling on x.
         *
         * @param fromScaleX the scale on x.
         * @return this builder to enable chaining.
         */
        public PropertyBuilder scaleX(float fromScaleX) {
            this.fromScaleX = fromScaleX;
            return this;
        }

        /**
         * Method for scaling on y.
         *
         * @param fromScaleY the scale on y.
         * @return this builder to enable chaining.
         */
        public PropertyBuilder scaleY(float fromScaleY) {
            this.fromScaleY = fromScaleY;
            return this;
        }

        /**
         * Method for setting the alpha.
         *
         * @param fromAlpha the aplha value.
         * @return this builder to enable chaining.
         */
        public PropertyBuilder alpha(float fromAlpha) {
            this.fromAlpha = fromAlpha;
            return this;
        }

        /**
         * Method for setting the {@link Interpolator}.
         *
         * @param interpolator the {@link Interpolator}.
         * @return this builder to enable chaining.
         */
        public PropertyBuilder interpolator(Interpolator interpolator) {
            this.interpolator = interpolator;
            return this;
        }

        /**
         * Boolean for animating alone.
         *
         * @param shouldWait the boolean value
         * @return this builder to enable chaining.
         */
        public PropertyBuilder animateAlone(final boolean shouldWait) {
            this.animateAlone = shouldWait;
            return this;
        }

        /**
         * Method for setting the rotation.
         *
         * @param rotation the rotation to set.
         * @return this builder to enable chaining.
         */
        public PropertyBuilder rotation(final float rotation) {
            this.rotation = rotation;
            return this;
        }
    }
}
