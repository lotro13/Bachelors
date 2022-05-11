import 'package:flutter/material.dart';

class NotificationsFragment extends StatelessWidget {
  const NotificationsFragment({Key? key}) : super(key: key);

  @override
  Widget build(BuildContext context) {
    List<String> notifications = [
      "Challenge started",
      "You have requested to join group",
      "You have 2 pending join requests",
      "Challenge ended"
    ];

    return Center(
      child: Column(
        children: notifications
            .map((e) => Padding(
                  padding: const EdgeInsets.all(8.0),
                  child: ClipRRect(
                    borderRadius: const BorderRadius.all(Radius.circular(12)),
                    child: Container(
                        color: Colors.grey,
                        child: SizedBox(
                          width: 400,
                          height: 60,
                          child: Padding(
                            padding: const EdgeInsets.all(14.0),
                            child: Text(
                              e,
                              style: const TextStyle(fontSize: 18),
                            ),
                          ),
                        )),
                  ),
                ))
            .toList(),
      ),
    );
  }
}
