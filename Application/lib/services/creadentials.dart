import 'dart:convert';

class Credentials {
  final String username;
  final String password;

  Credentials(
    this.username,
    this.password,
  );

  @override
  String toString() {
    String charset = base64.encode(utf8.encode('$username:$password'));
    return "Basic $charset";
  }
}
