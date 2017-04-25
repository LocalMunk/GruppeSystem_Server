/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Server;

import Data.Aftale;
import Data.Opgave;
import Data.Projekt;
import DAO.AftaleDAL;
import DAO.BrugerDAL;
import DAO.GruppeDAL;
import DAO.OpgaveDAL;
import DAO.ProjektDAL;
import java.util.List;
import DALException.DALException;

import brugerautorisation.transport.soap.Brugeradmin;
import brugerautorisation.data.Bruger;
import javax.xml.ws.Service;
import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;

/**
 *
 * @author elbosso
 */
public class ServerImpl implements ServerInterface{
    
    AftaleDAL aftDal;
    BrugerDAL bruDal;
    GruppeDAL gruDal;
    OpgaveDAL opgDal;
    ProjektDAL proDal;

    public ServerImpl(AftaleDAL aftDal, BrugerDAL bruDal, GruppeDAL gruDal, OpgaveDAL opgDal, ProjektDAL proDal) {
        this.aftDal = aftDal;
        this.bruDal = bruDal;
        this.gruDal = gruDal;
        this.opgDal = opgDal;
        this.proDal = proDal;
    }
    
    
    public ServerImpl(){
        aftDal = new AftaleDAL();
        bruDal = new BrugerDAL();
        gruDal = new GruppeDAL();
        opgDal = new OpgaveDAL();
        proDal = new ProjektDAL();
    }

    @Override
    public Bruger login(int studienummer, String password) throws MalformedURLException{
        URL url = new URL("http://javabog.dk:9901/brugeradmin?wsdl");
        QName qname = new QName("http://soap.transport.brugerautorisation/", "BrugeradminImplService");
        Service service = Service.create(url, qname);
        Brugeradmin ba = service.getPort(Brugeradmin.class);
        try {
            brugerautorisation.data.Bruger b = ba.hentBruger(studienummer + "", password);
            return b;

        } catch (Exception e) {
            System.out.println("forkert brugernavn");

            e.printStackTrace();
        }

        return null;
    }

    @Override
    public List<Projekt> getProjekter(int studienummer) throws DALException{
        return proDal.getProjektList(studienummer);
    }

    @Override
    public List<Opgave> getOpgaver(int projektnummer, int studienummer) throws DALException{
        return opgDal.getOpgaveList(projektnummer);
    }

    @Override
    public List<Aftale> getAftaler(int projektnummer, int studienummer) throws DALException{
        return aftDal.getAftaleList(projektnummer);
    }

    @Override
    public boolean CreateAftale(Aftale a, int studienummer, int projektnummer)throws DALException {
        aftDal.createAftale(a, projektnummer);
        return true;
    }

    @Override
    public boolean CreateOpgave(Opgave a, int studienummer, int projektnummer) throws DALException{
        opgDal.createOpgave(a, projektnummer);
        return true;
    }

    @Override
    public boolean CreateProjekt(Projekt a, int studienummer) throws DALException{
        proDal.createProjekt(a, studienummer);
        return true;
    }
    
}
