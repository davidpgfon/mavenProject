package com.mycompany.app;

import java.util.*;


public class App 
{
    public static void main( String[] args )
    {

	switch (args.length) {
			case 1:
				if (args[0].equals("-h")) {
					System.out.println("\nAYUDA:\nIntroduzca shikaku <nombre_fichero> para ejecutar.");
				} else {
					cShikaku s=new cShikaku(args[0]);
				}
				break;
			default: cShikaku s=new cShikaku();
		}	


	//rectangulo r;
	//r=new rectangulo();
        System.out.println( "Hello World!" );
	System.out.println( "Hello World!" );
	System.out.println( "OK!" );
	System.out.println( "OK2!" );
    }
}

