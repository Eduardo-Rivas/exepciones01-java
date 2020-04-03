package aplicacion;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;

import model.entidades.Reservacion;

import java.util.Date;

public class Programa {

	public static void main(String[] args) throws ParseException {
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

		System.out.print("Nro. del Cuarto :");
		int nroCuarto = sc.nextInt();

		System.out.print("Fecha de Entrada (dd/mm/yyyy):");
		Date fechaEntrada = sdf.parse(sc.next());
		 

		System.out.print("Fecha de Salida (dd/mm/yyyy):");
		Date fechaSalida = sdf.parse(sc.next());

		if (!fechaSalida.after(fechaEntrada)) {
			System.out.println("Error. Fecha de Salida debe ser > a Fecha de Entrada");
		} 
		else 
		{
			// --Instanciamos e Imprimimos la Reserva--//
			Reservacion reservacion = new Reservacion(nroCuarto, fechaEntrada, fechaSalida);
			System.out.println("Reservacion : " + reservacion);
			System.out.println();

			// --Entramos de nuevo Datos para Actualizar Reserva--//
			System.out.println("Entre los Datos para Actualizar Reserva :");
			System.out.print("Fecha de Entrada (dd/mm/yyyy):");
			fechaEntrada = sdf.parse(sc.next());
 
			System.out.print("Fecha de Salida (dd/mm/yyyy):");
			fechaSalida = sdf.parse(sc.next());

			String error = reservacion.actualizardias(fechaEntrada, fechaSalida);
			if(error != null)
			{
				System.out.println("Error en Reservacion : " + error);	
			}
			else
			{
				// --Todo Bien Imprimimos la Reservacion--//
				System.out.println("Reservacion : " + reservacion);
				System.out.println();
			}
		}

		sc.close();

	}

}
