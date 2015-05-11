<!doctype html>
<html>
<head>
    <script src="http://cdn.bootcss.com/angular.js/1.3.15/angular.js"></script>


</head>

<body >
<div data-ng-app>
    单价： <input type="number" min=0 ng-model="price" ng-init="price = 299">
    <br>
    数量： <input type="number" min=0 ng-model="quantity" ng-init="quantity = 1">
    <br>
    总价： {{ quantity * price }}


    <div>{{ 9999 | number }}</div>
    <div>{{ 9999+1 | number:2 }}</div>
    <div>{{ 9*9 | currency }}</div>
    <div>{{ 'Hello World' | uppercase }}</div>
</div>


</body>
</html>