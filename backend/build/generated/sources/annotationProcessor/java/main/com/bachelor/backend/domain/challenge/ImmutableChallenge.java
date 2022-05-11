package com.bachelor.backend.domain.challenge;

import com.bachelor.backend.domain.AccessType;
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.UUID;
import org.immutables.value.Generated;

/**
 * Immutable implementation of {@link Challenge}.
 * <p>
 * Use the builder to create immutable instances:
 * {@code ImmutableChallenge.builder()}.
 */
@Generated(from = "Challenge", generator = "Immutables")
@SuppressWarnings({"all"})
@javax.annotation.processing.Generated("org.immutables.processor.ProxyProcessor")
public final class ImmutableChallenge extends Challenge {
  private final UUID uuid;
  private final UUID founder;
  private final UUID group;
  private final List<UUID> participants;
  private final String name;
  private final String description;
  private final ChallengeType type;
  private final ChallengeStatus status;
  private final String deadline;
  private final Map<UUID, Integer> scoreboard;
  private final AccessType accessType;

  private ImmutableChallenge(
      UUID uuid,
      UUID founder,
      UUID group,
      List<UUID> participants,
      String name,
      String description,
      ChallengeType type,
      ChallengeStatus status,
      String deadline,
      Map<UUID, Integer> scoreboard,
      AccessType accessType) {
    this.uuid = uuid;
    this.founder = founder;
    this.group = group;
    this.participants = participants;
    this.name = name;
    this.description = description;
    this.type = type;
    this.status = status;
    this.deadline = deadline;
    this.scoreboard = scoreboard;
    this.accessType = accessType;
  }

