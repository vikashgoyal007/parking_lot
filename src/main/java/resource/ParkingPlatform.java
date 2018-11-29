package main.java.resource;

import main.java.service.ParkingLotService;
import main.java.service.ParkingLotServiceImpl;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ParkingPlatform {

    public static void main(String[] args) {

        ParkingPlatform parkingPlatform = new ParkingPlatform();

        // if no argument provided then read from file
        if(args == null || args.length == 0){

            ParkingLotService parkingLotService = null;
            String line = null;
            try {
                while(line == null || !line.equals("exit")) {
                    BufferedReader reader =
                            new BufferedReader(new InputStreamReader(System.in));
                    line = reader.readLine();
                    String[] lineData = line.split(" ");
                    parkingLotService = parkingPlatform.parkingLotActions(parkingLotService, lineData);
                }
            } catch (IOException e) {
                System.out.println("Unable to read from input");
            }
        }else{
            try {
                parkingPlatform.runThroughFile("bin/" + args[0]);
            }catch (IOException e){
                System.out.println("Unable to read file");
            }
        }
    }

    public void runThroughFile(String fileName) throws IOException {
        ParkingLotService parkingLotService = null;
        BufferedReader reader = null;

        try {
            reader = new BufferedReader(new FileReader(fileName));
            String line = reader.readLine();
            while (line != null) {
                String[] lineData =  line.split(" ");
                parkingLotService = parkingLotActions(parkingLotService, lineData);
                // read next line
                line = reader.readLine();
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(reader != null){
                reader.close();
            }
        }
    }

    private ParkingLotService parkingLotActions(ParkingLotService parkingLotService, String[] lineData) {
        switch (lineData[0]){
            case "create_parking_lot" : parkingLotService = new ParkingLotServiceImpl(Integer.parseInt(lineData[1]));break;
            case "park" : parkingLotService.allocateSlotToCar(lineData[1],lineData[2]); break;
            case "leave" : parkingLotService.freeSlot(Integer.parseInt(lineData[1])); break;
            case "status" : parkingLotService.status(); break;
            case "registration_numbers_for_cars_with_colour" : parkingLotService.getRegistrationNumberOfAllCarWithGivenColor(lineData[1]); break;
            case "slot_numbers_for_cars_with_colour" : parkingLotService.getSlotNumberForCarsWithColor(lineData[1]); break;
            case "slot_number_for_registration_number" : parkingLotService.getSlotNumberForRegistrationNumber(lineData[1]); break;

        }

        return parkingLotService;
    }
}
