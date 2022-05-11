package com.bachelor.backend.domain.group;

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
 * Immutable implementation of {@link Group}.
 * <p>
 * Use the builder to create immutable instances:
 * {@code ImmutableGroup.builder()}.
 */
@Generated(from = "Group", generator = "Immutables")
@SuppressWarnings({"all"})
@javax.annotation.processing.Generated("org.immutables.processor.ProxyProcessor")
public final class ImmutableGroup extends Group {
  private final UUID uuid;
  private final AccessType accessType;
  private final String name;
  private final UUID founder;
  private final List<UUID> moderators;
  private final List<UUID> members;
  private final List<UUID> pendingRequests;
  private final Map<UUID, Integer> scoreboard;

  private ImmutableGroup(ImmutableGroup.Builder builder) {
    this.uuid = builder.uuid;
    this.accessType = builder.accessType;
    this.name = builder.name;
    this.founder = builder.founder;
    this.moderators = createUnmodifiableList(true, builder.moderators);
    this.members = createUnmodifiableList(true, builder.members);
    this.scoreboard = createUnmodifiableMap(false, false, builder.scoreboard);
    this.pendingRequests = builder.pendingRequestsIsSet()
        ? createUnmodifiableList(true, builder.pendingRequests)
        : createUnmodifiableList(false, createSafeList(super.getPendingRequests(), true, false));
  }

