package assignments;

import java.util.Scanner;

class PatientRecord {
    int patientNumber;
    String patientName;
    String patientAddress;
    String patientBirthDay;
    String patientContact;
    float totalCost;

    public PatientRecord(int patientNumber, String patientName, String patientAddress, String patientBirthDay, String patientContact) {
        this.patientNumber = patientNumber; this.patientName = patientName;
        this.patientAddress = patientAddress; this.patientBirthDay = patientBirthDay;
        this.patientContact = patientContact; this.totalCost = 0;
    }
    void printPatients() {
        System.out.println("Patient Number: " + patientNumber);
        System.out.println("Patient Name: " + patientName);
        System.out.println("Patient Address: " + patientAddress);
        System.out.println("Patient Birthday: " + patientBirthDay);
        System.out.println("Patient Contact: " + patientContact);
        System.out.println();
    }
}

class RoomRecord {
    String roomType;
    int roomNumber;
    float roomPrice;
    boolean isOccupied;

    public RoomRecord(String roomType, int roomNumber, float roomPrice) {
        this.roomType = roomType;
        this.roomNumber = roomNumber;
        this.roomPrice = roomPrice;
        this.isOccupied = false;
    }
}

class ServiceRecord {
    String serviceType;
    String serviceName;

    public ServiceRecord(String serviceType, String serviceName) {
        this.serviceType = serviceType;
        this.serviceName = serviceName;
    }
}

class MainPatientRecord {
    static Scanner scan = new Scanner(System.in);

    public static void patient(PatientRecord[] patientRecords) {
        for (int i = 0; i < patientRecords.length; i++) {
            int pNumber; String pName, pAddress, pBirthDay, pContact;
            System.out.println();
            while (true) {
                try {
                    System.out.print("Patient Number:\t\t");
                    pNumber = Integer.parseInt(scan.nextLine().trim());
                    if (pNumber > 0) break;
                    System.out.println("Error: Patient number must be positive.");
                } catch (Exception e) {
                    System.out.println("Error: Invalid input! Enter a valid integer.");
                }
            }

            while (true) {
                System.out.print("Patient Name:\t\t");
                pName = scan.nextLine().trim();
                if (!pName.isEmpty()) break;
                System.out.println("Error: Name cannot be empty.");
            }

            while (true) {
                System.out.print("Patient Address:\t\t");
                pAddress = scan.nextLine().trim();
                if (!pAddress.isEmpty()) break;
                System.out.println("Error: Address cannot be empty.");
            }

            while (true) {
                System.out.print("Patient Birthday:\t\t");
                pBirthDay = scan.nextLine().trim();
                if (!pBirthDay.isEmpty()) break;
                System.out.println("Error: Birthday cannot be empty.");
            }

            while (true) {
                System.out.print("Patient Contact:\t\t");
                pContact = scan.nextLine().trim();
                if (!pContact.isEmpty()) break;
                System.out.println("Error: Contact cannot be empty.");
            }

            patientRecords[i] = new PatientRecord(pNumber, pName, pAddress, pBirthDay, pContact);
        } System.out.println("\nPatient record entry completed.\n");

        for (PatientRecord patientRecord : patientRecords) {
            if (patientRecord != null)
                patientRecord.printPatients();
        }
    }

    public static void room(RoomRecord[] roomRecords) {
        for (int i = 0; i < roomRecords.length; i++) {
            String roomType;
            int roomNumber;
            float roomPrice;
            System.out.println();
            while (true) {
                System.out.print("Room Type:\t\t");
                roomType = scan.nextLine().trim();
                if (!roomType.isEmpty()) break;
                System.out.println("Error: Room type cannot be empty.");
            }

            while (true) {
                try {
                    System.out.print("Room Number:\t\t");
                    roomNumber = Integer.parseInt(scan.nextLine().trim());

                    boolean exists = false;
                    for (int j = 0; j < i; j++) {
                        if (roomRecords[j] != null && roomRecords[j].roomNumber == roomNumber) {
                            exists = true; break;
                        }
                    }

                    if (roomNumber > 0 && !exists) break;
                    System.out.println("Error: Room number must be unique and positive.");
                } catch (Exception e) {
                    System.out.println("Error: Invalid input! Enter a valid integer.");
                }
            }

            while (true) {
                try {
                    System.out.print("Room Price:\t\t");
                    roomPrice = Float.parseFloat(scan.nextLine().trim());
                    if (roomPrice > 0) break;
                    System.out.println("Error: Room price must be a positive number.");
                } catch (Exception e) {
                    System.out.println("Error: Invalid input! Enter a valid price.");
                }
            }

            roomRecords[i] = new RoomRecord(roomType, roomNumber, roomPrice);
        }
        System.out.println("\nRoom record entry completed.");
    }

