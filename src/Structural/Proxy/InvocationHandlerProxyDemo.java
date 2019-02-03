package Structural.Proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

interface Task {
	public void setData(String data);
	public int getCalData(int x);
}

class TaskImpl implements Task {
	@Override
	public void setData(String data) {
		System.out.println(data + " >> Data is saved");
	}
	@Override
	public int getCalData(int x) {
		return x * 10;
	}
}

class MyInvocationHandler implements InvocationHandler {
	private Object obj;

	public MyInvocationHandler(Object obj) {
		this.obj = obj;
	}

	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		Object result;
		try {
			if (method.getName().contains("set")) {
				System.out.println("...Setter Method Executing...");
			}
			result = method.invoke(obj, args);
		} catch (Exception e) {
			throw e;
		}
		return result;
	}
}

public class InvocationHandlerProxyDemo {
	public static void main(String[] args) {
		
		Task originalTask = new TaskImpl();
		InvocationHandler invocationHandlerImpl = new MyInvocationHandler(originalTask);
		
		Task proxyTask = (Task) Proxy.newProxyInstance(originalTask.getClass().getClassLoader(), 
													   originalTask.getClass().getInterfaces(),
				 								       invocationHandlerImpl);
		
		proxyTask.setData("Test");
		System.out.println(proxyTask.getCalData(5));
	}
}
