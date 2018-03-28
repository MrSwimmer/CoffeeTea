package com.mrswimmer.coffeetea.presentation.main.fragment.filter;

import android.support.v7.app.AlertDialog;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;
import com.mrswimmer.coffeetea.App;
import com.mrswimmer.coffeetea.R;
import com.mrswimmer.coffeetea.data.model.Product;
import com.mrswimmer.coffeetea.data.settings.Settings;
import com.mrswimmer.coffeetea.di.qualifier.Local;
import com.mrswimmer.coffeetea.domain.service.FireService;

import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import javax.inject.Inject;

import ru.terrakok.cicerone.Router;

@InjectViewState
public class FilterFragmentPresenter extends MvpPresenter<FilterFragmentView> {

    @Inject
    @Local
    Router router;

    @Inject
    FireService fireService;

    public FilterFragmentPresenter() {
        App.getComponent().inject(this);
    }

    public void setSortSpinner(Spinner spinner, SpinnerAdapter adapter) {
        spinner.setAdapter(adapter);
        spinner.setSelection(0);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

            }

            @Override
            public void onNothingSelected(AdapterView<?> arg0) {
            }
        });
    }

    public void setBuilder(AlertDialog.Builder builder, boolean coffeeChecked) {

        final String[] kinds;
        final boolean[] checked = Settings.checked;
        if (coffeeChecked) {
            kinds = Settings.coffeKinds;
        } else {
            kinds = Settings.teaKinds;
        }
        builder.setTitle("Выберите сорта")
                .setCancelable(false)
                .setMultiChoiceItems(kinds, checked,
                        (dialog, which, isChecked) -> checked[which] = isChecked)
                .setPositiveButton("Готово",
                        (dialog, id1) -> {
                            getViewState().setCountKinds(checked, getCountKinds(checked));
                            dialog.cancel();
                        })
                .setNegativeButton("Отмена",
                        (dialog, id12) -> {
                            dialog.cancel();
                        });
        AlertDialog alert = builder.create();
        alert.getWindow().setBackgroundDrawableResource(R.color.brawn);
        alert.show();
    }

    int getCountKinds(boolean[] checked) {
        int count = 0;
        for (int i = 0; i < checked.length; i++) {
            if (checked[0])
                count++;
        }
        Log.i("code", "count " + count);
        return count;
    }

    void updateData(int type, int sort, boolean inSctock, boolean inMyCity, boolean[] kinds) {
        fireService.getProducts(new FireService.ProductsCallback() {
            @Override
            public void onSuccess(List<Product> products) {
                switch (sort) {
                    case 0:
                        Collections.sort(products, (o1, o2) -> o1.getCost()-o2.getCost());
                }

            }

            @Override
            public void onError(Throwable e) {

            }
        });
    }
}
