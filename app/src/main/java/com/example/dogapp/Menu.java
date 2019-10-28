package com.example.dogapp;

public class Menu {
    private String nomMenu;
    private int imgMenu;

    public Menu(String nomMenu, int imgMenu) {
        this.nomMenu = nomMenu;
        this.imgMenu = imgMenu;
    }
    public Menu (){

    }

    public String getNomMenu() {
        return nomMenu;
    }

    public void setNomMenu(String nomMenu) {
        this.nomMenu = nomMenu;
    }

    public int getImgMenu() {
        return imgMenu;
    }

    public void setImgMenu(int imgMenu) {
        this.imgMenu = imgMenu;
    }
}
