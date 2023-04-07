import java.util.*;

public class KargerAlgorithm {
    public static int minCut(int[][] graph) {
        int n = graph.length;

        while (n > 2) {
            // Rastgele seçilen iki düğümü birleştirir.
            int u = rand.nextInt(n);
            int v = rand.nextInt(n);
            while (u == v) {
                v = rand.nextInt(n);
            }

            // Düğümleri birleştirir.
            int[][] merged = mergeNodes(graph, u, v);
            graph = merged;
            n = graph.length;
        }

        // Geriye kalan iki düğüm arasındaki kenar sayısı, grafın kesim sayısıdır.
        int cut = 0;
        for (int i = 0; i < graph[0].length; i++) {
            cut += graph[0][i];
        }
        return cut;
    }

    private static int[][] mergeNodes(int[][] graph, int u, int v) {
        int n = graph.length;

        // Düğümleri birleştirir.
        int[] merged = new int[n];
        for (int i = 0; i < n; i++) {
            if (i == v) {
                continue;
            }
            merged[i] = graph[u][i] + graph[v][i];
        }

        // Kenarları keser.
        for (int i = 0; i < n; i++) {
            if (i == u || i == v) {
                continue;
            }
            merged[i] = graph[i][u] + graph[i][v];
        }

        // Birleştirilmiş düğümü siler.
        int[][] newGraph = new int[n - 1][n - 1];
        int x = 0;
        for (int i = 0; i < n; i++) {
            if (i == v) {
                continue;
            }
            int y = 0;
            for (int j = 0; j < n; j++) {
                if (j == u) {
                    continue;
                }
                newGraph[x][y] = merged[j];
                y++;
            }
            x++;
        }
        return newGraph;
    }

    public static void main(String[] args) {
        int n = 4; // Düğüm sayısı
        int[][] graph = new int[][]{
                {0, 2, 0, 3},
                {2, 0, 1, 0},
                {0, 1, 0, 4},
                {3, 0, 4, 0}
        };

        int minCut = minCut(graph);
        System.out.println("Minimum cut: " + minCut);
    }

    private static final Random rand = new Random();
}
