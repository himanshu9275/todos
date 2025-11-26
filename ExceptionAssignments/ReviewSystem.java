class InvalidRatingException extends Exception { InvalidRatingException(String m){super(m);} }
class EmptyReviewException extends Exception { EmptyReviewException(String m){super(m);} }

public class ReviewSystem {
    static void submitReview(int rating, String comment) throws InvalidRatingException, EmptyReviewException {
        if (rating < 1 || rating > 5) throw new InvalidRatingException("Rating must be 1-5");
        if (comment == null || comment.trim().isEmpty()) throw new EmptyReviewException("Comment required");
        System.out.println("Review accepted.");
    }

    public static void main(String[] args) {
        try {
            submitReview(6, "");
        } catch (InvalidRatingException e) {
            System.out.println("Invalid rating: " + e.getMessage());
        } catch (EmptyReviewException e) {
            System.out.println("Empty review: " + e.getMessage());
        }
    }
}
