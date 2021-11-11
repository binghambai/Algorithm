package main

import (
	b "MyAlgorithm_go/BinaryTree"
	"fmt"
)
func main() {
	//tree := &b.BinaryTree{
	//	Val:   1,
	//	Left:  &b.BinaryTree{Val:2, Left:nil, Right: &b.BinaryTree{Val:3}},
	//	Right: &b.BinaryTree{Val:2, Left:&b.BinaryTree{Val:3}, Right:&b.BinaryTree{Val:4}},
	//}
	pre := []int{1,2,3,2,3,4}
	inOrder := []int{2,3, 1, 2, 3, 4}
	tree := build(pre, inOrder)
	//binaryTree := build(pre, inOrder)
	preOrder(tree)
	fmt.Println(res)


}
var res []int
/**
	前序遍历
 */
func preOrder(tree *b.BinaryTree) {
	if tree != nil {
		res = append(res, tree.Val)
		preOrder(tree.Left)
		preOrder(tree.Right)
	}
}
/**
	中序遍历
 */
func inOrder(tree *b.BinaryTree) {
	if tree != nil {
		preOrder(tree.Left)
		res = append(res, tree.Val)
		preOrder(tree.Right)
	}
}

/**
	已知中后序，构建二叉树
 */
func build(pre []int, inOrder []int) *b.BinaryTree {
	if len(pre) == 0 {
		return nil
	}
	v := inOrder[0]
	root := &b.BinaryTree{Val:v, Left:nil, Right:nil}
	i:=0
	for ; i < len(inOrder);i++ {
		if inOrder[i] == v {
			break
		}
	}
	root.Left = build(pre[1:len(inOrder[:i]) + 1], inOrder[:i])
	root.Right = build(pre[len(inOrder[:i]) + 1:], inOrder[i+1:])
	return root
}
