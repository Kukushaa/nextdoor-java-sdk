# Nextdoor SDK for Java

## Introduction

This SDK was written to make API calls for [NextDoor API](https://developer.nextdoor.com/reference/introduction) more
easy and comfortable via Java.

Maven central repository (sonatype)
URL: [link](https://central.sonatype.com/artifact/io.github.kukushaa/nextdoor-java-sdk)

## Quick Start

### Add dependency

To add `nextdoor-java-sdk` to your maven project, you need to add `dependency` into your `pom.xml` file:

```xml
<!--https://github.com/Kukushaa/nextdoor-java-sdk-->
<dependency>
    <groupId>io.github.kukushaa</groupId>
    <artifactId>nextdoor-java-sdk</artifactId>
    <version>1.0</version>
</dependency>
```

### Create access token

First of all, you need to generate `Access token` for your API calls, you can create it using simple code:

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

After executing code successfully, you will get `AccessToken` object, which include `accessToken`, which you can use for
making API calls (be carefull, don't share you access token and don't leak it!).

### Create first post

After we generate our access token, we can create first Post on our page with code bellow:

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

After executing code successfully, you will get `Post` object, which include `postToLink`, which is link to post, which
you create (be carefull, don't share you access token and don't leak it!).