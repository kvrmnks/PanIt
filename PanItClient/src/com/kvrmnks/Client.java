package com.kvrmnks;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class Client {
    private DataInputStream socketIn;
    private DataOutputStream socketOut;
    private Socket socket;

    public Client(DataInputStream socketIn, DataOutputStream socketOut, Socket socket) {
        this.socketIn = socketIn;
        this.socketOut = socketOut;
        this.socket = socket;
    }

    public MyFile[] getStructure(String location) throws IOException{
        socketOut.writeUTF("GetStructure" + "$" + location);
        int n = socketIn.readInt();
        MyFile[] ret = new MyFile[n];
        for (int i = 0; i < n; i++) {
            ret[i] = MyFile.constructByStream(socketIn);
        }
        return ret;
    }


}
