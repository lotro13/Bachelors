import 'package:application/domain/comment.dart';
import 'package:application/screens/comments/comment_item.dart';
import 'package:flutter/material.dart';
import 'package:provider/provider.dart';

import '../../domain/post.dart';
import '../../providers/feed_provider.dart';

class CommentsPage extends StatelessWidget {
  CommentsPage({Key? key}) : super(key: key);

  final TextEditingController commentController = TextEditingController();

  @override
  Widget build(BuildContext context) {
    FeedProvider feed = Provider.of<FeedProvider>(context);

    Post? post = feed.selectedPost;

    if (post == null) {
      return const Center(
        child: CircularProgressIndicator(),
      );
    }

    feed.softPostCommentsRequest(post.uuid);

    return Container(
      decoration: const BoxDecoration(
        gradient: LinearGradient(
            begin: Alignment.topRight,
            end: Alignment.bottomRight,
            colors: [Colors.white, Color(0xff95b2cd)]),
      ),
      child: Scaffold(
        backgroundColor: Colors.transparent,
        body: Column(
          children: [
            Expanded(
              child: NestedScrollView(
                headerSliverBuilder:
                    (BuildContext context, bool innerBoxIsScrolled) {
                  return <Widget>[
                    SliverAppBar(
                      backgroundColor: Colors.transparent,
                      expandedHeight: 350.0,
                      pinned: true,
                      floating: true,
                      flexibleSpace: FlexibleSpaceBar(
                        background: Image(
                          image: NetworkImage(post.bodyURL),
                          fit: BoxFit.fitHeight,
                        ),
                      ),
                    ),
                  ];
                },
                body: SingleChildScrollView(
                  child: Center(
                    child: Column(
                      children: feed.postComments
                          .map((c) => CommentItem(comment: c))
                          .toList(),
                    ),
                  ),
                ),
              ),
            ),
            ConstrainedBox(
              constraints: BoxConstraints(
                minWidth: MediaQuery.of(context).size.width,
                minHeight: 40,
              ),
              child: Container(
                color: Colors.white,
                child: Padding(
                  padding: const EdgeInsets.all(8.0),
                  child: Row(
                    children: [
                      Expanded(
                        child: TextFormField(
                          controller: commentController,
                        ),
                      ),
                      const SizedBox(width: 12),
                      GestureDetector(
                        child: const Center(child: Icon(Icons.send)),
                        onTap: () async => {
                          await feed.createNewComment(
                              commentController.text, post.uuid),
                          feed.softPostCommentsRequest(post.uuid),
                          commentController.clear()
                        },
                      ),
                    ],
                  ),
                ),
              ),
            ),
          ],
        ),
      ),
    );
  }
}
