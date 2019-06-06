package com.example.weatherforecastbycity;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

public class WeatherAdapter extends RecyclerView.Adapter<WeatherAdapter.WeatherViewHolder> {
    private List<Weather> previsoes;
    private Context context;
    public WeatherAdapter (List <Weather> previsoes, Context context){
        this.previsoes = previsoes;
        this.context = context;
    }

    class WeatherViewHolder extends RecyclerView.ViewHolder{
        WeatherViewHolder (View v){
            super (v);
        }
    }

    @NonNull
    @Override
    public WeatherViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull WeatherViewHolder weatherViewHolder, int i) {
    }

    @Override
    public int getItemCount() {
        return 0;
    }
}

