package my.it.test;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Test;

public class TestLog {
	@Test
	public void test(){
		Log log = LogFactory.getLog(getClass());
		log.debug("debug 级别日志");
		log.info("info 级别日志");
		log.warn("warn 级别日志");
		log.error("error 级别日志");
		log.fatal("fatal 级别日志");
	}

}
