import { Category } from "./Category";

export class Product {
    idProduct:number = 0;
    nameProduct:string = "";
    detailsProduct:string = "";
    priceProduct:number = 0;
    dateUpdateproduct:Date = new Date();
    idCategory:number = 0;
    category:Category = new Category();
}