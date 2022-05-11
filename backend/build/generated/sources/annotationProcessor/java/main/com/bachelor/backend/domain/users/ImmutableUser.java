package com.bachelor.backend.domain.users;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.UUID;
import org.immutables.value.Generated;

/**
 * Immutable implementation of {@link User}.
 * <p>
 * Use the builder to create immutable instances:
 * {@code ImmutableUser.builder()}.
 */
@Generated(from = "User", generator = "Immutables")
@SuppressWarnings({"all"})
@javax.annotation.processing.Generated("org.immutables.processor.ProxyProcessor")
public final class ImmutableUser
    extends User
    implements Serializable {
  private final UUID uuid;
  private final String email;
  private final String username;
  private final UserRegistrationStatus registrationStatus;

  private ImmutableUser(ImmutableUser.Builder builder) {
    this.uuid = builder.uuid;
    this.email = builder.email;
    this.registrationStatus = builder.registrationStatus;
    this.username = builder.username != null
        ? builder.username
        : Objects.requireNonNull(super.getUsername(), "username");
  }

  private ImmutableUser(
      UUID uuid,
      String email,
      String username,
      UserRegistrationStatus registrationStatus) {
    this.uuid = uuid;
    this.email = email;
    this.username = username;
    this.registrationStatus = registrationStatus;
  }

  /**
   * @return The value of the {@code uuid} attribute
   */
  @JsonProperty
  @Override
  public UUID getUuid() {
    return uuid;
  }

  /**
   * @return The value of the {@code email} attribute
   */
  @JsonProperty
  @Override
  public String getEmail() {
    return email;
  }

  /**
   * @return The value of the {@code username} attribute
   */
  @JsonProperty
  @Override
  public String getUsername() {
    return username;
  }

  /**
   * @return The value of the {@code registrationStatus} attribute
   */
  @JsonProperty
  @Override
  public UserRegistrationStatus getRegistrationStatus() {
    return registrationStatus;
  }

  /**
   * Copy the current immutable object by setting a value for the {@link User#getUuid() uuid} attribute.
   * A shallow reference equality check is used to prevent copying of the same value by returning {@code this}.
   * @param value A new value for uuid
   * @return A modified copy of the {@code this} object
   */
  public final ImmutableUser withUuid(UUID value) {
    if (this.uuid == value) return this;
    UUID newValue = Objects.requireNonNull(value, "uuid");
    return new ImmutableUser(newValue, this.email, this.username, this.registrationStatus);
  }

  /**
   * Copy the current immutable object by setting a value for the {@link User#getEmail() email} attribute.
   * An equals check used to prevent copying of the same value by returning {@code this}.
   * @param value A new value for email
   * @return A modified copy of the {@code this} object
   */
  public final ImmutableUser withEmail(String value) {
    String newValue = Objects.requireNonNull(value, "email");
    if (this.email.equals(newValue)) return this;
    return new ImmutableUser(this.uuid, newValue, this.username, this.registrationStatus);
  }

  /**
   * Copy the current immutable object by setting a value for the {@link User#getUsername() username} attribute.
   * An equals check used to prevent copying of the same value by returning {@code this}.
   * @param value A new value for username
   * @return A modified copy of the {@code this} object
   */
  public final ImmutableUser withUsername(String value) {
    String newValue = Objects.requireNonNull(value, "username");
    if (this.username.equals(newValue)) return this;
    return new ImmutableUser(this.uuid, this.email, newValue, this.registrationStatus);
  }

  /**
   * Copy the current immutable object by setting a value for the {@link User#getRegistrationStatus() registrationStatus} attribute.
   * A value equality check is used to prevent copying of the same value by returning {@code this}.
   * @param value A new value for registrationStatus
   * @return A modified copy of the {@code this} object
   */
  public final ImmutableUser withRegistrationStatus(UserRegistrationStatus value) {
    UserRegistrationStatus newValue = Objects.requireNonNull(value, "registrationStatus");
    if (this.registrationStatus == newValue) return this;
    return new ImmutableUser(this.uuid, this.email, this.username, newValue);
  }

  /**
   * This instance is equal to all instances of {@code ImmutableUser} that have equal attribute values.
   * @return {@code true} if {@code this} is equal to {@code another} instance
   */
  @Override
  public boolean equals(Object another) {
    if (this == another) return true;
    return another instanceof ImmutableUser
        && equalTo(0, (ImmutableUser) another);
  }

  private boolean equalTo(int synthetic, ImmutableUser another) {
    return uuid.equals(another.uuid)
        && email.equals(another.email)
        && username.equals(another.username)
        && registrationStatus.equals(another.registrationStatus);
  }

  /**
   * Computes a hash code from attributes: {@code uuid}, {@code email}, {@code username}, {@code registrationStatus}.
   * @return hashCode value
   */
  @Override
  public int hashCode() {
    int h = 5381;
    h += (h << 5) + uuid.hashCode();
    h += (h << 5) + email.hashCode();
    h += (h << 5) + username.hashCode();
    h += (h << 5) + registrationStatus.hashCode();
    return h;
  }

  /**
   * Prints the immutable value {@code User} with attribute values.
   * @return A string representation of the value
   */
  @Override
  public String toString() {
    return "User{"
        + "uuid=" + uuid
        + ", email=" + email
        + ", username=" + username
        + ", registrationStatus=" + registrationStatus
        + "}";
  }

  /**
   * Utility type used to correctly read immutable object from JSON representation.
   * @deprecated Do not use this type directly, it exists only for the <em>Jackson</em>-binding infrastructure
   */
  @Generated(from = "User", generator = "Immutables")
  @Deprecated
  @JsonDeserialize
  @JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.NONE)
  static final class Json extends User implements Serializable {
    UUID uuid;
    String email;
    String username;
    UserRegistrationStatus registrationStatus;
    @JsonProperty
    public void setUuid(UUID uuid) {
      this.uuid = uuid;
    }
    @JsonProperty
    public void setEmail(String email) {
      this.email = email;
    }
    @JsonProperty
    public void setUsername(String username) {
      this.username = username;
    }
    @JsonProperty
    public void setRegistrationStatus(UserRegistrationStatus registrationStatus) {
      this.registrationStatus = registrationStatus;
    }
    @Override
    public UUID getUuid() { throw new UnsupportedOperationException(); }
    @Override
    public String getEmail() { throw new UnsupportedOperationException(); }
    @Override
    public String getUsername() { throw new UnsupportedOperationException(); }
    @Override
    public UserRegistrationStatus getRegistrationStatus() { throw new UnsupportedOperationException(); }
  }

  /**
   * @param json A JSON-bindable data structure
   * @return An immutable value type
   * @deprecated Do not use this method directly, it exists only for the <em>Jackson</em>-binding infrastructure
   */
  @Deprecated
  @JsonCreator(mode = JsonCreator.Mode.DELEGATING)
  static ImmutableUser fromJson(Json json) {
    ImmutableUser.Builder builder = ImmutableUser.builder();
    if (json.uuid != null) {
      builder.uuid(json.uuid);
    }
    if (json.email != null) {
      builder.email(json.email);
    }
    if (json.username != null) {
      builder.username(json.username);
    }
    if (json.registrationStatus != null) {
      builder.registrationStatus(json.registrationStatus);
    }
    return builder.build();
  }

  /**
   * Creates an immutable copy of a {@link User} value.
   * Uses accessors to get values to initialize the new immutable instance.
   * If an instance is already immutable, it is returned as is.
   * @param instance The instance to copy
   * @return A copied immutable User instance
   */
  public static ImmutableUser copyOf(User instance) {
    if (instance instanceof ImmutableUser) {
      return (ImmutableUser) instance;
    }
    return ImmutableUser.builder()
        .from(instance)
        .build();
  }

  /**
   * The serialized form captures the structural content of the value object,
   * providing the ability to reconstruct values with the capability to migrate
   * data. Uses optional, nullable, and provides flexible handling of
   * collection attributes.
   */
  @Generated(from = "User", generator = "Immutables")
  private static class SerialForm implements Serializable {
    private static final long serialVersionUID = 0L;
    private final String[] names;
    private final Object[] values;
    SerialForm(ImmutableUser instance) {
      List<String> names = new ArrayList<>(4);
      List<Object> values = new ArrayList<>(4);
      names.add("uuid");
      values.add(instance.getUuid());
      names.add("email");
      values.add(instance.getEmail());
      names.add("username");
      values.add(instance.getUsername());
      names.add("registrationStatus");
      values.add(instance.getRegistrationStatus());
      this.names = names.toArray(new String[names.size()]);
      this.values = values.toArray();
    }

    Object readResolve() {
      ImmutableUser.Builder builder = ImmutableUser.builder();

      for (int i = 0; i < names.length; i++) {
        String name = names[i];
        if ("uuid".equals(name)) {
          builder.uuid((UUID) toSingle("uuid", values[i]));
          continue;
        }
        if ("email".equals(name)) {
          builder.email((String) toSingle("email", values[i]));
          continue;
        }
        if ("username".equals(name)) {
          builder.username((String) toSingle("username", values[i]));
          continue;
        }
        if ("registrationStatus".equals(name)) {
          builder.registrationStatus((UserRegistrationStatus) toSingle("registrationStatus", values[i]));
          continue;
        }
      }
      return builder.build();
    }

    private static Object toSingle(String attribute, Object value) {
      if (value instanceof Object[]) {
        Object[] elements = (Object[]) value;
        if (elements.length == 1) {
          return elements[0];
        }
        throw new IllegalStateException("Cannot extract scalar value for attribute '"
            + attribute + "' from array of length " + elements.length);
      }
      return value;
    }
  }

  private Object writeReplace() {
    return new SerialForm(this);
  }

  /**
   * Creates a builder for {@link ImmutableUser ImmutableUser}.
   * <pre>
   * ImmutableUser.builder()
   *    .uuid(UUID) // required {@link User#getUuid() uuid}
   *    .email(String) // required {@link User#getEmail() email}
   *    .username(String) // optional {@link User#getUsername() username}
   *    .registrationStatus(com.bachelor.backend.domain.users.UserRegistrationStatus) // required {@link User#getRegistrationStatus() registrationStatus}
   *    .build();
   * </pre>
   * @return A new ImmutableUser builder
   */
  public static ImmutableUser.Builder builder() {
    return new ImmutableUser.Builder();
  }

  /**
   * Builds instances of type {@link ImmutableUser ImmutableUser}.
   * Initialize attributes and then invoke the {@link #build()} method to create an
   * immutable instance.
   * <p><em>{@code Builder} is not thread-safe and generally should not be stored in a field or collection,
   * but instead used immediately to create instances.</em>
   */
  @Generated(from = "User", generator = "Immutables")
  public static final class Builder {
    private static final long INIT_BIT_UUID = 0x1L;
    private static final long INIT_BIT_EMAIL = 0x2L;
    private static final long INIT_BIT_REGISTRATION_STATUS = 0x4L;
    private long initBits = 0x7L;

    private UUID uuid;
    private String email;
    private String username;
    private UserRegistrationStatus registrationStatus;

    private Builder() {
    }

    /**
     * Fill a builder with attribute values from the provided {@code User} instance.
     * Regular attribute values will be replaced with those from the given instance.
     * Absent optional values will not replace present values.
     * @param instance The instance from which to copy values
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder from(User instance) {
      Objects.requireNonNull(instance, "instance");
      uuid(instance.getUuid());
      email(instance.getEmail());
      username(instance.getUsername());
      registrationStatus(instance.getRegistrationStatus());
      return this;
    }

    /**
     * Initializes the value for the {@link User#getUuid() uuid} attribute.
     * @param uuid The value for uuid 
     * @return {@code this} builder for use in a chained invocation
     */
    @JsonProperty
    public final Builder uuid(UUID uuid) {
      this.uuid = Objects.requireNonNull(uuid, "uuid");
      initBits &= ~INIT_BIT_UUID;
      return this;
    }

    /**
     * Initializes the value for the {@link User#getEmail() email} attribute.
     * @param email The value for email 
     * @return {@code this} builder for use in a chained invocation
     */
    @JsonProperty
    public final Builder email(String email) {
      this.email = Objects.requireNonNull(email, "email");
      initBits &= ~INIT_BIT_EMAIL;
      return this;
    }

    /**
     * Initializes the value for the {@link User#getUsername() username} attribute.
     * <p><em>If not set, this attribute will have a default value as returned by the initializer of {@link User#getUsername() username}.</em>
     * @param username The value for username 
     * @return {@code this} builder for use in a chained invocation
     */
    @JsonProperty
    public final Builder username(String username) {
      this.username = Objects.requireNonNull(username, "username");
      return this;
    }

    /**
     * Initializes the value for the {@link User#getRegistrationStatus() registrationStatus} attribute.
     * @param registrationStatus The value for registrationStatus 
     * @return {@code this} builder for use in a chained invocation
     */
    @JsonProperty
    public final Builder registrationStatus(UserRegistrationStatus registrationStatus) {
      this.registrationStatus = Objects.requireNonNull(registrationStatus, "registrationStatus");
      initBits &= ~INIT_BIT_REGISTRATION_STATUS;
      return this;
    }

    /**
     * Builds a new {@link ImmutableUser ImmutableUser}.
     * @return An immutable instance of User
     * @throws java.lang.IllegalStateException if any required attributes are missing
     */
    public ImmutableUser build() {
      if (initBits != 0) {
        throw new IllegalStateException(formatRequiredAttributesMessage());
      }
      return new ImmutableUser(this);
    }

    private String formatRequiredAttributesMessage() {
      List<String> attributes = new ArrayList<>();
      if ((initBits & INIT_BIT_UUID) != 0) attributes.add("uuid");
      if ((initBits & INIT_BIT_EMAIL) != 0) attributes.add("email");
      if ((initBits & INIT_BIT_REGISTRATION_STATUS) != 0) attributes.add("registrationStatus");
      return "Cannot build User, some of required attributes are not set " + attributes;
    }
  }
}
