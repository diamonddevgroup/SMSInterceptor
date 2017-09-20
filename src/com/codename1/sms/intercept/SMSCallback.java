package com.codename1.sms.intercept;

import static com.codename1.ui.CN.*;
import com.codename1.util.FailureCallback;
import com.codename1.util.SuccessCallback;

/**
 *
 * @author Shai, Diamond
 *
 * This is an internal class, it's package protect to hide that
 */
class SMSCallback {

    static SuccessCallback<String> onSuccess;
    static FailureCallback onFail;

    public static void smsReceived(String sms) {
        if (onSuccess != null) {
            SuccessCallback<String> s = onSuccess;
            onSuccess = null;
            onFail = null;
            SMSInterceptor.unbindListener();
            callSerially(() -> s.onSucess(sms));
        }
    }

    public static void smsReceiveError(Exception err) {
        if (onFail != null) {
            FailureCallback f = onFail;
            onFail = null;
            SMSInterceptor.unbindListener();
            onSuccess = null;
            callSerially(() -> f.onError(null, err, 1, err.toString()));
        } else {
            if (onSuccess != null) {
                SMSInterceptor.unbindListener();
                onSuccess = null;
            }
        }
    }
}
