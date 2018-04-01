package com.example.lanto.tourguide.Reccomended;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;
import android.util.Log;

import com.example.lanto.tourguide.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class getWeatherData extends AsyncTask<Void, Void, String> {

    private static final String baseUrl = "http://api.openweathermap.org/data/2.5/weather?q=Nesselwang&APPID=5eb479aca37616cb69f23de267220aa0";
    private static final String LOG_TAG = getWeatherData.class.getSimpleName();
    private String weatherInfo = "";
    private Context mContext;

    private  com.example.lanto.tourguide.Reccomended.Contract.getRecommendedList mRecommendedList;

    public getWeatherData (com.example.lanto.tourguide.Reccomended.Contract.getRecommendedList recommendedList,
                           Context context){
        mRecommendedList = recommendedList;
        mContext = context;
    }

    @Override
    protected String doInBackground(Void... v) {

        //checking internet connection
        ConnectivityManager connMgr = (ConnectivityManager) mContext.getSystemService(Context.CONNECTIVITY_SERVICE);

        NetworkInfo networkInfo = connMgr.getActiveNetworkInfo();

        if (networkInfo != null && networkInfo.isConnected()) {

            URL Url = null;
            String baseJson = "";
            weatherInfo = "";

            Url = createUrl(baseUrl);
            try {
                baseJson = getJsonResponse(Url);
                weatherInfo = extractInfo(baseJson);
            } catch (IOException e) {
                Log.e(LOG_TAG, "Problem with closing the inputStream oder with disconnection");
            }
        } else weatherInfo = mContext.getString(R.string.warning_internet_connection);

        return weatherInfo;
    }

    private String extractInfo(String baseJson) {
        String weatherInfo = "";

        try{
            JSONObject baseJsonObject = new JSONObject(baseJson);

            JSONArray jsonArray = baseJsonObject.getJSONArray("weather");
            JSONObject weatherConditions = jsonArray.getJSONObject(0);

            weatherInfo = weatherConditions.getString("main");


        } catch (JSONException e){
            Log.e(LOG_TAG, "Problem with extracting the Json");
        }

        return weatherInfo;

    }

    private String getJsonResponse (URL url) throws IOException {
        HttpURLConnection connection = null;
        InputStream inputStream = null;
        String baseJson = "";

        try{
        connection= (HttpURLConnection) url.openConnection();
        connection.setReadTimeout(1000);
        connection.setConnectTimeout(1500);
        connection.setRequestMethod("GET");

        if (connection.getResponseCode() == 200){
            inputStream = connection.getInputStream();
            baseJson = readFromStream(inputStream);
        } else{
            Log.e(LOG_TAG, "The response code is: " + connection.getResponseCode());}

        } catch (IOException e){
            Log.e(LOG_TAG, "Problem with making the HTTPconnection");
        } finally {
            if (connection != null) connection.disconnect();
            if (inputStream != null) inputStream.close();
        }


        return baseJson;
    }

    private String readFromStream(InputStream inputStream) throws IOException {
        StringBuilder output = new StringBuilder();

        if(inputStream != null){
            InputStreamReader reader = new InputStreamReader(inputStream);
            BufferedReader bufferedReader = new BufferedReader(reader);
            String line = bufferedReader.readLine();

            while ( line != null){
                output.append(line);
                line = bufferedReader.readLine();
            }

        } else Log.e(LOG_TAG, "InputStream is null");

        return output.toString();
    }



    private URL createUrl(String baseUrl) {
        URL Url = null;
        try {
            Url = new URL(baseUrl);
        } catch (MalformedURLException e) {
            Log.e(LOG_TAG, "problem with making the URl");
        }
        return Url;
    }



    @Override
    protected void onPostExecute(String weatherCondition) {
        Log.e(LOG_TAG," a string : " + weatherCondition);
        mRecommendedList.isRaining(weatherCondition);

    }

}
