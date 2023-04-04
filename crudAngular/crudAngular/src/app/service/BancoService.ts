import { Injectable } from '@angular/core';
import { BancoModel } from '../models/BancoModel';
import { Observable } from 'rxjs';
import { HttpClient } from '@angular/common/http';


@Injectable({
    providedIn: 'root'
})
export class BancoService {


    public banco: BancoModel[] = [];

    constructor(private httpClient: HttpClient) { }


    public salvar(banco: BancoModel): Observable<any> {
        return this.httpClient.post(`http://localhost:9999/banco/`, banco);
    }

    public get(idx: number): Observable<any> {
        return this.httpClient.get(`http://localhost:9999/banco/${idx}`);
    }

    public list(): Observable<any> {

        return this.httpClient.get("http://localhost:9999/banco/");
    }

    public delete(id: number): Observable<any> {
        return this.httpClient.delete(`http://localhost:9999/banco/${id}`);
    }

}
