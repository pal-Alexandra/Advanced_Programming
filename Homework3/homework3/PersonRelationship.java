package homework3;

/**
 * @author Pal Alexandra
 * This class describes the PERSON-TO-PERSON relationship in the network. This relationship it is NOT symmetric (similar to "friendships" on Instagram plaform.)
 */
public class PersonRelationship implements Relationship {
    /**
     * Whithin this method, this class implement the interface Relationship
     *
     * @return a string descring the relationship type
     */
    @Override
    public String getType() {
        return "FOLLOW";
    }
}
