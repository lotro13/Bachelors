import 'package:application/domain/challenge.dart';
import 'package:application/domain/challenge_status.dart';
import 'package:application/providers/navigation_provider.dart';
import 'package:flutter/material.dart';
import 'package:provider/provider.dart';

import '../../providers/groups_provider.dart';
import '../../services/http_service.dart';

class ChallengeItem extends StatelessWidget {
  const ChallengeItem({Key? key, required this.challenge}) : super(key: key);

  final Challenge challenge;

  @override
  Widget build(BuildContext context) {
    NavigationProvider navigation =
        Provider.of<NavigationProvider>(context, listen: false);
    GroupsProvider groups = Provider.of<GroupsProvider>(context);

    final _screen = MediaQuery.of(context).size;
    return Padding(
      padding: const EdgeInsets.all(6.0),
      child: GestureDetector(
        child: Align(
          alignment: Alignment.centerLeft,
          child: ClipRRect(
            borderRadius: BorderRadius.circular(12.0),
            child: Container(
              color: const Color(0xffBFA5F7),
              alignment: Alignment.centerLeft,
              height: _screen.height * 0.16,
              child: Padding(
                padding: const EdgeInsets.only(
                    left: 36, top: 16, bottom: 16, right: 16),
                child: Row(
                  children: [
                    Icon(getStatusIcon(challenge.status), color: Colors.white),
                    const SizedBox(width: 16),
                    Expanded(
                      child: Column(
                        crossAxisAlignment: CrossAxisAlignment.start,
                        children: [
                          Text(
                            challenge.name,
                            style: const TextStyle(
                              fontSize: 22,
                              color: Colors.white,
                              fontWeight: FontWeight.bold,
                            ),
                          ),
                          Expanded(
                            child: Text(
                              challenge.description,
                              maxLines: 3,
                              style: const TextStyle(
                                fontSize: 14,
                                color: Colors.white,
                                overflow: TextOverflow.ellipsis,
                              ),
                            ),
                          ),
                        ],
                      ),
                    ),
                    getActiveButton(groups, challenge),
                  ],
                ),
              ),
            ),
          ),
        ),
        onTap: () => {
          if (challenge.isParticipant)
            {
              groups.hardSelectedChallengeRequest(challenge.uuid),
              navigation.changeGroupScreen('/challenge'),
            }
        },
      ),
    );
  }

  getStatusIcon(ChallengeStatus status) {
    switch (status) {
      case ChallengeStatus.FINISHED:
        return Icons.play_arrow;
      case ChallengeStatus.STARTED:
        return Icons.flag;
      case ChallengeStatus.CLOSED:
        return Icons.stop;
      case ChallengeStatus.IDLE:
        return Icons.timer;
    }
  }

  getActiveButton(GroupsProvider groups, Challenge challenge) {
    if (challenge.isParticipant) {
      return GestureDetector(
        child: const SizedBox(
          width: 36,
          height: 36,
          child: Icon(
            Icons.close,
            color: Colors.white,
          ),
        ),
        onTap: () async => {
          await HttpService.leaveChallenge(challenge.uuid),
          groups.hardGroupChallengesRequest()
        },
      );
    }

    if (!challenge.isParticipant) {
      return GestureDetector(
        child: const SizedBox(
          width: 36,
          height: 36,
          child: Icon(
            Icons.add,
            color: Colors.white,
          ),
        ),
        onTap: () async => {
          await HttpService.joinChallenge(challenge.uuid),
          groups.hardGroupChallengesRequest(),
          groups.fetchChallengesBrowsingResult(""),
        },
      );
    }

    return Container();
  }
}
