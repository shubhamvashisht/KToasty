# KToasty
Toasty library Kotlin variant with added sweetness of kotlin extensions.

[![](https://jitpack.io/v/shubhamvashisht/KToasty.svg)](https://jitpack.io/#shubhamvashisht/KToasty)

#### This library was forked from [Toasty](https://github.com/GrenderG/Toasty) and is a rewrite of same in kotlin with added kotlin extensions.

## Prerequisites

Add this in your root `build.gradle` file (**not** your module `build.gradle` file):

```gradle
allprojects {
	repositories {
		...
		maven { url "https://jitpack.io" }
	}
}
```
## Dependency

Add this to your module's `build.gradle` file (make sure the version matches the JitPack badge above):

```gradle
dependencies {
	...
	implementation 'com.github.shubhamvashisht:KToasty:1.0'
}
```
## Usage

Each method always returns a `Toast` object, so you can customize the Toast much more. **DON'T FORGET THE `show()` METHOD!**

For an error toast:

``` kotlin
KToasty.error(yourContext, "This is an error toast.", Toast.LENGTH_SHORT, true).show()
```
For a success toast:

``` kotlin
KToasty.success(yourContext, "Success!", Toast.LENGTH_SHORT, true).show()
```
For an info toast:

``` kotlin
KToasty.info(yourContext, "Here is some info for you.", Toast.LENGTH_SHORT, true).show()
```
For an warning toast:

``` kotlin
KToasty.warning(yourContext, "Beware of the dog.", Toast.LENGTH_SHORT, true).show()
```
For a normal toast:

``` kotlin
KToasty.normal(yourContext, "Normal toast w/o icon").show()
```
For a normal toast with an icon:

``` kotlin
KToasty.normal(yourContext, "Normal toast w/ icon", yourIconDrawable).show()
```

## Using Extensions

You can use extensions to quickly show the toasts. just call extensions on any context. 
For example. You don't need to call show() explicitly.

### In your activity

``` kotlin
//normal toast
this.showNormalToast("message", Toast.LENGTH_SHORT)
```
### or

``` kotlin
//success toast with default icon
this.showSuccessToast("message", Toast.LENGTH_SHORT, true)
```
### In your Fragment

```kotlin
//normal toast
getActivity().showNormalToast("message", Toast.LENGTH_SHORT)
```

### or

```kotlin
//error toast with default icon
getActivity().showErrorToast("error message", Toast.LENGTH_SHORT, true)
```
##### More extensions coming for full custom toasts.

## Screenshots

![Screenshots](/art/examples.png)

## Contributions and issues
Please report and open issue if you find any.
Contributions are always welcome. To contribute, simply open up a PR with the changes.
