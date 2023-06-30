package fscl.core.domain;

import lombok.*;

import javax.persistence.Embeddable;

@Embeddable
@NoArgsConstructor(force = true)
@RequiredArgsConstructor
@ToString
@Getter
public class CodeFormat {

	public static final String DEFAULT_FUNCTION_PREFIX = "=";
	public static final String DEFAULT_LOCATION_PREFIX = "+";
	public static final String DEFAULT_COMPONENT_PREFIX = "-";
	public static final String DEFAULT_SEPARATOR = ".";
	
	@NonNull private String prefix;
	@NonNull private String separator;
}
