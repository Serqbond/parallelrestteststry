package models.allcountries;

import com.google.gson.annotations.SerializedName;

import java.util.Objects;

public class Result {
    private String name;

    private String alpha2_code;

    @SerializedName("alpha3_code")
    private String alpha3_code;

    public String getName ()
    {
        return name;
    }

    public Result setName (String name)
    {
        this.name = name;
        return this;
    }

    public String getAlpha2_code ()
    {
        return alpha2_code;
    }

    public Result setAlpha2_code (String alpha2_code)
    {
        this.alpha2_code = alpha2_code;
        return this;
    }

    public String getAlpha3_code ()
    {
        return alpha3_code;
    }

    public Result setAlpha3_code (String alpha3_code)
    {
        this.alpha3_code = alpha3_code;
        return this;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [name = "+name+", alpha2_code = "+alpha2_code+", alpha3_code = "+alpha3_code+"]";
    }

    @Override
    public boolean equals(Object o) {
        // self check
        if (this == o)
            return true;
        // null check
        if (o == null)
            return false;
        // type check and cast
        if (getClass() != o.getClass())
            return false;
        Result result = (Result) o;
        // field comparison
        return Objects.equals(name, result.getName())
                && Objects.equals(alpha2_code, result.getAlpha2_code())
                && Objects.equals(alpha3_code, result.getAlpha3_code());
    }
}
