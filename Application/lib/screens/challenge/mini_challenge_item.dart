import 'package:application/domain/challenge.dart';
import 'package:flutter/material.dart';
import 'package:provider/provider.dart';

import '../../providers/groups_provider.dart';
import '../../providers/navigation_provider.dart';

class MiniChallengeItem extends StatelessWidget {
  const MiniChallengeItem({Key? key, required this.challenge})
      : super(key: key);

  final Challenge challenge;

  @override
  Widget build(BuildContext context) {
    NavigationProvider navigation =
        Provider.of<NavigationProvider>(context, listen: false);
    GroupsProvider groups = Provider.of<GroupsProvider>(context);

    return Padding(
      padding: const EdgeInsets.all(8.0),
      child: ClipRRect(
        borderRadius: BorderRadius.circular(16.0),
        child: GestureDetector(
          child: Container(
            width: 90,
            height: 90,
            color: const Color(0xffBFA5F7),
            child: Center(
              child: Text(challenge.name),
            ),
          ),
          onTap: () => {
            groups.hardSelectedChallengeRequest(challenge.uuid),
            navigation.changeGroupScreen('/challenge'),
          },
        ),
      ),
    );
  }
}
