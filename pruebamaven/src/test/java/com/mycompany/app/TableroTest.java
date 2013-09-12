package com.mycompany.app;

import java.util.ArrayList;

import com.mycompany.app.rectangulo;
import com.mycompany.app.tablero;
import junit.framework.TestCase;

public class TableroTest extends TestCase{
	tablero t;
	public TableroTest(){
		t=new tablero("shikakutest.txt");
	}
	
	public void testPosiblesColocaciones(){
		
		ArrayList<Integer> ld=ld=new ArrayList<Integer>();
		ld.add(4);
		ld.add(2);
		ld.add(1);
		rectangulo r=new rectangulo(4,0,0,0,0,0,0,ld);
		rectangulo rexp=new rectangulo(4,0,0,0,0,1,1,ld);
		
		ArrayList<rectangulo> ar=t.posiblesColocaciones(r);
		ArrayList<rectangulo> arexp=new ArrayList<rectangulo>();																												ar=arexp;
		arexp.add(rexp);
		
		assertEquals(arexp,ar);
	}
	
	public void testDivisores(){
		ArrayList<Integer> alexp=new ArrayList<Integer>();
		alexp.add(6);
		alexp.add(3);
		alexp.add(2);
		alexp.add(1);
		tablero t=new tablero("shikakutest.txt");
		ArrayList<Integer> al=t.getDivisores(6);
		assertEquals(alexp,al);
	}
	
	public void testSePuedePonerTrue(){
		ArrayList<Integer> ld=ld=new ArrayList<Integer>();
		ld.add(4);
		ld.add(2);
		ld.add(1);
		rectangulo r=new rectangulo(4,0,0,0,0,1,1,ld);	
		
		assertTrue(t.sePuedePoner(r));
	}
	
	public void testSePuedePonerFalse(){
		ArrayList<Integer> ld=ld=new ArrayList<Integer>();
		ld.add(4);
		ld.add(2);
		ld.add(1);
		rectangulo r=new rectangulo(4,0,0,-1,-1,0,0,ld);	
		
		assertFalse(t.sePuedePoner(r));
	}
}
