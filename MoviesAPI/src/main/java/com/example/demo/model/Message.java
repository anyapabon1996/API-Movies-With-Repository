package com.example.demo.model;
//import org.apache.logging.log4j.Level;

//Importamos los paquetes para el loggers
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
//import org.apache.logging.log4j.core.LoggerContext;

public class Message {

	//Esto le dice a donde vamos a crear el logger
    final static Logger logger = LogManager.getLogger(Message.class);

    public void logMessage(int parameter) {

        // Este codigo me permite configurar el nivel de mensaje de Log4J
//        LoggerContext ctx = (LoggerContext) LogManager.getContext(false);
//        org.apache.logging.log4j.core.config.Configuration conf = ctx.getConfiguration();
//        conf.getLoggerConfig(LogManager.ROOT_LOGGER_NAME).setLevel(Level.INFO);
//        ctx.updateLoggers(conf);
    	
//    	logger.error("you made a mistake" );

        if (parameter == 1)
            logger.error("You've ingress an unexiting ID");
        else if (parameter == 2)
            logger.warn("you've ingress a no valid character");
        else
            logger.fatal("Este es un mensaje Fatal");
    }
	
}
