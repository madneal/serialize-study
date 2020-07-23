import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class DynamicProxyDemo {
    public static void main(String[] args) {
        Animals cat = new Cat();
        InvocationHandler handler = (InvocationHandler) new CatProxyHandler(cat);
        Animals catProxy = (Animals) Proxy.newProxyInstance(Cat.class.getClassLoader(), Cat.class.getInterfaces(), handler);
        catProxy.say();
    }
}

//interface Animals {
//    void say();
//}
//
//class Cat implements Animals {
//    public void say() {
//        System.out.println("I am a cat!");
//    }
//}

class CatProxyHandler implements InvocationHandler {
    private Object obj;

    public CatProxyHandler(Object obj) {
        this.obj = obj;
    }

    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("Before invoke " + method.getName());
        method.invoke(obj, args);
        System.out.println("After invoke " + method.getName());
        return null;
    }
}
