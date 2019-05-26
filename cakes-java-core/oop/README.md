# oop

---

### 1.类的组成
> core.struct.*

#### 1.1 类示例
> core.struct.ClassDemo

##### 属性
* private Integer id;
* 存储于堆中


##### 构造代码块
* 构造代码块,优先于构造函数执行
* 覆盖的是所有对象,不管调用哪个构造函数
```java
  {
    System.out.println("这里是实例代码块,只要new就掉一次");
  }
```

##### 构造方法
```java
public ClassDemo(Integer id, String name) {
  System.out.println("准备要构造");
  this.id = id;
  this.name = name;
}
```

##### 实例方法
* 此方法内部定义的变量,均为局部变量,存储于该方法的栈帧中
```java
public String say(String message) {
  System.out.println(message);

  // 局部变量,存储位置位于方法的栈帧中
  int num = 1024;

  return this.id + "," + this.name + ": say hello";
}
```

#### 1.2 静态类示例
> core.struct.StaticClassDemo

##### 静态域
* private static String data
* 又叫类属性

##### 静态方法
* public static String call(String info)
* 又叫类方法

##### 常量
* public static final String CONST_INFO
* static修饰类属性,再加关键字final修饰即为常量

##### 静态代码块
* new 对象       会调用静态代码块
* 调用 静态方法   会调用静态代码块
* 调用 静态属性   会调用静态代码块
* 调用 常量       不会调用静态代码块
* 且只会在类初始化时调用一次
```java
static {
  System.out.println("static code block");
}
```
### 2.对象创建

#### 2.1 堆&栈关系

#### 2.2 this关键字
> public Person(String name, Integer age)

##### this指向
* 当前对象的指针,或者引用,或者地址
* this只是个关键字,持有的是对象的引用

#### 2.3 初始化过程
> core.object.User

##### User user = new User("木尘",23);
* 1.先将User.java文件编译成User.class
* 2.使用classloader(类加载器)将User.class加载进内存中
* 3.执行静态代码块
* 4.开辟一块堆内存空间,地址0X111
* 5.为属性赋初始值,默认值,name=null,age=null,info="user"
* 6.执行构造代码快
* 7.执行构造函数,name="木尘",age=23
* 8.将地址,0X111赋值给user

### 3.继承

#### 3.1 优点
> core.inherit.Parent
> core.inherit.Child

* 提高代码的复用性
* 使得类之间产生依赖关系, is-a

#### 3.2 问题
* 父类私有的属性,子类是否会继承?
* 