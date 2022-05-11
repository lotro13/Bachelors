package com.bachelor.backend.domain.group;

import com.bachelor.backend.domain.AccessType;
import com.bachelor.backend.domain.users.UserPage;
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
 * Immutable implementation of {@link GroupPage}.
 * <p>
 * Use the builder to create immutable instances:
 * {@code ImmutableGroupPage.builder()}.
 */
@Generated(from = "GroupPage", generator = "Immutables")
@SuppressWarnings({"all"})
@javax.annotation.processing.Generated("org.immutables.processor.ProxyProcessor")
public final class ImmutableGroupPage extends GroupPage {
  private final UUID uuid;
  private final AccessType accessType;
  private final String name;
  private final boolean canCreateChallenge;
  private final boolean canManageUsers;
  private final List<UserPage> members;
  private final List<UserPage> pendingRequests;
  private final Map<String, Integer> scoreboard;

  private ImmutableGroupPage(ImmutableGroupPage.Builder builder) {
    this.uuid = builder.uuid;
    this.accessType = builder.accessType;
    this.name = builder.name;
    this.canCreateChallenge = builder.canCreateChallenge;
    this.canManageUsers = builder.canManageUsers;
    this.members = createUnmodifiableList(true, builder.members);
    if (builder.pendingRequestsIsSet()) {
      initShim.pendingRequests(createUnmodifiableList(true, builder.pendingRequests));
    }
    if (builder.scoreboardIsSet()) {
      initShim.scoreboard(createUnmodifiableMap(false, false, builder.scoreboard));
    }
    this.pendingRequests = initShim.getPendingRequests();
    this.scoreboard = initShim.getScoreboard();
    this.initShim = null;
  }

  private ImmutableGroupPage(
      UUID uuid,
      AccessType accessType,
      String name,
      boolean canCreateChallenge,
      boolean canManageUsers,
      List<UserPage> members,
      List<UserPage> pendingRequests,
      Map<String, Integer> scoreboard) {
    this.uuid = uuid;
    this.accessType = accessType;
    this.name = name;
    this.canCreateChallenge = canCreateChallenge;
    this.canManageUsers = canManageUsers;
    this.members = members;
    this.pendingRequests = pendingRequests;
    this.scoreboard = scoreboard;
    this.initShim = null;
  }

  private static final byte STAGE_INITIALIZING = -1;
  private static final byte STAGE_UNINITIALIZED = 0;
  private static final byte STAGE_INITIALIZED = 1;
  private transient volatile InitShim initShim = new InitShim();

  @Generated(from = "GroupPage", generator = "Immutables")
  private final class InitShim {
    private byte pendingRequestsBuildStage = STAGE_UNINITIALIZED;
    private List<UserPage> pendingRequests;

    List<UserPage> getPendingRequests() {
      if (pendingRequestsBuildStage == STAGE_INITIALIZING) throw new IllegalStateException(formatInitCycleMessage());
      if (pendingRequestsBuildStage == STAGE_UNINITIALIZED) {
        pendingRequestsBuildStage = STAGE_INITIALIZING;
        this.pendingRequests = createUnmodifiableList(false, createSafeList(ImmutableGroupPage.super.getPendingRequests(), true, false));
        pendingRequestsBuildStage = STAGE_INITIALIZED;
      }
      return this.pendingRequests;
    }

    void pendingRequests(List<UserPage> pendingRequests) {
      this.pendingRequests = pendingRequests;
      pendingRequestsBuildStage = STAGE_INITIALIZED;
    }

    private byte scoreboardBuildStage = STAGE_UNINITIALIZED;
    private Map<String, Integer> scoreboard;

    Map<String, Integer> getScoreboard() {
      if (scoreboardBuildStage == STAGE_INITIALIZING) throw new IllegalStateException(formatInitCycleMessage());
      if (scoreboardBuildStage == STAGE_UNINITIALIZED) {
        scoreboardBuildStage = STAGE_INITIALIZING;
        this.scoreboard = createUnmodifiableMap(true, false, ImmutableGroupPage.super.getScoreboard());
        scoreboardBuildStage = STAGE_INITIALIZED;
      }
      return this.scoreboard;
    }

    void scoreboard(Map<String, Integer> scoreboard) {
      this.scoreboard = scoreboard;
      scoreboardBuildStage = STAGE_INITIALIZED;
    }

