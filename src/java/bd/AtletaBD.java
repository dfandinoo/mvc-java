package bd;

import negocio.Atleta;
import servicio.DBManager;
import java.sql.ResultSet;
import java.util.ArrayList;

public class AtletaBD extends DBManager{
    
    public static AtletaBD mgr = new AtletaBD();

    public AtletaBD() {
    }

    @Override
    protected void addObject(ArrayList v, ResultSet rs) {
        v.add(new Atleta(rs));
    }
    
    public Atleta getItem(int id) {
        ArrayList v = executeQuery("select * from atleta where id="+ id + " ");
        if(v.size() > 0){
            return (Atleta) v.get(0);
        }
        return new Atleta();
    }
    
    public Atleta getAtleta(int cedula) {
        ArrayList v = executeQuery("select * from atleta where cedula="+cedula);
        if(v.size() > 0){
            return (Atleta) v.get(0);
        }
        return new Atleta();
    }
    
    public void save(Atleta atleta, Boolean valor){
        if(valor) {
            mgr.execute("insert into atleta(nombre, genero, cedula) values('"+
                    atleta.getNombre()+ "',"
                    + "'" + atleta.getGenero()+"',"
                    + "'" + atleta.getCedula()+"')");
        }else {
            mgr.execute("update atleta set nombre='" +atleta.getNombre()+
                    "' , genero= '" + atleta.getGenero()+ 
                    "' , cedula='" + atleta.getCedula()+
                    "' where id=" + atleta.getId() + "");
        }
    }
    
    public void saveDisciplinas (String disciplina, String cedulaatleta){
        mgr.execute("insert into disciplina(cedulaatleta, disciplina) values('"+cedulaatleta+"' , '"+disciplina+"'");
    }
    
    public void delete(Atleta atleta) {
        mgr.execute("delete from atleta where id = " + atleta.getId() + "" );
    }
    
    public ArrayList<Atleta> getAtletas() {
        ArrayList<Atleta> v = executeQuery("select nombre,genero,cedula from atleta");
        return v;
    }
    
    public ArrayList consultarAtletas(String campo, String valor){
        ArrayList v = executeQuery("select * from atleta where "+ campo+"="+valor+" ");
        return v;
    }
    
    public ArrayList consultarAtletasDelegacion(int id){
        ArrayList v = executeQuery("select * from atleta where id = "+ id);
        return v;
    }  
    
}
