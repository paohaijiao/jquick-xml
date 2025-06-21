package com.paohaijiao.javelin.parser;// Generated from D:/idea/jthornruleGrammer/xml/JQuickXMLParser.g4 by ANTLR 4.13.2
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link JQuickXMLParser}.
 */
public interface JQuickXMLParserListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link JQuickXMLParser#document}.
	 * @param ctx the parse tree
	 */
	void enterDocument(JQuickXMLParser.DocumentContext ctx);
	/**
	 * Exit a parse tree produced by {@link JQuickXMLParser#document}.
	 * @param ctx the parse tree
	 */
	void exitDocument(JQuickXMLParser.DocumentContext ctx);
	/**
	 * Enter a parse tree produced by {@link JQuickXMLParser#prolog}.
	 * @param ctx the parse tree
	 */
	void enterProlog(JQuickXMLParser.PrologContext ctx);
	/**
	 * Exit a parse tree produced by {@link JQuickXMLParser#prolog}.
	 * @param ctx the parse tree
	 */
	void exitProlog(JQuickXMLParser.PrologContext ctx);
	/**
	 * Enter a parse tree produced by {@link JQuickXMLParser#content}.
	 * @param ctx the parse tree
	 */
	void enterContent(JQuickXMLParser.ContentContext ctx);
	/**
	 * Exit a parse tree produced by {@link JQuickXMLParser#content}.
	 * @param ctx the parse tree
	 */
	void exitContent(JQuickXMLParser.ContentContext ctx);
	/**
	 * Enter a parse tree produced by {@link JQuickXMLParser#element}.
	 * @param ctx the parse tree
	 */
	void enterElement(JQuickXMLParser.ElementContext ctx);
	/**
	 * Exit a parse tree produced by {@link JQuickXMLParser#element}.
	 * @param ctx the parse tree
	 */
	void exitElement(JQuickXMLParser.ElementContext ctx);
	/**
	 * Enter a parse tree produced by {@link JQuickXMLParser#reference}.
	 * @param ctx the parse tree
	 */
	void enterReference(JQuickXMLParser.ReferenceContext ctx);
	/**
	 * Exit a parse tree produced by {@link JQuickXMLParser#reference}.
	 * @param ctx the parse tree
	 */
	void exitReference(JQuickXMLParser.ReferenceContext ctx);
	/**
	 * Enter a parse tree produced by {@link JQuickXMLParser#attribute}.
	 * @param ctx the parse tree
	 */
	void enterAttribute(JQuickXMLParser.AttributeContext ctx);
	/**
	 * Exit a parse tree produced by {@link JQuickXMLParser#attribute}.
	 * @param ctx the parse tree
	 */
	void exitAttribute(JQuickXMLParser.AttributeContext ctx);
	/**
	 * Enter a parse tree produced by {@link JQuickXMLParser#chardata}.
	 * @param ctx the parse tree
	 */
	void enterChardata(JQuickXMLParser.ChardataContext ctx);
	/**
	 * Exit a parse tree produced by {@link JQuickXMLParser#chardata}.
	 * @param ctx the parse tree
	 */
	void exitChardata(JQuickXMLParser.ChardataContext ctx);
	/**
	 * Enter a parse tree produced by {@link JQuickXMLParser#misc}.
	 * @param ctx the parse tree
	 */
	void enterMisc(JQuickXMLParser.MiscContext ctx);
	/**
	 * Exit a parse tree produced by {@link JQuickXMLParser#misc}.
	 * @param ctx the parse tree
	 */
	void exitMisc(JQuickXMLParser.MiscContext ctx);
}