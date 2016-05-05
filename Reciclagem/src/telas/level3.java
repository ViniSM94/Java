package telas;

import principal.Jogo;
import principal.Tela;

import com.badlogic.gdx.Screen;

public class level3 implements Screen{
	private Tela t = new Tela("LEVEL 3", 1.6, 0.31,2000);
	private Jogo myGame;
	
    public level3(Jogo g)
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
		if(t.getPassaFase()=="Vitória") myGame.setScreen(new level4(myGame));
		else if(t.getPassaFase()=="Derrota") myGame.setScreen(new level3(myGame));
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