    public static void assignPatients(PatientRecord[] patientRecords, RoomRecord[] roomRecords) {
        for (int i = 0; i < 5; i++) {
            int patientNumber, roomNum, numberOfDays;
            boolean patientExists = false;
            System.out.println();
            while (true) {
                try {
                    System.out.print("Patient Number:\t\t");
                    patientNumber = Integer.parseInt(scan.nextLine().trim());
                    for (PatientRecord patient : patientRecords) {
                        if (patient != null && patient.patientNumber == patientNumber) {
                            patientExists = true; break;
                        }
                    }
                    if (patientExists) break;
                    System.out.println("Error: Patient number does not exist!");

                } catch (Exception e) {
                    System.out.println("Error: Invalid input! Enter a valid integer.");
                }
            }

            int assignedRoomIndex = -1;
            while (true) {
                try {
                    System.out.print("Room Number:\t\t");
                    roomNum = Integer.parseInt(scan.nextLine().trim());

                    for (int j = 0; j < roomRecords.length; j++) {
                        if (roomRecords[j] != null && roomRecords[j].roomNumber == roomNum && !roomRecords[j].isOccupied) {
                            assignedRoomIndex = j; break;
                        }
                    }

                    if (assignedRoomIndex != -1) break;
                    System.out.println("Room does not exist or is already occupied!");
                } catch (Exception e) {
                    System.out.println("Error: Invalid input! Enter a valid room number.");
                }
            }

            while (true) {
                try {
                    System.out.print("Number of days:\t\t");
                    numberOfDays = Integer.parseInt(scan.nextLine().trim());
                    if (numberOfDays > 0) break;
                    System.out.println("Error: Number of days must be positive.");
                } catch (Exception e) {
                    System.out.println("Error: Invalid input! Enter a valid number of days.");
                }
            }

            roomRecords[assignedRoomIndex].isOccupied = true;
            patientRecords[i].totalCost += numberOfDays * roomRecords[assignedRoomIndex].roomPrice;
            System.out.println("\nPatient " + patientNumber + " assigned to Room " + roomRecords[assignedRoomIndex].roomNumber + " for " + numberOfDays + " days.");
        }
    }

    public static void service(ServiceRecord[] serviceRecords, PatientRecord[] patientRecords) {

        for (int i = 0; i < serviceRecords.length; i++) {
            String serviceType, serviceName;

            while (true) {
                System.out.print("Service Type: ");
                serviceType = scan.nextLine().trim();
                if (!serviceType.isEmpty()) break;
                System.out.println("Error: Service type cannot be empty.");
            }
            while (true) {
                System.out.print("Service Name: ");
                serviceName = scan.nextLine().trim();
                if (!serviceName.isEmpty()) break;
                System.out.println("Error: Service name cannot be empty.");
            }
            serviceRecords[i] = new ServiceRecord(serviceType, serviceName);
        }

        for (int i = 0; i < 5; i++) {
            int patientNumber; boolean patientExists = false;

            while (true) {
                try {
                    System.out.print("\nPatient Number:\t\t");
                    patientNumber = Integer.parseInt(scan.nextLine().trim());
                    for (PatientRecord patient : patientRecords) {
                        if (patient != null && patient.patientNumber == patientNumber) {
                            patientExists = true; break;
                        }
                    }
                    if (patientExists) break;
                    System.out.println("Error: Patient number does not exist!");

                } catch (Exception e) {
                    System.out.println("Error: Invalid input! Enter a valid integer.");
                }
            }

            char answer = 'Y';
            while (answer == 'Y') {
                String serviceName; float price;

                while (true) {
                    System.out.print("Service Name:\t\t");
                    serviceName = scan.nextLine().trim();
                    if (!serviceName.isEmpty()) break;
                    System.out.println("Error: Service name cannot be empty.");
                }
                while (true) {
                    try {
                        System.out.print("Service Price:\t\t");
                        price = Float.parseFloat(scan.nextLine().trim());
                        if (price > 0) break;
                        System.out.println("Error: Service price must be a positive number.");
                    } catch (Exception e) {
                        System.out.println("Error: Invalid input! Enter a valid price.");
                    }
                }

                for (PatientRecord patient : patientRecords) {
                    if (patient != null && patient.patientNumber == patientNumber) {
                        patient.totalCost += price; break;
                    }
                }

                while (true) {
                    System.out.print("Add More? (Y/N): ");
                    answer = scan.nextLine().trim().toUpperCase().charAt(0);

                    if (answer == 'Y' || answer == 'N') break;
                    System.out.println("Invalid input! Please enter 'Y' or 'N'.");
                }
            }
        }
    }
    public static void outputPatientRecord(PatientRecord[] patientRecords) {
        System.out.println("\nPatient Record Summary: ");
        for (PatientRecord patientRecord : patientRecords) {
            if (patientRecord != null) {
                System.out.println("Patient Number: " + patientRecord.patientNumber);
                System.out.println("Patient Name: " + patientRecord.patientName);
                System.out.println("Total Bill: " + patientRecord.totalCost);
                System.out.println();
            }
        }
    }

    public static void main(String[] args) {
        PatientRecord[] patientRecords = new PatientRecord[5];
        RoomRecord[] roomRecords = new RoomRecord[10];
        ServiceRecord[] serviceRecords = new ServiceRecord[10];

        patient(patientRecords);
        room(roomRecords);
        assignPatients(patientRecords, roomRecords);
        service(serviceRecords, patientRecords);
        outputPatientRecord(patientRecords);
        scan.close();
    }
}