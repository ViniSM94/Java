package elementos;

import java.util.ArrayList;
import java.util.HashMap;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.TimeUtils;

public class Lixo {
	 private ArrayList<Texture> lixos;
	 private Array<Texture> text;
	 private Array<Rectangle> retLixos;
	 private HashMap<Texture,String> hm; // HashMap
	 private long lastDropTime;
	 private Rectangle lixoRet;
	 

	public Lixo(){
		  lixos = new ArrayList<Texture>();
		  hm = new HashMap<Texture,String>();
		  text = new Array<Texture>();
		  retLixos = new Array<Rectangle>();
	      lixos.add(new Texture(Gdx.files.internal("data/maca.png")));
	      lixos.add(new Texture(Gdx.files.internal("data/vidro_01.png")));
	      lixos.add(new Texture(Gdx.files.internal("data/papel_01.png")));
	      lixos.add(new Texture(Gdx.files.internal("data/plastico_01.png")));
	      lixos.add(new Texture(Gdx.files.internal("data/metal_01.png")));
	      lixos.add(new Texture(Gdx.files.internal("data/laranja.png")));
	      lixos.add(new Texture(Gdx.files.internal("data/vidro_02.png")));
	      lixos.add(new Texture(Gdx.files.internal("data/papel_02.png")));
	      lixos.add(new Texture(Gdx.files.internal("data/plastico_02.png")));
	      lixos.add(new Texture(Gdx.files.internal("data/metal_02.png")));
	      hm.put(lixos.get(0), "Organico");
	      hm.put(lixos.get(1), "Vidro");
	      hm.put(lixos.get(2), "Papel");
	      hm.put(lixos.get(3), "Plastico");
	      hm.put(lixos.get(4), "Metal");
	      hm.put(lixos.get(5), "Organico");
	      hm.put(lixos.get(6), "Vidro");
	      hm.put(lixos.get(7), "Papel");
	      hm.put(lixos.get(8), "Plastico");
	      hm.put(lixos.get(9), "Metal");
	      
	 }
	//Função de animação dos lixos
	 public void cairLixo(int i) {
		  lixoRet = new Rectangle();


	      lixoRet.x = MathUtils.random(0, 800-64);	    
	      text.add(lixos.get(i));
	      
	      lixoRet.y = 505;
	      lixoRet.width = 64;
	      lixoRet.height = 64;
	      retLixos.add(lixoRet);	     
	      lastDropTime = TimeUtils.millis();
	   }
	 
	 ///Getters
	 public ArrayList<Texture> getLixos() {
			return lixos;
		}
		public Array<Texture> getText() {
			return text;
		}
		public Array<Rectangle> getRetLixos() {
			return retLixos;
		}
		public HashMap<Texture, String> getHm() {
			return hm;
		}
		public long getLastDropTime() {
			return lastDropTime;
		}
	    
		 public Rectangle getLixoRet() {
				return lixoRet;
			}

}
