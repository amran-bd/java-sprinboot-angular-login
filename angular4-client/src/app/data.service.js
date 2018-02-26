"use strict";
var __decorate = (this && this.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
Object.defineProperty(exports, "__esModule", { value: true });
var core_1 = require("@angular/core");
var http_1 = require("@angular/http");
require("rxjs/add/operator/toPromise");
var DataService = /** @class */ (function () {
    function DataService(http) {
        this.http = http;
        this.userUrl = 'app.module.user'; // URL to web API
        this.headers = new http_1.Headers({ 'Content-Type': 'application/json' });
    }
    // Get all users
    DataService.prototype.getUsers = function () {
        return this.http.get(this.userUrl)
            .toPromise()
            .then(function (response) { return response.json(); })
            .catch(this.handleError);
    };
    DataService.prototype.getUserByLastName = function (lastName) {
        var url = 'findbylastname/${lastName}';
        return this.http.get(url)
            .toPromise()
            .then(function (response) { return response.json(); })
            .catch(this.handleError);
    };
    DataService.prototype.create = function (user) {
        return this.http
            .post("postcustomer", JSON.stringify(user), { headers: this.headers })
            .toPromise()
            .then(function (res) { return res.json(); })
            .catch(this.handleError);
    };
    DataService.prototype.delete = function (id) {
        var url = '${this.userUrl}/${id}';
        return this.http.delete(url, { headers: this.headers })
            .toPromise()
            .then(function () { return null; })
            .catch(this.handleError);
    };
    DataService.prototype.handleError = function (error) {
        console.error('Error', error); // for demo purposes only
        return Promise.reject(error.message || error);
    };
    DataService = __decorate([
        core_1.Injectable()
    ], DataService);
    return DataService;
}());
exports.DataService = DataService;
