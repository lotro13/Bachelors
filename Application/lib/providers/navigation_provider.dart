import 'package:flutter/material.dart';

class NavigationProvider extends ChangeNotifier {
  String screenName = '/feed';
  String groupNavigation = '/';

  void popGroupScreen() {
    switch (groupNavigation) {
      case '/':
        screenName = '/feed';
        break;
      case '/group':
        groupNavigation = '/';
        break;
      case '/challenge':
        groupNavigation = '/group';
        break;
    }
    notifyListeners();
  }

  void changeScreen(String newScreenName) {
    screenName = newScreenName;

    notifyListeners();
  }

  int getBottomNavigationIndex() {
    switch (screenName) {
      case '/groups':
        return 0;
      case '/feed':
        return 1;
      case '/notifications':
        return 2;
    }

    return 0;
  }

  void changeGroupScreen(String newScreenName) {
    groupNavigation = newScreenName;
    notifyListeners();
  }

  int getGroupsNavigationIndex() {
    switch (groupNavigation) {
      case '/':
        return 0;
      case '/group':
        return 1;
      case '/challenge':
        return 2;
    }

    return 0;
  }
}
