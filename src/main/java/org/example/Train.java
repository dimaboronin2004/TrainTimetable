package org.example;

import java.util.HashSet;
import java.util.Set;

public final class Train {
    private final String name;
    private final int hours;
    private final int mins;
    private final String dst;

    Train(String name, int hours, int mins, String dst) {
        if (hours < 0 || hours > 23 || mins < 0 || mins > 60)
            throw new IllegalArgumentException("Wrong time params");
        this.name = name;
        this.hours = hours;
        this.mins = mins;
        this.dst = dst;
    }

    private final Set<String> setOfStations = new HashSet<>();

    public void add(String station) {
        setOfStations.add(station);
    }

    public void delete(String station) {
        setOfStations.remove(station);
    }

    public String getName() {
        return name;
    }

    public String getDst() {
        return dst;
    }

    public int getHours() {
        return hours;
    }

    public int getMins() {
        return mins;
    }

    @Override
    public String toString() {
        return name + " " + hours + ":" + mins + " " + dst;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj instanceof Train) {
            Train another = (Train) obj;
            return this.name.equals(another.name)
                    && this.hours == another.hours
                    && this.mins == another.mins
                    && this.dst.equals(another.dst);
        } else return false;
    }
}
