package cn.com.dom4j.base.test.utils.number;

import org.junit.Test;

import java.math.BigInteger;

/**
 * @author bobo (bo.wang@laowantong.cc)
 * @date 2017年08月24日
 * @desc
 */


/**

 java.lang.Object
    java.lang.Number
        java.math.BigInteger


 All implemented Interfaces
    Serializable & Comparable<BigInteger>


    不可变的任意精度的整数。所有操作中，都以二进制补码形式表示 BigInteger（如 Java 的基本整数类型）。
 BigInteger 提供所有 Java 的基本整数操作符的对应物，并提供 java.lang.Math 的所有相关方法。
 另外，BigInteger 还提供以下运算：模算术、GCD 计算、质数测试、素数生成、位操作以及一些其他操作。

    算术运算的语义完全模仿 Java 整数算术运算符的语义，如 The Java Language Specification 中所定义的。
 例如，以零作为除数的除法抛出 ArithmeticException，而负数除以正数的除法则产生一个负（或零）的余数。
 Spec 中关于溢出的细节都被忽略了，因为 BigIntegers 所设置的实际大小能适应操作结果的需要。

    位移操作的语义扩展了 Java 的位移操作符的语义以允许产生负位移距离。带有负位移距离的右移操作会导致左移操作，
 反之亦然。忽略无符号的右位移运算符（>>>），因为该操作与由此类提供的“无穷大的词大小”抽象结合使用时毫无意义。

    逐位逻辑运算的语义完全模仿 Java 的逐位整数运算符的语义。在执行操作之前，二进制运算符（and、or、xor）
 对两个操作数中的较短操作数隐式执行符号扩展。

    比较操作执行有符号的整数比较，类似于 Java 的关系运算符和相等性运算符执行的比较。

    提供的模算术操作用来计算余数、求幂和乘法可逆元。这些方法始终返回非负结果，范围在 0 和 (modulus - 1)（包括）之间。

    位操作对其操作数的二进制补码表示形式的单个位进行操作。如有必要，操作数会通过扩展符号来包含指定的位。
 单一位操作不能产生与正在被操作的 BigInteger 符号不同的 BigInteger，因为它们仅仅影响单个位，
 并且此类提供的“无穷大词大小”抽象可保证在每个 BigInteger 前存在无穷多的“虚拟符号位”数。

    为了简洁明了，在整个 BigInteger 方法的描述中都使用了伪代码。伪代码表达式 (i + j) 是“其值为 BigInteger i 加 BigInteger j
 的 BigInteger”的简写。伪代码表达式 (i == j) 是“当且仅当 BigInteger i 表示与 BigInteger j 相同的值时，才为 true”的简写。
 可以类似地解释其他伪代码表达式。

    当为任何输入参数传递 null 对象引用时，此类中的所有方法和构造方法都将抛出 NullPointerException。


 从以下版本开始：
    JDK1.1
 另请参见：
    BigDecimal, 序列化表格

*/



public class BigIntegerTest {

    @Test
    public void constructor() {

        BigInteger b = BigInteger.ONE;

        System.out.println(b);
    }

    @Test
    public void devide() {




    }





}
