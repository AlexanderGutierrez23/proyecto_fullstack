FROM ghcr.io/graalvm/native-image-community:17-ol9 AS build
WORKDIR /app

COPY ../pom.xml ./pom.xml
COPY . .

RUN ./mvnw -Pnative native:compile -DskipTests

FROM debian:bookworm-slim
WORKDIR /app

COPY --from=build /app/target/ms-boleta /app/ms-boleta

EXPOSE 8080

ENTRYPOINT ["/app/ms-boleta"]