    private String formatInitCycleMessage() {
      List<String> attributes = new ArrayList<>();
      if (pendingRequestsBuildStage == STAGE_INITIALIZING) attributes.add("pendingRequests");
      if (scoreboardBuildStage == STAGE_INITIALIZING) attributes.add("scoreboard");
      return "Cannot build GroupPage, attribute initializers form cycle " + attributes;
    }
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
   * @return The value of the {@code canCreateChallenge} attribute
   */
  @JsonProperty("canCreateChallenge")
  @Override
  public boolean getCanCreateChallenge() {
    return canCreateChallenge;
  }

  /**
   * @return The value of the {@code canManageUsers} attribute
   */
  @JsonProperty("canManageUsers")
  @Override
  public boolean getCanManageUsers() {
    return canManageUsers;
  }

  /**
   * @return The value of the {@code members} attribute
   */
  @JsonProperty("members")
  @Override
  public List<UserPage> getMembers() {
    return members;
  }

  /**
   * @return The value of the {@code pendingRequests} attribute
   */
  @JsonProperty("pendingRequests")
  @Override
  public List<UserPage> getPendingRequests() {
    InitShim shim = this.initShim;
    return shim != null
        ? shim.getPendingRequests()
        : this.pendingRequests;
  }

  /**
   * @return The value of the {@code scoreboard} attribute
   */
  @JsonProperty("scoreboard")
  @Override
  public Map<String, Integer> getScoreboard() {
    InitShim shim = this.initShim;
    return shim != null
        ? shim.getScoreboard()
        : this.scoreboard;
  }

  /**
   * Copy the current immutable object by setting a value for the {@link GroupPage#getUuid() uuid} attribute.
   * A shallow reference equality check is used to prevent copying of the same value by returning {@code this}.
   * @param value A new value for uuid
   * @return A modified copy of the {@code this} object
   */
  public final ImmutableGroupPage withUuid(UUID value) {
    if (this.uuid == value) return this;
    UUID newValue = Objects.requireNonNull(value, "uuid");
    return new ImmutableGroupPage(
        newValue,
        this.accessType,
        this.name,
        this.canCreateChallenge,
        this.canManageUsers,
        this.members,
        this.pendingRequests,
        this.scoreboard);
  }

  /**
   * Copy the current immutable object by setting a value for the {@link GroupPage#getAccessType() accessType} attribute.
   * A value equality check is used to prevent copying of the same value by returning {@code this}.
   * @param value A new value for accessType
   * @return A modified copy of the {@code this} object
   */
  public final ImmutableGroupPage withAccessType(AccessType value) {
    AccessType newValue = Objects.requireNonNull(value, "accessType");
    if (this.accessType == newValue) return this;
    return new ImmutableGroupPage(
        this.uuid,
        newValue,
        this.name,
        this.canCreateChallenge,
        this.canManageUsers,
        this.members,
        this.pendingRequests,
        this.scoreboard);
  }

  /**
   * Copy the current immutable object by setting a value for the {@link GroupPage#getName() name} attribute.
   * An equals check used to prevent copying of the same value by returning {@code this}.
   * @param value A new value for name
   * @return A modified copy of the {@code this} object
   */
  public final ImmutableGroupPage withName(String value) {
    String newValue = Objects.requireNonNull(value, "name");
    if (this.name.equals(newValue)) return this;
    return new ImmutableGroupPage(
        this.uuid,
        this.accessType,
        newValue,
        this.canCreateChallenge,
        this.canManageUsers,
        this.members,
        this.pendingRequests,
        this.scoreboard);
  }

  /**
   * Copy the current immutable object by setting a value for the {@link GroupPage#getCanCreateChallenge() canCreateChallenge} attribute.
   * A value equality check is used to prevent copying of the same value by returning {@code this}.
   * @param value A new value for canCreateChallenge
   * @return A modified copy of the {@code this} object
   */
  public final ImmutableGroupPage withCanCreateChallenge(boolean value) {
    if (this.canCreateChallenge == value) return this;
    return new ImmutableGroupPage(
        this.uuid,
        this.accessType,
        this.name,
        value,
        this.canManageUsers,
        this.members,
        this.pendingRequests,
        this.scoreboard);
  }

