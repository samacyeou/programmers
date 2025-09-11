import java.util.*;

class Solution {
    public String solution(String m, String[] musicinfos) {
        Map<String, Integer> time = new HashMap<>();
        Map<String, String> music = new HashMap<>();
        List<String> name = new ArrayList<>();
        
        for (int i = 0; i < musicinfos.length; i++) {
            String[] split = musicinfos[i].split(",");
            name.add(split[2]);
            int span = time(split[0], split[1]);
            time.put(split[2], span);
            
            String melody = music(split[3], span);
            music.put(split[2], melody);
        }

        Collections.sort(name, (a, b) -> time.get(b).compareTo(time.get(a)));
        for (int i = 0; i < name.size(); i++) {
            String melody = music.get(name.get(i));

            if (compare(m, melody)) {
                return name.get(i);
            }
        }

        return "(None)";
    }

    public int time(String start, String end) {
        int startTime = Integer.parseInt(start.split(":")[0]) * 60 + Integer.parseInt(start.split(":")[1]);
        int endTime = Integer.parseInt(end.split(":")[0]) * 60 + Integer.parseInt(end.split(":")[1]);

        return endTime - startTime;
    }

    public String music(String music, int time) {
        int idx = 0, loop = 0;
        StringBuilder sb = new StringBuilder();

        while (loop < time) {
            sb.append(music.charAt(idx));
            idx = (idx + 1) % music.length();

            if (music.charAt(idx) == '#') {
                sb.append(music.charAt(idx));
                idx = (idx + 1) % music.length();
            }

            loop++;
        }

        return sb.toString();
    }

    public boolean compare(String m, String melody) {
        int idx = 0, cnt = 0;
        while (idx < m.length()) {
            if (idx + 1 < m.length() && m.charAt(idx + 1) == '#') idx++;

            idx++;
            cnt++;
        }

        idx = 0;
        while (idx < melody.length()) {
            StringBuilder sb = new StringBuilder();

            int p = idx;
            int loop = 0;
            while (p < melody.length() && loop < cnt) {
                sb.append(melody.charAt(p++));
                if (p < melody.length() && melody.charAt(p) == '#') sb.append(melody.charAt(p++));

                loop++;
            }

            if (sb.toString().equals(m)) return true;

            idx++;
        }


        return false;
    }
}