# Use a full JDK image
FROM openjdk:17

# Set the working directory
WORKDIR /app

# Copy Java file
COPY Calculator.java .

# Compile it
RUN javac Calculator.java

# Set the DISPLAY environment variable (this will be overridden at runtime)
ENV DISPLAY=:0

# Run GUI app
CMD ["java", "Calculator"]
