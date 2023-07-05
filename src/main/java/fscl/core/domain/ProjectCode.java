package fscl.core.domain;

import lombok.*;

import javax.persistence.Embeddable;

@Embeddable
@NoArgsConstructor(force = true)
@ToString
@Getter
@EqualsAndHashCode
public class ProjectCode {
	
	@NonNull private String code;

	public ProjectCode(String code) throws IllegalArgumentException {
		if(code.isEmpty()) {
			// TODO: elaborate on code validity
			throw new IllegalArgumentException(String.format("code must not be empty: %1$s", code));
		}
	}

	public boolean isValid() {
		// TODO: elaborate on code validity
		return (!this.code.isEmpty());
	}
		
}