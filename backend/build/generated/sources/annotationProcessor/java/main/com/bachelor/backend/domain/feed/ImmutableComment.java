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
 * Immutable implementation of {@link Comment}.
 * <p>
 * Use the builder to create immutable instances:
 * {@code ImmutableComment.builder()}.
 */
@Generated(from = "Comment", generator = "Immutables")
@SuppressWarnings({"all"})
@javax.annotation.processing.Generated("org.immutables.processor.ProxyProcessor")
public final class ImmutableComment extends Comment {
  private final UUID uuid;
  private final UUID authorUuid;
  private final UUID targetUuid;
  private final String body;
  private final String timestamp;
  private final String author;

  private ImmutableComment(ImmutableComment.Builder builder) {
    this.uuid = builder.uuid;
    this.authorUuid = builder.authorUuid;
    this.targetUuid = builder.targetUuid;
    this.body = builder.body;
    this.timestamp = builder.timestamp;
    this.author = builder.author != null
        ? builder.author
        : Objects.requireNonNull(super.getAuthor(), "author");
  }

  private ImmutableComment(
      UUID uuid,
      UUID authorUuid,
      UUID targetUuid,
      String body,
      String timestamp,
      String author) {
    this.uuid = uuid;
    this.authorUuid = authorUuid;
    this.targetUuid = targetUuid;
    this.body = body;
    this.timestamp = timestamp;
    this.author = author;
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
   * @return The value of the {@code timestamp} attribute
   */
  @JsonProperty("timestamp")
  @Override
  public String getTimestamp() {
    return timestamp;
  }

  /**
   * @return The value of the {@code author} attribute
   */
  @JsonProperty("author")
  @Override
  public String getAuthor() {
    return author;
  }

  /**
   * Copy the current immutable object by setting a value for the {@link Comment#getUuid() uuid} attribute.
   * A shallow reference equality check is used to prevent copying of the same value by returning {@code this}.
   * @param value A new value for uuid
   * @return A modified copy of the {@code this} object
   */
  public final ImmutableComment withUuid(UUID value) {
    if (this.uuid == value) return this;
    UUID newValue = Objects.requireNonNull(value, "uuid");
    return new ImmutableComment(newValue, this.authorUuid, this.targetUuid, this.body, this.timestamp, this.author);
  }

  /**
   * Copy the current immutable object by setting a value for the {@link Comment#getAuthorUuid() authorUuid} attribute.
   * A shallow reference equality check is used to prevent copying of the same value by returning {@code this}.
   * @param value A new value for authorUuid
   * @return A modified copy of the {@code this} object
   */
  public final ImmutableComment withAuthorUuid(UUID value) {
    if (this.authorUuid == value) return this;
    UUID newValue = Objects.requireNonNull(value, "authorUuid");
    return new ImmutableComment(this.uuid, newValue, this.targetUuid, this.body, this.timestamp, this.author);
  }

  /**
   * Copy the current immutable object by setting a value for the {@link Comment#getTargetUuid() targetUuid} attribute.
   * A shallow reference equality check is used to prevent copying of the same value by returning {@code this}.
   * @param value A new value for targetUuid
   * @return A modified copy of the {@code this} object
   */
  public final ImmutableComment withTargetUuid(UUID value) {
    if (this.targetUuid == value) return this;
    UUID newValue = Objects.requireNonNull(value, "targetUuid");
    return new ImmutableComment(this.uuid, this.authorUuid, newValue, this.body, this.timestamp, this.author);
  }

  /**
   * Copy the current immutable object by setting a value for the {@link Comment#getBody() body} attribute.
   * An equals check used to prevent copying of the same value by returning {@code this}.
   * @param value A new value for body
   * @return A modified copy of the {@code this} object
   */
  public final ImmutableComment withBody(String value) {
    String newValue = Objects.requireNonNull(value, "body");
    if (this.body.equals(newValue)) return this;
    return new ImmutableComment(this.uuid, this.authorUuid, this.targetUuid, newValue, this.timestamp, this.author);
  }

  /**
   * Copy the current immutable object by setting a value for the {@link Comment#getTimestamp() timestamp} attribute.
   * An equals check used to prevent copying of the same value by returning {@code this}.
   * @param value A new value for timestamp
   * @return A modified copy of the {@code this} object
   */
  public final ImmutableComment withTimestamp(String value) {
    String newValue = Objects.requireNonNull(value, "timestamp");
    if (this.timestamp.equals(newValue)) return this;
    return new ImmutableComment(this.uuid, this.authorUuid, this.targetUuid, this.body, newValue, this.author);
  }

  /**
   * Copy the current immutable object by setting a value for the {@link Comment#getAuthor() author} attribute.
   * An equals check used to prevent copying of the same value by returning {@code this}.
   * @param value A new value for author
   * @return A modified copy of the {@code this} object
   */
  public final ImmutableComment withAuthor(String value) {
    String newValue = Objects.requireNonNull(value, "author");
    if (this.author.equals(newValue)) return this;
    return new ImmutableComment(this.uuid, this.authorUuid, this.targetUuid, this.body, this.timestamp, newValue);
  }

  /**
   * This instance is equal to all instances of {@code ImmutableComment} that have equal attribute values.
   * @return {@code true} if {@code this} is equal to {@code another} instance
   */
  @Override
  public boolean equals(Object another) {
    if (this == another) return true;
    return another instanceof ImmutableComment
        && equalTo(0, (ImmutableComment) another);
  }

  private boolean equalTo(int synthetic, ImmutableComment another) {
    return uuid.equals(another.uuid)
        && authorUuid.equals(another.authorUuid)
        && targetUuid.equals(another.targetUuid)
        && body.equals(another.body)
        && timestamp.equals(another.timestamp)
        && author.equals(another.author);
  }

  /**
   * Computes a hash code from attributes: {@code uuid}, {@code authorUuid}, {@code targetUuid}, {@code body}, {@code timestamp}, {@code author}.
   * @return hashCode value
   */
  @Override
  public int hashCode() {
    int h = 5381;
    h += (h << 5) + uuid.hashCode();
    h += (h << 5) + authorUuid.hashCode();
    h += (h << 5) + targetUuid.hashCode();
    h += (h << 5) + body.hashCode();
    h += (h << 5) + timestamp.hashCode();
    h += (h << 5) + author.hashCode();
    return h;
  }

  /**
   * Prints the immutable value {@code Comment} with attribute values.
   * @return A string representation of the value
   */
  @Override
  public String toString() {
    return "Comment{"
        + "uuid=" + uuid
        + ", authorUuid=" + authorUuid
        + ", targetUuid=" + targetUuid
        + ", body=" + body
        + ", timestamp=" + timestamp
        + ", author=" + author
        + "}";
  }

  /**
   * Utility type used to correctly read immutable object from JSON representation.
   * @deprecated Do not use this type directly, it exists only for the <em>Jackson</em>-binding infrastructure
   */
  @Generated(from = "Comment", generator = "Immutables")
  @Deprecated
  @JsonDeserialize
  @JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.NONE)
  static final class Json extends Comment {
    UUID uuid;
    UUID authorUuid;
    UUID targetUuid;
    String body;
    String timestamp;
    String author;
    @JsonProperty("uuid")
    public void setUuid(UUID uuid) {
      this.uuid = uuid;
    }
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
    @JsonProperty("timestamp")
    public void setTimestamp(String timestamp) {
      this.timestamp = timestamp;
    }
    @JsonProperty("author")
    public void setAuthor(String author) {
      this.author = author;
    }
    @Override
    public UUID getUuid() { throw new UnsupportedOperationException(); }
    @Override
    public UUID getAuthorUuid() { throw new UnsupportedOperationException(); }
    @Override
    public UUID getTargetUuid() { throw new UnsupportedOperationException(); }
    @Override
    public String getBody() { throw new UnsupportedOperationException(); }
    @Override
    public String getTimestamp() { throw new UnsupportedOperationException(); }
    @Override
    public String getAuthor() { throw new UnsupportedOperationException(); }
  }

