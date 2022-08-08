package com.igor.otakunews.data.remote;

import androidx.room.Room;

import com.igor.otakunews.data.local.OtakuNewsDb;
import com.igor.otakunews.App;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class OtakuNewsRepository {

    //region Constantes
    private static final String REMOTE_API_URL = "https://igorsy.github.io/OtakuNewsApi/";
    private static final String LOCAL_DB_NAME = "OtakuNews";

    private OtakuNewsApi remoteApi;
    private OtakuNewsDb localDb;

    public OtakuNewsApi getRemoteApi() {
        return remoteApi;
    }

    public OtakuNewsDb getLocalDb() {
        return localDb;
    }
    //endregion

    //region Singleton: garante uma instância única dos atributos relacionados ao Retrofit e Room.
    private OtakuNewsRepository () {
        remoteApi = new Retrofit.Builder()
                .baseUrl(REMOTE_API_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(OtakuNewsApi.class);

        localDb = Room.databaseBuilder(App.getInstance(), OtakuNewsDb.class, LOCAL_DB_NAME).build();
    }

    public static OtakuNewsRepository getInstance() { return LazyHolder.INSTANCE; }

    private static class LazyHolder {
        private static final OtakuNewsRepository INSTANCE = new OtakuNewsRepository();
    }
    //endregion
}
