package org.fscl.core.commons.entity;

import java.util.regex.Pattern;

import lombok.Builder;

public class ResourceIdFormat {
	private final String prefix;
	private final String separator;
	private final String postfix;
	private final String project;

	@Builder
	private ResourceIdFormat(String project, String prefix, String separator, String postfix)
			throws EntityCodeFormatException, ProjectCodeException {

		Pattern projectPattern = Pattern.compile(PROJECT_REGEXP);
		if (!projectPattern.matcher(project).matches()) {
			throw new ProjectCodeException(String.format("project name %s ill-formed", project));
		}

		Pattern prefixPattern = Pattern.compile(PREFIX_REGEXP);
		if (!prefixPattern.matcher(prefix).matches()) {
			throw new EntityCodeFormatException(String.format("prefix %s ill-formed", prefix));
		}

		Pattern separatorPattern = Pattern.compile(SEPARATOR_REGEXP);
		if (!separatorPattern.matcher(separator).matches()) {
			throw new EntityCodeFormatException(String.format("separator %s ill-formed", separator));
		}

		if (postfix != null) {
			if (!postfix.equals(")")) {
				throw new EntityCodeFormatException(String.format("postfix %s ill-formed", postfix));
			}

			if (!prefix.startsWith("(")) {
				throw new EntityCodeFormatException(
						String.format("postfix %s not permitted without prefix beginning with %s", postfix, prefix));
			}
		}

		this.project = project;
		this.postfix = postfix;
		this.prefix = prefix;
		this.separator = separator;
	}

	public void validate(ResourceId dto) throws ProjectCodeException, EntityCodeException {
		validateProject(dto.getProject());
		validateCode(dto.getCode());
	}

	private void validateProject(String project) throws ProjectCodeException {
		if (!project.equals(this.project)) {
			throw new ProjectCodeException(String.format("project name %s invalid", project));
		}

	}

	private void validateCode(String code) throws EntityCodeException {
		if (!code.startsWith(this.prefix)) {
			throw new EntityCodeException(code, String.format("code %s missing prefix %s", code, this.prefix));
		}

		String stripped;
		if (this.postfix != null) {
			if (!code.endsWith(this.postfix)) {
				throw new EntityCodeException(code, String.format("code %s missing postfix %s", code, this.postfix));
			}
			stripped = code.substring(this.prefix.length(), code.length() - this.postfix.length());
		} else {
			stripped = code.substring(this.prefix.length());
		}

		Pattern p = Pattern.compile(SEGMENT_REGEXP);
		String[] segments = stripped.split(this.separator);
		for (String seg : segments) {
			if (!p.matcher(seg).matches()) {
				throw new EntityCodeException(code, String.format("code segment ill-formed (%s)", seg));
			}
		}
	}

	private static final String SEPARATOR_REGEXP = "\\W{1,4}";

	private static final String SEGMENT_REGEXP = "\\d{1,8}|[A-Z]{1,8}|[a-z]{1,8}";
	private static final String PREFIX_REGEXP = "\\W{1,4}";

	private static final String PROJECT_REGEXP = "(\\w|\\s){1,25}";
}
