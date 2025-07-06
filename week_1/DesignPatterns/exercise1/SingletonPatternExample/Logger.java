package SingletonPatternExample;

public class Logger{
        private static Logger logger;
        private Logger(){
            System.out.println("Logger initialized");
        }
        public static Logger getLogger(){
            if(logger==null){
                logger = new Logger();
            }
            return logger;
        }
        public void log(String s){
            System.out.println("Log : " + s);
        }
}