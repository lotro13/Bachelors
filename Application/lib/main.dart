import 'package:application/providers/feed_provider.dart';
import 'package:application/providers/groups_provider.dart';
import 'package:application/screens/challenge/challenge_creation_page.dart';
import 'package:application/screens/comments/comments_page.dart';
import 'package:application/screens/feed/post_creation_page.dart';
import 'package:application/screens/groups/group_creation_page.dart';
import 'package:application/screens/login/login.dart';
import 'package:application/screens/menu/menu.dart';
import 'package:flutter/material.dart';
import 'package:provider/provider.dart';
import 'providers/navigation_provider.dart';
import 'screens/challenge/find_challenge_page.dart';
import 'screens/groups/find_group_page.dart';

void main() => runApp(MultiProvider(
      providers: [
        ListenableProvider<NavigationProvider>(
          create: (_) => NavigationProvider(),
        ),
        ListenableProvider<FeedProvider>(
          create: (_) => FeedProvider(),
        ),
        ListenableProvider<GroupsProvider>(
          create: (_) => GroupsProvider(),
        ),
      ],
      child: const MyApp(),
    ));

class MyApp extends StatelessWidget {
  const MyApp({Key? key}) : super(key: key);

  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      home: LoginPage(),
      routes: <String, WidgetBuilder>{
        '/login': (BuildContext context) => LoginPage(),
        '/main': (BuildContext context) => const MainPage(),
        '/comments': (BuildContext context) => CommentsPage(),
        '/create/group': (BuildContext context) => const GroupCreationPage(),
        '/create/challenge': (BuildContext context) =>
            const ChallengeCreationPage(),
        '/browse/group': (BuildContext context) => FindGroupPage(),
        '/browse/challenge': (BuildContext context) => FindChallengesPage(),
        '/create/post': (BuildContext context) => const PostCreationPage(),
      },
    );
  }
}

class MainPage extends StatelessWidget {
  const MainPage({Key? key}) : super(key: key);

  @override
  Widget build(BuildContext context) {
    FeedProvider feed = Provider.of<FeedProvider>(context);
    feed.softRequestMainFeed();

    return const MenuPage();
  }
}
