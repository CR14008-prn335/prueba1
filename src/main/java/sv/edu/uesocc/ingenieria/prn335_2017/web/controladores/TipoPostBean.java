/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.edu.uesocc.ingenieria.prn335_2017.web.controladores;

import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import org.primefaces.event.SelectEvent;
import sv.edu.uesocc.ingenieria.prn335_2017.datos.acceso.GenericFacadeLocal;
import sv.edu.uesocc.ingenieria.prn335_2017.datos.acceso.TipoPostFacadeLocal;
import sv.edu.uesocc.ingenieria.prn335_2017.datos.definiciones.TipoPost;
/**
 *
 * @author carlos
 */
@Named(value = "tipoPostBean")
@ViewScoped
public class TipoPostBean extends GenericManagedBean<TipoPost> implements Serializable{

    /**
     * Creates a new instance of TipoPostBean
     */
    public TipoPostBean() {
    }
    @EJB
    TipoPostFacadeLocal facade;
    TipoPost tipoEntity;
    boolean mostrar = false, crudBtns=true;  
    
    
    // <editor-fold defaultstate="collapsed" desc="Getters y Setters">
    public TipoPostFacadeLocal getFacade() {
        return facade;
    }

    public boolean isMostrar() {
        return mostrar;
    }

    public boolean isCrudBtns() {
        return crudBtns;
    }

    public void setCrudBtns(boolean crudBtns) {
        this.crudBtns = crudBtns;
    }

    public void setMostrar(boolean mostrar) {
        this.mostrar = mostrar;
    }

    public void setFacade(TipoPostFacadeLocal facade) {
        this.facade = facade;
    }

    public TipoPost getTipoPostEntity() {
        return tipoEntity;
    }

    public void setTipoPostEntity(TipoPost tipoEntity) {
        this.tipoEntity = tipoEntity;
    }

    public List<TipoPost> getListaDatos() {
        return listaDatos;
    }

    public void setListaDatos(List<TipoPost> listaDatos) {
        this.listaDatos = listaDatos;
    }
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="Overrrides">
    @Override
    public TipoPost getEntity() {
        return tipoEntity;
    }

    @Override
    protected GenericFacadeLocal<TipoPost> getFacadeLocal() {
        return facade;
    }

   @Override
    public void reset() {
        tipoEntity.setActivo(false);
        tipoEntity.setNombre(null);
        tipoEntity.setDescripcion(null);
        
    }

    @Override
    public void nuevo() {
        tipoEntity = new TipoPost();
        setMostrar(true);
        setCrudBtns(true);
    }
    
    @Override
    public void cancelar(){
        tipoEntity = new TipoPost();
        setMostrar(false);
        setCrudBtns(true);
    }
    
    // </editor-fold>

    @PostConstruct
    public void init() {
        llenarLista();
    }
    
    /**
     * Este metodo sirve para mostrar el la fila seleccionada en un formulario para ser editado o eliminado
     * @param event 
     */
    public void onRowSelect(SelectEvent event) {
        setCrudBtns(false);
        setMostrar(true);
    }
    
    
}
