package com.bachelor.backend.domain.feed;

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
 * Immutable implementation of {@link NewComment}.
 * <p>
 * Use the builder to create immutable instances:
 * {@code ImmutableNewComment.builder()}.
 */
@Generated(from = "NewComment", generator = "Immutables")
@SuppressWarnings({"all"})
@javax.annotation.processing.Generated("org.immutables.processor.ProxyProcessor")
public final class ImmutableNewComment extends NewComment {
  private final UUID authorUuid;
  private final UUID targetUuid;
  private final String body;

  private ImmutableNewComment(UUID authorUuid, UUID targetUuid, String body) {
    this.authorUuid = authorUuid;
    this.targetUuid = targetUuid;
    this.body = body;
  }

  /**
   * @return The value of the {@code authorUuid} attribute
   */
  @JsonProperty("authorUuid")
  @Override
  public UUID getAuthorUuid() {
    return authorUuid;
  }

  /**
   * @return The value of the {@code targetUuid} attribute
   */
  @JsonProperty("targetUuid")
  @Override
  public UUID getTargetUuid() {
    return targetUuid;
  }

  /**
   * @return The value of the {@code body} attribute
   */
  @JsonProperty("body")
  @Override
  public String getBody() {
    return body;
  }

  /**
   * Copy the current immutable object by setting a value for the {@link NewComment#getAuthorUuid() authorUuid} attribute.
   * A shallow reference equality check is used to prevent copying of the same value by returning {@code this}.
   * @param value A new value for authorUuid
   * @return A modified copy of the {@code this} object
   */
  public final ImmutableNewComment withAuthorUuid(UUID value) {
    if (this.authorUuid == value) return this;
    UUID newValue = Objects.requireNonNull(value, "authorUuid");
    return new ImmutableNewComment(newValue, this.targetUuid, this.body);
  }

  /**
   * Copy the current immutable object by setting a value for the {@link NewComment#getTargetUuid() targetUuid} attribute.
   * A shallow reference equality check is used to prevent copying of the same value by returning {@code this}.
   * @param value A new value for targetUuid
   * @return A modified copy of the {@code this} object
   */
  public final ImmutableNewComment withTargetUuid(UUID value) {
    if (this.targetUuid == value) return this;
    UUID newValue = Objects.requireNonNull(value, "targetUuid");
    return new ImmutableNewComment(this.authorUuid, newValue, this.body);
  }

  /**
   * Copy the current immutable object by setting a value for the {@link NewComment#getBody() body} attribute.
   * An equals check used to prevent copying of the same value by returning {@code this}.
   * @param value A new value for body
   * @return A modified copy of the {@code this} object
   */
  public final ImmutableNewComment withBody(String value) {
    String newValue = Objects.requireNonNull(value, "body");
    if (this.body.equals(newValue)) return this;
    return new ImmutableNewComment(this.authorUuid, this.targetUuid, newValue);
  }

  /**
   * This instance is equal to all instances of {@code ImmutableNewComment} that have equal attribute values.
   * @return {@code true} if {@code this} is equal to {@code another} instance
   */
  @Override
  public boolean equals(Object another) {
    if (this == another) return true;
    return another instanceof ImmutableNewComment
        && equalTo(0, (ImmutableNewComment) another);
  }

  private boolean equalTo(int synthetic, ImmutableNewComment another) {
    return authorUuid.equals(another.authorUuid)
        && targetUuid.equals(another.targetUuid)
        && body.equals(another.body);
  }

  /**
   * Computes a hash code from attributes: {@code authorUuid}, {@code targetUuid}, {@code body}.
   * @return hashCode value
   */
  @Override
  public int hashCode() {
    int h = 5381;
    h += (h << 5) + authorUuid.hashCode();
    h += (h << 5) + targetUuid.hashCode();
    h += (h << 5) + body.hashCode();
    return h;
  }

  /**
   * Prints the immutable value {@code NewComment} with attribute values.
   * @return A string representation of the value
   */
  @Override
  public String toString() {
    return "NewComment{"
        + "authorUuid=" + authorUuid
        + ", targetUuid=" + targetUuid
        + ", body=" + body
        + "}";
  }

