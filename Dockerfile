FROM  eclipse-temurin:21
WORKDIR /Personal
COPY . .
RUN javac -cp"lib/mysql-connector-j-9.6.0.jar"  src/*.java 





CMD ["java", "-cp", "src:lib/*", "MainMenu"]

