package com.paohaijiao.javelin.executor;

import com.paohaijiao.javelin.antlr.impl.JAbstractAntlrExecutor;
import com.paohaijiao.javelin.exception.JAntlrExecutionException;
import com.paohaijiao.javelin.parser.JQuickXMLLexer;
import com.paohaijiao.javelin.parser.JQuickXMLParser;
import com.paohaijiao.javelin.visitor.JQuickXMLCommonVisitor;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.Parser;
import org.antlr.v4.runtime.TokenStream;

public class JQuickRestExecutor extends JAbstractAntlrExecutor<String, Object> {
    @Override
    protected Lexer createLexer(CharStream input) {
        return new JQuickXMLLexer(input);
    }

    @Override
    protected Parser createParser(TokenStream tokens) {
        return new JQuickXMLParser(tokens);
    }

    @Override
    protected Object parse(Parser parser) throws JAntlrExecutionException {
        JQuickXMLParser calcParser = (JQuickXMLParser) parser;
        JQuickXMLParser.DocumentContext tree = calcParser.document();
        JQuickXMLCommonVisitor visitor = new JQuickXMLCommonVisitor();
        return visitor.visit(tree);
    }
}
