package tn.rnu.isetr.myapplication.modele;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import java.util.Date;
import tn.rnu.isetr.myapplication.outils.MySQLiteOpenHelper;

public class AccessLocal {
    private String nomBase="bdCoach.sqlLte";
    private Integer versionBase=1;
    private MySQLiteOpenHelper accesBD;
    private SQLiteDatabase bd;

    public AccessLocal(Context contexte){
        accesBD= new MySQLiteOpenHelper(contexte,nomBase,null,versionBase);

    }
    public void ajout(Profil profil) {
        bd = accesBD.getWritableDatabase();
        String req = "insert into profil (datemesure, poids, taille, age, sexe) values";
        req += "(\"" + profil.getDateMesure() + "\"," + profil.getPoids() + "," + profil.getTaille() + "," + profil.getAge() + ",\"" + profil.getSexe() + "\")";
        bd.execSQL(req);
    }
public Profil recupDernier(){
        bd = accesBD.getReadableDatabase();
        Profil profil =null;
        String req="select * from profil";
        Cursor curseur =bd.rawQuery(req,null);
        curseur.moveToLast();
        if(!curseur.isAfterLast()){
            Date date =new Date();
            Integer poids =curseur.getInt(1);
            Integer taille =curseur.getInt(2);
            Integer age =curseur.getInt(3);
            Integer sexe =curseur.getInt(4);
            profil = new Profil(date,poids,taille,age,sexe);

        }
        curseur.close();
        return profil;
}

}
