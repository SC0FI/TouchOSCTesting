package Testing;

import com.illposed.osc.OSCMessage;
import com.illposed.osc.transport.OSCPortOut;

import java.net.InetAddress;
import java.security.Key;
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

            // KeyListener to detect key press and release
            frame.addKeyListener(new KeyAdapter() {
                @Override
                public void keyPressed(KeyEvent e) {
                    if (e.getKeyCode() == KeyEvent.VK_W) {
                        // Send OSC message with integer 1 when W is pressed
                        System.out.println("W key pressed, sending 1");
                        OSCMessage msg = new OSCMessage("/input/MoveForward", Collections.singletonList(1));
                        try {
                            sender.send(msg);
                        } catch (Exception ex) {
                            ex.printStackTrace();
                        }
                    } else if (e.getKeyCode() == KeyEvent.VK_S) {
                        // Send OSC message with integer 1 when S is pressed
                        System.out.println("S key pressed, sending 1");
                        OSCMessage msg = new OSCMessage("/input/MoveBackward", Collections.singletonList(1));
                        try {
                            sender.send(msg);
                        } catch (Exception ex) {
                            ex.printStackTrace();
                        }
                    } else if (e.getKeyCode() == KeyEvent.VK_A) {
                        // Send OSC message with integer 1 when A is pressed
                        System.out.println("A key pressed, sending 1");
                        OSCMessage msg = new OSCMessage("/input/MoveLeft", Collections.singletonList(1));
                        try {
                            sender.send(msg);
                        } catch (Exception ex) {
                            ex.printStackTrace();
                        }
                    } else if (e.getKeyCode() == KeyEvent.VK_D) {
                        // Send OSC message with integer 1 when D is pressed
                        System.out.println("D key pressed, sending 1");
                        OSCMessage msg = new OSCMessage("/input/MoveRight", Collections.singletonList(1));
                        try {
                            sender.send(msg);
                        } catch (Exception ex) {
                            ex.printStackTrace();
                        }
                    }
                }

                @Override
                public void keyReleased(KeyEvent e) {
                    if (e.getKeyCode() == KeyEvent.VK_W) {
                        // Send OSC message with integer 0 when W is released
                        System.out.println("W key released, sending 0");
                        OSCMessage msg = new OSCMessage("/input/MoveForward", Collections.singletonList(0));
                        try {
                            sender.send(msg);
                        } catch (Exception ex) {
                            ex.printStackTrace();
                        }
                    } else if (e.getKeyCode() == KeyEvent.VK_S) {
                        // Send OSC message with integer 0 when S is released
                        System.out.println("S key released, sending 0");
                        OSCMessage msg = new OSCMessage("/input/MoveBackward", Collections.singletonList(0));
                        try {
                            sender.send(msg);
                        } catch (Exception ex) {
                            ex.printStackTrace();
                        }
                    } else if (e.getKeyCode() == KeyEvent.VK_A) {
                        // Send OSC message with integer - when A is released
                        System.out.println("A key released, sending 0");
                        OSCMessage msg = new OSCMessage("/input/MoveLeft", Collections.singletonList(0));
                        try {
                            sender.send(msg);
                        } catch (Exception ex) {
                            ex.printStackTrace();
                        }
                    } else if (e.getKeyCode() == KeyEvent.VK_D) {
                        // Send OSC message with integer - when D is released
                        System.out.println("D key released, sending 0");
                        OSCMessage msg = new OSCMessage("/input/MoveRight", Collections.singletonList(0));
                        try {
                            sender.send(msg);
                        } catch (Exception ex) {
                            ex.printStackTrace();
                        }
                    }
                }
            });

            frame.setSize(300, 300);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setVisible(true);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
