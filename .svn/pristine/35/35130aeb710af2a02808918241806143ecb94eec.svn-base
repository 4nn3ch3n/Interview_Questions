package com.fdmgroup.interviewquestions.daos;

import java.util.List;

import com.fdmgroup.interviewquestions.exceptions.IQStorageException;

public interface Storage<T, I> 
{
	void create(T item) throws IQStorageException;

	void update(T item) throws IQStorageException;

	T read(I id) throws IQStorageException;

	List<T> readAll() throws IQStorageException;

	void delete(T item) throws IQStorageException;
}
