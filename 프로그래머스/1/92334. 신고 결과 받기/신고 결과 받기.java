import java.util.HashSet;
import java.util.HashMap;
import java.util.Set;
import java.util.Map;

class Solution {
    public int[] solution(String[] idList, String[] report, int k) {
        Map<String, Integer> mails = new HashMap<>();
        Map<String, Set<String>> reportedBy = new HashMap<>();
        for (String id : idList) {
            mails.put(id, 0);
            reportedBy.put(id, new HashSet<>());
        }

        // Process each report, splitting it into reporter and reportee
        for (String singleReport : report) {
            String[] parts = singleReport.split(" ");
            String reporter = parts[0];
            String reportee = parts[1];
            reportedBy.get(reportee).add(reporter);
        }

        // Count how many reports each reporter should receive
        for (Set<String> reporters : reportedBy.values()) {
            if (reporters.size() >= k) {
                for (String reporter : reporters) {
                    mails.put(reporter, mails.get(reporter) + 1);
                }
            }
        }

        // Prepare the result array in the same order as idList
        int[] result = new int[idList.length];
        for (int i = 0; i < idList.length; i++) {
            result[i] = mails.get(idList[i]);
        }

        return result;
    }
}