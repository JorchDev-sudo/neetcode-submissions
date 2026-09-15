class MedianFinder {

    PriorityQueue<Integer> left =
        new PriorityQueue<>(Collections.reverseOrder());

    PriorityQueue<Integer> right =
        new PriorityQueue<>();

    public MedianFinder() {
    }

    public void addNum(int num) {

        // 1. Add to left
        left.add(num);

        // 2. Move the largest element from left to right
        right.add(left.poll());

        // 3. Keep left equal or one larger than right
        if (right.size() > left.size()) {
            left.add(right.poll());
        }
    }

    public double findMedian() {

        if (left.size() > right.size()) {
            return left.peek();
        }

        return (left.peek() + right.peek()) / 2.0;
    }
}
