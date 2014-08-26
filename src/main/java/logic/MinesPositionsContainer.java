package logic;

import java.util.ArrayList;

public class MinesPositionsContainer {
    private ArrayList<Integer> container = new ArrayList<Integer>();

    public void add(Integer position){
        container.add(position);
    }

    public Integer get(Integer index){
        return container.get(index);
    }

    public boolean contains(Integer position){
        return container.contains(position);
    }

    public Integer size(){
        return container.size();
    }
}
