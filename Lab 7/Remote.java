package lab7;
import java.util.Scanner;

//Interface definition for Remote
interface Remote {
 void powerOn();
 void powerOff();
 void changeChannel(int channel);
}

//Implementation of the Remote interface for Television
class Television implements Remote {
 private boolean isOn;
 private int currentChannel;

 public Television() {
     this.isOn = false;
     this.currentChannel = 1; // Default channel
 }

 @Override
 public void powerOn() {
     if (!isOn) {
         isOn = true;
         System.out.println("TV is now on.");
     } else {
         System.out.println("TV is already on.");
     }
 }

 @Override
 public void powerOff() {
     if (isOn) {
         isOn = false;
         System.out.println("TV is off.");
     } else {
         System.out.println("TV is already off.");
     }
 }

 @Override
 public void changeChannel(int channel) {
     if (isOn) {
         if (channel > 0 && channel <= 100) { // Assuming a range of channels
             this.currentChannel = channel;
             System.out.println("Channel changed to " + currentChannel + ".");
         } else {
             System.out.println("Invalid channel number. Please select a channel between 1 and 100.");
         }
     } else {
         System.out.println("Cannot change channel. TV is off.");
     }
 }
}

//Class with the main method to demonstrate Remote control with user input
