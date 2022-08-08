package com.igor.otakunews.ui.favorites;

import android.os.AsyncTask;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.igor.otakunews.domain.News;
import com.igor.otakunews.data.remote.OtakuNewsRepository;

import java.util.List;

public class FavoritesViewModel extends ViewModel {

    public FavoritesViewModel() {

    }

    public LiveData<List<News>> loadFavoriteNews() {
        return OtakuNewsRepository.getInstance().getLocalDb().newsDao().loadFavoriteNews();
    }

    public void saveNews(News news) {
        AsyncTask.execute(() -> OtakuNewsRepository.getInstance().getLocalDb().newsDao().save(news));
    }

}