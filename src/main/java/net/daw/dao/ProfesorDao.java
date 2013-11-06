/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package net.daw.dao;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import net.daw.data.Mysql;

/**
 *
 * @author Pedro Benito
 */
public class ProfesorDao {
    private final Mysql oMysql;
    private final net.daw.helper.Enum.Connection enumTipoConexion;
    
     public ProfesorDao(net.daw.helper.Enum.Connection tipoConexion) throws Exception {
        oMysql = new Mysql();
        enumTipoConexion = tipoConexion;
    }
   
    public int getPages(int intRegsPerPag,HashMap<String, String> hmFilter, HashMap<String, String> hmOrder) throws Exception {
        int pages;
        try {
            oMysql.conexion(enumTipoConexion);
            pages = oMysql.getPages("cliente", intRegsPerPag, hmFilter, hmOrder);
            oMysql.desconexion();
            return pages;
        } catch (Exception e) {
            throw new Exception("ClienteDao.getPages: Error: " + e.getMessage());
        }
    }

    public ArrayList<ClienteBean> getPage(int intRegsPerPag, int intPage,HashMap<String, String> hmFilter, HashMap<String, String> hmOrder) throws Exception {
        ArrayList<Integer> arrId;
        ArrayList<ClienteBean> arrCliente = new ArrayList<>();
        try {
            oMysql.conexion(enumTipoConexion);           
            arrId = oMysql.getPage("cliente", intRegsPerPag, intPage, hmFilter, hmOrder);
            Iterator<Integer> iterador = arrId.listIterator();
            while (iterador.hasNext()) {
                ClienteBean oClienteBean = new ClienteBean(iterador.next());
                arrCliente.add(this.get(oClienteBean));
            }
            oMysql.desconexion();
            return arrCliente;
        } catch (Exception e) {
            throw new Exception("ClienteDao.getPage: Error: " + e.getMessage());
        }
    }

    public ArrayList<String> getNeighborhood(String strLink, int intPageNumber, int intTotalPages, int intNeighborhood) throws Exception {
        oMysql.conexion(enumTipoConexion);
        ArrayList<String> n = oMysql.getNeighborhood(strLink, intPageNumber, intTotalPages, intNeighborhood);
        oMysql.desconexion();
        return n;
    }
    
    
    
}
