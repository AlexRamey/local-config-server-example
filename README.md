# Local Config Server Example

This repo holds one application called `gs-rest-service` that prints out a greeting to the provided `?name=` parameter or a configurable default. It depends on a configuration server called `configuration-service` that runs locally. The locally-running configuration service points to the config folder hosted at the root of this repo to get the config values.

Build and Run the Local Config Server
```bash
cd configuration-service
./gradlew build
java -jar build/libs/configuration-service-0.0.1-SNAPSHOT.jar
```

Verify the Local Config Server is Up
```bash
curl "http://localhost:8888/gs-rest-service/default"
```

Build and Run the `gs-rest-service` Application
```bash
cd gs-rest-service
./gradlew build
java -jar build/libs/gs-rest-service-0.1.0.jar
```

Verify the Application Works
```bash
curl "http://localhost:8080/greeting?name=world"
```

should yield:

```json
{"id":2,"content":"Hello, world!"}
```

Test if the Configuration is working:
```bash
curl "http://localhost:8080/greeting"
```

should yield:
```json
{"id":2,"content":"Hello, fred!"}
```

(assuming that `fred` is the value configured in `config/gs-rest-service.yml`)

You can hot reload the config at any time:
```bash
 curl -H "Content-Type: application/json" -d {} "localhost:8080/actuator/refresh" 
```

which is useful when you want to change the config and see those changes reflected without restarting the application.

