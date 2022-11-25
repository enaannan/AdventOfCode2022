//package Utils
//
//import scalaj.http.{Http, HttpOptions}
//
//object FetchInput {
//
//  HttpClient client = HttpClient.newBuilder()
//    .version(Version.HTTP_1_1)
//    .followRedirects(Redirect.NORMAL)
//    .connectTimeout(Duration.ofSeconds(20))
//    .proxy(ProxySelector.of(new InetSocketAddress("proxy.example.com", 80)))
//    .authenticator(Authenticator.getDefault())
//    .build();
//  HttpResponse<String> response = client.send(request, BodyHandlers.ofString());
//  System.out.println(response.statusCode());
//  System.out.println(response.body());
//  Http("http://example.com/search")
//}
