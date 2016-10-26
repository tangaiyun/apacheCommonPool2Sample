package com.dttech.commonpool2;

import org.apache.commons.pool2.BasePooledObjectFactory;
import org.apache.commons.pool2.PooledObject;
import org.apache.commons.pool2.impl.DefaultPooledObject;

public class SessionPoolFactory extends BasePooledObjectFactory<SessionSample> {

	@Override
	public SessionSample create() throws Exception {
		Thread.sleep(100);
		SessionSample ss = new SessionSample();
		ss.setStatus(SessionSample.SessionStatus.INITIALIZING);
		ss.init();
		ss.setStatus(SessionSample.SessionStatus.INITIALIZED);
		return ss;
	}

	@Override
	public PooledObject<SessionSample> wrap(SessionSample obj) {
		System.out.println("session wraped.");

		return new DefaultPooledObject<SessionSample>(obj);
	}

	@Override
	public void destroyObject(PooledObject<SessionSample> p) throws Exception {
		System.out.println("session destroy");
		p.getObject().setStatus(SessionSample.SessionStatus.DESTROYED);
	}

	@Override
	public PooledObject<SessionSample> makeObject() throws Exception {
		System.out.println("session create");
		return wrap(create());
	}
	
	/**
     * This implementation always returns {@code true}.
     *
     * @param p ignored
     *
     * @return {@code true}
     */
    @Override
    public boolean validateObject(PooledObject<SessionSample> p) {
//    	System.out.println("session validate");
        return p.getObject().getStatus() == SessionSample.SessionStatus.INITIALIZED;
    }

    /**
     *  No-op.
     *
     *  @param p ignored
     */
    @Override
    public void activateObject(PooledObject<SessionSample> p) throws Exception {
//    	System.out.println("session activate");
    }

    /**
     *  No-op.
     *
     * @param p ignored
     */
    @Override
    public void passivateObject(PooledObject<SessionSample> p)
        throws Exception {
//    	System.out.println("session passivate");
    }

}
