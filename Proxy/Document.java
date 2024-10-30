public interface Document {
    String getIdentifier();
    Date getCreationDate();
    String getContent(User user) throws AccessDeniedException;
}
