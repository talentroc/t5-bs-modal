package com.talentroc.t5.bs.modal.test;

import org.apache.tapestry5.test.Jetty7Runner;

public class RunJetty {
    public static void main(String[] args) throws Exception {
        Jetty7Runner runner = new Jetty7Runner("src/test/webapp", "/", 9090, 9091);

        runner.start();
    }
}
