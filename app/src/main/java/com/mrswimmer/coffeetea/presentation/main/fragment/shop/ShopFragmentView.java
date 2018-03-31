package com.mrswimmer.coffeetea.presentation.main.fragment.shop;

import com.mrswimmer.coffeetea.data.base.BaseView;
import com.mrswimmer.coffeetea.data.model.Review;

import java.util.ArrayList;

interface ShopFragmentView extends BaseView {
    void initAdapter(ArrayList<Review> reviews);
}
