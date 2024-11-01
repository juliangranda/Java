package org.juliangranda.apiservlet.webapp.headers.filters;

import jakarta.inject.Inject;
import jakarta.inject.Named;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletResponse;
import org.juliangranda.apiservlet.webapp.headers.configs.MysqlConn;
import org.juliangranda.apiservlet.webapp.headers.services.ServiceJdbcException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

@WebFilter("/*")
public class ConexionFilter implements Filter {

    @Inject
    @MysqlConn
    private Connection conn;

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

        try(Connection connRequest = this.conn) {

            if (connRequest.getAutoCommit()) {
                connRequest.setAutoCommit(false);
            }
            try {
                //guardar la conexion de la base de datos.
                //request.setAttribute("conn",connRequest);
                //doFilter es cuando se devuelve la llamada a un doPost o doGet
                chain.doFilter(request, response);
                connRequest.commit();
            }catch (SQLException | ServiceJdbcException e){
                connRequest.rollback();
                ((HttpServletResponse)response).sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, e.getMessage());
                throw  new RuntimeException(e);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
