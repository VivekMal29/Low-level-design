package Entities;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Player {
    public int id;
    public String name;
    public int curPosition;
    public List<String> stepsTaken = new ArrayList<>();

    public Player(int id, String name, int curPosition) {
        this.id = id;
        this.name = name;
        this.curPosition = curPosition;
    }
}
