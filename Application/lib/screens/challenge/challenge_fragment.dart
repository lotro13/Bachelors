import 'package:application/domain/challenge.dart';
import 'package:application/domain/challenge_status.dart';
import 'package:application/screens/scoreboard.dart';
import 'package:application/services/http_service.dart';
import 'package:flutter/material.dart';
import 'package:provider/provider.dart';

import '../../providers/groups_provider.dart';
import '../feed/feed_fragment.dart';

class ChallengeFragment extends StatelessWidget {
  const ChallengeFragment({Key? key}) : super(key: key);

  @override
  Widget build(BuildContext context) {
    GroupsProvider groups = Provider.of<GroupsProvider>(context);

    Challenge? challenge = groups.getSelectedChallenge();

    if (challenge == null) {
      return const Center(
        child: CircularProgressIndicator(),
      );
    }

    return DefaultTabController(
      length: 2,
      child: Scaffold(
        backgroundColor: Colors.transparent,
        appBar: AppBar(
          backgroundColor: Colors.transparent,
          elevation: 0,
          title: Center(
            child: TabBar(
              labelColor: const Color.fromARGB(255, 1, 18, 32),
              isScrollable: true,
              indicator: BoxDecoration(
                  borderRadius: BorderRadius.circular(50),
                  color: const Color(0xffFF468F)),
              tabs: const [
                Tab(
                  text: "Feed",
                ),
                Tab(
                  text: "Scoreboard",
                ),
              ],
            ),
          ),
        ),
        body: TabBarView(
          children: [
            Column(
              children: [
                Text(challenge.name),
                Expanded(
                  child: RefreshIndicator(
                    onRefresh: () async =>
                        groups.hardChallengeFeedRequest(challenge.uuid),
                    child: FeedFragment(posts: groups.challengeFeed),
                  ),
                ),
                Row(
                  mainAxisAlignment: MainAxisAlignment.center,
                  children: [
                    challenge.canManageStatus
                        ? challenge.status == ChallengeStatus.IDLE
                            ? Padding(
                                padding: const EdgeInsets.all(4.0),
                                child: OutlinedButton(
                                  style: OutlinedButton.styleFrom(
                                    shadowColor: Colors.black,
                                    primary: Colors.white,
                                    backgroundColor:
                                        const Color.fromARGB(255, 101, 99, 214),
                                    elevation: 5,
                                    shape: const RoundedRectangleBorder(
                                        borderRadius: BorderRadius.all(
                                            Radius.circular(12))),
                                  ),
                                  child: const Center(
                                    child: Padding(
                                      padding: EdgeInsets.only(
                                          top: 12.0, bottom: 12.0),
                                      child: Text('Start challenge'),
                                    ),
                                  ),
                                  onPressed: () async => {
                                    await HttpService.startChallenge(
                                        challenge.uuid),
                                    groups.hardSelectedChallengeRequest(
                                        challenge.uuid)
                                  },
                                ),
                              )
                            : challenge.status == ChallengeStatus.STARTED
                                ? Padding(
                                    padding: const EdgeInsets.all(4.0),
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
                                      child: const Center(
                                        child: Padding(
                                          padding: EdgeInsets.only(
                                              top: 12.0, bottom: 12.0),
                                          child: Text('Stop challenge'),
                                        ),
                                      ),
                                      onPressed: () async => {
                                        await HttpService.stopChallenge(
                                            challenge.uuid),
                                        groups.hardSelectedChallengeRequest(
                                            challenge.uuid)
                                      },
                                    ),
                                  )
                                : Container()
                        : Container(),
                    challenge.canCreatePost
                        ? Padding(
                            padding: const EdgeInsets.all(4.0),
                            child: OutlinedButton(
                              style: OutlinedButton.styleFrom(
                                shadowColor: Colors.black,
                                primary: Colors.white,
                                backgroundColor:
                                    const Color.fromARGB(255, 101, 99, 214),
                                elevation: 5,
                                shape: const RoundedRectangleBorder(
                                    borderRadius:
                                        BorderRadius.all(Radius.circular(12))),
                              ),
                              child: const Center(
                                child: Padding(
                                  padding:
                                      EdgeInsets.only(top: 12.0, bottom: 12.0),
                                  child: Text('Create new post'),
                                ),
                              ),
                              onPressed: () => {
                                groups
                                    .setPostCreationTargetUuid(challenge.uuid),
                                Navigator.pushNamed(context, '/create/post'),
                              },
                            ),
                          )
                        : Container(),
                  ],
                ),
              ],
            ),
            ScoreBoard(results: challenge.scoreboard),
          ],
        ),
      ),
    );
  }
}
