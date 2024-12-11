package tn.rnu.isetr.myapplication.controleur;

import android.content.Context;

import java.util.Date;

import tn.rnu.isetr.myapplication.modele.AccessLocal;
import tn.rnu.isetr.myapplication.modele.Profil;
import tn.rnu.isetr.myapplication.outils.Serializer;

public class Controle {

    private static Controle instance= null;
    private static  Profil profil;
    private static  String nomPic="saveprofil";
    private static AccessLocal accesLocal;
    private Controle () {
        super () ;
    }

    /** creation de l'instance
     *
     * @return
     */
    public static final Controle getInstance (Context contexte) {
            if (Controle.instance == null) {
                Controle.instance = new Controle ();
                accesLocal=new AccessLocal(contexte);
                profil = accesLocal.recupDernier();
                //recuperSerialize(contexte);
            }
             return Controle.instance;
    }

    /**
     * creation du profil
     * @param poids
     * @param taille en cm
     * @param age
     * @param sexe 1 pour homme 0 pour femme
     */
    public void creerProfil (Integer poids, Integer taille, Integer age, Integer sexe, Context contexte){
        profil = new Profil(new Date(),poids, taille, age, sexe);
       accesLocal.ajout(profil);
        // Serializer.serialize(nomPic,profil,contexte);
    }

    /** recuperation img de profile
     *
     * @return
     */
    public float getImg(){
        return profil.getImg();
    }

    /** recuperation message de profile
     *
     * @return
     */
    public String  getMessage(){
        return profil.getMessage();
    }
    private static void   recuperSerialize(Context contexte){
        profil =(Profil)Serializer.deSerialize(nomPic,contexte);
    }
    public Integer getPoids(){
        if(profil == null){
            return null;
        }
        else{
            return profil.getPoids();
        }
    }
    public Integer getTaille(){
        if(profil == null){
            return null;
        }
        else{
            return profil.getTaille();
        }
    }
    public Integer getAge(){
        if(profil == null){
            return null;
        }
        else{
            return profil.getAge();
        }
    }
    public Integer getSexe(){
        if(profil == null){
            return null;
        }
        else{
            return profil.getSexe();
        }
    }


}
