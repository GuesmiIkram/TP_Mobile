package tn.rnu.isetr.app_solaire;

public class Planete {
    private String nom;
    private int photoResId;
    private String distanceSoleil;
    private String masse;
    private String periodeRevolution;

    public Planete(String nom, int photoResId, String distanceSoleil, String masse, String periodeRevolution) {
        this.nom = nom;
        this.photoResId = photoResId;
        this.distanceSoleil = distanceSoleil;
        this.masse = masse;
        this.periodeRevolution = periodeRevolution;
    }

    public String getNom() { return nom; }
    public int getPhotoResId() { return photoResId; }
    public String getDistanceSoleil() { return distanceSoleil; }
    public String getMasse() { return masse; }
    public String getPeriodeRevolution() { return periodeRevolution; }
}
