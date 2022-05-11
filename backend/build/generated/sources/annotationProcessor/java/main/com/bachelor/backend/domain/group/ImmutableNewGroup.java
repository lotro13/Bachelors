package com.bachelor.backend.domain.group;

import com.bachelor.backend.domain.AccessType;
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.UUID;
import org.immutables.value.Generated;

/**
 * Immutable implementation of {@link NewGroup}.
 * <p>
 * Use the builder to create immutable instances:
 * {@code ImmutableNewGroup.builder()}.
 */
@Generated(from = "NewGroup", generator = "Immutables")
@SuppressWarnings({"all"})
@javax.annotation.processing.Generated("org.immutables.processor.ProxyProcessor")
public final class ImmutableNewGroup extends NewGroup {
  private final AccessType accessType;
  private final String name;
  private final UUID founder;

  private ImmutableNewGroup(AccessType accessType, String name, UUID founder) {
    this.accessType = accessType;
    this.name = name;
    this.founder = founder;
  }

  /**
   * @return The value of the {@code accessType} attribute
   */
  @JsonProperty("accessType")
  @Override
  public AccessType getAccessType() {
    return accessType;
  }

  /**
   * @return The value of the {@code name} attribute
   */
  @JsonProperty("name")
  @Override
  public String getName() {
    return name;
  }

  /**
   * @return The value of the {@code founder} attribute
   */
  @JsonProperty("founder")
  @Override
  public UUID getFounder() {
    return founder;
  }

  /**
   * Copy the current immutable object by setting a value for the {@link NewGroup#getAccessType() accessType} attribute.
   * A value equality check is used to prevent copying of the same value by returning {@code this}.
   * @param value A new value for accessType
   * @return A modified copy of the {@code this} object
   */
  public final ImmutableNewGroup withAccessType(AccessType value) {
    AccessType newValue = Objects.requireNonNull(value, "accessType");
    if (this.accessType == newValue) return this;
    return new ImmutableNewGroup(newValue, this.name, this.founder);
  }

  /**
   * Copy the current immutable object by setting a value for the {@link NewGroup#getName() name} attribute.
   * An equals check used to prevent copying of the same value by returning {@code this}.
   * @param value A new value for name
   * @return A modified copy of the {@code this} object
   */
  public final ImmutableNewGroup withName(String value) {
    String newValue = Objects.requireNonNull(value, "name");
    if (this.name.equals(newValue)) return this;
    return new ImmutableNewGroup(this.accessType, newValue, this.founder);
  }

  /**
   * Copy the current immutable object by setting a value for the {@link NewGroup#getFounder() founder} attribute.
   * A shallow reference equality check is used to prevent copying of the same value by returning {@code this}.
   * @param value A new value for founder
   * @return A modified copy of the {@code this} object
   */
  public final ImmutableNewGroup withFounder(UUID value) {
    if (this.founder == value) return this;
    UUID newValue = Objects.requireNonNull(value, "founder");
    return new ImmutableNewGroup(this.accessType, this.name, newValue);
  }

  /**
   * This instance is equal to all instances of {@code ImmutableNewGroup} that have equal attribute values.
   * @return {@code true} if {@code this} is equal to {@code another} instance
   */
  @Override
  public boolean equals(Object another) {
    if (this == another) return true;
    return another instanceof ImmutableNewGroup
        && equalTo(0, (ImmutableNewGroup) another);
  }

  private boolean equalTo(int synthetic, ImmutableNewGroup another) {
    return accessType.equals(another.accessType)
        && name.equals(another.name)
        && founder.equals(another.founder);
  }

  /**
   * Computes a hash code from attributes: {@code accessType}, {@code name}, {@code founder}.
   * @return hashCode value
   */
  @Override
  public int hashCode() {
    int h = 5381;
    h += (h << 5) + accessType.hashCode();
    h += (h << 5) + name.hashCode();
    h += (h << 5) + founder.hashCode();
    return h;
  }

  /**
   * Prints the immutable value {@code NewGroup} with attribute values.
   * @return A string representation of the value
   */
  @Override
  public String toString() {
    return "NewGroup{"
        + "accessType=" + accessType
        + ", name=" + name
        + ", founder=" + founder
        + "}";
  }

