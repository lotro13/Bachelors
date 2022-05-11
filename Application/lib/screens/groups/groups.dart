import 'package:application/providers/navigation_provider.dart';
import 'package:application/screens/challenge/challenge_fragment.dart';
import 'package:application/screens/groups/group_fragment.dart';
import 'package:application/screens/groups/groups_list.dart';
import 'package:flutter/material.dart';
import 'package:provider/provider.dart';

class GroupsFragment extends StatelessWidget {
  const GroupsFragment({Key? key}) : super(key: key);

  @override
  Widget build(BuildContext context) {
    NavigationProvider navigation = Provider.of<NavigationProvider>(context);

    var fragments = [
      const GroupsList(),
      const GroupFragment(),
      const ChallengeFragment()
    ];

    return WillPopScope(
      onWillPop: () async {
        navigation.popGroupScreen();
        return false;
      },
      child: fragments[navigation.getGroupsNavigationIndex()],
    );
  }
}
