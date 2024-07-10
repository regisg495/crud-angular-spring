import { Component } from '@angular/core';
import { Category } from '../../model/Category';
import { CategoryService } from '../../service/category.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-category-create',
  templateUrl: './category-create.component.html',
  styleUrl: './category-create.component.scss'
})
export class CategoryCreateComponent {
    category: Category = new Category();

    constructor(private categoryService: CategoryService,
      private router: Router) { }
  
    ngOnInit(): void {
      }

    createCategory(){
      this.categoryService.createCategory(this.category).subscribe( data => {
        console.log(data);
        this.goToCategoryList();
      },
      error => console.log(error));
    }

    goToCategoryList(){
      this.router.navigate(['/category']);
    }

    onSubmit(){
      this.createCategory();
    }

}
