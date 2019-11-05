package models;

import java.util.Objects;

public class TempData {
    private String location;
    private long time;
    private int temperature;

    public TempData(String location, long time, int temperature) {
        this.location = location;
        this.time = time;
        this.temperature = temperature;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public long getTime() {
        return time;
    }

    public void setTime(long time) {
        this.time = time;
    }

    public int getTemperature() {
        return temperature;
    }

    public void setTemperature(int temperature) {
        this.temperature = temperature;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TempData tempData = (TempData) o;
        return time == tempData.time &&
                temperature == tempData.temperature &&
                Objects.equals(location, tempData.location);
    }

    @Override
    public int hashCode() {
        return Objects.hash(location, time, temperature);
    }

    @Override
    public String toString() {
        return "TempData{" +
                "location='" + location + '\'' +
                ", time=" + time +
                ", temperature=" + temperature +
                '}';
    }
}
