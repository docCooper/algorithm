package graph.read_graph;

/**
 * Create By 曹通
 * 2018/8/9 19:06
 */
public class Test {
    // 分别对两个文件构建稀疏图和稠密图
    public static void main(String[] args) {
        String filename = "D:\\eclipseSpace\\algorithm\\src\\main\\java\\graph\\read_graph\\testG1.txt";
        Graph g1 = new DenseGraph(13,false);
        ReadGraph readGraph1 = new ReadGraph(g1,filename);
        Path path = new Path(g1,0);
        path.showPath(6);
//        g1.show();
//        System.out.println("=============================");
//        Graph g2 = new DenseGraph(13,false);
//        ReadGraph readGraph2 = new ReadGraph(g2, filename);
//        g2.show();
//        Components components = new Components(g1);
//        System.out.println("TestG2.txt, Component Count: " + components.getAccount());
    }
}
