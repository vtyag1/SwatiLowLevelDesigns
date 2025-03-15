//import java.util.ArrayList;
//import java.util.List;
//
//public class ElevatorCar implements Runnable {
//    private int id;
//    private int currentFloor;
//    private Direction direction;
//    private Display display;
//    private List<Request> pendingRequests;  // Store all requests as a single list
//    private ElevatorMovementStrategy movementStrategy;
//    private boolean isRunning = true; // Keep thread alive
//
//    public ElevatorCar(int id, ElevatorMovementStrategy strategy) {
//        this.id = id;
//        this.currentFloor = 0;  // Assume ground floor start
//        this.direction = Direction.IDLE;
//        this.display = new Display();
//        this.pendingRequests = new ArrayList<>();
//        this.movementStrategy = strategy;
//    }
//
//    public synchronized void addRequest(Request request) {
//        pendingRequests.add(request);
//        notify(); // Wake up the thread if it's waiting
//    }
//
//    public void run() {
//        while (isRunning) {
//            processRequests();
//            try {
//                synchronized (this) {
//                    if (pendingRequests.isEmpty()) {
//                        wait(); // Sleep if no requests
//                    }
//                }
//            } catch (InterruptedException e) {
//                Thread.currentThread().interrupt();
//            }
//        }
//    }
//
//    private void processRequests() {
//        List<Request> orderedRequests = movementStrategy.getTraversalOrder(pendingRequests, currentFloor);
//        for (Request request : orderedRequests) {
//            moveToFloor(request.getFloor());
//            pendingRequests.remove(request); // Remove once served
//        }
//        direction = Direction.IDLE;
//    }
//
//    private void moveToFloor(int floor) {
//        System.out.println("Elevator " + id + " moving to floor " + floor);
//        this.currentFloor = floor;
//        display.updateFloor(floor);
//    }
//}
