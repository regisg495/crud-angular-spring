import { Component } from '@angular/core';
import { Category } from '../../model/Category';
import { ActivatedRoute } from '@angular/router';
import { CategoryService } from '../../service/category.service';

@Component({
  selector: 'app-category-details',
  templateUrl: './category-details.component.html',
  styleUrl: './category-details.component.scss'
})
export class CategoryDetailsComponent {
  idCategory: number = 0;
  category: Category = new Category();

  constructor(private route: ActivatedRoute, private categoryService: CategoryService) {}

  ngOnInit(): void {
    this.idCategory = this.route.snapshot.params['idCategory'];

    this.category = new Category();
    this.categoryService.getCategoryById(this.idCategory).subscribe( data => {
      this.category = data;
    });
  }
}