  /**
   * Utility type used to correctly read immutable object from JSON representation.
   * @deprecated Do not use this type directly, it exists only for the <em>Jackson</em>-binding infrastructure
   */
  @Generated(from = "NewComment", generator = "Immutables")
  @Deprecated
  @JsonDeserialize
  @JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.NONE)
  static final class Json extends NewComment {
    UUID authorUuid;
    UUID targetUuid;
    String body;
    @JsonProperty("authorUuid")
    public void setAuthorUuid(UUID authorUuid) {
      this.authorUuid = authorUuid;
    }
    @JsonProperty("targetUuid")
    public void setTargetUuid(UUID targetUuid) {
      this.targetUuid = targetUuid;
    }
    @JsonProperty("body")
    public void setBody(String body) {
      this.body = body;
    }
    @Override
    public UUID getAuthorUuid() { throw new UnsupportedOperationException(); }
    @Override
    public UUID getTargetUuid() { throw new UnsupportedOperationException(); }
    @Override
    public String getBody() { throw new UnsupportedOperationException(); }
  }

  /**
   * @param json A JSON-bindable data structure
   * @return An immutable value type
   * @deprecated Do not use this method directly, it exists only for the <em>Jackson</em>-binding infrastructure
   */
  @Deprecated
  @JsonCreator(mode = JsonCreator.Mode.DELEGATING)
  static ImmutableNewComment fromJson(Json json) {
    ImmutableNewComment.Builder builder = ImmutableNewComment.builder();
    if (json.authorUuid != null) {
      builder.authorUuid(json.authorUuid);
    }
    if (json.targetUuid != null) {
      builder.targetUuid(json.targetUuid);
    }
    if (json.body != null) {
      builder.body(json.body);
    }
    return builder.build();
  }

  /**
   * Creates an immutable copy of a {@link NewComment} value.
   * Uses accessors to get values to initialize the new immutable instance.
   * If an instance is already immutable, it is returned as is.
   * @param instance The instance to copy
   * @return A copied immutable NewComment instance
   */
  public static ImmutableNewComment copyOf(NewComment instance) {
    if (instance instanceof ImmutableNewComment) {
      return (ImmutableNewComment) instance;
    }
    return ImmutableNewComment.builder()
        .from(instance)
        .build();
  }

  /**
   * Creates a builder for {@link ImmutableNewComment ImmutableNewComment}.
   * <pre>
   * ImmutableNewComment.builder()
   *    .authorUuid(UUID) // required {@link NewComment#getAuthorUuid() authorUuid}
   *    .targetUuid(UUID) // required {@link NewComment#getTargetUuid() targetUuid}
   *    .body(String) // required {@link NewComment#getBody() body}
   *    .build();
   * </pre>
   * @return A new ImmutableNewComment builder
   */
  public static ImmutableNewComment.Builder builder() {
    return new ImmutableNewComment.Builder();
  }

  /**
   * Builds instances of type {@link ImmutableNewComment ImmutableNewComment}.
   * Initialize attributes and then invoke the {@link #build()} method to create an
   * immutable instance.
   * <p><em>{@code Builder} is not thread-safe and generally should not be stored in a field or collection,
   * but instead used immediately to create instances.</em>
   */
  @Generated(from = "NewComment", generator = "Immutables")
  public static final class Builder {
    private static final long INIT_BIT_AUTHOR_UUID = 0x1L;
    private static final long INIT_BIT_TARGET_UUID = 0x2L;
    private static final long INIT_BIT_BODY = 0x4L;
    private long initBits = 0x7L;

    private UUID authorUuid;
    private UUID targetUuid;
    private String body;

    private Builder() {
    }

    /**
     * Fill a builder with attribute values from the provided {@code NewComment} instance.
     * Regular attribute values will be replaced with those from the given instance.
     * Absent optional values will not replace present values.
     * @param instance The instance from which to copy values
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder from(NewComment instance) {
      Objects.requireNonNull(instance, "instance");
      authorUuid(instance.getAuthorUuid());
      targetUuid(instance.getTargetUuid());
      body(instance.getBody());
      return this;
    }

    /**
     * Initializes the value for the {@link NewComment#getAuthorUuid() authorUuid} attribute.
     * @param authorUuid The value for authorUuid 
     * @return {@code this} builder for use in a chained invocation
     */
    @JsonProperty("authorUuid")
    public final Builder authorUuid(UUID authorUuid) {
      this.authorUuid = Objects.requireNonNull(authorUuid, "authorUuid");
      initBits &= ~INIT_BIT_AUTHOR_UUID;
      return this;
    }

    /**
     * Initializes the value for the {@link NewComment#getTargetUuid() targetUuid} attribute.
     * @param targetUuid The value for targetUuid 
     * @return {@code this} builder for use in a chained invocation
     */
    @JsonProperty("targetUuid")
    public final Builder targetUuid(UUID targetUuid) {
      this.targetUuid = Objects.requireNonNull(targetUuid, "targetUuid");
      initBits &= ~INIT_BIT_TARGET_UUID;
      return this;
    }

    /**
     * Initializes the value for the {@link NewComment#getBody() body} attribute.
     * @param body The value for body 
     * @return {@code this} builder for use in a chained invocation
     */
    @JsonProperty("body")
    public final Builder body(String body) {
      this.body = Objects.requireNonNull(body, "body");
      initBits &= ~INIT_BIT_BODY;
      return this;
    }

    /**
     * Builds a new {@link ImmutableNewComment ImmutableNewComment}.
     * @return An immutable instance of NewComment
     * @throws java.lang.IllegalStateException if any required attributes are missing
     */
    public ImmutableNewComment build() {
      if (initBits != 0) {
        throw new IllegalStateException(formatRequiredAttributesMessage());
      }
      return new ImmutableNewComment(authorUuid, targetUuid, body);
    }

    private String formatRequiredAttributesMessage() {
      List<String> attributes = new ArrayList<>();
      if ((initBits & INIT_BIT_AUTHOR_UUID) != 0) attributes.add("authorUuid");
      if ((initBits & INIT_BIT_TARGET_UUID) != 0) attributes.add("targetUuid");
      if ((initBits & INIT_BIT_BODY) != 0) attributes.add("body");
      return "Cannot build NewComment, some of required attributes are not set " + attributes;
    }
  }
}
