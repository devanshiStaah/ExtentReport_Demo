package Log4j;

import org.apache.log4j.*;

public class MylogClass {
	
	static Logger logger = Logger.getLogger(MylogClass.class);
	
	public static void main(String[] args) {
        logger.debug("Debug");
        logger.info("Info");
        logger.warn("Warn");
        logger.error("Error");
        logger.fatal("Fatal");
	}

}

