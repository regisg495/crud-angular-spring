import { Product } from "./Product";

export class Category {
    idCategory:number = 0;
    nameCategory:string = "";
    detailsCategory:string = "";
    dateUpdateCategory:Date = new Date();
    products:Array<Product> = [];
}