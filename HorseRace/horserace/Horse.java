import javax.swing.ImageIcon;
import javax.swing.JLabel;

class Horse extends JLabel implements Runnable {
    private RaceGui race;
    private int track;

    Horse(RaceGui race, int no){  
        this.race = race;
        this.track = no;
        ImageIcon ii=new ImageIcon(this.getClass().getResource("images/Horse_Small.png"));
        this.setSize(ii.getIconWidth(), ii.getIconHeight());
        this.setIcon(ii);
    }    

    @Override
    public void run() {
        //多執行緒執行內容....
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
    }
}
