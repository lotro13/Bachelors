import 'package:application/services/creadentials.dart';
import 'package:application/services/request.dart';
import 'package:shared_preferences/shared_preferences.dart';
import 'package:http/http.dart' as http;

class RestClient {
  static Future<http.Response> get(Uri uri,
      {Map<String, String>? headers}) async {
    SharedPreferences sharedPreferences = await SharedPreferences.getInstance();
    Credentials? credentials;

    if (sharedPreferences.containsKey('email') &&
        sharedPreferences.containsKey('token')) {
      credentials = Credentials(
        sharedPreferences.getString('email')!,
        sharedPreferences.getString('token')!,
      );
    }

    return getAuth(Request(uri, headers: headers), credentials);
  }

  static Future<http.Response> getAuth(
      Request request, Credentials? credentialsOp) async {
    print('Doing GET on ${request.uri.path}');

    request = auth(request, credentialsOp);
    http.Response response = await http.get(
      request.uri,
      headers: request.headers,
    );

    return response;
  }

  static Future<http.Response> post(Uri uri,
      {Map<String, String>? headers, Object? body}) async {
    SharedPreferences sharedPreferences = await SharedPreferences.getInstance();
    Credentials? credentials;

    if (sharedPreferences.containsKey('email') &&
        sharedPreferences.containsKey('token')) {
      credentials = Credentials(sharedPreferences.getString('email')!,
          sharedPreferences.getString('token')!);
    }
    return postAuth(Request(uri, headers: headers, body: body), credentials);
  }

  static Future<http.Response> postAuth(
      Request request, Credentials? credentialsOp) async {
    print('Doing POST on ${request.uri.path}');

    request = auth(request, credentialsOp);

    return await http.post(request.uri,
        headers: request.headers!, body: request.body!);
  }

  static auth(Request request, Credentials? credentials) {
    if (credentials != null) {
      String credential = credentials.toString();
      request.addHeadder("Authorization", credential.toString());
    }

    return request;
  }
}
