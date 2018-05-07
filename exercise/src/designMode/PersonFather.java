package designMode;

import java.util.List;

public abstract class PersonFather extends BaseJSONBean{

	List<String> fields = null;
	
	abstract public Object get(int index);
	
	abstract public void set(int index,Object obj);
}
