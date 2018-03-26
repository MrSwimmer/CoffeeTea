package com.mrswimmer.coffeetea.di;

import com.mrswimmer.coffeetea.di.module.FireModule;
import com.mrswimmer.coffeetea.di.module.NavigatorModule;
import com.mrswimmer.coffeetea.di.module.SharedPreferencesModule;
import com.mrswimmer.coffeetea.presentation.auth.activity.AuthActivity;
import com.mrswimmer.coffeetea.presentation.auth.fragment.sign_in.SignInFragmentPresenter;
import com.mrswimmer.coffeetea.presentation.auth.fragment.sign_up.SignUpFragmentPresenter;
import com.mrswimmer.coffeetea.presentation.main.activity.MainActivity;
import com.mrswimmer.coffeetea.presentation.main.activity.MainActivityPresenter;
import com.mrswimmer.coffeetea.presentation.main.fragment.basket.BasketFragmentPresenter;
import com.mrswimmer.coffeetea.presentation.main.fragment.catalog.CatalogFragmentPresenter;
import com.mrswimmer.coffeetea.presentation.main.fragment.filter.FilterFragmentPresenter;
import com.mrswimmer.coffeetea.presentation.main.fragment.sale.SaleFragmentPresenter;
import com.mrswimmer.coffeetea.presentation.splash.SplashActivity;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {SharedPreferencesModule.class, NavigatorModule.class, FireModule.class})
public interface AppComponent {
    void inject(SplashActivity splashActivity);
    void inject(MainActivity mainActivity);
    void inject(AuthActivity authActivity);
    void inject(SignInFragmentPresenter signInFragmentPresenter);
    void inject(SignUpFragmentPresenter signUpFragmentPresenter);
    void inject(MainActivityPresenter mainActivityPresenter);
    void inject(CatalogFragmentPresenter catalogFragmentPresenter);

    void inject(SaleFragmentPresenter saleFragmentPresenter);

    void inject(BasketFragmentPresenter basketFragmentPresenter);

    void inject(FilterFragmentPresenter filterFragmentPresenter);
}
