#import <Foundation/Foundation.h>

@interface com_codename1_sms_intercept_NativeSMSInterceptorImpl : NSObject {
}

-(void)unbindSMSListener;
-(void)bindSMSListener;
-(BOOL)isSupported;
@end
