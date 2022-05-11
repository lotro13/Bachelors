package com.bachelor.backend.domain.challenge;

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
 * Immutable implementation of {@link NewChallenge}.
 * <p>
 * Use the builder to create immutable instances:
 * {@code ImmutableNewChallenge.builder()}.
 */
@Generated(from = "NewChallenge", generator = "Immutables")
@SuppressWarnings({"all"})
@javax.annotation.processing.Generated("org.immutables.processor.ProxyProcessor")
public final class ImmutableNewChallenge extends NewChallenge {
  private final UUID founder;
  private final UUID group;
  private final String name;
  private final String description;
  private final ChallengeType type;
  private final String deadline;
  private final AccessType accessType;

  private ImmutableNewChallenge(
      UUID founder,
      UUID group,
      String name,
      String description,
      ChallengeType type,
      String deadline,
      AccessType accessType) {
    this.founder = founder;
    this.group = group;
    this.name = name;
    this.description = description;
    this.type = type;
    this.deadline = deadline;
    this.accessType = accessType;
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
   * @return The value of the {@code group} attribute
   */
  @JsonProperty("group")
  @Override
  public UUID getGroup() {
    return group;
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
   * @return The value of the {@code description} attribute
   */
  @JsonProperty("description")
  @Override
  public String getDescription() {
    return description;
  }

  /**
   * @return The value of the {@code type} attribute
   */
  @JsonProperty("type")
  @Override
  public ChallengeType getType() {
    return type;
  }

  /**
   * @return The value of the {@code deadline} attribute
   */
  @JsonProperty("deadline")
  @Override
  public String getDeadline() {
    return deadline;
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
   * Copy the current immutable object by setting a value for the {@link NewChallenge#getFounder() founder} attribute.
   * A shallow reference equality check is used to prevent copying of the same value by returning {@code this}.
   * @param value A new value for founder
   * @return A modified copy of the {@code this} object
   */
  public final ImmutableNewChallenge withFounder(UUID value) {
    if (this.founder == value) return this;
    UUID newValue = Objects.requireNonNull(value, "founder");
    return new ImmutableNewChallenge(newValue, this.group, this.name, this.description, this.type, this.deadline, this.accessType);
  }

  /**
   * Copy the current immutable object by setting a value for the {@link NewChallenge#getGroup() group} attribute.
   * A shallow reference equality check is used to prevent copying of the same value by returning {@code this}.
   * @param value A new value for group
   * @return A modified copy of the {@code this} object
   */
  public final ImmutableNewChallenge withGroup(UUID value) {
    if (this.group == value) return this;
    UUID newValue = Objects.requireNonNull(value, "group");
    return new ImmutableNewChallenge(this.founder, newValue, this.name, this.description, this.type, this.deadline, this.accessType);
  }

  /**
   * Copy the current immutable object by setting a value for the {@link NewChallenge#getName() name} attribute.
   * An equals check used to prevent copying of the same value by returning {@code this}.
   * @param value A new value for name
   * @return A modified copy of the {@code this} object
   */
  public final ImmutableNewChallenge withName(String value) {
    String newValue = Objects.requireNonNull(value, "name");
    if (this.name.equals(newValue)) return this;
    return new ImmutableNewChallenge(this.founder, this.group, newValue, this.description, this.type, this.deadline, this.accessType);
  }

  /**
   * Copy the current immutable object by setting a value for the {@link NewChallenge#getDescription() description} attribute.
   * An equals check used to prevent copying of the same value by returning {@code this}.
   * @param value A new value for description
   * @return A modified copy of the {@code this} object
   */
  public final ImmutableNewChallenge withDescription(String value) {
    String newValue = Objects.requireNonNull(value, "description");
    if (this.description.equals(newValue)) return this;
    return new ImmutableNewChallenge(this.founder, this.group, this.name, newValue, this.type, this.deadline, this.accessType);
  }

  /**
   * Copy the current immutable object by setting a value for the {@link NewChallenge#getType() type} attribute.
   * A value equality check is used to prevent copying of the same value by returning {@code this}.
   * @param value A new value for type
   * @return A modified copy of the {@code this} object
   */
  public final ImmutableNewChallenge withType(ChallengeType value) {
    ChallengeType newValue = Objects.requireNonNull(value, "type");
    if (this.type == newValue) return this;
    return new ImmutableNewChallenge(this.founder, this.group, this.name, this.description, newValue, this.deadline, this.accessType);
  }

  /**
   * Copy the current immutable object by setting a value for the {@link NewChallenge#getDeadline() deadline} attribute.
   * An equals check used to prevent copying of the same value by returning {@code this}.
   * @param value A new value for deadline
   * @return A modified copy of the {@code this} object
   */
  public final ImmutableNewChallenge withDeadline(String value) {
    String newValue = Objects.requireNonNull(value, "deadline");
    if (this.deadline.equals(newValue)) return this;
    return new ImmutableNewChallenge(this.founder, this.group, this.name, this.description, this.type, newValue, this.accessType);
  }

  /**
   * Copy the current immutable object by setting a value for the {@link NewChallenge#getAccessType() accessType} attribute.
   * A value equality check is used to prevent copying of the same value by returning {@code this}.
   * @param value A new value for accessType
   * @return A modified copy of the {@code this} object
   */
  public final ImmutableNewChallenge withAccessType(AccessType value) {
    AccessType newValue = Objects.requireNonNull(value, "accessType");
    if (this.accessType == newValue) return this;
    return new ImmutableNewChallenge(this.founder, this.group, this.name, this.description, this.type, this.deadline, newValue);
  }

  /**
   * This instance is equal to all instances of {@code ImmutableNewChallenge} that have equal attribute values.
   * @return {@code true} if {@code this} is equal to {@code another} instance
   */
  @Override
  public boolean equals(Object another) {
    if (this == another) return true;
    return another instanceof ImmutableNewChallenge
        && equalTo(0, (ImmutableNewChallenge) another);
  }

  private boolean equalTo(int synthetic, ImmutableNewChallenge another) {
    return founder.equals(another.founder)
        && group.equals(another.group)
        && name.equals(another.name)
        && description.equals(another.description)
        && type.equals(another.type)
        && deadline.equals(another.deadline)
        && accessType.equals(another.accessType);
  }

  /**
   * Computes a hash code from attributes: {@code founder}, {@code group}, {@code name}, {@code description}, {@code type}, {@code deadline}, {@code accessType}.
   * @return hashCode value
   */
  @Override
  public int hashCode() {
    int h = 5381;
    h += (h << 5) + founder.hashCode();
    h += (h << 5) + group.hashCode();
    h += (h << 5) + name.hashCode();
    h += (h << 5) + description.hashCode();
    h += (h << 5) + type.hashCode();
    h += (h << 5) + deadline.hashCode();
    h += (h << 5) + accessType.hashCode();
    return h;
  }

  /**
   * Prints the immutable value {@code NewChallenge} with attribute values.
   * @return A string representation of the value
   */
  @Override
  public String toString() {
    return "NewChallenge{"
        + "founder=" + founder
        + ", group=" + group
        + ", name=" + name
        + ", description=" + description
        + ", type=" + type
        + ", deadline=" + deadline
        + ", accessType=" + accessType
        + "}";
  }

  /**
   * Utility type used to correctly read immutable object from JSON representation.
   * @deprecated Do not use this type directly, it exists only for the <em>Jackson</em>-binding infrastructure
   */
  @Generated(from = "NewChallenge", generator = "Immutables")
  @Deprecated
  @JsonDeserialize
  @JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.NONE)
  static final class Json extends NewChallenge {
    UUID founder;
    UUID group;
    String name;
    String description;
    ChallengeType type;
    String deadline;
    AccessType accessType;
    @JsonProperty("founder")
    public void setFounder(UUID founder) {
      this.founder = founder;
    }
    @JsonProperty("group")
    public void setGroup(UUID group) {
      this.group = group;
    }
    @JsonProperty("name")
    public void setName(String name) {
      this.name = name;
    }
    @JsonProperty("description")
    public void setDescription(String description) {
      this.description = description;
    }
    @JsonProperty("type")
    public void setType(ChallengeType type) {
      this.type = type;
    }
    @JsonProperty("deadline")
    public void setDeadline(String deadline) {
      this.deadline = deadline;
    }
    @JsonProperty("accessType")
    public void setAccessType(AccessType accessType) {
      this.accessType = accessType;
    }
    @Override
    public UUID getFounder() { throw new UnsupportedOperationException(); }
    @Override
    public UUID getGroup() { throw new UnsupportedOperationException(); }
    @Override
    public String getName() { throw new UnsupportedOperationException(); }
    @Override
    public String getDescription() { throw new UnsupportedOperationException(); }
    @Override
    public ChallengeType getType() { throw new UnsupportedOperationException(); }
    @Override
    public String getDeadline() { throw new UnsupportedOperationException(); }
    @Override
    public AccessType getAccessType() { throw new UnsupportedOperationException(); }
  }

  /**
   * @param json A JSON-bindable data structure
   * @return An immutable value type
   * @deprecated Do not use this method directly, it exists only for the <em>Jackson</em>-binding infrastructure
   */
  @Deprecated
  @JsonCreator(mode = JsonCreator.Mode.DELEGATING)
  static ImmutableNewChallenge fromJson(Json json) {
    ImmutableNewChallenge.Builder builder = ImmutableNewChallenge.builder();
    if (json.founder != null) {
      builder.founder(json.founder);
    }
    if (json.group != null) {
      builder.group(json.group);
    }
    if (json.name != null) {
      builder.name(json.name);
    }
    if (json.description != null) {
      builder.description(json.description);
    }
    if (json.type != null) {
      builder.type(json.type);
    }
    if (json.deadline != null) {
      builder.deadline(json.deadline);
    }
    if (json.accessType != null) {
      builder.accessType(json.accessType);
    }
    return builder.build();
  }

  /**
   * Creates an immutable copy of a {@link NewChallenge} value.
   * Uses accessors to get values to initialize the new immutable instance.
   * If an instance is already immutable, it is returned as is.
   * @param instance The instance to copy
   * @return A copied immutable NewChallenge instance
   */
  public static ImmutableNewChallenge copyOf(NewChallenge instance) {
    if (instance instanceof ImmutableNewChallenge) {
      return (ImmutableNewChallenge) instance;
    }
    return ImmutableNewChallenge.builder()
        .from(instance)
        .build();
  }

  /**
   * Creates a builder for {@link ImmutableNewChallenge ImmutableNewChallenge}.
   * <pre>
   * ImmutableNewChallenge.builder()
   *    .founder(UUID) // required {@link NewChallenge#getFounder() founder}
   *    .group(UUID) // required {@link NewChallenge#getGroup() group}
   *    .name(String) // required {@link NewChallenge#getName() name}
   *    .description(String) // required {@link NewChallenge#getDescription() description}
   *    .type(com.bachelor.backend.domain.challenge.ChallengeType) // required {@link NewChallenge#getType() type}
   *    .deadline(String) // required {@link NewChallenge#getDeadline() deadline}
   *    .accessType(com.bachelor.backend.domain.AccessType) // required {@link NewChallenge#getAccessType() accessType}
   *    .build();
   * </pre>
   * @return A new ImmutableNewChallenge builder
   */
  public static ImmutableNewChallenge.Builder builder() {
    return new ImmutableNewChallenge.Builder();
  }

  /**
   * Builds instances of type {@link ImmutableNewChallenge ImmutableNewChallenge}.
   * Initialize attributes and then invoke the {@link #build()} method to create an
   * immutable instance.
   * <p><em>{@code Builder} is not thread-safe and generally should not be stored in a field or collection,
   * but instead used immediately to create instances.</em>
   */
  @Generated(from = "NewChallenge", generator = "Immutables")
  public static final class Builder {
    private static final long INIT_BIT_FOUNDER = 0x1L;
    private static final long INIT_BIT_GROUP = 0x2L;
    private static final long INIT_BIT_NAME = 0x4L;
    private static final long INIT_BIT_DESCRIPTION = 0x8L;
    private static final long INIT_BIT_TYPE = 0x10L;
    private static final long INIT_BIT_DEADLINE = 0x20L;
    private static final long INIT_BIT_ACCESS_TYPE = 0x40L;
    private long initBits = 0x7fL;

    private UUID founder;
    private UUID group;
    private String name;
    private String description;
    private ChallengeType type;
    private String deadline;
    private AccessType accessType;

    private Builder() {
    }

    /**
     * Fill a builder with attribute values from the provided {@code NewChallenge} instance.
     * Regular attribute values will be replaced with those from the given instance.
     * Absent optional values will not replace present values.
     * @param instance The instance from which to copy values
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder from(NewChallenge instance) {
      Objects.requireNonNull(instance, "instance");
      founder(instance.getFounder());
      group(instance.getGroup());
      name(instance.getName());
      description(instance.getDescription());
      type(instance.getType());
      deadline(instance.getDeadline());
      accessType(instance.getAccessType());
      return this;
    }

    /**
     * Initializes the value for the {@link NewChallenge#getFounder() founder} attribute.
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
     * Initializes the value for the {@link NewChallenge#getGroup() group} attribute.
     * @param group The value for group 
     * @return {@code this} builder for use in a chained invocation
     */
    @JsonProperty("group")
    public final Builder group(UUID group) {
      this.group = Objects.requireNonNull(group, "group");
      initBits &= ~INIT_BIT_GROUP;
      return this;
    }

    /**
     * Initializes the value for the {@link NewChallenge#getName() name} attribute.
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
     * Initializes the value for the {@link NewChallenge#getDescription() description} attribute.
     * @param description The value for description 
     * @return {@code this} builder for use in a chained invocation
     */
    @JsonProperty("description")
    public final Builder description(String description) {
      this.description = Objects.requireNonNull(description, "description");
      initBits &= ~INIT_BIT_DESCRIPTION;
      return this;
    }

    /**
     * Initializes the value for the {@link NewChallenge#getType() type} attribute.
     * @param type The value for type 
     * @return {@code this} builder for use in a chained invocation
     */
    @JsonProperty("type")
    public final Builder type(ChallengeType type) {
      this.type = Objects.requireNonNull(type, "type");
      initBits &= ~INIT_BIT_TYPE;
      return this;
    }

    /**
     * Initializes the value for the {@link NewChallenge#getDeadline() deadline} attribute.
     * @param deadline The value for deadline 
     * @return {@code this} builder for use in a chained invocation
     */
    @JsonProperty("deadline")
    public final Builder deadline(String deadline) {
      this.deadline = Objects.requireNonNull(deadline, "deadline");
      initBits &= ~INIT_BIT_DEADLINE;
      return this;
    }

    /**
     * Initializes the value for the {@link NewChallenge#getAccessType() accessType} attribute.
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
     * Builds a new {@link ImmutableNewChallenge ImmutableNewChallenge}.
     * @return An immutable instance of NewChallenge
     * @throws java.lang.IllegalStateException if any required attributes are missing
     */
    public ImmutableNewChallenge build() {
      if (initBits != 0) {
        throw new IllegalStateException(formatRequiredAttributesMessage());
      }
      return new ImmutableNewChallenge(founder, group, name, description, type, deadline, accessType);
    }

    private String formatRequiredAttributesMessage() {
      List<String> attributes = new ArrayList<>();
      if ((initBits & INIT_BIT_FOUNDER) != 0) attributes.add("founder");
      if ((initBits & INIT_BIT_GROUP) != 0) attributes.add("group");
      if ((initBits & INIT_BIT_NAME) != 0) attributes.add("name");
      if ((initBits & INIT_BIT_DESCRIPTION) != 0) attributes.add("description");
      if ((initBits & INIT_BIT_TYPE) != 0) attributes.add("type");
      if ((initBits & INIT_BIT_DEADLINE) != 0) attributes.add("deadline");
      if ((initBits & INIT_BIT_ACCESS_TYPE) != 0) attributes.add("accessType");
      return "Cannot build NewChallenge, some of required attributes are not set " + attributes;
    }
  }
}
