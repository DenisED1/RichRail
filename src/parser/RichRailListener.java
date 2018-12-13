// Generated from RichRail.g4 by ANTLR 4.7.1
package parser;

import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link RichRailParser}.
 */
public interface RichRailListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link RichRailParser#command}.
	 * @param ctx the parse tree
	 */
	void enterCommand(RichRailParser.CommandContext ctx);
	/**
	 * Exit a parse tree produced by {@link RichRailParser#command}.
	 * @param ctx the parse tree
	 */
	void exitCommand(RichRailParser.CommandContext ctx);
	/**
	 * Enter a parse tree produced by {@link RichRailParser#newcommand}.
	 * @param ctx the parse tree
	 */
	void enterNewcommand(RichRailParser.NewcommandContext ctx);
	/**
	 * Exit a parse tree produced by {@link RichRailParser#newcommand}.
	 * @param ctx the parse tree
	 */
	void exitNewcommand(RichRailParser.NewcommandContext ctx);
	/**
	 * Enter a parse tree produced by {@link RichRailParser#newtraincommand}.
	 * @param ctx the parse tree
	 */
	void enterNewtraincommand(RichRailParser.NewtraincommandContext ctx);
	/**
	 * Exit a parse tree produced by {@link RichRailParser#newtraincommand}.
	 * @param ctx the parse tree
	 */
	void exitNewtraincommand(RichRailParser.NewtraincommandContext ctx);
	/**
	 * Enter a parse tree produced by {@link RichRailParser#newwagoncommand}.
	 * @param ctx the parse tree
	 */
	void enterNewwagoncommand(RichRailParser.NewwagoncommandContext ctx);
	/**
	 * Exit a parse tree produced by {@link RichRailParser#newwagoncommand}.
	 * @param ctx the parse tree
	 */
	void exitNewwagoncommand(RichRailParser.NewwagoncommandContext ctx);
	/**
	 * Enter a parse tree produced by {@link RichRailParser#addcommand}.
	 * @param ctx the parse tree
	 */
	void enterAddcommand(RichRailParser.AddcommandContext ctx);
	/**
	 * Exit a parse tree produced by {@link RichRailParser#addcommand}.
	 * @param ctx the parse tree
	 */
	void exitAddcommand(RichRailParser.AddcommandContext ctx);
	/**
	 * Enter a parse tree produced by {@link RichRailParser#getcommand}.
	 * @param ctx the parse tree
	 */
	void enterGetcommand(RichRailParser.GetcommandContext ctx);
	/**
	 * Exit a parse tree produced by {@link RichRailParser#getcommand}.
	 * @param ctx the parse tree
	 */
	void exitGetcommand(RichRailParser.GetcommandContext ctx);
	/**
	 * Enter a parse tree produced by {@link RichRailParser#delcommand}.
	 * @param ctx the parse tree
	 */
	void enterDelcommand(RichRailParser.DelcommandContext ctx);
	/**
	 * Exit a parse tree produced by {@link RichRailParser#delcommand}.
	 * @param ctx the parse tree
	 */
	void exitDelcommand(RichRailParser.DelcommandContext ctx);
	/**
	 * Enter a parse tree produced by {@link RichRailParser#remcommand}.
	 * @param ctx the parse tree
	 */
	void enterRemcommand(RichRailParser.RemcommandContext ctx);
	/**
	 * Exit a parse tree produced by {@link RichRailParser#remcommand}.
	 * @param ctx the parse tree
	 */
	void exitRemcommand(RichRailParser.RemcommandContext ctx);
	/**
	 * Enter a parse tree produced by {@link RichRailParser#type}.
	 * @param ctx the parse tree
	 */
	void enterType(RichRailParser.TypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link RichRailParser#type}.
	 * @param ctx the parse tree
	 */
	void exitType(RichRailParser.TypeContext ctx);
}