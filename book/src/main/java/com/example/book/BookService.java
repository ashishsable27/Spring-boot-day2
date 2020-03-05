package com.example.book;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookService {

	@Autowired
	BookRepository bookRepository;

	public Book add(Book book) {
		System.out.println("Inside BookService Add method..");
		book = bookRepository.save(book);
		System.out.println(book);
		return book;
	}

	public List<Book> getAll() {

		return bookRepository.findAll();
	}

	public Book findById(Integer bookId) {

		return bookRepository.findById(bookId).get();
	}

	public Book update(Book book, Integer bookId) {

		Book exisitingBook = bookRepository.findById(bookId).get();
		exisitingBook.setName(book.getName());
		exisitingBook.setAuther(book.getAuther());

		return bookRepository.save(exisitingBook);
	}

	public void delete(Integer bookId) {

		bookRepository.deleteById(bookId);
	}

	public Book patch(Book book, Integer bookId) {
		Book exisitingBook = bookRepository.findById(bookId).get();
		if (book.getName() != null) {
			exisitingBook.setName(book.getName());
		}

		if (book.getAuther() != null) {
			exisitingBook.setAuther(book.getAuther());
		}
		return bookRepository.save(exisitingBook);
	}

}