  /**
   * Copy the current immutable object by setting a value for the {@link GroupPage#getCanManageUsers() canManageUsers} attribute.
   * A value equality check is used to prevent copying of the same value by returning {@code this}.
   * @param value A new value for canManageUsers
   * @return A modified copy of the {@code this} object
   */
  public final ImmutableGroupPage withCanManageUsers(boolean value) {
    if (this.canManageUsers == value) return this;
    return new ImmutableGroupPage(
        this.uuid,
        this.accessType,
        this.name,
        this.canCreateChallenge,
        value,
        this.members,
        this.pendingRequests,
        this.scoreboard);
  }

  /**
   * Copy the current immutable object with elements that replace the content of {@link GroupPage#getMembers() members}.
   * @param elements The elements to set
   * @return A modified copy of {@code this} object
   */
  public final ImmutableGroupPage withMembers(UserPage... elements) {
    List<UserPage> newValue = createUnmodifiableList(false, createSafeList(Arrays.asList(elements), true, false));
    return new ImmutableGroupPage(
        this.uuid,
        this.accessType,
        this.name,
        this.canCreateChallenge,
        this.canManageUsers,
        newValue,
        this.pendingRequests,
        this.scoreboard);
  }

  /**
   * Copy the current immutable object with elements that replace the content of {@link GroupPage#getMembers() members}.
   * A shallow reference equality check is used to prevent copying of the same value by returning {@code this}.
   * @param elements An iterable of members elements to set
   * @return A modified copy of {@code this} object
   */
  public final ImmutableGroupPage withMembers(Iterable<? extends UserPage> elements) {
    if (this.members == elements) return this;
    List<UserPage> newValue = createUnmodifiableList(false, createSafeList(elements, true, false));
    return new ImmutableGroupPage(
        this.uuid,
        this.accessType,
        this.name,
        this.canCreateChallenge,
        this.canManageUsers,
        newValue,
        this.pendingRequests,
        this.scoreboard);
  }

  /**
   * Copy the current immutable object with elements that replace the content of {@link GroupPage#getPendingRequests() pendingRequests}.
   * @param elements The elements to set
   * @return A modified copy of {@code this} object
   */
  public final ImmutableGroupPage withPendingRequests(UserPage... elements) {
    List<UserPage> newValue = createUnmodifiableList(false, createSafeList(Arrays.asList(elements), true, false));
    return new ImmutableGroupPage(
        this.uuid,
        this.accessType,
        this.name,
        this.canCreateChallenge,
        this.canManageUsers,
        this.members,
        newValue,
        this.scoreboard);
  }

  /**
   * Copy the current immutable object with elements that replace the content of {@link GroupPage#getPendingRequests() pendingRequests}.
   * A shallow reference equality check is used to prevent copying of the same value by returning {@code this}.
   * @param elements An iterable of pendingRequests elements to set
   * @return A modified copy of {@code this} object
   */
  public final ImmutableGroupPage withPendingRequests(Iterable<? extends UserPage> elements) {
    if (this.pendingRequests == elements) return this;
    List<UserPage> newValue = createUnmodifiableList(false, createSafeList(elements, true, false));
    return new ImmutableGroupPage(
        this.uuid,
        this.accessType,
        this.name,
        this.canCreateChallenge,
        this.canManageUsers,
        this.members,
        newValue,
        this.scoreboard);
  }

  /**
   * Copy the current immutable object by replacing the {@link GroupPage#getScoreboard() scoreboard} map with the specified map.
   * Nulls are not permitted as keys or values.
   * A shallow reference equality check is used to prevent copying of the same value by returning {@code this}.
   * @param entries The entries to be added to the scoreboard map
   * @return A modified copy of {@code this} object
   */
  public final ImmutableGroupPage withScoreboard(Map<String, ? extends Integer> entries) {
    if (this.scoreboard == entries) return this;
    Map<String, Integer> newValue = createUnmodifiableMap(true, false, entries);
    return new ImmutableGroupPage(
        this.uuid,
        this.accessType,
        this.name,
        this.canCreateChallenge,
        this.canManageUsers,
        this.members,
        this.pendingRequests,
        newValue);
  }

  /**
   * This instance is equal to all instances of {@code ImmutableGroupPage} that have equal attribute values.
   * @return {@code true} if {@code this} is equal to {@code another} instance
   */
  @Override
  public boolean equals(Object another) {
    if (this == another) return true;
    return another instanceof ImmutableGroupPage
        && equalTo(0, (ImmutableGroupPage) another);
  }

