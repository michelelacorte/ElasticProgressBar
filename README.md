# ElasticProgressBar

![alt tag](https://raw.githubusercontent.com/Tibolte/ElasticDownload/master/success.gif)

![alt tag](https://raw.githubusercontent.com/Tibolte/ElasticDownload/master/fail.gif)

Elastic Progress Bar , is a loading bar made ​​for Android , the initial design is https://github.com/Tibolte/ElasticDownload , I applied some changes to make it accessible to everyone!

##USAGE

Elastic Progress Bar is pushed to JCenter, so you just need to add the following dependency to your `build.gradle`.
```
dependencies {
    compile 'com.example.michele.michelelacorteelasticprogressbar:michelelacorteelasticprogressbar:1.0.0'
}
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

##CHANGELOG
**v1.0.0**
- Support API 23
- Added method `isAnimationFinished()`
- Added method `setColorBackground(int color)`
- Added method `getColorBackground()`
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
