package com.epicodus.myrestaurants.adapters;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.epicodus.myrestaurants.R;
import com.epicodus.myrestaurants.models.Restaurant;
import com.epicodus.myrestaurants.ui.RestaurantDetailActivity;
import com.squareup.picasso.Picasso;

import org.parceler.Parcels;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by Guest on 5/2/16.
 */
public class RestaurantViewHolder extends RecyclerView.ViewHolder {
    private ArrayList<Restaurant> mRestaurants = new ArrayList<>();
    @Bind(R.id.restaurantImageView) ImageView mRestaurantImageView;
    @Bind(R.id.restaurantNameTextView) TextView mNameTextView;
    @Bind(R.id.categoryTextView) TextView mCategoryTextView;
    @Bind(R.id.ratingTextView) TextView mRatingTextView;
    private Context mContext;

    private static final int MAX_WIDTH = 200;
    private static final int MAX_HEIGHT = 200;


    public RestaurantViewHolder(View itemView, ArrayList<Restaurant> restaurants) {
        super(itemView);
        mContext = itemView.getContext();
        ButterKnife.bind(this, itemView);
        mRestaurants = restaurants;
        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int itemPosition = getLayoutPosition();
                Intent intent = new Intent(mContext, RestaurantDetailActivity.class);
                intent.putExtra("position", itemPosition + "");
                intent.putExtra("restaurants", Parcels.wrap(mRestaurants));
                mContext.startActivity(intent);
            }
        });
    }

    public void bindRestaurant(Restaurant restaurant) {
        Picasso.with(mContext)
                .load(restaurant.getImageUrl())
                .resize(MAX_WIDTH, MAX_HEIGHT)
                .centerCrop()
                .into(mRestaurantImageView);
        mNameTextView.setText(restaurant.getName());
        mCategoryTextView.setText(restaurant.getCategories().get(0));
        mRatingTextView.setText("Rating: " + restaurant.getRating() + "/5");
    }
}