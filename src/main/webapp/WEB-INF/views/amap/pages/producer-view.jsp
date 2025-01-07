<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

    <div class="container-fluid">
        <h1 class="text-center">Gestion des produits</h1>
        <div class="text-end mb-2">
            <a href="${pageContext.request.contextPath}/${slug}/product/add" class="btn btn-success">Ajouter un produit</a>
        </div>
        <table class="table table-bordered table-striped table-hover mb-5">
            <thead>
                <tr>
                    <th class="d-none">ID</th>
                    <th class="col-1">Nom</th>
                    <th class="col-1">Prix</th>
                    <th class="col-1">Stock</th>
                    <th class="col-1">Catégorie</th>
                    <th class="col-1">Date de disponibilité</th>
                    <th class="col-1">Date limite d'achat</th>
                    <th class="col-1">Date de création</th>
                    <th class="col-1">Dernière modification</th>
                    <th class="col-2">Actions</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="product" items="${products}">
                    <tr>
                        <td class="d-none">${product.id}</td>
                        <td>${product.name}</td>
                        <td>${product.price} €</td>
                        <td>${product.stock}</td>
                        <td>${product.category.displayName}</td>
                        <td>${product.formattedAvailableDate}</td>
                        <td>${product.formattedPurchaseDeadlineDate}</td>
                        <td>${product.formattedCreationDate}</td>
                        <td>${product.formattedLastModifiedDate}</td>
                        <td>
                            <div class="btn-container">
                                <a href="${pageContext.request.contextPath}/${slug}/product/${product.id}" class="btn btn-info btn-sm btn-link">Détails</a>
                                <a href="${pageContext.request.contextPath}/${slug}/product/edit/${product.id}" class="btn btn-warning btn-sm btn-link">Modifier</a>
                                <a href="${pageContext.request.contextPath}/${slug}/product/delete/${product.id}" class="btn btn-danger btn-sm btn-link" onclick="return confirm('Êtes-vous sûr de vouloir supprimer ce produit ?')">Supprimer</a>
                            </div>
                        </td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </div>