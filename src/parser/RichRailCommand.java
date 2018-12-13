package parser;

import org.antlr.v4.runtime.misc.NotNull;

public class RichRailCommand extends RichRailBaseListener {
	public void enterNewtraincommand(@NotNull RichRailParser.NewtraincommandContext ctx) {
		System.out.println("type " + ctx.getChild(1));
		System.out.println("id " + ctx.getChild(2));
	}
}