  private boolean equalTo(int synthetic, ImmutableGroupPage another) {
    return uuid.equals(another.uuid)
        && accessType.equals(another.accessType)
        && name.equals(another.name)
        && canCreateChallenge == another.canCreateChallenge
        && canManageUsers == another.canManageUsers
        && members.equals(another.members)
        && pendingRequests.equals(another.pendingRequests)
        && scoreboard.equals(another.scoreboard);
  }

  /**
   * Computes a hash code from attributes: {@code uuid}, {@code accessType}, {@code name}, {@code canCreateChallenge}, {@code canManageUsers}, {@code members}, {@code pendingRequests}, {@code scoreboard}.
   * @return hashCode value
   */
  @Override
  public int hashCode() {
    int h = 5381;
    h += (h << 5) + uuid.hashCode();
    h += (h << 5) + accessType.hashCode();
    h += (h << 5) + name.hashCode();
    h += (h << 5) + Boolean.hashCode(canCreateChallenge);
    h += (h << 5) + Boolean.hashCode(canManageUsers);
    h += (h << 5) + members.hashCode();
    h += (h << 5) + pendingRequests.hashCode();
    h += (h << 5) + scoreboard.hashCode();
    return h;
  }

  /**
   * Prints the immutable value {@code GroupPage} with attribute values.
   * @return A string representation of the value
   */
  @Override
  public String toString() {
    return "GroupPage{"
        + "uuid=" + uuid
        + ", accessType=" + accessType
        + ", name=" + name
        + ", canCreateChallenge=" + canCreateChallenge
        + ", canManageUsers=" + canManageUsers
        + ", members=" + members
        + ", pendingRequests=" + pendingRequests
        + ", scoreboard=" + scoreboard
        + "}";
  }

  /**
   * Utility type used to correctly read immutable object from JSON representation.
   * @deprecated Do not use this type directly, it exists only for the <em>Jackson</em>-binding infrastructure
   */
  @Generated(from = "GroupPage", generator = "Immutables")
  @Deprecated
  @JsonDeserialize
  @JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.NONE)
  static final class Json extends GroupPage {
    UUID uuid;
    AccessType accessType;
    String name;
    boolean canCreateChallenge;
    boolean canCreateChallengeIsSet;
    boolean canManageUsers;
    boolean canManageUsersIsSet;
    List<UserPage> members = Collections.emptyList();
    List<UserPage> pendingRequests = Collections.emptyList();
    boolean pendingRequestsIsSet;
    Map<String, Integer> scoreboard = Collections.emptyMap();
    boolean scoreboardIsSet;
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
    @JsonProperty("canCreateChallenge")
    public void setCanCreateChallenge(boolean canCreateChallenge) {
      this.canCreateChallenge = canCreateChallenge;
      this.canCreateChallengeIsSet = true;
    }
    @JsonProperty("canManageUsers")
    public void setCanManageUsers(boolean canManageUsers) {
      this.canManageUsers = canManageUsers;
      this.canManageUsersIsSet = true;
    }
    @JsonProperty("members")
    public void setMembers(List<UserPage> members) {
      this.members = members;
    }
    @JsonProperty("pendingRequests")
    public void setPendingRequests(List<UserPage> pendingRequests) {
      this.pendingRequests = pendingRequests;
      this.pendingRequestsIsSet = true;
    }
    @JsonProperty("scoreboard")
    public void setScoreboard(Map<String, Integer> scoreboard) {
      this.scoreboard = scoreboard;
      this.scoreboardIsSet = true;
    }
    @Override
    public UUID getUuid() { throw new UnsupportedOperationException(); }
    @Override
    public AccessType getAccessType() { throw new UnsupportedOperationException(); }
    @Override
    public String getName() { throw new UnsupportedOperationException(); }
    @Override
    public boolean getCanCreateChallenge() { throw new UnsupportedOperationException(); }
    @Override
    public boolean getCanManageUsers() { throw new UnsupportedOperationException(); }
    @Override
    public List<UserPage> getMembers() { throw new UnsupportedOperationException(); }
    @Override
    public List<UserPage> getPendingRequests() { throw new UnsupportedOperationException(); }
    @Override
    public Map<String, Integer> getScoreboard() { throw new UnsupportedOperationException(); }
  }

