package Testing;
import com.illposed.osc.*;
import com.illposed.osc.transport.OSCPortIn;
import com.illposed.osc.transport.OSCPortOut;
import com.illposed.osc.OSCMessage;
import com.illposed.osc.OSCBundle;



import java.net.InetAddress;
import java.util.Collections;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class Testing {
    public static void main(String args[]) {
        try {
            OSCPortOut sender = new OSCPortOut(InetAddress.getByName("192.168.50.172"), 9000);

           /* for (float i = 0; i < 10; i= (float) (i+0.1)) {
                OSCMessage msg = new OSCMessage("/juce/rotaryknob", Collections.singletonList(i));
                sender.send(msg);
                TimeUnit.SECONDS.sleep(1);
                System.out.println("osc message sent" + i);
            }
            */
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
            } else {
                System.out.println("Enter custom OSC directory");
                String oscDirectory = input.next();
                System.out.println("Please Select datatype \n Boolean : 1 \n Integer : 2 \n float : 3 \n");
                int datatypeSelection = input.nextInt();
                if (datatypeSelection == 1) {
                    System.out.println("please enter data (true/false)");
                    Boolean data = input.nextBoolean();
                    OSCMessage msgCustom = new OSCMessage(oscDirectory,Collections.singletonList(data));
                    sender.send(msgCustom);
                } else if (datatypeSelection == 2) {
                    System.out.println("Please input data (1,2,3, etc)");
                    int data = input.nextInt();
                    OSCMessage msgCustom = new OSCMessage("/avatar/parameters" + oscDirectory,Collections.singletonList(data));
                    sender.send(msgCustom);
                } else if (datatypeSelection == 3) {
                    System.out.println("Please input data (1.5,2.5,etc)");
                    float data = input.nextFloat();
                    OSCMessage msgCustom = new OSCMessage(oscDirectory,Collections.singletonList(data));
                    sender.send(msgCustom);
                }
            }


        }catch (Exception e) {
            e.printStackTrace();
        }
    }
}
