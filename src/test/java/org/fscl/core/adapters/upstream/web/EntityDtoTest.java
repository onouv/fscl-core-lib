package org.fscl.core.adapters.upstream.web;


import org.fscl.core.adapters.driven.web.lifecycle.EntityDto;
import org.fscl.core.domain.entity.FsclEntity;
import org.fscl.core.domain.entity.id.FsclEntityId;
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

    public TestFunction(FsclEntityId id) {
        super(id, null, "", "");
    }
}

class EntityDtoTest {

    @Test
    void shouldCreateEntityDtoFromEntity() {
        // Given
        FsclEntityId mockId = mock(FsclEntityId.class);
        @SuppressWarnings("unchecked")
        FsclEntity<TestFunction> mockEntity = mock(FsclEntity.class);
        
        when(mockEntity.getEntityId()).thenReturn(mockId);
        when(mockEntity.getName()).thenReturn("Test Entity");
        when(mockEntity.getDescription()).thenReturn("Test Description");

        // When
        EntityDto<?> result = EntityDto.of(mockEntity);

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
        EntityDto<?> dto = new EntityDto<>(mockId, name, description);

        // Then
        assertNotNull(dto);
        assertEquals(mockId, dto.getId());
        assertEquals(name, dto.getName());
        assertEquals(description, dto.getDescription());
    }
}