import 'package:application/domain/challenge.dart';
import 'package:application/screens/challenge/challenge_item.dart';
import 'package:flutter/material.dart';

class ChallengesList extends StatelessWidget {
  const ChallengesList({Key? key, required this.challenges}) : super(key: key);

  final List<Challenge> challenges;

  @override
  Widget build(BuildContext context) {
    return Scaffold(
        backgroundColor: Colors.transparent,
        body: challenges.isEmpty
            ? const Center(child: CircularProgressIndicator())
            : ListView(
                children:
                    challenges.map((c) => ChallengeItem(challenge: c)).toList(),
              ));
  }
}
