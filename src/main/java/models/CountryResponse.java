package models;

import com.google.gson.annotations.SerializedName;

public class CountryResponse {
    @SerializedName("result")
    private CountryInfo[] countryInfo;

    private String[] messages;

    public CountryInfo[] getCountryInfo()
    {
        return countryInfo;
    }

    public void setCountryInfo(CountryInfo[] countryInfo)
    {
        this.countryInfo = countryInfo;
    }

    public String[] getMessages ()
    {
        return messages;
    }

    public void setMessages (String[] messages)
    {
        this.messages = messages;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [countryInfo = "+ countryInfo.length + messagesToString() +"]";
    }

    private String messagesToString(){
        String result = ", messages = ";
        for(String s : this.messages){
            result += "\"" + s + "\"; ";
        }
        return result;
    }
}
