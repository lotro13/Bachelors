import 'package:application/domain/comment.dart';
import 'package:flutter/material.dart';

class CommentItem extends StatelessWidget {
  const CommentItem({Key? key, required this.comment}) : super(key: key);

  final Comment comment;

  @override
  Widget build(BuildContext context) {
    return Padding(
      padding:
          const EdgeInsets.only(top: 4.0, bottom: 4.0, left: 8.0, right: 8.0),
      child: ClipRRect(
        borderRadius: const BorderRadius.all(Radius.circular(12.0)),
        child: Container(
          color: Colors.white,
          child: Align(
            alignment: Alignment.centerLeft,
            child: Padding(
              padding: const EdgeInsets.all(14.0),
              child: Column(
                crossAxisAlignment: CrossAxisAlignment.start,
                children: [
                  Text(
                    comment.author,
                    style: const TextStyle(
                        fontSize: 13, fontWeight: FontWeight.w600),
                  ),
                  const SizedBox(height: 8),
                  Text(
                    comment.body,
                    style: const TextStyle(fontSize: 16),
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
