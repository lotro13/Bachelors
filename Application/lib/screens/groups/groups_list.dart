import 'package:application/domain/data_status.dart';
import 'package:application/screens/challenge/challenges_headder.dart';
import 'package:application/screens/groups/group_item.dart';
import 'package:flutter/material.dart';
import 'package:provider/provider.dart';

import '../../providers/groups_provider.dart';

class GroupsList extends StatelessWidget {
  const GroupsList({Key? key}) : super(key: key);

  @override
  Widget build(BuildContext context) {
    GroupsProvider groups = Provider.of<GroupsProvider>(context);

    return Scaffold(
      backgroundColor: Colors.transparent,
      body: Column(
        children: [
          ChallengesHeadder(
            challenges: groups.getActiveChallenges(),
          ),
          if (groups.getUserGroups().isNotEmpty)
            Expanded(
              child: RefreshIndicator(
                onRefresh: () async => groups.hardUserGroupsRequest(),
                child: ListView(
                  children: groups
                      .getUserGroups()
                      .map((g) => GroupItem(group: g))
                      .toList(),
                ),
              ),
            ),
          if (groups.getUserGroups().isEmpty)
            if (groups.userGroupsStatus == DataStatus.LOADED)
              const Center(
                child: Text("Nothing here"),
              ),
          if (groups.userGroupsStatus == DataStatus.FAILED)
            const Center(
              child: Text("Group list fetching failed"),
            ),
        ],
      ),
      floatingActionButton: Row(
        children: [
          Align(
            alignment: Alignment.bottomLeft,
            child: Padding(
              padding: const EdgeInsets.only(left: 26),
              child: FloatingActionButton(
                heroTag: "challengeCreateButton",
                onPressed: () => {
                  Navigator.pushNamed(context, '/create/group'),
                },
                tooltip: 'Create group',
                child: const Icon(Icons.add),
              ),
            ),
          ),
          Expanded(child: Container()),
          Align(
            alignment: Alignment.bottomRight,
            child: FloatingActionButton(
              heroTag: "challengeSearchButton",
              onPressed: () => {
                Navigator.pushNamed(context, '/browse/group'),
              },
              tooltip: 'Create group',
              child: const Icon(Icons.search),
            ),
          ),
        ],
      ),
    );
  }
}
