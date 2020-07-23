public class StaticProxyDemo {
    public static void main(String[] args) {
        Animals catProxy = new CatProxy();
        catProxy.say();
    }

}

interface Animals {
    void say();
}

class Cat implements Animals {
    public void say() {
        System.out.println("I am a cat!");
    }
}

class CatProxy implements Animals {
    private Cat cat = new Cat();
    public void say() {
        System.out.println("Before invoke say!");
        cat.say();
        System.out.println("After invoke say!");
    }
}
