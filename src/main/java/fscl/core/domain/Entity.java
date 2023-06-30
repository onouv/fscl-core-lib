package fscl.core.domain;

import java.util.*;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.DBRef;

import fscl.core.api.EntityApiId;

import static org.springframework.data.util.CastUtils.cast;


public abstract class Entity<T extends Entity<T>> 
	extends EntityContent {

	@Id
	protected EntityId code;	// must not use "id" since the repository function cannot be called FindById(..), as that
														// collides with an existing name
	
	@DBRef
	protected T parent;
	
	@DBRef
	protected List<T> children;

	@Transient
	private EntityState state = EntityState.PENDING;

	public Entity(Entity<T> e, CodeFormat cfg) {
		this.code = e.code;	
		this.parent = e.parent;
		this.children = e.children;		
	}
	
	public Entity() {
		this.code = null;
		this.parent = null;
		this.children = new LinkedList<T>();	
	}
		
	public Entity(EntityId code, T parent, LinkedList<T> children) {
		this.code = code;
		this.parent = parent;
		this.children = new LinkedList<T>();	
	}
	
	public Entity(EntityId id) {
		this.children = new LinkedList<T>();
		this.code = id;
	}
	
	public EntityId getCode() {
		return code;
	}

	public void setCode(EntityId id) {
		this.code = id;
	}

	public EntityState getState() {
		return state;
	}
	
	public T getParent() {
		return this.parent;
	}
	
	public void setParent(T parent) {
		this.parent = parent;
	}
	
	public boolean hasParent() { 
		return (this.parent != null); 
	}
		
	public void addChild(T child) {
		this.children.add(child);
	}
	
	/**
	 * Remove the entity from children collection
	 * iff its code matches child.code. Note this is robust in presesence
	 * of changed state as it doesn't evaluate children or parent but only 
	 * the code field.
	 * 
	 * @param code code of child entity
	 */
	public boolean removeChild(EntityId code) {		
		
		boolean removedAtLeastOne = false;
		
		T e = null;
		Iterator<T> iter = this.children.iterator();
		while(iter.hasNext()) {
			e = iter.next();
			if(e.code.equals(code)) {
				removedAtLeastOne = this.children.remove(e);
				break;
			}				
		}
		
		return removedAtLeastOne;
	}
	
	public List<T> getChildren() {
		return new LinkedList<T>(this.children); 
	}
	
	public List<EntityApiId> getChildrenId() {
		List<EntityApiId> reduced = new ArrayList<EntityApiId>();
		this.children.forEach(e -> {
			reduced.add(e.getCode().toEntityApiId());
		});
		return reduced;
	}
	
	public EntityApiId getParentId() {
		if(this.hasParent())
			return new EntityApiId(
				this.parent.code.project.toString(), 
				this.parent.code.entity.toString());
		else
			return new EntityApiId(null, null);
	}
	
	public ProjectCode getProjectCode() {
		return this.code.project;
	}
	
	public EntityCode getEntityCode() {
		return this.code.entity;
	}

	@Override
	public String toString() {
		
		StringBuilder str = new StringBuilder();
		str
				.append("{ code={ ")
				.append(code.toString()).append(" }, ")
				.append(", state={ ").append(state).append(" },");
		if(parent != null)
			str.append(" parent={").append(parent.getCode().toString()).append("}");
		else 
			str.append("parent={null}");
		str.append(" children: ").append(children.size()).append("}");
		
		return str.toString();
	}
	
	@Override
	public boolean equals(Object o) {
		if(o==null)
			return false;		
		if(!(o instanceof Entity<?>))
			return false;		
		if(o == this)
			return true;		
		Entity<T> e = cast(o);	
		
		return(
			super.equals(o) &&
			(Objects.equals(this.parent, e.parent)) &&
			(Objects.equals(this.children, e.children)) &&
			(Objects.equals(this.code, e.code)) &&
			(this.state == e.state)
		);		
	}

	/**
	 * Validate a given code as childcode
	 * 
	 * @return true if given child code valid, otherwise false
	 * @throws IllegalStateException if parent is not initialized
	 */
	public boolean isValidChildCode(EntityId childCode) throws IllegalStateException {
		// TODO: elaborate on code validity
		return true;
	}
	
}
