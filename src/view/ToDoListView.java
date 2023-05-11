package view;

import service.ToDoListService;
import util.InputUtil;

public class ToDoListView {
    private ToDoListService toDoListService;

    public ToDoListView(ToDoListService toDoListService) {
        this.toDoListService = toDoListService;
    }

    public void showToDoList(){
        while (true) {
            toDoListService.showToDoList();

            System.out.println("MENU: ");
            System.out.println("1. Tambah");
            System.out.println("2. Hapus");
            System.out.println("X. Keluar ");

            var input = InputUtil.input("Pilih");
            if (input.equals("1")) {
                addToDoList();
            } else if (input.equals("2")) {
                removeToDoList();
            } else if (input.equals("X")) {
                break;
            } else {
                System.out.println("404 Not Found");
            }
        }
    }
    public void addToDoList(){
        System.out.println("## MENAMBAH TO DO LIST ##");

        String todo = InputUtil.input("Todo (X jika batal)");
        if (todo.equals("X")) {
            // nothing happened
        } else {
            toDoListService.addToDoList(todo);
        }
    }
    public void removeToDoList(){
        System.out.println("## REMOVE TO DO LIST ##");
        String number = InputUtil.input("Input nomor (X jika batal)");

        if (number.equals("X")) {
            // nothing happened
        } else {
            int num = Integer.parseInt(number);
            toDoListService.removeToDoList(num);
        }
    }
}
