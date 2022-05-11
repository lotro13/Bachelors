import 'package:application/domain/challenge.dart';
import 'package:application/domain/data_status.dart';
import 'package:application/services/http_service.dart';
import 'package:flutter/material.dart';

import '../domain/group.dart';
import '../domain/post.dart';

class GroupsProvider extends ChangeNotifier {
  List<Challenge> activeChallenges = [];
  DataStatus activeChallengeStatus = DataStatus.NULL;
  List<Group> userGroups = [];
  DataStatus userGroupsStatus = DataStatus.NULL;

  Group? selectedGroup;
  DataStatus selectedGroupStatus = DataStatus.NULL;
  List<Post> groupFeed = [];
  DataStatus groupFeedStatus = DataStatus.NULL;
  List<Challenge> groupChallenges = [];
  DataStatus groupChallengesStatus = DataStatus.NULL;

  Challenge? selectedChallenge;
  DataStatus selectedChallengeStatus = DataStatus.NULL;
  List<Post> challengeFeed = [];
  DataStatus challengeFeedStatus = DataStatus.NULL;

  String? postCreationTargetUuid;

  void setPostCreationTargetUuid(String? targetUuid) {
    print("Post creation target set");

    postCreationTargetUuid = targetUuid;
    notifyListeners();
  }

  void initGrouList() {
    print("Group list initiated");

    hardUserGroupsRequest();
    hardActiveUserChallengesRequest();
  }

  void hardUserGroupsRequest() {
    print("Hard group request");
    _fetchUsersGroupsFromTheServer();
  }

  Future<void> _fetchUsersGroupsFromTheServer() async {
    try {
      var groups = await HttpService.getUsersGroups();
      userGroups = groups;

      userGroupsStatus = DataStatus.LOADED;

      notifyListeners();
    } on Exception catch (e) {
      print(e);
    }
  }

  void hardActiveUserChallengesRequest() {
    print("Hard active challenges requested");

    _fetchActiveUserChallenges();
  }

  Future<void> _fetchActiveUserChallenges() async {
    try {
      var challenges = await HttpService.getActiveUserChallengess();
      activeChallenges = challenges;

      activeChallengeStatus = DataStatus.LOADED;

      notifyListeners();
    } on Exception catch (e) {
      print(e);
    }
  }

  Future<void> hardSelectedGroupsRequest(String uuid) async {
    print("Hard selected group requested");

    await _fetchSelectedGroup(uuid);
    await _fetchGroupFeed(uuid);
    await _fetchGroupChallenges(uuid);
  }

  Future<void> _fetchSelectedGroup(String uuid) async {
    try {
      Group group = await HttpService.getGroupByUuid(uuid);
      selectedGroup = group;

      selectedGroupStatus = DataStatus.LOADED;

      notifyListeners();
    } on Exception catch (e) {
      selectedGroupStatus = DataStatus.FAILED;
      print(e);
    }
  }

  void softGroupFeedRequest() {
    print("Soft group feed request");

    if (selectedGroup != null && groupFeed.isEmpty) {
      _fetchGroupFeed(selectedGroup!.uuid);
    }
  }

  void hardGroupFeedRequest() {
    print("Hard group feed request");

    _fetchGroupFeed(selectedGroup!.uuid);
  }

  Future<void> _fetchGroupFeed(String uuid) async {
    try {
      List<Post> feed = await HttpService.getGroupFeed(uuid);
      groupFeed = feed;

      groupFeedStatus = DataStatus.LOADED;

      print('Group posts are fetched');

      notifyListeners();
    } on Exception catch (e) {
      print(e);
    }
  }

  void softGroupChallengesRequest() {
    print("Soft group challenges request");
    if (selectedGroup != null && groupChallenges.isEmpty) {
      _fetchGroupChallenges(selectedGroup!.uuid);
    }
  }

  void hardGroupChallengesRequest() {
    print("Hard group challenges request");
    _fetchGroupChallenges(selectedGroup!.uuid);
  }

  Future<void> _fetchGroupChallenges(String uuid) async {
    try {
      List<Challenge> chalenges = await HttpService.getGroupChallenges(uuid);
      groupChallenges = chalenges;

      groupChallengesStatus = DataStatus.LOADED;

      notifyListeners();
    } on Exception catch (e) {
      print(e);
    }
  }

  void hardSelectedChallengeRequest(String uuid) async {
    print("Hard selected challenge request");

    await _fetchSelectedChallenge(uuid);
    await _fetchChallengeFeedRequest(uuid);
  }

  Future<void> _fetchSelectedChallenge(String uuid) async {
    try {
      Challenge chalenge = await HttpService.getChallengeByUuid(uuid);
      selectedChallenge = chalenge;

      selectedChallengeStatus = DataStatus.LOADED;
      challengeFeedStatus = DataStatus.NULL;

      notifyListeners();
    } on Exception catch (e) {
      print(e);
    }
  }

  void softChallengeFeedRequest(String uuid) {
    print('Soft fetch challenge feed: ' + uuid);
    if (challengeFeedStatus == DataStatus.NULL) {
      _fetchChallengeFeedRequest(uuid);
    }
  }

  void hardChallengeFeedRequest(String uuid) {
    print('Hard fetch challenge feed: ' + uuid);
    _fetchChallengeFeedRequest(uuid);
  }

  Future<void> _fetchChallengeFeedRequest(String uuid) async {
    try {
      List<Post> feed = await HttpService.getChallengeFeed(uuid);
      challengeFeed = feed;

      challengeFeedStatus = DataStatus.LOADED;

      print('Fetched challenge feed received');
      print(feed.length);

      notifyListeners();
    } on Exception catch (e) {
      print(e);
    }
  }

  List<Challenge> getActiveChallenges() {
    return activeChallenges;
  }

  List<Group> getUserGroups() {
    return userGroups;
  }

  List<Challenge> getGroupChallenges() {
    return groupChallenges;
  }

  Group? getSelectedGroup() {
    return selectedGroup;
  }

  Challenge? getSelectedChallenge() {
    return selectedChallenge;
  }

  List<Post> getGroupFeed() {
    return groupFeed;
  }
}
