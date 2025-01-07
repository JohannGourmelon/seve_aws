<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<div class="container-fluid mt-5">
    <h1 class="text-center mb-4">Découvrez nos ateliers</h1>

    <div class="row">
        <c:forEach var="activity" items="${activities}">
            <div class="col-12 col-sm-6 col-md-6 col-lg-3 mt-4 mb-5">
                <div class="card">
                    <img
						src="${pageContext.request.contextPath}/${slug}/activity/image/${activity.id}"
						alt="Aperçu de l'image" class="img-thumbnail mb-3">
                    <p class="card-title text-center">${activity.name}</p>
               
                    <div class="card-body">
                        <p class="card-text mb-4">${activity.description}</p>
                        <div class="row">
                            <div class="col-12 col-md-6">
                           
                                <p class="card-text delivery-text"> Le ${activity.formattedDate} de ${activity.formattedStartTime} - ${activity.formattedEndTime}</p>
                            </div>
                            <div class="col-12 col-md-6 d-flex justify-content-end align-items-center">
								<span class="badge p-2 text-white">
						            ${activity.place}
						        </span>                            
							</div>
                        </div>
                        <div class="row d-flex justify-content-center align-items-center mt-4">
    						<p class="card-text text-center font-weight-bold">${activity.price} € </p>
						</div>
						<form action="${pageContext.request.contextPath}/${slug}/cart/add/activity"
							method="post" class="text-center mt-3">
							<input type="hidden" name="activityId" value="${activity.id}" />
								<input type="hidden" name="genre" value="ACTIVITY" />
							<button type="submit" class="btn btn-warning btn-sm">Commander</button>
						</form>
						
						

                    </div>
                </div>
            </div>
        </c:forEach>
    </div>
</div>
