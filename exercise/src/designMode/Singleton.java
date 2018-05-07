package designMode;

/**
 * �̰߳�ȫ�ĵ������ģʽ
 * @author 55083
 *
 */
public class Singleton {
	
	private static volatile Singleton singletonInstance;
	
	private Singleton(){}
	
	// �����Ǿ�̬�ģ�������ص�ʱ��ʹ���ʵ������Ϊ�����ʵ��ȥ������һ��Ψһʵ����������
	public static Singleton getInstance(){
		synchronized (Singleton.class) {	//Ҫ��֤�̰߳�ȫ���͵ü���
			if(singletonInstance==null){	//ֻ��ʵ��Ϊ�յ�ʱ�򣬲Ŵ���ʵ��������ֱ�ӷ��ء�
				singletonInstance = new Singleton();
			}
		}
		return singletonInstance;
	}
}
