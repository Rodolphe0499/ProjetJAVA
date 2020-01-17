package fr.utt.lo02.jest_jason_rodolphe.modeles;

public class ScoreVisitorVintage extends Visitor {
	   private ScoreVisitor cdc;

	    /** 
	     * Constructeur
	     */
	    public ScoreVisitorVintage() {
	        super();

	        this.cdc = new ScoreVisitor();
	    }


	    /** 
	     * {@inheritDoc}
	     */
	    protected int compterPiques(Jest j) {
	        return this.cdc.compterPiques(j);
	    }

	    /**
	     * {@inheritDoc}
	     */
	    protected int compterTrefles(Jest j) {
	        return this.cdc.compterTrefles(j);
	    }

	    /**
	     * {@inheritDoc}
	     */
	    protected int compterCarreaux(Jest j) {
	        return this.cdc.compterCarreaux(j);
	    }

	    /**
	     * {@inheritDoc}
	     */
	    protected int compterCoeurs(Jest j) {
	        return this.cdc.compterCoeurs(j);
	    }

	    /**
	     * {@inheritDoc}
	     */
	    protected int compterPaires(Jest j) {
	        return this.cdc.compterPaires(j);
	    }

	    /**
	     * {@inheritDoc}
	     */
	    protected int compterJoker(Jest j) {
	        return this.cdc.compterJoker(j) - 2*j.accept(cdc);
	    }

	    /**
	     * {@inheritDoc}
	     */
	    protected int compterBonus(Jest j) {
	        return 0;
	    }

		@Override
		protected int compterValet(Jest j) {
			
			return this.cdc.compterValet(j);
		}
	}


