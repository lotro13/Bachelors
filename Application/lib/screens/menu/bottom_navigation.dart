import 'package:application/providers/navigation_provider.dart';
import 'package:flutter/material.dart';
import 'package:provider/provider.dart';

import '../../providers/groups_provider.dart';

class BottomNav extends StatelessWidget {
  const BottomNav({Key? key}) : super(key: key);

  @override
  Widget build(BuildContext context) {
    NavigationProvider navigation = Provider.of<NavigationProvider>(context);
    GroupsProvider groups = Provider.of<GroupsProvider>(context);

    return BottomNavigationBar(
      currentIndex: navigation.getBottomNavigationIndex(),
      type: BottomNavigationBarType.fixed,
      onTap: (buttonIndex) {
        switch (buttonIndex) {
          case 0:
            groups.initGrouList();
            navigation.changeScreen('/groups');
            break;
          case 1:
            navigation.changeScreen('/feed');
            break;
          case 2:
            navigation.changeScreen('/notifications');
            break;
        }
      },
      selectedItemColor: Colors.blueAccent,
      unselectedItemColor: Colors.blueGrey,
      selectedFontSize: 16,
      unselectedFontSize: 13,
      backgroundColor: Colors.transparent,
      elevation: 0,
      iconSize: 30,
      items: const [
        BottomNavigationBarItem(
          label: "Groups",
          icon: Icon(Icons.group),
        ),
        BottomNavigationBarItem(
          label: "Feed",
          icon: Icon(Icons.list),
        ),
        BottomNavigationBarItem(
          label: "Notifications",
          icon: Icon(Icons.notifications),
        ),
      ],
    );
  }
}
