package com.bachelor.backend.domain.challenge;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.UUID;
import org.immutables.value.Generated;

/**
 * Immutable implementation of {@link ChallengePage}.
 * <p>
 * Use the builder to create immutable instances:
 * {@code ImmutableChallengePage.builder()}.
 */
@Generated(from = "ChallengePage", generator = "Immutables")
@SuppressWarnings({"all"})
@javax.annotation.processing.Generated("org.immutables.processor.ProxyProcessor")
public final class ImmutableChallengePage extends ChallengePage {
  private final UUID uuid;
  private final String name;
  private final String description;
  private final String deadline;
  private final ChallengeStatus status;
  private final ChallengeType type;
  private final boolean canManageStatus;
  private final boolean canCreatePost;
  private final boolean canCreateRatedPost;
  private final Map<String, Integer> scoreboard;

  private ImmutableChallengePage(ImmutableChallengePage.Builder builder) {
    this.uuid = builder.uuid;
    this.name = builder.name;
    this.description = builder.description;
    this.deadline = builder.deadline;
    this.status = builder.status;
    this.type = builder.type;
    this.canManageStatus = builder.canManageStatus;
    this.canCreatePost = builder.canCreatePost;
    this.canCreateRatedPost = builder.canCreateRatedPost;
    this.scoreboard = builder.scoreboardIsSet()
        ? createUnmodifiableMap(false, false, builder.scoreboard)
        : createUnmodifiableMap(true, false, super.getScoreboard());
  }

