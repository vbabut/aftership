package com.aftership;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class test {

	public static void main(String[] args) {

		String[] input={"aaa","bbb","ccc","bbb","aaa","aaa"};//{​​​​​"aaa","bbb", "ccc", "bbb", "aaa", "aaa" };
		System.out.println(repeatedString(input));
	}
	private static String repeatedString(String[] strArray){
		String result=null;
		HashMap<String, Integer> h1= new HashMap<>();
		int secmax=0;
		int firstmax=0;
		String secStr=null;
		int len= strArray.length;
		if(len==0)
		{
			return null;
		}
		else{
			//add the count to hashmap
			for(String s:strArray){
				
				if(h1.get(s)!=null){
					h1.put(s, h1.get(s)+1);
					
				}else
					h1.put(s, 1);
			}
			
			if(!h1.isEmpty()){
				Iterator<Map.Entry<String, Integer>> it =h1.entrySet().iterator();
				while(it.hasNext()){
					Map.Entry<String, Integer> mp=it.next();
					int v= mp.getValue();
					//System.out.println("key:"+mp.getKey()+"--value--"+v);
					//System.out.println("v:"+v+"--firstmax--"+firstmax);
					if(v>firstmax){
						secmax=firstmax;
						firstmax=v;
						//System.out.println("in condition key:"+mp.getKey()+"--value--"+v);
						//System.out.println("key:"+secmax);
					}else if(v>secmax && v!=firstmax)
					{
						secmax=v;
					}
				}
				it=h1.entrySet().iterator();
				while(it.hasNext()){
					Map.Entry<String, Integer> mp=it.next();
					int v= mp.getValue();
					System.out.println("key:"+mp.getKey()+"--value--"+v);
					if(v==secmax){
						return secStr=mp.getKey();
					}
				}
			}
			
		}
		
		return result;
	}

}
