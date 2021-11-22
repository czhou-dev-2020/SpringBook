package com.rillsoft.springbookadmin.JUnit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/*
    source copied and updated by crane zhou on 2021.08.12

    refer to:

    http://logback.qos.ch/documentation.html

    https://www.baeldung.com/junit-asserting-logs
    https://github.com/eugenp/tutorials/tree/master/testing-modules/testing-assertions
 */

public class JavaProjectWorker {
    private static final Logger m_objLogger = LoggerFactory.getLogger(JavaProjectWorker.class);

    public void generateLogs(String strMessage) {

        m_objLogger.info(strMessage);
//        m_objLogger.trace(strMessage);

        m_objLogger.trace("Hello World!");
        m_objLogger.debug("How are you today?");
        m_objLogger.info("I am fine.");
        m_objLogger.warn("I love programming.");
        m_objLogger.error("I am programming.");

    }
}
