package com.example.demo.web;


import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.domain.Book;
import com.example.demo.domain.BookRepository;
import com.example.demo.domain.Category;
import com.example.demo.domain.CategoryBook;
import com.example.demo.domain.CategoryRepository;
import com.fasterxml.jackson.databind.ObjectMapper;


//1.컨트롤러 클래스인것을 알려줌
@Controller
//2.대표 URL
@RequestMapping("books")
public class BooksController {

	//question 리파지토리를 사용하겠다!
	@Autowired
	private BookRepository bookRepository;
	
	@Autowired
	private CategoryRepository categoryRepository;
	
	//private CategoryBook categoryBook;
	private List<Book> insertBookList = new ArrayList<Book>();
	
	//페이지 보기
	@GetMapping("")
	public String show(Model model) {
		
		//카테고리 저장
		Category ct	= new Category("IT");
		ct	= categoryRepository.save(ct);
		
		//Category ct2	= new Category("MATH");
		//ct2	= categoryRepository.save(ct2);
		
		//그런데 왜 책 제목은 출력이 되지 않을까요?

		//persistence context에서 카테고리 엔티티가 책 엔티티의 정보들을 가지고 있지 않기 때문입니다.

		//즉, 아직 DB에 반영되지 않은 상태이므로 책 정보들이 persistence context에 존재하지 않은 것이죠.

		//따라서 아직 DB에 저장되지 않은, persistence context에 존재하는 책의 정보들을 카테고리 엔티티가 참조할 수 있도록 수정해야 합니다. 
		
		//book.getCategory().getBooks().add(book);
		
		
		//책 저장 - 1
		Book book = new Book("jpa master", ct);
		book.getCategory().getBooks().add(book); //영속성 컨텍스트에 넣어준다.
		bookRepository.save(book);
		
		
		
		//책 저장 - 2
//		Book book2 = new Book("123 MATH BOOK", ct);
//		book2.getCategory().getBooks().add(book2);
//		bookRepository.save(book2);
//		
		
		List <Book> books = ct.getBooks();
		for (Book bookss : books) {
			System.out.println("카테고리 안의 책 이름");
			System.out.println(bookss.getTitle());
			
		}
		
//		System.out.println("================================================");
//		
//		System.out.println("====================카테고리 추가=====================");
//		Category newCategory = new Category();
//		newCategory.setName("ETC");
//		categoryRepository.save(newCategory);
//		
//		
//		
//		Book modifyBook = bookRepository.findById(1L).get();
//		modifyBook.setCategory(newCategory);
//		//modifyBook.getCategory().getBooks().add(modifyBook);
//		bookRepository.save(modifyBook);
		
		
		
//		
//		List <Book>	books= bookRepository.findAll();
//		for (Book mybook : books) {
//			System.out.println("번호:" + mybook.getNo());
//			System.out.println("카테고리:" + mybook.getCategory().getName());
//			System.out.println("책이름:" + mybook.getTitle());
//			
//			System.out.println("================================================");
//		}
		
		
		
		//제이슨 매퍼
//		ObjectMapper mapper = new ObjectMapper(); 
//		
//		String jsonList=""; 
//		
//		try { 
//			
//			jsonList = mapper.writeValueAsString(books);
//			
//		} catch (IOException e) {
//			
//			e.printStackTrace();
//			
//			}
//		System.out.println(jsonList);
//		
		System.out.println("================================================");
		
		model.addAttribute("books", books);
		
		
		return "book/list";
	}
	
	
		//수정
		@PostMapping("/change")
		public String change( CategoryBook cb, Model model) {
			System.out.println("책 수정 컨트롤러 진입");
			
			
			System.out.println(cb.getCategoryno());
			System.out.println(cb.getCategoryname());
			System.out.println(cb.getNo());
			System.out.println(cb.getTitle());
			
			
			
			
			//카테고리 수정
			Category oneCategory = categoryRepository.findById(cb.getCategoryno()).get();
			oneCategory.update(cb.getCategoryname());
			categoryRepository.save(oneCategory);
			
			//책수정
			Book oneBook = bookRepository.findById(cb.getNo()).get();
			oneBook.update(cb.getTitle() , oneCategory);
			bookRepository.save(oneBook); 					//기존에 있으면 업데이트 , 없으면 추가
			
			
			
			
			List <Book>	books= bookRepository.findAll();
			
			System.out.println("=================수정된 도서 목록======================");
			for (Book mybook : books) {
				System.out.println("카테고리 번호:" + mybook.getCategory().getNo());
				System.out.println("카테고리:" + mybook.getCategory().getName());
				System.out.println("번호:" + mybook.getNo());
				System.out.println("책이름:" + mybook.getTitle());
				
				System.out.println("================================================");
			}
			
			model.addAttribute("books", books);
			return "book/list";
		}
	
		//TEST
		@GetMapping("/test")
		public String test(Model model) {
			
			
			List <Book>	books= bookRepository.findAll();
			model.addAttribute("books", books);
			
			
			return "book/list";
		}
		
	
}
