import { Component } from '@angular/core';
import { Product } from '../../model/Product';
import { ProductService } from '../../service/product.service';
import { Router } from '@angular/router';


@Component({
  selector: 'app-product-create',
  templateUrl: './product-create.component.html',
  styleUrl: './product-create.component.scss'
})
export class ProductCreateComponent {
  product: Product = new Product();

  constructor(private productService: ProductService,
    private router: Router) { }

  ngOnInit(): void {
    }

    createProduct() {
      this.productService.createProduct(this.product).subscribe( data => {
        console.log(data);
        this.goToCategoryList();
      },
      error => console.log(error));
    }

    goToCategoryList(){
      this.router.navigate(['/product']);
    }

    onSubmit(){
      this.createProduct();
    }

}
