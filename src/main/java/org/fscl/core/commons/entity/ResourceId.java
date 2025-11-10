package org.fscl.core.commons.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ResourceId {

	private String project;
	private String code;

	@Override
	public java.lang.String toString() {
		return String.format("{ project=%s, code=%s }", project, code);
	}
}
