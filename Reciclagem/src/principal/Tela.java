package principal;


import java.util.Calendar;
import java.util.Map.Entry;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.utils.TimeUtils;

import elementos.Latas;
import elementos.Lixo;


public class Tela implements ApplicationListener, InputProcessor{ // Interfaces
	   // Encapsulamento
	
	   private Texture agua, cenario;	
	   private Lixo lixo = new Lixo();
	   private Latas latas = new Latas();
	   private SpriteBatch batch = new SpriteBatch();	   
	   private BitmapFont bm = new BitmapFont();
	   private OrthographicCamera camera = new OrthographicCamera();
	   private String level, passaFase;
	   private boolean pause, vitoria;	   
	   private double yagua, sobelata, sobeagua;
	   private int i, contvidro,contorg,contpapel,contmetal,contplast,tempo,t,seconds, tempoLixo, pontuacao;
	   
	   // Construtor
	   public Tela(String level, double sobelata, double sobeagua, int tempoLixo){
		   agua = new Texture(Gdx.files.internal("data/agua.png"));
		   cenario = new Texture(Gdx.files.internal("data/cenario1.png"));
		   i = MathUtils.random(0, 8);
		   contvidro=0;
		   contorg=0;
		   contpapel=0;
		   contmetal=0;
		   contplast=0;
		   pontuacao=0;
		   tempo=47;
		   this.level = level;
		   this.sobelata = sobelata;
		   this.sobeagua = sobeagua;
		   this.tempoLixo = tempoLixo;
		   pause = false;
	   }


	@Override // Sobrescrita
	public void create() {
	   
		 yagua=-380;
		 Gdx.input.setInputProcessor(this);
		        
	     camera.setToOrtho(false, 800, 480);
	     
	     latas.getLtPapel().x = 210; 
	     latas.getLtPapel().y = 50;
	     latas.getLtPapel().width = 64;
	     latas.getLtPapel().height = 64;
	      
	     latas.getLtPlastico().x = 310; 
	     latas.getLtPlastico().y = 45; 
	     latas.getLtPlastico().width = 64;
	     latas.getLtPlastico().height = 64;
	      
	     latas.getLtVidro().x = 410; 
	     latas.getLtVidro().y = 15; 
	     latas.getLtVidro().width = 64;
	     latas.getLtVidro().height = 64;
	      	      
	     latas.getLtMetal().x = 510;
	     latas.getLtMetal().y = 10;
	     latas.getLtMetal().width = 64;
	     latas.getLtMetal().height = 64;
	      	      
	     latas.getLtOrganico().x = 610;
	     latas.getLtOrganico().y = 15;
	     latas.getLtOrganico().width = 64;
	     latas.getLtOrganico().height = 64;
	     
	     lixo.cairLixo(i);
	     
	   }
	   
	  
	@Override
	   public void render() {
		  Calendar calendar = Calendar.getInstance();
		  int j=0;
		  seconds = calendar.get(Calendar.SECOND);
		  
	      Gdx.gl.glClearColor(0, 0, 1f, 1);
	      Gdx.gl.glClear(GL10.GL_COLOR_BUFFER_BIT);

	      camera.update();	      
	     
	      batch.setProjectionMatrix(camera.combined);
	      
	      batch.begin();
	      
	      
	      batch.draw(cenario, 0, 0); //Polimorfismo
	      batch.draw(agua, 0, (int)yagua);
	      batch.draw(latas.getLataPapel(), latas.getLtPapel().x, latas.getLtPapel().y);
	      batch.draw(latas.getLataPlastico(), latas.getLtPlastico().x, latas.getLtPlastico().y);
	      batch.draw(latas.getLataVidro(), latas.getLtVidro().x, latas.getLtVidro().y);
	      batch.draw(latas.getLataMetal(), latas.getLtMetal().x, latas.getLtMetal().y);
	      batch.draw(latas.getLataOrganico(), latas.getLtOrganico().x, latas.getLtOrganico().y);
	      bm.draw(batch, "Organico: "+contorg, 0, 420);
	      bm.draw(batch, "Plastico: "+contplast, 0, 435);
	      bm.draw(batch, "Vidro: "+contvidro, 0, 450);
	      bm.draw(batch, "Metal: "+contmetal, 0, 465);
	      bm.draw(batch, "Papel: "+contpapel, 0, 480);
	      bm.draw(batch, "Pontos: "+pontuacao, 550, 480);
	     
	      if(t==seconds-1 && pause == false)
	      {
	    	  tempo--;
	      }
    	   
	      if(tempo>45){
	    	  bm.draw(batch, level, 300, 430); 
	      }
	      t = seconds;	
	      
	      if(yagua<0&&tempo>0 && tempo<=45 && pause == false){
	    	  
	    	  
	    	  bm.draw(batch, "Tempo: "+tempo, 700, 480);
	    	  for(Rectangle r: lixo.getRetLixos()) {
	    	  
	    	  if(r!=null){ 
	    		  batch.draw(lixo.getText().get(j), r.x-20, r.y-30,64,64);
	    		  criaLixo(r,j);
	        
	    		  j++;
	    	 }
	    	 
	      }
	      if(TimeUtils.millis() - lixo.getLastDropTime() > tempoLixo){
	    	  i = MathUtils.random(0,8);
	    	  lixo.cairLixo(i);	
	    	  
	      }

              }
	      else if(pause == true) bm.draw(batch, "PAUSE!!!!", 300, 430);

	      if(yagua<0&&tempo<=0){
	    	  bm.draw(batch, "PARABENS!!!! - Pressione ENTER para mudar de fase", 300,430);
	    	  vitoria = true;
	      }
	      if(yagua>=0){
	    	  vitoria = false;
	      }
	      	       
	      batch.end();
	      
	   }

