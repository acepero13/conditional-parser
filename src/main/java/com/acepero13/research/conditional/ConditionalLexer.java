// Generated from Conditional.g4 by ANTLR 4.9.3
package com.acepero13.research.conditional;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class ConditionalLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.9.3", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		OR=1, AND=2, EQ=3, NEQ=4, GT=5, LT=6, GTEQ=7, LTEQ=8, PLUS=9, MINUS=10, 
		MULT=11, DIV=12, MOD=13, POW=14, NOT=15, SCOL=16, ASSIGN=17, OPAR=18, 
		CPAR=19, TRUE=20, FALSE=21, NIL=22, IF=23, THEN=24, ELSE=25, LOG=26, ID=27, 
		INT=28, FLOAT=29, STRING=30, COMMENT=31;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"OR", "AND", "EQ", "NEQ", "GT", "LT", "GTEQ", "LTEQ", "PLUS", "MINUS", 
			"MULT", "DIV", "MOD", "POW", "NOT", "SCOL", "ASSIGN", "OPAR", "CPAR", 
			"TRUE", "FALSE", "NIL", "IF", "THEN", "ELSE", "LOG", "ID", "INT", "FLOAT", 
			"STRING", "COMMENT"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'||'", "'&&'", "'=='", "'!='", "'>'", "'<'", "'>='", "'<='", "'+'", 
			"'-'", "'*'", "'/'", "'%'", "'^'", "'!'", "';'", "'='", "'('", "')'", 
			"'true'", "'false'", "'nil'", null, null, "'else'", "'log'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "OR", "AND", "EQ", "NEQ", "GT", "LT", "GTEQ", "LTEQ", "PLUS", "MINUS", 
			"MULT", "DIV", "MOD", "POW", "NOT", "SCOL", "ASSIGN", "OPAR", "CPAR", 
			"TRUE", "FALSE", "NIL", "IF", "THEN", "ELSE", "LOG", "ID", "INT", "FLOAT", 
			"STRING", "COMMENT"
		};
	}
	private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}


	public ConditionalLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "Conditional.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getChannelNames() { return channelNames; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2!\u00c9\b\1\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \3\2"+
		"\3\2\3\2\3\3\3\3\3\3\3\4\3\4\3\4\3\5\3\5\3\5\3\6\3\6\3\7\3\7\3\b\3\b\3"+
		"\b\3\t\3\t\3\t\3\n\3\n\3\13\3\13\3\f\3\f\3\r\3\r\3\16\3\16\3\17\3\17\3"+
		"\20\3\20\3\21\3\21\3\22\3\22\3\23\3\23\3\24\3\24\3\25\3\25\3\25\3\25\3"+
		"\25\3\26\3\26\3\26\3\26\3\26\3\26\3\27\3\27\3\27\3\27\3\30\3\30\3\30\3"+
		"\30\5\30\u0081\n\30\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31\5\31\u008b"+
		"\n\31\3\32\3\32\3\32\3\32\3\32\3\33\3\33\3\33\3\33\3\34\3\34\7\34\u0098"+
		"\n\34\f\34\16\34\u009b\13\34\3\35\6\35\u009e\n\35\r\35\16\35\u009f\3\36"+
		"\6\36\u00a3\n\36\r\36\16\36\u00a4\3\36\3\36\7\36\u00a9\n\36\f\36\16\36"+
		"\u00ac\13\36\3\36\3\36\6\36\u00b0\n\36\r\36\16\36\u00b1\5\36\u00b4\n\36"+
		"\3\37\3\37\3\37\3\37\7\37\u00ba\n\37\f\37\16\37\u00bd\13\37\3\37\3\37"+
		"\3 \3 \7 \u00c3\n \f \16 \u00c6\13 \3 \3 \2\2!\3\3\5\4\7\5\t\6\13\7\r"+
		"\b\17\t\21\n\23\13\25\f\27\r\31\16\33\17\35\20\37\21!\22#\23%\24\'\25"+
		")\26+\27-\30/\31\61\32\63\33\65\34\67\359\36;\37= ?!\3\2\7\5\2C\\aac|"+
		"\6\2\62;C\\aac|\3\2\62;\5\2\f\f\17\17$$\4\2\f\f\17\17\2\u00d3\2\3\3\2"+
		"\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17"+
		"\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2"+
		"\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3"+
		"\2\2\2\2\'\3\2\2\2\2)\3\2\2\2\2+\3\2\2\2\2-\3\2\2\2\2/\3\2\2\2\2\61\3"+
		"\2\2\2\2\63\3\2\2\2\2\65\3\2\2\2\2\67\3\2\2\2\29\3\2\2\2\2;\3\2\2\2\2"+
		"=\3\2\2\2\2?\3\2\2\2\3A\3\2\2\2\5D\3\2\2\2\7G\3\2\2\2\tJ\3\2\2\2\13M\3"+
		"\2\2\2\rO\3\2\2\2\17Q\3\2\2\2\21T\3\2\2\2\23W\3\2\2\2\25Y\3\2\2\2\27["+
		"\3\2\2\2\31]\3\2\2\2\33_\3\2\2\2\35a\3\2\2\2\37c\3\2\2\2!e\3\2\2\2#g\3"+
		"\2\2\2%i\3\2\2\2\'k\3\2\2\2)m\3\2\2\2+r\3\2\2\2-x\3\2\2\2/\u0080\3\2\2"+
		"\2\61\u008a\3\2\2\2\63\u008c\3\2\2\2\65\u0091\3\2\2\2\67\u0095\3\2\2\2"+
		"9\u009d\3\2\2\2;\u00b3\3\2\2\2=\u00b5\3\2\2\2?\u00c0\3\2\2\2AB\7~\2\2"+
		"BC\7~\2\2C\4\3\2\2\2DE\7(\2\2EF\7(\2\2F\6\3\2\2\2GH\7?\2\2HI\7?\2\2I\b"+
		"\3\2\2\2JK\7#\2\2KL\7?\2\2L\n\3\2\2\2MN\7@\2\2N\f\3\2\2\2OP\7>\2\2P\16"+
		"\3\2\2\2QR\7@\2\2RS\7?\2\2S\20\3\2\2\2TU\7>\2\2UV\7?\2\2V\22\3\2\2\2W"+
		"X\7-\2\2X\24\3\2\2\2YZ\7/\2\2Z\26\3\2\2\2[\\\7,\2\2\\\30\3\2\2\2]^\7\61"+
		"\2\2^\32\3\2\2\2_`\7\'\2\2`\34\3\2\2\2ab\7`\2\2b\36\3\2\2\2cd\7#\2\2d"+
		" \3\2\2\2ef\7=\2\2f\"\3\2\2\2gh\7?\2\2h$\3\2\2\2ij\7*\2\2j&\3\2\2\2kl"+
		"\7+\2\2l(\3\2\2\2mn\7v\2\2no\7t\2\2op\7w\2\2pq\7g\2\2q*\3\2\2\2rs\7h\2"+
		"\2st\7c\2\2tu\7n\2\2uv\7u\2\2vw\7g\2\2w,\3\2\2\2xy\7p\2\2yz\7k\2\2z{\7"+
		"n\2\2{.\3\2\2\2|}\7k\2\2}\u0081\7h\2\2~\177\7K\2\2\177\u0081\7H\2\2\u0080"+
		"|\3\2\2\2\u0080~\3\2\2\2\u0081\60\3\2\2\2\u0082\u0083\7v\2\2\u0083\u0084"+
		"\7j\2\2\u0084\u0085\7g\2\2\u0085\u008b\7p\2\2\u0086\u0087\7V\2\2\u0087"+
		"\u0088\7J\2\2\u0088\u0089\7G\2\2\u0089\u008b\7P\2\2\u008a\u0082\3\2\2"+
		"\2\u008a\u0086\3\2\2\2\u008b\62\3\2\2\2\u008c\u008d\7g\2\2\u008d\u008e"+
		"\7n\2\2\u008e\u008f\7u\2\2\u008f\u0090\7g\2\2\u0090\64\3\2\2\2\u0091\u0092"+
		"\7n\2\2\u0092\u0093\7q\2\2\u0093\u0094\7i\2\2\u0094\66\3\2\2\2\u0095\u0099"+
		"\t\2\2\2\u0096\u0098\t\3\2\2\u0097\u0096\3\2\2\2\u0098\u009b\3\2\2\2\u0099"+
		"\u0097\3\2\2\2\u0099\u009a\3\2\2\2\u009a8\3\2\2\2\u009b\u0099\3\2\2\2"+
		"\u009c\u009e\t\4\2\2\u009d\u009c\3\2\2\2\u009e\u009f\3\2\2\2\u009f\u009d"+
		"\3\2\2\2\u009f\u00a0\3\2\2\2\u00a0:\3\2\2\2\u00a1\u00a3\t\4\2\2\u00a2"+
		"\u00a1\3\2\2\2\u00a3\u00a4\3\2\2\2\u00a4\u00a2\3\2\2\2\u00a4\u00a5\3\2"+
		"\2\2\u00a5\u00a6\3\2\2\2\u00a6\u00aa\7\60\2\2\u00a7\u00a9\t\4\2\2\u00a8"+
		"\u00a7\3\2\2\2\u00a9\u00ac\3\2\2\2\u00aa\u00a8\3\2\2\2\u00aa\u00ab\3\2"+
		"\2\2\u00ab\u00b4\3\2\2\2\u00ac\u00aa\3\2\2\2\u00ad\u00af\7\60\2\2\u00ae"+
		"\u00b0\t\4\2\2\u00af\u00ae\3\2\2\2\u00b0\u00b1\3\2\2\2\u00b1\u00af\3\2"+
		"\2\2\u00b1\u00b2\3\2\2\2\u00b2\u00b4\3\2\2\2\u00b3\u00a2\3\2\2\2\u00b3"+
		"\u00ad\3\2\2\2\u00b4<\3\2\2\2\u00b5\u00bb\7$\2\2\u00b6\u00ba\n\5\2\2\u00b7"+
		"\u00b8\7$\2\2\u00b8\u00ba\7$\2\2\u00b9\u00b6\3\2\2\2\u00b9\u00b7\3\2\2"+
		"\2\u00ba\u00bd\3\2\2\2\u00bb\u00b9\3\2\2\2\u00bb\u00bc\3\2\2\2\u00bc\u00be"+
		"\3\2\2\2\u00bd\u00bb\3\2\2\2\u00be\u00bf\7$\2\2\u00bf>\3\2\2\2\u00c0\u00c4"+
		"\7%\2\2\u00c1\u00c3\n\6\2\2\u00c2\u00c1\3\2\2\2\u00c3\u00c6\3\2\2\2\u00c4"+
		"\u00c2\3\2\2\2\u00c4\u00c5\3\2\2\2\u00c5\u00c7\3\2\2\2\u00c6\u00c4\3\2"+
		"\2\2\u00c7\u00c8\b \2\2\u00c8@\3\2\2\2\16\2\u0080\u008a\u0099\u009f\u00a4"+
		"\u00aa\u00b1\u00b3\u00b9\u00bb\u00c4\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}