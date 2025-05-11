package singleton;

import static java.util.Objects.isNull;

public class Logger {

    private static Logger logger;

    private Logger() {
    }

    public static Logger getInstance() {

        if (isNull(logger)) {
            synchronized (Logger.class){ // Lock my class and check but it can have some cost for us
                if (isNull(logger)){    //we use two if for more control and make thread safe and prevent to make two new of object
                    logger = new Logger(); //because we make object into the Logger scope
                }
            }
        }
        return logger;

//        if (isNull(logger)){ //simple way => logger == null
//            logger = new Logger();
//        }
//        return logger;
    }

}
