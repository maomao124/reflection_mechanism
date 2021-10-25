import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.LinkedList;
import java.util.Scanner;

/**
 * Project name(项目名称)：反射机制
 * Package(包名): PACKAGE_NAME
 * Class(类名): test
 * Author(作者）: mao
 * Author QQ：1296193245
 * Date(创建日期)： 2021/10/25
 * Time(创建时间)： 18:21
 * Version(版本): 1.0
 * Description(描述)： Java 反射机制是在运行状态中，对于任意一个类，都能够知道这个类的所有属性和方法；对于任意一个对象，
 * 都能够调用它的任意方法和属性；这种动态获取信息以及动态调用对象方法的功能称为 Java 语言的反射机制。简单来说，
 * 反射机制指的是程序在运行时能够获取自身的信息。在 Java 中，只要给定类的名字，就可以通过反射机制来获得类的所有信息。
 * Java 反射机制在服务器程序和中间件程序中得到了广泛运用。在服务器端，往往需要根据客户的请求，动态调用某一个对象的特定方法。
 * 此外，在 ORM 中间件的实现中，运用 Java 反射机制可以读取任意一个 JavaBean 的所有属性，或者给这些属性赋值。
 * Java 反射机制主要提供了以下功能，这些功能都位于java.lang.reflect包。
 * 在运行时判断任意一个对象所属的类。
 * 在运行时构造任意一个类的对象。
 * 在运行时判断任意一个类所具有的成员变量和方法。
 * 在运行时调用任意一个对象的方法。
 * 生成动态代理。
 * 要想知道一个类的属性和方法，必须先获取到该类的字节码文件对象。获取类的信息时，使用的就是 Class 类中的方法。
 * 所以先要获取到每一个字节码文件（.class）对应的 Class 类型的对象.
 * 众所周知，所有 Java 类均继承了 Object 类，在 Object 类中定义了一个 getClass() 方法，该方法返回同一个类型为 Class 的对象。
 * 类型	    访问方法	    返回值类型	说明
 * 包路径	getPackage()	Package 对象	获取该类的存放路径
 * 类名称	getName()	String 对象	获取该类的名称
 * 继承类	getSuperclass()	Class 对象	获取该类继承的类
 * 实现接口	getlnterfaces()	Class 型数组	获取该类实现的所有接口
 * 构造方法	getConstructors()	Constructor 型数组	获取所有权限为 public 的构造方法
 * p          getDeclaredContruectors()	Constructor 对象	获取当前对象的所有构造方法
 * 方法	getMethods()	Methods 型数组	获取所有权限为 public 的方法
 * p            getDeclaredMethods()	Methods 对象	获取当前对象的所有方法
 * 成员变量	getFields()	Field 型数组	获取所有权限为 public 的成员变量
 * p          getDeclareFileds()	Field 对象	获取当前对象的所有成员变量
 * 内部类	getClasses()	Class 型数组	获取所有权限为 public 的内部类
 * p         getDeclaredClasses()	Class 型数组	获取所有内部类
 * 内部类的声明类	getDeclaringClass()	Class 对象	如果该类为内部类，则返回它的成员类，否则返回 null
 * 优点：
 * 能够运行时动态获取类的实例，大大提高系统的灵活性和扩展性。
 * 与 Java 动态编译相结合，可以实现无比强大的功能。
 * 对于 Java 这种先编译再运行的语言，能够让我们很方便的创建灵活的代码，这些代码可以在运行时装配，无需在组件之间进行源代码的链接，更加容易实现面向对象。
 * 缺点：
 * 反射会消耗一定的系统资源，因此，如果不需要动态地创建一个对象，那么就不需要用反射；
 * 反射调用方法时可以忽略权限检查，获取这个类的私有方法和属性，因此可能会破坏类的封装性而导致安全问题。
 * java.lang.reflect 包
 * java.lang.reflect 包提供了反射中用到类，主要的类说明如下：
 * Constructor 类：提供类的构造方法信息。
 * Field 类：提供类或接口中成员变量信息。
 * Method 类：提供类或接口成员方法信息。
 * Array 类：提供了动态创建和访问 Java 数组的方法。
 * Modifier 类：提供类和成员访问修饰符信息。
 */

