package com.ayushtyagi.coronameter;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.TextView;

public class DetailActivity extends AppCompatActivity {
private int positionCountry;
TextView tvCases,tvCountry,tvtoday,tvDeaths,tvtoday_Deaths,tvrecovered,tvCritical,tvActive;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        Intent intent=getIntent();
        positionCountry =intent.getIntExtra("position",0);
        getSupportActionBar().setTitle("DETAILS OF "+AffectedCountries.countryModelList.get(positionCountry).getCountry().toUpperCase());
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);


    tvCases=findViewById(R.id.tvCases);
        tvCountry=findViewById(R.id.tvCountries);
        tvtoday=findViewById(R.id.tvtodayCases);
        tvDeaths=findViewById(R.id.tvDeaths);
        tvtoday_Deaths=findViewById(R.id.tvtoday_death);
        tvrecovered=findViewById(R.id.tvRecovered);
        tvCritical=findViewById(R.id.tvCritical);
        tvActive=findViewById(R.id.tvActive);

        tvCountry.setText(AffectedCountries.countryModelList.get(positionCountry).getCountry());
        tvCases.setText(AffectedCountries.countryModelList.get(positionCountry).getCases());
        tvtoday.setText(AffectedCountries.countryModelList.get(positionCountry).getTodaycases());
        tvDeaths.setText(AffectedCountries.countryModelList.get(positionCountry).getDeaths());
        tvtoday_Deaths.setText(AffectedCountries.countryModelList.get(positionCountry).getTodaydeaths());
        tvrecovered.setText(AffectedCountries.countryModelList.get(positionCountry).getRecovered());
        tvCritical.setText(AffectedCountries.countryModelList.get(positionCountry).getCritical());
        tvActive.setText(AffectedCountries.countryModelList.get(positionCountry).getActive());

    }
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        if(item.getItemId()==android.R.id.home);
        finish();
        return super.onOptionsItemSelected(item);

    }
}
