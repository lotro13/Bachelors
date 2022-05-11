package com.bachelor.backend.domain.users;

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
 * Immutable implementation of {@link UserPage}.
 * <p>
 * Use the builder to create immutable instances:
 * {@code ImmutableUserPage.builder()}.
 */
@Generated(from = "UserPage", generator = "Immutables")
@SuppressWarnings({"all"})
@javax.annotation.processing.Generated("org.immutables.processor.ProxyProcessor")
public final class ImmutableUserPage extends UserPage {
  private final UUID uuid;
  private final String username;

  private ImmutableUserPage(UUID uuid, String username) {
    this.uuid = uuid;
    this.username = username;
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
   * @return The value of the {@code username} attribute
   */
  @JsonProperty("username")
  @Override
  public String getUsername() {
    return username;
  }

  /**
   * Copy the current immutable object by setting a value for the {@link UserPage#getUuid() uuid} attribute.
   * A shallow reference equality check is used to prevent copying of the same value by returning {@code this}.
   * @param value A new value for uuid
   * @return A modified copy of the {@code this} object
   */
  public final ImmutableUserPage withUuid(UUID value) {
    if (this.uuid == value) return this;
    UUID newValue = Objects.requireNonNull(value, "uuid");
    return new ImmutableUserPage(newValue, this.username);
  }

  /**
   * Copy the current immutable object by setting a value for the {@link UserPage#getUsername() username} attribute.
   * An equals check used to prevent copying of the same value by returning {@code this}.
   * @param value A new value for username
   * @return A modified copy of the {@code this} object
   */
  public final ImmutableUserPage withUsername(String value) {
    String newValue = Objects.requireNonNull(value, "username");
    if (this.username.equals(newValue)) return this;
    return new ImmutableUserPage(this.uuid, newValue);
  }

  /**
   * This instance is equal to all instances of {@code ImmutableUserPage} that have equal attribute values.
   * @return {@code true} if {@code this} is equal to {@code another} instance
   */
  @Override
  public boolean equals(Object another) {
    if (this == another) return true;
    return another instanceof ImmutableUserPage
        && equalTo(0, (ImmutableUserPage) another);
  }

  private boolean equalTo(int synthetic, ImmutableUserPage another) {
    return uuid.equals(another.uuid)
        && username.equals(another.username);
  }

  /**
   * Computes a hash code from attributes: {@code uuid}, {@code username}.
   * @return hashCode value
   */
  @Override
  public int hashCode() {
    int h = 5381;
    h += (h << 5) + uuid.hashCode();
    h += (h << 5) + username.hashCode();
    return h;
  }

  /**
   * Prints the immutable value {@code UserPage} with attribute values.
   * @return A string representation of the value
   */
  @Override
  public String toString() {
    return "UserPage{"
        + "uuid=" + uuid
        + ", username=" + username
        + "}";
  }

  /**
   * Utility type used to correctly read immutable object from JSON representation.
   * @deprecated Do not use this type directly, it exists only for the <em>Jackson</em>-binding infrastructure
   */
  @Generated(from = "UserPage", generator = "Immutables")
  @Deprecated
  @JsonDeserialize
  @JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.NONE)
  static final class Json extends UserPage {
    UUID uuid;
    String username;
    @JsonProperty("uuid")
    public void setUuid(UUID uuid) {
      this.uuid = uuid;
    }
    @JsonProperty("username")
    public void setUsername(String username) {
      this.username = username;
    }
    @Override
    public UUID getUuid() { throw new UnsupportedOperationException(); }
    @Override
    public String getUsername() { throw new UnsupportedOperationException(); }
  }

  /**
   * @param json A JSON-bindable data structure
   * @return An immutable value type
   * @deprecated Do not use this method directly, it exists only for the <em>Jackson</em>-binding infrastructure
   */
  @Deprecated
  @JsonCreator(mode = JsonCreator.Mode.DELEGATING)
  static ImmutableUserPage fromJson(Json json) {
    ImmutableUserPage.Builder builder = ImmutableUserPage.builder();
    if (json.uuid != null) {
      builder.uuid(json.uuid);
    }
    if (json.username != null) {
      builder.username(json.username);
    }
    return builder.build();
  }

  /**
   * Creates an immutable copy of a {@link UserPage} value.
   * Uses accessors to get values to initialize the new immutable instance.
   * If an instance is already immutable, it is returned as is.
   * @param instance The instance to copy
   * @return A copied immutable UserPage instance
   */
  public static ImmutableUserPage copyOf(UserPage instance) {
    if (instance instanceof ImmutableUserPage) {
      return (ImmutableUserPage) instance;
    }
    return ImmutableUserPage.builder()
        .from(instance)
        .build();
  }

  /**
   * Creates a builder for {@link ImmutableUserPage ImmutableUserPage}.
   * <pre>
   * ImmutableUserPage.builder()
   *    .uuid(UUID) // required {@link UserPage#getUuid() uuid}
   *    .username(String) // required {@link UserPage#getUsername() username}
   *    .build();
   * </pre>
   * @return A new ImmutableUserPage builder
   */
  public static ImmutableUserPage.Builder builder() {
    return new ImmutableUserPage.Builder();
  }

  /**
   * Builds instances of type {@link ImmutableUserPage ImmutableUserPage}.
   * Initialize attributes and then invoke the {@link #build()} method to create an
   * immutable instance.
   * <p><em>{@code Builder} is not thread-safe and generally should not be stored in a field or collection,
   * but instead used immediately to create instances.</em>
   */
  @Generated(from = "UserPage", generator = "Immutables")
  public static final class Builder {
    private static final long INIT_BIT_UUID = 0x1L;
    private static final long INIT_BIT_USERNAME = 0x2L;
    private long initBits = 0x3L;

    private UUID uuid;
    private String username;

    private Builder() {
    }

    /**
     * Fill a builder with attribute values from the provided {@code UserPage} instance.
     * Regular attribute values will be replaced with those from the given instance.
     * Absent optional values will not replace present values.
     * @param instance The instance from which to copy values
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder from(UserPage instance) {
      Objects.requireNonNull(instance, "instance");
      uuid(instance.getUuid());
      username(instance.getUsername());
      return this;
    }

    /**
     * Initializes the value for the {@link UserPage#getUuid() uuid} attribute.
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
     * Initializes the value for the {@link UserPage#getUsername() username} attribute.
     * @param username The value for username 
     * @return {@code this} builder for use in a chained invocation
     */
    @JsonProperty("username")
    public final Builder username(String username) {
      this.username = Objects.requireNonNull(username, "username");
      initBits &= ~INIT_BIT_USERNAME;
      return this;
    }

    /**
     * Builds a new {@link ImmutableUserPage ImmutableUserPage}.
     * @return An immutable instance of UserPage
     * @throws java.lang.IllegalStateException if any required attributes are missing
     */
    public ImmutableUserPage build() {
      if (initBits != 0) {
        throw new IllegalStateException(formatRequiredAttributesMessage());
      }
      return new ImmutableUserPage(uuid, username);
    }

    private String formatRequiredAttributesMessage() {
      List<String> attributes = new ArrayList<>();
      if ((initBits & INIT_BIT_UUID) != 0) attributes.add("uuid");
      if ((initBits & INIT_BIT_USERNAME) != 0) attributes.add("username");
      return "Cannot build UserPage, some of required attributes are not set " + attributes;
    }
  }
}
