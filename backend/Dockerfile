FROM openjdk:11.0.6-jre

RUN mkdir /backend /backebnd/bin /backend/lib

COPY build/install/backend/bin/backend /backend/bin/
COPY build/install/backend/lib/*.jar /backend/lib/

WORKDIR /backend

CMD ["bin/backend", "-Xms:1G", "-Xmx:2G"]
