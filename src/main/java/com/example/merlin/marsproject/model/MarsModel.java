package com.example.merlin.marsproject.model;

import javax.persistence.*;

@Entity
@Table(name = "mars_api_preferences")
public class MarsModel {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long userId;
    @Column(length = 20)
    private String roverName;
    private Integer sol;

    private Boolean camFhaz;
    private Boolean camRhaz;
    private Boolean camMast;
    private Boolean camChemcam;
    private Boolean camMahli;
    private Boolean camMardi;
    private Boolean camNavcam;
    private Boolean camPancam;
    private Boolean camMinites;
    private Boolean savePref;


    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public Boolean getSavePref() {
        return savePref;
    }

    public void setSavePref(Boolean savePref) {
        this.savePref = savePref;
    }

    public String getRoverName() {
        return roverName;
    }

    public void setRoverName(String roverName) {
        this.roverName = roverName;
    }

    public Integer getSol() {
        return sol;
    }

    public void setSol(Integer sol) {
        this.sol = sol;
    }

    public Boolean getCamFhaz() {
        return camFhaz;
    }

    public void setCamFhaz(Boolean camFhaz) {
        this.camFhaz = camFhaz;
    }

    public Boolean getCamRhaz() {
        return camRhaz;
    }

    public void setCamRhaz(Boolean camRhaz) {
        this.camRhaz = camRhaz;
    }

    public Boolean getCamMast() {
        return camMast;
    }

    public void setCamMast(Boolean camMast) {
        this.camMast = camMast;
    }

    public Boolean getCamChemcam() {
        return camChemcam;
    }

    public void setCamChemcam(Boolean camChemcam) {
        this.camChemcam = camChemcam;
    }

    public Boolean getCamMahli() {
        return camMahli;
    }

    public void setCamMahli(Boolean camMahli) {
        this.camMahli = camMahli;
    }

    public Boolean getCamMardi() {
        return camMardi;
    }

    public void setCamMardi(Boolean camMardi) {
        this.camMardi = camMardi;
    }

    public Boolean getCamNavcam() {
        return camNavcam;
    }

    public void setCamNavcam(Boolean camNavcam) {
        this.camNavcam = camNavcam;
    }

    public Boolean getCamPancam() {
        return camPancam;
    }

    public void setCamPancam(Boolean camPancam) {
        this.camPancam = camPancam;
    }

    public Boolean getCamMinites() {
        return camMinites;
    }

    public void setCamMinites(Boolean camMinites) {
        this.camMinites = camMinites;
    }

    @Override
    public String toString() {
        return "MarsModel{" +
                "userId=" + userId +
                ", roverName='" + roverName + '\'' +
                ", sol=" + sol +
                ", camFhaz=" + camFhaz +
                ", camRhaz=" + camRhaz +
                ", camMast=" + camMast +
                ", camChemcam=" + camChemcam +
                ", camMahli=" + camMahli +
                ", camMardi=" + camMardi +
                ", camNavcam=" + camNavcam +
                ", camPancam=" + camPancam +
                ", camMinites=" + camMinites +
                ", savePref=" + savePref +
                '}';
    }
}
