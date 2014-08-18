#!/usr/bin/env python

################################################
# Binary Tree
# Implementation of a simple binary tree
# Author: Samuel Jackson (slj11@aber.ac.uk)
# Date: 4/5/13
################################################

import random

data = random.sample(range(100), 10)

class TreeNode:
	def __init__(self, d, l=None, r=None):
		self.data = d
		self.left = l
		self.right = r

	def getData(self):
		return self.data

	def isLeaf(self):
		return (self.left == None and self.right == None)

	def numberOfChildren(self):
		if(self.isLeaf()):
			return 0
		elif(self.left != None and self.right != None):
			return 2
		else:
			return 1


class BinaryTree:
	def __init__(self):
		self.root = None

	def insert(self, data, cursor=None):
		if(cursor == None): cursor = self.root

		if(self.root == None):
			self.root = TreeNode(data)
		else:
			if(data <= cursor.getData()):
				if(cursor.left == None):
					cursor.left = TreeNode(data)
				else:
					self.insert(data, cursor.left)
			else:
				if(cursor.right == None):
					cursor.right = TreeNode(data)
				else:
					self.insert(data, cursor.right)

	def inOrder(self):
		self.__inOrder(self.root)

	def __inOrder(self, cursor=None):
		if(cursor == None):
			return
		else:
			self.__inOrder(cursor.left)
			print cursor.getData()
			self.__inOrder(cursor.right)


			
			


bt = BinaryTree()
for d in data:
	bt.insert(d)

print data
bt.inOrder()