package com.igor.otakunews.data.local;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.igor.otakunews.domain.News;

@Database(entities = {News.class}, version = 1)
public abstract class OtakuNewsDb extends RoomDatabase {
    public abstract NewsDao newsDao();
}
