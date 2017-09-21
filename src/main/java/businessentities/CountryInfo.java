package businessentities;

import com.google.gson.annotations.SerializedName;

public class CountryInfo {
    @SerializedName("largest_city")
    private String largestCity;

    private String area;

    private String name;

    private String abbr;

    private String capital;

    private String country;

    public String getLargestCity ()
    {
        return largestCity;
    }

    public void setLargest_city (String largest_city)
    {
        this.largestCity = largest_city;
    }

    public String getArea ()
    {
        return area;
    }

    public void setArea (String area)
    {
        this.area = area;
    }

    public String getName ()
    {
        return name;
    }

    public void setName (String name)
    {
        this.name = name;
    }

    public String getAbbr ()
    {
        return abbr;
    }

    public void setAbbr (String abbr)
    {
        this.abbr = abbr;
    }

    public String getCapital ()
    {
        return capital;
    }

    public void setCapital (String capital)
    {
        this.capital = capital;
    }

    public String getCountry ()
    {
        return country;
    }

    public void setCountry (String country)
    {
        this.country = country;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [largest_city = "+largestCity+", area = "+area+", name = "+name+", abbr = "+abbr+", capital = "+capital+", country = "+country+"]";
    }
}
