package com.matrix.service;

import com.matrix.state.MatrixState;
import lombok.Getter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

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

    public MatrixState invertState() {
        state.invertState(random.nextInt(8), random.nextInt(8));
        LOG.info(Arrays.deepToString(state.getState()));
        return state;
    }

}