public class test
{
    public static void main(String... args)
    {
        //------------------------------------------------------
        long startTime = System.nanoTime();   //获取开始时间
        //------------------------------------------------------
        // 获得Class实例
        // 1.通过类型class静态变量
        Class clz1 = String.class;
        String str = "Hello";
        // 2.通过对象的getClass()方法
        Class clz2 = str.getClass();
        // 获得int类型Class实例
        Class clz3 = int.class;
        // 获得Integer类型Class实例
        Class clz4 = Integer.class;
        System.out.println("clz1类名称：" + clz1.getName());
        System.out.println("clz2类名称：" + clz2.getName());
        System.out.println("clz3类名称：" + clz3.getName());
        System.out.println("clz4类名称：" + clz4.getName());
        System.out.println("clz1是否为接口：" + clz1.isInterface());
        System.out.println("clz2是否为接口：" + clz2.isInterface());
        System.out.println("clz3是否为接口：" + clz3.isInterface());
        System.out.println("clz4是否为接口：" + clz4.isInterface());
        System.out.println("clz1是否为数组对象：" + clz1.isArray());
        System.out.println("clz2是否为数组对象：" + clz2.isArray());
        System.out.println("clz3是否为数组对象：" + clz3.isArray());
        System.out.println("clz4是否为数组对象：" + clz4.isArray());
        System.out.println("clz1父类名称：" + clz1.getSuperclass().getName());
        System.out.println("clz2父类名称：" + clz2.getSuperclass().getName());
        //System.out.println("clz3父类名称：" + clz3.getSuperclass().getName());
        System.out.println("clz4父类名称：" + clz4.getSuperclass().getName());
        System.out.println("clz1是否为基本类型：" + clz1.isPrimitive());
        System.out.println("clz2是否为基本类型：" + clz2.isPrimitive());
        System.out.println("clz3是否为基本类型：" + clz3.isPrimitive());
        System.out.println("clz4是否为基本类型：" + clz4.isPrimitive());
        System.out.println();
        try
        {
            // 动态加载xx类的运行时对象
            Class c;
            if (args.length == 0)
            {
                c = Class.forName("java.lang.String");
            }
            else
            {
                System.out.println(args[0]+":");
                c = Class.forName(args[0]);
            }
            // 获取成员方法集合
            Method[] methods = c.getDeclaredMethods();
            // 遍历成员方法集合
            for (Method method : methods)
            {
                // 打印权限修饰符，如public、protected、private
                System.out.print(Modifier.toString(method.getModifiers()));
                // 打印返回值类型名称
                System.out.print(" " + method.getReturnType().getName() + " ");
                // 打印方法名称
                System.out.println(method.getName() + "();");
            }
            System.out.println("数量："+methods.length);
        }
        catch (ClassNotFoundException e)
        {
            System.out.println("找不到指定类");
        }
        System.out.println();
        //------------------------------------------------------
        long endTime = System.nanoTime(); //获取结束时间
        if ((endTime - startTime) < 1000000)
        {
             double final_runtime;
             final_runtime = (endTime - startTime);
             final_runtime = final_runtime / 1000;
             System.out.println("算法运行时间： " + final_runtime + "微秒");
        }
        else if ((endTime - startTime) >= 1000000 && (endTime - startTime) < 10000000000L)
        {
            double final_runtime;
            final_runtime = (endTime - startTime) / 1000;
            final_runtime = final_runtime / 1000;
            System.out.println("算法运行时间： " + final_runtime + "毫秒");
         }
        else
        {
             double final_runtime;
             final_runtime = (endTime - startTime) / 10000;
             final_runtime = final_runtime / 100000;
             System.out.println("算法运行时间： " + final_runtime + "秒");
        }
        Runtime r = Runtime.getRuntime();
        float memory;
        memory = r.totalMemory();
        memory = memory / 1024 / 1024;
        System.out.printf("JVM总内存：%.3fMB\n", memory);
        memory = r.freeMemory();
        memory = memory / 1024 / 1024;
        System.out.printf(" 空闲内存：%.3fMB\n", memory);
        memory = r.totalMemory() - r.freeMemory();
        memory = memory / 1024 / 1024;
        System.out.printf("已使用的内存：%.4fMB\n", memory);
        //------------------------------------------------------
    }
}
