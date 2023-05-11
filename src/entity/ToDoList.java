package entity;

public class ToDoList {
    private String todo;

    // non argument constructor
    public ToDoList() {
    }

    // with String argument
    public ToDoList(String todo) {
        this.todo = todo;
    }

    // getter & setter
    public String getTodo() {
        return todo;
    }
    public void setTodo(String todo) {
        this.todo = todo;
    }
}
