package com.mrswimmer.coffeetea.presentation.main.activity;

import android.support.design.widget.NavigationView;
import android.util.Log;
import android.view.MenuItem;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;
import com.mrswimmer.coffeetea.App;
import com.mrswimmer.coffeetea.R;
import com.mrswimmer.coffeetea.data.settings.Screens;
import com.mrswimmer.coffeetea.di.qualifier.Global;
import com.mrswimmer.coffeetea.di.qualifier.Local;

import javax.inject.Inject;

import ru.terrakok.cicerone.Router;

@InjectViewState
public class MainActivityPresenter extends MvpPresenter<MainActivityView> {
    public MainActivityPresenter() {
        App.getComponent().inject(this);
    }
    @Inject
    @Local
    Router router;

    @Inject
    @Global
    Router globalRouter;

    @Override
    protected void onFirstViewAttach() {
        super.onFirstViewAttach();
        router.newRootScreen(Screens.CATALOG_SCREEN);
    }

    public void setupDrawerContent(NavigationView navigationView) {
        navigationView.setNavigationItemSelectedListener(
                menuItem -> {
                    selectDrawerItem(menuItem);
                    return true;
                });
    }

    private void selectDrawerItem(MenuItem menuItem) {
        switch(menuItem.getItemId()) {
            case R.id.nav_catalog_fragment:
                Log.i("code", "onFirstDrawerTap");
                router.replaceScreen(Screens.CATALOG_SCREEN);
                //fragmentClass = FirstFragment.class;
                break;
            case R.id.nav_sale_fragment:
                router.replaceScreen(Screens.SALE_SCREEN);
                //fragmentClass = SecondFragment.class;
                break;
            case R.id.nav_basket_fragment:
                router.replaceScreen(Screens.BASKET_SCREEN);
                //fragmentClass = ThirdFragment.class;
                break;
            default:
                //fragmentClass = FirstFragment.class;
        }
        menuItem.setChecked(true);
        getViewState().checkDrawerItem(menuItem);
    }
}
