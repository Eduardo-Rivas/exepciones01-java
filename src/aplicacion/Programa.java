package aplicacion;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;

import model.entidades.Reservacion;
import model.excepciones.ControlExcepciones;

import java.util.Date;

public class Programa {

	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
         
		try
		{
			System.out.print("Nro. del Cuarto :");
			int nroCuarto = sc.nextInt();
			
			System.out.print("Fecha de Entrada (dd/mm/yyyy):");
			Date fechaEntrada = sdf.parse(sc.next());
			
			System.out.print("Fecha de Salida (dd/mm/yyyy):");
			Date fechaSalida = sdf.parse(sc.next());
			
			// --Instanciamos e Imprimimos la Reserva--//
			Reservacion reservacion = new Reservacion(nroCuarto, fechaEntrada, fechaSalida);			System.out.println("Reservacion : " + reservacion);
			System.out.println();
			
			// --Entramos de nuevo Datos para Actualizar Reserva--//
			System.out.println("Entre los Datos para Actualizar Reserva :");
			System.out.print("Fecha de Entrada (dd/mm/yyyy):");
			fechaEntrada = sdf.parse(sc.next());
			 
			System.out.print("Fecha de Salida (dd/mm/yyyy):");
			fechaSalida = sdf.parse(sc.next());
			
			//--Llamamos al Metodo actualizardias(Con tartamiento de exepciones)--//
			reservacion.actualizardias(fechaEntrada, fechaSalida);
			
			// --Todo Bien Imprimimos la Reservacion--//
			System.out.println("Reservacion : " + reservacion);
			System.out.println();
		}
		catch(ParseException e) 
		{
			System.out.println("Invalido Formato de Fecha....");	
		}
		catch(ControlExcepciones e)
		{
			System.out.println("Error en Reservacion..."+e.getMessage());	
		}
		catch(RuntimeException e)
		{
			System.out.println("Error Inesperado..."+e.getMessage());	
		}
		sc.close();
		
	}

}