  /**
   * @return The value of the {@code uuid} attribute
   */
  @JsonProperty("uuid")
  @Override
  public UUID getUuid() {
    return uuid;
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
   * @return The value of the {@code participants} attribute
   */
  @JsonProperty("participants")
  @Override
  public List<UUID> getParticipants() {
    return participants;
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
   * @return The value of the {@code status} attribute
   */
  @JsonProperty("status")
  @Override
  public ChallengeStatus getStatus() {
    return status;
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
   * @return The value of the {@code scoreboard} attribute
   */
  @JsonProperty("scoreboard")
  @Override
  public Map<UUID, Integer> getScoreboard() {
    return scoreboard;
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
   * Copy the current immutable object by setting a value for the {@link Challenge#getUuid() uuid} attribute.
   * A shallow reference equality check is used to prevent copying of the same value by returning {@code this}.
   * @param value A new value for uuid
   * @return A modified copy of the {@code this} object
   */
  public final ImmutableChallenge withUuid(UUID value) {
    if (this.uuid == value) return this;
    UUID newValue = Objects.requireNonNull(value, "uuid");
    return new ImmutableChallenge(
        newValue,
        this.founder,
        this.group,
        this.participants,
        this.name,
        this.description,
        this.type,
        this.status,
        this.deadline,
        this.scoreboard,
        this.accessType);
  }

  /**
   * Copy the current immutable object by setting a value for the {@link Challenge#getFounder() founder} attribute.
   * A shallow reference equality check is used to prevent copying of the same value by returning {@code this}.
   * @param value A new value for founder
   * @return A modified copy of the {@code this} object
   */
  public final ImmutableChallenge withFounder(UUID value) {
    if (this.founder == value) return this;
    UUID newValue = Objects.requireNonNull(value, "founder");
    return new ImmutableChallenge(
        this.uuid,
        newValue,
        this.group,
        this.participants,
        this.name,
        this.description,
        this.type,
        this.status,
        this.deadline,
        this.scoreboard,
        this.accessType);
  }

  /**
   * Copy the current immutable object by setting a value for the {@link Challenge#getGroup() group} attribute.
   * A shallow reference equality check is used to prevent copying of the same value by returning {@code this}.
   * @param value A new value for group
   * @return A modified copy of the {@code this} object
   */
  public final ImmutableChallenge withGroup(UUID value) {
    if (this.group == value) return this;
    UUID newValue = Objects.requireNonNull(value, "group");
    return new ImmutableChallenge(
        this.uuid,
        this.founder,
        newValue,
        this.participants,
        this.name,
        this.description,
        this.type,
        this.status,
        this.deadline,
        this.scoreboard,
        this.accessType);
  }

  /**
   * Copy the current immutable object with elements that replace the content of {@link Challenge#getParticipants() participants}.
   * @param elements The elements to set
   * @return A modified copy of {@code this} object
   */
  public final ImmutableChallenge withParticipants(UUID... elements) {
    List<UUID> newValue = createUnmodifiableList(false, createSafeList(Arrays.asList(elements), true, false));
    return new ImmutableChallenge(
        this.uuid,
        this.founder,
        this.group,
        newValue,
        this.name,
        this.description,
        this.type,
        this.status,
        this.deadline,
        this.scoreboard,
        this.accessType);
  }

  /**
   * Copy the current immutable object with elements that replace the content of {@link Challenge#getParticipants() participants}.
   * A shallow reference equality check is used to prevent copying of the same value by returning {@code this}.
   * @param elements An iterable of participants elements to set
   * @return A modified copy of {@code this} object
   */
  public final ImmutableChallenge withParticipants(Iterable<? extends UUID> elements) {
    if (this.participants == elements) return this;
    List<UUID> newValue = createUnmodifiableList(false, createSafeList(elements, true, false));
    return new ImmutableChallenge(
        this.uuid,
        this.founder,
        this.group,
        newValue,
        this.name,
        this.description,
        this.type,
        this.status,
        this.deadline,
        this.scoreboard,
        this.accessType);
  }

  /**
   * Copy the current immutable object by setting a value for the {@link Challenge#getName() name} attribute.
   * An equals check used to prevent copying of the same value by returning {@code this}.
   * @param value A new value for name
   * @return A modified copy of the {@code this} object
   */
  public final ImmutableChallenge withName(String value) {
    String newValue = Objects.requireNonNull(value, "name");
    if (this.name.equals(newValue)) return this;
    return new ImmutableChallenge(
        this.uuid,
        this.founder,
        this.group,
        this.participants,
        newValue,
        this.description,
        this.type,
        this.status,
        this.deadline,
        this.scoreboard,
        this.accessType);
  }

  /**
   * Copy the current immutable object by setting a value for the {@link Challenge#getDescription() description} attribute.
   * An equals check used to prevent copying of the same value by returning {@code this}.
   * @param value A new value for description
   * @return A modified copy of the {@code this} object
   */
  public final ImmutableChallenge withDescription(String value) {
    String newValue = Objects.requireNonNull(value, "description");
    if (this.description.equals(newValue)) return this;
    return new ImmutableChallenge(
        this.uuid,
        this.founder,
        this.group,
        this.participants,
        this.name,
        newValue,
        this.type,
        this.status,
        this.deadline,
        this.scoreboard,
        this.accessType);
  }

  /**
   * Copy the current immutable object by setting a value for the {@link Challenge#getType() type} attribute.
   * A value equality check is used to prevent copying of the same value by returning {@code this}.
   * @param value A new value for type
   * @return A modified copy of the {@code this} object
   */
  public final ImmutableChallenge withType(ChallengeType value) {
    ChallengeType newValue = Objects.requireNonNull(value, "type");
    if (this.type == newValue) return this;
    return new ImmutableChallenge(
        this.uuid,
        this.founder,
        this.group,
        this.participants,
        this.name,
        this.description,
        newValue,
        this.status,
        this.deadline,
        this.scoreboard,
        this.accessType);
  }

  /**
   * Copy the current immutable object by setting a value for the {@link Challenge#getStatus() status} attribute.
   * A value equality check is used to prevent copying of the same value by returning {@code this}.
   * @param value A new value for status
   * @return A modified copy of the {@code this} object
   */
  public final ImmutableChallenge withStatus(ChallengeStatus value) {
    ChallengeStatus newValue = Objects.requireNonNull(value, "status");
    if (this.status == newValue) return this;
    return new ImmutableChallenge(
        this.uuid,
        this.founder,
        this.group,
        this.participants,
        this.name,
        this.description,
        this.type,
        newValue,
        this.deadline,
        this.scoreboard,
        this.accessType);
  }

  /**
   * Copy the current immutable object by setting a value for the {@link Challenge#getDeadline() deadline} attribute.
   * An equals check used to prevent copying of the same value by returning {@code this}.
   * @param value A new value for deadline
   * @return A modified copy of the {@code this} object
   */
  public final ImmutableChallenge withDeadline(String value) {
    String newValue = Objects.requireNonNull(value, "deadline");
    if (this.deadline.equals(newValue)) return this;
    return new ImmutableChallenge(
        this.uuid,
        this.founder,
        this.group,
        this.participants,
        this.name,
        this.description,
        this.type,
        this.status,
        newValue,
        this.scoreboard,
        this.accessType);
  }

  /**
   * Copy the current immutable object by replacing the {@link Challenge#getScoreboard() scoreboard} map with the specified map.
   * Nulls are not permitted as keys or values.
   * A shallow reference equality check is used to prevent copying of the same value by returning {@code this}.
   * @param entries The entries to be added to the scoreboard map
   * @return A modified copy of {@code this} object
   */
  public final ImmutableChallenge withScoreboard(Map<? extends UUID, ? extends Integer> entries) {
    if (this.scoreboard == entries) return this;
    Map<UUID, Integer> newValue = createUnmodifiableMap(true, false, entries);
    return new ImmutableChallenge(
        this.uuid,
        this.founder,
        this.group,
        this.participants,
        this.name,
        this.description,
        this.type,
        this.status,
        this.deadline,
        newValue,
        this.accessType);
  }

  /**
   * Copy the current immutable object by setting a value for the {@link Challenge#getAccessType() accessType} attribute.
   * A value equality check is used to prevent copying of the same value by returning {@code this}.
   * @param value A new value for accessType
   * @return A modified copy of the {@code this} object
   */
  public final ImmutableChallenge withAccessType(AccessType value) {
    AccessType newValue = Objects.requireNonNull(value, "accessType");
    if (this.accessType == newValue) return this;
    return new ImmutableChallenge(
        this.uuid,
        this.founder,
        this.group,
        this.participants,
        this.name,
        this.description,
        this.type,
        this.status,
        this.deadline,
        this.scoreboard,
        newValue);
  }

  /**
   * This instance is equal to all instances of {@code ImmutableChallenge} that have equal attribute values.
   * @return {@code true} if {@code this} is equal to {@code another} instance
   */
  @Override
  public boolean equals(Object another) {
    if (this == another) return true;
    return another instanceof ImmutableChallenge
        && equalTo(0, (ImmutableChallenge) another);
  }

  private boolean equalTo(int synthetic, ImmutableChallenge another) {
    return uuid.equals(another.uuid)
        && founder.equals(another.founder)
        && group.equals(another.group)
        && participants.equals(another.participants)
        && name.equals(another.name)
        && description.equals(another.description)
        && type.equals(another.type)
        && status.equals(another.status)
        && deadline.equals(another.deadline)
        && scoreboard.equals(another.scoreboard)
        && accessType.equals(another.accessType);
  }

  /**
   * Computes a hash code from attributes: {@code uuid}, {@code founder}, {@code group}, {@code participants}, {@code name}, {@code description}, {@code type}, {@code status}, {@code deadline}, {@code scoreboard}, {@code accessType}.
   * @return hashCode value
   */
  @Override
  public int hashCode() {
    int h = 5381;
    h += (h << 5) + uuid.hashCode();
    h += (h << 5) + founder.hashCode();
    h += (h << 5) + group.hashCode();
    h += (h << 5) + participants.hashCode();
    h += (h << 5) + name.hashCode();
    h += (h << 5) + description.hashCode();
    h += (h << 5) + type.hashCode();
    h += (h << 5) + status.hashCode();
    h += (h << 5) + deadline.hashCode();
    h += (h << 5) + scoreboard.hashCode();
    h += (h << 5) + accessType.hashCode();
    return h;
  }

  /**
   * Prints the immutable value {@code Challenge} with attribute values.
   * @return A string representation of the value
   */
  @Override
  public String toString() {
    return "Challenge{"
        + "uuid=" + uuid
        + ", founder=" + founder
        + ", group=" + group
        + ", participants=" + participants
        + ", name=" + name
        + ", description=" + description
        + ", type=" + type
        + ", status=" + status
        + ", deadline=" + deadline
        + ", scoreboard=" + scoreboard
        + ", accessType=" + accessType
        + "}";
  }

  /**
   * Utility type used to correctly read immutable object from JSON representation.
   * @deprecated Do not use this type directly, it exists only for the <em>Jackson</em>-binding infrastructure
   */
  @Generated(from = "Challenge", generator = "Immutables")
  @Deprecated
  @JsonDeserialize
  @JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.NONE)
  static final class Json extends Challenge {
    UUID uuid;
    UUID founder;
    UUID group;
    List<UUID> participants = Collections.emptyList();
    String name;
    String description;
    ChallengeType type;
    ChallengeStatus status;
    String deadline;
    Map<UUID, Integer> scoreboard = Collections.emptyMap();
    AccessType accessType;
    @JsonProperty("uuid")
    public void setUuid(UUID uuid) {
      this.uuid = uuid;
    }
    @JsonProperty("founder")
    public void setFounder(UUID founder) {
      this.founder = founder;
    }
    @JsonProperty("group")
    public void setGroup(UUID group) {
      this.group = group;
    }
    @JsonProperty("participants")
    public void setParticipants(List<UUID> participants) {
      this.participants = participants;
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
    @JsonProperty("status")
    public void setStatus(ChallengeStatus status) {
      this.status = status;
    }
    @JsonProperty("deadline")
    public void setDeadline(String deadline) {
      this.deadline = deadline;
    }
    @JsonProperty("scoreboard")
    public void setScoreboard(Map<UUID, Integer> scoreboard) {
      this.scoreboard = scoreboard;
    }
    @JsonProperty("accessType")
    public void setAccessType(AccessType accessType) {
      this.accessType = accessType;
    }
    @Override
    public UUID getUuid() { throw new UnsupportedOperationException(); }
    @Override
    public UUID getFounder() { throw new UnsupportedOperationException(); }
    @Override
    public UUID getGroup() { throw new UnsupportedOperationException(); }
    @Override
    public List<UUID> getParticipants() { throw new UnsupportedOperationException(); }
    @Override
    public String getName() { throw new UnsupportedOperationException(); }
    @Override
    public String getDescription() { throw new UnsupportedOperationException(); }
    @Override
    public ChallengeType getType() { throw new UnsupportedOperationException(); }
    @Override
    public ChallengeStatus getStatus() { throw new UnsupportedOperationException(); }
    @Override
    public String getDeadline() { throw new UnsupportedOperationException(); }
    @Override
    public Map<UUID, Integer> getScoreboard() { throw new UnsupportedOperationException(); }
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
  static ImmutableChallenge fromJson(Json json) {
    ImmutableChallenge.Builder builder = ImmutableChallenge.builder();
    if (json.uuid != null) {
      builder.uuid(json.uuid);
    }
    if (json.founder != null) {
      builder.founder(json.founder);
    }
    if (json.group != null) {
      builder.group(json.group);
    }
    if (json.participants != null) {
      builder.addAllParticipants(json.participants);
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
    if (json.status != null) {
      builder.status(json.status);
    }
    if (json.deadline != null) {
      builder.deadline(json.deadline);
    }
    if (json.scoreboard != null) {
      builder.putAllScoreboard(json.scoreboard);
    }
    if (json.accessType != null) {
      builder.accessType(json.accessType);
    }
    return builder.build();
  }

  /**
   * Creates an immutable copy of a {@link Challenge} value.
   * Uses accessors to get values to initialize the new immutable instance.
   * If an instance is already immutable, it is returned as is.
   * @param instance The instance to copy
   * @return A copied immutable Challenge instance
   */
  public static ImmutableChallenge copyOf(Challenge instance) {
    if (instance instanceof ImmutableChallenge) {
      return (ImmutableChallenge) instance;
    }
    return ImmutableChallenge.builder()
        .from(instance)
        .build();
  }

  /**
   * Creates a builder for {@link ImmutableChallenge ImmutableChallenge}.
   * <pre>
   * ImmutableChallenge.builder()
   *    .uuid(UUID) // required {@link Challenge#getUuid() uuid}
   *    .founder(UUID) // required {@link Challenge#getFounder() founder}
   *    .group(UUID) // required {@link Challenge#getGroup() group}
   *    .addParticipants|addAllParticipants(UUID) // {@link Challenge#getParticipants() participants} elements
   *    .name(String) // required {@link Challenge#getName() name}
   *    .description(String) // required {@link Challenge#getDescription() description}
   *    .type(com.bachelor.backend.domain.challenge.ChallengeType) // required {@link Challenge#getType() type}
   *    .status(com.bachelor.backend.domain.challenge.ChallengeStatus) // required {@link Challenge#getStatus() status}
   *    .deadline(String) // required {@link Challenge#getDeadline() deadline}
   *    .putScoreboard|putAllScoreboard(UUID =&gt; int) // {@link Challenge#getScoreboard() scoreboard} mappings
   *    .accessType(com.bachelor.backend.domain.AccessType) // required {@link Challenge#getAccessType() accessType}
   *    .build();
   * </pre>
   * @return A new ImmutableChallenge builder
   */
  public static ImmutableChallenge.Builder builder() {
    return new ImmutableChallenge.Builder();
  }

  /**
   * Builds instances of type {@link ImmutableChallenge ImmutableChallenge}.
   * Initialize attributes and then invoke the {@link #build()} method to create an
   * immutable instance.
   * <p><em>{@code Builder} is not thread-safe and generally should not be stored in a field or collection,
   * but instead used immediately to create instances.</em>
   */
  @Generated(from = "Challenge", generator = "Immutables")
  public static final class Builder {
    private static final long INIT_BIT_UUID = 0x1L;
    private static final long INIT_BIT_FOUNDER = 0x2L;
    private static final long INIT_BIT_GROUP = 0x4L;
    private static final long INIT_BIT_NAME = 0x8L;
    private static final long INIT_BIT_DESCRIPTION = 0x10L;
    private static final long INIT_BIT_TYPE = 0x20L;
    private static final long INIT_BIT_STATUS = 0x40L;
    private static final long INIT_BIT_DEADLINE = 0x80L;
    private static final long INIT_BIT_ACCESS_TYPE = 0x100L;
    private long initBits = 0x1ffL;

    private UUID uuid;
    private UUID founder;
    private UUID group;
    private List<UUID> participants = new ArrayList<UUID>();
    private String name;
    private String description;
    private ChallengeType type;
    private ChallengeStatus status;
    private String deadline;
    private Map<UUID, Integer> scoreboard = new LinkedHashMap<UUID, Integer>();
    private AccessType accessType;

    private Builder() {
    }

    /**
     * Fill a builder with attribute values from the provided {@code Challenge} instance.
     * Regular attribute values will be replaced with those from the given instance.
     * Absent optional values will not replace present values.
     * Collection elements and entries will be added, not replaced.
     * @param instance The instance from which to copy values
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder from(Challenge instance) {
      Objects.requireNonNull(instance, "instance");
      uuid(instance.getUuid());
      founder(instance.getFounder());
      group(instance.getGroup());
      addAllParticipants(instance.getParticipants());
      name(instance.getName());
      description(instance.getDescription());
      type(instance.getType());
      status(instance.getStatus());
      deadline(instance.getDeadline());
      putAllScoreboard(instance.getScoreboard());
      accessType(instance.getAccessType());
      return this;
    }

    /**
     * Initializes the value for the {@link Challenge#getUuid() uuid} attribute.
     * @param uuid The value for uuid 
     * @return {@code this} builder for use in a chained invocation
     */
    @JsonProperty("uuid")
    public final Builder uuid(UUID uuid) {
      this.uuid = Objects.requireNonNull(uuid, "uuid");
      initBits &= ~INIT_BIT_UUID;
      return this;
    }

    /**
     * Initializes the value for the {@link Challenge#getFounder() founder} attribute.
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
     * Initializes the value for the {@link Challenge#getGroup() group} attribute.
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
     * Adds one element to {@link Challenge#getParticipants() participants} list.
     * @param element A participants element
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder addParticipants(UUID element) {
      this.participants.add(Objects.requireNonNull(element, "participants element"));
      return this;
    }

    /**
     * Adds elements to {@link Challenge#getParticipants() participants} list.
     * @param elements An array of participants elements
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder addParticipants(UUID... elements) {
      for (UUID element : elements) {
        this.participants.add(Objects.requireNonNull(element, "participants element"));
      }
      return this;
    }


    /**
     * Sets or replaces all elements for {@link Challenge#getParticipants() participants} list.
     * @param elements An iterable of participants elements
     * @return {@code this} builder for use in a chained invocation
     */
    @JsonProperty("participants")
    public final Builder participants(Iterable<? extends UUID> elements) {
      this.participants.clear();
      return addAllParticipants(elements);
    }

    /**
     * Adds elements to {@link Challenge#getParticipants() participants} list.
     * @param elements An iterable of participants elements
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder addAllParticipants(Iterable<? extends UUID> elements) {
      for (UUID element : elements) {
        this.participants.add(Objects.requireNonNull(element, "participants element"));
      }
      return this;
    }

    /**
     * Initializes the value for the {@link Challenge#getName() name} attribute.
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
     * Initializes the value for the {@link Challenge#getDescription() description} attribute.
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
     * Initializes the value for the {@link Challenge#getType() type} attribute.
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
     * Initializes the value for the {@link Challenge#getStatus() status} attribute.
     * @param status The value for status 
     * @return {@code this} builder for use in a chained invocation
     */
    @JsonProperty("status")
    public final Builder status(ChallengeStatus status) {
      this.status = Objects.requireNonNull(status, "status");
      initBits &= ~INIT_BIT_STATUS;
      return this;
    }

    /**
     * Initializes the value for the {@link Challenge#getDeadline() deadline} attribute.
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
     * Put one entry to the {@link Challenge#getScoreboard() scoreboard} map.
     * @param key The key in the scoreboard map
     * @param value The associated value in the scoreboard map
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder putScoreboard(UUID key, int value) {
      this.scoreboard.put(
          Objects.requireNonNull(key, "scoreboard key"),
          Objects.requireNonNull(value, "scoreboard value"));
      return this;
    }

    /**
     * Put one entry to the {@link Challenge#getScoreboard() scoreboard} map. Nulls are not permitted
     * @param entry The key and value entry
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder putScoreboard(Map.Entry<? extends UUID, ? extends Integer> entry) {
      UUID k = entry.getKey();
      Integer v = entry.getValue();
      this.scoreboard.put(
          Objects.requireNonNull(k, "scoreboard key"),
          Objects.requireNonNull(v, "scoreboard value"));
      return this;
    }

    /**
     * Sets or replaces all mappings from the specified map as entries for the {@link Challenge#getScoreboard() scoreboard} map. Nulls are not permitted
     * @param entries The entries that will be added to the scoreboard map
     * @return {@code this} builder for use in a chained invocation
     */
    @JsonProperty("scoreboard")
    public final Builder scoreboard(Map<? extends UUID, ? extends Integer> entries) {
      this.scoreboard.clear();
      return putAllScoreboard(entries);
    }

    /**
     * Put all mappings from the specified map as entries to {@link Challenge#getScoreboard() scoreboard} map. Nulls are not permitted
     * @param entries The entries that will be added to the scoreboard map
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder putAllScoreboard(Map<? extends UUID, ? extends Integer> entries) {
      for (Map.Entry<? extends UUID, ? extends Integer> e : entries.entrySet()) {
        UUID k = e.getKey();
        Integer v = e.getValue();
        this.scoreboard.put(
            Objects.requireNonNull(k, "scoreboard key"),
            Objects.requireNonNull(v, "scoreboard value"));
      }
      return this;
    }

    /**
     * Initializes the value for the {@link Challenge#getAccessType() accessType} attribute.
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
     * Builds a new {@link ImmutableChallenge ImmutableChallenge}.
     * @return An immutable instance of Challenge
     * @throws java.lang.IllegalStateException if any required attributes are missing
     */
    public ImmutableChallenge build() {
      if (initBits != 0) {
        throw new IllegalStateException(formatRequiredAttributesMessage());
      }
      return new ImmutableChallenge(
          uuid,
          founder,
          group,
          createUnmodifiableList(true, participants),
          name,
          description,
          type,
          status,
          deadline,
          createUnmodifiableMap(false, false, scoreboard),
          accessType);
    }

    private String formatRequiredAttributesMessage() {
      List<String> attributes = new ArrayList<>();
      if ((initBits & INIT_BIT_UUID) != 0) attributes.add("uuid");
      if ((initBits & INIT_BIT_FOUNDER) != 0) attributes.add("founder");
      if ((initBits & INIT_BIT_GROUP) != 0) attributes.add("group");
      if ((initBits & INIT_BIT_NAME) != 0) attributes.add("name");
      if ((initBits & INIT_BIT_DESCRIPTION) != 0) attributes.add("description");
      if ((initBits & INIT_BIT_TYPE) != 0) attributes.add("type");
      if ((initBits & INIT_BIT_STATUS) != 0) attributes.add("status");
      if ((initBits & INIT_BIT_DEADLINE) != 0) attributes.add("deadline");
      if ((initBits & INIT_BIT_ACCESS_TYPE) != 0) attributes.add("accessType");
      return "Cannot build Challenge, some of required attributes are not set " + attributes;
    }
  }

  private static <T> List<T> createSafeList(Iterable<? extends T> iterable, boolean checkNulls, boolean skipNulls) {
    ArrayList<T> list;
    if (iterable instanceof Collection<?>) {
      int size = ((Collection<?>) iterable).size();
      if (size == 0) return Collections.emptyList();
      list = new ArrayList<>();
    } else {
      list = new ArrayList<>();
    }
    for (T element : iterable) {
      if (skipNulls && element == null) continue;
      if (checkNulls) Objects.requireNonNull(element, "element");
      list.add(element);
    }
    return list;
  }

  private static <T> List<T> createUnmodifiableList(boolean clone, List<T> list) {
    switch(list.size()) {
    case 0: return Collections.emptyList();
    case 1: return Collections.singletonList(list.get(0));
    default:
      if (clone) {
        return Collections.unmodifiableList(new ArrayList<>(list));
      } else {
        if (list instanceof ArrayList<?>) {
          ((ArrayList<?>) list).trimToSize();
        }
        return Collections.unmodifiableList(list);
      }
    }
  }

  private static <K, V> Map<K, V> createUnmodifiableMap(boolean checkNulls, boolean skipNulls, Map<? extends K, ? extends V> map) {
    switch (map.size()) {
    case 0: return Collections.emptyMap();
    case 1: {
      Map.Entry<? extends K, ? extends V> e = map.entrySet().iterator().next();
      K k = e.getKey();
      V v = e.getValue();
      if (checkNulls) {
        Objects.requireNonNull(k, "key");
        Objects.requireNonNull(v, "value");
      }
      if (skipNulls && (k == null || v == null)) {
        return Collections.emptyMap();
      }
      return Collections.singletonMap(k, v);
    }
    default: {
      Map<K, V> linkedMap = new LinkedHashMap<>(map.size());
      if (skipNulls || checkNulls) {
        for (Map.Entry<? extends K, ? extends V> e : map.entrySet()) {
          K k = e.getKey();
          V v = e.getValue();
          if (skipNulls) {
            if (k == null || v == null) continue;
          } else if (checkNulls) {
            Objects.requireNonNull(k, "key");
            Objects.requireNonNull(v, "value");
          }
          linkedMap.put(k, v);
        }
      } else {
        linkedMap.putAll(map);
      }
      return Collections.unmodifiableMap(linkedMap);
    }
    }
  }
}
