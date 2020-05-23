package com.example.dineasy;

public class Search
{
    String location;
    double range;
    double rating;
    String search_name;

    public Search( String loc, double ran, double rat, String s_name)
    {
        this.location = loc;
        this.range = range;
        this.rating = rat;
        this.search_name = s_name;
    }

    public String getSLocation()
    {
        return location;
    }

    public double getSRange()
    {
        return range;
    }

    public double getSRating()
    {
        return rating;
    }

    public String getSName()
    {
        return search_name;
    }

    public void setSName(String search_name) {
        this.search_name = search_name;
    }
}
