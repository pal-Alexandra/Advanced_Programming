package homework3;

/**
 * @author Pal Alexandra
 * This class describes the PERSON-TO-COMPANY relationship in the network. This relationship mentions the position that the person has in the related company, and it is not symmetric,
 */
public class CompanyRelationship implements Relationship {

    private CompanyPosition position;

    /**
     * This is the constructor of the class.
     *
     * @param position: sets the position in company.
     */

    public CompanyRelationship(CompanyPosition position) {
        this.position = position;
    }

    /**
     * This method is used to set the person position in the company
     *
     * @param position: sets the position that a person has in the current company.
     */
    public void setPosition(CompanyPosition position) {
        this.position = position;
    }

    /**
     * Whithin this method, this class implement the interface Relationship
     *
     * @return a string represention the position that a person has in the current company.
     */
    @Override
    public String getType() {
        return position.toString();
    }
}
