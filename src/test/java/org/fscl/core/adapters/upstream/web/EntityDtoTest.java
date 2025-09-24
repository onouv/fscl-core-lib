package org.fscl.core.adapters.upstream.web;


import org.fscl.core.adapters.driven.web.lifecycle.EntityDto;
import org.fscl.core.domain.entity.FsclEntity;
import org.fscl.core.domain.entity.id.FsclEntityId;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;


class TestFunction extends FsclEntity<TestFunction> {
    public TestFunction(
        FsclEntityId id,
        TestFunction parent,
        String name, 
        String description) {
        super(id, parent, name, description);
    }

    public TestFunction(FsclEntityId id, String name, String description) {
        super(id, null, name, description);
    }
    
    public String getName() {
    	return name;
    }
    
    public String getDescription() {
    	return description;
    }
}

class EntityDtoTest {
	
	FsclEntityId mockId;
	TestFunction mockEntity;
	
	@BeforeEach
	void setup() {
		this.mockId = mock(FsclEntityId.class);
        this.mockEntity = mock(TestFunction.class); //new TestFunction(mockId, "Test Entity", "Test Description");
        when(mockEntity.getEntityId()).thenReturn(mockId);
        when(mockEntity.getName()).thenReturn("Test Entity");
        when(mockEntity.getDescription()).thenReturn("Test Description");
	}
	
    @Test
    void shouldCreateEntityDtoFromEntity() {
        // Given 
    	// mock entity as per setup
        
        // When
    	// creating dto from it
        EntityDto<TestFunction> result = EntityDto.of(mockEntity);

        // Then
        assertNotNull(result);
        assertEquals(mockId, result.getId());
        assertEquals("Test Entity", result.getName());
        assertEquals("Test Description", result.getDescription());
    }

    @Test
    void shouldCreateEntityDtoWithConstructor() {
        // Given
        FsclEntityId mockId = mock(FsclEntityId.class);
        String name = "Test Name";
        String description = "Test Description";

        // When
        EntityDto<TestFunction> dto = new EntityDto<TestFunction>(mockId, name, description);

        // Then
        assertNotNull(dto);
        assertEquals(mockId, dto.getId());
        assertEquals(name, dto.getName());
        assertEquals(description, dto.getDescription());
    }
}