

# [View Binding](https://developer.android.com/topic/libraries/view-binding#kotlin)

*View binding* is a feature that allows you to more easily write code that
interacts with views. Once view binding is enabled in a module, it generates a *binding class* for each XML layout file present in that module. An instance of
a binding class contains direct references to all views that have an ID in the
corresponding layout.

In most cases, view binding replaces `findViewById`.



# Setup instructions

> `build.gradle`

```kotlin
android {
    ...
    buildFeatures {
        viewBinding = true
    }
}
```

If you want a layout file to be ignored while generating binding classes, add
the `tools:viewBindingIgnore="true"` attribute to the root view of that layout
file:

```kotlin
<LinearLayout
        ...
        tools:viewBindingIgnore="true" >
    ...
</LinearLayout>

```

## Use view binding in activities

To set up an instance of the binding class for use with an activity, perform the
following steps in the activity's `onCreate()`method:

1. Call the static `inflate()` method included in the generated binding class.
   This creates an instance of the binding class for the activity to use.
2. Get a reference to the root view by either calling the `getRoot()` method or
   using Kotlin property syntax
3. Pass the root view to `setContentView()` to make it the active view on the screen.
   
   

```kotlin
private lateinit var binding: ResultProfileBinding

override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    binding = ResultProfileBinding.inflate(layoutInflater)
    val view = binding.root
    setContentView(view)
}
```
