package com.capstone.tubestv.room;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.capstone.tubestv.model.ResultsItem;

import java.util.List;

public class TVSeriesViewModel extends AndroidViewModel {
    private TVSeriesRepository mRepository;
    private LiveData<List<ResultsItem>> mResultsItemsPopular;


    public TVSeriesViewModel(Application application) {
        super(application);
        mRepository = new TVSeriesRepository(application);
        mResultsItemsPopular = mRepository.getAllDataPopular();

    }

    public LiveData<List<ResultsItem>> getAllDataPopular() {
        return mResultsItemsPopular;
    }


    public void insert(ResultsItem resultsItem) { mRepository.insert(resultsItem); }

    public void deleteAllPopular() {mRepository.deleteAllPopular();}

}
