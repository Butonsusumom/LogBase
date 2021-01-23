package com.tsybulka.logbase.comparator;

import com.tsybulka.logbase.entity.Cargo;
import com.tsybulka.logbase.entity.Truck;

import java.util.Comparator;

public class TruckComparator implements Comparator<Truck> {

    @Override
    public int compare(Truck o1, Truck o2) {
        int result = 0;
        if (o1.isLoaded() && o2.isLoaded()) {
            Cargo cargo1 = o1.getCargo().orElseThrow();
            Cargo cargo2 = o2.getCargo().orElseThrow();
            result = Boolean.compare(cargo2.isPerishable(), cargo1.isPerishable());
        } else if (o1.isLoaded()) {
            Cargo cargo = o1.getCargo().orElseThrow();
            result = cargo.isPerishable() ? -1 : 0;
        } else if (o2.isLoaded()) {
            Cargo cargo = o2.getCargo().orElseThrow();
            result = cargo.isPerishable() ? 1 : 0;
        }
        return result;
    }
}
