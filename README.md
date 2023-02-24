# Highload Software Architecture 8 Lesson 4 Homework

Monitoring systems for user metrics
---

## Metrics details

This project sends currency rates to Google Analytics 4 using GAMP protocol.

Since UAH/USD rate is pretty static, I decided to send Crypto currency rates instead. Metrics include rates of BTC, ETH and DOGE to UA, USD
and EUR.

Sample payload which is sent to Google Analytics:

```json
{
    "client_id": "12345",
    "events": [
        {
            "name": "BTC_rate",
            "params": {
                "UAH": "872591",
                "EUR": "22502.7",
                "USD": "23728.6"
            }
        }
    ]
}
```

The application is currently deployed to Heroku and sends metrics every minut, so Google Analytics should have some data to show.

## GA Report

Live report can be found [here](https://analytics.google.com/analytics/web/#/report-home/a2710000000w1ZjAAI).

Unfortunately, I couldn't build a report with visible currency rate changes, only a general statistics and parameters preview,
see [PRESENTATION](PRESENTATION.md) for more some screenshots.

LookerStudio also needs couple days to process the data, so it currently doesn't show anything.

## Application configuration

The application is configured using yaml file. It is located
in [`src/main/resources/application.yaml`](src/main/resources/application.yaml).

## Running the project

The project is built with Kotlin/Quarkus and utilizes Gradle as a build tool.

**Requires Java 17+**

### Running the application in dev mode

You can run your application in dev mode that enables live coding using:

```shell script
./gradlew quarkusDev
```

### Other options

Package into thin jar:

```shell script
./gradlew build && \
java -jar build/quarkus-app/quarkus-run.jar
```

Package into fat jar:

```shell script
./gradlew build -Dquarkus.package.type=uber-jar && \
java -jar build/*-runner.jar
```

Native executables are also supported but guaranteed to work properly,
see https://quarkus.io/guides/gradle-tooling.
