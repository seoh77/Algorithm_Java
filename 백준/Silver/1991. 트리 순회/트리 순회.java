import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static class Node {
		char value;
		Node left;
		Node right;
		
		Node(char value) {
			this.value = value;
		}
	}
	
	static Node[] tree;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		tree = new Node [n+1];
		
		for(int i=0; i<n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			char parent = st.nextToken().charAt(0);
			char left = st.nextToken().charAt(0);
			char right = st.nextToken().charAt(0);
			
			if(tree[parent - 'A'] == null) {
				tree[parent - 'A'] = new Node(parent);
			}
			
			if(left != '.') {
				tree[left - 'A'] = new Node(left);
				tree[parent - 'A'].left = tree[left - 'A'];
			}
			
			if(right != '.') {
				tree[right - 'A'] = new Node(right);
				tree[parent - 'A'].right = tree[right - 'A'];
			}
		}
		
		preorder(tree[0]);
		System.out.println();
		
		inorder(tree[0]);
		System.out.println();
		
		postorder(tree[0]);
		System.out.println();
	}
	
	/**
	 * 전위 순회
	 */
	public static void preorder(Node node) {
		if(node == null) {
			return;
		}
		
		System.out.print(node.value);
		preorder(node.left);
		preorder(node.right);
	}
	
	/**
	 * 중위 순회
	 */
	public static void inorder(Node node) {
		if(node == null) {
			return;
		}
		
		inorder(node.left);
		System.out.print(node.value);
		inorder(node.right);
	}
	
	/**
	 * 후위 순회
	 */
	public static void postorder(Node node) {
		if(node == null) {
			return;
		}
		
		postorder(node.left);
		postorder(node.right);
		System.out.print(node.value);
	}
}