  /**
   * @param json A JSON-bindable data structure
   * @return An immutable value type
   * @deprecated Do not use this method directly, it exists only for the <em>Jackson</em>-binding infrastructure
   */
  @Deprecated
  @JsonCreator(mode = JsonCreator.Mode.DELEGATING)
  static ImmutableGroupPage fromJson(Json json) {
    ImmutableGroupPage.Builder builder = ImmutableGroupPage.builder();
    if (json.uuid != null) {
      builder.uuid(json.uuid);
    }
    if (json.accessType != null) {
      builder.accessType(json.accessType);
    }
    if (json.name != null) {
      builder.name(json.name);
    }
    if (json.canCreateChallengeIsSet) {
      builder.canCreateChallenge(json.canCreateChallenge);
    }
    if (json.canManageUsersIsSet) {
      builder.canManageUsers(json.canManageUsers);
    }
    if (json.members != null) {
      builder.addAllMembers(json.members);
    }
    if (json.pendingRequestsIsSet) {
      builder.addAllPendingRequests(json.pendingRequests);
    }
    if (json.scoreboardIsSet) {
      builder.putAllScoreboard(json.scoreboard);
    }
    return builder.build();
  }

  /**
   * Creates an immutable copy of a {@link GroupPage} value.
   * Uses accessors to get values to initialize the new immutable instance.
   * If an instance is already immutable, it is returned as is.
   * @param instance The instance to copy
   * @return A copied immutable GroupPage instance
   */
  public static ImmutableGroupPage copyOf(GroupPage instance) {
    if (instance instanceof ImmutableGroupPage) {
      return (ImmutableGroupPage) instance;
    }
    return ImmutableGroupPage.builder()
        .from(instance)
        .build();
  }

  /**
   * Creates a builder for {@link ImmutableGroupPage ImmutableGroupPage}.
   * <pre>
   * ImmutableGroupPage.builder()
   *    .uuid(UUID) // required {@link GroupPage#getUuid() uuid}
   *    .accessType(com.bachelor.backend.domain.AccessType) // required {@link GroupPage#getAccessType() accessType}
   *    .name(String) // required {@link GroupPage#getName() name}
   *    .canCreateChallenge(boolean) // required {@link GroupPage#getCanCreateChallenge() canCreateChallenge}
   *    .canManageUsers(boolean) // required {@link GroupPage#getCanManageUsers() canManageUsers}
   *    .addMembers|addAllMembers(com.bachelor.backend.domain.users.UserPage) // {@link GroupPage#getMembers() members} elements
   *    .addPendingRequests|addAllPendingRequests(com.bachelor.backend.domain.users.UserPage) // {@link GroupPage#getPendingRequests() pendingRequests} elements
   *    .putScoreboard|putAllScoreboard(String =&gt; int) // {@link GroupPage#getScoreboard() scoreboard} mappings
   *    .build();
   * </pre>
   * @return A new ImmutableGroupPage builder
   */
  public static ImmutableGroupPage.Builder builder() {
    return new ImmutableGroupPage.Builder();
  }

  /**
   * Builds instances of type {@link ImmutableGroupPage ImmutableGroupPage}.
   * Initialize attributes and then invoke the {@link #build()} method to create an
   * immutable instance.
   * <p><em>{@code Builder} is not thread-safe and generally should not be stored in a field or collection,
   * but instead used immediately to create instances.</em>
   */
  @Generated(from = "GroupPage", generator = "Immutables")
  public static final class Builder {
    private static final long INIT_BIT_UUID = 0x1L;
    private static final long INIT_BIT_ACCESS_TYPE = 0x2L;
    private static final long INIT_BIT_NAME = 0x4L;
    private static final long INIT_BIT_CAN_CREATE_CHALLENGE = 0x8L;
    private static final long INIT_BIT_CAN_MANAGE_USERS = 0x10L;
    private static final long OPT_BIT_PENDING_REQUESTS = 0x1L;
    private static final long OPT_BIT_SCOREBOARD = 0x2L;
    private long initBits = 0x1fL;
    private long optBits;

