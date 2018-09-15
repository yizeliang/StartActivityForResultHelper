
# StartActivityForResultHelper 

[![](https://jitpack.io/v/yizeliang/StartActivityForResultHelper.svg)](https://jitpack.io/#yizeliang/StartActivityForResultHelper)

灵感来自`RxPermission`


```java

//kotlin
this@MainActivity.startActivityForResult(Intent(this@MainActivity, MainActivity::class.java),1000) {
                Log.e("AAA", it.resultCode.toString())
            }
//java
ActivityHelper.startActivityForResult(this, new Intent(this, MainActivity.class), 100,
        new ActivityHelper.Callback() {
            @Override
            public void onResult(ActivityResult result) {

            }
        });

```






