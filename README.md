# decode-problem
https://stackoverflow.com/questions/58053650/how-to-make-android-base64-decode-reliable-throws-exception-or-returning-null

We notice when dealing with invalid base64 encoded String, android.util.Base64.decode yields inconsistent behavior.

Please refer to the following screenshots. Unlike the rest, you will notice the first screenshot doesn't throw any exception (which is incorrect behavior)

![alt text](https://github.com/yccheok/decode-problem/raw/master/0.png)

![alt text](https://github.com/yccheok/decode-problem/raw/master/1.png)

![alt text](https://github.com/yccheok/decode-problem/raw/master/2.png)

![alt text](https://github.com/yccheok/decode-problem/raw/master/3.png)
