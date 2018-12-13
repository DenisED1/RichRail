package ui;

import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

import controllers.ComponentController;
import controllers.TrainController;
import parser.RichRailCommand;
import parser.RichRailLexer;
import parser.RichRailParser;

public class Main {
	public static void main(String args[]) {
		//TrainController tc = new TrainController();
		//ComponentController cc = new ComponentController();
		//cc.removeComponent("tr1", "wg1");
		
CharStream is = CharStreams.fromString("new train jeroen");
        
        RichRailLexer lexer = new RichRailLexer(is);

        // create a buffer of tokens pulled from the lexer
        CommonTokenStream tokens = new CommonTokenStream(lexer);

        // create a parser that feeds off the tokens buffer
        RichRailParser parser = new RichRailParser(tokens);
        
        ParserRuleContext commandContext = parser.command();
        
        ParseTreeWalker walker = new ParseTreeWalker();
        RichRailCommand listener = new RichRailCommand();

        walker.walk(listener, commandContext);

	}
}
