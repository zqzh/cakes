# basis

---

### 1.注释
> core.Comments

### 2.数据类型
> core.DataType

#### 2.1 BigDecimal 基本 API
* 加 add
* 减 subtract
* 乘 multiply
* 除 divide

#### 2.2 int和Integer的区别
##### 区别: 
- 区别点1: 类型
    + int是原始八种数据类型之一
    + Integer是一个对象,包装整型提供了很多日常操作
- 区别点2: 存储的位置,大小
    + int是由jvm底层提供,由Java虚拟机规范,int型数据存储在局部变量区,占用一个数组单元.
        * 注: 关于局部变量区以及JVM其他知识将在后面的JVM专题中进行讲解,此处不做过多深入
    + Integer存储在Java运行时数据区的堆中,不在使用时可被垃圾回收机制回收
        * Integer对象大小:
            - Mark Word: 4个字节,标记位
            - Class对象指针: 4字节,指向对应class对象的内存地址
            - 对齐: 对齐填充字节,按照8个字节填充
            - 4+4+8 = 16字节
        * 注: 在JVM时会在深入,此处不做过多讲解
- 区别点3: 使用时,字节码的区别
    + int型字节码示例:
        * 定义: int num1 = 32;
        * 字节码: 0: bipush        32
    + Integer型字节码示例:
        * 定义: Integer num2 = 64;
        * 字节码: 
            - 3: bipush        64
            - 5: invokestatic  #20                 // Method java/lang/Integer.valueOf:(I)Ljava/lang/Integer;
            
##### 联系
- 相互转化
    + Integer.valueOf,    int -> Integer
    + Integer.intValue()  Integer -> int
    + 也可以直接相互赋值
- 自动拆装箱操作(auto boxing/unboxing)
    + int -> Integer ,装箱
    + Integer -> int, 拆箱
    + 注意: **程序中尽量避免无意中的拆装箱操作,尤其是有性能考虑时**

##### 缓存机制的源码分析:
```java
public static Integer valueOf(int i) {
    if (i >= IntegerCache.low && i <= IntegerCache.high)
        return IntegerCache.cache[i + (-IntegerCache.low)];
    return new Integer(i);
}
```

```java
private static class IntegerCache {
    static final int low = -128;
    static final int high;
    static final Integer cache[];

    static {
        // high value may be configured by property
        int h = 127;
        String integerCacheHighPropValue =
            sun.misc.VM.getSavedProperty("java.lang.Integer.IntegerCache.high");
        if (integerCacheHighPropValue != null) {
            try {
                int i = parseInt(integerCacheHighPropValue);
                i = Math.max(i, 127);
                // Maximum array size is Integer.MAX_VALUE
                h = Math.min(i, Integer.MAX_VALUE - (-low) -1);
            } catch( NumberFormatException nfe) {
                // If the property cannot be parsed into an int, ignore it.
            }
        }
        high = h;

        cache = new Integer[(high - low) + 1];
        int j = low;
        for(int k = 0; k < cache.length; k++)
            cache[k] = new Integer(j++);

        // range [-128, 127] must be interned (JLS7 5.1.7)
        assert IntegerCache.high >= 127;
    }

    private IntegerCache() {}
}
```
    
##### 注意事项:
* 在做相等判断时,若为原始类型则可直接使用==,若为包装类型则需要使用equals
* 业务中若使用包装类型,要注意默认值是null的,这里最易疏忽,因为原始类型默认值是0给大家养成了习惯

##### 扩展
* 其他基本数据类型与对应的包装类型是否类似?
* 既然你看过源码,那么自动拆装箱时是否会使用到缓存机制呢?
* 既然你看过源码,自动拆装箱时为啥可以做到自动转化? 
    - 语法糖
    - 编译支持(字节码)
* 既然你看过源码,也提到了说Integer的缓存最大是127,但是我的系统中会有很多整数的使用,一般范围在1024之内,可以利用缓存吗?
    - -XX:AutoBoxCacheMax=256
* 既然你看过源码,那么说一下有哪些设计要点?
    - 不可变性
        + 猜测: Integer内部装载的依旧是整数, 而在相互转化时,可以基于intValue()获取int值,那就从intValue()方法追进去,找int的存储
        + return value;
        + private final int value;
        + 进而可知,Integer对象定义的对象也是不可变的
        + 好处? 保证了基本的信息安全和并发编程中的线程安全
    - 移植性
        + 在64位操作系统写的代码移植到32位系统上,数据会否发生变化?
        + 在Integer中定义了常量:
            * @Native public static final int SIZE = 32;
            * public static final int BYTES = SIZE / Byte.SIZE;
        + Java语言规范: 无论是32位还是64位,开发者不需要担心位数的问题
* 有了Integer还要int干啥? 或者有了int还要Integer干啥? 
* Java号称纯面向对象,为啥搞一批原始类型让人去诟病,面向对象的一点都不纯粹呢?
    - 工程上的考虑,基本数据类型在**执行效率**和**内存使用**上提升软件性能,想想Java刚出生的年代,25年前,那会的硬件发展远没有现在这般牛掰,所以性能是工程师及其重视的问题.
    - 其他? 泛型的设计和考虑
    
### 3.运算符
> core.Operator

### 4.字符串
> core.CakesString

#### 4.1 String内部结构说明
* private final char value[];
    - String内部实际就是字节数组
    
#### 4.2 String&StringBuilder&StringBuffer区别
##### 应用:
* String: 
    + Java中字符串类,被修饰为final,因此是不可变数值的类,也不可被继承.
    + 进而其相关操作,如截取,剪切,拼接等都是产生新的String
* StringBuffer: 
    + 当大量的String进行拼接时会产生大量的对象,为姐姐此问题则引入了StringBuffer
    + StringBuffer本质是一个线程安全的可修改的字符序列,为保证其线程的安全必定会损失一定的性能开销
    + 所有方法都带有 synchronized 关键字修饰
** StringBuilder:
    + jdk1.5新增,功能与StringBuffer一致,只是去掉了线程安全的实现部分,进而可提升其性能

##### 设计
* String:
    - 由于其实现是不可变的(Immutable),进而原生支持线程安全,因为String对象一但建立就不可在修改.
    - 引申: java8的 LocalDateTime
* StringBuffer与StringBuilder:
    - 均继承自AbstractStringBuilder
    - 实现方法除Buffer的所有方法使用了synchronized外,无其他区别
    - 内部使用char数组做数据接收
        + class AbstractStringBuilder # char[] value;
        + 默认大小是16,若超过16之后,会触发数组的扩容,arrayCopy,会有性能开销
        + 因此若能预估大小,尽量做到设定预期值,避免扩容

##### 扩展
* 即使尽量减少了拼接带来的大量字符串对象的产生,但是程序内依旧还有很多重复的字符串,要怎么解决呢? 使用**缓存机制 **
    - intern()方法,告知jvm将字符串缓存起来共用!
        + jdk1.6时不建议使用此方法,因为这个缓存的动作将将对象存储在PermGen(永久代),其空间有限,很难被gc,弄不好就容易造成OOM
        + 1.6之后的版本将此缓存至于堆中,大小为60013
            * 查看数值的参数配置: -XX:+PrintStringTableStatistics
            * 配置缓存的大小: -XX:StringTableSize=1024
            * 缺点: 程序员自己手动显示调用,很难把控好
    - jdk1.8 8u20之后,增加了一个新特性,G1 GC字符串排重
        + 将相同数据的字符串指向同一份数据来做到的,JVM底层提供支持
        + 此功能默认关闭,开启: -XX:UseStringDuplication, 前提: 使用G1 GC

