import 'package:application/domain/post.dart';
import 'package:flutter/material.dart';
import 'package:provider/provider.dart';

import '../../providers/feed_provider.dart';

class PostFragment extends StatelessWidget {
  const PostFragment({Key? key, required this.post}) : super(key: key);

  final Post post;

  @override
  Widget build(BuildContext context) {
    FeedProvider feed = Provider.of<FeedProvider>(context);

    final _screen = MediaQuery.of(context).size;
    return Padding(
      padding: const EdgeInsets.all(8.0),
      child: ClipRRect(
        borderRadius: const BorderRadius.all(Radius.circular(12.0)),
        child: Container(
          color: Colors.white,
          child: Padding(
            padding: const EdgeInsets.only(
                left: 8.0, right: 8.0, top: 4.0, bottom: 4.0),
            child: SizedBox(
              height: _screen.height * 0.6,
              width: double.infinity,
              child: Column(
                children: [
                  Row(
                    children: [
                      const Icon(Icons.person_rounded),
                      Text(post.author),
                    ],
                  ),
                  SizedBox(
                    height: _screen.height * 0.4,
                    child: Image(
                      image: NetworkImage(post.bodyURL),
                      fit: BoxFit.fitWidth,
                    ),
                  ),
                  Align(
                    alignment: Alignment.centerLeft,
                    child: Text(
                      post.title,
                      style: const TextStyle(fontSize: 27),
                    ),
                  ),
                  Expanded(
                    child: Align(
                      alignment: Alignment.topLeft,
                      child: Text(
                        post.description,
                        overflow: TextOverflow.clip,
                        maxLines: 3,
                        softWrap: true,
                      ),
                    ),
                  ),
                  Align(
                    alignment: Alignment.centerRight,
                    child: TextButton(
                      style: ButtonStyle(
                        foregroundColor:
                            MaterialStateProperty.all<Color>(Colors.blue),
                      ),
                      onPressed: () {
                        feed.forceRequestSelectedPost(post.uuid);
                        Navigator.pushNamed(context, '/comments');
                      },
                      child: Text("All " +
                          post.numberOfComments.toString() +
                          " comments"),
                    ),
                  ),
                ],
              ),
            ),
          ),
        ),
      ),
    );
  }
}
