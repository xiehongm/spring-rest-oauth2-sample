# Spring Rest OAuth2 Sample

This is REST service sample that protected by [Spring OAuth 2](http://projects.spring.io/spring-security-oauth/).

## Build and Run

```
$ cd <spring-rest-oauth2-sample root path>
$ ./gradlew clean build bootRun
```

## Usage

1. Take your token from `oauth/token` in terminal, if you use ssl remember add `-k`:

```
$ curl -X POST -vu ios_app:123456 http://localhost:8080/oauth/token -H "Accept: application/json" -d "password=admin&username=admin&grant_type=password&scope=read&client_secret=123456&client_id=ios_app"
```

or [Advanced REST Client](https://github.com/jarrodek/advanced-rest-client) in your Chrome with:

```
url: http://localhost:8080/oauth/token
POST
headers: Authorization: Basic <Encrypt client_id:client_secret by HTTP Basic>
playload: password=admin&username=admin&grant_type=password&scope=read
```

2. Use the **'access_json'** returned to make the authorized request to the protected endpoint:

```
$ curl http://localhost:8080/welcome -H "Authorization: Bearer <access_token_returned>"
```
If the request is successful, you will see the following JSON response:

```
{
	"id":2,
	"content":"Hello, admin!"
}
```

or use Advanced REST Client:

```
url: http://localhost:8080/welcome
GET
headers: Authorization: bearer <access_token_returned>
```

3. Get user information:

```
$ curl http://localhost:8080/resources/users/admin -H "Authorization: Bearer <access_token_returned>"
```

If the request is successful, you will see the following JSON response:

```
{
	"name":"admin",
	"username":"admin"
}
```

or use Advanced REST Client:

```
url: http://localhost:8080/resources/users/admin
GET
headers: Authorization: bearer <access_token_returned>
```

4. Refresh token:

```
curl -X POST -vu ios_app:123456 http://localhost:8080/oauth/token -H "Accept: application/json" -d "grant_type=refresh_token&refresh_token=<refresh_token_returned>&client_secret=123456&client_id=ios_app"
```

or use Advanced REST Client:

```
url: http://localhost:8080/oauth/token
POST
headers: Authorization: Basic <Encrypt client_id:client_secret by HTTP Basic>
playload: grant_type=refresh_token&refresh_token=<refresh_token_returned>
```

## Version History:

- 0.0.1-SNAPSHOT
  - Initial version.
- 0.1.0-RELEASE
  - Release version.
- 0.2.0-RELEASE
  - Change authorities to resources.
  - Add https.
  - Fix some bugs.
- 0.2.1-RELEASE
  - Add name to Resource PO.
  - Change getAuthorities().
  - Change import.sql.
- 0.3.0-RELEASE
  - Add /bo, /enums, /exception.
  - Add UserService and its implement.
- 0.3.1-RELEASE
  - Modify build.gradle.
  - Add refresh token usage.
- 0.3.2-RELEASE
  - Fix some hidden bugs.
  - Add SystemRuntimeException and UnknownException.