package com.sentimentanalysis.util;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Utility class for REST Operations 
 * 
 * @author Vishvesh
 */
public abstract class RestUtils {
	
	/**
	 * Conversion Utility for custom/native join queries, which return Object[]
	 */
	public Map<Object, Object> mapResult(List<Object[]> result) {
		Map<Object, Object> map = null;
		if (result != null && !result.isEmpty()) {
			map = new HashMap<Object, Object>();
			for (Object[] object : result) {
				map.put((object[0]), object[1]);
			}
		}
		return map;
	}
}
