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
 * Immutable implementation of {@link PostPage}.
 * <p>
 * Use the builder to create immutable instances:
 * {@code ImmutablePostPage.builder()}.
 */
@Generated(from = "PostPage", generator = "Immutables")
@SuppressWarnings({"all"})
@javax.annotation.processing.Generated("org.immutables.processor.ProxyProcessor")
public final class ImmutablePostPage extends PostPage {
  private final UUID uuid;
  private final String authorName;
  private final String title;
  private final String description;
  private final String bodyURL;
  private final int numberOfComments;

  private ImmutablePostPage(
      UUID uuid,
      String authorName,
      String title,
      String description,
      String bodyURL,
      int numberOfComments) {
    this.uuid = uuid;
    this.authorName = authorName;
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
   * @return The value of the {@code authorName} attribute
   */
  @JsonProperty("authorName")
  @Override
  public String getAuthorName() {
    return authorName;
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
   * Copy the current immutable object by setting a value for the {@link PostPage#getUuid() uuid} attribute.
   * A shallow reference equality check is used to prevent copying of the same value by returning {@code this}.
   * @param value A new value for uuid
   * @return A modified copy of the {@code this} object
   */
  public final ImmutablePostPage withUuid(UUID value) {
    if (this.uuid == value) return this;
    UUID newValue = Objects.requireNonNull(value, "uuid");
    return new ImmutablePostPage(newValue, this.authorName, this.title, this.description, this.bodyURL, this.numberOfComments);
  }

  /**
   * Copy the current immutable object by setting a value for the {@link PostPage#getAuthorName() authorName} attribute.
   * An equals check used to prevent copying of the same value by returning {@code this}.
   * @param value A new value for authorName
   * @return A modified copy of the {@code this} object
   */
  public final ImmutablePostPage withAuthorName(String value) {
    String newValue = Objects.requireNonNull(value, "authorName");
    if (this.authorName.equals(newValue)) return this;
    return new ImmutablePostPage(this.uuid, newValue, this.title, this.description, this.bodyURL, this.numberOfComments);
  }

  /**
   * Copy the current immutable object by setting a value for the {@link PostPage#getTitle() title} attribute.
   * An equals check used to prevent copying of the same value by returning {@code this}.
   * @param value A new value for title
   * @return A modified copy of the {@code this} object
   */
  public final ImmutablePostPage withTitle(String value) {
    String newValue = Objects.requireNonNull(value, "title");
    if (this.title.equals(newValue)) return this;
    return new ImmutablePostPage(this.uuid, this.authorName, newValue, this.description, this.bodyURL, this.numberOfComments);
  }

  /**
   * Copy the current immutable object by setting a value for the {@link PostPage#getDescription() description} attribute.
   * An equals check used to prevent copying of the same value by returning {@code this}.
   * @param value A new value for description
   * @return A modified copy of the {@code this} object
   */
  public final ImmutablePostPage withDescription(String value) {
    String newValue = Objects.requireNonNull(value, "description");
    if (this.description.equals(newValue)) return this;
    return new ImmutablePostPage(this.uuid, this.authorName, this.title, newValue, this.bodyURL, this.numberOfComments);
  }

  /**
   * Copy the current immutable object by setting a value for the {@link PostPage#getBodyURL() bodyURL} attribute.
   * An equals check used to prevent copying of the same value by returning {@code this}.
   * @param value A new value for bodyURL
   * @return A modified copy of the {@code this} object
   */
  public final ImmutablePostPage withBodyURL(String value) {
    String newValue = Objects.requireNonNull(value, "bodyURL");
    if (this.bodyURL.equals(newValue)) return this;
    return new ImmutablePostPage(this.uuid, this.authorName, this.title, this.description, newValue, this.numberOfComments);
  }

  /**
   * Copy the current immutable object by setting a value for the {@link PostPage#getNumberOfComments() numberOfComments} attribute.
   * A value equality check is used to prevent copying of the same value by returning {@code this}.
   * @param value A new value for numberOfComments
   * @return A modified copy of the {@code this} object
   */
  public final ImmutablePostPage withNumberOfComments(int value) {
    if (this.numberOfComments == value) return this;
    return new ImmutablePostPage(this.uuid, this.authorName, this.title, this.description, this.bodyURL, value);
  }

  /**
   * This instance is equal to all instances of {@code ImmutablePostPage} that have equal attribute values.
   * @return {@code true} if {@code this} is equal to {@code another} instance
   */
  @Override
  public boolean equals(Object another) {
    if (this == another) return true;
    return another instanceof ImmutablePostPage
        && equalTo(0, (ImmutablePostPage) another);
  }

  private boolean equalTo(int synthetic, ImmutablePostPage another) {
    return uuid.equals(another.uuid)
        && authorName.equals(another.authorName)
        && title.equals(another.title)
        && description.equals(another.description)
        && bodyURL.equals(another.bodyURL)
        && numberOfComments == another.numberOfComments;
  }

  /**
   * Computes a hash code from attributes: {@code uuid}, {@code authorName}, {@code title}, {@code description}, {@code bodyURL}, {@code numberOfComments}.
   * @return hashCode value
   */
  @Override
  public int hashCode() {
    int h = 5381;
    h += (h << 5) + uuid.hashCode();
    h += (h << 5) + authorName.hashCode();
    h += (h << 5) + title.hashCode();
    h += (h << 5) + description.hashCode();
    h += (h << 5) + bodyURL.hashCode();
    h += (h << 5) + numberOfComments;
    return h;
  }

  /**
   * Prints the immutable value {@code PostPage} with attribute values.
   * @return A string representation of the value
   */
  @Override
  public String toString() {
    return "PostPage{"
        + "uuid=" + uuid
        + ", authorName=" + authorName
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
  @Generated(from = "PostPage", generator = "Immutables")
  @Deprecated
  @JsonDeserialize
  @JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.NONE)
  static final class Json extends PostPage {
    UUID uuid;
    String authorName;
    String title;
    String description;
    String bodyURL;
    int numberOfComments;
    boolean numberOfCommentsIsSet;
    @JsonProperty("uuid")
    public void setUuid(UUID uuid) {
      this.uuid = uuid;
    }
    @JsonProperty("authorName")
    public void setAuthorName(String authorName) {
      this.authorName = authorName;
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
    public String getAuthorName() { throw new UnsupportedOperationException(); }
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
  static ImmutablePostPage fromJson(Json json) {
    ImmutablePostPage.Builder builder = ImmutablePostPage.builder();
    if (json.uuid != null) {
      builder.uuid(json.uuid);
    }
    if (json.authorName != null) {
      builder.authorName(json.authorName);
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
   * Creates an immutable copy of a {@link PostPage} value.
   * Uses accessors to get values to initialize the new immutable instance.
   * If an instance is already immutable, it is returned as is.
   * @param instance The instance to copy
   * @return A copied immutable PostPage instance
   */
  public static ImmutablePostPage copyOf(PostPage instance) {
    if (instance instanceof ImmutablePostPage) {
      return (ImmutablePostPage) instance;
    }
    return ImmutablePostPage.builder()
        .from(instance)
        .build();
  }

  /**
   * Creates a builder for {@link ImmutablePostPage ImmutablePostPage}.
   * <pre>
   * ImmutablePostPage.builder()
   *    .uuid(UUID) // required {@link PostPage#getUuid() uuid}
   *    .authorName(String) // required {@link PostPage#getAuthorName() authorName}
   *    .title(String) // required {@link PostPage#getTitle() title}
   *    .description(String) // required {@link PostPage#getDescription() description}
   *    .bodyURL(String) // required {@link PostPage#getBodyURL() bodyURL}
   *    .numberOfComments(int) // required {@link PostPage#getNumberOfComments() numberOfComments}
   *    .build();
   * </pre>
   * @return A new ImmutablePostPage builder
   */
  public static ImmutablePostPage.Builder builder() {
    return new ImmutablePostPage.Builder();
  }

  /**
   * Builds instances of type {@link ImmutablePostPage ImmutablePostPage}.
   * Initialize attributes and then invoke the {@link #build()} method to create an
   * immutable instance.
   * <p><em>{@code Builder} is not thread-safe and generally should not be stored in a field or collection,
   * but instead used immediately to create instances.</em>
   */
  @Generated(from = "PostPage", generator = "Immutables")
  public static final class Builder {
    private static final long INIT_BIT_UUID = 0x1L;
    private static final long INIT_BIT_AUTHOR_NAME = 0x2L;
    private static final long INIT_BIT_TITLE = 0x4L;
    private static final long INIT_BIT_DESCRIPTION = 0x8L;
    private static final long INIT_BIT_BODY_U_R_L = 0x10L;
    private static final long INIT_BIT_NUMBER_OF_COMMENTS = 0x20L;
    private long initBits = 0x3fL;

    private UUID uuid;
    private String authorName;
    private String title;
    private String description;
    private String bodyURL;
    private int numberOfComments;

    private Builder() {
    }

    /**
     * Fill a builder with attribute values from the provided {@code PostPage} instance.
     * Regular attribute values will be replaced with those from the given instance.
     * Absent optional values will not replace present values.
     * @param instance The instance from which to copy values
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder from(PostPage instance) {
      Objects.requireNonNull(instance, "instance");
      uuid(instance.getUuid());
      authorName(instance.getAuthorName());
      title(instance.getTitle());
      description(instance.getDescription());
      bodyURL(instance.getBodyURL());
      numberOfComments(instance.getNumberOfComments());
      return this;
    }

    /**
     * Initializes the value for the {@link PostPage#getUuid() uuid} attribute.
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
     * Initializes the value for the {@link PostPage#getAuthorName() authorName} attribute.
     * @param authorName The value for authorName 
     * @return {@code this} builder for use in a chained invocation
     */
    @JsonProperty("authorName")
    public final Builder authorName(String authorName) {
      this.authorName = Objects.requireNonNull(authorName, "authorName");
      initBits &= ~INIT_BIT_AUTHOR_NAME;
      return this;
    }

    /**
     * Initializes the value for the {@link PostPage#getTitle() title} attribute.
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
     * Initializes the value for the {@link PostPage#getDescription() description} attribute.
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
     * Initializes the value for the {@link PostPage#getBodyURL() bodyURL} attribute.
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
     * Initializes the value for the {@link PostPage#getNumberOfComments() numberOfComments} attribute.
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
     * Builds a new {@link ImmutablePostPage ImmutablePostPage}.
     * @return An immutable instance of PostPage
     * @throws java.lang.IllegalStateException if any required attributes are missing
     */
    public ImmutablePostPage build() {
      if (initBits != 0) {
        throw new IllegalStateException(formatRequiredAttributesMessage());
      }
      return new ImmutablePostPage(uuid, authorName, title, description, bodyURL, numberOfComments);
    }

    private String formatRequiredAttributesMessage() {
      List<String> attributes = new ArrayList<>();
      if ((initBits & INIT_BIT_UUID) != 0) attributes.add("uuid");
      if ((initBits & INIT_BIT_AUTHOR_NAME) != 0) attributes.add("authorName");
      if ((initBits & INIT_BIT_TITLE) != 0) attributes.add("title");
      if ((initBits & INIT_BIT_DESCRIPTION) != 0) attributes.add("description");
      if ((initBits & INIT_BIT_BODY_U_R_L) != 0) attributes.add("bodyURL");
      if ((initBits & INIT_BIT_NUMBER_OF_COMMENTS) != 0) attributes.add("numberOfComments");
      return "Cannot build PostPage, some of required attributes are not set " + attributes;
    }
  }
}
