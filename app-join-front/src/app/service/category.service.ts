import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Category } from '../model/Category';

@Injectable({
  providedIn: 'root'
})
export class CategoryService {

  private url:string = 'http://localhost:8080/category';
  private urlCreate:String = "create";
  private urlDelete:String = "delete";
  private urlEdit:String = "edit";

  constructor(private httpClient: HttpClient) { }

  getCategoryList(): Observable<Category[]>{
    return this.httpClient.get<Category[]>(`${this.url}`);
  }

  createCategory(category: Category): Observable<Object>{
    return this.httpClient.post(`${this.url}/${this.urlCreate}`, category);
  }

  getCategoryById(id: number): Observable<Category>{
    return this.httpClient.get<Category>(`${this.url}/${id}`);
  }

  updateCategory(id: number, category: Category): Observable<Object>{
    return this.httpClient.put(`${this.url}/${this.urlEdit}/${id}`, category);
  }

  deleteCategory(id: number): Observable<Object>{
    return this.httpClient.delete(`${this.url}/${this.urlDelete}/${id}`);
  }

}
