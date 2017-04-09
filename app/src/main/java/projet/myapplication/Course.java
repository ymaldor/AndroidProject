package projet.myapplication;

/**
 * Created by alex on 09/04/2017.
 */

public class Course {

    private int distance;
    private int id;
    private String location;
    private int latitude;
    private int longitude;
    private double time;

    public Course(int id,int distance, double time, String location, int longitude, int latitude)
    {
        this.id=id;
        this.distance=distance;
        this.location=location;
        this.latitude=latitude;
        this.longitude=longitude;
        this.time=time;
    }
    public int getdist()
    {
        return this.distance;
    }
    public int getid()
    {
        return this.id;
    }
    public String getLocation()
    {
        return this.location;
    }
    public int getLatitude()
    {
        return this.latitude;
    }
    public int getLongitude()
    {
        return this.longitude;
    }
    public double getTime()
    {
        return this.time;
    }



}
