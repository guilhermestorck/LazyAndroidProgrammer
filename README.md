# Lazy Android Programmer
###### One liners for the lazy folks

When writing Android code sometimes we feel that the code we are writing could be expressed more briefly.
Depending on how lazy one is, creating tons of xml layout files even for the simplest layout is a challenge.

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
      )
    );
  }
  
  ...

}
```

Now we can =)

Just import all the statics from the `com.github.guilhermestorck.lap.LazyAndroidProgrammer` class (or just the ones you need, if you're not that lazy) and start using them.
By using those builder methods and the chain setters of each class it is possible to create layouts in a very concise way.


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
