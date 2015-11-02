# ElasticProgressBar
##COMING SOON! STAY TUNED

![alt tag](https://raw.githubusercontent.com/Tibolte/ElasticDownload/master/success.gif)

![alt tag](https://raw.githubusercontent.com/Tibolte/ElasticDownload/master/fail.gif)

Elastic Progress Bar , is a loading bar made ​​for Android , the initial design is https://github.com/Tibolte/ElasticDownload , I applied some changes to make it accessible to everyone!

##USAGE

Elastic Progress Bar is pushed to JCenter, so you just need to add the following dependency to your `build.gradle`.
```
Coming soon
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

![alt tag](http://s17.postimg.org/b9xpmxtsf/Screenshot_2015_11_02_15_21_25.png)

![alt tag](http://s1.postimg.org/g5wq1wwn3/Screenshot_2015_11_02_15_21_32.png)

##CHANGELOG
**v1.0.0**
- Support API 23
- Added class `OptionView.java` for set-up progress bar with your own options
- Added method `isAnimationFinished()` called by mElasticDownloadView

Method called by `OptionView`

- Added method `setBackgroundColorSquare(int color)`
- Added method `getColorBackgroundSquare()`
- Added method `setColorCloud(int color)`
- Added method `getColorCloud`
- Added method `setColorProgressBar(int color)`
- Added method `getColorProgressBar`
- Added method `setColorProgressBarInProgress(int color)`
- Added method `getColorProgressBarInProgress`
- Added method `setColorProgressBarText(int color)`
- Added method `getColorProgressBarText`
- Added method `setColorSuccess(int color)`
- Added method `getColorSuccess`
- Added method `setColorFail(int color)`
- Added method `getColorFail`
- Added boolean `noBackground` default is false
- Removed `@InjectView` annotation for set-up progress bar

##CREDITS

Author: Tibolte https://github.com/Tibolte/ElasticDownload

Edit by: Michele Lacorte (micky1995g@gmail.com)

##LICENSE

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
