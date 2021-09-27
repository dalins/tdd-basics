package social;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Timeline {
    ObservableList<String> list = FXCollections.observableArrayList();

    public ObservableList<String> getItems() {
        return list;
    }

    public void post(String post) {
        list.add(post);
    }
    
}
