import dao.impl.ProductDAOImpl;
import model.Product;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ReflectionTests {
    public static void main(String[] args) throws InvocationTargetException, IllegalAccessException {
        Product product1 = new Product();
        Product product2 = new Product();
        product1.setProductCode("ajsdh");
        product1.setBuyPrice(123);
        product1.setProductDescription("sadhowerh");
        //Root reflections Class;
        Class<Product> pClass = Product.class;

//        System.out.println(pClass == product1.getClass());
//        System.out.println(pClass == product2.getClass());

        System.out.println("fields :");
        for(Field field : pClass.getDeclaredFields()) {
            System.out.println(field.getName());
        }

        System.out.println();
        System.out.println("methods :");
        for (Method method : pClass.getDeclaredMethods()) {
            if (method.getName().startsWith("set")) {
                System.out.println(method.getName());
            }
            if (method.getName().startsWith("get")) {
                Object o = method.invoke(product1, null);
                System.out.println(o);
            }
        }
        System.out.println(new ProductDAOImpl().findById("S10_4698"));
    }
}
