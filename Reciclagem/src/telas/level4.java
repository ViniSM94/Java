package telas;

import principal.Jogo;
import principal.Tela;

import com.badlogic.gdx.Screen;

public class level4 implements Screen{
	private Tela t = new Tela("LEVEL 4", 1.8, 0.35,1000);
	private Jogo myGame;
	
    public level4(Jogo g)
    {
           myGame = g;
    }
	@Override
	public void dispose() {
		// TODO Auto-generated method stub
		
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
	public void render(float arg0) {
		// TODO Auto-generated method stub
		t.render();
		if(t.getPassaFase()=="Vitória") myGame.setScreen(new level1(myGame));
		else if(t.getPassaFase()=="Derrota") myGame.setScreen(new level4(myGame));
	}

	@Override
	public void resize(int arg0, int arg1) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void resume() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void show() {
		// TODO Auto-generated method stub
		t.create();
	}

}
