import 'package:flutter/material.dart';

import '../../domain/challenge.dart';
import 'mini_challenge_item.dart';

class ChallengesHeadder extends StatelessWidget {
  const ChallengesHeadder({Key? key, required this.challenges})
      : super(key: key);

  final List<Challenge> challenges;

  @override
  Widget build(BuildContext context) {
    List<Widget> items =
        challenges.map((c) => MiniChallengeItem(challenge: c)).toList();

    return SizedBox(
      height: 90,
      child: Row(
        children: [
          Expanded(
            child: ListView(
              scrollDirection: Axis.horizontal,
              children: items,
            ),
          ),
        ],
      ),
    );
  }
}
