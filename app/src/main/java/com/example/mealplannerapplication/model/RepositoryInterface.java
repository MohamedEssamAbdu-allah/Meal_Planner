package com.example.mealplannerapplication.model;

import com.example.mealplannerapplication.network.NetworkInterface;

public interface RepositoryInterface {
    void getDailyMeal(NetworkInterface networkInterfaceRef);
}
