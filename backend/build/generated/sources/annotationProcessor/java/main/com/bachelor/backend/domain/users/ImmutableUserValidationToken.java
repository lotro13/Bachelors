package com.bachelor.backend.domain.users;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.UUID;
import org.immutables.value.Generated;

/**
 * Immutable implementation of {@link UserValidationToken}.
 * <p>
 * Use the builder to create immutable instances:
 * {@code ImmutableUserValidationToken.builder()}.
 */
@Generated(from = "UserValidationToken", generator = "Immutables")
@SuppressWarnings({"all"})
@javax.annotation.processing.Generated("org.immutables.processor.ProxyProcessor")
public final class ImmutableUserValidationToken extends UserValidationToken {
  private final UUID uuid;
  private final String token;
  private final Instant inspirationDate;
  private final String email;

  private ImmutableUserValidationToken(
      UUID uuid,
      String token,
      Instant inspirationDate,
      String email) {
    this.uuid = uuid;
    this.token = token;
    this.inspirationDate = inspirationDate;
    this.email = email;
  }

  /**
   * @return The value of the {@code uuid} attribute
   */
  @Override
  public UUID getUuid() {
    return uuid;
  }

  /**
   * @return The value of the {@code token} attribute
   */
  @Override
  public String getToken() {
    return token;
  }

  /**
   * @return The value of the {@code inspirationDate} attribute
   */
  @Override
  public Instant getInspirationDate() {
    return inspirationDate;
  }

  /**
   * @return The value of the {@code email} attribute
   */
  @Override
  public String getEmail() {
    return email;
  }

  /**
   * Copy the current immutable object by setting a value for the {@link UserValidationToken#getUuid() uuid} attribute.
   * A shallow reference equality check is used to prevent copying of the same value by returning {@code this}.
   * @param value A new value for uuid
   * @return A modified copy of the {@code this} object
   */
  public final ImmutableUserValidationToken withUuid(UUID value) {
    if (this.uuid == value) return this;
    UUID newValue = Objects.requireNonNull(value, "uuid");
    return new ImmutableUserValidationToken(newValue, this.token, this.inspirationDate, this.email);
  }

  /**
   * Copy the current immutable object by setting a value for the {@link UserValidationToken#getToken() token} attribute.
   * An equals check used to prevent copying of the same value by returning {@code this}.
   * @param value A new value for token
   * @return A modified copy of the {@code this} object
   */
  public final ImmutableUserValidationToken withToken(String value) {
    String newValue = Objects.requireNonNull(value, "token");
    if (this.token.equals(newValue)) return this;
    return new ImmutableUserValidationToken(this.uuid, newValue, this.inspirationDate, this.email);
  }

  /**
   * Copy the current immutable object by setting a value for the {@link UserValidationToken#getInspirationDate() inspirationDate} attribute.
   * A shallow reference equality check is used to prevent copying of the same value by returning {@code this}.
   * @param value A new value for inspirationDate
   * @return A modified copy of the {@code this} object
   */
  public final ImmutableUserValidationToken withInspirationDate(Instant value) {
    if (this.inspirationDate == value) return this;
    Instant newValue = Objects.requireNonNull(value, "inspirationDate");
    return new ImmutableUserValidationToken(this.uuid, this.token, newValue, this.email);
  }

  /**
   * Copy the current immutable object by setting a value for the {@link UserValidationToken#getEmail() email} attribute.
   * An equals check used to prevent copying of the same value by returning {@code this}.
   * @param value A new value for email
   * @return A modified copy of the {@code this} object
   */
  public final ImmutableUserValidationToken withEmail(String value) {
    String newValue = Objects.requireNonNull(value, "email");
    if (this.email.equals(newValue)) return this;
    return new ImmutableUserValidationToken(this.uuid, this.token, this.inspirationDate, newValue);
  }

  /**
   * This instance is equal to all instances of {@code ImmutableUserValidationToken} that have equal attribute values.
   * @return {@code true} if {@code this} is equal to {@code another} instance
   */
  @Override
  public boolean equals(Object another) {
    if (this == another) return true;
    return another instanceof ImmutableUserValidationToken
        && equalTo(0, (ImmutableUserValidationToken) another);
  }

  private boolean equalTo(int synthetic, ImmutableUserValidationToken another) {
    return uuid.equals(another.uuid)
        && token.equals(another.token)
        && inspirationDate.equals(another.inspirationDate)
        && email.equals(another.email);
  }

  /**
   * Computes a hash code from attributes: {@code uuid}, {@code token}, {@code inspirationDate}, {@code email}.
   * @return hashCode value
   */
  @Override
  public int hashCode() {
    int h = 5381;
    h += (h << 5) + uuid.hashCode();
    h += (h << 5) + token.hashCode();
    h += (h << 5) + inspirationDate.hashCode();
    h += (h << 5) + email.hashCode();
    return h;
  }

  /**
   * Prints the immutable value {@code UserValidationToken} with attribute values.
   * @return A string representation of the value
   */
  @Override
  public String toString() {
    return "UserValidationToken{"
        + "uuid=" + uuid
        + ", token=" + token
        + ", inspirationDate=" + inspirationDate
        + ", email=" + email
        + "}";
  }

