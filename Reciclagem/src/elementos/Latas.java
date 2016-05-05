package elementos;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.utils.Array;

public class Latas {
	private Texture lataOrganico,lataVidro,lataMetal,lataPlastico,lataPapel;
	private Rectangle ltOrganico,ltVidro,ltMetal,ltPlastico,ltPapel;
	private Array<Rectangle> latas;
	
	public Latas(){
		lataOrganico = new Texture(Gdx.files.internal("data/lataOrganico.png"));
	    lataMetal = new Texture(Gdx.files.internal("data/lataMetal.png"));
	    lataPlastico = new Texture(Gdx.files.internal("data/lataPlastico.png"));
	    lataVidro = new Texture(Gdx.files.internal("data/lataVidro.png"));
	    lataPapel = new Texture(Gdx.files.internal("data/lataPapel.png"));
	    ltPapel = new Rectangle();
	    ltPlastico = new Rectangle();
	    ltVidro = new Rectangle();
	    ltMetal = new Rectangle();
	    ltOrganico = new Rectangle();
	    latas = new Array<Rectangle>();
	    latas.add(ltOrganico);
	    latas.add(ltPapel);
	    latas.add(ltVidro);
	    latas.add(ltMetal);
	    latas.add(ltPlastico);
	}

	public Texture getLataOrganico() {
		return lataOrganico;
	}

	public Texture getLataVidro() {
		return lataVidro;
	}

	public Texture getLataMetal() {
		return lataMetal;
	}

	public Texture getLataPlastico() {
		return lataPlastico;
	}

	public Texture getLataPapel() {
		return lataPapel;
	}

	public Rectangle getLtOrganico() {
		return ltOrganico;
	}

	public Rectangle getLtVidro() {
		return ltVidro;
	}

	public Rectangle getLtMetal() {
		return ltMetal;
	}

	public Rectangle getLtPlastico() {
		return ltPlastico;
	}

	public Rectangle getLtPapel() {
		return ltPapel;
	}

	public Array<Rectangle> getLatas() {
		return latas;
	}
	
}
