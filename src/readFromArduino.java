import gnu.io.CommPortIdentifier;
import gnu.io.SerialPort;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Scanner;


public class readFromArduino{
	 static InputStream input;
	    static OutputStream output;
	    
public static void readFromArduino() throws Exception{
    	//for linux
    	//CommPortIdentifier portId = CommPortIdentifier.getPortIdentifier("/dev/ttyACM3");
    	
    	//for windows
    	CommPortIdentifier portId = CommPortIdentifier.getPortIdentifier("COM5");
    	//CommPortIdentifier portId = CommPortIdentifier.getPortIdentifier("COM4");
    	
    	SerialPort port = (SerialPort)portId.open("serial talk", 4000);
        input = port.getInputStream();
        port.setSerialPortParams(9600,
                SerialPort.DATABITS_8,
                SerialPort.STOPBITS_1,
                SerialPort.PARITY_NONE);
        
        while(true){
        if(input.available()>0) {
            System.out.print((char)(input.read()));
        }
        }
        
        
       
    }
}