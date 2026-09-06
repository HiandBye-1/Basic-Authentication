FROM  eclipse-temurin:21

WORKDIR /Personal

COPY . .

RUN javac -cp "lib/*"  src/*.java 

ENV DB_USER=HiandBye
ENV DB_PASSWORD=Thanhly2410?
ENV DB_HOST=host.docker.internal




ENTRYPOINT ["java", "-cp", "src:lib/*", "MainMenu"]

