package designMode;

/**
 * 线程安全的单例设计模式
 * @author 55083
 *
 */
public class Singleton {
	
	private static volatile Singleton singletonInstance;
	
	private Singleton(){}
	
	// 方法是静态的，即类加载的时候就创建实例。因为让类的实例去生成另一个唯一实例毫无意义
	public static Singleton getInstance(){
		synchronized (Singleton.class) {	//要保证线程安全，就得加锁
			if(singletonInstance==null){	//只有实例为空的时候，才创建实例，否则，直接返回。
				singletonInstance = new Singleton();
			}
		}
		return singletonInstance;
	}
}
