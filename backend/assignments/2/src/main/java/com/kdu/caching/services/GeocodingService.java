package com.kdu.caching.services;


import com.kdu.caching.constants.APIConstants;
import com.kdu.caching.dto.error.ErrorDTO;
import com.kdu.caching.entities.Coordinate;
import com.kdu.caching.exceptions.custom.CustomException;
import com.kdu.caching.exceptions.custom.InvalidArgumentsException;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.json.JSONObject;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.util.UriComponentsBuilder;


@Service
public class GeocodingService {


    /**
     * Calls 3rd party API to fetch Coordinates of required location address
     * @param coordinate of required location
     * @return
     */
    public JSONObject revGeoCodingAPICall(Coordinate coordinate){

        String url = UriComponentsBuilder.fromUriString(APIConstants.REV_URL).queryParam("access_key", APIConstants.API_KEY).queryParam("query",coordinate.getLatitude() + "," + coordinate.getLongitude()).build().toUriString();

        OkHttpClient client = new OkHttpClient().newBuilder().build();
        Request request = new Request.Builder().url(url).method("GET", null).build();

        try (Response response = client.newCall(request).execute()) {
            if (!response.isSuccessful()) throw new InvalidArgumentsException( new ErrorDTO("Unexpected code: " + response, HttpStatus.UNPROCESSABLE_ENTITY));
            return new JSONObject(response.body().string()).getJSONArray("data").getJSONObject(0);
        } catch (Exception e) {
            throw new CustomException( new ErrorDTO("Invalid Coordinates", HttpStatus.BAD_REQUEST));
        }
    }


    /**
     * 3rd Party API calling service which will just call and respond with appropriate address of location
     * @param address
     * @return
     */
    public JSONObject geoCodingAPICall(String address){
        String url = UriComponentsBuilder.fromUriString(APIConstants.GEO_URL).queryParam("query",address).queryParam("access_key", APIConstants.API_KEY).build().toUriString();

        OkHttpClient client = new OkHttpClient().newBuilder().build();
        Request request = new Request.Builder().url(url).method("GET", null).build();

        try (Response response = client.newCall(request).execute()){
            if (!response.isSuccessful()) throw new InvalidArgumentsException( new ErrorDTO("Unexpected code: " + response, HttpStatus.UNPROCESSABLE_ENTITY));
            return new JSONObject(response.body().string()).getJSONArray("data").getJSONObject(0);
        } catch (Exception e) {
            throw new CustomException(new ErrorDTO("Invalid Address parameter", HttpStatus.BAD_REQUEST));
        }
    }
}
