/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Foncier;

import jakarta.ejb.Remote;
import java.util.ArrayList;

/**
 *
 * @author tahir
 */
@Remote
public interface EjbDevis {
    ArrayList<Devis> getDevis();
    Devis getDevi(String id);
}
