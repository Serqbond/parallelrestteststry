package businessentities;

import com.google.gson.annotations.SerializedName;

public class CountryResponseList {
    @SerializedName("result")
    private CountryInfo[] countryInfos;

    private String[] messages;

    public CountryInfo[] getCountryInfo()    {
        return countryInfos;
    }

    public void setCountryInfo(CountryInfo[] countryInfo)
    {
        this.countryInfos = countryInfo;
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
        return "ClassPojo [countryInfo = "+ countryInfos + messagesToString() +"]";
    }

    private String messagesToString(){
        String result = ", messages = ";
        for(String s : this.messages){
            result += "\"" + s + "\"; ";
        }
        return result;
    }
}
