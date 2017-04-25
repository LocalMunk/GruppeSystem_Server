/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Server;

import brugerautorisation.data.Bruger;
import Data.Projekt;
import Data.Opgave;
import Data.Aftale;
import java.net.MalformedURLException;
import javax.jws.WebMethod;
import javax.jws.WebService;
import java.util.ArrayList;
import java.util.List;
import DALException.DALException;

/**
 *
 * @author elbosso
 */
@WebService
public interface ServerInterface {
   
   @WebMethod public Bruger login(int studienummer, String password)  throws MalformedURLException;
   @WebMethod public List<Projekt> getProjekter(int studienummer) throws DALException;
   @WebMethod public List<Opgave> getOpgaver(int projektnummer, int studienummer)throws DALException;
   @WebMethod public List<Aftale> getAftaler(int projektnummer, int studienummer)throws DALException;
   @WebMethod public boolean CreateAftale(Aftale a, int studienummer, int projektnummer)throws DALException;
   @WebMethod public boolean CreateOpgave(Opgave a, int studienummer, int projektnummer)throws DALException;
   @WebMethod public boolean CreateProjekt(Projekt a, int studienummer)throws DALException;
   
}
