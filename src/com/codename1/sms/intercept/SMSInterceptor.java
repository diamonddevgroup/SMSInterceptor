package com.codename1.sms.intercept;

import com.codename1.system.NativeLookup;
import com.codename1.util.SuccessCallback;

/**
 *
 * @author Shai, Diamond
 *
 * This is a high level abstraction of the native classes and callbacks rolled
 * into one.
 */
public class SMSInterceptor {

    private static NativeSMSInterceptor nativeImpl;

    private static NativeSMSInterceptor get() {
        if (nativeImpl == null) {
            nativeImpl = NativeLookup.create(NativeSMSInterceptor.class);
            if (!nativeImpl.isSupported()) {
                nativeImpl = null;
            }
        }
        return nativeImpl;
    }

    public static boolean isSupported() {
        return get() != null;
    }

    public static void grabNextSMS(SuccessCallback<String> onSuccess) {
        if (isSupported()) {
            SMSCallback.onSuccess = onSuccess;
            get().bindSMSListener();
        }
    }

    static void unbindListener() {
        if (isSupported()) {
            get().unbindSMSListener();
        }
    }
}
