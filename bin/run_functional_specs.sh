javac -classpath src/ src/main/java/resource/ParkingPlatform.java
javac -classpath src/:lib/junit-4.12.jar:lib/hamcrest-core-1.3.jar src/test/java/service/ParkingLotServiceTest.java  
java -classpath src/:lib/junit-4.12.jar:lib/hamcrest-core-1.3.jar org.junit.runner.JUnitCore test.java.service.ParkingLotServiceTest
