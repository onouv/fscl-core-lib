package ono.fscl.core.domain.parameter;

import javax.measure.Quantity;
import javax.measure.quantity.Length;
import javax.measure.quantity.Volume;


public class Parameter {

    public enum QuantityType {
        Length,
        Mass,
        Volume;
    };

    public final String name;
    public final QuantityType type;
    private final Quantity<?> quantity;

    public Parameter(String name, QuantityType type, Quantity<?> quantity) {
        this.name = name;
        this.type = type;
        this.quantity = quantity;
    }

    public static Parameter of(String name, Quantity<Length> q) {
        return new Parameter(name, QuantityType.Length, q);
    }

    @SuppressWarnings("unchecked")
    Quantity<Length> toLength() throws QuantityTypeException {
        if(this.type == QuantityType.Length) {
            try {
                return (Quantity<Length>) this.quantity;
            } catch (ClassCastException e) {
                throw new QuantityTypeException( e.getMessage());
            }
        }

        throw new QuantityTypeException("Not a Length quantity type");
    }

    Quantity<Volume> toVolume() throws QuantityTypeException {
        if(this.type == QuantityType.Volume) {
            try {
                return (Quantity<Volume>) this.quantity;
            } catch (ClassCastException e) {
                throw new QuantityTypeException( e.getMessage());
            }
        }

        throw new QuantityTypeException("Not a Volume quantity type");
    }
} 


/*

// TODO: use ddd marker interface Value Object

public final class Parameter {
    
    public final Quantity<Q extends Quantity> value;

    public static Parameter  of(String name, Length value) {
        return new Parameter(name, value);
    }

    public static Parameter<Quantity<Volume>>  of(String name, Volume value) {
        return new Parameter<Quantity<Volume>>(name, value);
    }

    public static Parameter<Quantity<Mass>>  of(String name, Mass value) {
        return new Parameter<Quantity<Mass>>(name, value);
    }

    public Parameter(String name, Quantity<?> value) {
        this.name = name;
        this.value = value;
    }
}
*/