package com.github.paohaijiao;/*
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
public class JXML02Test {


    @Test
    public void test01() throws IOException {
        String inputFile = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
                "<configuration>\n" +
                "  <appSettings>\n" +
                "    <setting key=\"Timeout\" value=\"300\"/>\n" +
                "    <setting key=\"MaxConnections\" value=\"50\"/>\n" +
                "    <setting key=\"DebugMode\" value=\"false\"/>\n" +
                "  </appSettings>\n" +
                "  <database>\n" +
                "    <server>localhost</server>\n" +
                "    <port>3306</port>\n" +
                "    <username>admin</username>\n" +
                "    <password encrypted=\"true\">xYz123AbC</password>\n" +
                "  </database>\n" +
                "  <logging>\n" +
                "    <level>INFO</level>\n" +
                "    <path>/var/log/app.log</path>\n" +
                "    <maxSize unit=\"MB\">10</maxSize>\n" +
                "  </logging>\n" +
                "</configuration>";
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
                "<rss version=\"2.0\">\n" +
                "  <channel>\n" +
                "    <title>示例新闻频道</title>\n" +
                "    <link>http://example.com/news</link>\n" +
                "    <description>最新的新闻资讯</description>\n" +
                "    <language>zh-cn</language>\n" +
                "    <pubDate>Wed, 15 May 2023 08:00:00 GMT</pubDate>\n" +
                "    \n" +
                "    <item>\n" +
                "      <title>XML标准发布新版本</title>\n" +
                "      <link>http://example.com/news/123</link>\n" +
                "      <description>XML 1.1标准正式发布，包含多项改进...</description>\n" +
                "      <pubDate>Wed, 15 May 2023 07:30:00 GMT</pubDate>\n" +
                "      <guid>http://example.com/news/123</guid>\n" +
                "    </item>\n" +
                "    \n" +
                "    <item>\n" +
                "      <title>Web开发技术趋势</title>\n" +
                "      <link>http://example.com/news/124</link>\n" +
                "      <description>2023年Web开发领域的新趋势分析...</description>\n" +
                "      <pubDate>Tue, 14 May 2023 18:45:00 GMT</pubDate>\n" +
                "      <guid>http://example.com/news/124</guid>\n" +
                "    </item>\n" +
                "  </channel>\n" +
                "</rss>";
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
                "<soap:Envelope xmlns:soap=\"http://www.w3.org/2003/05/soap-envelope\">\n" +
                "  <soap:Header>\n" +
                "    <auth:Authentication xmlns:auth=\"http://example.com/auth\">\n" +
                "      <auth:Username>user123</auth:Username>\n" +
                "      <auth:Password>pass456</auth:Password>\n" +
                "    </auth:Authentication>\n" +
                "  </soap:Header>\n" +
                "  <soap:Body>\n" +
                "    <m:GetProductInfo xmlns:m=\"http://example.com/products\">\n" +
                "      <m:ProductID>789</m:ProductID>\n" +
                "      <m:DetailLevel>Full</m:DetailLevel>\n" +
                "    </m:GetProductInfo>\n" +
                "  </soap:Body>\n" +
                "</soap:Envelope>";
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
                "<svg width=\"200\" height=\"200\" viewBox=\"0 0 200 200\" xmlns=\"http://www.w3.org/2000/svg\">\n" +
                "  <rect x=\"10\" y=\"10\" width=\"180\" height=\"180\" fill=\"none\" stroke=\"blue\" stroke-width=\"2\"/>\n" +
                "  \n" +
                "  <circle cx=\"100\" cy=\"100\" r=\"80\" fill=\"lightblue\"/>\n" +
                "  \n" +
                "  <text x=\"100\" y=\"100\" font-family=\"Arial\" font-size=\"20\" text-anchor=\"middle\" fill=\"darkblue\">\n" +
                "    SVG示例\n" +
                "  </text>\n" +
                "  \n" +
                "  <polygon points=\"100,20 140,180 60,180\" fill=\"yellow\" stroke=\"orange\" stroke-width=\"2\"/>\n" +
                "</svg>";
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
                "<enterprise>\n" +
                "  <companyInfo>\n" +
                "    <name>ABC科技有限公司</name>\n" +
                "    <established>2005-03-15</established>\n" +
                "    <address country=\"中国\" province=\"北京\" city=\"海淀区\">\n" +
                "      <street>中关村南大街5号</street>\n" +
                "      <postalCode>100081</postalCode>\n" +
                "    </address>\n" +
                "  </companyInfo>\n" +
                "  \n" +
                "  <departments>\n" +
                "    <department id=\"D001\" type=\"R&D\">\n" +
                "      <name>研发中心</name>\n" +
                "      <employees>\n" +
                "        <employee id=\"E001\">\n" +
                "          <personal>\n" +
                "            <name>王五</name>\n" +
                "            <gender>男</gender>\n" +
                "            <birthDate>1985-08-23</birthDate>\n" +
                "          </personal>\n" +
                "          <professional>\n" +
                "            <position>高级工程师</position>\n" +
                "            <salary currency=\"CNY\">25000</salary>\n" +
                "            <skills>\n" +
                "              <skill level=\"5\">Java</skill>\n" +
                "              <skill level=\"4\">XML</skill>\n" +
                "              <skill level=\"3\">Python</skill>\n" +
                "            </skills>\n" +
                "          </professional>\n" +
                "        </employee>\n" +
                "      </employees>\n" +
                "    </department>\n" +
                "  </departments>\n" +
                "  \n" +
                "  <projects>\n" +
                "    <project id=\"P2023-001\" status=\"ongoing\">\n" +
                "      <title>企业数据平台升级</title>\n" +
                "      <budget>500000</budget>\n" +
                "      <startDate>2023-01-10</startDate>\n" +
                "      <expectedEndDate>2023-12-31</expectedEndDate>\n" +
                "      <departmentsInvolved>D001 D002</departmentsInvolved>\n" +
                "    </project>\n" +
                "  </projects>\n" +
                "</enterprise>";
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
    public void test07() throws IOException {
        String inputFile = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
                "<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Strict//EN\"\n" +
                "  \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd\">\n" +
                "<html xmlns=\"http://www.w3.org/1999/xhtml\" xml:lang=\"zh\" lang=\"zh\">\n" +
                "<head>\n" +
                "  <title>XHTML测试页面</title>\n" +
                "  <meta name=\"description\" content=\"这是一个XHTML测试页面\"/>\n" +
                "  <meta name=\"keywords\" content=\"XML,XHTML,测试\"/>\n" +
                "  <link rel=\"stylesheet\" type=\"text/css\" href=\"styles.css\"/>\n" +
                "</head>\n" +
                "<body>\n" +
                "  <div id=\"header\">\n" +
                "    <h1>欢迎来到测试页面</h1>\n" +
                "  </div>\n" +
                "  \n" +
                "  <div id=\"content\">\n" +
                "    <p>这是一个符合XML规范的XHTML文档。</p>\n" +
                "    <ul>\n" +
                "      <li>列表项1</li>\n" +
                "      <li>列表项2</li>\n" +
                "      <li>列表项3</li>\n" +
                "    </ul>\n" +
                "    \n" +
                "    <table>\n" +
                "      <tr>\n" +
                "        <th>姓名</th>\n" +
                "        <th>年龄</th>\n" +
                "      </tr>\n" +
                "      <tr>\n" +
                "        <td>张三</td>\n" +
                "        <td>28</td>\n" +
                "      </tr>\n" +
                "    </table>\n" +
                "  </div>\n" +
                "  \n" +
                "  <div id=\"footer\">\n" +
                "    <p>© 2023 示例公司</p>\n" +
                "  </div>\n" +
                "</body>\n" +
                "</html>";
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
