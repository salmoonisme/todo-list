package service;

import entity.ToDoList;
import repository.ToDoListRepository;

public class ToDoListServiceImpl implements ToDoListService{
    private ToDoListRepository toDoListRepository;

    public ToDoListServiceImpl(ToDoListRepository toDoListRepository) {
        this.toDoListRepository = toDoListRepository;
    }

    @Override
    public void showToDoList() {
        ToDoList[] data = toDoListRepository.getAll();

        System.out.println("## TO DO LIST ##");
        for (int i = 0; i < data.length; i++) {
            var todo = data[i];
            int number = i + 1;

            // if not null, view the data
            if (todo != null) {
                System.out.println(number + ". " + todo.getTodo());
            }
        }
    }

    @Override
    public void addToDoList(String todo) {
        ToDoList toDoList = new ToDoList(todo);
        toDoListRepository.add(toDoList);
        System.out.println("Sukses add ToDoList: " + todo);
    }

    @Override
    public void removeToDoList(Integer number) {
        boolean success = toDoListRepository.remove(number);
        if (success) {
            System.out.println("Sukses remove list: " + number);
        } else {
            System.out.println("Gagal remove");
        }
    }
}
