//import java.util.List;
//import java.util.PriorityQueue;
//import java.util.Queue;
//import java.util.stream.Collectors;
//
//public class UpThenDownStrategy implements ElevatorMovementStrategy {
//    @Override
//    public List<Request> getTraversalOrder(List<Request> requests, int currentFloor) {
//        Queue<Request> upQueue = new PriorityQueue<>(Comparator.comparingInt(Request::getFloor));
//        Queue<Request> downQueue = new PriorityQueue<>((a, b) -> b.getFloor() - a.getFloor());
//
//        for (Request request : requests) {
//            if (request.getFloor() >= currentFloor) {
//                upQueue.add(request);
//            } else {
//                downQueue.add(request);
//            }
//        }
//
//        // First process UP requests, then DOWN requests
//        List<Request> orderedRequests = upQueue.stream().collect(Collectors.toList());
//        orderedRequests.addAll(downQueue.stream().collect(Collectors.toList()));
//
//        return orderedRequests;
//    }
//}
