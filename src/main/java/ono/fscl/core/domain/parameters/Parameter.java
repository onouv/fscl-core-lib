package ono.fscl.core.domain.parameters;

import java.util.Map;

import javax.measure.Quantity;
import javax.measure.quantity.Length;
import javax.measure.quantity.Mass;
import javax.measure.quantity.Volume;

import lombok.Value;

// TODO: use ddd marker interface Value Object

public class Parameter<Q extends Quantity> {
    private final String name;
    private final Quantity<?> value;

    public static Parameter<Quantity<Length>>  lengthParameter(String name, Length value) {
        return new Parameter(name, value);
    }

    public static Parameter<Quantity<Volume>>  lengthParameter(String name, Volume value) {
        return new Parameter(name, value);
    }

    public static Parameter<Quantity<Mass>>  lengthParameter(String name, Mass value) {
        return new Parameter(name, value);
    }

    public Parameter(String name, Quantity<?> value) {
        this.name = name;
        this.value = value;
    }
}
