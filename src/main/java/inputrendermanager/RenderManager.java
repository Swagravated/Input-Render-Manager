package inputrendermanager;
import java.awt.Canvas;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.util.ArrayList;

public class RenderManager {
    
    private Canvas screen;
    
    private ArrayList<RenderManager> renderables = new ArrayList<>();
    
    public RenderManager(Canvas screen){
        this.screen = screen;
    }
    
    public void add(Renderable r){
        renderables.add((RenderManager) r);
    }
    
    public void update(){
        BufferStrategy b = screen.getBufferStrategy();
        
        if(screen.isDisplayable()){
            
        // BufferStrategy won't exist on first attempt - if statement is to create a buffer
        if(b == null){
            screen.createBufferStrategy(2);
            return;
        }
        
        Graphics g = b.getDrawGraphics();
        g.clearRect(0, 0, screen.getWidth(), screen.getHeight());
        
        for(RenderManager r : renderables){
            r.draw(g);
        }
        
        b.show();
        // Dispose to Save Memory
        g.dispose();
        }
    }

    private void draw(Graphics g) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
