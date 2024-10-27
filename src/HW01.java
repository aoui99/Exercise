import java.util.*;

public class HW01 {
    private static class Station {
        public int id;
        public List<Integer> routes;

        public Station(int id) {
            this.id = id;
            this.routes = new ArrayList<>();
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int start = scanner.nextInt();
        int breakfast = scanner.nextInt();
        int end = scanner.nextInt();
        int routeCount = scanner.nextInt();
        scanner.nextLine(); // Consume the rest of the line

        // Map each station to its corresponding Station object
        Map<Integer, Station> stations = new HashMap<>();

        // Read the routes and populate the stations map
        for (int i = 0; i < routeCount; i++) {
            String[] parts = scanner.nextLine().split(" ");
            int routeId = i;
            for (int j = 1; j < parts.length; j++) {
                int stationId = Integer.parseInt(parts[j]);
                Station station = stations.getOrDefault(stationId, new Station(stationId));
                station.routes.add(routeId);
                stations.put(stationId, station);
            }
        }

        // Calculate the minimum number of buses needed to get from start to breakfast to end
        int busesNeeded = findMinimumBusesNeeded(stations, start, breakfast, end);
        System.out.println(busesNeeded);
    }

    private static int findMinimumBusesNeeded(Map<Integer, Station> stations, int start, int breakfast, int end) {
        // Perform BFS twice: start to breakfast, and breakfast to end
        int busesToBreakfast = bfs(stations, start, breakfast);
        int busesToEnd = bfs(stations, breakfast, end);

        // If either search failed, return -1
        if (busesToBreakfast == -1 || busesToEnd == -1) {
            return -1;
        }

        // Return the total number of buses needed, minus one if start != breakfast
        return busesToBreakfast + busesToEnd - (start == breakfast ? 0 : 1);
    }

    private static int bfs(Map<Integer, Station> stations, int start, int end) {
        Set<Integer> visitedStations = new HashSet<>();
        Set<Integer> visitedRoutes = new HashSet<>();
        Queue<int[]> queue = new LinkedList<>(); // int[]: {stationId, previousRouteId, busesTaken}

        // Enqueue starting station with dummy route -1 and 0 buses taken
        queue.offer(new int[]{start, -1, 0});
        visitedStations.add(start);

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int currentStationId = current[0];
            int currentRouteId = current[1];
            int busesTaken = current[2];

            if (currentStationId == end) {
                return busesTaken;
            }

            Station currentStation = stations.get(currentStationId);
            for (int nextRouteId : currentStation.routes) {
                if (nextRouteId != currentRouteId && !visitedRoutes.contains(nextRouteId)) {
                    // Take a new route, increment busesTaken
                    for (int nextStationId : stations.keySet()) {
                        if (stations.get(nextStationId).routes.contains(nextRouteId) && !visitedStations.contains(nextStationId)) {
                            queue.offer(new int[]{nextStationId, nextRouteId, busesTaken + 1});
                            visitedStations.add(nextStationId);
                        }
                    }
                    visitedRoutes.add(nextRouteId);
                }
            }
        }

        // If we didn't find the end station
        return -1;
    }
}

