import org.apache.dubbo.common.URL;
import org.apache.dubbo.common.utils.UrlUtils;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;

public class Main {

    public static void main(String[] args) throws Exception {
        String[] whiteHosts = new String[]{"whitehost"};
        String evilUrl = "https://evilhost@whitehost";
        URL url = UrlUtils.parseURL(evilUrl, null);
        System.out.println(url.getHost());
        System.out.println(whitehostCheck(whiteHosts, url.getHost()));
        java.net.URL url1 = new java.net.URL(evilUrl);
        System.out.println(url1.getHost());
        System.out.println(whitehostCheck(whiteHosts, url1.getHost()));
    }

    private static boolean whitehostCheck(String[] whiteHosts, String hostToCheck) {
        for(String host: whiteHosts) {
            if (host.equals(hostToCheck)) {
                return true;
            }
        }
        return false;
    }

    private static void exex() throws Exception {
        Process process = Runtime.getRuntime().exec("git checkout master & echo 11");
        print(process.getInputStream());
        print(process.getErrorStream());
//        print(process.getOutputStream());
    }

    private static void print(InputStream input) throws Exception {
        Reader reader = new InputStreamReader(input);
        BufferedReader bf = new BufferedReader(reader);
        String line = null;
        while ((line = bf.readLine()) != null) {
            System.out.println(line);
        }
    }
}
