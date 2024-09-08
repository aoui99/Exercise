import java.util.*;
public class YY04 {

    public class InterviewScheduler {
        public int maxPossibilitySum(int[][] interviews, int k) {
            // 按照开始时间对面试进行排序
            Arrays.sort(interviews, Comparator.comparingInt(a -> a[0]));

            // 创建一个最小堆来存储当前可以参加的面试，按照结束时间排序
            PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);

            int maxPossibility = 0;

            // 遍历排序后的面试
            for (int[] interview : interviews) {
                // 弹出堆中结束时间早于或等于当前面试开始时间的面试
                while (!pq.isEmpty() && pq.peek()[1] <= interview[0]) {
                    maxPossibility += pq.poll()[2]; // 累加之前面试的可能性
                }

                // 如果还可以参加面试（即k大于0），并且堆的大小小于k
                if (pq.size() < k) {
                    pq.offer(interview); // 将当前面试加入堆中
                } else if (pq.peek()[2] < interview[2]) {
                    // 如果当前面试的可能性更大，则弹出堆顶面试，并加入当前面试
                    maxPossibility += pq.poll()[2];
                    pq.offer(interview);
                }

                // 如果堆的大小超过了k，则弹出堆顶面试（即结束时间最早的面试）
                if (pq.size() > k) {
                    pq.poll();
                }
            }

            // 堆中剩下的面试都是小明可以参加的，将剩余的可能性累加到最大可能性中
            while (!pq.isEmpty()) {
                maxPossibility += pq.poll()[2];
            }

            return maxPossibility;
        }

//        public static void main(String[] args) {
//            InterviewScheduler scheduler = new InterviewScheduler();
//            int[][] interviews = {{1, 2, 3}, {3, 4, 2}, {2, 5, 4}}; // 假设这是输入的面试数组
//            int k = 2;
//            int result = scheduler.maxPossibilitySum(interviews, k);
//            System.out.println("Max possibility sum: " + result); // 应该输出5
//        }
    }
}
