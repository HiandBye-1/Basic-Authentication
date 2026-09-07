FROM  eclipse-temurin:21

WORKDIR /Personal

COPY . .

RUN javac -cp "lib/*"  src/*.java 



ENTRYPOINT ["java", "-cp", "src:lib/*", "MainMenu"]

