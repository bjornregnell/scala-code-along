# scala-code-along

A short intro to [Scala](https://github.com/bjornregnell/scala-code-along#what-is-scala). 

The provided code is ment as inspiration for interactive live coding sessions lead by someone who wants to share the joy of Scala. We [code-along](https://github.com/bjornregnell/scala-code-along/blob/master/scala-code-along-intro.scala) together step-by-step
by typing/pasting code snippets into the Scala interactive shell, also known as the Scala [REPL](http://en.wikipedia.org/wiki/Read%E2%80%93eval%E2%80%93print_loop).

## Preparations before coding along:

  * Download latest Scala using http://scala-lang.org/download/ or mirrors provided [below](https://github.com/bjornregnell/scala-code-along#scala-download-mirrors-at-cslthse) by LTH, Lund University in Sweden.
  * Open a terminal window (bash | powershell | cmd)
  * Run the `scala` command
  * Type or paste these [code snippets](https://github.com/bjornregnell/scala-code-along/blob/master/scala-code-along-intro.scala) line by line as we code along together 

## Scala download mirrors at cs.lth.se

  * Scala command line tools (`scala`, `scalac`, `scaladoc`, etc) 
    * [Scala 2.11.6 Windows msi](http://fileadmin.cs.lth.se/scala/scala-2.11.6.msi) 110MB
    * [Scala 2.11.6 Unix/MacOSX tgz](http://fileadmin.cs.lth.se/scala/scala-2.11.6.tgz) 27MB
    * [Scala 2.11.6 Linux/Debian deb](http://fileadmin.cs.lth.se/scala/scala-2.11.6.deb) 78MB

  * Kojo IDE for easy scripting with api for 2D graphics and simple game dev     
    * [Kojo 2.4.06 Windows exe](http://fileadmin.cs.lth.se/kojo/KojoInstall-2.4.06.exe)  18MB
    * [Kojo 2.4.06 MacOSX dmg](http://fileadmin.cs.lth.se/kojo/Kojo-2.4.06.app.dmg) 39MB
    * [Kojo 2.4.06 Linux/Unix jar](http://fileadmin.cs.lth.se/kojo/kojoInstall-2.4.06.jar) 18MB
    
  * Recommended reading for java programmers:
    * [Part of "Scala for the impatient"] (http://fileadmin.cs.lth.se/scala/scala-impatient.pdf) 6MB, first 110 pages Copyright [Cay S. Horstmann 2012](http://www.horstmann.com/scala/index.html).  
  
  * Download SimpleWindow etc. in [cs_eda016.jar](http://fileadmin.cs.lth.se/scala/cs_eda016.jar) 51kB and [JavaDoc for cs_eda016](http://fileadmin.cs.lth.se/cs//Education/EDA016/javadoc/cs_eda016_doc/) to test Java interoperability:
    * put the jar on the REPL's class path with `scala -cp cs_eda016.jar` 
    * or if you have compiled some `object Main extends App` that ``import se.lth.cs.window.SimpleWindow`, run class file Main.class using:
      * Windows: `scala -cp "cs_eda016.jar;." Main`
      * Linux: `scala -cp "cs_eda016.jar:." Main`
  
## What is [Scala](http://scala-lang.org/)?

  * Scala is a statically typed object-functional programming language 
  * Scala runs as fast as Java on the Java Virtual Machine 
  * Scala can call any Java byte code, including all classes in the JDK
  * Scala's standard library includes a powerful collections library
  * Scala has more powerful abstraction mechanisms compared to Java
  * Scala is more regular compared to Java
  * Scala is as concise as many dynamic scripting languages
  * Scala is statically typed; thus both safe and fast
  * Scala is used by Twitter, LinkedIn, Netflix, [Coursera]( https://tech.coursera.org/blog/2014/02/18/why-we-love-scala-at-coursera/), ... 
  * There are many useful Scala libs and frameworks: Play, Akka, Scalatra, ...

