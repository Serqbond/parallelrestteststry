package businessentities.serhii.be.allcountries;

public class AllCountries {
    private RestResponse RestResponse;

    public RestResponse getRestResponse ()
    {
        return RestResponse;
    }

    public void setRestResponse (RestResponse RestResponse)
    {
        this.RestResponse = RestResponse;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [CountryResponse = " + RestResponse + "]";
    }
}
