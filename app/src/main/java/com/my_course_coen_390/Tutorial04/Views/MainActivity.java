package com.my_course_coen_390.Tutorial04.Views;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.my_course_coen_390.Tutorial04.Controllers.ApiClient;
import com.my_course_coen_390.Tutorial04.Controllers.ApiInterface;
import com.my_course_coen_390.Tutorial04.Models.Example;
import com.my_course_coen_390.Tutorial04.R;

public class MainActivity extends AbsRuntimePermission {

    ApiInterface apiInterface;
    final static String appKey = "5dd57642c5ea81c569e59c55ccaeb5e6";

    TextView temp,pressure,humidity;
    Button btn_settings;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        temp = findViewById(R.id.txt_temp);
        pressure = findViewById(R.id.txt_pressure);
        humidity = findViewById(R.id.txt_humidity);

        apiInterface = ApiClient.getRetrofit().create(ApiInterface.class);
        Call<Example> call = apiInterface.getWeather("Montreal", appKey,"metric");

        call.enqueue(new Callback<Example>() {
            @Override
            public void onResponse(Call<Example> call, Response<Example> response) {
                Log.w("MSG_Inbox", response.message());
                if(response.isSuccessful())
                {
                    Example data = response.body();

                    temp.setText("Temperature " + data.getMain().getTemp());
                    pressure.setText("Pressure " + data.getMain().getPressure());
                    humidity.setText("Humidity " + data.getMain().getHumidity());
                }
            }

            @Override
            public void onFailure(Call<Example> call, Throwable t) {
                Toast.makeText(getApplicationContext(),
                        t.getMessage(),
                        Toast.LENGTH_LONG).show();
            }
        });

        btn_settings = findViewById(R.id.btn_settings);
        try {
            btn_settings.setOnClickListener(view -> {
                Intent intent = new Intent(this, Settings.class);
                startActivity(intent);
            });
        }
        catch (Exception exception)
        {
            Intent intent = new Intent(this, Settings.class);
            startActivity(intent);
        }


    }

    @Override
    public void onPermissionsGranted(int requestCode) {

    }
}