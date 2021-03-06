package chapter3_search.implement;

import com.sun.glass.ui.SystemClipboard;

public class RedBlackBST<Key extends Comparable<Key>, Val> {
    private Node root;
    private static final boolean RED = true;
    private static final boolean BLACK = false;

    private class Node {
        private Key key;
        private Val val;
        Node left, right;
        boolean color;
        private int N;

        public Node(Key key, Val val, int N, boolean color) {
            this.key = key;
            this.val = val;
            this.N = N;
            this.color = color;
        }
    }

    private boolean isRed(Node x) {
        if (x == null) {
            return false;
        }
        return x.color == RED;
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

    private Node rotateLeft(Node x) {
        Node temp = x.right;
        x.right = temp.left;
        temp.left = x;
        temp.color = x.color;
        x.color = RED;
        temp.N = x.N;
        x.N = size(x.left) + size(x.right) + 1;
        return temp;
    }

    private Node rotateRight(Node x) {
        Node temp = x.left;
        x.left = temp.right;
        temp.right = x;
        temp.color = x.color;
        x.color = RED;
        temp.N = x.N;
        x.N = size(x.left) + size(x.right) + 1;
        return temp;
    }

    private void flipColors(Node x) {
        x.left.color = BLACK;
        x.right.color = BLACK;
        x.color = RED;
    }

    private Node put(Node x, Key key, Val val) {
        if (x == null) {
            return new Node(key, val, 1, RED);
        }
        int cmp = key.compareTo(x.key);
        if (cmp > 0) {
            x.right = put(x.right, key, val);
        } else if (cmp < 0) {
            x.left = put(x.left, key, val);
        } else {
            x.val = val;
        }
        if (isRed(x.right) && !isRed(x.left)) {
            x = rotateLeft(x);
        }
        if (isRed(x.left) && isRed(x.left.left)) {
            x = rotateRight(x);
        }
        if (isRed(x.left) && isRed(x.right)) {
            flipColors(x);
        }
        x.N = size(x.left) + size(x.right) + 1;
        return x;
    }

    public Val min() {
        Node x = min(root);
        if (x != null) {
            return x.val;
        } else {
            return null;
        }
    }

    private Node min(Node x) {
        if (x == null) {
            return null;
        }
        if (x.left == null) {
            return x;
        } else {
            return min(x.left);
        }

    }

    public Val max() {
        Node x = max(root);
        if (x != null) {
            return x.val;
        } else {
            return null;
        }
//        no recursive
//        Node x = root;
//        while(x.right != null){
//            x = x.right;
//        }
//        return x.val;
    }

    private Node max(Node x) {
        if (x == null) {
            return null;
        } else if (x.right == null) {
            return x;
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

    public void delete(Key key) {
        root = delete(root, key);
    }

    private Node delete(Node x, Key key) {
        if (x == null) {
            return null;
        } else {
            int cmp = key.compareTo(x.key);
            if (cmp > 0) {
                x.right = delete(x.right, key);
            } else if (cmp < 0) {
                x.left = delete(x.left, key);
            } else {
                if (x.right == null) {
                    return x.left;
                } else if (x.left == null) {
                    return x.right;
                } else {
                    Node t = x;
                    x = min(t.right);
                    x.right = deleteMin(t.right);
                    x.left = t.left;
                }
            }
            x.N = size(x.left) + size(x.right) + 1;
            return x;
        }
    }

    public void print() {
        print(root);
    }

    private void print(Node x) {
        if (x == null) {
            return;
        }
        print(x.left);
        System.out.print(x.key + ",");
        print(x.right);
    }

    public static void main(String[] args) {
        RedBlackBST<String, Integer> tree = new RedBlackBST<>();
        tree.put("1", 1);
        tree.put("2", 2);
        tree.put("3", 3);
        tree.put("4", 4);
        tree.put("5", 5);
        tree.put("6", 6);
        tree.put("7", 7);
        // tree.put("6", 6);
        System.out.println(tree.get("2"));
        tree.delete("6");
        System.out.println(tree.ceiling("1"));
        System.out.println(tree.min());
        System.out.println(tree.max());
        tree.print();
    }

}
