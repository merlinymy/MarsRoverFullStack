package com.example.merlin.marsproject.Response;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;
import java.util.List;

public class MarsPhoto {
    private Long id;
    private Integer sol;
    private MarsCamera camera;
    //map json to Java
    @JsonProperty("img_src")
    private String imgSrc;
    @JsonProperty("earth_date")
    private Date earthDate;
    private Rover rover;

    public Date getEarthDate() {
        return earthDate;
    }

    public void setEarthDate(Date earthDate) {
        this.earthDate = earthDate;
    }

    public Rover getRover() {
        return rover;
    }

    public void setRover(Rover rover) {
        this.rover = rover;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getSol() {
        return sol;
    }

    public void setSol(Integer sol) {
        this.sol = sol;
    }

    public MarsCamera getCamera() {
        return camera;
    }

    public void setCamera(MarsCamera camera) {
        this.camera = camera;
    }

    public String getImgSrc() {
        return imgSrc;
    }

    public void setImgSrc(String imgSrc) {
        this.imgSrc = imgSrc;
    }

    @Override
    public String toString() {
        return "MarsPhoto{" +
                "id=" + id +
                ", sol=" + sol +
                ", camera=" + camera +
                ", imgSrc='" + imgSrc + '\'' +
                '}';
    }
}
