import java.util.*;

class Solution {
    public int solution(int[][] points, int[][] routes) {
        int answer = 0;

        // 로봇 초기 위치 설정
        List<Map<Integer, Loc>> moves = new ArrayList<>();
        int maxTime = 0;
        for (int[] route : routes) {
            int time = 0;
            Map<Integer, Loc> map = new HashMap<>();
            map.put(0, new Loc(points[route[0]-1][0], points[route[0]-1][1]));
            for(int j = 1; j<route.length; j++) {
                // 시작위치
                int startX = points[route[j-1]-1][0];
                int startY = points[route[j-1]-1][1];
                // 도착위치
                int destX = points[route[j]-1][0];
                int destY = points[route[j]-1][1];

                int currentX = startX;
                int currentY = startY;

                if(destX > startX) {
                    for (int i = 0; i < destX-startX; i++) {
                        map.put(++time, new Loc(++currentX, currentY));
                    }
                }else if(destX < startX) {
                    for (int i = 0; i < startX-destX; i++) {
                        map.put(++time, new Loc(--currentX, currentY));
                    }
                }

                if(destY > startY) {
                    for (int i = 0; i < destY-startY; i++) {
                        map.put(++time, new Loc(currentX, ++currentY));
                    }
                }
                else if(destY < startY) {
                    for (int i = 0; i < startY-destY; i++) {
                        map.put(++time, new Loc(currentX, --currentY));
                    }
                }
            }
            maxTime = Math.max(maxTime, time);
            moves.add(map);
        }

        // 같은 시간에 같은 좌표 체크
        for (int time = 0; time <= maxTime; time++) {
            Map<Loc, Integer> times = new HashMap<>();
            for (Map<Integer, Loc> map : moves) {
                Loc loc = map.get(time);
                if( loc != null) {
                    times.put(map.get(time), times.getOrDefault(map.get(time), 0) + 1);
                }
            }
            for (Loc loc : times.keySet()) {
                if (times.get(loc) >1) {
                    answer ++;
                }
            }
        }
        return answer;
    }
//


    // Loc 클래스에 equals와 hashCode를 정의
    static class Loc {
        int x, y;

        public Loc(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public int getX() {
            return x;
        }

        public int getY() {
            return y;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Loc loc = (Loc) o;
            return x == loc.x && y == loc.y;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }
    }
}