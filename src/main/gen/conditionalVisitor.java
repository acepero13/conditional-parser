// Generated from java-escape by ANTLR 4.11.1
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link conditionalParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface conditionalVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link conditionalParser#program}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProgram(conditionalParser.ProgramContext ctx);
	/**
	 * Visit a parse tree produced by {@link conditionalParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatement(conditionalParser.StatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link conditionalParser#condition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCondition(conditionalParser.ConditionContext ctx);
	/**
	 * Visit a parse tree produced by {@link conditionalParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpr(conditionalParser.ExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link conditionalParser#assign}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssign(conditionalParser.AssignContext ctx);
	/**
	 * Visit a parse tree produced by {@link conditionalParser#add}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAdd(conditionalParser.AddContext ctx);
	/**
	 * Visit a parse tree produced by {@link conditionalParser#sub}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSub(conditionalParser.SubContext ctx);
	/**
	 * Visit a parse tree produced by {@link conditionalParser#mul}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMul(conditionalParser.MulContext ctx);
	/**
	 * Visit a parse tree produced by {@link conditionalParser#div}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDiv(conditionalParser.DivContext ctx);
	/**
	 * Visit a parse tree produced by {@link conditionalParser#ifcond}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIfcond(conditionalParser.IfcondContext ctx);
}