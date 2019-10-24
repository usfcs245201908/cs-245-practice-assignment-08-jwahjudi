import java.lang.Comparable;
public class BST<String>
{
    class Node
    {
        Comparable data;
        Node left;
        Node right;
        public Node(Comparable item)
        {
            data = item;
            left = null;
            right = null;
        }
    }
    Node root;
    public BST()
    {
        root = null;
    }

    boolean find(Comparable item)
    {
        return find (item, root);
    }

    private boolean find (Comparable item, Node root)
    {
        if(root == null)
            return false;
        if (root.data.compareTo(item) == 0)
            return true;
        else if (root.data.compareTo(item)>0)
            return find(item, root.right);
        else
            return find(item, root.left);
    }

    void insert(Comparable item)
    {
        root = insert(root, item);
    }

    Node insert(Node root, Comparable item)
    {
        if (root == null)
            return new Node(item);
        else if (root.data.compareTo(item)>0)
            root.right = insert(root.right, item);
        else
            root.left = insert(root.left, item);
        return root;
    }

    void print()
    {
        print(root);

    }

    void print(Node root)
    {
        if (root == null)
        {
            return;
        }
        print(root.left);
        System.out.println(root.data);
        print(root.right);
    }

    void delete(Comparable item)
    {
        root = delete(root, item);
    }

    Node delete(Node root, Comparable item)
    {
        if (root == null)
            return null;
        if (root.data == item)
        {
            if (root.left == null)
                return root.right;
            else if (root.right == null)
                return root.left;
            else if (root.right.left == null)
            {
                root.data = root.right.data;
                root.right = root.right.right;
                return root;
            }
            else
                root.data = removeSmallest(root.right);
                return root;
        }
        else if(root.data.compareTo(item)>0)
        {
            root.right = delete(root.right, item);
            return root;
        }
        else
        {
            root.left = delete(root.left, item);
            return root;
        }
    }

    Comparable removeSmallest(Node root)
    {
        if (root.left.left == null)
        {
            Comparable smallest = root.left.data;
            root.left = root.left.right;
            return smallest;
        }
        removeSmallest(root.left);
        return null;
    }
}
