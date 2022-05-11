import 'dart:convert';

class Comment {
  String uuid;
  String author;
  String body;
  String targetUuid;
  String timestamp;

  Comment(
    this.uuid,
    this.author,
    this.body,
    this.targetUuid,
    this.timestamp,
  );

  factory Comment.fromJson(dynamic json) {
    return Comment(
      json['uuid'] as String,
      // json['children'] as List<Comment>,
      json['author'] as String,
      json['body'] as String,
      json['targetUuid'] as String,
      json['timestamp'] as String,
    );
  }

  @override
  String toString() {
    return jsonEncode({
      "authorUuid": author,
      "targetUuid": targetUuid,
      "body": body,
    });
  }
}
