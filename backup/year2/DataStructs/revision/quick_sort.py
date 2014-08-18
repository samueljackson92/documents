#!/usr/bin/env python

################################################
# Quick Sort
# Implementation of a quick sort algorithm
# Author: Samuel Jackson (slj11@aber.ac.uk)
# Date: 4/5/13
################################################

import random

data = random.sample(range(100), 100)

def quicksort(data):
	if(len(data) < 2):
		return data

	pivot = data.pop(len(data)/2)
	less = []
	greater = []

	for n in data:
		if n <= pivot:
			less.append(n)
		else:
			greater.append(n)

	return quicksort(less) + [pivot] + quicksort(greater)


data = quicksort(data)



def binarySearch(d, data):
	val = data[len(data)/2]
	if(d == val):
		return val
	elif(d < val):
		return binarySearch(d, data[:len(data)/2])
	elif(d > val):
		return binarySearch(d, data[len(data)/2:])

print binarySearch(20, data)