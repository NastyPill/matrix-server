package com.matrix.state;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@JsonIgnoreProperties(ignoreUnknown = true)
public class MatrixState {

    private static final Logger LOG = LoggerFactory.getLogger("State");

    @JsonProperty("state")
    @Getter
    int[][] state;


    public MatrixState() {
        initState();
    }

    public void invertState(int x, int y) {
        if(state[x][y] == 0) {
            state[x][y] = 1;
        } else {
            state[x][y] = 0;
        }
    }

    private void initState() {
        state = new int[8][8];
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                state[i][j] = 0;
            }
        }
    }

}
