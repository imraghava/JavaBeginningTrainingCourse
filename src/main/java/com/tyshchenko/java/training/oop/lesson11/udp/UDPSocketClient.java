package com.tyshchenko.java.training.oop.lesson11.udp;


import java.io.IOException;
import java.net.*;

/**
 * @author Alexander Tyshchenko.
 */
public class UDPSocketClient {

    public static void main(String[] args) {
        UDPSocketClient client = new UDPSocketClient();
        client.createAndListenSocket();
    }

    public void createAndListenSocket() {
            try(DatagramSocket socket = new DatagramSocket()) {

            InetAddress IPAddress = InetAddress.getByName("localhost");
            byte[] incomingData = new byte[1024];
            String sentence = "This is a message from client";
            byte[] data = sentence.getBytes();
            DatagramPacket sendPacket = new DatagramPacket(data, data.length, IPAddress, 9999);
            socket.send(sendPacket);
            System.out.println("Message sent from client");
            DatagramPacket incomingPacket = new DatagramPacket(incomingData, incomingData.length);
            socket.receive(incomingPacket);
            String response = new String(incomingPacket.getData()).trim();
            System.out.println("Response from server:" + response);

        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (SocketException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}

