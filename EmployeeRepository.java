
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;

class EmployeeRepository {
    private static final ArrayList<Employee> listEmployee = new ArrayList<>();
    private static int counter = 1;

    private static String getCurrentDate() {
        LocalDate now = LocalDate.now();
        DateTimeFormatter myformat = DateTimeFormatter.ofPattern("yyyyMMdd");
        return now.format(myformat);
    }

    private static String generateId() {
        String dateNow = getCurrentDate();

        return dateNow + String.format("%05d", counter++);
    }

    private static Employee findEmployeeByName(String name) {
        for (Employee Employee : listEmployee) {
            if (Employee.getName().equalsIgnoreCase(name)) {
                return Employee;
            }
        }
        return null;
    }

    private Employee findEmployeeById(String id) {
        for (Employee Employee : listEmployee) {
            if (Employee.getId().equals(id)) {
                return Employee;
            }
        }
        return null;
    }

    public void displayEmployee(){
        if(!(listEmployee.isEmpty())){
            for(int i = 1; i <= listEmployee.size(); i++){
                System.out.println("Karyawan#" + i);
                System.out.println(listEmployee.get(i - 1) + "\n");
            }
        }else{
            System.out.println("Tidak ada data Karyawan.");
        }
    }

    public void addEmployee(Scanner scanner) {
        System.out.print("Masukkan nama Karyawan: ");
        String name = scanner.nextLine();

        Employee foundEmployee = findEmployeeByName(name);

        if (foundEmployee != null) {
            System.out.println("Nama Karyawan duplikat");
        } else {
            String id = generateId();
            Employee EmployeeBaru = new Employee(id, name);
            listEmployee.add(EmployeeBaru);

            System.out.println("Data Karyawan berhasil ditambahkan!");
        }
    }

    public void updateEmployee(Scanner scanner) {
        System.out.print("Masukkan ID Karyawan: ");
        String id = scanner.nextLine();

        Employee foundEmployee = findEmployeeById(id);
        if (foundEmployee != null) {
            System.out.print("Masukkan nama Karyawan yang baru: ");
            String newName = scanner.nextLine();

            foundEmployee.setName(newName);

            System.out.println("Data Karyawan berhasil diubah!");
        } else {
            System.out.println("Mohon maaf data Karyawan tidak ditemukan!");

        }
    }

    public void deleteEmployee(Scanner scanner) {
        System.out.print("Masukkan ID Employee: ");
        String id = scanner.nextLine();

        Employee foundEmployee = findEmployeeById(id);
        if (foundEmployee != null) {
            listEmployee.remove(foundEmployee);

            System.out.println("Data Employee berhasil dihapus!");
        }else{
            System.out.println("Mohon maaf data Employee tidak ditemukan!");
        }
    }
    
    public void exitApp(){
        listEmployee.clear();
        System.out.println("Semua data Employee telah dihapus dan terima kasih telah menggunakan aplikasi pendataan kami...");
    }
}