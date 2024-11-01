package org.juliangranda.apiservlet.webapp.headers.models;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import jakarta.inject.Inject;
import org.juliangranda.apiservlet.webapp.headers.configs.CarroCompra;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;

@CarroCompra
public class Carro implements Serializable {
    private List<ItemCarro> items;

    @Inject
    private transient Logger log;

    @PostConstruct
    public void inicializar(){
        //@PostConstruct se utiliza para inicializar algo en vez de utilizar un contructor
        //y este significa despues de un constructor
        this.items = new ArrayList<>();
        log.info("inicializando el carro de compras");
    }

    @PreDestroy
    public void destruir(){
        log.info("destruyendo el carro de compra");
    }
    public void addItemCarro(ItemCarro itemCarro) {
        if (items.contains(itemCarro)) {
            Optional<ItemCarro> optionalItemCarro = items.stream()
                    .filter(i -> i.equals(itemCarro))
                    .findAny();
            if (optionalItemCarro.isPresent()) {
                ItemCarro i = optionalItemCarro.get();
                i.setCantidad(i.getCantidad()+1);
            }
        } else {
            this.items.add(itemCarro);
        }
    }
    public List<ItemCarro> getItems() {
        return items;
    }

    public int getTotal() {
        return items.stream().mapToInt(ItemCarro::getImporte).sum();
    }
}
