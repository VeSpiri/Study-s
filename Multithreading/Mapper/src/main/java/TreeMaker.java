import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.RecursiveAction;

public class TreeMaker extends RecursiveAction {
    private List<String> visited = new ArrayList<>();
    private volatile String indent;
    private String root;
    private volatile StringBuilder builder = new StringBuilder();

    public TreeMaker(String root, String indent) {
        this.root = root;
        this.indent = indent;
    }

    public TreeMaker(String root, List<String> visited, String indent, StringBuilder stringBuilder) {
        this.visited = visited;
        this.root = root;
        this.indent = indent;
        this.builder = stringBuilder;
    }

    @Override
    protected void compute() {
        Parser parser = new Parser(root);
        visited.add(root);
        builder.append(indent).append(root).append("\n");
        for (String url : parser.getUrls()) {
            if (!visited.contains(url) && url.contains(Main.url)) {
                visited.add(url);
                builder.append(indent).append("\t").append(url).append("\n");
                TreeMaker maker = new TreeMaker(url, visited, indent + "\t", builder);
                maker.invoke();
            }
        }
    }

    public StringBuilder getBuilder() {
        return builder;
    }
}
