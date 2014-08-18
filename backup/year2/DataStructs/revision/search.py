#!/usr/bin/env python

################################################
# Search.py
# Assorted searches for revision
# Author: Samuel Jackson (slj11@aber.ac.uk)
# Date: 10/5/13
################################################

import random

#generate some random data
sample = random.sample(range(100), 10)

#generic swap function
def swap(data, a, b):
	temp = data[a]
	data[a] = data[b]
	data[b] = temp
	return data

##################################################################
# In-place implementation of Quicksort
##################################################################

def findPivot(data, left, right):
	centre = ((right-left)/2) + left
	return centre

def partition(data, left, right, pivotIndex):
	pivot = data[pivotIndex]
	data = swap(data, pivotIndex, right)
	storeIndex = left

	for i in range(left, right):
		if(data[i] <= pivot):
			data = swap(data, i, storeIndex)
			storeIndex = storeIndex + 1

	data = swap(data, storeIndex, right)
	return storeIndex

def quicksort(data, left, right):
	if left < right:
		pivotIndex = findPivot(data, left, right)
		pivotIndex = partition(data, left, right, pivotIndex)
		data = quicksort(data, left, pivotIndex-1)
		data = quicksort(data, pivotIndex+1, right)

	return data

data = sample
print quicksort(data, 0, len(data)-1)

##################################################################
# Bubble sort
##################################################################

def bubblesort(data):
	for i in range(len(data)):
		for j in range(len(data)-1):
			if (data[j] > data[j+1]):
				data = swap(data, j, j+1)

	return data

data = sample
print bubblesort(data)

##################################################################
# Shaker sort
##################################################################

def shakersort(data):
	swapped = True
	while swapped:
		swapped = False

		for i in range(0, len(data)-2):
			if (data[i] > data[i+1]):
				data = swap(data, i, j)
				swapped = True

		if not swapped: break
		swapped = False

		for i in range(len(data)-2, 0):
			if(data[i] > data[i+1]):
				data = swap(data, i, j)
				swapped = True

	return data

data = sample
print shakersort(data)

##################################################################
# Selection sort
##################################################################

def selectionsort(data):
	for i in range(len(data)-1):
		minIndex = i

		for j in range(i+1, len(data)):
			if(data[j] < data[minIndex]):
				minIndex = j

		if(minIndex != i):
			data = swap(data, minIndex, i)

	return data

data = sample
print selectionsort(data)

##################################################################
# Insertion sort
##################################################################

def insertionsort(data):
	for i in range(1, len(data)):
		valToInsert = data[i]
		holeIndex = i

		while holeIndex > 0 and valToInsert < data[holeIndex-1]:
			data[holeIndex] = data[holeIndex-1]
			holeIndex = holeIndex - 1

		data[holeIndex] = valToInsert

	return data

data = sample
print insertionsort(data)

##################################################################
#  Shell sort
##################################################################
