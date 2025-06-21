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

import com.paohaijiao.javelin.parser.JQuickXMLLexer;
import com.paohaijiao.javelin.parser.JQuickXMLParser;
import com.paohaijiao.javelin.visitor.JQuickXMLCommonVisitor;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.junit.Test;

import java.io.IOException;
import java.util.Arrays;

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
        Object object= tv.visit(tree);
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
        Object object= tv.visit(tree);
        System.out.println(object);
    }













}
