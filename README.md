# SMSInterceptor
Intercept incoming sms on supported platforms (Android) in Codename One

Installation
============

- Download SMSInterceptor.cn1lib to your project from CodenameOne Extensions Library (Right-click -> Codename One -> CodenameOne Settings -> Extensions -> Search for comScore)

- Right-click your project and do `Refresh cn1Libs` to generate the necessary classes.


Usage
=====

    //Method to generate random strings
    public static String randomString(int length) {
        return randomString(length, false);
    }

    //Method to generate random strings
    public static String randomString(int length, boolean numberOnly) {
        char[] characterSet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ123456789".toCharArray();
        char[] characterNumberSet = "0123456789".toCharArray();
        Random random = new Random();
        char[] result = new char[length];
        if (numberOnly) {
            for (int i = 0; i < result.length; i++) {
                int randomCharIndex = random.nextInt(characterNumberSet.length);
                result[i] = characterNumberSet[randomCharIndex];
            }
        } else {
            for (int i = 0; i < result.length; i++) {
                int randomCharIndex = random.nextInt(characterSet.length);
                result[i] = characterSet[randomCharIndex];
            }
        }
        return new String(result);
    }

        String code = randomString(6, true);
        // Send the code in an sms to user phone number

        //Listen to incoming sms on the code input form
        myForm.addShowListener(evt -> {
            SMSInterceptor.grabNextSMS((value) -> {
                if (value.contains(code)) { //check if the sms contains the code that was sent to user phone number
                    codeTextField.setText(code);
                    verify(code); // verify user with the code
                }
            });
        });
