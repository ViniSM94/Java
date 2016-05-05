package telas;





import principal.Jogo;
import principal.Tela;

import com.badlogic.gdx.Screen;

public class level2 implements Screen{
	//Tela tela = new Tela();
	Tela t = new Tela("LEVEL 2", 1.3, 0.26,2500);
	private Jogo myGame;
	
    public level2(Jogo g)
    {
           myGame = g;
    }
	@Override
	public void render(float delta) {
		// TODO Auto-generated method stub
		//t.render();
		t.render();
		if(t.getPassaFase()=="Vitória") myGame.setScreen(new level3(myGame));
		else if(t.getPassaFase()=="Derrota") myGame.setScreen(new level2(myGame));
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
