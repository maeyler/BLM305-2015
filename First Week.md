## First Week

* Study [Small-Simple-Safe](http://eyler.blogspot.com.tr/2004/12/neden-java.html) web site, download SSS,
and run `Chooser.runTeacher("String")`
* Read  http://eyler.blogspot.com.tr/2004/12/neden-java.html
* Select the attached file, convert it to URL, and
run DiningPhilosophers until deadlock occurs
```
f = Chooser.file(); //select DiningPhilosophers.jar
i = f.toURI(); //--> file:/C:/java/jars/DiningPh...
u = i.toURL(); //--> file:/C:/java/jars/DiningPh...
Chooser.loadClass(u, "DiningPhilosophers");
d = new DiningPhilosophers(5); 
d.start();
```
*This page was made by* [Dillinger](http://dillinger.io/)
