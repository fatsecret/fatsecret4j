# fatsecret4j
Java/Android Client for using Fatsecret REST API

## Java Client Code

You can use this library by downloading it [here](http://search.maven.org/remotecontent?filepath=com/fatsecret4j/fatsecret-platform/2.0/fatsecret-platform-2.0.jar) or by following this step -

### Add this maven dependency in your pom.xml

```xml
<dependency>
	<groupId>com.fatsecret4j</groupId>
	<artifactId>fatsecret-platform</artifactId>
	<version>2.0</version>
</dependency>
```

## Android Client Code

You can use this library by downloading it [here](http://search.maven.org/remotecontent?filepath=com/fatsecret4j/fatsecret-platform/2.0/fatsecret-platform-2.0.jar) and placing it in libs folder or by following these steps -

### Add the following configuration to your `build.gradle` file

```
repositories {
	mavenCentral()
}

android {
	defaultConfig {
		minSdkVersion 24
		jackOptions {
			enabled true
		}
	}
	compileOptions {
		sourceCompatibility JavaVersion.VERSION_1_8
		targetCompatibility JavaVersion.VERSION_1_8
	}	
}

dependencies {
	compile 'com.fatsecret4j:fatsecret-platform:2.0'
	compile 'com.android.volley:volley:1.0.0'
}
```

### Add the following line to your `Android Manifest` file

In order to target Android API level 24 or later, you will need to ensure that your application requests runtime permissions for internet access.

```xml
<uses-permission android:name="android.permission.INTERNET"/>
```


## Supported methods

* food.get()
* foods.search()
* recipe.get()
* recipe.search()

You can check more documentation [here](http://fatsecret4j.com).