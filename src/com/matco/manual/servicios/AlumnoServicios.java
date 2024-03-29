package com.matco.manual.servicios;

import java.util.List;

import javax.ws.rs.*;
import javax.ws.rs.core.*;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

import com.matco.manual.facade.AlumnoFacade;
import com.matco.manual.entity.Alumno;


@XmlAccessorType(XmlAccessType.NONE)
@XmlRootElement(name = "alumnoServicio")
@Path("alumnoServicio")
public class AlumnoServicios extends Generic{
    
    AlumnoFacade alumnoFacade = new AlumnoFacade(archivoConfiguracionServicio);
    
    @POST
    @Path("guardarAlumno")
    @Produces(MediaType.APPLICATION_JSON)
    public Alumno guardarAlumno(Alumno tmp) throws Exception {
        int mat = alumnoFacade.guardarAlumno(tmp);
        System.out.println("Hasta aqui todo bien");
        return alumnoFacade.obtenerAlumnoPorMatricula(mat);
    }
    
    @PUT
    @Path("modificarAlumno")
    public void modificarAlumno(Alumno tmp) throws Exception {
        alumnoFacade.modificarAlumno(tmp);
    }
    
    @DELETE
    @Path("eliminarAlumno")
    public void eliminarAlumno(@QueryParam("matricula") int matricula) throws Exception {
        Alumno tmp = new Alumno();
        tmp.setMatricula(matricula);
        alumnoFacade.eliminarAlumno(tmp);
    }
    
    @GET
    @Path("obtenerTodosAlumnos")
    @Produces(MediaType.APPLICATION_JSON)
    public List <Alumno> obtenerTodosAlumnos() throws Exception {
        List<Alumno> res = alumnoFacade.obtenerTodosAlumnos();
        return res;
    }
}