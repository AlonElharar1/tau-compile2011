package IC.AST;

import IC.SymbolTables.SymbolTable;

/**
 * Abstract AST node base class.
 * 
 * @author Tovi Almozlino
 */
public abstract class ASTNode {

	private int line;
	private SymbolTable enclosingScope;
	private IC.TYPE.Type semanticType;

	/**
	 * Double dispatch method, to allow a visitor to visit a specific subclass.
	 * 
	 * @param visitor
	 *            The visitor.
	 * @return A value propagated by the visitor.
	 */
	public abstract Object accept(Visitor visitor);

	/**
	 * Constructs an AST node corresponding to a line number in the original
	 * code. Used by subclasses.
	 * 
	 * @param line
	 *            The line number.
	 */
	protected ASTNode(int line) {
		this.line = line;
	}

	public int getLine() {
		return line;
	}
	
	public void setLine(int line) {
		this.line = line;
	}
	
	public void setEnclosingScope(SymbolTable enclosingScope) {
        this.enclosingScope = enclosingScope;
    }

    public SymbolTable getEnclosingScope() {
		return enclosingScope;
	}

    public IC.TYPE.Type getSemanticType() {
        return semanticType;
    }

    public void setSemanticType(IC.TYPE.Type semanticType) {
        if (this.semanticType == null) { 
        	
            this.semanticType = semanticType;
        }
        
    }
    
}
