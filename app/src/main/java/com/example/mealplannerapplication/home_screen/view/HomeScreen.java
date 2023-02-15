package com.example.mealplannerapplication.home_screen.view;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mealplannerapplication.R;
import com.example.mealplannerapplication.home_screen.view.presenter.HomeScreenPresenter;
import com.example.mealplannerapplication.home_screen.view.presenter.HomeScreenPresenterInterface;
import com.example.mealplannerapplication.model.Meal;
import com.example.mealplannerapplication.model.Repository;
import com.example.mealplannerapplication.network.RetrofitClient;

import java.util.ArrayList;

public class HomeScreen extends Fragment implements HomeScreenViewInterface {

    RecyclerView myDailyRec;
    RecyclerView beefRec;
    RecyclerView breakfastRec;
    RecyclerView chickenRec;
    RecyclerView desertRec;
    LinearLayoutManager dailyLayout;
    LinearLayoutManager beefLayout;
    LinearLayoutManager breakfastLayout;
    LinearLayoutManager chickenLayout;
    LinearLayoutManager desertLayout;
    DailyAdapter dailyAdapter;
    HomeScreenPresenterInterface presenterInterface;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initLayouts();
        presenterInterface = new HomeScreenPresenter(this, Repository.getInstance(RetrofitClient.getInstance()));
        presenterInterface.getDailyMeals();
        //presenterInterface.getChickenCategory();

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home_screen, container, false);
        initUI(view);
        dailyAdapter = new DailyAdapter(requireContext(), new ArrayList<>());
        return view;
    }


    @Override
    public void showDailyMeals(ArrayList<Meal> meals) {
        dailyAdapter.setDailyList(meals);
        dailyAdapter.notifyDataSetChanged();
        myDailyRec.setAdapter(dailyAdapter);
    }

    @Override
    public void showCategoryMeals(ArrayList<Meal> meals) {
        dailyAdapter.setDailyList(meals);
        dailyAdapter.notifyDataSetChanged();
        beefRec.setAdapter(dailyAdapter);
    }

    @Override
    public void addMeal(Meal meal) {

    }

    private void initUI(View view){
        myDailyRec = view.findViewById(R.id.daily_rec);
        beefRec = view.findViewById(R.id.beef_rec);
        breakfastRec = view.findViewById(R.id.breakfast_rec);
        chickenRec = view.findViewById(R.id.chicken_rec);
        desertRec = view.findViewById(R.id.desert_rec);

        myDailyRec.setLayoutManager(dailyLayout);
        beefRec.setLayoutManager(beefLayout);
        breakfastRec.setLayoutManager(breakfastLayout);
        chickenRec.setLayoutManager(chickenLayout);
        desertRec.setLayoutManager(desertLayout);
    }

    private void initLayouts(){
        dailyLayout = new LinearLayoutManager(this.getContext());
        dailyLayout.setOrientation(RecyclerView.HORIZONTAL);

        beefLayout = new LinearLayoutManager(this.getContext());
        beefLayout.setOrientation(RecyclerView.HORIZONTAL);

        beefLayout = new LinearLayoutManager(this.getContext());
        beefLayout.setOrientation(RecyclerView.HORIZONTAL);

        breakfastLayout = new LinearLayoutManager(this.getContext());
        breakfastLayout.setOrientation(RecyclerView.HORIZONTAL);

        chickenLayout = new LinearLayoutManager(this.getContext());
        chickenLayout.setOrientation(RecyclerView.HORIZONTAL);

        desertLayout = new LinearLayoutManager(this.getContext());
        desertLayout.setOrientation(RecyclerView.HORIZONTAL);

    }
}