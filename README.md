# Tapestry5

[Tapestry 5](http://tapestry.apache.org/) library to handle
[bootstrap modals](http://getbootstrap.com/javascript/#modals)

## Requirements

* tapestry 5.4

## Why use this module

This module allows to show, update or hide a bootstrap modal in a very simple way.

It makes your dom lighter if you are developing a website full of modals by using only one and modifying its
content as needed.

## How to use it

__Currently, it only works with ajax request__


### Installing

There are no maven artifact yet but as soon as a first release is out, i'll do it. For now, it's more a demonstrative
module.

You'll have to install it to your local maven repository using this command

```bash
./gradlew install
```

then you can use it in your project (as long as you are referencing the maven local repository)

* in gradle:
```gradle
compile 'com.talentroc.t5:t5-bs-modal:1.0.0-SNAPSHOT'
```
* in maven:
```xml
<dependency>
    <groupId>com.talentroc.t5</groupId>
    <artifactId>t5-bs-modal</artifactId>
    <version>1.0.0-SNAPSHOT<version>
</dependency>
```

### Usage

Really easy to use as there is a component for it.

* in the tml:
```xml
<t:talentroc.modal t:id="myModal" t:title="My modal title">
Here is my modal content ! Yeah !
</t:talentroc.modal>
```
* in the java:
  * Inject the component
```java
    @InjectComponent
    private Modal myModal;
```
  * Use it in events
```java
    void onShowMyModal() {
        myModal.show()
    }
    void onUpdateMyModal() {
        myModal.update()
    }
    void onHideMyModal() {
        myModal.hide()
    }
```

## Contact

Feel free to leave an issue if you need anything.
