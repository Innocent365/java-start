package java8Feature;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class demo {

    private static String parentId;
    private static int nodeCount;

    private static List<Node> data;
    static {
        data = new ArrayList<>();

        //一级
        data.add(new Node("1", "深圳市", ""));

        //二级
        data.add(new Node("11","罗湖","1"));
        data.add(new Node("12","南山","1"));
        data.add(new Node("13","福田","1"));

        //三级
        data.add(new Node("111","笋岗街道","11"));
        data.add(new Node("111","布吉街道","11"));

        data.add(new Node("121","西丽街道","12"));
        data.add(new Node("122","蛇口街道","12"));

        //四级
        data.add(new Node("1211","松坪山社区","121"));
        data.add(new Node("1212","留仙社区","121"));
    }

    public static void main(String[] args) {
        for (Node node: data){
            //System.out.println(getNewNode(node));
        }
        for (Node node: data){
            NodeWithCount temp = getNewNode(node);
            if(temp.getCount()==0){
                System.out.println(temp);
            }
        }
    }

    public static NodeWithCount getNewNode(Node node){
        int count = 0;
        NodeWithCount newNode = new NodeWithCount(node,count);
        for(Node item: data){
            if(item.getParentId().equals(node.getId())){
                count += 1;
                node.getChildren().add(item);
            }
        }
        newNode.setCount(count);
        return newNode;
    }

}


class NodeWithCount{
    private Node node;
    private int count;

    public NodeWithCount(Node node, int count) {
        this.node = node;
        this.count = count;
    }

    public Node getNode() {
        return node;
    }

    public void setNode(Node node) {
        this.node = node;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    @Override
    public String toString() {

        StringBuffer sf = new StringBuffer();
        for (Node item: this.node.getChildren()){
            sf.append(item.toString());
            sf.append(",");
        }

        return "{ id:" + node.getId()+
                ", name:" + node.getName() +
                ", count:" + count +
                ", children: [" + sf + "]" +
                '}';
    }
}

class Node{
    private String id;
    private String name;
    private String parentId;

    private List<Node> children = new ArrayList<>();

    public Node(String id, String name, String parentId) {
        this.id = id;
        this.name = name;
        this.parentId = parentId;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
    }

    public List<Node> getChildren() {
        return children;
    }

    public void setChildren(List<Node> children) {
        this.children = children;
    }

    @Override
    public String toString() {
        return "{" +
                "id:'" + id + '\'' +
                ", name:'" + name + '\'' +
                '}';
    }
}