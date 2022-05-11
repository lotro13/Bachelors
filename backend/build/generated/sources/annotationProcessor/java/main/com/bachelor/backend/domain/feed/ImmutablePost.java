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
 * Immutable implementation of {@link Post}.
 * <p>
 * Use the builder to create immutable instances:
 * {@code ImmutablePost.builder()}.
 */
@Generated(from = "Post", generator = "Immutables")
@SuppressWarnings({"all"})
@javax.annotation.processing.Generated("org.immutables.processor.ProxyProcessor")
public final class ImmutablePost extends Post {
  private final UUID uuid;
  private final UUID author;
  private final UUID target;
  private final String title;
  private final String description;
  private final String bodyURL;
  private final int numberOfComments;

  private ImmutablePost(
      UUID uuid,
      UUID author,
      UUID target,
      String title,
      String description,
      String bodyURL,
      int numberOfComments) {
    this.uuid = uuid;
    this.author = author;
    this.target = target;
    this.title = title;
    this.description = description;
    this.bodyURL = bodyURL;
    this.numberOfComments = numberOfComments;
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
   * @return The value of the {@code author} attribute
   */
  @JsonProperty("author")
  @Override
  public UUID getAuthor() {
    return author;
  }

  /**
   * @return The value of the {@code target} attribute
   */
  @JsonProperty("target")
  @Override
  public UUID getTarget() {
    return target;
  }

  /**
   * @return The value of the {@code title} attribute
   */
  @JsonProperty("title")
  @Override
  public String getTitle() {
    return title;
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
   * @return The value of the {@code bodyURL} attribute
   */
  @JsonProperty("bodyURL")
  @Override
  public String getBodyURL() {
    return bodyURL;
  }

  /**
   * @return The value of the {@code numberOfComments} attribute
   */
  @JsonProperty("numberOfComments")
  @Override
  public int getNumberOfComments() {
    return numberOfComments;
  }

  /**
   * Copy the current immutable object by setting a value for the {@link Post#getUuid() uuid} attribute.
   * A shallow reference equality check is used to prevent copying of the same value by returning {@code this}.
   * @param value A new value for uuid
   * @return A modified copy of the {@code this} object
   */
  public final ImmutablePost withUuid(UUID value) {
    if (this.uuid == value) return this;
    UUID newValue = Objects.requireNonNull(value, "uuid");
    return new ImmutablePost(
        newValue,
        this.author,
        this.target,
        this.title,
        this.description,
        this.bodyURL,
        this.numberOfComments);
  }

  /**
   * Copy the current immutable object by setting a value for the {@link Post#getAuthor() author} attribute.
   * A shallow reference equality check is used to prevent copying of the same value by returning {@code this}.
   * @param value A new value for author
   * @return A modified copy of the {@code this} object
   */
  public final ImmutablePost withAuthor(UUID value) {
    if (this.author == value) return this;
    UUID newValue = Objects.requireNonNull(value, "author");
    return new ImmutablePost(
        this.uuid,
        newValue,
        this.target,
        this.title,
        this.description,
        this.bodyURL,
        this.numberOfComments);
  }

  /**
   * Copy the current immutable object by setting a value for the {@link Post#getTarget() target} attribute.
   * A shallow reference equality check is used to prevent copying of the same value by returning {@code this}.
   * @param value A new value for target
   * @return A modified copy of the {@code this} object
   */
  public final ImmutablePost withTarget(UUID value) {
    if (this.target == value) return this;
    UUID newValue = Objects.requireNonNull(value, "target");
    return new ImmutablePost(
        this.uuid,
        this.author,
        newValue,
        this.title,
        this.description,
        this.bodyURL,
        this.numberOfComments);
  }

  /**
   * Copy the current immutable object by setting a value for the {@link Post#getTitle() title} attribute.
   * An equals check used to prevent copying of the same value by returning {@code this}.
   * @param value A new value for title
   * @return A modified copy of the {@code this} object
   */
  public final ImmutablePost withTitle(String value) {
    String newValue = Objects.requireNonNull(value, "title");
    if (this.title.equals(newValue)) return this;
    return new ImmutablePost(
        this.uuid,
        this.author,
        this.target,
        newValue,
        this.description,
        this.bodyURL,
        this.numberOfComments);
  }

  /**
   * Copy the current immutable object by setting a value for the {@link Post#getDescription() description} attribute.
   * An equals check used to prevent copying of the same value by returning {@code this}.
   * @param value A new value for description
   * @return A modified copy of the {@code this} object
   */
  public final ImmutablePost withDescription(String value) {
    String newValue = Objects.requireNonNull(value, "description");
    if (this.description.equals(newValue)) return this;
    return new ImmutablePost(this.uuid, this.author, this.target, this.title, newValue, this.bodyURL, this.numberOfComments);
  }

  /**
   * Copy the current immutable object by setting a value for the {@link Post#getBodyURL() bodyURL} attribute.
   * An equals check used to prevent copying of the same value by returning {@code this}.
   * @param value A new value for bodyURL
   * @return A modified copy of the {@code this} object
   */
  public final ImmutablePost withBodyURL(String value) {
    String newValue = Objects.requireNonNull(value, "bodyURL");
    if (this.bodyURL.equals(newValue)) return this;
    return new ImmutablePost(
        this.uuid,
        this.author,
        this.target,
        this.title,
        this.description,
        newValue,
        this.numberOfComments);
  }

  /**
   * Copy the current immutable object by setting a value for the {@link Post#getNumberOfComments() numberOfComments} attribute.
   * A value equality check is used to prevent copying of the same value by returning {@code this}.
   * @param value A new value for numberOfComments
   * @return A modified copy of the {@code this} object
   */
  public final ImmutablePost withNumberOfComments(int value) {
    if (this.numberOfComments == value) return this;
    return new ImmutablePost(this.uuid, this.author, this.target, this.title, this.description, this.bodyURL, value);
  }

  /**
   * This instance is equal to all instances of {@code ImmutablePost} that have equal attribute values.
   * @return {@code true} if {@code this} is equal to {@code another} instance
   */
  @Override
  public boolean equals(Object another) {
    if (this == another) return true;
    return another instanceof ImmutablePost
        && equalTo(0, (ImmutablePost) another);
  }

  private boolean equalTo(int synthetic, ImmutablePost another) {
    return uuid.equals(another.uuid)
        && author.equals(another.author)
        && target.equals(another.target)
        && title.equals(another.title)
        && description.equals(another.description)
        && bodyURL.equals(another.bodyURL)
        && numberOfComments == another.numberOfComments;
  }

  /**
   * Computes a hash code from attributes: {@code uuid}, {@code author}, {@code target}, {@code title}, {@code description}, {@code bodyURL}, {@code numberOfComments}.
   * @return hashCode value
   */
  @Override
  public int hashCode() {
    int h = 5381;
    h += (h << 5) + uuid.hashCode();
    h += (h << 5) + author.hashCode();
    h += (h << 5) + target.hashCode();
    h += (h << 5) + title.hashCode();
    h += (h << 5) + description.hashCode();
    h += (h << 5) + bodyURL.hashCode();
    h += (h << 5) + numberOfComments;
    return h;
  }

  /**
   * Prints the immutable value {@code Post} with attribute values.
   * @return A string representation of the value
   */
  @Override
  public String toString() {
    return "Post{"
        + "uuid=" + uuid
        + ", author=" + author
        + ", target=" + target
        + ", title=" + title
        + ", description=" + description
        + ", bodyURL=" + bodyURL
        + ", numberOfComments=" + numberOfComments
        + "}";
  }

  /**
   * Utility type used to correctly read immutable object from JSON representation.
   * @deprecated Do not use this type directly, it exists only for the <em>Jackson</em>-binding infrastructure
   */
  @Generated(from = "Post", generator = "Immutables")
  @Deprecated
  @JsonDeserialize
  @JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.NONE)
  static final class Json extends Post {
    UUID uuid;
    UUID author;
    UUID target;
    String title;
    String description;
    String bodyURL;
    int numberOfComments;
    boolean numberOfCommentsIsSet;
    @JsonProperty("uuid")
    public void setUuid(UUID uuid) {
      this.uuid = uuid;
    }
    @JsonProperty("author")
    public void setAuthor(UUID author) {
      this.author = author;
    }
    @JsonProperty("target")
    public void setTarget(UUID target) {
      this.target = target;
    }
    @JsonProperty("title")
    public void setTitle(String title) {
      this.title = title;
    }
    @JsonProperty("description")
    public void setDescription(String description) {
      this.description = description;
    }
    @JsonProperty("bodyURL")
    public void setBodyURL(String bodyURL) {
      this.bodyURL = bodyURL;
    }
    @JsonProperty("numberOfComments")
    public void setNumberOfComments(int numberOfComments) {
      this.numberOfComments = numberOfComments;
      this.numberOfCommentsIsSet = true;
    }
    @Override
    public UUID getUuid() { throw new UnsupportedOperationException(); }
    @Override
    public UUID getAuthor() { throw new UnsupportedOperationException(); }
    @Override
    public UUID getTarget() { throw new UnsupportedOperationException(); }
    @Override
    public String getTitle() { throw new UnsupportedOperationException(); }
    @Override
    public String getDescription() { throw new UnsupportedOperationException(); }
    @Override
    public String getBodyURL() { throw new UnsupportedOperationException(); }
    @Override
    public int getNumberOfComments() { throw new UnsupportedOperationException(); }
  }

  /**
   * @param json A JSON-bindable data structure
   * @return An immutable value type
   * @deprecated Do not use this method directly, it exists only for the <em>Jackson</em>-binding infrastructure
   */
  @Deprecated
  @JsonCreator(mode = JsonCreator.Mode.DELEGATING)
  static ImmutablePost fromJson(Json json) {
    ImmutablePost.Builder builder = ImmutablePost.builder();
    if (json.uuid != null) {
      builder.uuid(json.uuid);
    }
    if (json.author != null) {
      builder.author(json.author);
    }
    if (json.target != null) {
      builder.target(json.target);
    }
    if (json.title != null) {
      builder.title(json.title);
    }
    if (json.description != null) {
      builder.description(json.description);
    }
    if (json.bodyURL != null) {
      builder.bodyURL(json.bodyURL);
    }
    if (json.numberOfCommentsIsSet) {
      builder.numberOfComments(json.numberOfComments);
    }
    return builder.build();
  }

  /**
   * Creates an immutable copy of a {@link Post} value.
   * Uses accessors to get values to initialize the new immutable instance.
   * If an instance is already immutable, it is returned as is.
   * @param instance The instance to copy
   * @return A copied immutable Post instance
   */
  public static ImmutablePost copyOf(Post instance) {
    if (instance instanceof ImmutablePost) {
      return (ImmutablePost) instance;
    }
    return ImmutablePost.builder()
        .from(instance)
        .build();
  }

  /**
   * Creates a builder for {@link ImmutablePost ImmutablePost}.
   * <pre>
   * ImmutablePost.builder()
   *    .uuid(UUID) // required {@link Post#getUuid() uuid}
   *    .author(UUID) // required {@link Post#getAuthor() author}
   *    .target(UUID) // required {@link Post#getTarget() target}
   *    .title(String) // required {@link Post#getTitle() title}
   *    .description(String) // required {@link Post#getDescription() description}
   *    .bodyURL(String) // required {@link Post#getBodyURL() bodyURL}
   *    .numberOfComments(int) // required {@link Post#getNumberOfComments() numberOfComments}
   *    .build();
   * </pre>
   * @return A new ImmutablePost builder
   */
  public static ImmutablePost.Builder builder() {
    return new ImmutablePost.Builder();
  }

  /**
   * Builds instances of type {@link ImmutablePost ImmutablePost}.
   * Initialize attributes and then invoke the {@link #build()} method to create an
   * immutable instance.
   * <p><em>{@code Builder} is not thread-safe and generally should not be stored in a field or collection,
   * but instead used immediately to create instances.</em>
   */
  @Generated(from = "Post", generator = "Immutables")
  public static final class Builder {
    private static final long INIT_BIT_UUID = 0x1L;
    private static final long INIT_BIT_AUTHOR = 0x2L;
    private static final long INIT_BIT_TARGET = 0x4L;
    private static final long INIT_BIT_TITLE = 0x8L;
    private static final long INIT_BIT_DESCRIPTION = 0x10L;
    private static final long INIT_BIT_BODY_U_R_L = 0x20L;
    private static final long INIT_BIT_NUMBER_OF_COMMENTS = 0x40L;
    private long initBits = 0x7fL;

    private UUID uuid;
    private UUID author;
    private UUID target;
    private String title;
    private String description;
    private String bodyURL;
    private int numberOfComments;

    private Builder() {
    }

    /**
     * Fill a builder with attribute values from the provided {@code Post} instance.
     * Regular attribute values will be replaced with those from the given instance.
     * Absent optional values will not replace present values.
     * @param instance The instance from which to copy values
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder from(Post instance) {
      Objects.requireNonNull(instance, "instance");
      uuid(instance.getUuid());
      author(instance.getAuthor());
      target(instance.getTarget());
      title(instance.getTitle());
      description(instance.getDescription());
      bodyURL(instance.getBodyURL());
      numberOfComments(instance.getNumberOfComments());
      return this;
    }

    /**
     * Initializes the value for the {@link Post#getUuid() uuid} attribute.
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
     * Initializes the value for the {@link Post#getAuthor() author} attribute.
     * @param author The value for author 
     * @return {@code this} builder for use in a chained invocation
     */
    @JsonProperty("author")
    public final Builder author(UUID author) {
      this.author = Objects.requireNonNull(author, "author");
      initBits &= ~INIT_BIT_AUTHOR;
      return this;
    }

    /**
     * Initializes the value for the {@link Post#getTarget() target} attribute.
     * @param target The value for target 
     * @return {@code this} builder for use in a chained invocation
     */
    @JsonProperty("target")
    public final Builder target(UUID target) {
      this.target = Objects.requireNonNull(target, "target");
      initBits &= ~INIT_BIT_TARGET;
      return this;
    }

    /**
     * Initializes the value for the {@link Post#getTitle() title} attribute.
     * @param title The value for title 
     * @return {@code this} builder for use in a chained invocation
     */
    @JsonProperty("title")
    public final Builder title(String title) {
      this.title = Objects.requireNonNull(title, "title");
      initBits &= ~INIT_BIT_TITLE;
      return this;
    }

    /**
     * Initializes the value for the {@link Post#getDescription() description} attribute.
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
     * Initializes the value for the {@link Post#getBodyURL() bodyURL} attribute.
     * @param bodyURL The value for bodyURL 
     * @return {@code this} builder for use in a chained invocation
     */
    @JsonProperty("bodyURL")
    public final Builder bodyURL(String bodyURL) {
      this.bodyURL = Objects.requireNonNull(bodyURL, "bodyURL");
      initBits &= ~INIT_BIT_BODY_U_R_L;
      return this;
    }

    /**
     * Initializes the value for the {@link Post#getNumberOfComments() numberOfComments} attribute.
     * @param numberOfComments The value for numberOfComments 
     * @return {@code this} builder for use in a chained invocation
     */
    @JsonProperty("numberOfComments")
    public final Builder numberOfComments(int numberOfComments) {
      this.numberOfComments = numberOfComments;
      initBits &= ~INIT_BIT_NUMBER_OF_COMMENTS;
      return this;
    }

    /**
     * Builds a new {@link ImmutablePost ImmutablePost}.
     * @return An immutable instance of Post
     * @throws java.lang.IllegalStateException if any required attributes are missing
     */
    public ImmutablePost build() {
      if (initBits != 0) {
        throw new IllegalStateException(formatRequiredAttributesMessage());
      }
      return new ImmutablePost(uuid, author, target, title, description, bodyURL, numberOfComments);
    }

    private String formatRequiredAttributesMessage() {
      List<String> attributes = new ArrayList<>();
      if ((initBits & INIT_BIT_UUID) != 0) attributes.add("uuid");
      if ((initBits & INIT_BIT_AUTHOR) != 0) attributes.add("author");
      if ((initBits & INIT_BIT_TARGET) != 0) attributes.add("target");
      if ((initBits & INIT_BIT_TITLE) != 0) attributes.add("title");
      if ((initBits & INIT_BIT_DESCRIPTION) != 0) attributes.add("description");
      if ((initBits & INIT_BIT_BODY_U_R_L) != 0) attributes.add("bodyURL");
      if ((initBits & INIT_BIT_NUMBER_OF_COMMENTS) != 0) attributes.add("numberOfComments");
      return "Cannot build Post, some of required attributes are not set " + attributes;
    }
  }
}