  /**
   * @param json A JSON-bindable data structure
   * @return An immutable value type
   * @deprecated Do not use this method directly, it exists only for the <em>Jackson</em>-binding infrastructure
   */
  @Deprecated
  @JsonCreator(mode = JsonCreator.Mode.DELEGATING)
  static ImmutableComment fromJson(Json json) {
    ImmutableComment.Builder builder = ImmutableComment.builder();
    if (json.uuid != null) {
      builder.uuid(json.uuid);
    }
    if (json.authorUuid != null) {
      builder.authorUuid(json.authorUuid);
    }
    if (json.targetUuid != null) {
      builder.targetUuid(json.targetUuid);
    }
    if (json.body != null) {
      builder.body(json.body);
    }
    if (json.timestamp != null) {
      builder.timestamp(json.timestamp);
    }
    if (json.author != null) {
      builder.author(json.author);
    }
    return builder.build();
  }

  /**
   * Creates an immutable copy of a {@link Comment} value.
   * Uses accessors to get values to initialize the new immutable instance.
   * If an instance is already immutable, it is returned as is.
   * @param instance The instance to copy
   * @return A copied immutable Comment instance
   */
  public static ImmutableComment copyOf(Comment instance) {
    if (instance instanceof ImmutableComment) {
      return (ImmutableComment) instance;
    }
    return ImmutableComment.builder()
        .from(instance)
        .build();
  }

