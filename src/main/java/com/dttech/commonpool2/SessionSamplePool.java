package com.dttech.commonpool2;

import org.apache.commons.pool2.impl.GenericObjectPool;

public class SessionSamplePool {

	private GenericObjectPool<SessionSample> poolImpl;

	public SessionSamplePool(SessionPoolFactory sessionPoolFactory) {
		poolImpl = new GenericObjectPool<SessionSample>(sessionPoolFactory);
	}

	public void setMaxTotal(int maxTotal) {
		poolImpl.setMaxTotal(maxTotal);
	}

	public void setMaxIdle(int maxIdle) {
		poolImpl.setMaxIdle(maxIdle);
	}

	public void setMinIdle(int minIdle) {
		poolImpl.setMinIdle(minIdle);
	}

	public int getMaxTotal() {
		return poolImpl.getMaxTotal();
	}

	public int getMaxIdle() {
		return poolImpl.getMaxIdle();
	}

	public int getMinIdle() {
		return poolImpl.getMinIdle();
	}

	public long getCreatedCount() {
		return poolImpl.getCreatedCount();
	}

	public long getDestroyedCount() {
		return poolImpl.getDestroyedCount();
	}

	public long getBorrowedCount() {
		return poolImpl.getBorrowedCount();
	}

	public int getNumActive() {
		return poolImpl.getNumActive();
	}

	public int get() {
		return poolImpl.getNumIdle();
	}

	public SessionSample borrowObject() throws Exception {
		return poolImpl.borrowObject();
	}

	public SessionSample borrowObject(long borrowMaxWaitMillis) throws Exception {
		return poolImpl.borrowObject(borrowMaxWaitMillis);
	}

	public void returnObject(SessionSample session) {
		poolImpl.returnObject(session);
	}
	public void setTestOnBorrow(boolean flag) {
		poolImpl.setTestOnBorrow(flag);
	}
	public void setMinEvictableIdleTimeMillis(long t) {
		poolImpl.setMinEvictableIdleTimeMillis(t);
	}
	
	public void setSoftMinEvictableIdleTimeMillis(long t) {
		poolImpl.setSoftMinEvictableIdleTimeMillis(t);
	}
	public void setTimeBetweenEvictionRunsMillis(long t) {
		poolImpl.setTimeBetweenEvictionRunsMillis(t);
	}
	public int getNumIdle() {
		return poolImpl.getNumIdle();
	}
	public String getEvictionPolicyClassName() {
		return poolImpl.getEvictionPolicyClassName();
	}
	public long getDestroyedByEvictorCount() {
		return poolImpl.getDestroyedByEvictorCount();
	}
}
