package designMode.singleton;

/**
 * 优点：延迟加载（需要的时候才去加载），适合单线程操作
 * 缺点：线程不安全，在多线程中很容易出现不同步的情况，如在数据库对象进行频繁读写操作时。
 * @author 55083
 *
 */
public class Singleton {

	// 持有私有静态实例，放置被引用。此处复制为null，目的是实现延迟加载
	private static Singleton instance = null;

	// 私有构造方法，防止被实例化
	private Singleton() {
	}

	// 懒汉式，静态工厂方法，创建实例
	public Singleton getInstance() {
		if (instance == null) {
			instance = new Singleton();
		}
		return instance;
	}
}
