# fizzbuzz Project

Welcome to the **FizzBuzz**.

The `Make` command in the root folder will give you available commands.

## Prerequisites

- JDK 11+ installed with JAVA_HOME configured appropriately
- Optionaly quarkus CLI
- jq is a plus when testing with curl

## Running the application in dev mode

You can run your application in dev mode that enables live coding using:
```shell script
./gradlew quarkusDev
```

You can then test the app with http requests like:
```sheel script
curl --location --request POST 'localhost:8080/fizzbuzz' \
--header 'Content-Type: application/json' \
--data-raw '{
    "str1": "fizz",
    "int1": 3,
    "str2": "buzz",
    "int2": 1,
    "limit": 15
}' | jq
```

## Testing the app

Run `Make test` to run tests.
Run `Make test.info` to run with more logs.

## Packaging and running the application

The application can be packaged using:`make build`

It produces the `quarkus-run.jar` file in the `build/quarkus-app/` directory.

The application is now runnable using `java -jar build/quarkus-app/quarkus-run.jar`.

## Related Guides

- Kotlin ([guide](https://quarkus.io/guides/kotlin)): Write your services in Kotlin
- Reactive Easily start your Reactive RESTful Web Services [Related guide section...](https://quarkus.io/guides/getting-started-reactive#reactive-jax-rs-resources)
