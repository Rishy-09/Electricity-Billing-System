package electricity.billing.system;
//90% swing 10% awt to be used
//awt: Abstract Window Toolkit
import javax.swing.*;
import java.awt.*;

public class Splash extends JFrame implements Runnable{
    Thread t;
    Splash(){

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/elect.jpg"));
        Image i2 = i1.getImage().getScaledInstance(730, 550, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        add(image);

        setVisible(true);

        int x = 1;
        for(int i = 2; i<600; i+=4, x+=1){
            setSize(i+x, i);
            setLocation(700 - ((i+x)/2), 400 - (i/2));
            try{
                Thread.sleep(5);
            }
            catch(Exception e){
                System.out.println(e);
            }
        }

//        we can't call run method directly , have to create object of thread ,so to work like multi-thread function

//        setSize(730, 550);
//        setLocation(400, 150);
        t = new Thread(this);
        t.start();
        setVisible(true);

    }

    public void run(){
        try{
            Thread.sleep(7000); // for 7 seconds
            setVisible(false);
            new Login();
        }
        catch(Exception e){
            System.out.println(e);
        }
    }

    public static void main(String[] args) {
        new Splash();
    }
}