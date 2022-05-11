package com.bachelor.backend.security;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.UUID;
import org.immutables.value.Generated;

/**
 * Immutable implementation of {@link SessionToken}.
 * <p>
 * Use the builder to create immutable instances:
 * {@code ImmutableSessionToken.builder()}.
 */
@Generated(from = "SessionToken", generator = "Immutables")
@SuppressWarnings({"all"})
@javax.annotation.processing.Generated("org.immutables.processor.ProxyProcessor")
public final class ImmutableSessionToken extends SessionToken {
  private final UUID userUuid;
  private final String token;

  private ImmutableSessionToken(UUID userUuid, String token) {
    this.userUuid = userUuid;
    this.token = token;
  }

  /**
   * @return The value of the {@code userUuid} attribute
   */
  @Override
  public UUID getUserUuid() {
    return userUuid;
  }

  /**
   * @return The value of the {@code token} attribute
   */
  @Override
  public String getToken() {
    return token;
  }

  /**
   * Copy the current immutable object by setting a value for the {@link SessionToken#getUserUuid() userUuid} attribute.
   * A shallow reference equality check is used to prevent copying of the same value by returning {@code this}.
   * @param value A new value for userUuid
   * @return A modified copy of the {@code this} object
   */
  public final ImmutableSessionToken withUserUuid(UUID value) {
    if (this.userUuid == value) return this;
    UUID newValue = Objects.requireNonNull(value, "userUuid");
    return new ImmutableSessionToken(newValue, this.token);
  }

  /**
   * Copy the current immutable object by setting a value for the {@link SessionToken#getToken() token} attribute.
   * An equals check used to prevent copying of the same value by returning {@code this}.
   * @param value A new value for token
   * @return A modified copy of the {@code this} object
   */
  public final ImmutableSessionToken withToken(String value) {
    String newValue = Objects.requireNonNull(value, "token");
    if (this.token.equals(newValue)) return this;
    return new ImmutableSessionToken(this.userUuid, newValue);
  }

  /**
   * This instance is equal to all instances of {@code ImmutableSessionToken} that have equal attribute values.
   * @return {@code true} if {@code this} is equal to {@code another} instance
   */
  @Override
  public boolean equals(Object another) {
    if (this == another) return true;
    return another instanceof ImmutableSessionToken
        && equalTo(0, (ImmutableSessionToken) another);
  }

  private boolean equalTo(int synthetic, ImmutableSessionToken another) {
    return userUuid.equals(another.userUuid)
        && token.equals(another.token);
  }

  /**
   * Computes a hash code from attributes: {@code userUuid}, {@code token}.
   * @return hashCode value
   */
  @Override
  public int hashCode() {
    int h = 5381;
    h += (h << 5) + userUuid.hashCode();
    h += (h << 5) + token.hashCode();
    return h;
  }

  /**
   * Prints the immutable value {@code SessionToken} with attribute values.
   * @return A string representation of the value
   */
  @Override
  public String toString() {
    return "SessionToken{"
        + "userUuid=" + userUuid
        + ", token=" + token
        + "}";
  }

  /**
   * Creates an immutable copy of a {@link SessionToken} value.
   * Uses accessors to get values to initialize the new immutable instance.
   * If an instance is already immutable, it is returned as is.
   * @param instance The instance to copy
   * @return A copied immutable SessionToken instance
   */
  public static ImmutableSessionToken copyOf(SessionToken instance) {
    if (instance instanceof ImmutableSessionToken) {
      return (ImmutableSessionToken) instance;
    }
    return ImmutableSessionToken.builder()
        .from(instance)
        .build();
  }

  /**
   * Creates a builder for {@link ImmutableSessionToken ImmutableSessionToken}.
   * <pre>
   * ImmutableSessionToken.builder()
   *    .userUuid(UUID) // required {@link SessionToken#getUserUuid() userUuid}
   *    .token(String) // required {@link SessionToken#getToken() token}
   *    .build();
   * </pre>
   * @return A new ImmutableSessionToken builder
   */
  public static ImmutableSessionToken.Builder builder() {
    return new ImmutableSessionToken.Builder();
  }

  /**
   * Builds instances of type {@link ImmutableSessionToken ImmutableSessionToken}.
   * Initialize attributes and then invoke the {@link #build()} method to create an
   * immutable instance.
   * <p><em>{@code Builder} is not thread-safe and generally should not be stored in a field or collection,
   * but instead used immediately to create instances.</em>
   */
  @Generated(from = "SessionToken", generator = "Immutables")
  public static final class Builder {
    private static final long INIT_BIT_USER_UUID = 0x1L;
    private static final long INIT_BIT_TOKEN = 0x2L;
    private long initBits = 0x3L;

    private UUID userUuid;
    private String token;

    private Builder() {
    }

    /**
     * Fill a builder with attribute values from the provided {@code SessionToken} instance.
     * Regular attribute values will be replaced with those from the given instance.
     * Absent optional values will not replace present values.
     * @param instance The instance from which to copy values
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder from(SessionToken instance) {
      Objects.requireNonNull(instance, "instance");
      userUuid(instance.getUserUuid());
      token(instance.getToken());
      return this;
    }

    /**
     * Initializes the value for the {@link SessionToken#getUserUuid() userUuid} attribute.
     * @param userUuid The value for userUuid 
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder userUuid(UUID userUuid) {
      this.userUuid = Objects.requireNonNull(userUuid, "userUuid");
      initBits &= ~INIT_BIT_USER_UUID;
      return this;
    }

    /**
     * Initializes the value for the {@link SessionToken#getToken() token} attribute.
     * @param token The value for token 
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder token(String token) {
      this.token = Objects.requireNonNull(token, "token");
      initBits &= ~INIT_BIT_TOKEN;
      return this;
    }

    /**
     * Builds a new {@link ImmutableSessionToken ImmutableSessionToken}.
     * @return An immutable instance of SessionToken
     * @throws java.lang.IllegalStateException if any required attributes are missing
     */
    public ImmutableSessionToken build() {
      if (initBits != 0) {
        throw new IllegalStateException(formatRequiredAttributesMessage());
      }
      return new ImmutableSessionToken(userUuid, token);
    }

    private String formatRequiredAttributesMessage() {
      List<String> attributes = new ArrayList<>();
      if ((initBits & INIT_BIT_USER_UUID) != 0) attributes.add("userUuid");
      if ((initBits & INIT_BIT_TOKEN) != 0) attributes.add("token");
      return "Cannot build SessionToken, some of required attributes are not set " + attributes;
    }
  }
}
