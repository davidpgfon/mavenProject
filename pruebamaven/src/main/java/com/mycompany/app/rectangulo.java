package com.mycompany.app;

import java.util.*;


public class rectangulo {
	private int tam;
	private int fila,columna;
	private int fila_sup_izq,columna_sup_izq;
	private int fila_inf_dcha,columna_inf_dcha;
	private ArrayList<Integer> listadivisores;
	
	public rectangulo(){
		tam=0;
		fila=0;
		columna=0;
		fila_sup_izq=0;
		columna_sup_izq=0;
		fila_inf_dcha=0;
		columna_inf_dcha=0;
		listadivisores=new ArrayList<Integer>();
	}
	public rectangulo(int tam,int fila,int columna,int fila_sup_izq,int columna_sup_izq,int fila_inf_dcha,int columna_inf_dcha,ArrayList<Integer> listadivisores){
		this.tam=tam;
		this.fila=fila;
		this.columna=columna;
		this.fila_sup_izq=fila_sup_izq;
		this.columna_sup_izq=columna_sup_izq;
		this.fila_inf_dcha=fila_inf_dcha;
		this.columna_inf_dcha=columna_inf_dcha;
		this.listadivisores=(ArrayList<Integer>) listadivisores.clone();
	}
	
	public rectangulo(rectangulo r){
		tam=r.getTam();
		fila=r.getFila();
		columna=r.getColumna();
		fila_sup_izq=r.getFila_sup_izq();
		columna_sup_izq=r.getColumna_sup_izq();
		fila_inf_dcha=r.getFila_inf_dcha();
		columna_inf_dcha=r.getColumna_inf_dcha();
		listadivisores=(ArrayList<Integer>) r.getListadivisores().clone();
	}
	
	public void setTam(int tam) {
		this.tam = tam;
	}
	public int getTam() {
		return tam;
	}
	public void setFila(int fila) {
		this.fila = fila;
	}
	public int getFila() {
		return fila;
	}
	public void setColumna(int columna) {
		this.columna = columna;
	}
	public int getColumna() {
		return columna;
	}
	public void setFila_sup_izq(int fila_sup_izq) {
		this.fila_sup_izq = fila_sup_izq;
	}
	public int getFila_sup_izq() {
		return fila_sup_izq;
	}
	public void setColumna_sup_izq(int columna_sup_izq) {
		this.columna_sup_izq = columna_sup_izq;
	}
	public int getColumna_sup_izq() {
		return columna_sup_izq;
	}
	public void setFila_inf_dcha(int fila_inf_dcha) {
		this.fila_inf_dcha = fila_inf_dcha;
	}
	public int getFila_inf_dcha() {
		return fila_inf_dcha;
	}
	public void setColumna_inf_dcha(int columna_inf_dcha) {
		this.columna_inf_dcha = columna_inf_dcha;
	}
	public int getColumna_inf_dcha() {
		return columna_inf_dcha;
	}
	public void setListadivisores(ArrayList<Integer> listadivisores) {
		this.listadivisores = listadivisores;
	}
	public ArrayList<Integer> getListadivisores() {
		return listadivisores;
	}
	
}

