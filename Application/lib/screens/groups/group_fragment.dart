import 'package:application/services/http_service.dart';
import 'package:flutter/material.dart';
import 'package:provider/provider.dart';
import '../../domain/group.dart';
import '../../providers/groups_provider.dart';
import '../challenge/challenges_list.dart';
import '../feed/feed_fragment.dart';
import '../scoreboard.dart';

class GroupFragment extends StatelessWidget {
  const GroupFragment({Key? key}) : super(key: key);

  @override
  Widget build(BuildContext context) {
    GroupsProvider groups = Provider.of<GroupsProvider>(context);

    Group? group = groups.getSelectedGroup();

    if (group == null) {
      return const Center(
        child: CircularProgressIndicator(),
      );
    }

    return DefaultTabController(
      length: 3,
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
                  text: "Challenges",
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
            Center(
              child: Column(
                children: [
                  Expanded(
                    child: RefreshIndicator(
                      onRefresh: () async => groups.hardGroupFeedRequest(),
                      child: FeedFragment(posts: groups.getGroupFeed()),
                    ),
                  ),
                ],
              ),
            ),
            Scaffold(
              backgroundColor: Colors.transparent,
              body: Center(
                child: RefreshIndicator(
                  onRefresh: () async => groups.hardGroupChallengesRequest(),
                  child:
                      ChallengesList(challenges: groups.getGroupChallenges()),
                ),
              ),
              floatingActionButton: Row(
                children: [
                  group.canCreateChallenge
                      ? Align(
                          alignment: Alignment.bottomLeft,
                          child: Padding(
                            padding: const EdgeInsets.only(left: 26),
                            child: FloatingActionButton(
                              heroTag: "groupCreateButton",
                              onPressed: () => {
                                Navigator.pushNamed(
                                    context, '/create/challenge'),
                              },
                              tooltip: 'Create group',
                              child: const Icon(Icons.add),
                            ),
                          ),
                        )
                      : Container(),
                  Expanded(child: Container()),
                  Align(
                    alignment: Alignment.bottomRight,
                    child: FloatingActionButton(
                      heroTag: "groupSearchButton",
                      onPressed: () => {
                        Navigator.pushNamed(context, '/browse/challenge'),
                      },
                      tooltip: 'Find group',
                      child: const Icon(Icons.search),
                    ),
                  ),
                ],
              ),
            ),
            Column(
              children: [
                SizedBox(
                  height: 300,
                  child: ScoreBoard(results: group.scoredoard),
                ),
                if (group.pendingRequests.isNotEmpty)
                  Expanded(
                    child: ListView(
                      children: group.pendingRequests
                          .map(
                            (e) => SizedBox(
                              height: 30,
                              child: Flex(
                                direction: Axis.horizontal,
                                children: [
                                  const Icon(Icons.person),
                                  Text(e.username),
                                  Expanded(child: Container()),
                                  GestureDetector(
                                    child: const Icon(Icons.add_box_outlined),
                                    onTap: () async => {
                                      await HttpService.aprooveJoinRequest(
                                          group.uuid, e.uuid),
                                      await groups.hardSelectedGroupsRequest(
                                          group.uuid),
                                    },
                                  ),
                                  const SizedBox(width: 14),
                                  GestureDetector(
                                    child: const Icon(Icons.close_outlined),
                                    onTap: () async => {
                                      await HttpService.denyJoinRequest(
                                          group.uuid, e.uuid),
                                      await groups.hardSelectedGroupsRequest(
                                          group.uuid),
                                    },
                                  ),
                                ],
                              ),
                            ),
                          )
                          .toList(),
                    ),
                  ),
              ],
            ),
          ],
        ),
      ),
    );
  }
}
