package com.github.paohaijiao.executor;

import com.github.paohaijiao.model.JSONObject;
import com.github.paohaijiao.parser.JQuickXMLLexer;
import com.github.paohaijiao.parser.JQuickXMLParser;
import com.github.paohaijiao.visitor.JQuickXMLCommonVisitor;
import com.github.paohaijiao.antlr.impl.JAbstractAntlrExecutor;
import com.github.paohaijiao.exception.JAntlrExecutionException;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.Parser;
import org.antlr.v4.runtime.TokenStream;

public class JQuickXMLExecutor extends JAbstractAntlrExecutor<String, JSONObject> {
    @Override
    protected Lexer createLexer(CharStream input) {
        return new JQuickXMLLexer(input);
    }

    @Override
    protected Parser createParser(TokenStream tokens) {
        return new JQuickXMLParser(tokens);
    }

    @Override
    protected JSONObject parse(Parser parser) throws JAntlrExecutionException {
        JQuickXMLParser calcParser = (JQuickXMLParser) parser;
        JQuickXMLParser.DocumentContext tree = calcParser.document();
        JQuickXMLCommonVisitor visitor = new JQuickXMLCommonVisitor();
        JSONObject object= visitor.visitDocument(tree);
        return  object;
    }
}
