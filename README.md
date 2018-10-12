
# StartActivityForResultHelper 

[![](https://jitpack.io/v/yizeliang/StartActivityForResultHelper.svg)](https://jitpack.io/#yizeliang/StartActivityForResultHelper)

灵感来自`RxPermission`


```java

//kotlin
this@MainActivity.startActivityForResult(Intent(this@MainActivity, MainActivity::class.java),1000,false) {
                Log.e("AAA", it.resultCode.toString())
            }
 //如果简洁模式,只有RESULT_OK 才会执行,默认为true
 this@MainActivity.startActivityForResult(Intent(this@MainActivity, MainActivity::class.java)) {
                 Log.e("AAA", it.resultCode.toString())
             }
//java

 ActivityHelper.startActivityForResult(this, new Intent(this, MainActivity.class),1000,
                new ActivityHelper.Callback(false) {
                    @Override
                    protected void onResult(ActivityResult result) {

                    }
                });

 ActivityHelper.startActivityForResult(this, new Intent(this, MainActivity.class),
                new ActivityHelper.Callback() {
                    @Override
                    protected void onResult(ActivityResult result) {

                    }
                });

```






