FROM  eclipse-temurin:21-jdk AS build

WORKDIR /Personal

COPY . .

RUN javac -cp "lib/*"  src/*.java 



FROM  eclipse-temurin:21-jdk
COPY --from=build /Personal /Personal


ENTRYPOINT ["java", "-cp", "src:lib/*", "MainMenu"]

