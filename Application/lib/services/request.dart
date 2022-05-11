class Request {
  Uri uri;
  Map<String, String>? headers;
  Object? body;

  Request(this.uri, {this.headers, this.body});

  Request addHeadder(String header, String headerBody) {
    if (headers == null) {
      headers = {header: headerBody};
    } else {
      headers!.addAll({header: headerBody});
    }

    print('New request headders $headers.toString()');

    return Request(uri, headers: headers, body: body);
  }

  void setBody(Object object) {
    body = object;
  }
}
