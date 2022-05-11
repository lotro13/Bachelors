import 'package:application/domain/data_status.dart';
import 'package:application/domain/comment.dart';
import 'package:flutter/cupertino.dart';
import 'package:shared_preferences/shared_preferences.dart';

import '../domain/post.dart';
import '../services/http_service.dart';

class FeedProvider extends ChangeNotifier {
  DataStatus mainFeedStatus = DataStatus.NULL;
  List<Post> mainFeed = [];

  DataStatus groupFeedStatus = DataStatus.NULL;
  List<Post> groupFeed = [];

  DataStatus selectedPostStatus = DataStatus.NULL;
  Post? selectedPost;
  DataStatus postCommentsStatus = DataStatus.NULL;
  List<Comment> postComments = [];

  String? name;

  void getCurrentUsername() async {
    SharedPreferences sharedPreferences = await SharedPreferences.getInstance();
    String? optional = sharedPreferences.getString("name");

    if (optional != null) {
      name = optional;
    }
    name = "Andrej";

    notifyListeners();
  }

  void forceRequestSelectedPost(String uuid) {
    if (selectedPost != null) {
      if (selectedPost!.uuid == uuid) {
        return;
      }
    }
    postComments = [];
    _fetchSelectedPost(uuid);
  }

  void _fetchSelectedPost(String uuid) async {
    try {
      var post = await HttpService.getPostByUuid(uuid);
      selectedPost = post;

      selectedPostStatus = DataStatus.LOADED;
      postCommentsStatus = DataStatus.NULL;

      notifyListeners();
    } on Exception catch (e) {
      print(e);
    }
  }

  void softPostCommentsRequest(String uuid) {
    if (postCommentsStatus == DataStatus.NULL) {
      _fetchPostComments(uuid);
    }
  }

  void _fetchPostComments(String uuid) async {
    try {
      var comments = await HttpService.getPostComments(uuid);
      postComments = comments;

      postCommentsStatus = DataStatus.LOADED;

      notifyListeners();
    } on Exception catch (e) {
      print(e);
    }
  }

  void softRequestMainFeed() {
    if (mainFeedStatus == DataStatus.NULL) {
      _fetchMainFeedFromTheServer();
    }
  }

  void forceRequestMainFeed() {
    _fetchMainFeedFromTheServer();
  }

  Future<void> _fetchMainFeedFromTheServer() async {
    try {
      var posts = await HttpService.getGeneralFeed();
      mainFeed = posts;

      mainFeedStatus = DataStatus.LOADED;

      notifyListeners();
    } on Exception catch (e) {
      print(e);
    }
  }

  List<Post> getMainFeed() {
    return mainFeed;
  }

  Future<void> createNewComment(String body, String targetUuid) async {
    postCommentsStatus = DataStatus.NULL;

    SharedPreferences sharedPreferences = await SharedPreferences.getInstance();
    String author = sharedPreferences.getString("me")!;

    Comment comment =
        Comment("", author, body, targetUuid, DateTime.now().toIso8601String());

    await HttpService.postNewComment(comment);
  }
}
