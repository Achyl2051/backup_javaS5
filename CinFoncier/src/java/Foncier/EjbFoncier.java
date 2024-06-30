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
public interface EjbFoncier {
    ArrayList<Terre> getTerre(String cin);
    int insertTerre(int cin, String terre_localisation, double superficie, double perimetre);
}
