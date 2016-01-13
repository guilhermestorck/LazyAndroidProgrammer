# Lazy Android Programmer
###### One liners for the lazy folks

When writing Android code sometimes we feel that the code we are writing could be expressed more briefly.
Depending on how lazy one is, creating tons of xml layout files even for the simplest layout is a challenge.

## Instalation

Just add the following line to your `build.gradle`

```
compile 'com.github.guilhermestorck:lazy-android-programmer:0.0.7'
```

This library is available at jcenter.
Notice that this library depends on a few [Android support libraries](http://developer.android.com/tools/support-library/features.html). If your project also depends on those and you are getting some version issues, add the following to override the library dependencies with yours.

```
compile ('com.github.guilhermestorck:lazy-android-programmer:0.0.7') {
    exclude group: 'com.android.support'
}
```

## Layout Fluent Builder

It would be cool if we could write

```java
import static com.github.guilhermestorck.lap.LazyAndroidProgrammer.*;

class MyActivity extends Activity {

  ...

  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(
      LAPVerticalLayout(
        LAPTextView("Oh, look! I'm a text view!").fillWidth().padding(32),
        LAPButton("If you press me, I'll scream").fillWidth().weight(1)
      ).build(this)
    );
  }

  ...

}
```

Now we can =)

Just import all the statics from the `com.github.guilhermestorck.lap.LazyAndroidProgrammer` class (or just the ones you need, if you're not that lazy) and start using them.
By using those builder methods and the chain setters of each class it is possible to create layouts in a very concise way.

## Creating components

###### LAPTextView
```java
LAPTextView(String label);
LAPTextView(String labelRes);
```
###### LAPButton
```java
LAPButton(String label);
LAPButton(String label, View.OnClickListener callback);

LAPButton(Integer labelRes);
LAPButton(Integer labelRes, View.OnClickListener callback);
```
###### LAPCheckBox
```java
LAPCheckBox(String label);
LAPCheckBox(String label, View.OnClickListener callback);

LAPCheckBox(Integer labelRes);
LAPCheckBox(Integer labelRes, View.OnClickListener callback);
```
###### LAPLinearLayout
```java
LAPLinearLayout(int orientation, LAPView... views);
LAPVerticalLayout(LAPView... views);
LAPHorizontalLayout(LAPView... views);
```

where `orientation` can be one of `LinearLayout.VERTICAL` or `LinearLayout.VERTICAL`.
###### LAPFragment
```java
LAPFragment(View view);
LAPFragment(Context ctx, LAPView view);
```
###### LAP
```java
LAP(View view);
```

## Modifying components
| Modifier | Modifiable components |
|-------------|:-----------------:|
| id(Integer id) |All |
| onClick(OnClickListener onClick) | All |
| onLongClick(OnLongClickListener onLongClick) | All |
| alpha(Float alpha) | All |
| background(Drawable background) | All |
| backgroundColor(Integer backgroundColor) | All |
| backgroundColorRes(Integer backgroundColorResource) | All |
| backgroundResource(Integer backgroundResource) | All |
| enabled(Boolean enabled) | All |
| minHeight(Integer minHeight) | All |
| minWidth(Integer minWidth) | All |
| paddingLeft(Integer paddingLeft) | All |
| paddingRight(Integer paddingRight) | All |
| paddingTop(Integer paddingTop) | All |
| paddingBottom(Integer padding) | All |
| padding(Integer paddingTopBottom, Integer paddingLeftRight) | All |
| padding(Integer padding) | All |
| marginLeft(Integer marginLeft) | All |
| marginRight(Integer marginRight) | All |
| marginTop(Integer marginTop) | All |
| marginBottom(Integer margin) | All |
| margin(Integer marginTopBottom, Integer marginLeftRight) | All |
| margin(Integer padding) | All |
| visibility(Integer visibility) | All |
| invisible() | All |
| visible() | All |
| gone() | All |
| width(Integer width) | All |
| fillWidth() | All |
| wrapWidth() | All |
| height(Integer height) | All |
| fillHeight() | All |
| wrapHeight() | All |
| weight(Integer weight) | All |
| add(LAPView view) | LAPLinearLayout |
| add(LAPView view, int index) | LAPLinearLayout |
| text(CharSequence text) | LAPTextView, LAPButton, LAPCheckbox |
| textRes(Integer res) | LAPTextView, LAPButton, LAPCheckbox |
| allCaps(Boolean allCaps) | LAPTextView, LAPButton, LAPCheckbox |
| autoLinkMask(Integer autoLinkMask) | LAPTextView, LAPButton, LAPCheckbox |
| ems(Integer ems) | LAPTextView, LAPButton, LAPCheckbox |
| gravity(Integer gravity) | LAPTextView, LAPButton, LAPCheckbox, LAPLinearLayout |
| height(Integer height) | LAPTextView, LAPButton, LAPCheckbox |
| checked(Boolean checked) | LAPCheckbox |
| onCheckedChange(CompoundButton.OnCheckedChangeListener onCheckedChange) | LAPCheckbox |
| dividerDrawable(Drawable dividerDrawable) | LAPLinearLayout |
| orientation(Integer orientation) | LAPLinearLayout |
| weightSum(Float weightSum) | LAPLinearLayout |


## Other functions

```java
dp(int n) //converts n dp to pixels
sp(int n) //converts n sp to pixels
```

    Copyright 2015 Guilherme Storck

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

    http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.
