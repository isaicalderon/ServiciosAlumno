package com.matco.manual.controller;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.PropertyConfigurator;

public class Log4jInit extends HttpServlet{

    /**
     * Gestor de consola de la aplicacion
     */
	
    private static final long serialVersionUID = -1267172923511440093L;

    public void init() {
        String file = getInitParameter("log4j-init-file");
        if (file!=null) {
            PropertyConfigurator.configure(file);
        }
    }
    
    public void doGet(HttpServletRequest req, HttpServletResponse res) {
        
    }
}