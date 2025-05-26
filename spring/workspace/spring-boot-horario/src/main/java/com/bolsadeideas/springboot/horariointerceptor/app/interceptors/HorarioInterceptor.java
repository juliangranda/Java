package com.bolsadeideas.springboot.horariointerceptor.app.interceptors;

import java.util.Calendar;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component("horario")
public class HorarioInterceptor implements HandlerInterceptor {
	
	@Value("${config.horario.apertura}")
	private Integer apertura;
	
	@Value("${config.horario.cierre}")
	private Integer cierre;

	//pasar o transferir datos durante el request
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		
		Calendar calendar = Calendar.getInstance();
		int hora = calendar.get(calendar.HOUR_OF_DAY);
		
		if(hora >= apertura && hora < cierre) {
			
			StringBuilder mensaje = new StringBuilder("Bienvenido al horario de atención al cliente");
			mensaje.append(", atendemos desde las ");
			mensaje.append(apertura);
			mensaje.append("hrs. ");
			mensaje.append("hasta las ");
			mensaje.append(cierre);
			mensaje.append("hrs. ");
			mensaje.append(", Gracias por su visita");
			request.setAttribute("mensaje", mensaje.toString());		
			return true;
		}
		//en caso de que sea false
		response.sendRedirect(request.getContextPath().concat("/cerrado"));
		return false;
		
	}

	//capturar/obtener el dato del prehandle en el posthandle
	//mandar a la vista con modelAndView
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		
		String mensaje = (String) request.getAttribute("mensaje");
		if(modelAndView != null && handler instanceof HandlerMethod) {
			modelAndView.addObject("horario", mensaje);
		}
	}

}
