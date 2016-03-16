package com.animations.indanimator;

import android.os.Handler;
import android.view.View;
import android.view.ViewTreeObserver;

import com.animations.indanimator.actions.BaseAction;
import com.animations.indanimator.listeners.INDAnimatorEndListener;
import com.animations.indanimator.listeners.INDAnimatorStartListener;

import java.util.ArrayList;
import java.util.List;

/**
 * The class that runs all the animations.
 */
public class INDAnimator {

    /**
     * {@link List} of {@link BaseAction}s.
     */
    private List<List<BaseAction>> list;

    /**
     * The {@link INDAnimatorStartListener} for listening the start of the animation.
     */
    private INDAnimatorStartListener INDAnimatorStartListener;

    /**
     * The {@link INDAnimatorEndListener} for listening the end of the animation.
     */
    private INDAnimatorEndListener INDAnimatorEndListener;

    /**
     * The int value of loop time.
     */
    private int loopTime = -1;

    /**
     * {@link Handler} for posting animations.
     */
    final Handler handler = new Handler();

    /**
     * Private constructor for this class.
     */
    private INDAnimator() {
        list = new ArrayList<>();
        list.add(new ArrayList<BaseAction>());
    }

    /**
     * Method for creating an instance of this object.
     *
     * @return a new instancve of this object.
     */
    public static INDAnimator init() {
        return new INDAnimator();
    }

    /**
     * Method for animating an action.
     *
     * @param action the action to animate.
     * @return this object.
     */
    public INDAnimator animate(final BaseAction action) {
        final List<BaseAction> peek = list.get(list.size() - 1);
        if (peek == null) {
            throw new IllegalArgumentException("There is no actions.");
        }
        peek.add(action);
        return this;
    }

    /**
     * Method for adding an action to this {@link INDAnimator} object.
     *
     * @return this object.
     */
    public INDAnimator add() {
        list.add(new ArrayList<BaseAction>());
        return this;
    }

    /**
     * Loop animation
     *
     * @param loopTime 0 if infinity loop
     *
     *  @return this object.
     */
    public INDAnimator loop(int loopTime) {
        this.loopTime = loopTime;
        return this;
    }

    /**
     * Method for playing the list of actions.
     */
    public void play() {
        final View firstView = getFirstView();
        if (firstView == null) {
            return;
        }
        firstView.getViewTreeObserver().addOnPreDrawListener(new ViewTreeObserver.OnPreDrawListener() {
            @Override
            public boolean onPreDraw() {
                firstView.getViewTreeObserver().removeOnPreDrawListener(this);
                initAll();
                animateAll();
                return true;
            }
        });
    }

    /**
     * Method for getting the first {@link View}.
     *
     * @return the first view.
     */
    private View getFirstView() {
        final List<BaseAction> baseActions = list.get(0);
        if (baseActions != null) {
            final BaseAction baseAction = baseActions.get(0);
            if (baseAction != null) {
                return baseAction.getView();
            }
        }
        return null;
    }

    private void initAll() {
        for (final List<BaseAction> baseActions : list) {
            for (final BaseAction baseAction : baseActions) {
                final View view = baseAction.getView();
                baseAction.init(view);
            }
        }
    }

    /**
     * Method for animating all.
     */
    private void animateAll() {
        if (INDAnimatorStartListener != null) {
            INDAnimatorStartListener.onStart();
        }
        int durationCounter = 0;
        for (int i = 0; i < list.size(); i++) {
            final List<BaseAction> baseActions = list.get(i);
            final int longestDuration = getLongestDuration(baseActions);
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    animateAllBaseActions(baseActions);
                }
            }, durationCounter);
            durationCounter += longestDuration;
        }
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                if (INDAnimatorEndListener != null) {
                    INDAnimatorEndListener.onEnd();
                }
                if (loopTime > 0) {
                    --loopTime;
                }
                if (loopTime != 0) {
                    animateAll();
                }
            }
        }, durationCounter);
    }

    /**
     * Method for getting the longest duration in a {@link List} of {@link BaseAction}.
     *
     * @param actions the list of actions.
     * @return the int value of duration.
     */
    private int getLongestDuration(final List<BaseAction> actions) {
        int maxDuration = 0;
        for (final BaseAction action : actions) {
            if (!action.isAnimateAlone() && action.getDuration() > maxDuration) {
                maxDuration = action.getDuration() + action.getDelay();
            }
        }
        return maxDuration;
    }

    /**
     * Method for animating the base actions.
     *
     * @param actions the {@link List} of {@link BaseAction}.
     */
    private void animateAllBaseActions(final List<BaseAction> actions) {
        for (final BaseAction action : actions) {
            final View view = action.getView();
            action.animate(view);
        }
    }

    /**
     * Method for setting the {@link INDAnimatorStartListener} for this object.
     *
     * @param INDAnimatorStartListener the {@link INDAnimatorStartListener}.
     * @return this object.
     */
    public INDAnimator setINDAnimatorStartListener(final INDAnimatorStartListener INDAnimatorStartListener) {
        this.INDAnimatorStartListener = INDAnimatorStartListener;
        return this;
    }

    /**
     * Method for setting the {@link INDAnimatorEndListener} for this object.
     *
     * @param INDAnimatorEndListener the {@link INDAnimatorEndListener}.
     * @return this object.
     */
    public INDAnimator setINDAnimatorEndListener(final INDAnimatorEndListener INDAnimatorEndListener) {
        this.INDAnimatorEndListener = INDAnimatorEndListener;
        return this;
    }
}
