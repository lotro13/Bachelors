import 'package:application/domain/post.dart';
import 'package:application/screens/feed/post_fragment.dart';
import 'package:flutter/material.dart';

class FeedFragment extends StatelessWidget {
  const FeedFragment({Key? key, required this.posts}) : super(key: key);

  final List<Post> posts;

  @override
  Widget build(BuildContext context) {
    if (posts.isNotEmpty) {
      return ListView(
          children: posts.map((p) => PostFragment(post: p)).toList());
    } else {
      return const Center(
        child: CircularProgressIndicator(),
      );
    }
  }
}
