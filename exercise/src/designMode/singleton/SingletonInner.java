package designMode.singleton;

/**
 *	�ŵ㣺�ӳټ��أ��̰߳�ȫ��Java��class����ʱ����ģ���Ҳ�������ڴ����ģ��Ƽ�ʹ���ڲ��෽ʽ�� 
 *
 */
public class SingletonInner {

	/**
	 * �ڲ���ʵ�ֵ���ģʽ
	 * �ӳټ��أ������ڴ濪��
	 */
	private static class SingletonHandler{
		private static SingletonInner instance = new SingletonInner();
	}

	// ˽�й��캯��
	private SingletonInner(){}
	
	public static SingletonInner getInstance(){
		return SingletonHandler.instance;
	}
	
	protected void method(){
		System.out.println("SingletonInner");
	}
}
