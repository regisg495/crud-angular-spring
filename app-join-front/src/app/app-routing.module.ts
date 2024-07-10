import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { CategoryListComponent } from './components/category-list/category-list.component';
import { CategoryCreateComponent } from './components/category-create/category-create.component';
import { CategoryDetailsComponent } from './components/category-details/category-details.component';
import { CategoryUpdateComponent } from './components/category-update/category-update.component';
import { ProductListComponent } from './components/product-list/product-list.component';
import { ProductCreateComponent } from './components/product-create/product-create.component';
import { ProductDetailsComponent } from './components/product-details/product-details.component';
import { ProductUpdateComponent } from './components/product-update/product-update.component';

const routes: Routes = [
  {path: 'category/create', component: CategoryCreateComponent },
  {path: 'category', component: CategoryListComponent},
  {path: 'category-details/:idCategory', component: CategoryDetailsComponent},
  {path: 'category-update/:idCategory', component: CategoryUpdateComponent},
  {path: 'product', component: ProductListComponent},
  {path: 'product/create', component: ProductCreateComponent},
  {path: 'product-details/:idProduct', component: ProductDetailsComponent},
  {path: 'product-update/:idProduct', component: ProductUpdateComponent}
  
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
