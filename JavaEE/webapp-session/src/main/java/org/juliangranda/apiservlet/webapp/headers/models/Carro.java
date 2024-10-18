package org.juliangranda.apiservlet.webapp.headers.models;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Carro {
    private List<ItemCarro> items;

    public Carro() {
        this.items = new ArrayList<>();
    }

    public void addItem(ItemCarro itemCarro){
        if(items.contains(itemCarro)){
            Optional<ItemCarro> optionalItemCarro = items.stream()
                    .filter(i -> i.equals(itemCarro))
                    .findAny();
            if(optionalItemCarro.isPresent()){
                ItemCarro i = optionalItemCarro.get();
                i.setCantidad(i.getCantidad()+1);
            }
        }else{
            this.items.add(itemCarro);
        }
    }

    public List<ItemCarro> getItems() {
        return items;
    }

    public int getTotal(){
        //convertir un tipo stream de ItemCarro a un IntStream.
        return items.stream().mapToInt(ItemCarro::getImporte).sum();
    }
}
