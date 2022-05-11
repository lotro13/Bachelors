import 'package:application/screens/groups/group_item.dart';
import 'package:flutter/material.dart';
import 'package:provider/provider.dart';

import '../../providers/groups_provider.dart';

class FindGroupPage extends StatelessWidget {
  FindGroupPage({Key? key}) : super(key: key);

  final TextEditingController searchController = TextEditingController();

  @override
  Widget build(BuildContext context) {
    GroupsProvider groups = Provider.of<GroupsProvider>(context);

    return Scaffold(
      body: LimitedBox(
        child: Container(
          decoration: const BoxDecoration(
            gradient: LinearGradient(
                begin: Alignment.topLeft,
                end: Alignment.bottomRight,
                colors: [Colors.white, Color(0xff95b2cd)]),
          ),
          child: Column(
            children: [
              Expanded(
                child: SingleChildScrollView(
                  child: Center(
                    child: Column(
                      children: groups.browsingGroups
                          .map((c) => GroupItem(group: c))
                          .toList(),
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
                            controller: searchController,
                          ),
                        ),
                        const SizedBox(width: 12),
                        GestureDetector(
                          child: const Center(child: Icon(Icons.search)),
                          onTap: () async => {
                            await groups.fetchGroupBrowsingResult(
                                searchController.text),
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
      ),
    );
  }
}
