package designMode.singleton;

/**
 * �е㣺�ӳټ��أ��̰߳�ȫ
 * ȱ�㣺д�����ӣ������
 * @author 55083
 *
 */
public class SingletonSafe {

	// ��������� volatile
	private static volatile SingletonSafe instance = null;
	
	// ˽�еĹ��캯��
	private SingletonSafe(){}
	
	public static SingletonSafe getInstance(){
		SingletonSafe inst = instance;		// �����ﴴ����ʱ����
		if(inst== null){
			synchronized(SingletonSafe.class){
				inst = instance;
				if(inst == null){
					inst = new SingletonSafe();
					instance = inst;
				}
			}
		}
		return inst;		//ע�⣬���ﷵ�ص�����ʱ����
	}
	
	protected void method(){
		System.out.println("SingletonSafe............");
	}
}
