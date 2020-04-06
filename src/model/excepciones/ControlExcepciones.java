package model.excepciones;

public class ControlExcepciones extends RuntimeException
{
	private static final long serialVersionUID = 1L;

	//--Define Construcor--//
	public ControlExcepciones(String msg)
	{
		super(msg);
	}
}
