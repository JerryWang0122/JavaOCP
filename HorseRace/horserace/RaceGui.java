import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class RaceGui {
    private JFrame frame;
    private JLabel messageLabel;
    private JPanel mainPanel, btnPanel;
    private JButton startBtn, resetBtn;
    private Horse[] horses;
    private boolean completed;
    
    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }

    public void setWinner(int track) {
        this.messageLabel.setText("比賽結束!第"+track+"匹馬獲勝!");
    } 
    
    public RaceGui(){
        frame = new JFrame();
        messageLabel = new JLabel("請按開始按鈕開始比賽");
        mainPanel = new JPanel();
        btnPanel = new JPanel();
        startBtn = new JButton("開始");
        resetBtn = new JButton("重設");
        horses = new Horse[]{new Horse(this, 1), new Horse(this, 2), 
                             new Horse(this, 3), new Horse(this, 4), 
                             new Horse(this, 5)};           
    }
    public void launchFrame() {
        frame.setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);        
        messageLabel.setHorizontalAlignment(SwingConstants.CENTER);
        frame.add(messageLabel , BorderLayout.NORTH);
        startBtn.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                messageLabel.setText("比賽開始.......");
                //建立一個五匹馬的執行緒陣列,逐一啟動
                
                
                
                
                
            }            
        });
        
        resetBtn.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                //畫面重設, 比賽回復開始前狀態
                //gameCompleted設為false
                
                //mainPanel逐一移除Horse Label
                
                
                
                //重新建構Horse陣列,並設定Horse Label顯示位置
                
                
                
                
                
                //重設顯示訊息
                
                //重新繪製Frame
                
             }
            
        });
        
        btnPanel.add(startBtn);       
        btnPanel.add(resetBtn);
        frame.add(btnPanel, BorderLayout.SOUTH);
        mainPanel.setLayout(null);
        for(int i=0; i<horses.length; i++){
            horses[i].setLocation(20,i*70);
            mainPanel.add(horses[i]);
        }
	frame.add(mainPanel, BorderLayout.CENTER);
	frame.setSize(700,450);
        frame.setResizable(false);
	frame.setVisible(true);
    }
    
    public static void main(String[] args) {
        RaceGui gui = new RaceGui();
        gui.launchFrame();       
    }
}
