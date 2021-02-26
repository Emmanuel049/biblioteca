package relLector;
import java.util.Date;

public class Multa {
	//Utilizo la clase Multa para determinar lo que necesita recibir la clase para generar los días de multa (directamente proporcionales a la cantidad de días de atraso) y para poder revisar el estado de la multa y su finalización, admito que el módulo Date es nuevo para mí y me enteré que está obsoleto actualmente, para la próxima revisión busco utilizar el módulo Calendar y optimizar el código.
	
	private Lector lector;
	private Date fechaMulta = new Date();
	private Date finalMulta = new Date();
	
	//Constructor
	public Multa (Lector _lector,int _diasAtraso) {
		this.lector = _lector;
		Date fechaFinal = new Date(fechaMulta.getYear(),fechaMulta.getMonth(),fechaMulta.getDate()+(_diasAtraso*2));
		finalMulta = new Date(fechaFinal.getYear(),fechaFinal.getMonth(),fechaFinal.getDate());
		_lector.multar();
		System.out.println("Multa establecida: El lector: "+this.lector.getNombre()+" no podrá retirar libros hasta la fecha: "+fechaFinal.getDate()+"/"+fechaFinal.getMonth()+1+"/"+fechaFinal.getYear());
	}
	
	//Getters
	public Date getFechaMulta() {
		return fechaMulta;
	}
	
	public Date getFinalMulta() {
		return finalMulta;
	}
	
	public Lector getLector() {
		return lector;
	}
	
	//En ambos casos si el lector no tiene una multa se devolverá un texto, pero en otro caso se dará una especie de getter que mostrará la fecha de inicio y fin de la multa de la forma: "DD/MM/YYYY".
	public String mostrarInicioMulta() {
		//Devuelve un string que informa si el lector tiene una multa actualmente, y si la tiene devuelve en forma de string la fecha de emisión de la multa
		if (lector.estaMultado() == false) {
			return "El lector no tiene una multa actualmente.";
		}
		else {
			return fechaMulta.getDate()+"/"+fechaMulta.getMonth()+1+"/"+fechaMulta.getYear();
		}
	}
	
	public String mostrarFinalMulta() {
		//Devuelve un string que informa si el lector tiene una multa actualmente, y si la tiene devuelve en forma de string la fecha final de dicha multa
		if (lector.estaMultado() == false) {
			return "El lector no tiene una multa actualmente.";
		}
		else {
			return finalMulta.getDate()+"/"+finalMulta.getMonth()+1+"/"+finalMulta.getYear();
		}
	}
	
	//Funciones Específicas
	public void deshacerMulta () {
		//Deshace la multa vinculada a un lector
		lector.sacarMulta();
	}
	
	public void extenderMulta(int dias) {
		finalMulta = new Date(finalMulta.getYear(),finalMulta.getMonth(),finalMulta.getDate()+(dias*2));
	}
}
