package com.ayushtyagi.coronameter;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.leo.simplearcloader.SimpleArcLoader;

import org.eazegraph.lib.charts.PieChart;
import org.eazegraph.lib.models.PieModel;
import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {
TextView tvCases,tvRecovered,tvCritical,tvDeaths,tvToday,tvCountries,tvActive,tvtoday_deaths;
SimpleArcLoader simpleArcLoader;
        ScrollView scrollView;
PieChart pieChart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    tvCases=findViewById(R.id.tvCases);
        tvRecovered=findViewById(R.id.tvRecovered);
        tvCritical=findViewById(R.id.tvCritical);
        tvDeaths=findViewById(R.id.tvDeaths);
        tvToday=findViewById(R.id.tvToday);
        tvCountries=findViewById(R.id.tvCountries);
        tvActive=findViewById(R.id.tvActive);
        tvtoday_deaths=findViewById(R.id.tvtoday_death);

        scrollView=findViewById(R.id.scrollView);
        simpleArcLoader=findViewById(R.id.loader);
        pieChart=findViewById(R.id.piechart);

        featchData();
    }

   private void featchData() {
       String url = "https://corona.lmao.ninja/v2/all";
      simpleArcLoader.start();
       StringRequest request;
       request = new StringRequest(Request.Method.GET, url,
               new Response.Listener<String>() {
                   @Override
                   public void onResponse(String response) {

                       JSONObject jsonObject = null;
                       try {
                           jsonObject = new JSONObject(response.toString());
                           tvCases.setText(jsonObject.getString("cases"));
                           tvActive.setText(jsonObject.getString("active"));
                           tvDeaths.setText(jsonObject.getString("deaths"));
                           tvRecovered.setText(jsonObject.getString("recovered"));
                           tvCritical.setText(jsonObject.getString("critical"));
                           tvToday.setText(jsonObject.getString("todayCases"));
                           tvtoday_deaths.setText(jsonObject.getString("todayDeaths"));
                           tvCountries.setText(jsonObject.getString("affectedCountries"));

                           pieChart.addPieSlice(new PieModel("Cases", Integer.parseInt(tvCases.getText().toString()), Color.parseColor("#FFA726")));
                           pieChart.addPieSlice(new PieModel("Recovered", Integer.parseInt(tvRecovered.getText().toString()), Color.parseColor("#66BB6A")));
                           pieChart.addPieSlice(new PieModel("Deaths", Integer.parseInt(tvDeaths.getText().toString()), Color.parseColor("#EF5350")));
                           pieChart.addPieSlice(new PieModel("Active", Integer.parseInt(tvActive.getText().toString()), Color.parseColor("#29B6F6")));
                           pieChart.startAnimation();
                        simpleArcLoader.setVisibility(View.GONE);
                         // scrollView.setVisibility(View.VISIBLE);
                           simpleArcLoader.stop();

                       } catch (JSONException e) {
                           e.printStackTrace();
                         simpleArcLoader.stop();
                           simpleArcLoader.setVisibility(View.GONE);
                           scrollView.setVisibility(View.VISIBLE);
                       }
                   }
               }, new Response.ErrorListener() {
           @Override
           public void onErrorResponse(VolleyError error) {
               simpleArcLoader.stop();
               simpleArcLoader.setVisibility(View.GONE);
               scrollView.setVisibility(View.VISIBLE);
               Toast.makeText(MainActivity.this, error.getMessage(), Toast.LENGTH_SHORT).show();
           }
       });
       try {
           RequestQueue requestQueue = Volley.newRequestQueue(this);
           requestQueue.add(request);
       } catch (Exception e) {
           Toast.makeText(this, e.getMessage(), Toast.LENGTH_SHORT).show();
       }
   }
    public void goTrackCountries(View view) {
        startActivity(new Intent(getApplicationContext(),AffectedCountries.class));
    }
}
