// Generated from Conditional.g4 by ANTLR 4.9.3
package com.acepero13.research.conditional;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link ConditionalParser}.
 */
public interface ConditionalListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link ConditionalParser#parse}.
	 * @param ctx the parse tree
	 */
	void enterParse(ConditionalParser.ParseContext ctx);
	/**
	 * Exit a parse tree produced by {@link ConditionalParser#parse}.
	 * @param ctx the parse tree
	 */
	void exitParse(ConditionalParser.ParseContext ctx);
	/**
	 * Enter a parse tree produced by {@link ConditionalParser#block}.
	 * @param ctx the parse tree
	 */
	void enterBlock(ConditionalParser.BlockContext ctx);
	/**
	 * Exit a parse tree produced by {@link ConditionalParser#block}.
	 * @param ctx the parse tree
	 */
	void exitBlock(ConditionalParser.BlockContext ctx);
	/**
	 * Enter a parse tree produced by {@link ConditionalParser#stat}.
	 * @param ctx the parse tree
	 */
	void enterStat(ConditionalParser.StatContext ctx);
	/**
	 * Exit a parse tree produced by {@link ConditionalParser#stat}.
	 * @param ctx the parse tree
	 */
	void exitStat(ConditionalParser.StatContext ctx);
	/**
	 * Enter a parse tree produced by {@link ConditionalParser#if_stat}.
	 * @param ctx the parse tree
	 */
	void enterIf_stat(ConditionalParser.If_statContext ctx);
	/**
	 * Exit a parse tree produced by {@link ConditionalParser#if_stat}.
	 * @param ctx the parse tree
	 */
	void exitIf_stat(ConditionalParser.If_statContext ctx);
	/**
	 * Enter a parse tree produced by {@link ConditionalParser#condition_block}.
	 * @param ctx the parse tree
	 */
	void enterCondition_block(ConditionalParser.Condition_blockContext ctx);
	/**
	 * Exit a parse tree produced by {@link ConditionalParser#condition_block}.
	 * @param ctx the parse tree
	 */
	void exitCondition_block(ConditionalParser.Condition_blockContext ctx);
	/**
	 * Enter a parse tree produced by {@link ConditionalParser#stat_block}.
	 * @param ctx the parse tree
	 */
	void enterStat_block(ConditionalParser.Stat_blockContext ctx);
	/**
	 * Exit a parse tree produced by {@link ConditionalParser#stat_block}.
	 * @param ctx the parse tree
	 */
	void exitStat_block(ConditionalParser.Stat_blockContext ctx);
	/**
	 * Enter a parse tree produced by {@link ConditionalParser#action_block}.
	 * @param ctx the parse tree
	 */
	void enterAction_block(ConditionalParser.Action_blockContext ctx);
	/**
	 * Exit a parse tree produced by {@link ConditionalParser#action_block}.
	 * @param ctx the parse tree
	 */
	void exitAction_block(ConditionalParser.Action_blockContext ctx);
	/**
	 * Enter a parse tree produced by {@link ConditionalParser#end_block}.
	 * @param ctx the parse tree
	 */
	void enterEnd_block(ConditionalParser.End_blockContext ctx);
	/**
	 * Exit a parse tree produced by {@link ConditionalParser#end_block}.
	 * @param ctx the parse tree
	 */
	void exitEnd_block(ConditionalParser.End_blockContext ctx);
	/**
	 * Enter a parse tree produced by the {@code notExpr}
	 * labeled alternative in {@link ConditionalParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterNotExpr(ConditionalParser.NotExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code notExpr}
	 * labeled alternative in {@link ConditionalParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitNotExpr(ConditionalParser.NotExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code unaryMinusExpr}
	 * labeled alternative in {@link ConditionalParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterUnaryMinusExpr(ConditionalParser.UnaryMinusExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code unaryMinusExpr}
	 * labeled alternative in {@link ConditionalParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitUnaryMinusExpr(ConditionalParser.UnaryMinusExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code multiplicationExpr}
	 * labeled alternative in {@link ConditionalParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterMultiplicationExpr(ConditionalParser.MultiplicationExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code multiplicationExpr}
	 * labeled alternative in {@link ConditionalParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitMultiplicationExpr(ConditionalParser.MultiplicationExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code atomExpr}
	 * labeled alternative in {@link ConditionalParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterAtomExpr(ConditionalParser.AtomExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code atomExpr}
	 * labeled alternative in {@link ConditionalParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitAtomExpr(ConditionalParser.AtomExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code orExpr}
	 * labeled alternative in {@link ConditionalParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterOrExpr(ConditionalParser.OrExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code orExpr}
	 * labeled alternative in {@link ConditionalParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitOrExpr(ConditionalParser.OrExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code additiveExpr}
	 * labeled alternative in {@link ConditionalParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterAdditiveExpr(ConditionalParser.AdditiveExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code additiveExpr}
	 * labeled alternative in {@link ConditionalParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitAdditiveExpr(ConditionalParser.AdditiveExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code powExpr}
	 * labeled alternative in {@link ConditionalParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterPowExpr(ConditionalParser.PowExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code powExpr}
	 * labeled alternative in {@link ConditionalParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitPowExpr(ConditionalParser.PowExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code relationalExpr}
	 * labeled alternative in {@link ConditionalParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterRelationalExpr(ConditionalParser.RelationalExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code relationalExpr}
	 * labeled alternative in {@link ConditionalParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitRelationalExpr(ConditionalParser.RelationalExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code equalityExpr}
	 * labeled alternative in {@link ConditionalParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterEqualityExpr(ConditionalParser.EqualityExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code equalityExpr}
	 * labeled alternative in {@link ConditionalParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitEqualityExpr(ConditionalParser.EqualityExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code andExpr}
	 * labeled alternative in {@link ConditionalParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterAndExpr(ConditionalParser.AndExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code andExpr}
	 * labeled alternative in {@link ConditionalParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitAndExpr(ConditionalParser.AndExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code parExpr}
	 * labeled alternative in {@link ConditionalParser#atom}.
	 * @param ctx the parse tree
	 */
	void enterParExpr(ConditionalParser.ParExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code parExpr}
	 * labeled alternative in {@link ConditionalParser#atom}.
	 * @param ctx the parse tree
	 */
	void exitParExpr(ConditionalParser.ParExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code numberAtom}
	 * labeled alternative in {@link ConditionalParser#atom}.
	 * @param ctx the parse tree
	 */
	void enterNumberAtom(ConditionalParser.NumberAtomContext ctx);
	/**
	 * Exit a parse tree produced by the {@code numberAtom}
	 * labeled alternative in {@link ConditionalParser#atom}.
	 * @param ctx the parse tree
	 */
	void exitNumberAtom(ConditionalParser.NumberAtomContext ctx);
	/**
	 * Enter a parse tree produced by the {@code booleanAtom}
	 * labeled alternative in {@link ConditionalParser#atom}.
	 * @param ctx the parse tree
	 */
	void enterBooleanAtom(ConditionalParser.BooleanAtomContext ctx);
	/**
	 * Exit a parse tree produced by the {@code booleanAtom}
	 * labeled alternative in {@link ConditionalParser#atom}.
	 * @param ctx the parse tree
	 */
	void exitBooleanAtom(ConditionalParser.BooleanAtomContext ctx);
	/**
	 * Enter a parse tree produced by the {@code idAtom}
	 * labeled alternative in {@link ConditionalParser#atom}.
	 * @param ctx the parse tree
	 */
	void enterIdAtom(ConditionalParser.IdAtomContext ctx);
	/**
	 * Exit a parse tree produced by the {@code idAtom}
	 * labeled alternative in {@link ConditionalParser#atom}.
	 * @param ctx the parse tree
	 */
	void exitIdAtom(ConditionalParser.IdAtomContext ctx);
	/**
	 * Enter a parse tree produced by the {@code stringAtom}
	 * labeled alternative in {@link ConditionalParser#atom}.
	 * @param ctx the parse tree
	 */
	void enterStringAtom(ConditionalParser.StringAtomContext ctx);
	/**
	 * Exit a parse tree produced by the {@code stringAtom}
	 * labeled alternative in {@link ConditionalParser#atom}.
	 * @param ctx the parse tree
	 */
	void exitStringAtom(ConditionalParser.StringAtomContext ctx);
	/**
	 * Enter a parse tree produced by the {@code nilAtom}
	 * labeled alternative in {@link ConditionalParser#atom}.
	 * @param ctx the parse tree
	 */
	void enterNilAtom(ConditionalParser.NilAtomContext ctx);
	/**
	 * Exit a parse tree produced by the {@code nilAtom}
	 * labeled alternative in {@link ConditionalParser#atom}.
	 * @param ctx the parse tree
	 */
	void exitNilAtom(ConditionalParser.NilAtomContext ctx);
}