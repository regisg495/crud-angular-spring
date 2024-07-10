import { Component } from '@angular/core';
import { Category } from '../../model/Category';
import { Product } from '../../model/Product';
import { CategoryService } from '../../service/category.service';
import { ActivatedRoute, Router } from '@angular/router';
import { ProductService } from '../../service/product.service';

@Component({
  selector: 'app-product-update',
  templateUrl: './product-update.component.html',
  styleUrl: './product-update.component.scss'
})
export class ProductUpdateComponent {

  idProduct: number = 0;
  category: Category = new Category();
  product: Product = new Product();

  constructor(private categoryService: CategoryService,
    private productService: ProductService,
    private route: ActivatedRoute,
    private router: Router) { }

    ngOnInit(): void {
      this.idProduct = this.route.snapshot.params['idProduct'];
    
      this.productService.getProductById(this.idProduct).subscribe(data => {
        this.product = data;
      }, error => console.log(error));
      }

      onSubmit(){
        this.productService.updateProduct(this.idProduct, this.product).subscribe( data =>{
          this.goToProductList();
        });
      }
    
      goToProductList(){
        this.router.navigate(['/product']);
      }
}
