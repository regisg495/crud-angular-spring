import { Component } from '@angular/core';
import { Category } from '../../model/Category';
import { CategoryService } from '../../service/category.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-category-list',
  templateUrl: './category-list.component.html',
  styleUrl: './category-list.component.scss'
})
export class CategoryListComponent {

  categories: Category[] = [];

  constructor(private categoryService: CategoryService,
    private router: Router) { }

  ngOnInit(): void {
    this.getCategories();
  }

  private getCategories(){
    this.categoryService.getCategoryList().subscribe(data => {
      this.categories = data;
    });
  }

  createCategory() {
    this.router.navigate(['category/create']);
  }

  categoryDetails(id: number){
    this.router.navigate(['category-details', id]);
  }

  updateCategory(id: number){
    this.router.navigate(['category-update', id]);
  }

  deleteCategory(id: number){
    this.categoryService.deleteCategory(id).subscribe( data => {
      console.log(data);
      this.getCategories();
    })
  }

}
