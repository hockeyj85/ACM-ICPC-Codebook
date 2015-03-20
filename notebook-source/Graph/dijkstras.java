import java.util.*;

class Main {

	public static void main(String[] args) {
		new Main().begin();
	}

/* START SOLUTION */

class Vertex implements Comparable<Vertex> {
	Vertex() {}
	int id;
	int x;
	int y;
	int floor;
	int prev;
	double dist;
	boolean visited;
	ArrayList<Edge> edges;
	public int compareTo (Vertex o) { 
		return Double.compare(this.dist, o.dist); 
	}
}

class Edge {
	double cost;
	int dest;
}

void resetGraph(Vertex[] graph) {
	for (Vertex v: graph) {
		if (v == null) continue;
		v.prev = -1;
		v.dist = Double.MAX_VALUE;
		v.visited = false;
	}
}

double dijkstras(Vertex[] graph, int start, int finish) {
	
	graph[start].dist = 0;
	boolean[] visited = new boolean[graph.length];

	PriorityQueue<Vertex> q = new PriorityQueue<Vertex>();
	q.add(graph[start]);
	
	while (!q.isEmpty()) {
		Vertex u = q.poll();
		if (visited[u.id]) continue;
		visited[u.id] = true;

		for (Edge e: u.edges) {
			q.remove(u);
			double alt = u.dist + e.cost;

			if (alt < graph[e.dest].dist) { 
				graph[e.dest].dist = alt; 
				graph[e.dest].prev = u.id;
			}
			q.add(graph[e.dest]);
		}
	}

	return graph[finish].dist;
}

String path (Vertex[] graph, int start, int finish) {
	
	int p = finish;

	String path = Integer.toString(Math.round(p));
	while (graph[p].prev != -1) {
		p = graph[p].prev;
		path = Math.round(p) + " " + path; 
	}
	return path;
}

/* END SOLUTION */

	// Real entry point of code
	public void begin() {
		Scanner in = new Scanner(System.in);

		int N = in.nextInt(), M = in.nextInt();

		// Get vertices
		Vertex[] vertices = new Vertex[N];
		for (int i = 0; i < N; i ++) {
			Vertex v = new Vertex();
			v.id = i;
			v.prev = -1;
			v.floor = in.nextInt();
			v.x = in.nextInt();
			v.y = in.nextInt();
			v.edges = new ArrayList<Edge>();
			v.dist = Double.MAX_VALUE;
			vertices[i] = v;
	//		System.out.println("Vertex: " + v.floor + "\t" + v.x + "\t" + v.y);
		}

		// Get edges
		// They can cost a differing amount in the backwards direction.
		for (int i = 0; i < M; i++) {
			int v1Id = in.nextInt(), v2Id = in.nextInt();
			Vertex v1 = vertices[v1Id], v2 = vertices[v2Id];
			String type = in.next();
			
			// TODO: Generate 2 edges from each data source, they will be often different.
			// Note: Distances are Euclidian distance, height between each floor is 5 units.
		
			Edge e1 = new Edge(), e2 = new Edge();
			e1.dest = v2Id; e2.dest = v1Id;
			double d = Math.sqrt(Math.pow((v1.floor - v2.floor)*5, 2) + Math.pow(v1.x - v2.x, 2) + Math.pow(v1.y-v2.y, 2));

			// Walking is euclidean distance. As is stairs.
			e1.cost = d; e2.cost = d;
			
			// Escalator: 1 unit or 3* d in wrong direction
			if (type.equals("escalator")) {
				e1.cost = 1; 
				e2.cost = d * 3;
			}

			// Lift 1 unit
			if (type.equals("lift")) {
				e1.cost = 1; e2.cost = 1;
			}
			
//			System.out.println("Cost 1: " + e1.cost + "\tCost 2: " +  e2.cost);

//			System.out.println("v, from: " + e1.dest + " to: " + e2.dest);
			v1.edges.add(e1);
			v2.edges.add(e2);
		}

		// Test cases
		int T = in.nextInt();
		for (int i = 0; i < T; i++) {
			int v1 = in.nextInt(), v2 = in.nextInt();
				
			// Djikstras on test cases.
			resetGraph(vertices);
			double length = dijkstras(vertices, v1, v2);
			String path = path(vertices, v1, v2);
			System.out.println(path);
		}
	}
}