  private ImmutableGroup(
      UUID uuid,
      AccessType accessType,
      String name,
      UUID founder,
      List<UUID> moderators,
      List<UUID> members,
      List<UUID> pendingRequests,
      Map<UUID, Integer> scoreboard) {
    this.uuid = uuid;
    this.accessType = accessType;
    this.name = name;
    this.founder = founder;
    this.moderators = moderators;
    this.members = members;
    this.pendingRequests = pendingRequests;
    this.scoreboard = scoreboard;
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
   * @return The value of the {@code moderators} attribute
   */
  @JsonProperty("moderators")
  @Override
  public List<UUID> getModerators() {
    return moderators;
  }

  /**
   * @return The value of the {@code members} attribute
   */
  @JsonProperty("members")
  @Override
  public List<UUID> getMembers() {
    return members;
  }

  /**
   * @return The value of the {@code pendingRequests} attribute
   */
  @JsonProperty("pendingRequests")
  @Override
  public List<UUID> getPendingRequests() {
    return pendingRequests;
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
   * Copy the current immutable object by setting a value for the {@link Group#getUuid() uuid} attribute.
   * A shallow reference equality check is used to prevent copying of the same value by returning {@code this}.
   * @param value A new value for uuid
   * @return A modified copy of the {@code this} object
   */
  public final ImmutableGroup withUuid(UUID value) {
    if (this.uuid == value) return this;
    UUID newValue = Objects.requireNonNull(value, "uuid");
    return new ImmutableGroup(
        newValue,
        this.accessType,
        this.name,
        this.founder,
        this.moderators,
        this.members,
        this.pendingRequests,
        this.scoreboard);
  }

  /**
   * Copy the current immutable object by setting a value for the {@link Group#getAccessType() accessType} attribute.
   * A value equality check is used to prevent copying of the same value by returning {@code this}.
   * @param value A new value for accessType
   * @return A modified copy of the {@code this} object
   */
  public final ImmutableGroup withAccessType(AccessType value) {
    AccessType newValue = Objects.requireNonNull(value, "accessType");
    if (this.accessType == newValue) return this;
    return new ImmutableGroup(
        this.uuid,
        newValue,
        this.name,
        this.founder,
        this.moderators,
        this.members,
        this.pendingRequests,
        this.scoreboard);
  }

  /**
   * Copy the current immutable object by setting a value for the {@link Group#getName() name} attribute.
   * An equals check used to prevent copying of the same value by returning {@code this}.
   * @param value A new value for name
   * @return A modified copy of the {@code this} object
   */
  public final ImmutableGroup withName(String value) {
    String newValue = Objects.requireNonNull(value, "name");
    if (this.name.equals(newValue)) return this;
    return new ImmutableGroup(
        this.uuid,
        this.accessType,
        newValue,
        this.founder,
        this.moderators,
        this.members,
        this.pendingRequests,
        this.scoreboard);
  }

  /**
   * Copy the current immutable object by setting a value for the {@link Group#getFounder() founder} attribute.
   * A shallow reference equality check is used to prevent copying of the same value by returning {@code this}.
   * @param value A new value for founder
   * @return A modified copy of the {@code this} object
   */
  public final ImmutableGroup withFounder(UUID value) {
    if (this.founder == value) return this;
    UUID newValue = Objects.requireNonNull(value, "founder");
    return new ImmutableGroup(
        this.uuid,
        this.accessType,
        this.name,
        newValue,
        this.moderators,
        this.members,
        this.pendingRequests,
        this.scoreboard);
  }

  /**
   * Copy the current immutable object with elements that replace the content of {@link Group#getModerators() moderators}.
   * @param elements The elements to set
   * @return A modified copy of {@code this} object
   */
  public final ImmutableGroup withModerators(UUID... elements) {
    List<UUID> newValue = createUnmodifiableList(false, createSafeList(Arrays.asList(elements), true, false));
    return new ImmutableGroup(
        this.uuid,
        this.accessType,
        this.name,
        this.founder,
        newValue,
        this.members,
        this.pendingRequests,
        this.scoreboard);
  }

  /**
   * Copy the current immutable object with elements that replace the content of {@link Group#getModerators() moderators}.
   * A shallow reference equality check is used to prevent copying of the same value by returning {@code this}.
   * @param elements An iterable of moderators elements to set
   * @return A modified copy of {@code this} object
   */
  public final ImmutableGroup withModerators(Iterable<? extends UUID> elements) {
    if (this.moderators == elements) return this;
    List<UUID> newValue = createUnmodifiableList(false, createSafeList(elements, true, false));
    return new ImmutableGroup(
        this.uuid,
        this.accessType,
        this.name,
        this.founder,
        newValue,
        this.members,
        this.pendingRequests,
        this.scoreboard);
  }

  /**
   * Copy the current immutable object with elements that replace the content of {@link Group#getMembers() members}.
   * @param elements The elements to set
   * @return A modified copy of {@code this} object
   */
  public final ImmutableGroup withMembers(UUID... elements) {
    List<UUID> newValue = createUnmodifiableList(false, createSafeList(Arrays.asList(elements), true, false));
    return new ImmutableGroup(
        this.uuid,
        this.accessType,
        this.name,
        this.founder,
        this.moderators,
        newValue,
        this.pendingRequests,
        this.scoreboard);
  }

  /**
   * Copy the current immutable object with elements that replace the content of {@link Group#getMembers() members}.
   * A shallow reference equality check is used to prevent copying of the same value by returning {@code this}.
   * @param elements An iterable of members elements to set
   * @return A modified copy of {@code this} object
   */
  public final ImmutableGroup withMembers(Iterable<? extends UUID> elements) {
    if (this.members == elements) return this;
    List<UUID> newValue = createUnmodifiableList(false, createSafeList(elements, true, false));
    return new ImmutableGroup(
        this.uuid,
        this.accessType,
        this.name,
        this.founder,
        this.moderators,
        newValue,
        this.pendingRequests,
        this.scoreboard);
  }

  /**
   * Copy the current immutable object with elements that replace the content of {@link Group#getPendingRequests() pendingRequests}.
   * @param elements The elements to set
   * @return A modified copy of {@code this} object
   */
  public final ImmutableGroup withPendingRequests(UUID... elements) {
    List<UUID> newValue = createUnmodifiableList(false, createSafeList(Arrays.asList(elements), true, false));
    return new ImmutableGroup(
        this.uuid,
        this.accessType,
        this.name,
        this.founder,
        this.moderators,
        this.members,
        newValue,
        this.scoreboard);
  }

  /**
   * Copy the current immutable object with elements that replace the content of {@link Group#getPendingRequests() pendingRequests}.
   * A shallow reference equality check is used to prevent copying of the same value by returning {@code this}.
   * @param elements An iterable of pendingRequests elements to set
   * @return A modified copy of {@code this} object
   */
  public final ImmutableGroup withPendingRequests(Iterable<? extends UUID> elements) {
    if (this.pendingRequests == elements) return this;
    List<UUID> newValue = createUnmodifiableList(false, createSafeList(elements, true, false));
    return new ImmutableGroup(
        this.uuid,
        this.accessType,
        this.name,
        this.founder,
        this.moderators,
        this.members,
        newValue,
        this.scoreboard);
  }

  /**
   * Copy the current immutable object by replacing the {@link Group#getScoreboard() scoreboard} map with the specified map.
   * Nulls are not permitted as keys or values.
   * A shallow reference equality check is used to prevent copying of the same value by returning {@code this}.
   * @param entries The entries to be added to the scoreboard map
   * @return A modified copy of {@code this} object
   */
  public final ImmutableGroup withScoreboard(Map<? extends UUID, ? extends Integer> entries) {
    if (this.scoreboard == entries) return this;
    Map<UUID, Integer> newValue = createUnmodifiableMap(true, false, entries);
    return new ImmutableGroup(
        this.uuid,
        this.accessType,
        this.name,
        this.founder,
        this.moderators,
        this.members,
        this.pendingRequests,
        newValue);
  }

  /**
   * This instance is equal to all instances of {@code ImmutableGroup} that have equal attribute values.
   * @return {@code true} if {@code this} is equal to {@code another} instance
   */
  @Override
  public boolean equals(Object another) {
    if (this == another) return true;
    return another instanceof ImmutableGroup
        && equalTo(0, (ImmutableGroup) another);
  }

  private boolean equalTo(int synthetic, ImmutableGroup another) {
    return uuid.equals(another.uuid)
        && accessType.equals(another.accessType)
        && name.equals(another.name)
        && founder.equals(another.founder)
        && moderators.equals(another.moderators)
        && members.equals(another.members)
        && pendingRequests.equals(another.pendingRequests)
        && scoreboard.equals(another.scoreboard);
  }

  /**
   * Computes a hash code from attributes: {@code uuid}, {@code accessType}, {@code name}, {@code founder}, {@code moderators}, {@code members}, {@code pendingRequests}, {@code scoreboard}.
   * @return hashCode value
   */
  @Override
  public int hashCode() {
    int h = 5381;
    h += (h << 5) + uuid.hashCode();
    h += (h << 5) + accessType.hashCode();
    h += (h << 5) + name.hashCode();
    h += (h << 5) + founder.hashCode();
    h += (h << 5) + moderators.hashCode();
    h += (h << 5) + members.hashCode();
    h += (h << 5) + pendingRequests.hashCode();
    h += (h << 5) + scoreboard.hashCode();
    return h;
  }

  /**
   * Prints the immutable value {@code Group} with attribute values.
   * @return A string representation of the value
   */
  @Override
  public String toString() {
    return "Group{"
        + "uuid=" + uuid
        + ", accessType=" + accessType
        + ", name=" + name
        + ", founder=" + founder
        + ", moderators=" + moderators
        + ", members=" + members
        + ", pendingRequests=" + pendingRequests
        + ", scoreboard=" + scoreboard
        + "}";
  }

  /**
   * Utility type used to correctly read immutable object from JSON representation.
   * @deprecated Do not use this type directly, it exists only for the <em>Jackson</em>-binding infrastructure
   */
  @Generated(from = "Group", generator = "Immutables")
  @Deprecated
  @JsonDeserialize
  @JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.NONE)
  static final class Json extends Group {
    UUID uuid;
    AccessType accessType;
    String name;
    UUID founder;
    List<UUID> moderators = Collections.emptyList();
    List<UUID> members = Collections.emptyList();
    List<UUID> pendingRequests = Collections.emptyList();
    boolean pendingRequestsIsSet;
    Map<UUID, Integer> scoreboard = Collections.emptyMap();
    @JsonProperty("uuid")
    public void setUuid(UUID uuid) {
      this.uuid = uuid;
    }
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
    @JsonProperty("moderators")
    public void setModerators(List<UUID> moderators) {
      this.moderators = moderators;
    }
    @JsonProperty("members")
    public void setMembers(List<UUID> members) {
      this.members = members;
    }
    @JsonProperty("pendingRequests")
    public void setPendingRequests(List<UUID> pendingRequests) {
      this.pendingRequests = pendingRequests;
      this.pendingRequestsIsSet = true;
    }
    @JsonProperty("scoreboard")
    public void setScoreboard(Map<UUID, Integer> scoreboard) {
      this.scoreboard = scoreboard;
    }
    @Override
    public UUID getUuid() { throw new UnsupportedOperationException(); }
    @Override
    public AccessType getAccessType() { throw new UnsupportedOperationException(); }
    @Override
    public String getName() { throw new UnsupportedOperationException(); }
    @Override
    public UUID getFounder() { throw new UnsupportedOperationException(); }
    @Override
    public List<UUID> getModerators() { throw new UnsupportedOperationException(); }
    @Override
    public List<UUID> getMembers() { throw new UnsupportedOperationException(); }
    @Override
    public List<UUID> getPendingRequests() { throw new UnsupportedOperationException(); }
    @Override
    public Map<UUID, Integer> getScoreboard() { throw new UnsupportedOperationException(); }
  }

  /**
   * @param json A JSON-bindable data structure
   * @return An immutable value type
   * @deprecated Do not use this method directly, it exists only for the <em>Jackson</em>-binding infrastructure
   */
  @Deprecated
  @JsonCreator(mode = JsonCreator.Mode.DELEGATING)
  static ImmutableGroup fromJson(Json json) {
    ImmutableGroup.Builder builder = ImmutableGroup.builder();
    if (json.uuid != null) {
      builder.uuid(json.uuid);
    }
    if (json.accessType != null) {
      builder.accessType(json.accessType);
    }
    if (json.name != null) {
      builder.name(json.name);
    }
    if (json.founder != null) {
      builder.founder(json.founder);
    }
    if (json.moderators != null) {
      builder.addAllModerators(json.moderators);
    }
    if (json.members != null) {
      builder.addAllMembers(json.members);
    }
    if (json.pendingRequestsIsSet) {
      builder.addAllPendingRequests(json.pendingRequests);
    }
    if (json.scoreboard != null) {
      builder.putAllScoreboard(json.scoreboard);
    }
    return builder.build();
  }

  /**
   * Creates an immutable copy of a {@link Group} value.
   * Uses accessors to get values to initialize the new immutable instance.
   * If an instance is already immutable, it is returned as is.
   * @param instance The instance to copy
   * @return A copied immutable Group instance
   */
  public static ImmutableGroup copyOf(Group instance) {
    if (instance instanceof ImmutableGroup) {
      return (ImmutableGroup) instance;
    }
    return ImmutableGroup.builder()
        .from(instance)
        .build();
  }

  /**
   * Creates a builder for {@link ImmutableGroup ImmutableGroup}.
   * <pre>
   * ImmutableGroup.builder()
   *    .uuid(UUID) // required {@link Group#getUuid() uuid}
   *    .accessType(com.bachelor.backend.domain.AccessType) // required {@link Group#getAccessType() accessType}
   *    .name(String) // required {@link Group#getName() name}
   *    .founder(UUID) // required {@link Group#getFounder() founder}
   *    .addModerators|addAllModerators(UUID) // {@link Group#getModerators() moderators} elements
   *    .addMembers|addAllMembers(UUID) // {@link Group#getMembers() members} elements
   *    .addPendingRequests|addAllPendingRequests(UUID) // {@link Group#getPendingRequests() pendingRequests} elements
   *    .putScoreboard|putAllScoreboard(UUID =&gt; int) // {@link Group#getScoreboard() scoreboard} mappings
   *    .build();
   * </pre>
   * @return A new ImmutableGroup builder
   */
  public static ImmutableGroup.Builder builder() {
    return new ImmutableGroup.Builder();
  }

  /**
   * Builds instances of type {@link ImmutableGroup ImmutableGroup}.
   * Initialize attributes and then invoke the {@link #build()} method to create an
   * immutable instance.
   * <p><em>{@code Builder} is not thread-safe and generally should not be stored in a field or collection,
   * but instead used immediately to create instances.</em>
   */
  @Generated(from = "Group", generator = "Immutables")
  public static final class Builder {
    private static final long INIT_BIT_UUID = 0x1L;
    private static final long INIT_BIT_ACCESS_TYPE = 0x2L;
    private static final long INIT_BIT_NAME = 0x4L;
    private static final long INIT_BIT_FOUNDER = 0x8L;
    private static final long OPT_BIT_PENDING_REQUESTS = 0x1L;
    private long initBits = 0xfL;
    private long optBits;

    private UUID uuid;
    private AccessType accessType;
    private String name;
    private UUID founder;
    private List<UUID> moderators = new ArrayList<UUID>();
    private List<UUID> members = new ArrayList<UUID>();
    private List<UUID> pendingRequests = new ArrayList<UUID>();
    private Map<UUID, Integer> scoreboard = new LinkedHashMap<UUID, Integer>();

    private Builder() {
    }

    /**
     * Fill a builder with attribute values from the provided {@code Group} instance.
     * Regular attribute values will be replaced with those from the given instance.
     * Absent optional values will not replace present values.
     * Collection elements and entries will be added, not replaced.
     * @param instance The instance from which to copy values
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder from(Group instance) {
      Objects.requireNonNull(instance, "instance");
      uuid(instance.getUuid());
      accessType(instance.getAccessType());
      name(instance.getName());
      founder(instance.getFounder());
      addAllModerators(instance.getModerators());
      addAllMembers(instance.getMembers());
      addAllPendingRequests(instance.getPendingRequests());
      putAllScoreboard(instance.getScoreboard());
      return this;
    }

    /**
     * Initializes the value for the {@link Group#getUuid() uuid} attribute.
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
     * Initializes the value for the {@link Group#getAccessType() accessType} attribute.
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
     * Initializes the value for the {@link Group#getName() name} attribute.
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
     * Initializes the value for the {@link Group#getFounder() founder} attribute.
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
     * Adds one element to {@link Group#getModerators() moderators} list.
     * @param element A moderators element
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder addModerators(UUID element) {
      this.moderators.add(Objects.requireNonNull(element, "moderators element"));
      return this;
    }

    /**
     * Adds elements to {@link Group#getModerators() moderators} list.
     * @param elements An array of moderators elements
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder addModerators(UUID... elements) {
      for (UUID element : elements) {
        this.moderators.add(Objects.requireNonNull(element, "moderators element"));
      }
      return this;
    }


    /**
     * Sets or replaces all elements for {@link Group#getModerators() moderators} list.
     * @param elements An iterable of moderators elements
     * @return {@code this} builder for use in a chained invocation
     */
    @JsonProperty("moderators")
    public final Builder moderators(Iterable<? extends UUID> elements) {
      this.moderators.clear();
      return addAllModerators(elements);
    }

    /**
     * Adds elements to {@link Group#getModerators() moderators} list.
     * @param elements An iterable of moderators elements
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder addAllModerators(Iterable<? extends UUID> elements) {
      for (UUID element : elements) {
        this.moderators.add(Objects.requireNonNull(element, "moderators element"));
      }
      return this;
    }

    /**
     * Adds one element to {@link Group#getMembers() members} list.
     * @param element A members element
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder addMembers(UUID element) {
      this.members.add(Objects.requireNonNull(element, "members element"));
      return this;
    }

    /**
     * Adds elements to {@link Group#getMembers() members} list.
     * @param elements An array of members elements
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder addMembers(UUID... elements) {
      for (UUID element : elements) {
        this.members.add(Objects.requireNonNull(element, "members element"));
      }
      return this;
    }


    /**
     * Sets or replaces all elements for {@link Group#getMembers() members} list.
     * @param elements An iterable of members elements
     * @return {@code this} builder for use in a chained invocation
     */
    @JsonProperty("members")
    public final Builder members(Iterable<? extends UUID> elements) {
      this.members.clear();
      return addAllMembers(elements);
    }

    /**
     * Adds elements to {@link Group#getMembers() members} list.
     * @param elements An iterable of members elements
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder addAllMembers(Iterable<? extends UUID> elements) {
      for (UUID element : elements) {
        this.members.add(Objects.requireNonNull(element, "members element"));
      }
      return this;
    }

    /**
     * Adds one element to {@link Group#getPendingRequests() pendingRequests} list.
     * @param element A pendingRequests element
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder addPendingRequests(UUID element) {
      this.pendingRequests.add(Objects.requireNonNull(element, "pendingRequests element"));
      optBits |= OPT_BIT_PENDING_REQUESTS;
      return this;
    }

    /**
     * Adds elements to {@link Group#getPendingRequests() pendingRequests} list.
     * @param elements An array of pendingRequests elements
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder addPendingRequests(UUID... elements) {
      for (UUID element : elements) {
        this.pendingRequests.add(Objects.requireNonNull(element, "pendingRequests element"));
      }
      optBits |= OPT_BIT_PENDING_REQUESTS;
      return this;
    }


    /**
     * Sets or replaces all elements for {@link Group#getPendingRequests() pendingRequests} list.
     * @param elements An iterable of pendingRequests elements
     * @return {@code this} builder for use in a chained invocation
     */
    @JsonProperty("pendingRequests")
    public final Builder pendingRequests(Iterable<? extends UUID> elements) {
      this.pendingRequests.clear();
      return addAllPendingRequests(elements);
    }

    /**
     * Adds elements to {@link Group#getPendingRequests() pendingRequests} list.
     * @param elements An iterable of pendingRequests elements
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder addAllPendingRequests(Iterable<? extends UUID> elements) {
      for (UUID element : elements) {
        this.pendingRequests.add(Objects.requireNonNull(element, "pendingRequests element"));
      }
      optBits |= OPT_BIT_PENDING_REQUESTS;
      return this;
    }

    /**
     * Put one entry to the {@link Group#getScoreboard() scoreboard} map.
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
     * Put one entry to the {@link Group#getScoreboard() scoreboard} map. Nulls are not permitted
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
     * Sets or replaces all mappings from the specified map as entries for the {@link Group#getScoreboard() scoreboard} map. Nulls are not permitted
     * @param entries The entries that will be added to the scoreboard map
     * @return {@code this} builder for use in a chained invocation
     */
    @JsonProperty("scoreboard")
    public final Builder scoreboard(Map<? extends UUID, ? extends Integer> entries) {
      this.scoreboard.clear();
      return putAllScoreboard(entries);
    }

    /**
     * Put all mappings from the specified map as entries to {@link Group#getScoreboard() scoreboard} map. Nulls are not permitted
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
     * Builds a new {@link ImmutableGroup ImmutableGroup}.
     * @return An immutable instance of Group
     * @throws java.lang.IllegalStateException if any required attributes are missing
     */
    public ImmutableGroup build() {
      if (initBits != 0) {
        throw new IllegalStateException(formatRequiredAttributesMessage());
      }
      return new ImmutableGroup(this);
    }

    private boolean pendingRequestsIsSet() {
      return (optBits & OPT_BIT_PENDING_REQUESTS) != 0;
    }

    private String formatRequiredAttributesMessage() {
      List<String> attributes = new ArrayList<>();
      if ((initBits & INIT_BIT_UUID) != 0) attributes.add("uuid");
      if ((initBits & INIT_BIT_ACCESS_TYPE) != 0) attributes.add("accessType");
      if ((initBits & INIT_BIT_NAME) != 0) attributes.add("name");
      if ((initBits & INIT_BIT_FOUNDER) != 0) attributes.add("founder");
      return "Cannot build Group, some of required attributes are not set " + attributes;
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
