import 'package:application/domain/access_type.dart';
import 'package:application/domain/group.dart';
import 'package:application/providers/navigation_provider.dart';
import 'package:application/services/http_service.dart';
import 'package:flutter/material.dart';
import 'package:provider/provider.dart';

import '../../providers/groups_provider.dart';

class GroupItem extends StatelessWidget {
  const GroupItem({Key? key, required this.group}) : super(key: key);

  final Group group;

  @override
  Widget build(BuildContext context) {
    NavigationProvider navigation =
        Provider.of<NavigationProvider>(context, listen: false);
    GroupsProvider groups = Provider.of<GroupsProvider>(context);

    final _screen = MediaQuery.of(context).size;
    return Padding(
      padding: const EdgeInsets.only(top: 18, left: 12, right: 12),
      child: ClipRRect(
        borderRadius: BorderRadius.circular(8.0),
        child: GestureDetector(
          child: Align(
            alignment: Alignment.centerLeft,
            child: Container(
              color: const Color(0xff7F6AEB),
              alignment: Alignment.centerLeft,
              height: _screen.height * 0.125,
              child: Padding(
                padding: const EdgeInsets.only(
                    left: 36, top: 16, bottom: 16, right: 16),
                child: Row(
                  children: [
                    Icon(
                        group.accessType == AccessType.PRIVATE
                            ? Icons.lock_rounded
                            : Icons.lock_open_rounded,
                        color: Colors.white),
                    const SizedBox(width: 16),
                    Text(
                      group.name,
                      style: const TextStyle(
                        color: Colors.white,
                        fontSize: 22,
                        fontWeight: FontWeight.bold,
                      ),
                    ),
                    Expanded(child: Container()),
                    getActiveButton(groups, group),
                  ],
                ),
              ),
            ),
          ),
          onTap: () => {
            if (group.isMember)
              {
                print('Requesting group: ' + group.uuid),
                groups.hardSelectedGroupsRequest(group.uuid),
                navigation.changeGroupScreen('/group'),
              }
          },
        ),
      ),
    );
  }

  getActiveButton(GroupsProvider groups, Group group) {
    if (group.isMember) {
      return GestureDetector(
        child: const SizedBox(
          width: 36,
          height: 36,
          child: Icon(
            Icons.close,
            color: Colors.white,
          ),
        ),
        onTap: () async => {
          await HttpService.leaveGroup(group.uuid),
          groups.hardUserGroupsRequest()
        },
      );
    }

    if (group.isRequestPending) {
      return const SizedBox(
        width: 36,
        height: 36,
        child: Icon(
          Icons.lock_clock,
          color: Colors.white,
        ),
      );
    }

    if (!group.isMember && !group.isRequestPending) {
      return GestureDetector(
        child: const SizedBox(
          width: 36,
          height: 36,
          child: Icon(
            Icons.add,
            color: Colors.white,
          ),
        ),
        onTap: () async => {
          await HttpService.tryToJoinGroup(group.uuid),
          groups.hardUserGroupsRequest(),
          groups.fetchGroupBrowsingResult(""),
        },
      );
    }

    return Container();
  }
}