	//Função que verifica se o lixo colidiu com alguma lata ou água


	public void criaLixo(Rectangle ret, int j){
		   		boolean troca=false;

		         ret.y -= 50 * Gdx.graphics.getDeltaTime();

		         for(Rectangle r:latas.getLatas()) {
	
		         
		        	 for(Entry<Texture,String> e:lixo.getHm().entrySet()){
		        		 if(e.getKey()==lixo.getText().get(j)){
		        			 if(r==latas.getLtVidro() && e.getValue()=="Vidro"&&ret.overlaps(r)){	
		        				 contvidro++;
		        				 pontuacao+=100;
		        				 troca=true;		        	 
		        				 break;
			         
		        			 }
		        			 else if(r==latas.getLtOrganico() && e.getValue()=="Organico"&&ret.overlaps(r)){	
		        				 contorg++;
		        				 troca=true;
		        				 pontuacao+=100;
		        	   			 break;
			         
		        			 }
		        			 else if(r==latas.getLtMetal() && e.getValue()=="Metal"&&ret.overlaps(r)){	
		        				 contmetal++; 
		        				 troca=true;
		        				 pontuacao+=100;
		        				 break;
		        	 
		        			 }
		        			 else if(r==latas.getLtPapel() && e.getValue()=="Papel"&& ret.overlaps(r)){	
		        				 contpapel++; 		        			
		        				 troca=true;
		        				 pontuacao+=100;
		        				 break;
			         
		        			 }
		        			 else if(r==latas.getLtPlastico() && e.getValue()=="Plastico" && ret.overlaps(r)){	
		        				 contplast++; 
		        				 troca=true;
		        				 pontuacao+=100;
		        				 break;			         
		        			 }
		        			 else if(ret.overlaps(r)){	
			        			 contmetal=0;
			        			 contplast=0;
			        			 contorg=0;
			        			 contpapel=0;
			        			 contvidro=0;
			        			 pontuacao-=50;
			        			 troca=true;				        
			        			 break;
				         
		        			 }
		        			 else if(ret.y + 64 <= latas.getLtPlastico().y && ret.y+64>latas.getLtPlastico().y-40){
		        				 r.y +=sobelata;
		        				 yagua +=sobeagua;
		        				 break;
		         	 
		        			 }
		        			 else if(ret.y+64<latas.getLtPlastico().y-40){
		        				 troca=true;
		        				 break;
		        			 }
		        		 }
		        
		         	}   
		         }
		         
		         if(troca==true){			        	
			        	lixo.getRetLixos().removeIndex(j);
			        	lixo.getText().removeIndex(j);

			        }     
		        
	   }

	   @Override
	   public void dispose() {
		  
		  bm.dispose(); 
	      batch.dispose();
	   }

	   @Override
	   public void resize(int width, int height) {
	   }

	   @Override
	   public void pause() {
		  // screen.pause();
	   }

	   @Override
	   public void resume() {
	   }

	   //Função de teclado
	   @Override public boolean keyDown (int keycode) {
		    
		   	if(keycode == 131 && pause == false) pause = true;
		   	else if(keycode == 131 && pause == true) pause = false;
		   	if(keycode == 66 && vitoria == false) passaFase = "Derrota";
		   	else if(keycode == 66 && vitoria == true) passaFase = "Vitória";
		    return false;
		  }

		  @Override public boolean keyTyped (char character) {

		    return false;
		  }

		  @Override public boolean keyUp (int keycode) {

		    return false;
		  }
		  
		  @Override public boolean touchDown (int x, int y, int pointer, int button) {
			  Gdx.app.log(null, "X: "+x+" Y: "+y);
		    return false;
		  }

		  // FUnção de click no lixo
		  @Override public boolean touchDragged (int x, int y, int pointer) {
			  for(Rectangle r: lixo.getRetLixos()) {
				  	
				  	 Vector3 touchPos = new Vector3();
			         touchPos.set(Gdx.input.getX(), Gdx.input.getY(), 0);
			         camera.unproject(touchPos);
				//	 Gdx.app.log(null, "X: "+x+" Y: "+y);
				//	 Gdx.app.log(null, "RX: "+r.x+" RY: "+r.y);
			         if(r!=null && touchPos.x>=r.x-20 && touchPos.x<r.x+r.width && y+(int)r.y>=463 && y+(int)r.y<=500){

				         r.x = touchPos.x;  
				         r.y = touchPos.y; 

		         }			 			
			  }
		    return false;
		  }

		  @Override public boolean touchUp (int x, int y, int pointer, int button) {

		    return false;
		  }



		  @Override public boolean scrolled (int amount) {
		  //  Gdx.app.log("Input Test", "scrolled: " + amount);
		    return false;
		  }

		@Override
		public boolean mouseMoved(int screenX, int screenY) {
			// TODO Auto-generated method stub
			return false;
		}




		public String getPassaFase() {
			return passaFase;
		}

}
