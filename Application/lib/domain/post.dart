import 'dart:convert';

class Post {
  String uuid;
  String author;
  String target;
  String title;
  String description;
  String bodyURL;
  int numberOfComments;
  bool isRated;

  Post(this.uuid, this.author, this.target, this.title, this.description,
      this.bodyURL, this.numberOfComments, this.isRated);

  factory Post.fromJson(dynamic json) {
    return Post(
      json['uuid'] as String,
      json['authorName'] as String,
      "",
      json['title'] as String,
      json['description'] as String,
      json['bodyURL'] as String,
      json['numberOfComments'] as int,
      false,
    );
  }

  @override
  String toString() {
    return jsonEncode({
      "author": author,
      "target": target,
      "title": title,
      "description": description,
      "bodyURL": bodyURL,
      "isRated": isRated,
    });
  }
}
