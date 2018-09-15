
# StartActivityForResultHelper(Kotlin) [![](https://jitpack.io/v/yizeliang/StartActivityForResultHelper.svg)](https://jitpack.io/#yizeliang/StartActivityForResultHelper)

灵感来自`RxPermission`


```kotlin
this@MainActivity.startActivityForResult(Intent(this@MainActivity, MainActivity::class.java),1000) {
                Log.e("AAA", it.resultCode.toString())
            }

```






