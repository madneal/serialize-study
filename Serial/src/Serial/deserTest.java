package Serial;

import java.io.*;

public class deserTest implements Serializable {
    private static final long serialVersionUID = 1L;

    private int n;

    public deserTest(int n) {
        this.n = n;
    }

    public static void main(String[] args) {
        deserTest x = new deserTest(5);
        operation.ser(x);
        operation.dser();
    }
}

class operation {
    public static void ser(Object obj) {
        try {
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("object.obj"));
            oos.writeObject(obj);
            oos.flush();
            oos.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void dser() {
        try {
            File file = new File("object.obj");
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file));
            Object x = ois.readObject();
            System.out.println(x);
            ois.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}