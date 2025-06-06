package com.bolsadeideas.springboot.app.paginator;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.domain.Page;

//se encarga de calcular parametros muy importantes se encarga de calcular como:
//elementosPorPagina con el size(), numero total paginas y 
//desde donde hasta donde se va a mostrar(paginas/elementos).

public class PageRender<T> {
	//paginar lista de productos o clientes.
	
	private String url;
	private Page<T> page;
	
	private int totalPaginas;
	
	private int numElementosPorPagina;
	
	private int paginaActual;
	
	private List<PageItem> paginas;
	
	public PageRender(String url, Page<T> page) {
		this.url = url;
		this.page = page;
		this.paginas = new ArrayList<PageItem>();
		
		//size() = contiene la pagina de elementos por pagina.
		//size declarado en controller
		numElementosPorPagina = page.getSize();
		totalPaginas = page.getTotalPages();
		//pageNumber(toma el valor por defecto en controller.)
		paginaActual = page.getNumber() + 1;
		
		int desde, hasta;
		if (totalPaginas <= numElementosPorPagina) {
			desde = 1;
			hasta = totalPaginas;
		}else {
			if (paginaActual <= numElementosPorPagina / 2) {
				desde = 1;
				hasta = numElementosPorPagina;
			} else if (paginaActual >= totalPaginas - numElementosPorPagina / 2) {
				desde = totalPaginas - numElementosPorPagina + 1;
				hasta = numElementosPorPagina;
			} else {
				desde = paginaActual - numElementosPorPagina / 2;
				hasta = numElementosPorPagina;
			}
		}
		//paginas que se van a mostrar en el paginador.
		for(int i=0;i < hasta; i++) {
			paginas.add(new PageItem(desde + i, paginaActual == desde + i));
			
		}
		
	}

	public String getUrl() {
		return url;
	}

	public int getTotalPaginas() {
		return totalPaginas;
	}

	public int getPaginaActual() {
		return paginaActual;
	}

	public List<PageItem> getPaginas() {
		return paginas;
	}
	
	//primera pagina
	public boolean isFirst() {
		return page.isFirst();
	}
	
	//ultima pagina
	public boolean isLast() {
		return page.isLast();
	}
	
	//avanzar de pagina de uno en uno.
	public boolean isHasNext() {
		return page.hasNext();
	}
	
	//retroceder de pagina
	public boolean isHasPrevious() {
		return page.hasPrevious();
	}
}
