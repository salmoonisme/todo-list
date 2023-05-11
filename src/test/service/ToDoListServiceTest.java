package test.service;

import entity.ToDoList;
import repository.ToDoListRepository;
import repository.ToDoListRepositoryImpl;
import service.ToDoListService;
import service.ToDoListServiceImpl;

public class ToDoListServiceTest {
    public static void main(String[] args) {
//        testShowToDoList();
//        testAddToDoList();
//        testRemoveToDoList();
    }
    public static void testShowToDoList() {
        ToDoListRepositoryImpl toDoListRepository = new ToDoListRepositoryImpl();
        toDoListRepository.data[0] = new ToDoList("Main badminton");
        toDoListRepository.data[1] = new ToDoList("Potong rambut");

        ToDoListService toDoListService = new ToDoListServiceImpl(toDoListRepository);

        toDoListService.showToDoList();
    }
    public static void testAddToDoList() {
        ToDoListRepository toDoListRepository = new ToDoListRepositoryImpl();
        ToDoListService toDoListService = new ToDoListServiceImpl(toDoListRepository);

        toDoListService.addToDoList("Belajar Java Dasar");
        toDoListService.addToDoList("Membajak sawah");

        toDoListService.showToDoList();
    }
    public static void testRemoveToDoList() {
        ToDoListRepository toDoListRepository = new ToDoListRepositoryImpl();
        ToDoListService toDoListService = new ToDoListServiceImpl(toDoListRepository);

        toDoListService.addToDoList("Belajar Java Dasar");
        toDoListService.addToDoList("Membajak sawah");

        toDoListService.showToDoList();

        toDoListService.removeToDoList(5);
        toDoListService.removeToDoList(2);

        toDoListService.showToDoList();

    }
}
