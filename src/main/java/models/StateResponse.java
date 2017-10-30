package models;

import com.google.gson.annotations.SerializedName;

public class StateResponse {
    @SerializedName("RestResponse")
    private CountryResponse CountryResponse;

    public CountryResponse getCountryResponse()
    {
        return CountryResponse;
    }

    public void setCountryResponse(CountryResponse CountryResponse)
    {
        this.CountryResponse = CountryResponse;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [CountryResponse = "+ CountryResponse +"]";
    }
}
