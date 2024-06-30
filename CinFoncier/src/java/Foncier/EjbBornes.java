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
public interface EjbBornes {
    ArrayList<Bornes> getBornes(String id);
    void insertBornes(int idTerre,double latitude, double longitude);
    double calculerAire(ArrayList<Double> latitudes,ArrayList<Double> longitudes);
    double getPerimetre(ArrayList<Double> latitudes, ArrayList<Double> longitudes);
}
