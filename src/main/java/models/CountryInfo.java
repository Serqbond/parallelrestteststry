package models;

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

    public CountryInfo setLargest_city (String largest_city)    {
        this.largestCity = largest_city;
        return this;
    }

    public String getArea ()
    {
        return area;
    }

    public CountryInfo setArea (String area)    {
        this.area = area;
        return this;
    }

    public String getName ()
    {
        return name;
    }

    public CountryInfo setName (String name)    {
        this.name = name;
        return this;
    }

    public String getAbbr ()
    {
        return abbr;
    }

    public CountryInfo setAbbr (String abbr)    {
        this.abbr = abbr;
        return this;
    }

    public String getCapital ()
    {
        return capital;
    }

    public CountryInfo setCapital (String capital)    {
        this.capital = capital;
        return this;
    }

    public String getCountry ()
    {
        return country;
    }

    public CountryInfo setCountry (String country)    {
        this.country = country;
        return this;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [largest_city = "+largestCity+", area = "+area+", name = "+name+", abbr = "+abbr+", capital = "+capital+", country = "+country+"]";
    }
}
