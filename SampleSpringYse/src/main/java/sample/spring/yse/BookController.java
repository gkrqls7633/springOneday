package sample.spring.yse;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class BookController {
	
	@Autowired
	BookService bookService;

	//������ �Է� ȭ�� ���
	@RequestMapping(value = "/create", method=RequestMethod.GET)
	public ModelAndView create() {
		return new ModelAndView("book/create");
	}
	
	//å ������ �Է� ����
	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public ModelAndView createPost(@RequestParam Map<String, Object> map) {
		ModelAndView mav = new ModelAndView();
		
		String BookId = this.bookService.create(map);
		if(BookId == null) {
			mav.setViewName("redirect:/create");
			
		}else {
			mav.setViewName("redirect:/detail?bookId=" + BookId);
		}
		
		return mav;
	}
	
	//å �� �޼ҵ�
	@RequestMapping(value="/detail", method = RequestMethod.GET)
	public ModelAndView detail(@RequestParam Map<String, Object> map) {
		Map<String, Object> detailMap = this.bookService.detail(map);
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("data", detailMap);
		String bookId = map.get("bookId").toString();
		mav.addObject("bookId", bookId);
		mav.setViewName("/book/detail");
		return mav;
	}
	
}
