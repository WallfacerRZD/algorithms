package chapter3_search.implement;

import com.sun.glass.ui.SystemClipboard;

public class BST<Key extends Comparable<Key>, Val> {
    private Node root;

    private class Node {
        private Key key;
        private Val val;
        Node left, right;
        private int N;

        public Node(Key key, Val val, int N) {
            this.key = key;
            this.val = val;
            this.N = N;
        }
    }

    public int size() {
        return size(root);
    }

    public boolean contains(Key key) {
        return get(key) != null;
    }

    private int size(Node x) {
        if (x == null) {
            return 0;
        } else {
            return x.N;
        }
    }

    public Val get(Key key) {
        return get(root, key);
    }

    private Val get(Node x, Key key) {
        if (x == null) {
            return null;
        }
        int cmp = key.compareTo(x.key);
        if (cmp > 0) {
            return get(x.right, key);
        } else if (cmp < 0) {
            return get(x.left, key);
        } else {
            return x.val;
        }
    }

    public void put(Key key, Val val) {
        root = put(root, key, val);
    }

    private Node put(Node x, Key key, Val val) {
        if (x == null) {
            return new Node(key, val, 1);
        }
        int cmp = key.compareTo(x.key);
        if (cmp > 0) {
            x.right = put(x.right, key, val);
        } else if (cmp < 0) {
            x.left = put(x.left, key, val);
        } else {
            x.val = val;
        }
        x.N = size(x.left) + size(x.right) + 1;
        return x;
    }

    public Val min() {
        return min(root);
    }

    private Val min(Node x) {
        if (x.left == null) {
            return x.val;
        } else {
            return min(x.left);
        }
    }

    public Val max() {
        return max(root);
    }

    private Val max(Node x) {
        if (x.right == null) {
            return x.val;
        } else {
            return max(x.right);
        }
    }

    public Val floor(Key key) {
        Node x = floor(root, key);
        if (x != null) {
            return x.val;
        } else {
            return null;
        }
    }

    private Node floor(Node x, Key key) {
        if (x == null) {
            return null;
        }
        int cmp = key.compareTo(x.key);
        if (cmp < 0) {
            return floor(x.left, key);
        } else if (cmp == 0) {
            return x;
        } else {
            Node y = floor(x.right, key);
            if (y != null) {
                return y;
            } else {
                return x;
            }
        }

    }

    public Val ceiling(Key key) {
        Node x = ceiling(root, key);
        if (x != null) {
            return x.val;
        } else {
            return null;
        }
    }

    private Node ceiling(Node x, Key key) {
        if (x == null) {
            return null;
        }
        int cmp = key.compareTo(x.key);
        if (cmp > 0) {
            return ceiling(x.right, key);
        } else if (cmp < 0) {
            Node y = ceiling(x.left, key);
            if (y != null) {
                return y;
            } else {
                return x;
            }
        } else {
            return x;
        }
    }

    public void deleteMin() {
        root = deleteMin(root);
    }

    private Node deleteMin(Node x) {
        if (x.left == null) {
            return x.right;
        }
        x.left = deleteMin(x.left);
        x.N = size(x.left) + size(x.right) + 1;
        return x;
    }

    public static void main(String[] args) {
        BST<String, Integer> tree = new BST();
        tree.put("1", 1);
        tree.put("2", 2);
        tree.put("4", 4);
        // tree.put("6", 6);
        System.out.println(tree.get("2"));
        tree.deleteMin();
        System.out.println(tree.ceiling("1"));
        System.out.println(tree.min());
    }

}
