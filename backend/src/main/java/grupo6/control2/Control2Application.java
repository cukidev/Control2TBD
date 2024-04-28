package grupo6.control2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Control2Application {

	public static void main(String[] args) {
		SpringApplication.run(Control2Application.class, args);

		helloWorld();
	}

		public static void helloWorld(){
			System.out.println("Control2 está funcionando correctamente.");
		}

}


