package com.alam.app.alam_app;

import java.util.List;  
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;


public class alamTest05 {
	/*定义user 属性username age school
	 * List<user>
	 * 基于school分组 MAP<String,List<user>>
	 * 遍历每个分组中的所有user
	 * */
		public static void main(String[] args){
			ArrayList<User> lu = new ArrayList<User>();
			
			String[] schools = { "schoolAAA", "schoolBBB" };
		    ArrayList<String> schoolsList = new ArrayList<String>(Arrays.asList(schools));
		    
		    Map<String, List<User>> alamMap = new HashMap<String, List<User>>();
		    
		    /* ��������alamUser */
			User alamUser = new User();
			alamUser.setAge(12);
			alamUser.setUsername("Alam");
			alamUser.setSchool(schoolsList.get(0));
			System.out.println(alamUser);
			lu.add(alamUser);
			
			/* ��������bibiUser */
			User bibiUser = new User();
			bibiUser.setAge(2);
			bibiUser.setUsername("bibi");
			bibiUser.setSchool(schoolsList.get(1));
			lu.add(bibiUser);
			System.out.println(bibiUser);
			
			/* ��������ciciUser */
			User ciciUser = new User();
			ciciUser.setAge(22);
			ciciUser.setUsername("cici");
			ciciUser.setSchool(schoolsList.get(0));
			lu.add(ciciUser);
			System.out.println(ciciUser);
			
			//��ӵ�map��,��key��ѧУ,value��user list
			for(User u:lu) {
				List<User> ls = alamMap.get(u.getSchool());
//				System.out.print(u.getUsername());
//				System.out.println(u.getSchool());
				if(null == ls|| ls.size() ==0 ){
					ls =new ArrayList<User>();
				}
				ls.add(u);
				alamMap.put(u.getSchool(), ls);
			}
			
			//���map
			for (String key : alamMap.keySet()) {
			    System.out.println(key + " :" + alamMap.get(key));
			    if(alamMap.get(key).size() >1 ){
			    	for(User u:lu) {
			    		System.out.println(u);
			    	}
				}
			}
		 }
//	}
}