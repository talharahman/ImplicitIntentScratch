package org.pursuit.implicitintentsfromscratch;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import org.pursuit.implicitintentsfromscratch.controller.ZodiacAdapter;
import org.pursuit.implicitintentsfromscratch.model.ZodiacList;
import org.pursuit.implicitintentsfromscratch.network.RetrofitSingleton;
import org.pursuit.implicitintentsfromscratch.network.ZodiacService;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class MainActivity extends AppCompatActivity {
    public static final String TAG = "TAG";
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.zodiac_recyclerview);

        Retrofit retrofit= RetrofitSingleton.getInstance();
        retrofit.create(ZodiacService.class)
                .getZodiac()
                .enqueue(new Callback<ZodiacList>() {
                    @Override
                    public void onResponse(Call<ZodiacList> call, Response<ZodiacList> response) {
                        Log.d(TAG, "onResonse" + response.body().getZodiac().get(0).getName());
                        recyclerView.setAdapter(new ZodiacAdapter(response.body().getZodiac()));
                        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
                    }

                    @Override
                    public void onFailure(Call<ZodiacList> call, Throwable t) {
                        Log.d(TAG, "onFailure");
                    }
                });

    }
}
