package test.view;

import repository.ToDoListRepository;
import repository.ToDoListRepositoryImpl;
import service.ToDoListService;
import service.ToDoListServiceImpl;
import view.ToDoListView;

public class ToDoListViewTest {
    public static void main(String[] args) {
//        testShowToDoList();
//        testAddToDoList();
        testRemoveToDoList();
    }
    public static void testShowToDoList() {
        ToDoListRepository toDoListRepository = new ToDoListRepositoryImpl();
        ToDoListService toDoListService = new ToDoListServiceImpl(toDoListRepository);
        ToDoListView toDoListView = new ToDoListView(toDoListService);

        toDoListService.addToDoList("Belajar catur");
        toDoListService.addToDoList("Berenang");

        toDoListView.showToDoList();

    }
    public static void testAddToDoList() {
        ToDoListRepository toDoListRepository = new ToDoListRepositoryImpl();
        ToDoListService toDoListService = new ToDoListServiceImpl(toDoListRepository);
        ToDoListView toDoListView = new ToDoListView(toDoListService);

        toDoListService.showToDoList();
        toDoListView.addToDoList();
        toDoListService.showToDoList();
    }   public static void testRemoveToDoList() {
        ToDoListRepository toDoListRepository = new ToDoListRepositoryImpl();
        ToDoListService toDoListService = new ToDoListServiceImpl(toDoListRepository);
        ToDoListView toDoListView = new ToDoListView(toDoListService);

        toDoListService.addToDoList("Belajar catur");
        toDoListService.addToDoList("Berenang");

        toDoListService.showToDoList();
        toDoListView.removeToDoList();
        toDoListService.showToDoList();
    }
}
