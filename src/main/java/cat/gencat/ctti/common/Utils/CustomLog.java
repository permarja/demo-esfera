package cat.gencat.ctti.common.Utils; 

import java.io.IOException;
import java.time.LocalDateTime;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.FileAppender;
import org.apache.log4j.PatternLayout;
import org.apache.log4j.SimpleLayout;

public class CustomLog {

	private static final String DIR = System.getProperty("user.dir");
	private static Logger LOG = Logger.getLogger(CustomLog.class);

	private LocalDateTime fecha = LocalDateTime.now();

	private FileAppender simpleAppender;
	private FileAppender patternAppender;

	public enum Tipus {
		INFORMACIO, ADVERTENCIA, ERROR, ERROR_FATAL
	}

	public CustomLog(String nomLog) throws IOException {

		Logger.getRootLogger().setLevel(Level.OFF);

		String DATA_LOG = fecha.getYear() + "-" + fecha.getMonthValue() + "-" + fecha.getDayOfMonth() + "T"
				+ fecha.getHour() + "h" + fecha.getMinute() + "m" + fecha.getSecond() + "s";

		String fullpath = DIR + "\\Logs\\" + DATA_LOG + "_" + nomLog;
		SimpleLayout simpleLayout = new SimpleLayout();
		PatternLayout patternLayout = new PatternLayout("%d{ISO8601} [%t] %-5p %c %x - %m%n");
		simpleAppender = new FileAppender(simpleLayout, fullpath, true);
		patternAppender = new FileAppender(patternLayout, fullpath, true);
		simpleAppender.setName("simple");
		simpleAppender.setEncoding("ISO-8859-1");
		patternAppender.setName("pattern");
		patternAppender.setEncoding("ISO-8859-1");

	}

	public void CapçaleraLog() {

		ImprimeixSenseData("################################################################################",
				Tipus.INFORMACIO);
		ImprimeixSenseData("################################################################################",
				Tipus.INFORMACIO);
		ImprimeixSenseData("INICI DEL LOG", Tipus.INFORMACIO);
		ImprimeixSenseData("################################################################################",
				Tipus.INFORMACIO);
		ImprimeixSenseData("################################################################################",
				Tipus.INFORMACIO);

	}

	public void ImprimeixSenseData(String str, Tipus tipus) {

		if (patternAppender.equals(LOG.getAppender("pattern"))) {
			LOG.removeAppender("pattern");
		}

		if (!simpleAppender.equals(LOG.getAppender("simple"))) {
			LOG.addAppender(simpleAppender);
			LOG.setLevel((Level) Level.DEBUG);
		}

		switch (tipus) {
		case INFORMACIO:
			LOG.info(str);
			break;
		case ADVERTENCIA:
			LOG.warn(str);
			break;
		case ERROR:
			LOG.error(str);
			break;
		case ERROR_FATAL:
			LOG.fatal(str);
			break;
		}
	}

	public void ImprimeixAmbData(Class<?> clazz, String str, Tipus tipus) {

		LOG = Logger.getLogger(clazz);
		if (simpleAppender.equals(LOG.getAppender("simple"))) {
			LOG.removeAppender("simple");
		}

		if (!patternAppender.equals(LOG.getAppender("patternAppender"))) {
			LOG.addAppender(patternAppender);
			LOG.setLevel((Level) Level.DEBUG);
		}

		switch (tipus) {
		case INFORMACIO:
			LOG.info(str);
			break;
		case ADVERTENCIA:
			LOG.warn(str);
			break;
		case ERROR:
			LOG.error(str);
			break;
		case ERROR_FATAL:
			LOG.fatal(str);
			break;
		}
	}

	public void ImprimeixAmbData(String traza, String str, Tipus tipus) {

		LOG = Logger.getLogger(traza);
		if (simpleAppender.equals(LOG.getAppender("simple"))) {
			LOG.removeAppender("simple");
		}

		if (!patternAppender.equals(LOG.getAppender("patternAppender"))) {
			LOG.addAppender(patternAppender);
			LOG.setLevel((Level) Level.DEBUG);
		}

		switch (tipus) {
		case INFORMACIO:
			LOG.info(str);
			break;
		case ADVERTENCIA:
			LOG.warn(str);
			break;
		case ERROR:
			LOG.error(str);
			break;
		case ERROR_FATAL:
			LOG.fatal(str);
			break;
		}
	}

	public void ImprimeixAmbData(Class<?> clazz, String str, Tipus tipus, Integer nombreLinia) {

		LOG = Logger.getLogger(clazz);
		if (simpleAppender.equals(LOG.getAppender("simple"))) {
			LOG.removeAppender("simple");
		}

		if (!patternAppender.equals(LOG.getAppender("patternAppender"))) {
			LOG.addAppender(patternAppender);
			LOG.setLevel((Level) Level.DEBUG);
		}

		switch (tipus) {
		case INFORMACIO:
			LOG.info(str + "- (Linia: " + nombreLinia + ")");
			break;
		case ADVERTENCIA:
			LOG.warn(str + "- (Linia: " + nombreLinia + ")");
			break;
		case ERROR:
			LOG.error(str + "- (Linia: " + nombreLinia + ")");
			break;
		case ERROR_FATAL:
			LOG.fatal(str + "- (Linia: " + nombreLinia + ")");
			break;
		}
	}

	public void ImprimeixAmbData(String traza, String str, Tipus tipus, Integer nombreLinia) {

		LOG = Logger.getLogger(traza);
		if (simpleAppender.equals(LOG.getAppender("simple"))) {
			LOG.removeAppender("simple");
		}

		if (!patternAppender.equals(LOG.getAppender("patternAppender"))) {
			LOG.addAppender(patternAppender);
			LOG.setLevel((Level) Level.DEBUG);
		}

		switch (tipus) {
		case INFORMACIO:
			LOG.info(str + "- (Linia: " + nombreLinia + ")");
			break;
		case ADVERTENCIA:
			LOG.warn(str + "- (Linia: " + nombreLinia + ")");
			break;
		case ERROR:
			LOG.error(str + "- (Linia: " + nombreLinia + ")");
			break;
		case ERROR_FATAL:
			LOG.fatal(str + "- (Linia: " + nombreLinia + ")");
			break;
		}
	}

}
