package graph.read_graph;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;

/**
 * 所有的图都经由这个类创建
 * Create By 曹通
 * 2018/8/9 17:02
 */
public class ReadGraph {
    private Scanner scanner;

    public ReadGraph(Graph graph, String filename) {
        readFile(filename);
        try {
            // 读出来的第一个数为顶点数
            int V = scanner.nextInt();
            if(V<0)
                throw new IllegalArgumentException("number V must greater than 0");
            int E = scanner.nextInt();
            if (E<0)
                throw new IllegalArgumentException("number E must greater than 0");
            for (int i = 0; i < E; i++) {
                // 一行行的添加边
                int v = scanner.nextInt();
                int w = scanner.nextInt();
                assert v >= 0 && v < V;
                assert w >= 0 && w < V;
                graph.addEdge(v, w);
            }
        }catch (InputMismatchException e){
            String next = scanner.next();
            throw new InputMismatchException("预期输入类型为整型,本次输入为："+next);
        }catch (NoSuchElementException e){
            throw new NoSuchElementException("输入为空");
        }

    }

    private void readFile(String filename) {
        assert filename != null;
        try {
            File file = new File(filename);
            if (file.exists()) {
                FileInputStream fileInputStream = new FileInputStream(file);
                scanner = new Scanner(new BufferedInputStream(fileInputStream));
            } else
                throw new IllegalArgumentException(filename + " doesn't exist.");
        } catch (IOException e) {
            throw new IllegalArgumentException("Could not open " + filename, e);
        }
    }
}
