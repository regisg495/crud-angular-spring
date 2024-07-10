import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Product } from '../model/Product';
import { Observable } from 'rxjs';
import { CategoryService } from './category.service';

@Injectable({
  providedIn: 'root'
})
export class ProductService {

  private url:string = 'http://localhost:8080/product';
  private urlCreate:String = "create";
  private urlDelete:String = "delete";
  private urlEdit:String = "edit";

  constructor(private httpClient: HttpClient) { }

  getProductList(): Observable<Product[]>{
    return this.httpClient.get<Product[]>(`${this.url}`);
  }

  createProduct(product: Product): Observable<Object>{
    return this.httpClient.post(`${this.url}/${this.urlCreate}`, product);
  }

  getProductById(id: number): Observable<Product>{
    return this.httpClient.get<Product>(`${this.url}/${id}`);
  }

  updateProduct(id: number, product: Product): Observable<Object>{
    return this.httpClient.put(`${this.url}/${this.urlEdit}/${id}`, product);
  }

  deleteProduct(id: number): Observable<Object>{
    return this.httpClient.delete(`${this.url}/${this.urlDelete}/${id}`);
  }
}
