package fscl.core.domain;

public class CodeFormat {
	
	private final String prefix;
	private final String separator;
	
	public CodeFormat(String prefix, String separator) {
		super();
		this.prefix = prefix;
		this.separator = separator;
	}
	
	public String getPrefix() {
		return prefix;
	}
	public String getSeparator() {
		return separator;
	}
	
}
