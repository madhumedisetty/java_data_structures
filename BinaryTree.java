public class BinaryTree {
    // Node class representing each node in the binary tree
    class Node {
        int data;
        Node left, right;

        public Node(int item) {
            data = item;
            left = right = null;
        }
    }

    // Root of Binary Tree
    Node root;

    // Constructor
    BinaryTree() {
        root = null;
    }

    // Method to insert a new node
    void insert(int key) {
        root = insertRec(root, key);
    }

    // A recursive function to insert a new key in BST
    Node insertRec(Node root, int key) {
        // If the tree is empty, return a new node
        if (root == null) {
            root = new Node(key);
            return root;
        }

        // Otherwise, recur down the tree
        if (key < root.data)
            root.left = insertRec(root.left, key);
        else if (key > root.data)
            root.right = insertRec(root.right, key);

        // Return the (unchanged) node pointer
        return root;
    }

    // Method to do inorder traversal of tree
    void inorder() {
        inorderRec(root);
    }

    // A utility function to do inorder traversal of BST
    void inorderRec(Node root) {
        if (root != null) {
            inorderRec(root.left);
            System.out.print(root.data + " ");
            inorderRec(root.right);
        }
    }
    //method to do preorder traversal of tree
    void preorder() {
        preorderRec(root);
    }

    // A utility function to do preorder traversal of BST
    void preorderRec(Node root) {
        if (root != null) {
            System.out.print(root.data + " ");
            preorderRec(root.left);
            preorderRec(root.right);
        }
    }
    //method to do postorder traversal of tree
    void postorder() {
        postorderRec(root);
    }

    // A utility function to do postorder traversal of BST
    void postorderRec(Node root) {
        if (root != null) {
            postorderRec(root.left);
            postorderRec(root.right);
            System.out.print(root.data + " ");
        }
    }   

    // Method to search a key in BST
    boolean search(int key) {
        return searchRec(root, key);
    }

    // A recursive function to search a given key in BST
    boolean searchRec(Node root, int key) {
        // Base Cases: root is null or key is present at root
        if (root == null || root.data == key)
            return root != null;

        // Key is greater than root's key
        if (root.data < key)
            return searchRec(root.right, key);

        // Key is smaller than root's key
        return searchRec(root.left, key);
    }

    // Depth First Search (DFS) implementation
    void depthFirstSearch() {
        System.out.println("Depth First Search (Pre-order traversal):");
        dfsRec(root);
        System.out.println();
    }

    // A utility function to do DFS of BST
    void dfsRec(Node node) {
        if (node == null)
            return;

        // First print data of node
        System.out.print(node.data + " ");

        // Then recur on left subtree
        dfsRec(node.left);

        // Now recur on right subtree
        dfsRec(node.right);
    }

    //delete a node from the tree
    void delete(int key) {
        root = deleteRec(root, key);
    }

    // A recursive function to delete a node with given key in BST
    Node deleteRec(Node root, int key) {
        // Base case: if the tree is empty
        if (root == null)
            return root;

        // Otherwise, recur down the tree
        if (key < root.data)
            root.left = deleteRec(root.left, key);
        else if (key > root.data)
            root.right = deleteRec(root.right, key);

        // if key is same as root's key, then This is the node to be deleted    
        else {
            // node with only one child or no child
            if (root.left == null)
                return root.right;
            else if (root.right == null)
                return root.left;

            // node with two children: Get the inorder successor (smallest in the right subtree)
            root.data = minValue(root.right);

            // Delete the inorder successor
            root.right = deleteRec(root.right, root.data);  
        }

        return root;
    }

    int minValue(Node root) {
        int minv = root.data;
        while (root.left != null) {
            minv = root.left.data;
            root = root.left;
        }
        return minv;
    }
    
    

    // Driver Code
    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();

        /* Let's create following BST
              50
           /     \
          30      70
         /  \    /  \
        20  40  60  80 */
        tree.insert(50);
        tree.insert(30);
        tree.insert(20);
        tree.insert(40);
        tree.insert(70);
        tree.insert(60);
        tree.insert(80);

        // Print inorder traversal of the BST
        System.out.println("Inorder traversal of the binary tree:");
        tree.inorder();
        System.out.println();

        // Search for a key
        int key = 60;
        System.out.println("\nSearching for key " + key + ": " + 
                           (tree.search(key) ? "Found" : "Not Found"));

        // Perform DFS
        tree.depthFirstSearch();
    }
}