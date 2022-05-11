import 'package:application/domain/challenge_type.dart';
import 'package:flutter/material.dart';
import 'package:intl/intl.dart';
import 'package:provider/provider.dart';

import '../../providers/groups_provider.dart';
import '../../services/http_service.dart';

class ChallengeCreationPage extends StatefulWidget {
  const ChallengeCreationPage({Key? key}) : super(key: key);

  @override
  State<ChallengeCreationPage> createState() => _ChallengeCreationPageState();
}

class _ChallengeCreationPageState extends State<ChallengeCreationPage> {
  final TextEditingController nameController = TextEditingController();
  ChallengeType challengeType = ChallengeType.CHALLENGE;

  DateTime selectedDate = DateTime.now();
  bool showDateTime = false;

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
                  'New challenge creation',
                  style: TextStyle(fontSize: 18),
                ),
              ),
              const SizedBox(height: 50.0),
              TextFormField(
                controller: nameController,
                decoration: const InputDecoration(
                  hintText: "Challenge name",
                ),
              ),
              DropdownButton<ChallengeType>(
                value: challengeType,
                onChanged: (value) {
                  setState(() {
                    challengeType = value!;
                  });
                },
                items: ChallengeType.values.map(
                  (ChallengeType classType) {
                    return DropdownMenuItem<ChallengeType>(
                      value: classType,
                      child: Text(classType.name),
                    );
                  },
                ).toList(),
              ),
              Padding(
                padding: const EdgeInsets.all(8.0),
                child: Container(
                  padding: const EdgeInsets.symmetric(horizontal: 15),
                  width: double.infinity,
                  child: ElevatedButton(
                    onPressed: () {
                      _selectDateTime(context);
                      showDateTime = true;
                    },
                    child: const Text('Select deadline'),
                  ),
                ),
              ),
              showDateTime
                  ? Center(child: Text(getDateTime()))
                  : const SizedBox(height: 20),
              const SizedBox(height: 15.0),
              GestureDetector(
                child: ClipRRect(
                  borderRadius: const BorderRadius.all(Radius.circular(60.0)),
                  child: Container(
                    color: Colors.blueAccent,
                    child: const Padding(
                      padding: EdgeInsets.only(
                          left: 22, right: 22, top: 11, bottom: 11),
                      child: Text(
                        'Create challenge',
                        style: TextStyle(
                            fontSize: 18,
                            fontWeight: FontWeight.w600,
                            color: Colors.white),
                      ),
                    ),
                  ),
                ),
                onTap: () async => {
                  await HttpService.createNewChallenge(
                    groups.selectedGroup!.uuid,
                    nameController.text,
                    challengeType,
                    selectedDate,
                  ),
                  groups.hardGroupChallengesRequest(),
                  groups.setPostCreationTargetUuid(null),
                  Navigator.pop(context),
                },
              )
            ],
          ),
        ),
      ),
    );
  }

  // Select for Date
  Future<DateTime> _selectDate(BuildContext context) async {
    final selected = await showDatePicker(
      context: context,
      initialDate: selectedDate,
      firstDate: DateTime(2000),
      lastDate: DateTime(2025),
    );
    if (selected != null && selected != selectedDate) {
      setState(() {
        selectedDate = selected;
      });
    }
    return selectedDate;
  }

  Future _selectDateTime(BuildContext context) async {
    final date = await _selectDate(context);
    if (date == null) return;

    setState(() {
      selectedDate = DateTime(
        date.year,
        date.month,
        date.day,
      );
    });
  }

  String getDateTime() {
    // ignore: unnecessary_null_comparison
    if (selectedDate == null) {
      return 'select date timer';
    } else {
      return DateFormat('yyyy-MM-dd').format(selectedDate);
    }
  }
}
