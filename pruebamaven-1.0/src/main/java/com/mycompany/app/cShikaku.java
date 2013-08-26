package com.mycompany.app;

import java.util.*;


public class cShikaku {
	private tablero t;
	private ArrayList<tablero> resultado;
	private int numeritos;
	
	public cShikaku(){
		numeritos=96;
		t=new tablero("s.txt");
		resultado= new ArrayList<tablero>();
		vueltaAtras(t);
		
		if (resultado.size()==0){
			System.out.println("No hay soluciones");
		} else {
			tablero ta;
			System.out.println("\n\n\nSOLUCIONES:\n");
			for (int i=0;i<resultado.size();i++){
				ta=resultado.get(i);
				ta.toString();			
			}
		}
	}

	public cShikaku(String f){
		numeritos=96;
		t=new tablero(f);
		resultado= new ArrayList<tablero>();
		vueltaAtras(t);
		
		if (resultado.size()==0){
			System.out.println("No hay soluciones");
		} else {
			tablero ta;
			System.out.println("\n\n\nSOLUCIONES:\n");
			for (int i=0;i<resultado.size();i++){
				ta=resultado.get(i);
				ta.toString();			
			}
		}
	}
	
	
	private void vueltaAtras(tablero t){
		if (esSolucion(t)) { 
			resultado.add(t);
			}
		else {
			numeritos++;
			ArrayList<tablero> L=candidatos(t);
			while (!(L.size()==0)){
				tablero hijo= L.get(0).clonar(); //cogemos el primer elemento de la lista.
				L.remove(0);
				vueltaAtras(hijo);
			}
		}
	}
	
	private boolean esSolucion(tablero t2) {
		return t2.getNumRectColocados()==t2.getRectangulos().size();
	}

	private ArrayList<tablero> candidatos (tablero t){
		ArrayList<tablero> hijos=new ArrayList<tablero>();
		int rectActual=t.getNumRectColocados();
		rectangulo r=t.getRectangulos().get(rectActual);
		
		ArrayList<rectangulo> rects=t.posiblesColocaciones(r);
		for (int k=0; k<rects.size();k++){
			tablero taux=null;
			taux=t.clonar();
			rectangulo ra=rects.get(k);
			//hacemos todos los tableros para cada colocoacion del cuadarito de las bolas
			for (int i=ra.getFila_sup_izq();i<=ra.getFila_inf_dcha();i++){
				for (int j=ra.getColumna_sup_izq();j<=ra.getColumna_inf_dcha();j++){
					taux.setValueMatriz(i, j,Character.toString((char)(97+rectActual)));
					
				}
			}

			if (rects.size()<0 || rects!=null){
				taux.setNumRectColocados(taux.getNumRectColocados()+1);
			}
			hijos.add(taux);
		}

		return hijos;
	}
}
