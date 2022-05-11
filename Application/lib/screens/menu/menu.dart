import 'package:application/providers/feed_provider.dart';
import 'package:application/providers/navigation_provider.dart';
import 'package:application/screens/feed/feed_fragment.dart';
import 'package:application/screens/groups/groups.dart';
import 'package:application/screens/menu/bottom_navigation.dart';
import 'package:application/screens/notifications/notifications.dart';
import 'package:flutter/material.dart';
import 'package:provider/provider.dart';

class MenuPage extends StatelessWidget {
  const MenuPage({Key? key}) : super(key: key);

  @override
  Widget build(BuildContext context) {
    NavigationProvider navigation = Provider.of<NavigationProvider>(context);
    FeedProvider feed = Provider.of<FeedProvider>(context);

    feed.softRequestMainFeed();

    var fragments = [
      const GroupsFragment(),
      RefreshIndicator(
        onRefresh: () async => feed.forceRequestMainFeed(),
        child: FeedFragment(posts: feed.getMainFeed()),
      ),
      const NotificationsFragment(),
    ];

    return Container(
      decoration: const BoxDecoration(
        gradient: LinearGradient(
            begin: Alignment.topLeft,
            end: Alignment.bottomRight,
            colors: [Colors.white, Color(0xff95b2cd)]),
      ),
      child: Scaffold(
        appBar: AppBar(
          backgroundColor: Colors.transparent,
          elevation: 0,
          title: Row(
            children: const [
              Icon(
                Icons.person_rounded,
                color: Colors.blue,
                size: 36.0,
              ),
              Text(
                'Username',
                style: TextStyle(
                  color: Color.fromARGB(255, 0, 44, 80),
                  fontSize: 22,
                  fontWeight: FontWeight.bold,
                ),
              ),
            ],
          ),
        ),
        backgroundColor: Colors.transparent,
        body: fragments[navigation.getBottomNavigationIndex()],
        bottomNavigationBar: const BottomNav(),
      ),
    );
  }
}
