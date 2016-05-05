package principal;

import com.badlogic.gdx.backends.jglfw.JglfwApplication;
import com.badlogic.gdx.backends.jglfw.JglfwApplicationConfiguration;

public class MainScreen {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		  JglfwApplicationConfiguration cfg = new JglfwApplicationConfiguration();
	      cfg.title = "Reciclagem";
	      cfg.width = 800;
	      cfg.height = 480;
	      cfg.resizable = false;

	      new JglfwApplication(new Jogo(), cfg);
	}

}