  /**
   * Creates a builder for {@link ImmutableComment ImmutableComment}.
   * <pre>
   * ImmutableComment.builder()
   *    .uuid(UUID) // required {@link Comment#getUuid() uuid}
   *    .authorUuid(UUID) // required {@link Comment#getAuthorUuid() authorUuid}
   *    .targetUuid(UUID) // required {@link Comment#getTargetUuid() targetUuid}
   *    .body(String) // required {@link Comment#getBody() body}
   *    .timestamp(String) // required {@link Comment#getTimestamp() timestamp}
   *    .author(String) // optional {@link Comment#getAuthor() author}
   *    .build();
   * </pre>
   * @return A new ImmutableComment builder
   */
  public static ImmutableComment.Builder builder() {
    return new ImmutableComment.Builder();
  }

  /**
   * Builds instances of type {@link ImmutableComment ImmutableComment}.
   * Initialize attributes and then invoke the {@link #build()} method to create an
   * immutable instance.
   * <p><em>{@code Builder} is not thread-safe and generally should not be stored in a field or collection,
   * but instead used immediately to create instances.</em>
   */
  @Generated(from = "Comment", generator = "Immutables")
  public static final class Builder {
    private static final long INIT_BIT_UUID = 0x1L;
    private static final long INIT_BIT_AUTHOR_UUID = 0x2L;
    private static final long INIT_BIT_TARGET_UUID = 0x4L;
    private static final long INIT_BIT_BODY = 0x8L;
    private static final long INIT_BIT_TIMESTAMP = 0x10L;
    private long initBits = 0x1fL;

    private UUID uuid;
    private UUID authorUuid;
    private UUID targetUuid;
    private String body;
    private String timestamp;
    private String author;

    private Builder() {
    }

    /**
     * Fill a builder with attribute values from the provided {@code Comment} instance.
     * Regular attribute values will be replaced with those from the given instance.
     * Absent optional values will not replace present values.
     * @param instance The instance from which to copy values
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder from(Comment instance) {
      Objects.requireNonNull(instance, "instance");
      uuid(instance.getUuid());
      authorUuid(instance.getAuthorUuid());
      targetUuid(instance.getTargetUuid());
      body(instance.getBody());
      timestamp(instance.getTimestamp());
      author(instance.getAuthor());
      return this;
    }

    /**
     * Initializes the value for the {@link Comment#getUuid() uuid} attribute.
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
     * Initializes the value for the {@link Comment#getAuthorUuid() authorUuid} attribute.
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
     * Initializes the value for the {@link Comment#getTargetUuid() targetUuid} attribute.
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
     * Initializes the value for the {@link Comment#getBody() body} attribute.
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
     * Initializes the value for the {@link Comment#getTimestamp() timestamp} attribute.
     * @param timestamp The value for timestamp 
     * @return {@code this} builder for use in a chained invocation
     */
    @JsonProperty("timestamp")
    public final Builder timestamp(String timestamp) {
      this.timestamp = Objects.requireNonNull(timestamp, "timestamp");
      initBits &= ~INIT_BIT_TIMESTAMP;
      return this;
    }

    /**
     * Initializes the value for the {@link Comment#getAuthor() author} attribute.
     * <p><em>If not set, this attribute will have a default value as returned by the initializer of {@link Comment#getAuthor() author}.</em>
     * @param author The value for author 
     * @return {@code this} builder for use in a chained invocation
     */
    @JsonProperty("author")
    public final Builder author(String author) {
      this.author = Objects.requireNonNull(author, "author");
      return this;
    }

    /**
     * Builds a new {@link ImmutableComment ImmutableComment}.
     * @return An immutable instance of Comment
     * @throws java.lang.IllegalStateException if any required attributes are missing
     */
    public ImmutableComment build() {
      if (initBits != 0) {
        throw new IllegalStateException(formatRequiredAttributesMessage());
      }
      return new ImmutableComment(this);
    }

    private String formatRequiredAttributesMessage() {
      List<String> attributes = new ArrayList<>();
      if ((initBits & INIT_BIT_UUID) != 0) attributes.add("uuid");
      if ((initBits & INIT_BIT_AUTHOR_UUID) != 0) attributes.add("authorUuid");
      if ((initBits & INIT_BIT_TARGET_UUID) != 0) attributes.add("targetUuid");
      if ((initBits & INIT_BIT_BODY) != 0) attributes.add("body");
      if ((initBits & INIT_BIT_TIMESTAMP) != 0) attributes.add("timestamp");
      return "Cannot build Comment, some of required attributes are not set " + attributes;
    }
  }
}
