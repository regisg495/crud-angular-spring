import { Component } from '@angular/core';
import { Category } from '../../model/Category';
import { Product } from '../../model/Product';
import { ActivatedRoute } from '@angular/router';
import { CategoryService } from '../../service/category.service';
import { ProductService } from '../../service/product.service';

@Component({
  selector: 'app-product-details',
  templateUrl: './product-details.component.html',
  styleUrl: './product-details.component.scss'
})
export class ProductDetailsComponent {
  idProduct: number = 0;
  category: Category = new Category();
  product: Product = new Product();

  constructor(private route: ActivatedRoute, private categoryService: CategoryService, private productService: ProductService) {}

  ngOnInit(): void {
    this.idProduct = this.route.snapshot.params['idProduct'];

    this.productService.getProductById(this.idProduct).subscribe( data => {
      this.product = data;
    });
  }
}
