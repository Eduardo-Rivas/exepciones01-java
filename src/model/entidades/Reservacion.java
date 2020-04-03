package model.entidades;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Reservacion {
	private Integer nroCuarto;
	private Date fechaEntrada;
	private Date fechaSalida;

	private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

	// --Definimos el Constructor--//
	public Reservacion(Integer nroCuarto, Date fechaEntrada, Date fechaSalida) {
		this.nroCuarto = nroCuarto;
		this.fechaEntrada = fechaEntrada;
		this.fechaSalida = fechaSalida;
	}

	// --Definimos Getters y Setter--//
	public Integer getNroCuarto() {
		return nroCuarto;
	}
	public void setNroCuarto(Integer nroCuarto) {
		this.nroCuarto = nroCuarto;
	}

	public Date getFechaEntrada() {
		return fechaEntrada;
	}
	public Date getFechaSalida() {
		return fechaSalida;
	}

	//--Metodo para calclar los dias--//
	public long duracion()
	{
		//--Guarda valor en milisegundos--//
		long dif = fechaSalida.getTime() - fechaEntrada.getTime();
		
		//--Convierte MiliSeg. en Dias--//
		return TimeUnit.DAYS.convert(dif, TimeUnit.MILLISECONDS);
	}

    public String actualizardias(Date fechaEntrada, Date fechaSalida)
    {
		Date hoy = new Date();
		if (fechaEntrada.before(hoy) || fechaSalida.before(hoy)) 
		{
			return "La Actualizacion debe ser con Fechas Futuras ";
		} 
		if (!fechaSalida.after(fechaEntrada)) 
		{
			return "Error. Fecha de Salida debe ser > a Fecha de Entrada";
		} 	
       this.fechaEntrada = fechaEntrada;
       this.fechaSalida = fechaSalida;
       return null;
    }

	@Override
	public String toString()
	{
		return "Nro. Cuarto :"
			   +nroCuarto
			   +" - "
			   +"Fecha de Entrada :"
			   +sdf.format(fechaEntrada) 
			   +" - "
			   +"Fecha de Salida :"
			   +sdf.format(fechaSalida)
			   +" - "
			   +duracion()
			   +" Noches";	
	}
    

}
