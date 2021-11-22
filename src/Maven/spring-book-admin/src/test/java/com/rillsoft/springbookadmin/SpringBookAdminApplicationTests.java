package com.rillsoft.springbookadmin;

import ch.qos.logback.core.Appender;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mockito;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.Assert;

//@RunWith(SpringRunner.class)
@SpringBootTest
// @AutoConfigureMockMvc
class SpringBookAdminApplicationTests {

	@Test
	void contextLoads() {
	}

	/*
	@Autowired
	private MockMvc mvc;

	@Test
	public void testLogger() throws Exception {
		// create the mock appender
		Appender mockedAppender = Mockito.mock(Appender.class);

		// inject it
		((ch.qos.logback.classic.Logger) LoggerFactory.getLogger(Logger.ROOT_LOGGER_NAME)).addAppender(mockedAppender);

		// run your test
		LoggerFactory.getLogger(Logger.ROOT_LOGGER_NAME).error("Test msg");

		// verify using ArgumentCaptor
		ArgumentCaptor<Appender> argumentCaptor = ArgumentCaptor.forClass(Appender.class);
		Mockito.verify(mockedAppender).doAppend(argumentCaptor.capture());

		// assert against argumentCaptor.getAllValues()
		Asser.assertEquals(1, argumentCaptor.getAllValues().size());
		Assert.assertEquals("Test msg", ((LoggingEvent)argumentCaptor.getAllValues().get(0)).getMessage());

		// remove the mock appender from static context
		((Logger) LoggerFactory.getLogger(Logger.ROOT_LOGGER_NAME)).detachAppender(mockedAppender);
	}
 */
}
