package com.bachelor.backend.domain.group;

import com.bachelor.backend.domain.AccessType;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import org.immutables.value.Value;

import java.io.Serializable;
import java.util.UUID;


@Value.Immutable
@JsonSerialize(as = ImmutableNewGroup.class)
@JsonDeserialize(as = ImmutableNewGroup.class)
public abstract class NewGroup implements Serializable {

    public abstract AccessType getAccessType();

    public abstract String getName();

    public abstract UUID getFounder();
}
