package fscl.core.domain;

public class EntityContent {
	
	protected String name;
	protected String description;
	
	protected EntityContent() {}
	
	public EntityContent(String name, String description) {
		this.name = name;		
		this.description = description;
	}
	
	public EntityContent(EntityContent data) {
		this.name = data.name;
		this.description = data.description;
	}
		
	public String getName() {
		return this.name;
	}
	
	public String getDescription() {
		return this.description;
	}
		
	public void setName(String name) {
		this.name = name;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	public boolean equals(Object o) {
		if(o==null)
			return false;		
		if(!(o instanceof EntityContent))
			return false;		
		if(o == this)
			return true;		
		EntityContent d = (EntityContent) o;		
		return(
			(this.name == null ? d.name == null : this.name.equals(d.name)) &&
			(this.description == null ? d.description == null : this.description.equals(d.description))
		);		
	}
	
	public String toString() {
		return String.format(
				"{ name: %s, description: %s}",				
				this.name,
				this.description); 
	}
}
