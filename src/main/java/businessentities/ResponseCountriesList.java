package businessentities;

import com.google.gson.annotations.SerializedName;

public class ResponseCountriesList {

    @SerializedName("RestResponse")
    private CountryResponseList countryResponseList;

    public CountryResponseList getCountryResponse()
    {
        return countryResponseList;
    }

    public void setCountryResponse(CountryResponseList countryResponseList) {
        this.countryResponseList = countryResponseList;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [CountryResponse = "+ countryResponseList +"]";
    }
}
