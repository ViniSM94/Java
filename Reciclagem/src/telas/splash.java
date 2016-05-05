package telas;



import java.util.Calendar;

import principal.Jogo;


import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;



public class splash implements Screen // Interface
{
    private SpriteBatch spriteBatch;
    private Texture splsh;
    private Jogo myGame;
    private int seconds,t, tempo=0;

    // Construtor
    public splash(Jogo g)
    {
           myGame = g;
    }

    @Override // Sobrescrita
    public void render(float delta)
    {
		  	Calendar calendar = Calendar.getInstance();
		  	
		  	seconds = calendar.get(Calendar.SECOND);
    		
            Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
            spriteBatch.begin();
            spriteBatch.draw(splsh, 0, 0);
  	      	if(t==seconds-1)
  	      	{
  	    	  tempo++;
  	      	}
  	      	t = seconds;
           
            spriteBatch.end();
            if(tempo==5) myGame.setScreen(new level1(myGame));
    }
    
    @Override
    public void show()
    {
    		
            spriteBatch = new SpriteBatch();
            Texture.setEnforcePotImages(false); 
            splsh = new Texture(Gdx.files.internal("data/splash.png"));
    }

	@Override
	public void resize(int width, int height) {
		
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