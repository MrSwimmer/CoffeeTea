package com.mrswimmer.coffeetea.presentation.main.fragment.product;

import android.content.Intent;
import android.util.Log;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;
import com.mrswimmer.coffeetea.App;
import com.mrswimmer.coffeetea.data.model.Review;
import com.mrswimmer.coffeetea.data.model.Shop;
import com.mrswimmer.coffeetea.data.model.product.Availability;
import com.mrswimmer.coffeetea.data.model.product.Product;
import com.mrswimmer.coffeetea.data.settings.Screens;
import com.mrswimmer.coffeetea.di.qualifier.Local;
import com.mrswimmer.coffeetea.domain.service.FireService;

import java.util.ArrayList;

import javax.inject.Inject;

import ru.terrakok.cicerone.Router;

@InjectViewState
public class ProductFragmentPresenter extends MvpPresenter<ProductFragmentView> {

    String id;
    public static Product curProduct;
    public static int countShops = 0;
    @Inject
    FireService fireService;

    @Inject
    @Local
    Router router;

    @Inject
    public ProductFragmentPresenter() {
        App.getComponent().inject(this);
    }

    public void getProduct(String id) {
        this.id = id;
        fireService.getProduct(id, new FireService.ProductCallback() {
            @Override
            public void onSuccess(Product product) {
                curProduct = product;
                Log.i("code", "prod name " + product.getName());
                getViewState().setProduct(product);
            }

            @Override
            public void onError(Throwable e) {
                Log.i("code", "prod name error " + e);
            }
        });
    }

    public void gotoReviews() {

        router.navigateTo(Screens.REVIEWS_SCREEN, id);
    }

    public void gotoShops() {
        ArrayList<Availability> availabilities = new ArrayList<>();
        availabilities = curProduct.getAvailabilities();
        router.navigateTo(Screens.SHOP_SCREEN_TOUCHABLE, availabilities);
    }

    public void chooseCount() {
        ArrayList<Availability> availabilities = new ArrayList<>();
        availabilities = curProduct.getAvailabilities();
        int max = 0;
        for (int i = 0; i < availabilities.size(); i++) {
            if (availabilities.get(i).getQuantity() > max)
                max = availabilities.get(i).getQuantity();
        }
        getViewState().showChooseCountDialog(max);
    }

    public void gotoChooseShop(int max) {
        ArrayList<Availability> availabilities = curProduct.getAvailabilities();
        for (int i = 0; i < availabilities.size(); i++) {
            if (availabilities.get(i).getQuantity() >= max)
                countShops++;
        }/*
        router.navigateTo(Screens.SHOP_SCREEN_CHOOSE, ids);*/

        router.navigateTo(Screens.SHOP_SCREEN_CHOOSE);
    }
}
