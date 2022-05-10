package com.oop.agency.object;

import com.oop.agency.model.City;
import com.oop.agency.repository.CityRepository;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class CityList {

    private static CityList instance = new CityList();

    private CityList(){}

    public static CityList getInstance(){
        return instance;
    }

    public ObservableList<City> getList(CityRepository cityRepository){
        return FXCollections.observableArrayList(cityRepository.findAll());
    }
}
