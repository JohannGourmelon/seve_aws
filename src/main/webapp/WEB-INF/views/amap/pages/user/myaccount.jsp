<%-- <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> --%>
<%-- <%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %> --%>
<%-- <%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %> --%>

<!-- <div class="body-container"> -->
<!-- 	<h1>Vos informations personnelles</h1> -->

<!--    <form> -->
<!--             <div class="mb-3"> -->
<%-- 			<label for="name" class="form-label">Nom :</label> ${amapUser.name} --%>
			
<!-- 				</div> -->
<!-- 			 <div class="mb-3"> -->
<%-- 			<label for="firstname" class="form-label">Prénom :</label> ${amapUser.firstname} --%>
<!-- 						</div> -->
			
<!-- 			 <div class="mb-3"> -->
<%-- 			<label for="email" class="form-label">Email :</label> ${amapUser.email} --%>
<!-- 			</div> -->
			
<!-- 			<div class="mb-3"> -->
<%-- 			<label for="phone" class="form-label">Téléphone :</label> ${amapUser.phone} --%>
<!-- 			</div> -->

<%--     <c:choose> --%>
<%--         <c:when test="${amapUser.type == 'INDIVIDUAL'}"> --%>
         
			
<!-- 			<div class="mb-3"> -->
<!-- 				<label for="volunteer" class="form-label">Vous êtes bénévole :</label> -->
<%-- 					<option value="true" <c:if test="${amapUser.individualUser.volunteer == true}"></c:if>>Oui</option> --%>
<%-- 					<option value="false" <c:if test="${amapUser.individualUse == false}"></c:if>>Non</option> --%>
				
<!-- 			</div> -->
			

<%--         </c:when> --%>

<%--         <c:when test="${amapUser.type == 'PRODUCER'}"> --%>
<!--            <div class="mb-3"> -->
<%-- 			<label for="rib" class="form-label">RIB :</label> ${amapUser.producerUser.rib} --%>
			
<!-- 			</div> -->
            
<!--              <div class="mb-3"> -->
<%-- 			<label for="address" class="form-label">Adresse :</label> ${amapUser.producerUser.address} --%>
		
<!-- 			</div> -->
            
<%--         </c:when> --%>
        
<%--            <c:when test="${amapUser.type == 'WORKS_COMITTEE'}"> --%>
            
<!--                <div class="mb-3"> -->
<%-- 			<label for="companyName" class="form-label">Nom de l'entreprise :</label> ${amapUser.worksComitteeUser.companyName} --%>
		
<!-- 			</div> -->
			
<!-- 			  <div class="mb-3"> -->
<%-- 			<label for="siret" class="form-label"> Numéro SIRET :</label> ${amapUser.worksComitteeUser.siret} --%>
		
<!-- 			</div> -->
            
<%--         </c:when> --%>
       

<%--         <c:otherwise> --%>
<!--             <p>Erreur : rôle inconnu. Veuillez contacter l'administrateur.</p> -->
<%--         </c:otherwise> --%>
<%--     </c:choose> --%>
    
<!--     <div class="mt-4"> -->
<!-- 			<button type="submit" class="btn btn-primary">Modifier</button> -->
<!-- 		</div> -->
    
<!-- </form> -->

<!-- </div> -->


<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<div class="container mt-5 d-flex justify-content-center">
    <div class="card shadow p-3 mb-5 bg-body rounded-3" style="width: 80%; background-color: #ffffff; box-shadow: 0 8px 20px rgba(0, 0, 0, 0.2);">
        <h2 class="text-center fw-bold mb-4">Vos informations personnelles</h2>

        <div class="mb-4 d-flex ">
            <label class="fw-bold">Nom :</label>
            <span>${amapUser.name}</span>
        </div>

        <div class="mb-4 d-flex ">
            <label class="fw-bold">Prénom :</label>
            <span>${amapUser.firstname}</span>
        </div>

        <div class="mb-4 d-flex ">
            <label class="fw-bold">Email :</label>
            <span>${amapUser.email}</span>
        </div>

        <div class="mb-4 d-flex ">
            <label class="fw-bold">Téléphone :</label>
            <span>${amapUser.phone}</span>
        </div>

        <c:choose>
            <c:when test="${amapUser.type == 'INDIVIDUAL'}">
                <div class="mb-4 d-flex ">
                    <label class="fw-bold">Vous êtes bénévole :</label>
                    <span>
                        <c:choose>
                            <c:when test="${amapUser.individualUser.volunteer == true}">Oui</c:when>
                            <c:otherwise>Non</c:otherwise>
                        </c:choose>
                    </span>
                </div>
            </c:when>

            <c:when test="${amapUser.type == 'PRODUCER'}">
                <div class="mb-4 d-flex ">
                    <label class="fw-bold">RIB :</label>
                    <span>${amapUser.producerUser.rib}</span>
                </div>
                <div class="mb-4 d-flex ">
                    <label class="fw-bold">Adresse :</label>
                    <span>${amapUser.producerUser.address}</span>
                </div>
            </c:when>

            <c:when test="${amapUser.type == 'WORKS_COMITTEE'}">
                <div class="mb-4 d-flex ">
                    <label class="fw-bold">Nom de l'entreprise :</label>
                    <span>${amapUser.worksComitteeUser.companyName}</span>
                </div>
                <div class="mb-4 d-flex ">
                    <label class="fw-bold">Numéro SIRET :</label>
                    <span>${amapUser.worksComitteeUser.siret}</span>
                </div>
            </c:when>

            <c:otherwise>
                <div class="text-danger">
                    Erreur : rôle inconnu. Veuillez contacter l'administrateur.
                </div>
            </c:otherwise>
        </c:choose>
<div class="mt-5 text-center">
            <a href="modifier-url" class="btn btn-primary px-5 py-2 rounded-pill shadow">Modifier</a>
        </div>
      
    </div>
    
</div>


  
