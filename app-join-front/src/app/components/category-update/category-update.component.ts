import { Component } from '@angular/core';
import { Category } from '../../model/Category';
import { CategoryService } from '../../service/category.service';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-category-update',
  templateUrl: './category-update.component.html',
  styleUrl: './category-update.component.scss'
})
export class CategoryUpdateComponent {

  idCategory: number = 0;
  category: Category = new Category();

  constructor(private categoryService: CategoryService,
    private route: ActivatedRoute,
    private router: Router) { }

  ngOnInit(): void {
    this.idCategory = this.route.snapshot.params['idCategory'];
  
    this.categoryService.getCategoryById(this.idCategory).subscribe(data => {
      this.category = data;
    }, error => console.log(error));
    }

    onSubmit(){
      this.categoryService.updateCategory(this.idCategory, this.category).subscribe( data =>{
        this.goToCategoryList();
      }
      , error => console.log(error));
    }
  
    goToCategoryList(){
      this.router.navigate(['/category']);
    }
}
