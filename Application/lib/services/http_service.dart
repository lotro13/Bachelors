import 'dart:convert';

import 'package:application/domain/access_type.dart';
import 'package:application/domain/challenge.dart';
import 'package:application/domain/challenge_status.dart';
import 'package:application/domain/challenge_type.dart';
import 'package:application/domain/group.dart';
import 'package:application/domain/post.dart';
import 'package:application/domain/comment.dart';
import 'package:shared_preferences/shared_preferences.dart';

import 'package:http/http.dart' as http;
import 'rest_client.dart';

class HttpService {
  static String baseUrl = "http://10.0.2.2:8080";

  static Future<bool> requestToken(String email) async {
    var parse = Uri.parse(baseUrl + '/auth/tokenRequest');
    var response = await http.post(
      parse,
      headers: <String, String>{
        'Content-Type': 'application/json; charset=UTF-8',
      },
      body: jsonEncode({"email": email}),
    );

    if (response.statusCode == 200) {
      print('Token requested');
      return true;
    } else {
      print("Token request failed");
      return false;
    }
  }

  static Future<String?> getCurrentUserUuid() async {
    var parse = Uri.parse(baseUrl + '/users/me');
    var response = await RestClient.get(parse);

    if (response.statusCode == 200) {
      final data = json.decode(response.body);
      String userUuid = data;
      print("User me is: $data");

      return userUuid;
    } else {
      return null;
    }
  }

  static Future<String?> login(String email, String token) async {
    SharedPreferences sharedPreferences = await SharedPreferences.getInstance();
    sharedPreferences.setString("email", email);
    sharedPreferences.setString("token", token);

    try {
      var login = Uri.parse(baseUrl + '/users/me');
      var response = await RestClient.get(login);
      final data = json.decode(response.body);

      if (response.statusCode == 200) {
        sharedPreferences.setString("me", data);

        print("User logged in: $data");
        return data;
      }
    } on Exception {
      print("Authorizaion exception thrown");
    }

    print("User is not logged in");

    sharedPreferences.remove("email");
    sharedPreferences.remove("token");
    sharedPreferences.remove("me");
    return null;
  }

  static Future<List<Post>> getGeneralFeed() async {
    var parse = Uri.parse(baseUrl + '/api/feed');
    var response = await RestClient.get(parse);

    if (response.statusCode == 200) {
      List data = json.decode(response.body);
      var receivedItems = (data).map((e) => Post.fromJson(e)).toList();

      print('Posts receievd');
      print(receivedItems.length);

      return receivedItems;
    } else {
      print("Fetching general post has failed");
      throw Exception();
    }
  }

  static Future<List<Group>> getUsersGroups() async {
    var parse = Uri.parse(baseUrl + '/api/groups');
    var response = await RestClient.get(parse);

    if (response.statusCode == 200) {
      List data = json.decode(response.body);
      var receivedItems = (data).map((e) => Group.fromJson(e)).toList();

      return receivedItems;
    } else {
      throw Exception();
    }
  }

  static getActiveUserChallengess() async {
    var parse = Uri.parse(baseUrl + '/api/challenges/active');
    var response = await RestClient.get(parse);

    if (response.statusCode == 200) {
      List data = json.decode(response.body);
      var receivedItems = (data).map((e) => Challenge.fromJson(e)).toList();

      print('Active challenges receievd');
      print(receivedItems.length);
      return receivedItems;
    } else {
      throw Exception();
    }
  }

  static getGroupByUuid(String uuid) async {
    var parse = Uri.parse(baseUrl + '/api/groups/' + uuid);
    var response = await RestClient.get(parse);

    if (response.statusCode == 200) {
      final data = json.decode(response.body);
      Group receivedItem = Group.fromJson(data);
      return receivedItem;
    } else {
      print('Group by UUID request has failed');
      throw Exception();
    }
  }

  static getGroupChallenges(String groupUuid) async {
    var parse = Uri.parse(baseUrl + '/api/groups/' + groupUuid + '/challenges');
    var response = await RestClient.get(parse);

    if (response.statusCode == 200) {
      List data = json.decode(response.body);
      var receivedItems = (data).map((e) => Challenge.fromJson(e)).toList();

      return receivedItems;
    } else {
      print("Group challenges fetch has failed");
      throw Exception();
    }
  }

  static getGroupFeed(String groupUuid) async {
    SharedPreferences sharedPreferences = await SharedPreferences.getInstance();
    String me = sharedPreferences.getString("me")!;
    var parse =
        Uri.parse(baseUrl + '/api/groups/' + groupUuid + '/feed?userUuid=$me');
    var response = await RestClient.get(parse);

    if (response.statusCode == 200) {
      List data = json.decode(response.body);
      var receivedItems = (data).map((e) => Post.fromJson(e)).toList();

      return receivedItems;
    } else {
      throw Exception("Group feed fetch has failed");
    }
  }

