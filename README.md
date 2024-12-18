<h1 align="center">
   Java SDK for nextdoor
</h1>

<p align="center">
   <a href="https://central.sonatype.com/artifact/io.github.kukushaa/nextdoor-java-sdk" target="_blank">
      <img src="https://img.shields.io/maven-central/v/io.github.kukushaa/nextdoor-java-sdk?logo=sonatype&link=https%3A%2F%2Fcentral.sonatype.com%2Fartifact%2Fio.github.kukushaa%2Fnextdoor-java-sdk" alt="Sonatype Logo">
   </a>

   <a href="https://github.com/Kukushaa/nextdoor-java-sdk/blob/main/LICENSE.md" target="_blank">
      <img src="https://img.shields.io/github/license/Kukushaa/nextdoor-java-sdk" alt="License">
   </a>
</p>

## Introduction

This SDK was written to make API calls for nextdoor API easier and more convenient via Java.

For nextdoor API official documentation, visit their [website](https://developer.nextdoor.com/reference/introduction).

## Installation

Recommended installation of SDK is via `maven` (or gradle etc.). The last version of dependency that needs to be injected:

```xml
<!--https://github.com/Kukushaa/nextdoor-java-sdk-->
<dependency>
    <groupId>io.github.kukushaa</groupId>
    <artifactId>nextdoor-java-sdk</artifactId>
    <version>1.1.1</version>
</dependency>
```

## Examples

### Create/Get access token

To create/get the first access token via our SDK, use the generated code below:

```java
import com.nextdoor.exception.APIRequestException;
import com.nextdoor.models.AccessToken;

public class GenerateAccessToken {
    public static void main(String[] args) {
        final String userName = "USERNAME";
        final String password = "PASSWORD";
        final String authorizationCode = "AUTHORIZATION_CODE";
        final String clientId = "CLIENT_ID";
        final String redirectUri = "REDIRECT_URI";

        try {
            AccessToken accessToken = new NextDoorAPIAccessToken(userName, password)
                    .generate()
                    .setGrantType(AccessToken.GrantType.AUTHORIZATION_CODE)
                    .setCode(authorizationCode)
                    .setClientId(clientId)
                    .setRedirectUri(redirectUri)
                    .execute();

            System.out.println("Generated access token: " + accessToken.getAccessToken());
        } catch (APIRequestException e) {
            throw new RuntimeException(e);
        }
    }
}
```

After executing the code successfully, it will return `AccessToken` object, which includes `accessToken` object, which we can
get via method `getAccessToken()` (be careful, don't share your access token!).

[documentation](https://developer.nextdoor.com/reference/sharing-get-access-token)

### Create post

After creating/getting an access token, we can create the first post via our SDK.

To make that possible, use the generated code below:

```java
public class CreatePost {
    public static void main(String[] args) {
        final String token = "TOKEN";

        try {
            Post post = new NextDoorAPIPosts(new NextDoorAPIAuth(token))
                    .createDefaultPost()
                    .setBodyText("My first post created via SDK!")
                    .execute();

            System.out.println("Link to created post: " + post.getLinkToPost());
        } catch (APIRequestException e) {
            throw new RuntimeException(e);
        }
    }
}
```

After executing the code successfully, it will return the `Post` object, which includes `postToLink` object, which represents
link to the post that we created, to get it use the method `getLinkToPost()`.

[documentation](https://developer.nextdoor.com/reference/create-post)

All classes, which are making requests to nextdoor API, are in the `api` package.

## Known bugs

This article is for known bugs that are in fixing progress.

1) `HTTP GET request failed java.lang.RuntimeException: java.lang.RuntimeException: org.json.JSONException: A JSONArray
   text must start with '[' at 1 [character 2 line 1]` -- This exception appears because nextdoor API returns HTML
   page and not JSON, we are waiting for nextdoor to fix this kind of issue (typically throws in displayingcontent
   package classes).