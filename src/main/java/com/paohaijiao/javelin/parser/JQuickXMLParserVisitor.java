package com.paohaijiao.javelin.parser;// Generated from D:/idea/jthornruleGrammer/xml/JQuickXMLParser.g4 by ANTLR 4.13.2
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link JQuickXMLParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface JQuickXMLParserVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link JQuickXMLParser#document}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDocument(JQuickXMLParser.DocumentContext ctx);
	/**
	 * Visit a parse tree produced by {@link JQuickXMLParser#prolog}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProlog(JQuickXMLParser.PrologContext ctx);
	/**
	 * Visit a parse tree produced by {@link JQuickXMLParser#content}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitContent(JQuickXMLParser.ContentContext ctx);
	/**
	 * Visit a parse tree produced by {@link JQuickXMLParser#element}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitElement(JQuickXMLParser.ElementContext ctx);
	/**
	 * Visit a parse tree produced by {@link JQuickXMLParser#reference}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitReference(JQuickXMLParser.ReferenceContext ctx);
	/**
	 * Visit a parse tree produced by {@link JQuickXMLParser#attribute}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAttribute(JQuickXMLParser.AttributeContext ctx);
	/**
	 * Visit a parse tree produced by {@link JQuickXMLParser#chardata}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitChardata(JQuickXMLParser.ChardataContext ctx);
	/**
	 * Visit a parse tree produced by {@link JQuickXMLParser#misc}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMisc(JQuickXMLParser.MiscContext ctx);
}