  private ImmutableChallengePage(
      UUID uuid,
      String name,
      String description,
      String deadline,
      ChallengeStatus status,
      ChallengeType type,
      boolean canManageStatus,
      boolean canCreatePost,
      boolean canCreateRatedPost,
      Map<String, Integer> scoreboard) {
    this.uuid = uuid;
    this.name = name;
    this.description = description;
    this.deadline = deadline;
    this.status = status;
    this.type = type;
    this.canManageStatus = canManageStatus;
    this.canCreatePost = canCreatePost;
    this.canCreateRatedPost = canCreateRatedPost;
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
   * @return The value of the {@code deadline} attribute
   */
  @JsonProperty("deadline")
  @Override
  public String getDeadline() {
    return deadline;
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
   * @return The value of the {@code type} attribute
   */
  @JsonProperty("type")
  @Override
  public ChallengeType getType() {
    return type;
  }

  /**
   * @return The value of the {@code canManageStatus} attribute
   */
  @JsonProperty("canManageStatus")
  @Override
  public boolean getCanManageStatus() {
    return canManageStatus;
  }

  /**
   * @return The value of the {@code canCreatePost} attribute
   */
  @JsonProperty("canCreatePost")
  @Override
  public boolean getCanCreatePost() {
    return canCreatePost;
  }

  /**
   * @return The value of the {@code canCreateRatedPost} attribute
   */
  @JsonProperty("canCreateRatedPost")
  @Override
  public boolean getCanCreateRatedPost() {
    return canCreateRatedPost;
  }

  /**
   * @return The value of the {@code scoreboard} attribute
   */
  @JsonProperty("scoreboard")
  @Override
  public Map<String, Integer> getScoreboard() {
    return scoreboard;
  }

  /**
   * Copy the current immutable object by setting a value for the {@link ChallengePage#getUuid() uuid} attribute.
   * A shallow reference equality check is used to prevent copying of the same value by returning {@code this}.
   * @param value A new value for uuid
   * @return A modified copy of the {@code this} object
   */
  public final ImmutableChallengePage withUuid(UUID value) {
    if (this.uuid == value) return this;
    UUID newValue = Objects.requireNonNull(value, "uuid");
    return new ImmutableChallengePage(
        newValue,
        this.name,
        this.description,
        this.deadline,
        this.status,
        this.type,
        this.canManageStatus,
        this.canCreatePost,
        this.canCreateRatedPost,
        this.scoreboard);
  }

  /**
   * Copy the current immutable object by setting a value for the {@link ChallengePage#getName() name} attribute.
   * An equals check used to prevent copying of the same value by returning {@code this}.
   * @param value A new value for name
   * @return A modified copy of the {@code this} object
   */
  public final ImmutableChallengePage withName(String value) {
    String newValue = Objects.requireNonNull(value, "name");
    if (this.name.equals(newValue)) return this;
    return new ImmutableChallengePage(
        this.uuid,
        newValue,
        this.description,
        this.deadline,
        this.status,
        this.type,
        this.canManageStatus,
        this.canCreatePost,
        this.canCreateRatedPost,
        this.scoreboard);
  }

  /**
   * Copy the current immutable object by setting a value for the {@link ChallengePage#getDescription() description} attribute.
   * An equals check used to prevent copying of the same value by returning {@code this}.
   * @param value A new value for description
   * @return A modified copy of the {@code this} object
   */
  public final ImmutableChallengePage withDescription(String value) {
    String newValue = Objects.requireNonNull(value, "description");
    if (this.description.equals(newValue)) return this;
    return new ImmutableChallengePage(
        this.uuid,
        this.name,
        newValue,
        this.deadline,
        this.status,
        this.type,
        this.canManageStatus,
        this.canCreatePost,
        this.canCreateRatedPost,
        this.scoreboard);
  }

  /**
   * Copy the current immutable object by setting a value for the {@link ChallengePage#getDeadline() deadline} attribute.
   * An equals check used to prevent copying of the same value by returning {@code this}.
   * @param value A new value for deadline
   * @return A modified copy of the {@code this} object
   */
  public final ImmutableChallengePage withDeadline(String value) {
    String newValue = Objects.requireNonNull(value, "deadline");
    if (this.deadline.equals(newValue)) return this;
    return new ImmutableChallengePage(
        this.uuid,
        this.name,
        this.description,
        newValue,
        this.status,
        this.type,
        this.canManageStatus,
        this.canCreatePost,
        this.canCreateRatedPost,
        this.scoreboard);
  }

  /**
   * Copy the current immutable object by setting a value for the {@link ChallengePage#getStatus() status} attribute.
   * A value equality check is used to prevent copying of the same value by returning {@code this}.
   * @param value A new value for status
   * @return A modified copy of the {@code this} object
   */
  public final ImmutableChallengePage withStatus(ChallengeStatus value) {
    ChallengeStatus newValue = Objects.requireNonNull(value, "status");
    if (this.status == newValue) return this;
    return new ImmutableChallengePage(
        this.uuid,
        this.name,
        this.description,
        this.deadline,
        newValue,
        this.type,
        this.canManageStatus,
        this.canCreatePost,
        this.canCreateRatedPost,
        this.scoreboard);
  }

  /**
   * Copy the current immutable object by setting a value for the {@link ChallengePage#getType() type} attribute.
   * A value equality check is used to prevent copying of the same value by returning {@code this}.
   * @param value A new value for type
   * @return A modified copy of the {@code this} object
   */
  public final ImmutableChallengePage withType(ChallengeType value) {
    ChallengeType newValue = Objects.requireNonNull(value, "type");
    if (this.type == newValue) return this;
    return new ImmutableChallengePage(
        this.uuid,
        this.name,
        this.description,
        this.deadline,
        this.status,
        newValue,
        this.canManageStatus,
        this.canCreatePost,
        this.canCreateRatedPost,
        this.scoreboard);
  }

  /**
   * Copy the current immutable object by setting a value for the {@link ChallengePage#getCanManageStatus() canManageStatus} attribute.
   * A value equality check is used to prevent copying of the same value by returning {@code this}.
   * @param value A new value for canManageStatus
   * @return A modified copy of the {@code this} object
   */
  public final ImmutableChallengePage withCanManageStatus(boolean value) {
    if (this.canManageStatus == value) return this;
    return new ImmutableChallengePage(
        this.uuid,
        this.name,
        this.description,
        this.deadline,
        this.status,
        this.type,
        value,
        this.canCreatePost,
        this.canCreateRatedPost,
        this.scoreboard);
  }

  /**
   * Copy the current immutable object by setting a value for the {@link ChallengePage#getCanCreatePost() canCreatePost} attribute.
   * A value equality check is used to prevent copying of the same value by returning {@code this}.
   * @param value A new value for canCreatePost
   * @return A modified copy of the {@code this} object
   */
  public final ImmutableChallengePage withCanCreatePost(boolean value) {
    if (this.canCreatePost == value) return this;
    return new ImmutableChallengePage(
        this.uuid,
        this.name,
        this.description,
        this.deadline,
        this.status,
        this.type,
        this.canManageStatus,
        value,
        this.canCreateRatedPost,
        this.scoreboard);
  }

  /**
   * Copy the current immutable object by setting a value for the {@link ChallengePage#getCanCreateRatedPost() canCreateRatedPost} attribute.
   * A value equality check is used to prevent copying of the same value by returning {@code this}.
   * @param value A new value for canCreateRatedPost
   * @return A modified copy of the {@code this} object
   */
  public final ImmutableChallengePage withCanCreateRatedPost(boolean value) {
    if (this.canCreateRatedPost == value) return this;
    return new ImmutableChallengePage(
        this.uuid,
        this.name,
        this.description,
        this.deadline,
        this.status,
        this.type,
        this.canManageStatus,
        this.canCreatePost,
        value,
        this.scoreboard);
  }

  /**
   * Copy the current immutable object by replacing the {@link ChallengePage#getScoreboard() scoreboard} map with the specified map.
   * Nulls are not permitted as keys or values.
   * A shallow reference equality check is used to prevent copying of the same value by returning {@code this}.
   * @param entries The entries to be added to the scoreboard map
   * @return A modified copy of {@code this} object
   */
  public final ImmutableChallengePage withScoreboard(Map<String, ? extends Integer> entries) {
    if (this.scoreboard == entries) return this;
    Map<String, Integer> newValue = createUnmodifiableMap(true, false, entries);
    return new ImmutableChallengePage(
        this.uuid,
        this.name,
        this.description,
        this.deadline,
        this.status,
        this.type,
        this.canManageStatus,
        this.canCreatePost,
        this.canCreateRatedPost,
        newValue);
  }

  /**
   * This instance is equal to all instances of {@code ImmutableChallengePage} that have equal attribute values.
   * @return {@code true} if {@code this} is equal to {@code another} instance
   */
  @Override
  public boolean equals(Object another) {
    if (this == another) return true;
    return another instanceof ImmutableChallengePage
        && equalTo(0, (ImmutableChallengePage) another);
  }

  private boolean equalTo(int synthetic, ImmutableChallengePage another) {
    return uuid.equals(another.uuid)
        && name.equals(another.name)
        && description.equals(another.description)
        && deadline.equals(another.deadline)
        && status.equals(another.status)
        && type.equals(another.type)
        && canManageStatus == another.canManageStatus
        && canCreatePost == another.canCreatePost
        && canCreateRatedPost == another.canCreateRatedPost
        && scoreboard.equals(another.scoreboard);
  }

  /**
   * Computes a hash code from attributes: {@code uuid}, {@code name}, {@code description}, {@code deadline}, {@code status}, {@code type}, {@code canManageStatus}, {@code canCreatePost}, {@code canCreateRatedPost}, {@code scoreboard}.
   * @return hashCode value
   */
  @Override
  public int hashCode() {
    int h = 5381;
    h += (h << 5) + uuid.hashCode();
    h += (h << 5) + name.hashCode();
    h += (h << 5) + description.hashCode();
    h += (h << 5) + deadline.hashCode();
    h += (h << 5) + status.hashCode();
    h += (h << 5) + type.hashCode();
    h += (h << 5) + Boolean.hashCode(canManageStatus);
    h += (h << 5) + Boolean.hashCode(canCreatePost);
    h += (h << 5) + Boolean.hashCode(canCreateRatedPost);
    h += (h << 5) + scoreboard.hashCode();
    return h;
  }

  /**
   * Prints the immutable value {@code ChallengePage} with attribute values.
   * @return A string representation of the value
   */
  @Override
  public String toString() {
    return "ChallengePage{"
        + "uuid=" + uuid
        + ", name=" + name
        + ", description=" + description
        + ", deadline=" + deadline
        + ", status=" + status
        + ", type=" + type
        + ", canManageStatus=" + canManageStatus
        + ", canCreatePost=" + canCreatePost
        + ", canCreateRatedPost=" + canCreateRatedPost
        + ", scoreboard=" + scoreboard
        + "}";
  }

  /**
   * Utility type used to correctly read immutable object from JSON representation.
   * @deprecated Do not use this type directly, it exists only for the <em>Jackson</em>-binding infrastructure
   */
  @Generated(from = "ChallengePage", generator = "Immutables")
  @Deprecated
  @JsonDeserialize
  @JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.NONE)
  static final class Json extends ChallengePage {
    UUID uuid;
    String name;
    String description;
    String deadline;
    ChallengeStatus status;
    ChallengeType type;
    boolean canManageStatus;
    boolean canManageStatusIsSet;
    boolean canCreatePost;
    boolean canCreatePostIsSet;
    boolean canCreateRatedPost;
    boolean canCreateRatedPostIsSet;
    Map<String, Integer> scoreboard = Collections.emptyMap();
    boolean scoreboardIsSet;
    @JsonProperty("uuid")
    public void setUuid(UUID uuid) {
      this.uuid = uuid;
    }
    @JsonProperty("name")
    public void setName(String name) {
      this.name = name;
    }
    @JsonProperty("description")
    public void setDescription(String description) {
      this.description = description;
    }
    @JsonProperty("deadline")
    public void setDeadline(String deadline) {
      this.deadline = deadline;
    }
    @JsonProperty("status")
    public void setStatus(ChallengeStatus status) {
      this.status = status;
    }
    @JsonProperty("type")
    public void setType(ChallengeType type) {
      this.type = type;
    }
    @JsonProperty("canManageStatus")
    public void setCanManageStatus(boolean canManageStatus) {
      this.canManageStatus = canManageStatus;
      this.canManageStatusIsSet = true;
    }
    @JsonProperty("canCreatePost")
    public void setCanCreatePost(boolean canCreatePost) {
      this.canCreatePost = canCreatePost;
      this.canCreatePostIsSet = true;
    }
    @JsonProperty("canCreateRatedPost")
    public void setCanCreateRatedPost(boolean canCreateRatedPost) {
      this.canCreateRatedPost = canCreateRatedPost;
      this.canCreateRatedPostIsSet = true;
    }
    @JsonProperty("scoreboard")
    public void setScoreboard(Map<String, Integer> scoreboard) {
      this.scoreboard = scoreboard;
      this.scoreboardIsSet = true;
    }
    @Override
    public UUID getUuid() { throw new UnsupportedOperationException(); }
    @Override
    public String getName() { throw new UnsupportedOperationException(); }
    @Override
    public String getDescription() { throw new UnsupportedOperationException(); }
    @Override
    public String getDeadline() { throw new UnsupportedOperationException(); }
    @Override
    public ChallengeStatus getStatus() { throw new UnsupportedOperationException(); }
    @Override
    public ChallengeType getType() { throw new UnsupportedOperationException(); }
    @Override
    public boolean getCanManageStatus() { throw new UnsupportedOperationException(); }
    @Override
    public boolean getCanCreatePost() { throw new UnsupportedOperationException(); }
    @Override
    public boolean getCanCreateRatedPost() { throw new UnsupportedOperationException(); }
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
  static ImmutableChallengePage fromJson(Json json) {
    ImmutableChallengePage.Builder builder = ImmutableChallengePage.builder();
    if (json.uuid != null) {
      builder.uuid(json.uuid);
    }
    if (json.name != null) {
      builder.name(json.name);
    }
    if (json.description != null) {
      builder.description(json.description);
    }
    if (json.deadline != null) {
      builder.deadline(json.deadline);
    }
    if (json.status != null) {
      builder.status(json.status);
    }
    if (json.type != null) {
      builder.type(json.type);
    }
    if (json.canManageStatusIsSet) {
      builder.canManageStatus(json.canManageStatus);
    }
    if (json.canCreatePostIsSet) {
      builder.canCreatePost(json.canCreatePost);
    }
    if (json.canCreateRatedPostIsSet) {
      builder.canCreateRatedPost(json.canCreateRatedPost);
    }
    if (json.scoreboardIsSet) {
      builder.putAllScoreboard(json.scoreboard);
    }
    return builder.build();
  }

  /**
   * Creates an immutable copy of a {@link ChallengePage} value.
   * Uses accessors to get values to initialize the new immutable instance.
   * If an instance is already immutable, it is returned as is.
   * @param instance The instance to copy
   * @return A copied immutable ChallengePage instance
   */
  public static ImmutableChallengePage copyOf(ChallengePage instance) {
    if (instance instanceof ImmutableChallengePage) {
      return (ImmutableChallengePage) instance;
    }
    return ImmutableChallengePage.builder()
        .from(instance)
        .build();
  }

  /**
   * Creates a builder for {@link ImmutableChallengePage ImmutableChallengePage}.
   * <pre>
   * ImmutableChallengePage.builder()
   *    .uuid(UUID) // required {@link ChallengePage#getUuid() uuid}
   *    .name(String) // required {@link ChallengePage#getName() name}
   *    .description(String) // required {@link ChallengePage#getDescription() description}
   *    .deadline(String) // required {@link ChallengePage#getDeadline() deadline}
   *    .status(com.bachelor.backend.domain.challenge.ChallengeStatus) // required {@link ChallengePage#getStatus() status}
   *    .type(com.bachelor.backend.domain.challenge.ChallengeType) // required {@link ChallengePage#getType() type}
   *    .canManageStatus(boolean) // required {@link ChallengePage#getCanManageStatus() canManageStatus}
   *    .canCreatePost(boolean) // required {@link ChallengePage#getCanCreatePost() canCreatePost}
   *    .canCreateRatedPost(boolean) // required {@link ChallengePage#getCanCreateRatedPost() canCreateRatedPost}
   *    .putScoreboard|putAllScoreboard(String =&gt; int) // {@link ChallengePage#getScoreboard() scoreboard} mappings
   *    .build();
   * </pre>
   * @return A new ImmutableChallengePage builder
   */
  public static ImmutableChallengePage.Builder builder() {
    return new ImmutableChallengePage.Builder();
  }

  /**
   * Builds instances of type {@link ImmutableChallengePage ImmutableChallengePage}.
   * Initialize attributes and then invoke the {@link #build()} method to create an
   * immutable instance.
   * <p><em>{@code Builder} is not thread-safe and generally should not be stored in a field or collection,
   * but instead used immediately to create instances.</em>
   */
  @Generated(from = "ChallengePage", generator = "Immutables")
  public static final class Builder {
    private static final long INIT_BIT_UUID = 0x1L;
    private static final long INIT_BIT_NAME = 0x2L;
    private static final long INIT_BIT_DESCRIPTION = 0x4L;
    private static final long INIT_BIT_DEADLINE = 0x8L;
    private static final long INIT_BIT_STATUS = 0x10L;
    private static final long INIT_BIT_TYPE = 0x20L;
    private static final long INIT_BIT_CAN_MANAGE_STATUS = 0x40L;
    private static final long INIT_BIT_CAN_CREATE_POST = 0x80L;
    private static final long INIT_BIT_CAN_CREATE_RATED_POST = 0x100L;
    private static final long OPT_BIT_SCOREBOARD = 0x1L;
    private long initBits = 0x1ffL;
    private long optBits;

    private UUID uuid;
    private String name;
    private String description;
    private String deadline;
    private ChallengeStatus status;
    private ChallengeType type;
    private boolean canManageStatus;
    private boolean canCreatePost;
    private boolean canCreateRatedPost;
    private Map<String, Integer> scoreboard = new LinkedHashMap<String, Integer>();

    private Builder() {
    }

    /**
     * Fill a builder with attribute values from the provided {@code ChallengePage} instance.
     * Regular attribute values will be replaced with those from the given instance.
     * Absent optional values will not replace present values.
     * Collection elements and entries will be added, not replaced.
     * @param instance The instance from which to copy values
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder from(ChallengePage instance) {
      Objects.requireNonNull(instance, "instance");
      uuid(instance.getUuid());
      name(instance.getName());
      description(instance.getDescription());
      deadline(instance.getDeadline());
      status(instance.getStatus());
      type(instance.getType());
      canManageStatus(instance.getCanManageStatus());
      canCreatePost(instance.getCanCreatePost());
      canCreateRatedPost(instance.getCanCreateRatedPost());
      putAllScoreboard(instance.getScoreboard());
      return this;
    }

    /**
     * Initializes the value for the {@link ChallengePage#getUuid() uuid} attribute.
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
     * Initializes the value for the {@link ChallengePage#getName() name} attribute.
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
     * Initializes the value for the {@link ChallengePage#getDescription() description} attribute.
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
     * Initializes the value for the {@link ChallengePage#getDeadline() deadline} attribute.
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
     * Initializes the value for the {@link ChallengePage#getStatus() status} attribute.
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
     * Initializes the value for the {@link ChallengePage#getType() type} attribute.
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
     * Initializes the value for the {@link ChallengePage#getCanManageStatus() canManageStatus} attribute.
     * @param canManageStatus The value for canManageStatus 
     * @return {@code this} builder for use in a chained invocation
     */
    @JsonProperty("canManageStatus")
    public final Builder canManageStatus(boolean canManageStatus) {
      this.canManageStatus = canManageStatus;
      initBits &= ~INIT_BIT_CAN_MANAGE_STATUS;
      return this;
    }

    /**
     * Initializes the value for the {@link ChallengePage#getCanCreatePost() canCreatePost} attribute.
     * @param canCreatePost The value for canCreatePost 
     * @return {@code this} builder for use in a chained invocation
     */
    @JsonProperty("canCreatePost")
    public final Builder canCreatePost(boolean canCreatePost) {
      this.canCreatePost = canCreatePost;
      initBits &= ~INIT_BIT_CAN_CREATE_POST;
      return this;
    }

    /**
     * Initializes the value for the {@link ChallengePage#getCanCreateRatedPost() canCreateRatedPost} attribute.
     * @param canCreateRatedPost The value for canCreateRatedPost 
     * @return {@code this} builder for use in a chained invocation
     */
    @JsonProperty("canCreateRatedPost")
    public final Builder canCreateRatedPost(boolean canCreateRatedPost) {
      this.canCreateRatedPost = canCreateRatedPost;
      initBits &= ~INIT_BIT_CAN_CREATE_RATED_POST;
      return this;
    }

    /**
     * Put one entry to the {@link ChallengePage#getScoreboard() scoreboard} map.
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
     * Put one entry to the {@link ChallengePage#getScoreboard() scoreboard} map. Nulls are not permitted
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
     * Sets or replaces all mappings from the specified map as entries for the {@link ChallengePage#getScoreboard() scoreboard} map. Nulls are not permitted
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
     * Put all mappings from the specified map as entries to {@link ChallengePage#getScoreboard() scoreboard} map. Nulls are not permitted
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
     * Builds a new {@link ImmutableChallengePage ImmutableChallengePage}.
     * @return An immutable instance of ChallengePage
     * @throws java.lang.IllegalStateException if any required attributes are missing
     */
    public ImmutableChallengePage build() {
      if (initBits != 0) {
        throw new IllegalStateException(formatRequiredAttributesMessage());
      }
      return new ImmutableChallengePage(this);
    }

    private boolean scoreboardIsSet() {
      return (optBits & OPT_BIT_SCOREBOARD) != 0;
    }

    private String formatRequiredAttributesMessage() {
      List<String> attributes = new ArrayList<>();
      if ((initBits & INIT_BIT_UUID) != 0) attributes.add("uuid");
      if ((initBits & INIT_BIT_NAME) != 0) attributes.add("name");
      if ((initBits & INIT_BIT_DESCRIPTION) != 0) attributes.add("description");
      if ((initBits & INIT_BIT_DEADLINE) != 0) attributes.add("deadline");
      if ((initBits & INIT_BIT_STATUS) != 0) attributes.add("status");
      if ((initBits & INIT_BIT_TYPE) != 0) attributes.add("type");
      if ((initBits & INIT_BIT_CAN_MANAGE_STATUS) != 0) attributes.add("canManageStatus");
      if ((initBits & INIT_BIT_CAN_CREATE_POST) != 0) attributes.add("canCreatePost");
      if ((initBits & INIT_BIT_CAN_CREATE_RATED_POST) != 0) attributes.add("canCreateRatedPost");
      return "Cannot build ChallengePage, some of required attributes are not set " + attributes;
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
