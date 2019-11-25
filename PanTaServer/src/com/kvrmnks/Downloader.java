package com.kvrmnks;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;

public class Downloader implements Runnable {
    private Socket socket;
    private DataOutputStream out;
    private DataInputStream in;
    private Socket realSocket;
    private int port;
    private String file;
    private Downloader(){}
    public Downloader(Socket socket,DataInputStream in,DataOutputStream out,String file){
        this.socket = socket;
        this.in = in;
        this.out = out;
        this.file = file;
    }
    private int findEmptyPort(){
        for(int i=1000;true;i++){
            try {
                Socket s = new Socket("localhost",i);
                s.close();
            } catch (UnknownHostException e) {
                return i;
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    private void setConnect(){
        port = findEmptyPort();
        try {
            ServerSocket serverSocket = new ServerSocket(port);
            out.writeInt(port);
            realSocket = serverSocket.accept();
            in = new DataInputStream(realSocket.getInputStream());
            out = new DataOutputStream(realSocket.getOutputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private void mainWork() throws IOException {
        File f = new File(file);
        DataInputStream fileIn = new DataInputStream(new FileInputStream(f));
        long length = f.length();
        out.writeLong(length);
        byte[] buffer = new byte[1024];
        long current = 0;
        while (current < length){
            int w = fileIn.read(buffer);
            current += w;
            out.write(buffer,0,w);
        }
        fileIn.close();
    }
    @Override
    public void run() {
        setConnect();
        try {
            mainWork();
            in.close();
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
