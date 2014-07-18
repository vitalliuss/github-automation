package com.epam.kzta2014;

import java.io.File;

import org.apache.log4j.Logger;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.epam.kzta2014.steps.Steps;
import com.epam.ta.reportportal.client.core.message.ReportPortalMessage;
import com.epam.ta.reportportal.listeners.testng.ReportPortalTestNGListener;

@Listeners({ ReportPortalTestNGListener.class })
public class LogTest
{
	public static final String DEMO_SCREENSHOOT = "D://demoScreenshoot.png";
	private static Logger logger = Logger.getLogger(Steps.class);

	@Test
	public void testLogWithFiles() throws Exception
	{

		File atachingFile = new File(DEMO_SCREENSHOOT);
		for (int i = 1; i < 15; i++)
		{
			ReportPortalMessage message =
					new ReportPortalMessage(atachingFile, new StringBuilder("info with file #").append(i).toString());
			logger.info(message);
		}
	}

	@Test
	public void testDifferentEvents()
	{
		ReportPortalMessage message = new ReportPortalMessage("Test different levels. Wrapper");

		logEvents(message);
		String stringLog = "Test different levels. String message";
		logEvents(stringLog);
	}

	private void logEvents(Object message)
	{
		logger.debug(message);
		logger.error(message);
		logger.fatal(message);
		logger.info(message);
		logger.trace(message);
		logger.warn(message);
	}

}
