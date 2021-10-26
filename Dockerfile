ARG COMPILACION=maven:3.6.0-jdk-8
ARG EJECUCION=ubuntu:18.04

FROM ${COMPILACION} as dependencies
COPY pom.xml ./
RUN mvn dependency:go-offline

FROM dependencies as build
COPY src ./src
RUN mvn clean package -Pjar

FROM ${EJECUCION}
RUN apt-get update && \
    apt-get install -y openjdk-8-jdk && \
    apt-get install -y ant && \
    apt-get clean;
RUN apt-get update && \
    apt-get install ca-certificates-java && \
    apt-get clean && \
    update-ca-certificates -f;
ENV JAVA_HOME /usr/lib/jvm/java-8-openjdk-amd64/
RUN export JAVA_HOME

COPY --from=build target/users-api-0.0.1-SNAPSHOT.jar /home/app.jar

RUN apt-get install -y mongodb
RUN cd / && mkdir data && cd /data && mkdir db

RUN apt-get install -y supervisor
COPY supervisord.conf /etc/supervisord.conf
EXPOSE 8080
CMD ["/usr/bin/supervisord", "-c", "/etc/supervisord.conf"]
