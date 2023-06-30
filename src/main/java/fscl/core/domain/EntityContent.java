package fscl.core.domain;

import lombok.*;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@Getter
@Setter
@EqualsAndHashCode
@ToString
public class EntityContent {
	
	protected String name;
	protected String description;
	
	protected EntityContent() {}
	
	public EntityContent(EntityContent data) {
		this.name = data.name;
		this.description = data.description;
	}
}
