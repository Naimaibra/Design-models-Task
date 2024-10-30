import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class AccessControlService {
    private static AccessControlService instance;
    private Map<String, Set<String>> accessMap;

    private AccessControlService() {
        accessMap = new HashMap<>();
    }

    public static AccessControlService getInstance() {
        if (instance == null) {
            instance = new AccessControlService();
        }
        return instance;
    }

    public void addAccess(String documentId, String username) {
        accessMap.computeIfAbsent(documentId, k -> new HashSet<>()).add(username);
    }

    public boolean isAllowed(String documentId, String username) {
        return accessMap.getOrDefault(documentId, new HashSet<>()).contains(username);
    }
}
