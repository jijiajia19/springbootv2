package com.jacle.springbootv2.springbootv2.lifecycle;

import org.springframework.context.Lifecycle;

/**
 * @author jacle
 * @version 1.0
 * @description: 容器生命周期触发事件
 * 在SpringBoot或Spring应用中如果没有调用AbstractApplicationContext#start方法，
 * 只是实现了Lifecycle接口，是不会执行Lifecycle接口中的启动方法和isRunning方法的。
 *
 * lifecycle需要显示调用才会生效
 *
 * @date 12/15/2021 4:13 PM
 */
//@Component
public class MyLifeCycle implements Lifecycle
{
	//Java volatile
	//：
	//对变量的写操作不依赖于当前值
	//该变量没有包含在具有其他变量的不变式中
	//第一个条件就是不能是自增自减等操作，上文已经提到volatile不保证原子性。
	//第二个条件我们来举个例子它包含了一个不变式 ：下界总是小于或等于上界

	//多线程读取，立即可见，会促使单个线程的缓存失效
	private volatile boolean running=true;

	/**
	 * 容器启动后调用
	 */
	@Override
	public void start()
	{
		System.out.println("容器启动后执行MyLifeCycle操作...");
		running = true;
	}

	/**
	 * 容器停止时调用
	 */
	@Override
	public void stop()
	{
		System.out.println("收到关闭容器的信号MyLifeCycle操作...");
		running = false;
	}

	/**
	 * 检查此组件是否正在运行。 1. 只有该方法返回false时，start方法才会被执行。 2. 只有该方法返回true时，stop(Runnable
	 * callback)或stop()方法才会被执行。
	 */
	@Override
	public boolean isRunning()
	{
		System.out.println("检查MyLifeCycle组件的运行状态：" + running);
		return running;
	}

}
