package org.fscl.core.commons;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Embeddable
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ResourceIdDataDto {

	@Column(name = "entityid_project")
	private String project;

	@Column(name = "entityid_code")
	private String code;
}
