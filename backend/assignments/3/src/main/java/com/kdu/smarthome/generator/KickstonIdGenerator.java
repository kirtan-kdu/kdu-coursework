package com.kdu.smarthome.generator;

import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;

import java.io.Serializable;
import java.util.concurrent.atomic.AtomicInteger;

public class KickstonIdGenerator implements IdentifierGenerator {

    private AtomicInteger counter = new AtomicInteger(1);

    @Override
    public Serializable generate(SharedSessionContractImplementor session, Object object) throws HibernateException {
        int count = counter.getAndIncrement();
        StringBuilder hexStrBuilder = new StringBuilder(Integer.toHexString(count));
        while (hexStrBuilder.length() < 6) {
            hexStrBuilder.insert(0, '0');
        }
        return hexStrBuilder.toString().toUpperCase();

    }
}
