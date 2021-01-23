package com.tsybulka.logbase.util.parser;

import com.tsybulka.logbase.entity.Cargo;
import com.tsybulka.logbase.entity.Truck;
import com.tsybulka.logbase.util.IdGenerator;

public class TruckParser {

    private static final String NULL = "null";

    public Truck parseTruck(String string) {
        Truck result;
        int truckId = IdGenerator.generateId();
        if (!string.equals(NULL)) {
            boolean isCargoPerishable = Boolean.parseBoolean(string);
            Cargo cargo = new Cargo(isCargoPerishable);
            result = new Truck(truckId, cargo);
        } else {
            result = new Truck(truckId);
        }
        return result;
    }
}
