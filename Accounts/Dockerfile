# The from command is used to define the base image you are building with.
# It should contain Java Runtime. Basically installing Java in your docker container
FROM openjdk:11-slim as build

# Metadata info about who maintains the docker image
MAINTAINER betPawa


# Add the applications jar file to the container, copy the jar of the project into the container file system
COPY target/Accounts-0.0.1-SNAPSHOT.jar Accounts-0.0.1-SNAPSHOT.jar

#execute the application
ENTRYPOINT ["java", "-jar", "/Accounts-0.0.1-SNAPSHOT.jar"]

# The docker file creates a definition of our docker image...