package com.rillsoft.springbookadmin.JUnit;

// import org.junit.After;  for JUnit4
// import org.junit.Before; for JUnit4
// import org.junit.Test;   for JUnit4

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Test;

import ch.qos.logback.classic.Level;
import ch.qos.logback.classic.Logger;
import ch.qos.logback.classic.LoggerContext;

import org.slf4j.LoggerFactory;

import static org.assertj.core.api.Assertions.assertThat;

/*
    source copied and updated by crane zhou on 2021.08.12

    refre to:

    http://logback.qos.ch/documentation.html

    https://www.baeldung.com/junit-asserting-logs
    https://github.com/eugenp/tutorials/tree/master/testing-modules/testing-assertions
 */

public class JavaProjectWorkerUnitTest {
    private static MemoryAppender m_objMemoryAppender;
//    private static final String LOGGER_NAME = "com.rillsoft.springbookadmin.JUnit";
    private static final String m_strLoggerName = JavaProjectWorker.class.getName();
    private static final String UNITTEST_MSG = "This is a unit test message!";

    @BeforeAll
    static void setupBeforeAll() {

        Logger objLogger = (Logger) LoggerFactory.getLogger(m_strLoggerName);
//        Logger objLogger = (Logger) LoggerFactory.getLogger(LOGGER_NAME);

        m_objMemoryAppender = new MemoryAppender();
        m_objMemoryAppender.setContext((LoggerContext) LoggerFactory.getILoggerFactory());
        objLogger.setLevel(Level.DEBUG);
        objLogger.addAppender(m_objMemoryAppender);
        m_objMemoryAppender.start();

    }

    @AfterAll
    static void cleanupAfterAll() {
        m_objMemoryAppender.reset();
        m_objMemoryAppender.stop();
    }

    @Test
    public void testJavaProjectWorker() {
        JavaProjectWorker objWorker = new JavaProjectWorker();
        objWorker.generateLogs(UNITTEST_MSG);

        // I check that I only have 4 messages (all but trace)
        assertThat(m_objMemoryAppender.countEventsForLogger(m_strLoggerName)).isEqualTo(5);
        // I look for a specific message at a specific level, and I only have 1
        assertThat(m_objMemoryAppender.search(UNITTEST_MSG, Level.INFO).size()).isEqualTo(1);
        // I check that the entry that is not present is the trace level
        assertThat(m_objMemoryAppender.contains(UNITTEST_MSG, Level.TRACE)).isFalse();

    }
}

// mvn test -Dtest=JavaProjectWorkerUnitTest
//