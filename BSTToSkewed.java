package com.greatlearning.gradedassignment3;

import java.util.Scanner;

class Node {
    int value;
    Node left;
    Node right;

    Node(int value) {
        this.value = value;
    }
}

class BST {
    private Node root;

    public Node getRoot() {
        return root;
    }

    public void insert(int val) {
        Node newNode = new Node(val);

        if (root == null) {
            root = newNode;
            return;
        }

        Node prev = null;
        Node temp = root;

        while (temp != null) {
            prev = temp;
            if (temp.value >= val)
                temp = temp.left;
            else if (temp.value < val)
                temp = temp.right;
        }

        if (prev.value >= val)
            prev.left = newNode;
        else
            prev.right = newNode;
    }

    private static Node skewedTreeRoot = null;
    private static Node skewedTreePrev = null;

    public Node getSkewedTreeRoot() {
        return skewedTreeRoot;
    }

    public void BSTToSkewedTree(Node current) {
        if (current == null)
            return;

        BSTToSkewedTree(current.left);

        Node rightNode = current.right;

        if (skewedTreeRoot == null)
            skewedTreeRoot = current;
        else
            skewedTreePrev.right = current;

        current.left = null;
        skewedTreePrev = current;

        BSTToSkewedTree(rightNode);
    }

    public void displayTreeInorder(Node current) {
        if (current != null) {
            displayTreeInorder(current.left);
            System.out.print(current.value + " ");
            displayTreeInorder(current.right);
        }
    }
}

public class BSTToSkewed {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        BST tree = new BST();

        System.out.println("Insert nodes into the BST: [Press -1 to stop insert]");
        int insertValue = 0;
        while (insertValue != -1) {
            insertValue = sc.nextInt();
            if (insertValue == -1)
                break;
            tree.insert(insertValue);
        }

        tree.BSTToSkewedTree(tree.getRoot());
        System.out.println("\nThe converted Right Skewed Tree is:");
        tree.displayTreeInorder(tree.getSkewedTreeRoot());

        sc.close();
    }
}