package test.java.service;

import main.java.resource.ParkingPlatform;
import main.java.service.ParkingLotService;
import main.java.service.ParkingLotServiceImpl;
import org.junit.Test;

import java.io.IOException;


public class ParkingLotServiceTest {

    @Test
    public void testWithInput0(){
        ParkingLotService parkingLotService = new ParkingLotServiceImpl(0);
        parkingLotService.allocateSlotToCar("KA-01-HH-1234","White");
        parkingLotService.freeSlot(4);
    }

    @Test
    public void testWithInput1(){
        ParkingLotService parkingLotService = new ParkingLotServiceImpl(1);
        parkingLotService.allocateSlotToCar("KA-01-HH-1234","White");
        parkingLotService.freeSlot(1);
        parkingLotService.status();
        parkingLotService.allocateSlotToCar("KA-01-P-333","White");
        parkingLotService.status();
    }

    @Test
    public void testWithInput(){
        ParkingLotService parkingLotService = new ParkingLotServiceImpl(6);
        parkingLotService.allocateSlotToCar("KA-01-HH-1234","White");
        parkingLotService.allocateSlotToCar("KA-01-HH-9999","White");
        parkingLotService.allocateSlotToCar("KA-01-BB-0001","Black");
        parkingLotService.allocateSlotToCar("KA-01-HH-7777","Red");
        parkingLotService.allocateSlotToCar("KA-01-HH-2701","Blue");
        parkingLotService.allocateSlotToCar("KA-01-HH-3141","Black");
        parkingLotService.freeSlot(4);
        parkingLotService.status();
        parkingLotService.allocateSlotToCar("KA-01-P-333","White");
        parkingLotService.allocateSlotToCar("DL-12-AA-9999","White");
        parkingLotService.getRegistrationNumberOfAllCarWithGivenColor("White");
        parkingLotService.getSlotNumberForCarsWithColor("White");
        parkingLotService.getSlotNumberForRegistrationNumber("KA-01-HH-3141");
        parkingLotService.getSlotNumberForRegistrationNumber("MH-04-AY-1111");
    }

    @Test
    public void testWithInputFile() throws IOException{
        ParkingPlatform parkingPlatform = new ParkingPlatform();
        parkingPlatform.runThroughFile("src/test/java/service/file_input.txt");
    }

}
