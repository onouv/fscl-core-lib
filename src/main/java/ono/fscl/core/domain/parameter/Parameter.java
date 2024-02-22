package ono.fscl.core.domain.parameter;

import javax.measure.Quantity;
import javax.measure.quantity.Length;
import javax.measure.quantity.Volume;


// TODO: use ddd marker interface Value Object

public class Parameter {

    public enum QuantityType {
        Length,
        Mass,
        Volume;
    };

    public final String name;
    public final QuantityType type;
    public final Quantity<?> quantity;

    public Parameter(String name, QuantityType type, Quantity<?> quantity) {
        this.name = name;
        this.type = type;
        this.quantity = quantity;
    }

    public static Parameter ofLength(String name, Quantity<Length> q) {
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