  static getChallengeFeed(String challengeUuid) async {
    var parse =
        Uri.parse(baseUrl + '/api/challenges/' + challengeUuid + '/feed');
    var response = await RestClient.get(parse);

    if (response.statusCode == 200) {
      List data = json.decode(response.body);
      var receivedItems = (data).map((e) => Post.fromJson(e)).toList();

      return receivedItems;
    } else {
      throw Exception("Challenge feed fetch has failed");
    }
  }

  static getChallengeByUuid(String uuid) async {
    var parse = Uri.parse(baseUrl + '/api/challenges/' + uuid);
    var response = await RestClient.get(parse);

    if (response.statusCode == 200) {
      final data = json.decode(response.body);
      var receivedItem = Challenge.fromJson(data);

      print('Challenge with UUID: ' + uuid + ' received');
      return receivedItem;
    } else {
      throw Exception("Challenge fetch has failed");
    }
  }

  static getPostByUuid(String uuid) async {
    var parse = Uri.parse(baseUrl + '/api/feed/' + uuid);
    var response = await RestClient.get(parse);

    if (response.statusCode == 200) {
      final data = json.decode(response.body);
      var receivedItem = Post.fromJson(data);

      print('Post with UUID: ' + uuid + ' received');
      return receivedItem;
    } else {
      throw Exception("Post fetch has failed");
    }
  }

  static getPostComments(String uuid) async {
    var parse = Uri.parse(baseUrl + '/api/feed/' + uuid + '/comments');
    var response = await RestClient.get(parse);

    if (response.statusCode == 200) {
      List data = json.decode(response.body);
      var receivedItems = (data).map((e) => Comment.fromJson(e)).toList();

      print('Comments received');
      print(receivedItems.length);

      return receivedItems;
    } else {
      throw Exception("Post comments fetch has failed");
    }
  }

  static startChallenge(String challengeUuid) async {
    var parse =
        Uri.parse(baseUrl + '/api/challenges/' + challengeUuid + '/start');
    var response = await RestClient.get(parse);

    if (response.statusCode == 200) {
      print('Challenge with UUID: ' + challengeUuid + ' started');
    } else {
      throw Exception("Challenge fetch has failed");
    }
  }

  static stopChallenge(String challengeUuid) async {
    var parse =
        Uri.parse(baseUrl + '/api/challenges/' + challengeUuid + '/close');
    var response = await RestClient.get(parse);

    if (response.statusCode == 200) {
      print('Challenge with UUID: ' + challengeUuid + ' stopped');
    } else {
      throw Exception("Challenge fetch has failed");
    }
  }

  static createNewChallenge(
    String targetUuid,
    String name,
    ChallengeType challengeType,
    DateTime dateTime,
  ) async {
    SharedPreferences sharedPreferences = await SharedPreferences.getInstance();
    String founder = sharedPreferences.getString("me")!;
    Challenge challenge = Challenge(
        "",
        founder,
        targetUuid,
        name,
        "",
        challengeType,
        dateTime,
        AccessType.PUBLIC,
        ChallengeStatus.STARTED,
        false,
        false,
        false, {});
    var parse = Uri.parse(baseUrl + '/api/challenges/create');
    var response = await RestClient.post(
      parse,
      headers: <String, String>{
        'Content-Type': 'application/json; charset=UTF-8',
      },
      body: challenge.toString(),
    );

    if (response.statusCode == 200) {
      print('New challenge created');
      return true;
    } else {
      print("Challenge creation has failed");
      return false;
    }
  }

  static createNewGroup(String name, AccessType accessType) async {
    SharedPreferences sharedPreferences = await SharedPreferences.getInstance();
    String founder = sharedPreferences.getString("me")!;
    Group group = Group("", name, accessType, founder, false, false, [], {});

    var parse = Uri.parse(baseUrl + '/api/groups/create');
    var response = await RestClient.post(
      parse,
      headers: <String, String>{
        'Content-Type': 'application/json; charset=UTF-8',
      },
      body: group.toString(),
    );

    if (response.statusCode == 200) {
      print('New group created');
      return true;
    } else {
      print("Group creation has failed");
      return false;
    }
  }

  static postNewComment(Comment comment) async {
    var parse = Uri.parse(baseUrl + '/api/feed/comments');
    var response = await RestClient.post(
      parse,
      headers: <String, String>{
        'Content-Type': 'application/json; charset=UTF-8',
      },
      body: comment.toString(),
    );

    if (response.statusCode == 200) {
      print('New comment created');
      return true;
    } else {
      print("Comment creation has failed");
      return false;
    }
  }

  static createNewPost(
      String target, String title, String description, String bodyURL) async {
    SharedPreferences sharedPreferences = await SharedPreferences.getInstance();
    String author = sharedPreferences.getString("me")!;
    Post post = Post("", author, target, title, description, bodyURL, 0);

    var parse = Uri.parse(baseUrl + '/api/feed/posts');
    var response = await RestClient.post(
      parse,
      headers: <String, String>{
        'Content-Type': 'application/json; charset=UTF-8',
      },
      body: post.toString(),
    );

    if (response.statusCode == 200) {
      print('New post created');
      return true;
    } else {
      print("Post creation has failed");
      return false;
    }
  }
}
