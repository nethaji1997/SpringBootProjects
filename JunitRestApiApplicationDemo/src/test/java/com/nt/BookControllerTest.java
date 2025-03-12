package com.nt;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.Matchers.hasSize; // Add this import
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;

@ExtendWith(MockitoExtension.class)
public class BookControllerTest {

	private MockMvc mockMvc;

	// To convert Json to String
	ObjectMapper objectMapper = new ObjectMapper();
	ObjectWriter objectWriter = objectMapper.writer();

	@Mock
	private BookRepository bookRepository;

	@InjectMocks
	private BookController bookController;

	Book record_1 = new Book(1L, "Atomic habits", "How to build habits", 5);
	Book record_2 = new Book(2L, "Pysch of Money", "How to create Money", 4);
	Book record_3 = new Book(3L, "Rich Dad poor Dad", "Think Wisely", 3);

	@BeforeEach
	public void setUp() {
		this.mockMvc = MockMvcBuilders.standaloneSetup(bookController).build();
	}

	@Test
	public void getAllRecordsSuccess() throws Exception {
		List<Book> records = List.of(record_1, record_2, record_3);
		Mockito.when(bookRepository.findAll()).thenReturn(records);

		mockMvc.perform(MockMvcRequestBuilders
				.get("/book")
				.contentType(MediaType.APPLICATION_JSON))
		.andExpect(status().isOk())
		.andExpect(MockMvcResultMatchers.jsonPath("$", hasSize(3)))
		.andExpect(jsonPath("$[2].name", is("Rich Dad poor Dad")));
	}

	@Test
	public void getBookByIdSuccess() throws Exception
	{
		Mockito.when(bookRepository.findById(record_1.getBookId())).thenReturn(java.util.Optional.of(record_1));

		mockMvc.perform(MockMvcRequestBuilders
				.get("/book/1")
				.contentType(MediaType.APPLICATION_JSON))
		.andExpect(status().isOk())
		.andExpect(MockMvcResultMatchers.jsonPath("$", notNullValue()))
		.andExpect(jsonPath("$.name", is("Atomic habits")));

	}

	@Test
	public void createRecordSuccess() throws Exception
	{
		Book record=Book.builder()
				.bookId(4l)
				.name("Intro to java")
				.summary("The name but longer")
				.rating(5)
				.build();

		Mockito.when(bookRepository.save(record)).thenReturn(record);

		//To send the request in the form of String
		String content=objectWriter.writeValueAsString(record);

		MockHttpServletRequestBuilder mockRequest=MockMvcRequestBuilders.post("/book")
				.contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON)
				.content(content);

		mockMvc.perform(mockRequest)
		.andExpect(status().isOk())
		.andExpect(jsonPath("$", notNullValue()))
		.andExpect(jsonPath("$.name", is("Intro to java")));
	}

	@Test
	public void updateBookRecordSuccess() throws Exception
	{
		Book updatedRecord=Book.builder()
				.bookId(1L)
				.name("Updated book name")
				.summary("Updated summary")
				.rating(1).build();

		Mockito.when(bookRepository.findById(record_1.getBookId())).thenReturn(java.util.Optional.ofNullable(record_1));
		Mockito.when(bookRepository.save(updatedRecord)).thenReturn(updatedRecord);

		String updatedContent=objectWriter.writeValueAsString(updatedRecord);

		MockHttpServletRequestBuilder mockRequest=MockMvcRequestBuilders.put("/book")
				.contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON)
				.content(updatedContent);

		mockMvc.perform(mockRequest)
		.andExpect(status().isOk())
		.andExpect(jsonPath("$", notNullValue()))
		.andExpect(jsonPath("$.name", is("Updated book name")));
	}

	@Test
	public void deleteBookByIdSuccess() throws Exception
	{
		Mockito.when(bookRepository.findById(record_2.getBookId())).thenReturn(Optional.of(record_2));

		mockMvc.perform(MockMvcRequestBuilders
				.delete("/book/2")
				.contentType(MediaType.APPLICATION_JSON))
		.andExpect(status().isOk());			
	}

}