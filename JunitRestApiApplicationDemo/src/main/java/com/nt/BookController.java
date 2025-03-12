package com.nt;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/book")
public class BookController {

	@Autowired
	BookRepository bookRepository;

	@GetMapping
	public List<Book> getAllBooks()
	{
		return bookRepository.findAll();
	}

	@GetMapping(value = "{bookId}")
	public Book getBookById(@PathVariable Long bookId)
	{	
		return bookRepository.findById(bookId).get();
	}

	@PostMapping
	public Book createBookRecords(@RequestBody Book book)
	{
		return bookRepository.save(book);
	}

	@PutMapping()
	public Book updateBookRecord(@RequestBody Book bookRecord)
	{
		if(bookRecord==null || bookRecord.getBookId()==null)
		{
			throw new IllegalArgumentException("Book Id should not be null");
		}
		Optional<Book> optionalBook=bookRepository.findById(bookRecord.getBookId());
		if(!optionalBook.isPresent())
		{
			throw new IllegalArgumentException("Book is not present");
		}
		Book existingBookRecord = optionalBook.get();
		existingBookRecord.setName(bookRecord.getName());
		existingBookRecord.setSummary(bookRecord.getSummary());
		existingBookRecord.setRating(bookRecord.getRating());
		return bookRepository.save(existingBookRecord);
	}

	@DeleteMapping(value = "{bookId}")
	public void deleteBookById(@PathVariable Long bookId)
	{
		if(bookRepository.findById(bookId).isPresent())
		{
			bookRepository.deleteById(bookId);
		}
	}
}
