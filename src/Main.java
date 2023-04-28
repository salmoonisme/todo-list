import java.util.Arrays;

public class Main {

    // make global variable to store todo list in an array
    public static String[] data = new String[5];

    // config input
    public static java.util.Scanner scanner = new java.util.Scanner(System.in);

    public static void main(String[] args) {
        viewShowTodoList();
    }

    // BUSINESS LOGIC
    // show todo list
    public static void showTodoList() {
        System.out.println("## TO DO LIST ##");
        for (int i = 0; i < data.length; i++) {
            String todo = data[i];
            int number = i + 1;

            // if not null, view the data
            if (todo != null) {
                System.out.println(number + ". " + todo);
            }
        }
    }
    // test case show todo list
    public static void testShowTodoList() {
        data[0] = "Mandi";
        data[1] = "Makan sate";
        showTodoList();
    }

    // add todo list
    public static void addTodoList(String value) {
        // check if the array data already full
        boolean full = true;
        for (int i = 0; i < data.length; i++) {
            if(data[i] == null) {
                full = false;
                break;
            }
        }

        // if full, resize the array
        if (full) {
            String[] temp = data;
            data = new String[data.length * 2];

            for (int i = 0; i < temp.length; i++) {
                data[i] = temp[i];
            }
        }

        // add new value to the array data todo list
        for (int i = 0; i < data.length; i++) {
            if (data[i] == null) {
                data[i] = value;
                break;
            }
        }
    }
    // test case add todo list
    public static void testAddTodoList() {
        for (int i = 0; i < 25; i ++) {
            addTodoList("To do list " + i);
        }
        showTodoList();
    }

    // remove todo list
    public static boolean removeTodolist(int number) {
        // check if the data exists
        if (( number - 1) >= data.length) {
            return false;
        } else if (data[number - 1] == null) {
            return false;
            // perform removing and ordering array index
        } else {
            for (int i = (number - 1); i < data.length; i++) {
                if (i == (data.length - 1)) {
                    data[i] = null;
                } else {
                    data[i] = data[i + 1];
                }
            }
            return true;
        }
    }
    // test remove todo list
    public static void testRemoveTodoList() {
        addTodoList("Satu");
        addTodoList("Dua");
        addTodoList("Tiga");
        addTodoList("Empat");
        addTodoList("Lima");

        var result = removeTodolist(10);
        System.out.println(result);

        result = removeTodolist(5);
        System.out.println(result);

        result = removeTodolist(2);
        System.out.println(result);

        showTodoList();
    }

    // input method
    public static String input(String info) {
        System.out.print(info + ": ");
        String data = scanner.nextLine();
        return data;
    }
    // test input method
    public static void testInput() {
        var name = input("Nama");
        System.out.println("Hi " + name);

        var channel = input("Channel");
        System.out.println(channel);
    }

    // VIEW LOGIC
    // show  view todo list
    public static void viewShowTodoList() {
        while (true) {
            showTodoList();

            System.out.println("MENU: ");
            System.out.println("1. Tambah");
            System.out.println("2. Hapus");
            System.out.println("X. Keluar ");

            var input = input("Pilih");
            if (input.equals("1")) {
                viewAddTodoList();
            } else if (input.equals("2")) {
                viewRemoveTodoList();
            } else if (input.equals("X")) {
              break;
            } else {
                System.out.println("404 Not Found");
            }
        }
    }
    // test show view todo list
    public static void testViewShowTodoList() {
        addTodoList("Satu");
        addTodoList("Dua");
        addTodoList("Tiga");
        addTodoList("Empat");
        viewShowTodoList();
    }

    public static void viewAddTodoList() {
        System.out.println("## MENAMBAH TO DO LIST ##");

        String todo = input("Todo (X jika batal)");
        if (todo.equals("X")) {
            // nothing happened
        } else {
            addTodoList(todo);
        }
    }
    // test view add todo list
    public static void testViewAddTodoList() {
        addTodoList("Satu");
        addTodoList("Dua");
        addTodoList("Tiga");

        viewAddTodoList();
        showTodoList();
    }

    public static void viewRemoveTodoList() {
        System.out.println("## REMOVE TO DO LIST ##");
        showTodoList();
        String number = (input("Input nomor (X jika batal)"));

        if (number.equals("X")) {
            // nothing happened
        } else {
            int num = Integer.parseInt(number);
            removeTodolist(num);
        }
    }
    // test view remove todo list
    public static void testViewRemoveTodoList() {
        addTodoList("Satu");
        addTodoList("Dua");
        addTodoList("Tiga");

        showTodoList();

        viewRemoveTodoList();

        showTodoList();
    }
}