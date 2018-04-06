package com.dsy.dadui.common.beans;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.BeansException;

/**
 * <pre>
 * 参数处理类
 * </pre>
 * @author <a href="mailto:yangcheng@loonxi.com">杨成</a>
 * @version 1.0 2016年12月23日
 * @since 1.0
 */
public class Params extends Entity {
	
	private static final long serialVersionUID = -8249365317692990675L;

	/**
	 * 1.将为""值的参数值设为null；
	 * 2.将字符值的前后空格去除。
	 */
	public void cleanStringValue(){
		Method[] methods = this.getClass().getDeclaredMethods();
		for(Method method: methods){
			String methodName = method.getName();
			if(methodName.length() > 4 && "get".equals(methodName.substring(0, 3))){
				Object obj;
				try {
					obj = method.invoke(this);
					if(null != obj && obj instanceof String){
						String value = String.valueOf(obj);
						try {
							if("".equals(value.trim())){
								value = null;
							}else{
								value = value.trim();
							}
							this.getClass().getMethod("set"+methodName.substring(3), String.class).invoke(this, value);
						} catch (NoSuchMethodException e) {
							e.printStackTrace();
						} catch (SecurityException e) {
							e.printStackTrace();
						}
					}
				} catch (IllegalAccessException e) {
					e.printStackTrace();
				} catch (IllegalArgumentException e) {
					e.printStackTrace();
				} catch (InvocationTargetException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	public <T> T parseObject(Class<T> resultClazz){
		try {
			T t = resultClazz.newInstance();
			BeanUtils.copyProperties(this, t);
			return t;
		} catch (BeansException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public static boolean validateSqlParam(String param){
		String inj_str = "':and:exec:insert:select:delete:update:count:*:%:chr:mid:master:truncate:char:declare:;:or:-:+:,";
	    String inj_stra[] = inj_str.split(":");
	    for (int i = 0; i < inj_stra.length; i++) {
	      if (param.indexOf(" " + inj_stra[i])!=-1 || param.indexOf(inj_stra[i] + " ") != -1) {
	        return false;
	      }
	    }
	    return true;
	}
	
}
