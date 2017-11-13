package util;

import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;

public class CommonUtil {
	
	public static String newGuid() {
		return UUID.randomUUID().toString().toUpperCase().replace("-", "");
	}

	
	public static List<Map<String, Object>> dataNull_jh(List<Map<String, Object>> list) {
		if(list==null || list.isEmpty()){
			return Collections.emptyList();
		}else{
			for (Map a : list) {
				mapNull_jh(a);
			}
			return list;
		}
		
	}
	
	
	public static Map<String, Object> mapNull_jh(Map<String, Object> a) {
		if(a==null ||a.isEmpty()){
			return (Map<String, Object>) Collections.emptySet();
		}else{
			Set<String> set = a.keySet();
			for (String s : set) {
				if (a.get(s) == null) {
					a.put(s, "");
				}else{
					a.put(s, a.get(s));
				}
			}
			return a;
		}
	}
	
	public static String getDatetime(){
		SimpleDateFormat sdf =new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return sdf.format(new Date());
	}
	
}
