package servicios;

import jakarta.xml.ws.Endpoint;

public class AutorServiciosWebservice {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Endpoint endPoint = Endpoint.publish("http://localhost:8080/Autor", new AutorServicios());

	}

}
