package com.mrswimmer.coffeetea.presentation.main.fragment.filter;

import android.app.Dialog;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.TextView;
import android.widget.Toast;

import com.arellomobile.mvp.MvpAppCompatFragment;
import com.arellomobile.mvp.presenter.InjectPresenter;
import com.arellomobile.mvp.presenter.ProvidePresenter;
import com.mrswimmer.coffeetea.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnCheckedChanged;
import butterknife.OnClick;

public class FilterFragment extends MvpAppCompatFragment implements FilterFragmentView {

    @InjectPresenter
    FilterFragmentPresenter presenter;

    @ProvidePresenter
    public FilterFragmentPresenter presenter() {
        return new FilterFragmentPresenter();
    }

    @BindView(R.id.filter_radio_coffee)
    RadioButton radioCoffee;
    @BindView(R.id.filter_radio_tea)
    RadioButton radioTea;
    @BindView(R.id.filter_spinner_sort)
    Spinner spinner;
    @BindView(R.id.filter_choose_kinds)
    Button chooseKindButton;
    @BindView(R.id.filter_count_kinds_text)
    TextView countKindsText;
    @BindView(R.id.filter_check_in_my_city)
    CheckBox inMyCityCheck;
    @BindView(R.id.filter_check_in_stock)
    Button inStockCheck;

    String[] sorts = {"По цене ↑", "По цене ↓", "По весу ↑", "По весу ↓"};

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_filter, container, false);
        return v;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ButterKnife.bind(this, view);
        SpinnerAdapter adapter = new ArrayAdapter<String>(getActivity(), R.layout.sign_up_spinner_item, sorts);
        presenter.setSortSpinner(spinner, adapter);
    }

    @OnClick(R.id.filter_choose_kinds)
    void onChooseKindClick() {
        //onCreateDialog(0);
    }

    @OnClick(R.id.filter_show_button)
    void onShowResultsClick() {

    }


    /*@Override
    public AlertDialog onCreateDialog(int id) {
        final boolean[] mCheckedItems = {false, true, false};
        final String[] checkCatsName = {"Васька", "Рыжик", "Мурзик"};
        AlertDialog.Builder builder;
        builder = new AlertDialog.Builder(getActivity());
        builder.setTitle("Выберите котов")
                .setCancelable(false)
                .setMultiChoiceItems(checkCatsName, mCheckedItems,
                        (dialog, which, isChecked) -> mCheckedItems[which] = isChecked)
                // Добавляем кнопки
                .setPositiveButton("Готово",
                        (dialog, id1) -> {

                        })
                .setNegativeButton("Отмена",
                        (dialog, id12) -> dialog.cancel());
        return builder.create();
    }*/
}
