package org.cap.bim.controller;


import java.util.List;

import org.cap.bim.model.Category;
import org.cap.bim.service.CategoryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/category")
@RestController
public class CategoryController {
	@Autowired 
	private CategoryImpl categoryService;
	
	@PostMapping("/post")
	public ResponseEntity<String> addCategory(@RequestBody Category category){
		categoryService.saveCategory(category);
		return new ResponseEntity<String>("category added successfully",HttpStatus.OK);
	}
	
	
	@GetMapping("/categories")
    public ResponseEntity <List<Category>> getAllCategory() {
        List<Category> category = categoryService.getAllCategory();

        if (category != null) {
            return new ResponseEntity<>(category, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
	
	@PutMapping("/update/description/{catId}")
	public ResponseEntity<String> updateCategory(@RequestBody Category updateCategory,@PathVariable("catId") int catId){
		Category category =categoryService.updateCatDescription(catId,updateCategory);
		if(category!=null) {
			
			return ResponseEntity.status(HttpStatus.OK).body("Category Updated successfully");
		}
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Cannot update Category");
		
	}
	
	 @GetMapping("/{id}")
	    public ResponseEntity<Category> getCategoryById(@PathVariable int id) {
	        Category category = categoryService.getCategoryWithId(id);

	        if (category != null) {
	            return new ResponseEntity<>(category, HttpStatus.OK);
	        } else {
	            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	        }
	    }
	
	

}
