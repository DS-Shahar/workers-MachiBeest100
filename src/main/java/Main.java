import java.util.*;

public class Company {
    private Queue<Worker> workers;

    public Company() {
        this.workers = new LinkedList<>();
    }

    public void fired(int departmentNumber, int num) {
        List<Worker> toBeFired = new ArrayList<>();
        Iterator<Worker> iterator = workers.iterator();

        while (iterator.hasNext() && toBeFired.size() < num) {
            Worker worker = iterator.next();
            if (worker.getDepartmentNumber() == departmentNumber) {
                toBeFired.add(worker);
                iterator.remove();
            }
        }

        System.out.println("Fired " + num + " youngest employee(s) from department " + departmentNumber + ":");
        for (Worker worker : toBeFired) {
            System.out.println(worker);
        }
    }

    public void deleteEmployees(List<Delete> toBeDeleted) {
        for (Delete delete : toBeDeleted) {
            Iterator<Worker> iterator = workers.iterator();
            while (iterator.hasNext()) {
                Worker worker = iterator.next();
                if (worker.getName().equals(delete.getName()) && worker.getDepartmentNumber() == delete.getDepartmentNumber()) {
                    iterator.remove();
                    break;
                }
            }
        }

        System.out.println("Deleted employees based on the provided list.");
    }

    private static class Worker {
        private String name;
        private int departmentNumber;
        private int yearOfWorkStart;

        public Worker(String name, int departmentNumber, int yearOfWorkStart) {
            this.name = name;
            this.departmentNumber = departmentNumber;
            this.yearOfWorkStart = yearOfWorkStart;
        }

        public String getName() {
            return name;
        }

        public int getDepartmentNumber() {
            return departmentNumber;
        }

        public int getYearOfWorkStart() {
            return yearOfWorkStart;
        }

        @Override
        public String toString() {
            return "Worker{name='" + name + "', departmentNumber=" + departmentNumber + ", yearOfWorkStart=" + yearOfWorkStart + '}';
        }
    }

    private static class Delete {
        private String name;
        private int departmentNumber;

        public Delete(String name, int departmentNumber) {
            this.name = name;
            this.departmentNumber = departmentNumber;
        }

        public String getName() {
            return name;
        }

        public int getDepartmentNumber() {
            return departmentNumber;
        }
    }
}






public class RecursiveOperations {

    public static boolean nothingInCommon(char[] chars, String str) {
        return nothingInCommon(chars, str, 0);
    }

    private static boolean nothingInCommon(char[] chars, String str, int index) {
        if (index == chars.length) {
            return true;
        }

        char currentChar = chars[index];
        if (str.indexOf(currentChar) != -1) {
            return false;
        }

        return nothingInCommon(chars, str, index + 1);
    }

    public static void main(String[] args) {
        char[] chars1 = {'a', 'b', 'c'};
        String str1 = "defg";
        System.out.println("Result for chars1: " + nothingInCommon(chars1, str1));

        char[] chars2 = {'x', 'y', 'z'};
        String str2 = "abc";
        System.out.println("Result for chars2: " + nothingInCommon(chars2, str2));
    }
}
