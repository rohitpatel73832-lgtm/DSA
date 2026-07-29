class Solution {
    class Pair implements Comparable<Pair> {
        int pt;
        int gt;
        Pair(int pt, int gt) {
            this.pt = pt;
            this.gt = gt;
        }
        public int compareTo(Pair other) {
            return Integer.compare(other.gt, this.gt); // Descending by grow time
        }
    }

    public int earliestFullBloom(int[] p, int[] g) {
        List<Pair> adj = new ArrayList<>();
        for (int i = 0; i < p.length; i++) {
            adj.add(new Pair(p[i], g[i]));
        }
        Collections.sort(adj);
        int days = 0;
        int maxDays = 0;

        for (int i = 0; i < adj.size(); i++) {
            Pair curr = adj.get(i);
            days += curr.pt;
            maxDays = Math.max(maxDays, days + curr.gt);
        }

        return maxDays;
    }
}