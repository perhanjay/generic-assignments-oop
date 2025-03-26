//Anda diminta untuk membuat sistem sederhana yang mengelola berbagai jenis kendaraan
// menggunakan abstract class dan interface.
// Sistem ini akan mencakup kendaraan darat dan air,
// dengan fitur seperti pergerakan, konsumsi bahan bakar,
// dan kemampuan khusus tertentu. Tugas ini akan menguji kemampuan Anda
// dalam mendesain hierarki kelas, mengimplementasikan metode abstrak,
// dan menggunakan interface untuk menambahkan perilaku tambahan.

public class Main {
    public static void main(String[] args) {
        Vehicle[] vehicles = {new LandVehicle("Toyota", 80, 50, 4),
                              new WaterVehicle("Joysway SpeedBoat", 120, 50, true),
                              new LandVehicle("Leopard tank", 80, 50, 9)};

        for (Vehicle vehicle : vehicles) {
            vehicle.move();
            vehicle.powerSavingMode();
            vehicle.move();
            vehicle.calculateFuelConsumption(50);
            vehicle.powerSavingModeOff();
            vehicle.calculateFuelConsumption(50);
            if (vehicle.isFuelLow()) {
                vehicle.refuel(30);
            }
            System.out.println();
        }
    }
}
