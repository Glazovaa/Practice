package book;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class BookController {

    @Autowired
    BookStorage storage;

    @GetMapping(value = "/book")
    public String BookForm(Model model) {
        model.addAttribute("div", storage.isEmpty());
        model.addAttribute("books", storage.get());
        return "book";
    }

    @GetMapping("/book/addBook")
    public String BookAdd(Model model) {
        model.addAttribute("book", new Book(0,"","",0));
        return "addBook";
    }

    @PostMapping("/book/addBook")
    public String BookAdd(@ModelAttribute Book books, Model model) {
        model.addAttribute("book", books);
        storage.add(books.getName(), books.getAuthor(), books.getAge());
        return "addBook";
    }

    @RequestMapping("/book/deleteBook")
    public String BookDelete(@RequestParam(value = "ID", required = false, defaultValue = "0") int ID, Model model) {
        model.addAttribute("books", storage.get());
        storage.removeID(ID);
        return "deleteBook";
    }
}
