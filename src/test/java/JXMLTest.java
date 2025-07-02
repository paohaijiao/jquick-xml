/*
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 * Copyright (c) [2025-2099] Martin (goudingcheng@gmail.com)
 */

import com.github.paohaijiao.parser.JQuickXMLLexer;
import com.github.paohaijiao.parser.JQuickXMLParser;
import com.github.paohaijiao.visitor.JQuickXMLCommonVisitor;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.junit.Test;

import java.io.IOException;

/**
 * packageName PACKAGE_NAME
 *
 * @author Martin
 * @version 1.0.0
 * @className JpathTest
 * @date 2025/6/15
 * @description
 */
public class JXMLTest {


    @Test
    public void test01() throws IOException {
        String inputFile = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
                "<!-- 这是一个XML测试样例文件 -->\n" +
                "<testsuites>\n" +
                "  \n" +
                "    <config>\n" +
                "    </config>\n" +
                "</testsuites>\n";
        System.out.println(inputFile);
        JQuickXMLLexer lexer = new JQuickXMLLexer(CharStreams.fromString(inputFile));
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        JQuickXMLParser parser = new JQuickXMLParser(tokens);
        JQuickXMLParser.DocumentContext tree = parser.document();
        JQuickXMLCommonVisitor tv = new JQuickXMLCommonVisitor();
        Object object = tv.visit(tree);
        System.out.println(object);
    }

    @Test
    public void test02() throws IOException {
        String inputFile = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
                "<!-- 这是一个XML测试样例文件 -->\n" +
                "<testsuites>\n" +
                "    <config>\n" +
                "\t <name>用户登录成功测试</name>\n" +
                "\t <step number=\"1\">打开登录页面</step>\n" +
                "     <step number=\"2\">输入用户名</step>\n" +
                "     <step number=\"3\">输入密码</step>\n" +
                "     <step number=\"4\">点击登录按钮</step>\n" +
                "    </config>\n" +
                "</testsuites>";
        System.out.println(inputFile);
        JQuickXMLLexer lexer = new JQuickXMLLexer(CharStreams.fromString(inputFile));
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        JQuickXMLParser parser = new JQuickXMLParser(tokens);
        JQuickXMLParser.DocumentContext tree = parser.document();
        JQuickXMLCommonVisitor tv = new JQuickXMLCommonVisitor();
        Object object = tv.visit(tree);
        System.out.println(object);
    }

    @Test
    public void test03() throws IOException {
        String inputFile = "<?xml version=\"1.0\"?>\n" +
                "<!DOCTYPE catalog [\n" +
                "  <!ELEMENT catalog (book+)>\n" +
                "  <!ELEMENT book (title,author,price)>\n" +
                "  <!ELEMENT title (#PCDATA)>\n" +
                "  <!ELEMENT author (#PCDATA)>\n" +
                "  <!ELEMENT price (#PCDATA)>\n" +
                "  <!ATTLIST book id ID #REQUIRED>\n" +
                "]>\n" +
                "<catalog>\n" +
                "  <book id=\"bk101\">\n" +
                "    <title>XML Developer's Guide</title>\n" +
                "    <author>Gambardella, Matthew</author>\n" +
                "    <price>44.95</price>\n" +
                "  </book>\n" +
                "</catalog>";
        System.out.println(inputFile);
        JQuickXMLLexer lexer = new JQuickXMLLexer(CharStreams.fromString(inputFile));
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        JQuickXMLParser parser = new JQuickXMLParser(tokens);
        JQuickXMLParser.DocumentContext tree = parser.document();
        JQuickXMLCommonVisitor tv = new JQuickXMLCommonVisitor();
        Object object = tv.visit(tree);
        System.out.println(object);
    }

