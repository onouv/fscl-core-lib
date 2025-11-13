package org.fscl.core.commons.entity;

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
public class EntityIdJpaDto {

	@Column(name = "entityid_project")
	private String project;

	@Column(name = "entityid_code")
	private String code;
}
