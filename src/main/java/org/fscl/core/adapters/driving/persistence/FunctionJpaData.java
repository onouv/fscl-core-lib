package org.fscl.core.adapters.driving.persistence;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Entity
@SuperBuilder
@Getter
@Setter
public class FunctionJpaData extends EntityJpaData  {
}

