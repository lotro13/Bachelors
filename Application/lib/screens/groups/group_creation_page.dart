import 'package:application/domain/access_type.dart';
import 'package:flutter/material.dart';
import 'package:provider/provider.dart';

import '../../providers/groups_provider.dart';
import '../../services/http_service.dart';

class GroupCreationPage extends StatefulWidget {
  const GroupCreationPage({Key? key}) : super(key: key);

  @override
  State<GroupCreationPage> createState() => _GroupCreationPageState();
}

class _GroupCreationPageState extends State<GroupCreationPage> {
  final TextEditingController nameController = TextEditingController();
  AccessType accessType = AccessType.PUBLIC;

  @override
  Widget build(BuildContext context) {
    GroupsProvider groups = Provider.of<GroupsProvider>(context);

    return Scaffold(
      body: Container(
        decoration: const BoxDecoration(
          gradient: LinearGradient(
              begin: Alignment.topLeft,
              end: Alignment.bottomRight,
              colors: [Colors.white, Color(0xff95b2cd)]),
        ),
        child: Padding(
          padding: const EdgeInsets.all(25.0),
          child: Column(
            mainAxisAlignment: MainAxisAlignment.center,
            crossAxisAlignment: CrossAxisAlignment.center,
            children: [
              const SizedBox(
                width: 250,
                height: 250,
                child: Image(
                  image: AssetImage('assets/logo.png'),
                ),
              ),
              const Padding(
                padding: EdgeInsets.all(8.0),
                child: Text(
                  'New group creation',
                  style: TextStyle(fontSize: 18),
                ),
              ),
              const SizedBox(height: 50.0),
              TextFormField(
                controller: nameController,
                decoration: const InputDecoration(
                  hintText: "Group name",
                ),
              ),
              DropdownButton<AccessType>(
                value: accessType,
                onChanged: (value) {
                  setState(() {
                    accessType = value!;
                  });
                },
                items: AccessType.values.map(
                  (AccessType classType) {
                    return DropdownMenuItem<AccessType>(
                      value: classType,
                      child: Text(classType.name),
                    );
                  },
                ).toList(),
              ),
              GestureDetector(
                child: ClipRRect(
                  borderRadius: const BorderRadius.all(Radius.circular(60.0)),
                  child: Container(
                    color: Colors.blueAccent,
                    child: const Padding(
                      padding: EdgeInsets.only(
                          left: 22, right: 22, top: 11, bottom: 11),
                      child: Text(
                        'Create group',
                        style: TextStyle(
                            fontSize: 18,
                            fontWeight: FontWeight.w600,
                            color: Colors.white),
                      ),
                    ),
                  ),
                ),
                onTap: () async => {
                  await HttpService.createNewGroup(
                      nameController.text, accessType),
                  groups.hardUserGroupsRequest(),
                  Navigator.pop(context),
                },
              )
            ],
          ),
        ),
      ),
    );
  }
}
