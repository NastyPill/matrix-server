package com.matrix.service;

import com.matrix.state.MatrixState;
import lombok.Getter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Arrays;
import java.util.Random;

@Service
public class MatrixService {

    @Getter
    MatrixState state;
    Random random;

    private static final Logger LOG = LoggerFactory.getLogger("MatrixService");

    public MatrixService() {
        this.state = new MatrixState();
        this.random = new Random();
    }

    public MatrixState invertState(String ip) {
        LOG.info("invert");
        while (true) {
            state.invertState(random.nextInt(8), random.nextInt(8));
            try {
                Socket socket = new Socket(ip, 80);
                OutputStream outputStream = socket.getOutputStream();
                BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream));
                bufferedWriter.write(stringState(state));
                bufferedWriter.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private String stringState(MatrixState state) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                sb.append(state.getState()[i][j]);
            }
        }
        return sb.toString();
    }

}
