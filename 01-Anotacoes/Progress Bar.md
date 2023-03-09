# Progress Bar



```xml
<ProgressBar
                    style="@style/Widget.AppCompat.ProgressBar.Horizontal"
                    android:id="@+id/progressBar"
                    android:layout_width="0dp"
                    android:layout_height="wrap_content"
                    android:layout_weight="1"
                    tools:max="10"
                    tools:progress="2"
                    android:progressTint="@color/white"
                    android:indeterminate="false"
                    android:layout_marginEnd="10dp"/>
```

> indeterminate -> Allows to enable the indeterminate mode. In this mode the progress bar plays an infinite looping animation.
