package designMode.singleton;

/**
 * �ŵ㣺�ӳټ��أ���Ҫ��ʱ���ȥ���أ����ʺϵ��̲߳���
 * ȱ�㣺�̲߳���ȫ���ڶ��߳��к����׳��ֲ�ͬ����������������ݿ�������Ƶ����д����ʱ��
 * @author 55083
 *
 */
public class Singleton {

	// ����˽�о�̬ʵ�������ñ����á��˴�����Ϊnull��Ŀ����ʵ���ӳټ���
	private static Singleton instance = null;

	// ˽�й��췽������ֹ��ʵ����
	private Singleton() {
	}

	// ����ʽ����̬��������������ʵ��
	public Singleton getInstance() {
		if (instance == null) {
			instance = new Singleton();
		}
		return instance;
	}
}
