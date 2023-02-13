package front;

import java.util.HashMap;
import java.util.Map;

import controller.ListController;

public class RequestMapping {
	public static Map<RequestKeyValue, Handle> mapping = new HashMap<>();
	
	public static void init() {
		mapping.put(new RequestKeyValue("/list", "GET"), new ListController() );
	}
	
	public static Handle getHandler(RequestKeyValue key) {
		return mapping.get(key);
	}
	
}