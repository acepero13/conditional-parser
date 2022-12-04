// Generated from java-escape by ANTLR 4.11.1
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link conditionalParser}.
 */
public interface conditionalListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link conditionalParser#program}.
	 * @param ctx the parse tree
	 */
	void enterProgram(conditionalParser.ProgramContext ctx);
	/**
	 * Exit a parse tree produced by {@link conditionalParser#program}.
	 * @param ctx the parse tree
	 */
	void exitProgram(conditionalParser.ProgramContext ctx);
	/**
	 * Enter a parse tree produced by {@link conditionalParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterStatement(conditionalParser.StatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link conditionalParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitStatement(conditionalParser.StatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link conditionalParser#condition}.
	 * @param ctx the parse tree
	 */
	void enterCondition(conditionalParser.ConditionContext ctx);
	/**
	 * Exit a parse tree produced by {@link conditionalParser#condition}.
	 * @param ctx the parse tree
	 */
	void exitCondition(conditionalParser.ConditionContext ctx);
	/**
	 * Enter a parse tree produced by {@link conditionalParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterExpr(conditionalParser.ExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link conditionalParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitExpr(conditionalParser.ExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link conditionalParser#assign}.
	 * @param ctx the parse tree
	 */
	void enterAssign(conditionalParser.AssignContext ctx);
	/**
	 * Exit a parse tree produced by {@link conditionalParser#assign}.
	 * @param ctx the parse tree
	 */
	void exitAssign(conditionalParser.AssignContext ctx);
	/**
	 * Enter a parse tree produced by {@link conditionalParser#add}.
	 * @param ctx the parse tree
	 */
	void enterAdd(conditionalParser.AddContext ctx);
	/**
	 * Exit a parse tree produced by {@link conditionalParser#add}.
	 * @param ctx the parse tree
	 */
	void exitAdd(conditionalParser.AddContext ctx);
	/**
	 * Enter a parse tree produced by {@link conditionalParser#sub}.
	 * @param ctx the parse tree
	 */
	void enterSub(conditionalParser.SubContext ctx);
	/**
	 * Exit a parse tree produced by {@link conditionalParser#sub}.
	 * @param ctx the parse tree
	 */
	void exitSub(conditionalParser.SubContext ctx);
	/**
	 * Enter a parse tree produced by {@link conditionalParser#mul}.
	 * @param ctx the parse tree
	 */
	void enterMul(conditionalParser.MulContext ctx);
	/**
	 * Exit a parse tree produced by {@link conditionalParser#mul}.
	 * @param ctx the parse tree
	 */
	void exitMul(conditionalParser.MulContext ctx);
	/**
	 * Enter a parse tree produced by {@link conditionalParser#div}.
	 * @param ctx the parse tree
	 */
	void enterDiv(conditionalParser.DivContext ctx);
	/**
	 * Exit a parse tree produced by {@link conditionalParser#div}.
	 * @param ctx the parse tree
	 */
	void exitDiv(conditionalParser.DivContext ctx);
	/**
	 * Enter a parse tree produced by {@link conditionalParser#ifcond}.
	 * @param ctx the parse tree
	 */
	void enterIfcond(conditionalParser.IfcondContext ctx);
	/**
	 * Exit a parse tree produced by {@link conditionalParser#ifcond}.
	 * @param ctx the parse tree
	 */
	void exitIfcond(conditionalParser.IfcondContext ctx);
}