  /**
   * Utility type used to correctly read immutable object from JSON representation.
   * @deprecated Do not use this type directly, it exists only for the <em>Jackson</em>-binding infrastructure
   */
  @Generated(from = "NewGroup", generator = "Immutables")
  @Deprecated
  @JsonDeserialize
  @JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.NONE)
  static final class Json extends NewGroup {
    AccessType accessType;
    String name;
    UUID founder;
    @JsonProperty("accessType")
    public void setAccessType(AccessType accessType) {
      this.accessType = accessType;
    }
    @JsonProperty("name")
    public void setName(String name) {
      this.name = name;
    }
    @JsonProperty("founder")
    public void setFounder(UUID founder) {
      this.founder = founder;
    }
    @Override
    public AccessType getAccessType() { throw new UnsupportedOperationException(); }
    @Override
    public String getName() { throw new UnsupportedOperationException(); }
    @Override
    public UUID getFounder() { throw new UnsupportedOperationException(); }
  }

  /**
   * @param json A JSON-bindable data structure
   * @return An immutable value type
   * @deprecated Do not use this method directly, it exists only for the <em>Jackson</em>-binding infrastructure
   */
  @Deprecated
  @JsonCreator(mode = JsonCreator.Mode.DELEGATING)
  static ImmutableNewGroup fromJson(Json json) {
    ImmutableNewGroup.Builder builder = ImmutableNewGroup.builder();
    if (json.accessType != null) {
      builder.accessType(json.accessType);
    }
    if (json.name != null) {
      builder.name(json.name);
    }
    if (json.founder != null) {
      builder.founder(json.founder);
    }
    return builder.build();
  }

  /**
   * Creates an immutable copy of a {@link NewGroup} value.
   * Uses accessors to get values to initialize the new immutable instance.
   * If an instance is already immutable, it is returned as is.
   * @param instance The instance to copy
   * @return A copied immutable NewGroup instance
   */
  public static ImmutableNewGroup copyOf(NewGroup instance) {
    if (instance instanceof ImmutableNewGroup) {
      return (ImmutableNewGroup) instance;
    }
    return ImmutableNewGroup.builder()
        .from(instance)
        .build();
  }

  /**
   * Creates a builder for {@link ImmutableNewGroup ImmutableNewGroup}.
   * <pre>
   * ImmutableNewGroup.builder()
   *    .accessType(com.bachelor.backend.domain.AccessType) // required {@link NewGroup#getAccessType() accessType}
   *    .name(String) // required {@link NewGroup#getName() name}
   *    .founder(UUID) // required {@link NewGroup#getFounder() founder}
   *    .build();
   * </pre>
   * @return A new ImmutableNewGroup builder
   */
  public static ImmutableNewGroup.Builder builder() {
    return new ImmutableNewGroup.Builder();
  }

  /**
   * Builds instances of type {@link ImmutableNewGroup ImmutableNewGroup}.
   * Initialize attributes and then invoke the {@link #build()} method to create an
   * immutable instance.
   * <p><em>{@code Builder} is not thread-safe and generally should not be stored in a field or collection,
   * but instead used immediately to create instances.</em>
   */
  @Generated(from = "NewGroup", generator = "Immutables")
  public static final class Builder {
    private static final long INIT_BIT_ACCESS_TYPE = 0x1L;
    private static final long INIT_BIT_NAME = 0x2L;
    private static final long INIT_BIT_FOUNDER = 0x4L;
    private long initBits = 0x7L;

    private AccessType accessType;
    private String name;
    private UUID founder;

    private Builder() {
    }

    /**
     * Fill a builder with attribute values from the provided {@code NewGroup} instance.
     * Regular attribute values will be replaced with those from the given instance.
     * Absent optional values will not replace present values.
     * @param instance The instance from which to copy values
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder from(NewGroup instance) {
      Objects.requireNonNull(instance, "instance");
      accessType(instance.getAccessType());
      name(instance.getName());
      founder(instance.getFounder());
      return this;
    }

    /**
     * Initializes the value for the {@link NewGroup#getAccessType() accessType} attribute.
     * @param accessType The value for accessType 
     * @return {@code this} builder for use in a chained invocation
     */
    @JsonProperty("accessType")
    public final Builder accessType(AccessType accessType) {
      this.accessType = Objects.requireNonNull(accessType, "accessType");
      initBits &= ~INIT_BIT_ACCESS_TYPE;
      return this;
    }

    /**
     * Initializes the value for the {@link NewGroup#getName() name} attribute.
     * @param name The value for name 
     * @return {@code this} builder for use in a chained invocation
     */
    @JsonProperty("name")
    public final Builder name(String name) {
      this.name = Objects.requireNonNull(name, "name");
      initBits &= ~INIT_BIT_NAME;
      return this;
    }

    /**
     * Initializes the value for the {@link NewGroup#getFounder() founder} attribute.
     * @param founder The value for founder 
     * @return {@code this} builder for use in a chained invocation
     */
    @JsonProperty("founder")
    public final Builder founder(UUID founder) {
      this.founder = Objects.requireNonNull(founder, "founder");
      initBits &= ~INIT_BIT_FOUNDER;
      return this;
    }

    /**
     * Builds a new {@link ImmutableNewGroup ImmutableNewGroup}.
     * @return An immutable instance of NewGroup
     * @throws java.lang.IllegalStateException if any required attributes are missing
     */
    public ImmutableNewGroup build() {
      if (initBits != 0) {
        throw new IllegalStateException(formatRequiredAttributesMessage());
      }
      return new ImmutableNewGroup(accessType, name, founder);
    }

    private String formatRequiredAttributesMessage() {
      List<String> attributes = new ArrayList<>();
      if ((initBits & INIT_BIT_ACCESS_TYPE) != 0) attributes.add("accessType");
      if ((initBits & INIT_BIT_NAME) != 0) attributes.add("name");
      if ((initBits & INIT_BIT_FOUNDER) != 0) attributes.add("founder");
      return "Cannot build NewGroup, some of required attributes are not set " + attributes;
    }
  }
}