  /**
   * Creates an immutable copy of a {@link UserValidationToken} value.
   * Uses accessors to get values to initialize the new immutable instance.
   * If an instance is already immutable, it is returned as is.
   * @param instance The instance to copy
   * @return A copied immutable UserValidationToken instance
   */
  public static ImmutableUserValidationToken copyOf(UserValidationToken instance) {
    if (instance instanceof ImmutableUserValidationToken) {
      return (ImmutableUserValidationToken) instance;
    }
    return ImmutableUserValidationToken.builder()
        .from(instance)
        .build();
  }

  /**
   * Creates a builder for {@link ImmutableUserValidationToken ImmutableUserValidationToken}.
   * <pre>
   * ImmutableUserValidationToken.builder()
   *    .uuid(UUID) // required {@link UserValidationToken#getUuid() uuid}
   *    .token(String) // required {@link UserValidationToken#getToken() token}
   *    .inspirationDate(java.time.Instant) // required {@link UserValidationToken#getInspirationDate() inspirationDate}
   *    .email(String) // required {@link UserValidationToken#getEmail() email}
   *    .build();
   * </pre>
   * @return A new ImmutableUserValidationToken builder
   */
  public static ImmutableUserValidationToken.Builder builder() {
    return new ImmutableUserValidationToken.Builder();
  }

  /**
   * Builds instances of type {@link ImmutableUserValidationToken ImmutableUserValidationToken}.
   * Initialize attributes and then invoke the {@link #build()} method to create an
   * immutable instance.
   * <p><em>{@code Builder} is not thread-safe and generally should not be stored in a field or collection,
   * but instead used immediately to create instances.</em>
   */
  @Generated(from = "UserValidationToken", generator = "Immutables")
  public static final class Builder {
    private static final long INIT_BIT_UUID = 0x1L;
    private static final long INIT_BIT_TOKEN = 0x2L;
    private static final long INIT_BIT_INSPIRATION_DATE = 0x4L;
    private static final long INIT_BIT_EMAIL = 0x8L;
    private long initBits = 0xfL;

    private UUID uuid;
    private String token;
    private Instant inspirationDate;
    private String email;

    private Builder() {
    }

    /**
     * Fill a builder with attribute values from the provided {@code UserValidationToken} instance.
     * Regular attribute values will be replaced with those from the given instance.
     * Absent optional values will not replace present values.
     * @param instance The instance from which to copy values
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder from(UserValidationToken instance) {
      Objects.requireNonNull(instance, "instance");
      uuid(instance.getUuid());
      token(instance.getToken());
      inspirationDate(instance.getInspirationDate());
      email(instance.getEmail());
      return this;
    }

    /**
     * Initializes the value for the {@link UserValidationToken#getUuid() uuid} attribute.
     * @param uuid The value for uuid 
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder uuid(UUID uuid) {
      this.uuid = Objects.requireNonNull(uuid, "uuid");
      initBits &= ~INIT_BIT_UUID;
      return this;
    }

    /**
     * Initializes the value for the {@link UserValidationToken#getToken() token} attribute.
     * @param token The value for token 
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder token(String token) {
      this.token = Objects.requireNonNull(token, "token");
      initBits &= ~INIT_BIT_TOKEN;
      return this;
    }

    /**
     * Initializes the value for the {@link UserValidationToken#getInspirationDate() inspirationDate} attribute.
     * @param inspirationDate The value for inspirationDate 
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder inspirationDate(Instant inspirationDate) {
      this.inspirationDate = Objects.requireNonNull(inspirationDate, "inspirationDate");
      initBits &= ~INIT_BIT_INSPIRATION_DATE;
      return this;
    }

    /**
     * Initializes the value for the {@link UserValidationToken#getEmail() email} attribute.
     * @param email The value for email 
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder email(String email) {
      this.email = Objects.requireNonNull(email, "email");
      initBits &= ~INIT_BIT_EMAIL;
      return this;
    }

    /**
     * Builds a new {@link ImmutableUserValidationToken ImmutableUserValidationToken}.
     * @return An immutable instance of UserValidationToken
     * @throws java.lang.IllegalStateException if any required attributes are missing
     */
    public ImmutableUserValidationToken build() {
      if (initBits != 0) {
        throw new IllegalStateException(formatRequiredAttributesMessage());
      }
      return new ImmutableUserValidationToken(uuid, token, inspirationDate, email);
    }

    private String formatRequiredAttributesMessage() {
      List<String> attributes = new ArrayList<>();
      if ((initBits & INIT_BIT_UUID) != 0) attributes.add("uuid");
      if ((initBits & INIT_BIT_TOKEN) != 0) attributes.add("token");
      if ((initBits & INIT_BIT_INSPIRATION_DATE) != 0) attributes.add("inspirationDate");
      if ((initBits & INIT_BIT_EMAIL) != 0) attributes.add("email");
      return "Cannot build UserValidationToken, some of required attributes are not set " + attributes;
    }
  }
}
