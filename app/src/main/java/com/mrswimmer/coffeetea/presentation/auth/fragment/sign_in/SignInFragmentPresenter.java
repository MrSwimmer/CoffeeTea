package com.mrswimmer.coffeetea.presentation.auth.fragment.sign_in;

import android.content.SharedPreferences;
import android.transition.Scene;
import android.util.Log;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.mrswimmer.coffeetea.App;
import com.mrswimmer.coffeetea.data.model.Availability;
import com.mrswimmer.coffeetea.data.model.Product;
import com.mrswimmer.coffeetea.data.settings.Screens;
import com.mrswimmer.coffeetea.di.qualifier.Global;
import com.mrswimmer.coffeetea.di.qualifier.Local;
import com.mrswimmer.coffeetea.domain.service.FireService;

import java.util.ArrayList;

import javax.inject.Inject;

import ru.terrakok.cicerone.Router;

@InjectViewState
public class SignInFragmentPresenter extends MvpPresenter<SignInFragmentView> {
    @Inject
    @Local
    Router router;

    @Inject
    @Global
    Router globalRouter;

    @Inject
    SharedPreferences settings;

    @Inject
    FireService fireService;
    private DatabaseReference reference = FirebaseDatabase.getInstance().getReference();

    public SignInFragmentPresenter() {
        App.getComponent().inject(this);
    }

    void enter(String email, String pass) {
        fireService.signIn(email, pass, new FireService.AuthCallBack() {
            @Override
            public void onSuccess(boolean success) {
                globalRouter.navigateTo(Screens.MAIN_ACTIVITY);
            }

            @Override
            public void onError(Throwable e) {
                getViewState().showErrorToast(":(");
            }
        });
    }

    void gotoReg() {
        //fireService.getProducts();
        DatabaseReference newProd = reference.child("products").push();
        ArrayList<String> images = new ArrayList<>();
        images.add("http://heaclub.ru/tim/673c999977399788744cde08181b449d.jpg");
        images.add("url2");
        ArrayList<Availability> availabilities = new ArrayList<>();
        availabilities.add(new Availability(2, "0123"));
        availabilities.add(new Availability(4, "456"));
        newProd.setValue(new Product(newProd.getKey(), 100, "OK", "Шмаль", 199, images, availabilities, 1, 3, 5));
        newProd = reference.child("products").push();
        newProd.setValue(new Product(newProd.getKey(), 150, "OK", "Волшебный чай", 99, images, availabilities, 1, 2, 4));
        newProd = reference.child("products").push();
        newProd.setValue(new Product(newProd.getKey(), 200, "OK", "Ядреный кофе", 149, images, availabilities, 0, 1, 2));
        newProd = reference.child("products").push();
        newProd.setValue(new Product(newProd.getKey(), 100, "OK", "эКспрессо", 499, images, availabilities, 0, 3, 3));
        Log.i("code", "OK");
        router.navigateTo(Screens.SIGN_UP_SCREEN);
    }

    void goToMain() {
        /*DatabaseReference newProd = reference.child("products").push();
        ArrayList<String> images = new ArrayList<>();
        images.add("url1");
        images.add("url2");
        ArrayList<Availability> availabilities = new ArrayList<>();
        availabilities.add(new Availability(2, "0123"));
        availabilities.add(new Availability(4, "456"));
        newProd.setValue(new Product(newProd.getKey(), 100, "ok", "coffee1", 150, images, availabilities));
        Log.i("code", "OK");*/
        SharedPreferences.Editor editor = settings.edit();
        globalRouter.navigateTo(Screens.MAIN_ACTIVITY);
    }
}