    private UUID uuid;
    private AccessType accessType;
    private String name;
    private boolean canCreateChallenge;
    private boolean canManageUsers;
    private List<UserPage> members = new ArrayList<UserPage>();
    private List<UserPage> pendingRequests = new ArrayList<UserPage>();
    private Map<String, Integer> scoreboard = new LinkedHashMap<String, Integer>();

    private Builder() {
    }

    /**
     * Fill a builder with attribute values from the provided {@code GroupPage} instance.
     * Regular attribute values will be replaced with those from the given instance.
     * Absent optional values will not replace present values.
     * Collection elements and entries will be added, not replaced.
     * @param instance The instance from which to copy values
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder from(GroupPage instance) {
      Objects.requireNonNull(instance, "instance");
      uuid(instance.getUuid());
      accessType(instance.getAccessType());
      name(instance.getName());
      canCreateChallenge(instance.getCanCreateChallenge());
      canManageUsers(instance.getCanManageUsers());
      addAllMembers(instance.getMembers());
      addAllPendingRequests(instance.getPendingRequests());
      putAllScoreboard(instance.getScoreboard());
      return this;
    }

    /**
     * Initializes the value for the {@link GroupPage#getUuid() uuid} attribute.
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
     * Initializes the value for the {@link GroupPage#getAccessType() accessType} attribute.
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
     * Initializes the value for the {@link GroupPage#getName() name} attribute.
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
     * Initializes the value for the {@link GroupPage#getCanCreateChallenge() canCreateChallenge} attribute.
     * @param canCreateChallenge The value for canCreateChallenge 
     * @return {@code this} builder for use in a chained invocation
     */
    @JsonProperty("canCreateChallenge")
    public final Builder canCreateChallenge(boolean canCreateChallenge) {
      this.canCreateChallenge = canCreateChallenge;
      initBits &= ~INIT_BIT_CAN_CREATE_CHALLENGE;
      return this;
    }

    /**
     * Initializes the value for the {@link GroupPage#getCanManageUsers() canManageUsers} attribute.
     * @param canManageUsers The value for canManageUsers 
     * @return {@code this} builder for use in a chained invocation
     */
    @JsonProperty("canManageUsers")
    public final Builder canManageUsers(boolean canManageUsers) {
      this.canManageUsers = canManageUsers;
      initBits &= ~INIT_BIT_CAN_MANAGE_USERS;
      return this;
    }

    /**
     * Adds one element to {@link GroupPage#getMembers() members} list.
     * @param element A members element
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder addMembers(UserPage element) {
      this.members.add(Objects.requireNonNull(element, "members element"));
      return this;
    }

    /**
     * Adds elements to {@link GroupPage#getMembers() members} list.
     * @param elements An array of members elements
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder addMembers(UserPage... elements) {
      for (UserPage element : elements) {
        this.members.add(Objects.requireNonNull(element, "members element"));
      }
      return this;
    }


    /**
     * Sets or replaces all elements for {@link GroupPage#getMembers() members} list.
     * @param elements An iterable of members elements
     * @return {@code this} builder for use in a chained invocation
     */
    @JsonProperty("members")
    public final Builder members(Iterable<? extends UserPage> elements) {
      this.members.clear();
      return addAllMembers(elements);
    }

    /**
     * Adds elements to {@link GroupPage#getMembers() members} list.
     * @param elements An iterable of members elements
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder addAllMembers(Iterable<? extends UserPage> elements) {
      for (UserPage element : elements) {
        this.members.add(Objects.requireNonNull(element, "members element"));
      }
      return this;
    }

    /**
     * Adds one element to {@link GroupPage#getPendingRequests() pendingRequests} list.
     * @param element A pendingRequests element
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder addPendingRequests(UserPage element) {
      this.pendingRequests.add(Objects.requireNonNull(element, "pendingRequests element"));
      optBits |= OPT_BIT_PENDING_REQUESTS;
      return this;
    }

    /**
     * Adds elements to {@link GroupPage#getPendingRequests() pendingRequests} list.
     * @param elements An array of pendingRequests elements
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder addPendingRequests(UserPage... elements) {
      for (UserPage element : elements) {
        this.pendingRequests.add(Objects.requireNonNull(element, "pendingRequests element"));
      }
      optBits |= OPT_BIT_PENDING_REQUESTS;
      return this;
    }


    /**
     * Sets or replaces all elements for {@link GroupPage#getPendingRequests() pendingRequests} list.
     * @param elements An iterable of pendingRequests elements
     * @return {@code this} builder for use in a chained invocation
     */
    @JsonProperty("pendingRequests")
    public final Builder pendingRequests(Iterable<? extends UserPage> elements) {
      this.pendingRequests.clear();
      return addAllPendingRequests(elements);
    }

