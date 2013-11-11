/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package net.daw.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import net.daw.bean.ActividadOfflineBean;
import net.daw.data.Mysql;
import net.daw.helper.Enum;
import java.sql.Date;

/**
 *
 * @author mati
 */
public class ActividadOfflineDao {
    
    private Mysql oMysql;
     private Enum.Connection enumTipoConexion;
 
     public ActividadOfflineDao(net.daw.helper.Enum.Connection tipoConexion) throws Exception {
         oMysql = new Mysql();
         enumTipoConexion = tipoConexion;
     }
    
     
         public int getPages(int intRegsPerPag, HashMap<String, String> hmFilter, HashMap<String, String> hmOrder) throws Exception {
         int pages;
         try {
             oMysql.conexion(enumTipoConexion);
             pages = oMysql.getPages("actividadoffline", intRegsPerPag, hmFilter, hmOrder);
             oMysql.desconexion();
             return pages;
         } catch (Exception e) {
             throw new Exception("ActividadOfflineDao.getPages: Error: " + e.getMessage());
         } finally {
             oMysql.desconexion();
         }
     }
         
         
        public ArrayList<ActividadOfflineBean> getPage(int intRegsPerPag, int intPage, HashMap<String, String> hmFilter, HashMap<String, String> hmOrder) throws Exception {
         ArrayList<Integer> arrId;
         ArrayList<ActividadOfflineBean> arrActividadesOffline = new ArrayList<>();
         try {
             oMysql.conexion(enumTipoConexion);
             arrId = oMysql.getPage("actividadoffline", intRegsPerPag, intPage, hmFilter, hmOrder);
             Iterator<Integer> iterador = arrId.listIterator();
             while (iterador.hasNext()) {
                 ActividadOfflineBean oActividadOfflineBean = new ActividadOfflineBean(iterador.next());
                 arrActividadesOffline.add(this.get(oActividadOfflineBean));
             }
             oMysql.desconexion();
             return arrActividadesOffline;
         } catch (Exception e) {
             throw new Exception("ActividadOfflineDao.getPage: Error: " + e.getMessage());
         } finally {
             oMysql.desconexion();
         }
     }
        
        
        public ArrayList<String> getNeighborhood(String strLink, int intPageNumber, int intTotalPages, int intNeighborhood) throws Exception {
         oMysql.conexion(enumTipoConexion);
         ArrayList<String> n = oMysql.getNeighborhood(strLink, intPageNumber, intTotalPages, intNeighborhood);
         oMysql.desconexion();
         return n;
     }
    
        
        public ActividadOfflineBean get(ActividadOfflineBean oActividadOfflineBean) throws Exception {
         try {
             oMysql.conexion(enumTipoConexion);
             oActividadOfflineBean.setEnunciado(oMysql.getOne("actividadoffline", "enunciado", oActividadOfflineBean.getId()));
             oActividadOfflineBean.setFecha(Date.valueOf(oMysql.getOne("actividadoffline", "fecha", oActividadOfflineBean.getId())));
             oActividadOfflineBean.setCalificacion(Double.valueOf(oMysql.getOne("actividadoffline", "calificacion", oActividadOfflineBean.getId())));
             oActividadOfflineBean.setEvaluacion(Integer.valueOf(oMysql.getOne("actividadoffline", "evaluacion", oActividadOfflineBean.getId())));
             oActividadOfflineBean.setActivo(Boolean.valueOf(oMysql.getOne("actividadoffline", "activo", oActividadOfflineBean.getId())));
           
             oMysql.desconexion();
         } catch (Exception e) {
             throw new Exception("ActividadOfflineDao.getCliente: Error: " + e.getMessage());
         } finally {
             oMysql.desconexion();
         }
         return oActividadOfflineBean;
     }
        
        
         public void set(ActividadOfflineBean oActividadOfflineBean) throws Exception {
         try {
            oMysql.conexion(enumTipoConexion);
             oMysql.initTrans();
             if (oActividadOfflineBean.getId() == 0) {
                 oActividadOfflineBean.setId(oMysql.insertOne("actividadoffline"));
             }
             oMysql.updateOne(oActividadOfflineBean.getId(), "actividadoffline", "enunciado", oActividadOfflineBean.getEnunciado());
             oMysql.updateOne(oActividadOfflineBean.getId(), "actividadoffline", "fecha", (oActividadOfflineBean.getFecha().toString()));
             oMysql.updateOne(oActividadOfflineBean.getId(), "actividadoffline", "calificacion", Double.toString(oActividadOfflineBean.getCalificacion()));
             oMysql.updateOne(oActividadOfflineBean.getId(), "actividadoffline", "evaluacion", Integer.toString(oActividadOfflineBean.getEvaluacion()));
             oMysql.updateOne(oActividadOfflineBean.getId(), "actividadoffline", "activo", Boolean.toString(oActividadOfflineBean.isActivo()));
             oMysql.commitTrans();
         } catch (Exception e) {
             oMysql.rollbackTrans();
             throw new Exception("ActividadOfflineDao.setCliente: Error: " + e.getMessage());
         } finally {
             oMysql.desconexion();
         }
     }
         
          public void remove(ActividadOfflineBean oActividadOfflineBean) throws Exception {
         try {
             oMysql.conexion(enumTipoConexion);
             oMysql.removeOne(oActividadOfflineBean.getId(), "actividadoffline");
             oMysql.desconexion();
         } catch (Exception e) {
             throw new Exception("ActividadOfflineDao.removeAlumno: Error: " + e.getMessage());
         } finally {
             oMysql.desconexion();
         }
     }
        
        
        
    
    
}
