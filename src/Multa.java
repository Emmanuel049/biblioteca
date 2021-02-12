import java.util.Date;

public class Multa {
	//Utilizo la clase Multa para determinar lo que necesita recibir la clase para generar los d�as de multa (directamente proporcionales a la cantidad de d�as de atraso) y para poder revisar el estado de la multa y su finalizaci�n, admito que el m�dulo Date es nuevo para m� y me enter� que est� obsoleto actualmente, para la pr�xima revisi�n busco utilizar el m�dulo Calendar y optimizar el c�digo.
	
	Lector lector;
	int diasAtraso;
	Date fechaMulta = new Date();
	Date finalMulta = new Date();
	
	//Constructor
	public Multa (Lector _lector,int _diasAtraso) {
		lector = _lector;
		Date fechaFinal = new Date(fechaMulta.getDay(),fechaMulta.getMonth(),fechaMulta.getDate()+(_diasAtraso*2));
		finalMulta = new Date(fechaFinal.getYear(),fechaFinal.getMonth(),fechaFinal.getDate());
		_lector.multar();
		System.out.println("Multa establecida: El lector: "+lector.nombre+" no podr� retirar libros hasta la fecha: "+fechaFinal.getDate()+"/"+fechaFinal.getMonth()+1+"/"+fechaFinal.getYear());
	}
	
	//Getters
	public Date getfechaMulta() {
		return fechaMulta;
	}
	
	public Date getfinalMulta() {
		return finalMulta;
	}
	
	public Lector getLector() {
		return lector;
	}
	
	//En ambos casos si el lector no tiene una multa se devolver� un texto, pero en otro caso se dar� una especie de getter que mostrar� la fecha de inicio y fin de la multa de la forma: "DD/MM/YYYY".
	public String mostrarInicioMulta() {
		if (lector.estaMultado() == false) {
			return "El lector no tiene una multa actualmente.";
		}
		else {
			return fechaMulta.getDate()+"/"+fechaMulta.getMonth()+1+"/"+fechaMulta.getYear();
		}
	}
	
	public String mostrarFinalMulta() {
		if (lector.estaMultado() == false) {
			return "El lector no tiene una multa actualmente.";
		}
		else {
			return finalMulta.getDate()+"/"+finalMulta.getMonth()+1+"/"+finalMulta.getYear();
		}
	}
	
	//Funciones Espec�ficas
	public void deshacerMulta (Lector _lector) {
		_lector.sacarMulta();
	}
	
}
