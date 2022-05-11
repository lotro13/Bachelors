import 'package:flutter/material.dart';

import '../../services/http_service.dart';

class LoginPage extends StatefulWidget {
  LoginPage({Key? key}) : super(key: key);

  final TextEditingController emailController = TextEditingController();
  final TextEditingController tokenController = TextEditingController();

  @override
  State<LoginPage> createState() => _LoginPagePageState();
}

class _LoginPagePageState extends State<LoginPage> {
  bool tokenRequested = false;
  String? errorMessage;
  String mainButton = "Request validation token";

  @override
  Widget build(BuildContext context) {
    final _screen = MediaQuery.of(context).size;
    return Scaffold(
      body: SingleChildScrollView(
        physics: const ClampingScrollPhysics(),
        child: ConstrainedBox(
          constraints: BoxConstraints(
            minWidth: MediaQuery.of(context).size.width,
            minHeight: MediaQuery.of(context).size.height,
          ),
          child: IntrinsicHeight(
            child: Container(
              decoration: const BoxDecoration(
                gradient: LinearGradient(
                    begin: Alignment.topLeft,
                    end: Alignment.bottomRight,
                    colors: [Colors.white, Color(0xff95b2cd)]),
              ),
              child: Padding(
                padding: const EdgeInsets.all(32.0),
                child: Column(
                  mainAxisSize: MainAxisSize.max,
                  children: [
                    const SizedBox(
                      width: 250,
                      height: 250,
                      child: Image(
                        image: AssetImage('assets/logo.png'),
                      ),
                    ),
                    const SizedBox(height: 50.0),
                    Flexible(
                      child: false
                          ? const Center(child: CircularProgressIndicator())
                          : Column(
                              crossAxisAlignment: CrossAxisAlignment.stretch,
                              children: <Widget>[
                                TextFormField(
                                  controller: widget.emailController,
                                  decoration:
                                      const InputDecoration(hintText: "E-mail"),
                                  validator: (String? value) {
                                    return (value != null &&
                                            !value.contains('@'))
                                        ? 'Please enter valid e-mail.'
                                        : null;
                                  },
                                  readOnly: tokenRequested,
                                ),
                                const SizedBox(height: 20.0),
                                if (tokenRequested)
                                  TextFormField(
                                    controller: widget.tokenController,
                                    obscureText: true,
                                    decoration: const InputDecoration(
                                      hintText: "Token",
                                    ),
                                  )
                                else
                                  const SizedBox(height: 40.0),
                                const SizedBox(height: 30.0),
                                SizedBox(
                                  width: _screen.width * 0.8,
                                  height: 50.0,
                                  child: OutlinedButton(
                                    style: OutlinedButton.styleFrom(
                                      shadowColor: Colors.black,
                                      primary: Colors.white,
                                      backgroundColor: const Color.fromARGB(
                                          255, 101, 99, 214),
                                      elevation: 5,
                                      shape: const RoundedRectangleBorder(
                                          borderRadius: BorderRadius.all(
                                              Radius.circular(12))),
                                    ),
                                    onPressed: () {
                                      if (tokenRequested) {
                                        _validateEnteredToken(context);
                                      } else {
                                        _requestNewToken();
                                      }
                                    },
                                    child: Text(
                                      mainButton,
                                      style: const TextStyle(
                                        color: Color(0xffd8dfe9),
                                        fontSize: 18,
                                      ),
                                    ),
                                  ),
                                ),
                                Container(height: 15),
                                if (errorMessage == null)
                                  Container()
                                else
                                  Center(
                                    child: Text(
                                      errorMessage!,
                                      style: const TextStyle(
                                        color: Colors.redAccent,
                                        fontWeight: FontWeight.bold,
                                      ),
                                    ),
                                  ),
                                Row(
                                  mainAxisAlignment: MainAxisAlignment.center,
                                  children: const [
                                    Icon(
                                      Icons.facebook,
                                      color: Colors.blue,
                                      size: 36.0,
                                    ),
                                    SizedBox(width: 36),
                                    SizedBox(
                                      height: 36,
                                      width: 36,
                                      child: Image(
                                        image: AssetImage('assets/gmail.png'),
                                      ),
                                    ),
                                  ],
                                ),
                              ],
                            ),
                    ),
                  ],
                ),
              ),
            ),
          ),
        ),
      ),
    );
  }

  _requestNewToken() async {
    bool tokenRequested =
        await HttpService.requestToken(widget.emailController.text);

    setState(() {
      if (!tokenRequested) {
        errorMessage = "Token request failed";
      } else {
        mainButton = "Validate token";
        this.tokenRequested = true;
      }
    });
  }

  _validateEnteredToken(BuildContext context) async {
    String? loggedInUser = await HttpService.login(
      widget.emailController.text,
      widget.tokenController.text,
    );

    if (loggedInUser != null) {
      Navigator.pushReplacementNamed(context, '/main');
    } else {
      setState(() {
        errorMessage = "Token validation failed";
      });
    }
  }
}
