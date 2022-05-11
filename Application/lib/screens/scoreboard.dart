import 'package:flutter/material.dart';

class ScoreBoard extends StatelessWidget {
  const ScoreBoard({Key? key, required this.results}) : super(key: key);

  final Map<String, int> results;

  @override
  Widget build(BuildContext context) {
    return LimitedBox(
      child: Padding(
        padding: const EdgeInsets.all(16.0),
        child: ListView(
          children: results.entries
              .toList()
              .map(
                (e) => SizedBox(
                  height: 30,
                  child: Flex(
                    direction: Axis.horizontal,
                    children: [
                      const Icon(Icons.person),
                      Text(e.key),
                      Expanded(child: Container()),
                      Text('${e.value}'),
                    ],
                  ),
                ),
              )
              .toList(),
        ),
      ),
    );
  }
}