    /**
     * Adds elements to {@link GroupPage#getPendingRequests() pendingRequests} list.
     * @param elements An iterable of pendingRequests elements
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder addAllPendingRequests(Iterable<? extends UserPage> elements) {
      for (UserPage element : elements) {
        this.pendingRequests.add(Objects.requireNonNull(element, "pendingRequests element"));
      }
      optBits |= OPT_BIT_PENDING_REQUESTS;
      return this;
    }

    /**
     * Put one entry to the {@link GroupPage#getScoreboard() scoreboard} map.
     * @param key The key in the scoreboard map
     * @param value The associated value in the scoreboard map
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder putScoreboard(String key, int value) {
      this.scoreboard.put(
          Objects.requireNonNull(key, "scoreboard key"),
          Objects.requireNonNull(value, "scoreboard value"));
      optBits |= OPT_BIT_SCOREBOARD;
      return this;
    }

    /**
     * Put one entry to the {@link GroupPage#getScoreboard() scoreboard} map. Nulls are not permitted
     * @param entry The key and value entry
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder putScoreboard(Map.Entry<String, ? extends Integer> entry) {
      String k = entry.getKey();
      Integer v = entry.getValue();
      this.scoreboard.put(
          Objects.requireNonNull(k, "scoreboard key"),
          Objects.requireNonNull(v, "scoreboard value"));
      optBits |= OPT_BIT_SCOREBOARD;
      return this;
    }

    /**
     * Sets or replaces all mappings from the specified map as entries for the {@link GroupPage#getScoreboard() scoreboard} map. Nulls are not permitted
     * @param entries The entries that will be added to the scoreboard map
     * @return {@code this} builder for use in a chained invocation
     */
    @JsonProperty("scoreboard")
    public final Builder scoreboard(Map<String, ? extends Integer> entries) {
      this.scoreboard.clear();
      optBits |= OPT_BIT_SCOREBOARD;
      return putAllScoreboard(entries);
    }

    /**
     * Put all mappings from the specified map as entries to {@link GroupPage#getScoreboard() scoreboard} map. Nulls are not permitted
     * @param entries The entries that will be added to the scoreboard map
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder putAllScoreboard(Map<String, ? extends Integer> entries) {
      for (Map.Entry<String, ? extends Integer> e : entries.entrySet()) {
        String k = e.getKey();
        Integer v = e.getValue();
        this.scoreboard.put(
            Objects.requireNonNull(k, "scoreboard key"),
            Objects.requireNonNull(v, "scoreboard value"));
      }
      optBits |= OPT_BIT_SCOREBOARD;
      return this;
    }

    /**
     * Builds a new {@link ImmutableGroupPage ImmutableGroupPage}.
     * @return An immutable instance of GroupPage
     * @throws java.lang.IllegalStateException if any required attributes are missing
     */
    public ImmutableGroupPage build() {
      if (initBits != 0) {
        throw new IllegalStateException(formatRequiredAttributesMessage());
      }
      return new ImmutableGroupPage(this);
    }

    private boolean pendingRequestsIsSet() {
      return (optBits & OPT_BIT_PENDING_REQUESTS) != 0;
    }

    private boolean scoreboardIsSet() {
      return (optBits & OPT_BIT_SCOREBOARD) != 0;
    }

    private String formatRequiredAttributesMessage() {
      List<String> attributes = new ArrayList<>();
      if ((initBits & INIT_BIT_UUID) != 0) attributes.add("uuid");
      if ((initBits & INIT_BIT_ACCESS_TYPE) != 0) attributes.add("accessType");
      if ((initBits & INIT_BIT_NAME) != 0) attributes.add("name");
      if ((initBits & INIT_BIT_CAN_CREATE_CHALLENGE) != 0) attributes.add("canCreateChallenge");
      if ((initBits & INIT_BIT_CAN_MANAGE_USERS) != 0) attributes.add("canManageUsers");
      return "Cannot build GroupPage, some of required attributes are not set " + attributes;
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
