package com.paohaijiao.javelin.visitor;

import com.paohaijiao.javelin.model.JSONArray;
import com.paohaijiao.javelin.model.JSONObject;
import com.paohaijiao.javelin.parser.JQuickXMLParser;
import com.paohaijiao.javelin.parser.JQuickXMLParserBaseVisitor;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.TerminalNode;

public class JQuickXmlCoreVisitor extends JQuickXMLParserBaseVisitor {
    protected final String cdata="cdata";
    protected final String text="text";
    protected final String element="element";
    protected final String comment="comment";
    protected final String chardata="chardata";
    protected final String attributes="attributes";
    protected final String postMisc="postMisc";
    protected static final String seaWs="seaWs";
    protected static final String name="name";
    protected static final String entityRef="entityRef";
    protected static final String charRef="charRef";
    protected static final String string="string";
    protected static final String pi="pi";
    protected static final String content="content";
    protected static final String reference="reference";
    protected JSONObject handleText(JQuickXMLParser.ChardataContext ctx) {
        String text = ctx.getText().trim();
        JSONObject jsonObject=new JSONObject();
        jsonObject.put(text, text);
        return jsonObject;
    }

    protected JSONObject handleElement(JQuickXMLParser.ElementContext ctx) {
        JSONObject jsonObject = new JSONObject();
        JSONArray array=new JSONArray();
        for (int i = 0; i < ctx.attribute().size(); i++) {
            array.add((JSONObject)visitAttribute(ctx.attribute(i)));
        }
        jsonObject.put(element, array);
        return jsonObject;
    }

    private JSONObject handleTerminal(ParseTree node) {
        TerminalNode tn = (TerminalNode) node;
        JSONObject jsonObject = new JSONObject();
        switch (tn.getSymbol().getType()) {
            case JQuickXMLParser.CDATA:
                jsonObject.put(cdata, tn.getText());
            case JQuickXMLParser.COMMENT:
                jsonObject.put(comment, tn.getText());
        }
        return jsonObject;
    }
}
