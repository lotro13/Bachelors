import 'dart:convert';
import 'dart:math';

import 'package:application/domain/user.dart';

import 'access_type.dart';

class Group {
  String uuid;
  String founder;
  String name;
  AccessType accessType;
  bool canCreateChallenge;
  bool canManageUsers;
  bool isMember;
  bool isRequestPending;
  List<User> pendingRequests;
  Map<String, int> scoredoard;

  Group(
      this.uuid,
      this.name,
      this.accessType,
      this.founder,
      this.canCreateChallenge,
      this.canManageUsers,
      this.isMember,
      this.isRequestPending,
      this.pendingRequests,
      this.scoredoard);

  factory Group.fromJson(dynamic json) {
    return Group(
      json['uuid'] as String,
      json['name'] as String,
      AccessType.values.byName(json['accessType'] as String),
      "",
      json['canCreateChallenge'] as bool,
      json['canManageUsers'] as bool,
      json['isMember'] as bool,
      json['isRequestPending'] as bool,
      (json['pendingRequests'] as List).map((e) => User.fromJson(e)).toList(),
      Map.castFrom(json['scoreboard']),
    );
  }

  @override
  String toString() {
    return jsonEncode({
      "uuid": uuid,
      "name": name,
      "founder": founder,
      "accessType": accessType.name,
    });
  }
}
