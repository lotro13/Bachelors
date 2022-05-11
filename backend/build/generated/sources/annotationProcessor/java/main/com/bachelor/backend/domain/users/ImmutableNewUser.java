package com.bachelor.backend.domain.users;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import org.immutables.value.Generated;

/**
 * Immutable implementation of {@link NewUser}.
 * <p>
 * Use the builder to create immutable instances:
 * {@code ImmutableNewUser.builder()}.
 */
@Generated(from = "NewUser", generator = "Immutables")
@SuppressWarnings({"all"})
@javax.annotation.processing.Generated("org.immutables.processor.ProxyProcessor")
public final class ImmutableNewUser extends NewUser {
  private final String email;
  private final String username;

  private ImmutableNewUser(String email, String username) {
    this.email = email;
    this.username = username;
  }

  /**
   * @return The value of the {@code email} attribute
   */
  @JsonProperty("email")
  @Override
  public String getEmail() {
    return email;
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
   * Copy the current immutable object by setting a value for the {@link NewUser#getEmail() email} attribute.
   * An equals check used to prevent copying of the same value by returning {@code this}.
   * @param value A new value for email
   * @return A modified copy of the {@code this} object
   */
  public final ImmutableNewUser withEmail(String value) {
    String newValue = Objects.requireNonNull(value, "email");
    if (this.email.equals(newValue)) return this;
    return new ImmutableNewUser(newValue, this.username);
  }

  /**
   * Copy the current immutable object by setting a value for the {@link NewUser#getUsername() username} attribute.
   * An equals check used to prevent copying of the same value by returning {@code this}.
   * @param value A new value for username
   * @return A modified copy of the {@code this} object
   */
  public final ImmutableNewUser withUsername(String value) {
    String newValue = Objects.requireNonNull(value, "username");
    if (this.username.equals(newValue)) return this;
    return new ImmutableNewUser(this.email, newValue);
  }

  /**
   * This instance is equal to all instances of {@code ImmutableNewUser} that have equal attribute values.
   * @return {@code true} if {@code this} is equal to {@code another} instance
   */
  @Override
  public boolean equals(Object another) {
    if (this == another) return true;
    return another instanceof ImmutableNewUser
        && equalTo(0, (ImmutableNewUser) another);
  }

  private boolean equalTo(int synthetic, ImmutableNewUser another) {
    return email.equals(another.email)
        && username.equals(another.username);
  }

  /**
   * Computes a hash code from attributes: {@code email}, {@code username}.
   * @return hashCode value
   */
  @Override
  public int hashCode() {
    int h = 5381;
    h += (h << 5) + email.hashCode();
    h += (h << 5) + username.hashCode();
    return h;
  }

  /**
   * Prints the immutable value {@code NewUser} with attribute values.
   * @return A string representation of the value
   */
  @Override
  public String toString() {
    return "NewUser{"
        + "email=" + email
        + ", username=" + username
        + "}";
  }

  /**
   * Utility type used to correctly read immutable object from JSON representation.
   * @deprecated Do not use this type directly, it exists only for the <em>Jackson</em>-binding infrastructure
   */
  @Generated(from = "NewUser", generator = "Immutables")
  @Deprecated
  @JsonDeserialize
  @JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.NONE)
  static final class Json extends NewUser {
    String email;
    String username;
    @JsonProperty("email")
    public void setEmail(String email) {
      this.email = email;
    }
    @JsonProperty("username")
    public void setUsername(String username) {
      this.username = username;
    }
    @Override
    public String getEmail() { throw new UnsupportedOperationException(); }
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
  static ImmutableNewUser fromJson(Json json) {
    ImmutableNewUser.Builder builder = ImmutableNewUser.builder();
    if (json.email != null) {
      builder.email(json.email);
    }
    if (json.username != null) {
      builder.username(json.username);
    }
    return builder.build();
  }

  /**
   * Creates an immutable copy of a {@link NewUser} value.
   * Uses accessors to get values to initialize the new immutable instance.
   * If an instance is already immutable, it is returned as is.
   * @param instance The instance to copy
   * @return A copied immutable NewUser instance
   */
  public static ImmutableNewUser copyOf(NewUser instance) {
    if (instance instanceof ImmutableNewUser) {
      return (ImmutableNewUser) instance;
    }
    return ImmutableNewUser.builder()
        .from(instance)
        .build();
  }

  /**
   * Creates a builder for {@link ImmutableNewUser ImmutableNewUser}.
   * <pre>
   * ImmutableNewUser.builder()
   *    .email(String) // required {@link NewUser#getEmail() email}
   *    .username(String) // required {@link NewUser#getUsername() username}
   *    .build();
   * </pre>
   * @return A new ImmutableNewUser builder
   */
  public static ImmutableNewUser.Builder builder() {
    return new ImmutableNewUser.Builder();
  }

  /**
   * Builds instances of type {@link ImmutableNewUser ImmutableNewUser}.
   * Initialize attributes and then invoke the {@link #build()} method to create an
   * immutable instance.
   * <p><em>{@code Builder} is not thread-safe and generally should not be stored in a field or collection,
   * but instead used immediately to create instances.</em>
   */
  @Generated(from = "NewUser", generator = "Immutables")
  public static final class Builder {
    private static final long INIT_BIT_EMAIL = 0x1L;
    private static final long INIT_BIT_USERNAME = 0x2L;
    private long initBits = 0x3L;

    private String email;
    private String username;

    private Builder() {
    }

    /**
     * Fill a builder with attribute values from the provided {@code NewUser} instance.
     * Regular attribute values will be replaced with those from the given instance.
     * Absent optional values will not replace present values.
     * @param instance The instance from which to copy values
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder from(NewUser instance) {
      Objects.requireNonNull(instance, "instance");
      email(instance.getEmail());
      username(instance.getUsername());
      return this;
    }

    /**
     * Initializes the value for the {@link NewUser#getEmail() email} attribute.
     * @param email The value for email 
     * @return {@code this} builder for use in a chained invocation
     */
    @JsonProperty("email")
    public final Builder email(String email) {
      this.email = Objects.requireNonNull(email, "email");
      initBits &= ~INIT_BIT_EMAIL;
      return this;
    }

    /**
     * Initializes the value for the {@link NewUser#getUsername() username} attribute.
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
     * Builds a new {@link ImmutableNewUser ImmutableNewUser}.
     * @return An immutable instance of NewUser
     * @throws java.lang.IllegalStateException if any required attributes are missing
     */
    public ImmutableNewUser build() {
      if (initBits != 0) {
        throw new IllegalStateException(formatRequiredAttributesMessage());
      }
      return new ImmutableNewUser(email, username);
    }

    private String formatRequiredAttributesMessage() {
      List<String> attributes = new ArrayList<>();
      if ((initBits & INIT_BIT_EMAIL) != 0) attributes.add("email");
      if ((initBits & INIT_BIT_USERNAME) != 0) attributes.add("username");
      return "Cannot build NewUser, some of required attributes are not set " + attributes;
    }
  }
}
