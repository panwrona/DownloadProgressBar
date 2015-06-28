# Download Progress Bar

Android progress bar with cool animation, inspired by : https://dribbble.com/shots/2012292-Download-Animation

![Download Progress Bar Animation](downloadprogressbar1.gif)
![Download Progress Bar Animation](downloadprogressbar2.gif)

---
###Attributes

| Attribute                     | Type      | Usage                                                                |
| ----------------------------- | --------- | -------------------------------------------------------------------- |
| `app:circleRadius`            | dimension | The dimension of the circle radius                                   |
| `app:strokeWidth`             | dimension | The dimension of the circle stroke width                             |
| `app:lineWidth`               | dimension | Color used for the progress completed                                |
| `app:progressDuration`        | integer   | Duration of progress. Default value is set to 1000 ms                |
| `app:resultDuration`          | integer   | Duration of result, either success and error. Default set to 4000 ms |
| `app:overshootValue`          | dimension | Value of overshoot interpolator (used for popping up the circle)     |
| `app:drawingColor `           | color     | Color used for drawing inside drawables (white on gif)               |
| `app:progressColor `          | color     | Color used for drawing the progress (white on gif)                   |
| `app:circleBackgroundColor `  | color     | Color used for drawing background circle (light blue on gif)         |
| `app:progressBackgroundColor `| color     | Color used for drawing progress background (light blue on gif)       |

---
###Download

```groovy
repositories {
    maven {
        url "https://jitpack.io"
    }
}

dependencies {
    compile 'com.github.panwrona:DownloadProgressBar:1.0'
}
```

###Usage

Below I will show You how to use this custom view. First we need to distinguish two kinds of result we can get: success and error.
To play success animation, simply call this one line:
```java
DownloadProgressView downloadProgressView = (DownloadProgressView)findViewById(R.id.download_progress_view);
downloadProgressView.playToSuccess();
```
If you want to play error animation, simply call:
```java
DownloadProgressView downloadProgressView = (DownloadProgressView)findViewById(R.id.download_progress_view);
downloadProgressView.playToError();
```
I've also added listener for common events: whole animation start, whole animation end, progress update, animation success, animation error.
To define it, call this one:
```java
downloadProgressView.setOnProgressUpdateListener(new DownloadProgressView.OnProgressUpdateListener() {
            @Override
            public void onProgressUpdate(float currentPlayTime) {
                // Here we are setting % value on our text view.
                successTextView.setText(Math.round(currentPlayTime / 3.6) + " %");
            }

            @Override
            public void onAnimationStarted() {
                // Here we are disabling our view because of possible interactions while animating.
                downloadProgressView.setEnabled(false);
            }

            @Override
            public void onAnimationEnded() {
                successTextView.setText("Click to download");
                downloadProgressView.setEnabled(true);
            }

            @Override
            public void onAnimationSuccess() {
                successTextView.setText("Downloaded!");
            }

            @Override
            public void onAnimationError() {

            }
        });
        ```
###Developed By
- Mariusz Brona - <mariusz.brona@gmail.com>

---
###License

```
Copyright 2015 Mariusz Brona

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