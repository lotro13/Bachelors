import 'dart:async';
import 'dart:io';

import 'package:application/domain/post.dart';
import 'package:flutter/foundation.dart';
import 'package:flutter/material.dart';
import 'package:image_picker/image_picker.dart';
import 'package:provider/provider.dart';

import '../../providers/groups_provider.dart';
import '../../services/http_service.dart';

class PostCreationPage extends StatefulWidget {
  const PostCreationPage({Key? key}) : super(key: key);

  @override
  _PostCreationPageState createState() => _PostCreationPageState();
}

class _PostCreationPageState extends State<PostCreationPage> {
  List<XFile>? _imageFileList;

  set _imageFile(XFile? value) {
    _imageFileList = value == null ? null : <XFile>[value];
  }

  dynamic _pickImageError;
  String? _retrieveDataError;
  final ImagePicker _picker = ImagePicker();

  TextEditingController titleController = TextEditingController();
  TextEditingController descriptionController = TextEditingController();

  bool isRatedPost = false;

  @override
  Widget build(BuildContext context) {
    GroupsProvider groups = Provider.of<GroupsProvider>(context);

    return Scaffold(
      appBar: AppBar(
        backgroundColor: Colors.blueAccent,
        title: const Text("Create new post"),
      ),
      body: Column(
        children: [
          Expanded(
            child: Center(
              child: !kIsWeb && defaultTargetPlatform == TargetPlatform.android
                  ? FutureBuilder<void>(
                      future: retrieveLostData(),
                      builder:
                          (BuildContext context, AsyncSnapshot<void> snapshot) {
                        switch (snapshot.connectionState) {
                          case ConnectionState.none:
                          case ConnectionState.waiting:
                            return const Text(
                              'You have not yet picked an image.',
                              textAlign: TextAlign.center,
                            );
                          case ConnectionState.done:
                            return _previewImages();
                          default:
                            if (snapshot.hasError) {
                              return Text(
                                'Pick image/video error: ${snapshot.error}}',
                                textAlign: TextAlign.center,
                              );
                            } else {
                              return const Text(
                                'You have not yet picked an image.',
                                textAlign: TextAlign.center,
                              );
                            }
                        }
                      },
                    )
                  : _previewImages(),
            ),
          ),
          GestureDetector(
            child: Row(
              children: [
                Expanded(
                  child: Container(
                    alignment: Alignment.center,
                    color: Colors.blueAccent,
                    child: const Padding(
                      padding: EdgeInsets.all(8.0),
                      child: Text(
                        'Select Image',
                        style: TextStyle(
                            fontSize: 18,
                            fontWeight: FontWeight.w600,
                            color: Colors.white),
                      ),
                    ),
                  ),
                ),
              ],
            ),
            onTap: () => {
              _onImageButtonPressed(ImageSource.gallery, context: context),
            },
          ),
          Padding(
            padding: const EdgeInsets.all(25.0),
            child: Column(
              mainAxisAlignment: MainAxisAlignment.center,
              crossAxisAlignment: CrossAxisAlignment.center,
              children: [
                TextFormField(
                  controller: titleController,
                  decoration: const InputDecoration(
                    hintText: "Post title",
                  ),
                ),
                TextFormField(
                  controller: descriptionController,
                  decoration: const InputDecoration(
                    hintText: "Post description",
                  ),
                ),
                groups.selectedChallenge!.canCreateRatedPost
                    ? Row(
                        children: [
                          Switch(
                            value: isRatedPost,
                            onChanged: (v) => setState(() {
                              isRatedPost = v;
                            }),
                          ),
                          const Padding(
                            padding: EdgeInsets.only(left: 18),
                            child: Text('Is post rated'),
                          )
                        ],
                      )
                    : const SizedBox(height: 20),
                Padding(
                  padding: const EdgeInsets.only(top: 16.0),
                  child: GestureDetector(
                    child: ClipRRect(
                      borderRadius:
                          const BorderRadius.all(Radius.circular(60.0)),
                      child: Container(
                        color: Colors.blueAccent,
                        child: const Padding(
                          padding: EdgeInsets.only(
                              left: 22, right: 22, top: 11, bottom: 11),
                          child: Text(
                            'Create post',
                            style: TextStyle(
                                fontSize: 18,
                                fontWeight: FontWeight.w600,
                                color: Colors.white),
                          ),
                        ),
                      ),
                    ),
                    onTap: () async => {
                      await HttpService.createNewPost(
                        groups.postCreationTargetUuid!,
                        titleController.text,
                        descriptionController.text,
                        "myCustomImage",
                      ),
                      groups.hardChallengeFeedRequest(
                          groups.postCreationTargetUuid!),
                      groups.setPostCreationTargetUuid(null),
                      Navigator.pop(context),
                    },
                  ),
                )
              ],
            ),
          ),
        ],
      ),
    );
  }

  Future<void> _onImageButtonPressed(ImageSource source,
      {BuildContext? context}) async {
    try {
      final XFile? pickedFile = await _picker.pickImage(
        source: source,
        maxWidth: null,
        maxHeight: null,
        imageQuality: null,
      );
      setState(() {
        _imageFile = pickedFile;
      });
    } catch (e) {
      setState(() {
        _pickImageError = e;
      });
    }
  }

  Widget _previewImages() {
    final Text? retrieveError = _getRetrieveErrorWidget();
    if (retrieveError != null) {
      return retrieveError;
    }
    if (_imageFileList != null) {
      return Semantics(
          child: ListView.builder(
            key: UniqueKey(),
            itemBuilder: (BuildContext context, int index) {
              return Semantics(
                label: 'image_picker_example_picked_image',
                child: kIsWeb
                    ? Image.network(_imageFileList![index].path)
                    : Image.file(File(_imageFileList![index].path)),
              );
            },
            itemCount: _imageFileList!.length,
          ),
          label: 'image_picker_example_picked_images');
    } else if (_pickImageError != null) {
      return Text(
        'Pick image error: $_pickImageError',
        textAlign: TextAlign.center,
      );
    } else {
      return const Text(
        'You have not yet picked an image.',
        textAlign: TextAlign.center,
      );
    }
  }

  Future<void> retrieveLostData() async {
    final LostDataResponse response = await _picker.retrieveLostData();
    if (response.isEmpty) {
      return;
    }
    if (response.file != null) {
      setState(() {
        _imageFile = response.file;
        _imageFileList = response.files;
      });
    } else {
      _retrieveDataError = response.exception!.code;
    }
  }

  Text? _getRetrieveErrorWidget() {
    if (_retrieveDataError != null) {
      final Text result = Text(_retrieveDataError!);
      _retrieveDataError = null;
      return result;
    }
    return null;
  }
}
