# Error Note

- `Cannot fit requested classes in a single dex file (# methods: 69681 > 65536)`

Add `multiDexEnabled true` to gradle:
```groovy
    android {
        defaultConfig {
//            ...
            minSdkVersion 16
            targetSdkVersion 26
            multiDexEnabled true
        }
//        ...
    }
```