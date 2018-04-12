package designMode.singleton;

/**
 * 有点：延迟加载，线程安全
 * 缺点：写法复杂，不简洁
 * @author 55083
 *
 */
public class SingletonSafe {

	// 这里添加了 volatile
	private static volatile SingletonSafe instance = null;
	
	// 私有的构造函数
	private SingletonSafe(){}
	
	public static SingletonSafe getInstance(){
		SingletonSafe inst = instance;		// 在这里创建临时变量
		if(inst== null){
			synchronized(SingletonSafe.class){
				inst = instance;
				if(inst == null){
					inst = new SingletonSafe();
					instance = inst;
				}
			}
		}
		return inst;		//注意，这里返回的是临时变量
	}
	
	protected void method(){
		System.out.println("SingletonSafe............");
	}
}
