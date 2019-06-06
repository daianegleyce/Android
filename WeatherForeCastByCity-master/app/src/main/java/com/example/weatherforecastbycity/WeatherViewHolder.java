package com.example.weatherforecastbycity;

import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.BitSet;

public class WeatherViewHolder {

    public ImageView conditionImageView;
    public TextView dayTextView;
    public TextView lowTextView;
    public TextView highTextView;
    public TextView humidityTextView;
    private View context;
    private BitSet previsoes;

    WeatherViewHolder (View v){
        super (v);
        conditionImageView = v.findViewById(R.id.conditionImageView);
        dayTextView = v.findViewById(R.id.dayTextView);
        lowTextView = v.findViewById(R.id.lowTextView);
        highTextView = v.findViewById(R.id.highTextView);
        humidityTextView = v.findViewById(R.id.humidityTextView);
    }

    @NonNull
    @Override
    public WeatherViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater inflater = LayoutInflater.from(viewGroup.getContext());
        View raiz = inflater.inflate(R.layout.list_item, viewGroup, false);
        return new WeatherViewHolder (raiz);
    }


    @Override
    public void onBindViewHolder(@NonNull WeatherViewHolder weatherViewHolder, int i) {
        Glide.with(context).load(dadoDeInteresse.iconURL).into(weatherViewHolder.conditionImageView);

        boolean dadoDeInteresse = previsoes.get(i);
        weatherViewHolder.
                dayTextView.
                setText(
                        context.getString(
                                R.string.day_description,
                                dadoDeInteresse.dayOfWeek,
                                dadoDeInteresse.description
                        )
                );
        weatherViewHolder.
                lowTextView.
                setText(
                        context.getString(
                                R.string.low_temp,
                                dadoDeInteresse.minTemp
                        )
                );
        weatherViewHolder.
                highTextView.
                setText(
                        context.getString(
                                R.string.high_temp,
                                dadoDeInteresse.maxTemp
                        )
                );
        weatherViewHolder.
                humidityTextView.
                setText(
                        context.getString(
                                R.string.humidity,
                                dadoDeInteresse.humidity
                        )
                );

    }

    @Override
    public int getItemCount() {
        return this.previsoes.size();
    }

}
