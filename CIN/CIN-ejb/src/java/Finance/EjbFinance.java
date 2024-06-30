/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Finance;

import jakarta.ejb.Remote;
import java.util.ArrayList;

/**
 *
 * @author tahir
 */
@Remote
public interface EjbFinance {
    Banque getBanque(String cin);
}