    @Test
    public void test04() throws IOException {
        String inputFile = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
                "<!-- 这是一个XML语法测试文件 -->\n" +
                "<testDocument xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\"\n" +
                "              xsi:noNamespaceSchemaLocation=\"testSchema.xsd\">\n" +
                "  \n" +
                "  <!-- 基本元素测试 -->\n" +
                "  <basicElements>\n" +
                "    <emptyElement/>\n" +
                "    <textElement>这是一个包含文本的元素</textElement>\n" +
                "    <mixedContent>这是混合<bold>内容</bold>的示例</mixedContent>\n" +
                "    <elementWithAttributes id=\"001\" type=\"sample\" valid=\"true\"/>\n" +
                "  </basicElements>\n" +
                "  \n" +
                "  <!-- 嵌套结构测试 -->\n" +
                "  <nestedStructures>\n" +
                "    <parent>\n" +
                "      <child sequence=\"1\">\n" +
                "        <grandchild>第一项</grandchild>\n" +
                "      </child>\n" +
                "      <child sequence=\"2\">\n" +
                "        <grandchild>第二项</grandchild>\n" +
                "      </child>\n" +
                "    </parent>\n" +
                "  </nestedStructures>\n" +
                "  \n" +
                "  <!-- 特殊字符测试 -->\n" +
                "  <specialCharacters>\n" +
                "    <lessThan><![CDATA[这里可以包含特殊字符如 < > & ' \"]]></lessThan>\n" +
                "    <escapedChars>&lt; &gt; &amp; &apos; &quot;</escapedChars>\n" +
                "  </specialCharacters>\n" +
                "  \n" +
                "  <!-- 命名空间测试 -->\n" +
                "  <ns:namespaces xmlns:ns=\"http://example.com/ns\">\n" +
                "    <ns:item ns:id=\"ns1\">命名空间项目1</ns:item>\n" +
                "    <ns:item ns:id=\"ns2\">命名空间项目2</ns:item>\n" +
                "  </ns:namespaces>\n" +
                "  \n" +
                "  <!-- 注释和CDATA测试 -->\n" +
                "  <commentsAndCDATA>\n" +
                "    <!-- 这是一个注释 -->\n" +
                "    <description><![CDATA[\n" +
                "      这里可以包含任意文本，包括 < > & 等特殊字符\n" +
                "      甚至多行内容\n" +
                "    ]]></description>\n" +
                "  </commentsAndCDATA>\n" +
                "  \n" +
                "  <!-- 处理指令 -->\n" +
                "  <?xml-stylesheet type=\"text/xsl\" href=\"style.xsl\"?>\n" +
                "  \n" +
                "  <!-- 数据类型测试 -->\n" +
                "  <dataTypes>\n" +
                "    <string>文本数据</string>\n" +
                "    <number>12345</number>\n" +
                "    <float>3.14159</float>\n" +
                "    <boolean>true</boolean>\n" +
                "    <date>2023-05-15</date>\n" +
                "    <time>13:45:30</time>\n" +
                "    <dateTime>2023-05-15T13:45:30Z</dateTime>\n" +
                "  </dataTypes>\n" +
                "  \n" +
                "</testDocument>";
        System.out.println(inputFile);
        JQuickXMLLexer lexer = new JQuickXMLLexer(CharStreams.fromString(inputFile));
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        JQuickXMLParser parser = new JQuickXMLParser(tokens);
        JQuickXMLParser.DocumentContext tree = parser.document();
        JQuickXMLCommonVisitor tv = new JQuickXMLCommonVisitor();
        Object object = tv.visit(tree);
        System.out.println(object);
    }
    @Test
    public void test05() throws IOException {
        String inputFile = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
                "<dataStorage>\n" +
                "  <records>\n" +
                "    <record id=\"101\">\n" +
                "      <name>张三</name>\n" +
                "      <age>28</age>\n" +
                "      <email>zhangsan@example.com</email>\n" +
                "      <department>技术部</department>\n" +
                "    </record>\n" +
                "    <record id=\"102\">\n" +
                "      <name>李四</name>\n" +
                "      <age>35</age>\n" +
                "      <email>lisi@example.com</email>\n" +
                "      <department>市场部</department>\n" +
                "    </record>\n" +
                "  </records>\n" +
                "</dataStorage>";
        System.out.println(inputFile);
        JQuickXMLLexer lexer = new JQuickXMLLexer(CharStreams.fromString(inputFile));
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        JQuickXMLParser parser = new JQuickXMLParser(tokens);
        JQuickXMLParser.DocumentContext tree = parser.document();
        JQuickXMLCommonVisitor tv = new JQuickXMLCommonVisitor();
        Object object = tv.visit(tree);
        System.out.println(object);
    }


}
