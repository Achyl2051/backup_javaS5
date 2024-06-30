/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

/**
 *
 * @author tahir
 */
public class DetailResultat {
    int idDetail;
    int idResultat;
    int idCandidat;
    int nbrVote;

    public int getIdDetail() {
        return idDetail;
    }

    public void setIdDetail(int idDetail) {
        this.idDetail = idDetail;
    }

    public int getIdResultat() {
        return idResultat;
    }

    public void setIdResultat(int idResultat) {
        this.idResultat = idResultat;
    }

    public int getIdCandidat() {
        return idCandidat;
    }

    public void setIdCandidat(int idCandidat) {
        this.idCandidat = idCandidat;
    }

    public int getNbrVote() {
        return nbrVote;
    }

    public void setNbrVote(int nbrVote) {
        this.nbrVote = nbrVote;
    }

    public DetailResultat() {
    }

    public DetailResultat(int idDetail, int idResultat, int idCandidat, int nbrVote) {
        this.setIdDetail(idDetail);
        this.setIdResultat(idResultat);
        this.setIdCandidat(idCandidat);
        this.setNbrVote(nbrVote);
    }
    
}
