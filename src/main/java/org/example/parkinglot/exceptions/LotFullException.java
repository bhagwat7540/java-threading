package org.example.parkinglot.exceptions;

import org.example.parkinglot.model.VehicleType;

public class LotFullException extends RuntimeException{
    public LotFullException(VehicleType type) {
        super("No spots for - " + type.toString());
    }
}
