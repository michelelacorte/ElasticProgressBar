# ElasticProgressBar
##IS NOW RELEASED!

![alt tag](https://raw.githubusercontent.com/Tibolte/ElasticDownload/master/success.gif)

![alt tag](https://raw.githubusercontent.com/Tibolte/ElasticDownload/master/fail.gif)

Elastic Progress Bar , is a loading bar made ​​for Android , the initial design is https://github.com/Tibolte/ElasticDownload , I applied some changes to make it accessible to everyone!

##USAGE

Elastic Progress Bar is pushed to JCenter, so you just need to add the following dependency to your `build.gradle`.
```
compile 'com.example.michele.michelelacorteelasticprogressbar:michelelacorteelasticprogressbar:1.0.2
```

In alternative you can use AAR repository with:

```
buildscript {
    repositories {
        maven{
            url "https://dl.bintray.com/michelelacorte/maven/"
        }
        jcenter()
    }
}
```

And add this dependecies

```
compile 'com.example.michele.michelelacorteelasticprogressbar:michelelacorteelasticprogressbar:1.0.2@aar'
```

In you `layout.xml`

```
    <com.example.michele.michelelacorteelasticprogressbar.ElasticDownloadView
        android:id="@+id/elastic_download_view"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_alignParentBottom="true"
        android:layout_centerInParent="true"/>
```

Then in your `MainActivity.java`

```
ElasticDownloadView mElasticDownloadView;
mElasticDownloadView = (ElasticDownloadView)findViewById(R.id.elastic_download_view);

//Call startIntro() to start animation
mElasticDownloadView.startIntro();

//You can set progress
mElasticDownloadView.setProgress(10);

//If is finish animation
 mElasticDownloadView.success();
 
//Or fail
//mElasticDownloadView.fail();
```

You can set color background with (default is `colorPrimary`), make sure to call this before `setContentView(..)` of your activity:

```
OptionView.setBackgroundColorSquare(int color)
```

For set `noBackground` do this (without `setBackgroundColorSquare`, remember `setBackgroundColorSquare` is priority than `noBackground`

```
OptionView.noBackground = true;
```

![alt tag](http://s27.postimg.org/t7xk0iqz7/Screenshot_2015_11_02_15_21_25.png)

![alt tag](http://s1.postimg.org/g5wq1wwn3/Screenshot_2015_11_02_15_21_32.png)


##SYSTEM REQUIREMENT

Android API 21+

##CHANGELOG

**v1.0.3 Coming Soon**
- Compatibility with API 8+
- Boolean noIntro for set-up progress bar with no intro
- Add Example App to GitHub repo

**v1.0.2**
- Minor Bug Fixed
 
**v1.0.0**
- Support API 23
- Added class `OptionView.java` for set-up progress bar with your own options
- Added method `isAnimationFinished()` called by mElasticDownloadView
- Removed `@InjectView` annotation for set-up progress bar (from lib com.jakewharton:butterknife)

Method called by `OptionView`

- Added method `setBackgroundColorSquare(int color)` default is `colorPrimary`
- Added method `getColorBackgroundSquare()`
- Added method `setColorCloud(int color)` default is `Color.WHITE`
- Added method `getColorCloud`
- Added method `setColorProgressBar(int color)` default is `Color.BLACK`
- Added method `getColorProgressBar`
- Added method `setColorProgressBarInProgress(int color)` default is `Color.BLACK`
- Added method `getColorProgressBarInProgress`
- Added method `setColorProgressBarText(int color)` default is `Color.BLACK`
- Added method `getColorProgressBarText`
- Added method `setColorSuccess(int color)` default is `colorPrimary`
- Added method `getColorSuccess`
- Added method `setColorFail(int color)` default is `colorPrimary`
- Added method `getColorFail`
- Added boolean `noBackground` default is false

##CREDITS

Author: Tibolte https://github.com/Tibolte/ElasticDownload

Edit by: Michele Lacorte (micky1995g@gmail.com)

##LICENSE

ElasticProgressBar new license

```
Copyright 2015 Michele Lacorte

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

    http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
```

ElasticProgressBar original license

```
Copyright 2015 Thibault Guégan and Aron Ingi Óskarsson

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

   http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
```
