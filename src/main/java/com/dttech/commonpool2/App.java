package com.dttech.commonpool2;

import java.util.Random;
import java.util.concurrent.CountDownLatch;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Hello world!
 *
 */
public class App {
	/**
	 * Main方法.
	 * 
	 * @param args
	 *            参数
	 */
	public static final void main(String[] args) {

		try {
			ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
			final SessionSamplePool sessionSamplePool = (SessionSamplePool) ac.getBean("SessionSamplePool");
			Random r = new Random();
			int n = 0;
			while (true) {
				n++;
				int count = 0;
				if (n <= 10) {
					count = r.nextInt(20);
				} else {
					count = 1;
				}
				System.out.println("Thread count: " + count + "*****************************");
				final CountDownLatch cdl = new CountDownLatch(count);
				for (int i = 0; i < count; i++) {
					new Thread(new Runnable() {
						@Override
						public void run() {

							SessionSample session = null;
							try {
								session = sessionSamplePool.borrowObject();
								Thread.sleep(200);
								cdl.countDown();
							} catch (Exception e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							} finally {

								sessionSamplePool.returnObject(session);

							}

						}
					}) {
					}.start();
				}
				cdl.await();
				Thread.sleep(5000);
				System.out.println("created count: " + sessionSamplePool.getCreatedCount());
				System.out.println("destroyed count: " + sessionSamplePool.getDestroyedCount());
				System.out.println("number active: " + sessionSamplePool.getNumActive());
				System.out.println("number idle: " + sessionSamplePool.getNumIdle());
				System.out.println("EvictionPolicyClassName: " + sessionSamplePool.getEvictionPolicyClassName());
				System.out.println("DestroyedByEvictorCount: " + sessionSamplePool.getDestroyedByEvictorCount());
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}

	}
}
