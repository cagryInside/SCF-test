# SCF-test
A java app that creates test post requests for SeeClickFix.

* The app always generates random lat & long values to avoid the SCF duplicate detection. 
* Download the jar file: https://github.com/cagryInside/SCF-test/blob/master/ScfTest.jar
* Run the app to send sample post request to SCF server:

```
java -jar ScfTest.jar
```

* Pass ```noimage ``` parameter to not to send image

```
java -jar ScfTest.jar noimage
```
