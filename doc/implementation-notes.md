
# RegExp for complete FUNCTION code

```Java
public static final String REGEXP = "=(\\d{1,4}|[A-Z]{1,4}|[a-z]{1,4})(.\\d{1,4}|.[A-Z]{1,4}|.[a-z]{1,4})*";
```

> [!danger] Must not enclose the regexp in `/your regexp here/g`
 
>[!info] 
>Use [https://regexr.com/](https://regexr.com/) to develop the actual reg exp, 
>but here it is to be enclosed in `/.../g` due to javascript


# Entity Parameters

Parameters can be of:
* SI Units, i.e. `javax.measure.Quantity: Quantity<Q extends Quantity>`
* Strings
* numbers 
	* counts, i.e. `java.lang.Long`
	* `java.lang.Double`

Now, **at runtime**, one must be able to select the type for a parameter when it is created. But how to express this in a type `ParameterValue` **at compile time** ?

```java
class Parameter {
	String name;
	ParameterValue value;
}

...

class Entity {
	List<Parameter> parameters;
	
}
```

Answer: some sort of Factory Method Pattern as described here:
		https://stackoverflow.com/questions/23722124/make-a-java-class-generic-but-only-for-two-or-three-types
		https://refactoring.guru/design-patterns/factory-method

https://refactoring.guru/design-patterns/abstract-factory


Get class name as a string at runtime:
```java

String type = Volume.class.getSimpleName();
System.out.println(type);
```

could be used to initialize an enum and use that to call the right static factory method 
```java 
class Entity {
	List<Parameter> parameters = new ArrayList<Parameter>();
	...
	Parameter setParam(ParameterType type, String name, Double value) {
		
		switch(type) {
			case ParameterType.Volume: 
				Paramter.volumeParameter(name, value);
		}
	}
}
```