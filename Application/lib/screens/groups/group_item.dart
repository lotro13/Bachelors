import 'package:application/domain/access_type.dart';
import 'package:application/domain/group.dart';
import 'package:application/providers/navigation_provider.dart';
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
                  ],
                ),
              ),
            ),
          ),
          onTap: () => {
            print('Requesting group: ' + group.uuid),
            groups.hardSelectedGroupsRequest(group.uuid),
            navigation.changeGroupScreen('/group'),
          },
        ),
      ),
    );
  }
}
