/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package lolwatch;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.DataInputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author Dark
 */
public class LolWatch {

    /**
     * @param args the command line arguments
     */
    static Robot robot;

    public static void main(String[] args) {

        try {
            robot = new Robot();
            ServerSocket srv_sck = new ServerSocket(3000);
            Socket sck_cliente = srv_sck.accept();
            DataInputStream datain = new DataInputStream(sck_cliente.getInputStream());

            int msg = -1;

            while (true) {
                if (datain.available() > 0) {
                    msg = datain.readInt();
                    System.out.println(msg);

                    switch (msg) {
                        case 2:
                            pulsa(KeyEvent.VK_Q);
                            break;
                        case 0:
                            pulsa(KeyEvent.VK_W);
                            break;
                        case 3:
                            pulsa(KeyEvent.VK_E);
                            break;
                        case 1:
                            pulsa(KeyEvent.VK_R);
                            break;
                        case -1:
                            pulsa(KeyEvent.VK_D);
                            break;
                        case -2:
                            pulsa(KeyEvent.VK_F);
                            break;
                    }
                }
            }

        } catch (Exception ex) {
            System.out.println("Error:" + ex.toString());
        }

    }

    static void pulsa(int keycode) {
        robot.keyPress(keycode);
        robot.keyRelease(keycode);
    }
}
