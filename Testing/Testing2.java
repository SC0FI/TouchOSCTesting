package Testing;

import com.illposed.osc.OSCMessage;
import com.illposed.osc.transport.OSCPortOut;

import java.net.InetAddress;
import java.util.Collections;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;
import javax.swing.*;
import java.awt.event.*;

public class Testing2 {
    public static void main(String args[]) {
        try {
            OSCPortOut sender = new OSCPortOut(InetAddress.getByName("192.168.50.172"), 9000);
            JFrame frame = new JFrame("Key Press Example");


            frame.addKeyListener(new KeyAdapter() {
                @Override
                public void keyPressed(KeyEvent e) {
                    if (e.getKeyCode() == KeyEvent.VK_F) {
                        System.out.println("hiii");
                    }
                }
            });

            frame.setSize(300,300);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setVisible(true);

           /* for (float i = 0; i < 10; i= (float) (i+0.1)) {
                OSCMessage msg = new OSCMessage("/juce/rotaryknob", Collections.singletonList(i));
                sender.send(msg);
                TimeUnit.SECONDS.sleep(1);
                System.out.println("osc message sent" + i);
            }
            */
            System.out.println("Please intput selection (1-3)");
            Scanner input = new Scanner(System.in);


            int selection = input.nextInt();
            if(selection == 1) {
                System.out.println("Please enter Input (true/false)");
                Boolean oscInput = input.nextBoolean();
                OSCMessage msg = new OSCMessage("/avatar/parameters/pcs/isEnable", Collections.singletonList(oscInput));

                sender.send(msg);
                System.out.println("OSC message sent!");
            } else if (selection == 2){
                System.out.println("Please enter Input (true/false)");
                Boolean oscInput = input.nextBoolean();
                OSCMessage msg2 = new OSCMessage("/avatar/parameters/pcs/satisfaction/orgasm", Collections.singletonList(oscInput));


                sender.send(msg2);
                System.out.println("OSC message sent!");
            } else if (selection == 3) {
                System.out.println("Enter custom OSC directory");
                String oscDirectory = input.next();
                System.out.println("Please Select datatype \n Boolean : 1 \n Integer : 2 \n float : 3 \n");
                int datatypeSelection = input.nextInt();
                if (datatypeSelection == 1) {
                    System.out.println("please enter data (true/false)");
                    Boolean data = input.nextBoolean();
                    OSCMessage msgCustom = new OSCMessage("/avatar/parameters/" + oscDirectory,Collections.singletonList(data));
                    sender.send(msgCustom);
                } else if (datatypeSelection == 2) {
                    System.out.println("Please input data (1,2,3, etc)");
                    int data = input.nextInt();
                    OSCMessage msgCustom = new OSCMessage("/avatar/parameters/" + oscDirectory,Collections.singletonList(data));
                    sender.send(msgCustom);
                } else if (datatypeSelection == 3) {
                    System.out.println("Please input data (1.5,2.5,etc)");
                    float data = input.nextFloat();
                    OSCMessage msgCustom = new OSCMessage("/avatar/parameters/" +oscDirectory,Collections.singletonList(data));
                    sender.send(msgCustom);
                }
            } else if (selection == 4) {
                for(float i = 0; i < 1; i = (float) (i + 0.05)) {
                    OSCMessage msgEars = new OSCMessage("/avatar/parameters/EarsHor", Collections.singletonList(i));
                    sender.send(msgEars);
                    System.out.println("ears Hor is [" + i + "]");
                    TimeUnit.MILLISECONDS.sleep(50);
                } for (float i = 1; i > -1; i = (float) (i - 0.05)) {
                    OSCMessage msgEars = new OSCMessage("/avatar/parameters/EarsHor", Collections.singletonList(i));
                    sender.send(msgEars);
                    System.out.println("ears Hor is [" + i + "]");
                    TimeUnit.MILLISECONDS.sleep(50);
                }

            }


        }catch (Exception e) {
            e.printStackTrace();
        }
    }
}
