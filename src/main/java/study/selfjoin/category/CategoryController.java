package study.selfjoin.category;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class CategoryController {

    private final CategoryRepository categoryRepository;

    public CategoryController(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @ResponseBody
    @GetMapping("/get")
    public String findCategories() {
        List<Category> categories = categoryRepository.findAll();
        for (Category c : categories) {
            System.out.println("c.getParentId() = " + c.getParentId());
            System.out.println("c.getParent() = " + c.getParent());
        }
        return "got";
    }

    @ResponseBody
    @GetMapping("/create")
    public String addCategories() {
        Category parent = Category.builder()
                .id("1")
                .level(1)
                .sequence(1)
                .name("parent")
                .build();
        categoryRepository.save(parent);

        Category child = Category.builder()
                .id("2")
                .level(2)
                .sequence(1)
                .name("child")
                .parentId(parent.getId())
                .build();
        categoryRepository.save(child);

        return "created";
    }
}
