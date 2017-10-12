# SMSInterceptor
Intercept incoming sms on supported platforms (Android) in Codename One

# Installation

- Download SMSInterceptor.cn1lib to your project from CodenameOne Extensions Library (Right-click -> Codename One -> CodenameOne Settings -> Extensions -> Search for SMSInterceptor)

- Right-click your project and do `Refresh cn1Libs` to generate the necessary classes.


# Usage

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


# License

MIT License

Copyright (c) 2017 Diamond Dev Group

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.
