# Build Stage
FROM maven:3.8.6-openjdk-18 AS build
WORKDIR /app
COPY . .
RUN mvn clean package

# Run Stage
FROM openjdk:18-jdk-slim
WORKDIR /app
COPY --from=build /app/target/*.jar app.jar
ENV JAVA_OPTS="-Xms256m -Xmx512m"
EXPOSE 8080
CMD ["java", "${JAVA_OPTS}", "-jar", "app.jar"]