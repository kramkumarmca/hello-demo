# Hello Demo

A small Spring Boot 4.1.1 project using Java 17 and Maven.

## Run in IntelliJ IDEA

1. Open this folder's `pom.xml` as a project and let Maven import dependencies.
2. Select JDK 17 as the project SDK.
3. Run `HelloDemoApplication.main()`.
4. Open http://localhost:8080/hello in your browser.

The response is plain text:

```text
Hi, how are you?
```

## Run from a terminal

Windows PowerShell:

```powershell
.\mvnw.cmd spring-boot:run
```

macOS/Linux:

```sh
./mvnw spring-boot:run
```

Java 17 must be installed. The included Maven wrapper downloads Maven and dependencies on the first run.

## Verify and package

```powershell
.\mvnw.cmd clean verify
java -jar target/hello-demo-0.0.1-SNAPSHOT.jar
```

The integration test starts the real HTTP server on a random port and checks that
`GET /hello` returns status 200, plain text, and the exact greeting.

## Interview walkthrough

Request flow: browser -> `HelloController` -> `HelloService` -> `HelloServiceImpl`.

- `HelloDemoApplication`: starts Spring Boot and discovers components.
- `HelloController`: maps `GET /hello` and returns the service result.
- `HelloService`: defines the greeting operation.
- `HelloServiceImpl`: implements that operation and supplies the greeting.

`@RestController` writes the return value to the HTTP response. `@GetMapping`
maps the URL. `@Service` registers the implementation as a Spring bean.
Constructor injection supplies the service to the controller.

No database or extra configuration is needed. The default port is 8080.
If it is occupied, run the JAR with `--server.port=8081` and use that port in the URL.
