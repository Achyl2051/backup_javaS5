/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Finance;

import jakarta.ejb.Remote;

/**
 *
 * @author tahir
 */
@Remote
public interface EjbTransac {
    double getSolde(String cin);
    String transferer(String cinsend,String cinreceive,String valeur,String solde,String ta,String tv);
}
