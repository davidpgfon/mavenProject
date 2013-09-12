package com.mycompany.app;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

import java.util.ArrayList;

public class RectanguloTest extends TestCase{

	public RectanguloTest(){
	}
	public void testGetTam(){
		ArrayList<Integer> a=new ArrayList<Integer>();
		a.add(6);a.add(3);a.add(2);a.add(1);
		rectangulo r=new rectangulo(6,0,0,0,0,1,2,a);
		
		int expectedtam=6;
		assertEquals(expectedtam,r.getTam());
	}
	
	public void testGetFil(){
		ArrayList<Integer> a=new ArrayList<Integer>();
		a.add(6);a.add(3);a.add(2);a.add(1);
		rectangulo r=new rectangulo(6,0,0,0,0,1,2,a);
		
		int expectedfil=0;
		assertEquals(expectedfil,r.getFila());
	}
	
	public void testGetCol(){
		ArrayList<Integer> a=new ArrayList<Integer>();
		a.add(6);a.add(3);a.add(2);a.add(1);
		rectangulo r=new rectangulo(6,0,0,0,0,1,2,a);
		
		int expectedcol=0;
		assertEquals(expectedcol,r.getColumna());
	}
}