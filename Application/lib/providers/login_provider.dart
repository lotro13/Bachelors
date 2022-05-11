import 'package:application/domain/user.dart';
import 'package:flutter/material.dart';
import 'package:shared_preferences/shared_preferences.dart';

import '../services/http_service.dart';

class LoginProvider extends ChangeNotifier {
  bool tokenRequested = false;
  String mainButton = "Request validation token";
  String? errorMessage;

  String? email;
  String? me;

  String getEmail() {
    if (email != null) email!;

    return "";
  }

  String getMe() {
    if (me != null) me!;

    return "";
  }

  Future<void> requestNewToken(String email) async {
    bool tokenRequested = await HttpService.requestToken(email);

    this.email = email;

    if (!tokenRequested) {
      setErrorMessage("Token request failed");
    } else {
      setTokenRequested();
    }
  }

  bool isLoggedIn() {
    return me != null;
  }

  // Future<void> checkIfLoggedIn() async {
  //   SharedPreferences sharedPreferences = await SharedPreferences.getInstance();
  //   // String? loggedInUser = await HttpService.getCurrentUserUuid();

  //   if (loggedInUser != null) {
  //     sharedPreferences.setString("me", loggedInUser);
  //     me = loggedInUser;
  //   } else {
  //     me = null;
  //   }

  //   notifyListeners();
  // }

  bool isTokenRequested() {
    return tokenRequested;
  }

  String getMainButtonText() {
    return mainButton;
  }

  void setMainButton(String buttonText) {
    mainButton = buttonText;
    notifyListeners();
  }

  bool isLoading() {
    return false;
  }

  String? getErrorMessage() {
    return errorMessage;
  }

  void setErrorMessage(String errorMessage) {
    this.errorMessage = errorMessage;
    notifyListeners();
  }

  void setTokenRequested() {
    mainButton = "Validate token";
    tokenRequested = true;
    notifyListeners();
  }
}
