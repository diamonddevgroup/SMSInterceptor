package com.codename1.sms.intercept;

import com.codename1.system.NativeInterface;

/**
 *
 * @author Shai, Diamond
 */
public interface NativeSMSInterceptor extends NativeInterface {

    public void bindSMSListener();

    public void unbindSMSListener();
}
