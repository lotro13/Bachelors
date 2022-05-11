import 'dart:convert';
import 'package:application/domain/challenge_status.dart';
import 'package:application/domain/user.dart';

import 'access_type.dart';
import 'challenge_type.dart';

class Challenge {
  String uuid;
  String founder;
  String group;
  String name;
  String description;
  ChallengeType type;
  DateTime deadline;
  AccessType accessType;
  ChallengeStatus status;
  bool canManageStatus;
  bool canCreatePost;
  bool canCreateRatedPost;
  bool isParticipant;
  Map<String, int> scoreboard;

  Challenge(
    this.uuid,
    this.founder,
    this.group,
    this.name,
    this.description,
    this.type,
    this.deadline,
    this.accessType,
    this.status,
    this.canManageStatus,
    this.canCreatePost,
    this.canCreateRatedPost,
    this.isParticipant,
    this.scoreboard,
  );

  factory Challenge.fromJson(dynamic json) {
    return Challenge(
      json['uuid'] as String,
      "",
      "",
      json['name'] as String,
      json['description'] as String,
      ChallengeType.values.byName(json['type'] as String),
      DateTime.parse(json['deadline'] as String),
      AccessType.PUBLIC,
      ChallengeStatus.values.byName(json['status']),
      json['canManageStatus'] as bool,
      json['canCreatePost'] as bool,
      json['canCreateRatedPost'] as bool,
      json['isParticipant'] as bool,
      Map.castFrom(json['scoreboard']),
    );
  }

  @override
  String toString() {
    return jsonEncode({
      "founder": founder,
      "group": group,
      "name": name,
      "description": description,
      "type": type.name,
      "deadline": deadline.toIso8601String(),
      "accessType": accessType.name,
    });
  }
}
