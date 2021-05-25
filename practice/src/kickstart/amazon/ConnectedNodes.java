package kickstart.amazon;

import java.util.*;

public class ConnectedNodes {

    public static int connectedSum(int n, List<String> edges) {

        Map<String,Set<String>> islands = new HashMap<>();
        Map<String,String> visitedNodes = new HashMap<>();

        for(String edge :edges){

            String[] values = edge.split(" ");
            String nodeA = values[0];
            String nodeB = values[1];

            checkIfPresent(nodeA,nodeB,islands,visitedNodes);
        }

        int sum = 0;
        int length = 0;
        int existingCount = 0;

        for(Map.Entry<String,Set<String>> entry :islands.entrySet()){
            length = entry.getValue().size()+1;
            existingCount = existingCount +length ;
            sum+= Math.ceil(Math.sqrt(length)) ;

        }

        return sum + (n-existingCount);

    }

    private static void checkIfPresent(String nodeA,String nodeB ,Map<String,Set<String>> islands , Map<String,String> visitedNodes){

        if(islands.containsKey(nodeA)){
            islands.get(nodeA).add(nodeB);
            visitedNodes.put(nodeB, nodeA);
        }else if(islands.containsKey(nodeB)){
            islands.get(nodeB).add(nodeA);
            visitedNodes.put(nodeA, nodeB);
        }
        else if (visitedNodes.containsKey(nodeA)){
            if(islands.containsKey(visitedNodes.get(nodeA))) {
                islands.get(visitedNodes.get(nodeA)).add(nodeB);
                visitedNodes.put(nodeB, visitedNodes.get(nodeA));
            }
            else {
                String node = visitedNodes.get(nodeA);
                for(Map.Entry<String,Set<String> >entry : islands.entrySet()){
                    if(entry.getValue().contains(node)){
                        visitedNodes.put(nodeB,entry.getKey());
                        islands.get(entry.getKey()).add(nodeB);
                    }
                }

            }
        }else if (visitedNodes.containsKey(nodeB)){
            if(islands.containsKey(visitedNodes.get(nodeB))) {
                islands.get(visitedNodes.get(nodeB)).add(nodeA);
                visitedNodes.put(nodeA, visitedNodes.get(nodeB));
            }
            else {
                String node = visitedNodes.get(nodeB);
                for(Map.Entry<String,Set<String> >entry : islands.entrySet()){
                    if(entry.getValue().contains(node)){
                        visitedNodes.put(nodeA,entry.getKey());
                        islands.get(entry.getKey()).add(nodeA);
                    }
                }

            }
        }else {
            Set<String> set = new HashSet<>();
            set.add(nodeB);
            islands.put(nodeA, set);
            visitedNodes.put(nodeB, nodeA);
            visitedNodes.put(nodeA, nodeB);

        }
    }

    public static void main(String[] args){

        List<String> edges = new ArrayList<>();

        edges.add("1 2");
        edges.add("1 3");
        edges.add("2 4");
        edges.add("3 5");
        edges.add("7 8");
        System.out.println(connectedSum(10,edges));


    /*    edges.add("8 1");
        edges.add("5 8");
        edges.add("7 3");
        edges.add("8 6");

        System.out.println(connectedSum(8,edges));
*/

/*

        edges.add("1 2");
        edges.add("2 3");
        edges.add("3 4");

        edges.add("5 6");
        edges.add("6 7");


        System.out.println(connectedSum(7,edges));
*/

    }

}
