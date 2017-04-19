/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

/**
 *
 * @author elbosso
 */
public class ProjektDAL {
	public Projekt getProjekt(int id) throws DALException{
        ResultSet rs = Connector.doQuery("SELECT * FROM projekt WHERE id = ?", id);
        try {
            if (!rs.first())
                throw new DALException("projektet" + id + "findes ikke");
            
            return new Projekt(rs.getInt("id"), rs.getString("projectname"), rs.getString("projectdesc"), rs.getString("groupname"), rs.getInt("adminid"));
	}catch (SQLException e){
            throw new DALException(e);
        }
    }
	
	public List<Projekt> getProjektList(int personid) throws DALException{
        List<Projekt> list = new ArrayList<Projekt>();
		ResultSet rs = Connector.doQuery("SELECT * FROM projekt WHERE id = ?", personid);
                try{
                while (rs.next())   
			{
				list.add(new Projekt(rs.getInt("id"), rs.getString("projectname"), rs.getString("projectdesc"), rs.getString("groupname"), rs.getInt("adminid")));
			}
		}
		catch (SQLException e) { throw new DALException(e); }
		return list;
    }
	
	public void createProjekt(Projekt a, int personid) throws DALException{
        {
		Connector.doUpdate
		(
			"INSERT INTO projekt(id, projectname, projectdesc, groupname, adminid) VALUES (?,?,?,?,?)",
				a.getId(), a.getNavn(), a.getDesc(), a.getGruppeNavn(), a.getAdminid()
				);
	}
        
    }
	
	public void updateProjekt(Projekt a, int personid) throws DALException{
        
        {
		Connector.doUpdate(
				"UPDATE projekt SET projectname = ?,  projectdesc = ?, groupname = ?, adminid = ? WHERE id = ?",
				a.getId(), a.getNavn(), a.getDesc(), a.getGruppeNavn(), a.getAdminid()
				);
	} 
    }
    
}
