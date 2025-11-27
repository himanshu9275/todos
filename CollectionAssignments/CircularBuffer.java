public class CircularBuffer {
    private int[] buffer;
    private int size;
    private int index = 0;
    private boolean isFull = false;

    public CircularBuffer(int size) {
        this.size = size;
        buffer = new int[size];
    }

    public void add(int value) {
        buffer[index] = value;
        index = (index + 1) % size;

        if (index == 0) isFull = true;
    }

    public void printBuffer() {
        System.out.print("[ ");
        if (!isFull) {
            for (int i = 0; i < index; i++)
                System.out.print(buffer[i] + " ");
        } else {
            for (int i = 0; i < size; i++)
                System.out.print(buffer[(index + i) % size] + " ");
        }
        System.out.println("]");
    }

    public static void main(String[] args) {
        CircularBuffer cb = new CircularBuffer(3);
        cb.add(1);
        cb.add(2);
        cb.add(3);

        cb.printBuffer(); // [1 2 3]

        cb.add(4);
        cb.printBuffer(); // [2 3 4]
    }
}
