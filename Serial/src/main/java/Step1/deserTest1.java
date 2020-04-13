package Step1;

import java.io.*;

public class deserTest1 implements Serializable {
    private static final long serialVersionUID = 1L;

    private int n;

    public deserTest1(int n) {
        this.n = n;
    }

    private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
        in.defaultReadObject();
        Runtime.getRuntime().exec("calc");
        System.out.println("test");
    }

    public static void main(String[] args) {
        deserTest1 x = new deserTest1(5);
        operation1.ser(x);
        operation1.deser();
    }
}

class operation1 {
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

    public static void deser() {
        try {
            File file = new File("object.obj");
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file));
            Object x = ois.readObject();
            System.out.println(x);
            ois.readObject();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
