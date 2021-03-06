package com.mycompany.app;

import java.io.*;
import java.util.*;

import javax.swing.*;

public class tablero {
	private String[][] matriz;
	private int numRectColocados;
	private ArrayList<rectangulo> rectangulos;
	private ArrayList<tablero> resultado;
	private int tfila,tcolumna;
	
	public tablero(){
		matriz=new String[0][0];
		matriz[0][0]="*";
		numRectColocados=0;
		rectangulos=new ArrayList<rectangulo>();
		resultado=new ArrayList<tablero>();
	}
	public tablero(int f,int c){
		matriz=new String[f][c];
		for (int i=0;i<f;i++){
			for (int j=0;j<c;j++){
				matriz[i][j]="*";
			}
		}
		numRectColocados=0;
		rectangulos=new ArrayList<rectangulo>();
		resultado=new ArrayList<tablero>();
	}
	public ArrayList<Integer> getDivisores(int n){
		ArrayList<Integer> al=new ArrayList<Integer>();
		for (int i=n;i>0;i--){
			if (n % i==0) {
				al.add(i);
			}
		}
		return al;
	}
	
	private ArrayList<rectangulo> listaRectangulos(){
		ArrayList<rectangulo> al=new ArrayList<rectangulo>();
		for (int i=0;i<tfila;i++){
			for (int j=0;j<tcolumna;j++){
				if (!matriz[i][j].equals("*")){
					rectangulo r=new rectangulo(Integer.parseInt(matriz[i][j]),i,j,0,0,0,0,getDivisores(Integer.parseInt(matriz[i][j])));
					al.add(r);
				}
			}
		}
		return al;
	}
	
	public tablero(String fichero){
		Scanner sc=null;

		try {
			sc=new Scanner(new File(fichero));
			String linea;
			int fila=0;
			ArrayList<String> lineaAux=new ArrayList<String>();
			while (sc.hasNext()) {
				linea=sc.nextLine();
				if (!linea.equals("")) {
					if (linea.charAt(0) != '#'){
						/*String[] arrLinea=linea.split(" ");
						for (int i=0;i<arrLinea.length-1;i++){
							matriz[fila][i]=arrLinea[i];
						}
						tfila=fila;
						tcolumna=arrLinea.length;*/
						lineaAux.add(linea);
						tcolumna=linea.split(" ").length;
						fila++;
					}
				}
			} 
			sc.close();
			tfila=fila;
			matriz=new String[tfila][tcolumna];
			
			for (int i=0;i<tfila;i++){
				matriz[i]=lineaAux.get(i).split(" ");
			}
	
			numRectColocados=0;
			rectangulos=listaRectangulos();
			resultado=new ArrayList<tablero>();
			resultado.clear();
		}
		
		catch (FileNotFoundException e){
			JOptionPane.showMessageDialog(null,"Error al buscar fichero");
		}
	}
	
	public int getFila(){
		return tfila;
	}
	
	public int getColumna(){
		return tcolumna;
	}
	
	public void setFila(int f){
		tfila=f;
	}
	public void setColumna(int c){
		tcolumna=c;
	}
	
	public String toString() {
		String ts=new String(); 
		ts="\n";
		for (int i=0;i<tfila;i++){
			for (int j=0;j<tcolumna;j++){
				ts=ts+matriz[i][j]+" ";
			}
			ts=ts+"\n";
		}
		
		System.out.println(ts);
		return ts;
		
	}
	public void setValueMatriz(int i,int j, String strn){
		matriz[i][j]=strn;
	}
	public void setMatriz(String[][] matriz) {
		this.matriz = matriz;
	}
	public String[][] getMatriz() {
		return matriz;
	}
	public void setNumRectColocados(int numRectColocados) {
		this.numRectColocados = numRectColocados;
	}
	public int getNumRectColocados() {
		return numRectColocados;
	}
	public void setRectangulos(ArrayList<rectangulo> rectangulos) {
		this.rectangulos = rectangulos;
	}
	public ArrayList<rectangulo> getRectangulos() {
		return rectangulos;
	}
	public void setResultado(ArrayList<tablero> resultado) {
		this.resultado = resultado;
	}
	public ArrayList<tablero> getResultado() {
		return resultado;
	}
	
	public tablero clonar(){
		tablero ta=new tablero(tfila,tcolumna);
		ta.setNumRectColocados(numRectColocados);
		ta.setColumna(tcolumna);
		ta.setFila(tfila);
		ta.setRectangulos((ArrayList<rectangulo>) rectangulos.clone());
		ta.setResultado((ArrayList<tablero>) resultado.clone());
		
		String[][] m=new String[tfila][tcolumna];
		for (int i=0;i<tfila;i++){
			for (int j=0;j<tfila;j++){
				m[i][j]=matriz[i][j];
			}
		}
		ta.setMatriz(m);
		return ta;
	}
	public boolean sePuedePoner(rectangulo r){
		int fsi,csi;
		int fid,cid;
		fsi=r.getFila_sup_izq();
		csi=r.getColumna_sup_izq();
		fid=r.getFila_inf_dcha();
		cid=r.getColumna_inf_dcha();
		if (fsi<0 || csi<0 || fid>=tfila || cid>=tcolumna) return false;
		boolean sepuede=true;
		int i=fsi;
		int j;
		while (i<=fid && sepuede) {
			j=csi; //antes staba fuera
			while (j<=cid && sepuede) {
				//sepuede=(matriz[i][j].equals("*")||matriz[i][j].equals(String.valueOf(r.getTam()))); // mal para el 1013 porq hay un 4 tb en la fila, ad+ del suyo.
				sepuede=(matriz[i][j].equals("*")||(i==r.getFila() && j==r.getColumna()));
				j++;
			}
			i++;
		}		
		return sepuede;
	}
	
	public ArrayList<rectangulo> posiblesColocaciones(rectangulo r){
		ArrayList<rectangulo> al=new ArrayList<rectangulo>();
		ArrayList<Integer> ld=r.getListadivisores();
		for (int k=0;k<ld.size();k++){	//para cada divisor
			int f=ld.get(k); 			//filas
			int c=ld.get(ld.size()-1-k);//columnas
			
			//para cada colocacion del divisor.
			for (int j=r.getColumna()-c+1;j<=r.getColumna();j++){ //(int j=r.getColumna()-c+1;j<=r.getColumna()+c-1;j++)
				for (int i=r.getFila()-f+1;i<=r.getFila();i++){ //(int i=r.getFila()-f+1;i<=r.getFila()+f-1;i++)
					rectangulo ra=new rectangulo(r.getTam(),r.getFila(),r.getColumna(),i,j,i+f-1,j+c-1,ld);
					if (sePuedePoner(ra)){
						al.add(ra);
					}
				}
			}
		}
		return al;
		
	}
}
