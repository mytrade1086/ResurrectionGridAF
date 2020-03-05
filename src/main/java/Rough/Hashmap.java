package Rough;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class Hashmap {

	public static void main(String[] args) {
		
		Map<String,String> m=new HashMap<String,String>();	
		m.put("name", "sumit");
		m.put("place", "bhandara");
		m.put("edu", "BE");
			
		//Looping with keySet()
		Set<String> key =m.keySet();		
		for(String s:key) {
			System.out.println(m.get(s));
//			BE
//			sumit
//			bhandara			
		}
		
		
		//Looping with Values()
		Collection<String> s=m.values();	
		for(String str:s) {
			System.out.println(str);
//			BE
//			sumit
//			bhandara		
		}
		
		
		//entrySet()
		
		Set<Entry<String,String>>   es=m.entrySet();
		for(Entry<String,String>  i:es) {
			System.out.println(i.getKey() +" "+i.getValue());
//			edu BE
//			name sumit
//			place bhandara
		}
		
		
		
		//lambda map
		
		m.forEach((k,v) -> System.out.println(" map loop from lambda "+k+" "+ v));	
//		 map loop from lambda edu BE
//		 map loop from lambda name sumit
//		 map loop from lambda place bhandara
//		
		
		
		
		
		
		
		
		
		Set<String> ss=new HashSet<String>();
		ss.add("sumit");
		ss.add("neha");
		
		
		Iterator<String> i=ss.iterator();	
		while(i.hasNext()) {
			System.out.println(i.next());
		}

//		neha
//		sumit
		
		
		ss.forEach(st ->System.out.println("using lambda"+st));
//		using lambdaneha
//		using lambdasumit
		
		
		
		List<String> ls=new ArrayList<String>();
		
		ls.add("aabha");
		ls.add(1, "aastha");
		
		
		for(int j=0;j<ls.size();j++) {
			
			System.out.println(ls.get(j));
			
		}
		
//		aabha
//		aastha
		
	
		ls.forEach(a ->System.out.println("using lambda=>  "+a));
//		using lambda=>  aabha
//				using lambda=>  aastha
		
		
	}

}
