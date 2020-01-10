# spark_learning

如何运行Spark SQL？

我们需要先需要通过Gradle建立一个Scala项目。

**工具要求：**

Idea：https://www.jetbrains.com/idea/

Gradle：https://gradle.org 根据官网指示下载

Scala：https://www.scala-lang.org/download/

下载之后在命令行输入 gradle init --type scala-library

![屏幕快照 2020-01-10 下午1.33.21](/Users/sheng.wang3/Desktop/屏幕快照 2020-01-10 下午1.33.21.png)

然后一直回车选择默认配置安装

![屏幕快照 2020-01-10 下午1.34.31](/Users/sheng.wang3/Desktop/屏幕快照 2020-01-10 下午1.34.31.png)

然后在idea打开项目的文件夹

默认的文件结构为

![屏幕快照 2020-01-10 下午1.36.48](/Users/sheng.wang3/Desktop/屏幕快照 2020-01-10 下午1.36.48.png)

build.gradle为项目的依赖配置文件

![屏幕快照 2020-01-10 下午1.38.07](/Users/sheng.wang3/Desktop/屏幕快照 2020-01-10 下午1.38.07.png)

在该文件加入spark依赖便可以安心的写spark语句了。