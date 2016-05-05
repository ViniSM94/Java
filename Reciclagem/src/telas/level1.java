package telas;

import principal.Jogo;
import principal.Tela;

import com.badlogic.gdx.Screen;

public class level1 implements Screen{
	
	private Tela t = new Tela("LEVEL 1", 0.9, 0.21,3000);
	private Jogo myGame;
	
	// Construtor
    public level1(Jogo g)
    {
           myGame = g;
    }
	@Override // Sobrescrita
	public void render(float delta) {
		// TODO Auto-generated method stub
		t.render();	
		if(t.getPassaFase()=="Vitória") myGame.setScreen(new level2(myGame));
		else if(t.getPassaFase()=="Derrota") myGame.setScreen(new level1(myGame));
	}

	@Override
	public void resize(int width, int height) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void show() {
		// TODO Auto-generated method stub
		t.create();
	}

	@Override
	public void hide() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void pause() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void resume() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void dispose() {
		// TODO Auto-generated method stub
		
	}

}
