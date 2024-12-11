package tn.rnu.isetr.myapplication.modele;

import junit.framework.TestCase;

public class profilTest extends TestCase {

    // Création de l'objet Profil
    private Profil profil = new Profil(67, 165, 35, 0);  // Femme, donc sexe = 0

    // Valeur attendue de l'IMG
    private float img = 32.2f;

    // Message attendu
    private String message = "trop élevé";

    // Test de la méthode getImg
    public void testGetImg() throws Exception {
        assertEquals(img, profil.getImg(), 0.1f);
    }

    // Test de la méthode getMessage
    public void testGetMessage() throws Exception {
        assertEquals(message, profil.getMessage());
    }
}
