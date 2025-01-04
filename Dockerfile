FROM openjdk:11
WORKDIR /user/scr/app
COPY . .
RUN javac Calculator.java
CMD ["java","Calculator"]
