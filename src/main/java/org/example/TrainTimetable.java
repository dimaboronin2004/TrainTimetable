package org.example;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public final class TrainTimetable {
    private final Set<Train> setOfTrains = new HashSet<>();

    public void addTrain(String name, int hours, int mins, String dst) {
        setOfTrains.add(new Train(name, hours, mins, dst));
    }

    public void deleteTrain(String name, int hours, int mins, String dst) {
        setOfTrains.remove(new Train(name, hours, mins, dst));
    }

    public void addStation(Train train, String station) {
        if (setOfTrains.contains(train)) train.add(station);
        else throw new IllegalArgumentException("No such train in a timetable");
    }

    public void deleteStation(Train train, String station) {
        if (setOfTrains.contains(train)) train.delete(station);
        else throw new IllegalArgumentException("No such train in a timetable");
    }

    public Train findNearest(String dst, int hours, int mins) {
        Train res = new Train("", 0, 0, "");
        int min = 1_000_000;
        for (Train train : setOfTrains) {
            if (train.getDst().equals(dst)) {
                int diff = (train.getHours() * 60 + train.getMins()) - (hours + mins);
                if (diff < min) {
                    min = diff;
                    res = new Train(train.getName(), train.getHours(), train.getMins(), train.getDst());
                }
            }
        }
        return res;
    }

    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();
        for (Train train: setOfTrains) {
            s.append(train.toString()).append("\n");
        }
        return s.toString();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj instanceof TrainTimetable) {
            TrainTimetable another = (TrainTimetable) obj;
            if (this.setOfTrains.size() != another.setOfTrains.size()) return false;
            boolean flag = true;
            for (Train train: this.setOfTrains) {
                if (!another.setOfTrains.contains(train)) {
                    flag = false;
                    break;
                }
            }
            return flag;
        }
        else return false;
    }
}
