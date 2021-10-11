package social;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Timeline {
    private final ObservableList<String> list = FXCollections.observableArrayList();

    public ObservableList<String> getItems() {
        return FXCollections.unmodifiableObservableList(list);
    }

    public void post(String post) {
        list.add(post);
    }
}