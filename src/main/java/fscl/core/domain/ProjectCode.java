package fscl.core.domain;

import lombok.*;

import javax.persistence.Embeddable;

@Embeddable
@NoArgsConstructor(force = true)
@RequiredArgsConstructor
@ToString
@Getter
@EqualsAndHashCode
public class ProjectCode {
	
	@NonNull private String code;

	public boolean isEmpty() {
		return this.code.isEmpty();
	}
	
	// TODO: elaborate code validity
	public boolean isValid() {
		return (!this.isEmpty());
	}
		
}