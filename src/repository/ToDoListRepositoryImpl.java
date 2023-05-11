package repository;

import entity.ToDoList;

public class ToDoListRepositoryImpl implements ToDoListRepository{
    public ToDoList[] data = new ToDoList[10];


    @Override
    public ToDoList[] getAll() {
        return data;
    }

    public boolean isFull(){
        boolean full = true;
        for (int i = 0; i < data.length; i++) {
            if(data[i] == null) {
                full = false;
                break;
            }
        }
        return full;
    }

    public void resizeIfFull() {
        // if full, resize the array
        if (isFull()) {
            var temp = data;
            data = new ToDoList[data.length * 2];

            for (int i = 0; i < temp.length; i++) {
                data[i] = temp[i];
            }
        }
    }
    @Override
    public void add(ToDoList toDoList) {
        resizeIfFull();
        // add new value to the array data list
        for (int i = 0; i < data.length; i++) {
            if (data[i] == null) {
                data[i] = toDoList;
                break;
            }
        }
    }

    @Override
    public boolean remove(Integer number) {
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
}
