package inputrendermanager;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;

public class Main {
    
    public static void main(String[] args){
        
        Application app = new Application("My First App", 800, 600){
            @Override
            public void addRenderables(){
                getRenderManager().add(new Renderable(){
                    
                    private int x = 100, y = 100;
                    
                    @Override
                    public void draw(Graphics g){
                        g.setColor(Color.red);
                        g.fillOval(x, y, 100, 100);
                        
                        if(getInputManager().getKeyboard().isKeyPressed(KeyEvent.VK_LEFT)){
                            x -= 10;
                        }else if(getInputManager().getKeyboard().isKeyPressed(KeyEvent.VK_RIGHT)){
                            x += 10;
                        }
                    }
                });
                
                getRenderManager().add(new Renderable(){
                    
                    @Override
                    public void draw(Graphics g){
                        g.setColor(Color.blue);
                        g.fillRect(getInputManager().getMouse().getX(), getInputManager().getMouse().getY(), 50, 50);
                
                
                    }
                    
                });
            }
            
            @Override
            public void update(){}
        };
        
        app.start();
    }
}
