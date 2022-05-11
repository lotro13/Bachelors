class User {
  String uuid;
  String username;

  User(this.uuid, this.username);

  factory User.fromJson(dynamic json) {
    return User(json['uuid'] as String, json['username'] as String);
  }
}
