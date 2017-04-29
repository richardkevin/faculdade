package Model;





/**
 *
 * @author richard
 */
public class Rating {
    private int id;
    private int type;
    private String description;
    private int stars;

    private final int RATED_BY_FRIEND = 0;
    private final int RATED_BY_GUEST = 1;
    private final int RATED_BY_HOST = 2;
    private final int RATED_BY_CALLER = 3;
    private final int RATED_BY_INVITED = 4;

    public Rating(int id, int type, String description, int stars) {
        this.id = id;
        this.type = type;
        this.description = description;
        this.stars = stars;
    }
}
