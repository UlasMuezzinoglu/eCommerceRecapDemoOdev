package com.eCommerceRecapDemoOdev.core.concretes;

import com.eCommerceRecapDemoOdev.JLogger.JLoggerManager;
import com.eCommerceRecapDemoOdev.core.abstracts.LoggerService;

public class JLoggerManagerAdapter implements LoggerService {
    @Override
    public void log(String mesaj) {
        JLoggerManager jLoggerManager = new JLoggerManager();
        jLoggerManager.log("Mail Gönderildi." + mesaj);
    }
}
