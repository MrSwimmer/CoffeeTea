package com.mrswimmer.coffeetea.domain.utils;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;

import com.mrswimmer.coffeetea.data.settings.Screens;
import com.mrswimmer.coffeetea.presentation.auth.fragment.sign_in.SignInFragment;

import ru.terrakok.cicerone.android.SupportFragmentNavigator;

public class LocalNavigator extends SupportFragmentNavigator {

    int currentContainer;

    public LocalNavigator(FragmentManager fragmentManager, int containerId) {
        super(fragmentManager, containerId);
        currentContainer = containerId;
    }

    @Override
    protected Fragment createFragment(String screenKey, Object data) {
        switch (currentContainer) {
            /*case Screens.CONTAINER_MAIN:
                return mainFragments(screenKey);*/
            case Screens.CONTAINER_AUTH:
                return authFragments(screenKey);
            default:
                    return authFragments(screenKey);
        }
    }
    /*public Fragment mainFragments(String screenKey) {
        switch (screenKey) {
            case Screens.MODES_SCREEN:
                return new ModesFragment();
            case Screens.RATE_SCREEN:
                return new RateFragment();
            case Screens.INFO_SCREEN:
                return new InfoFragment();
            case Screens.SETTINGS_SCREEN:
                return new SettingsFragment();
            case Screens.SHOP_SCREEN:
                showSystemMessage("Магазин пока не работает!");
                return new ModesFragment();
            case Screens.PROFILE_SCREEN:
                return new ProfileFragment();
            default:
                return new ModesFragment();
        }
    }
    private Fragment gameFragments(String screenKey, Object data) {
        switch (screenKey) {
            case Screens.GAME_SCREEN:
                return new GameFragment();
            case Screens.RATE_SCREEN:
                return new RateFragment();
            case Screens.SHOP_SCREEN:
                showSystemMessage("Магазин пока не работает!");
                return new GameFragment();
            case Screens.PROFILE_SCREEN:
                return new ProfileFragment();
            case Screens.ZOOM_SCREEN:
                return new ZoomFragment(data);
            default:
                return new ModesFragment();
        }
    }*/

    private Fragment authFragments(String screenKey) {
        switch (screenKey) {
            case Screens.SIGN_IN_SCREEN :
                return new SignInFragment();/*
            case Screens.SIGN_UP_SCREEN :
                return new SignUpFragment();*/
            default:
                return new SignInFragment();
        }
    }

    @Override
    protected void showSystemMessage(String message) {
    }

    @Override
    protected void exit() {
    }
}


