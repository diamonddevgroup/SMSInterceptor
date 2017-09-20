(function(exports){

var o = {};

    o.unbindSMSListener_ = function(callback) {
        callback.error(new Error("Not implemented yet"));
    };

    o.bindSMSListener_ = function(callback) {
        callback.error(new Error("Not implemented yet"));
    };

    o.isSupported_ = function(callback) {
        callback.complete(false);
    };

exports.com_codename1_sms_intercept_NativeSMSInterceptor= o;

})(cn1_get_native_interfaces());
