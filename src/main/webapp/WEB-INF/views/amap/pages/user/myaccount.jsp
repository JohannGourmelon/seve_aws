<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<div class="body-container">
	<h1>Bienvenue chez ${amap.name}</h1>

   <form>
            <div class="mb-3">
			<label for="name" class="form-label">Nom :</label> 
			<input type="text" id="name" name="amapUser.name" class="form-control"value="${amapUser.name}"/>
				</div>
			 <div class="mb-3">
			<label for="firstname" class="form-label">Prénom :</label> 
			<input type="text" id="firstname" name="amapUser.firstname" class="form-control"value="${amapUser.firstname}"/>
			</div>
			
			 <div class="mb-3">
			<label for="email" class="form-label">Email :</label> 
			<input type="text" id="email" name="amapUser.email" class="form-control"value="${amapUser.email}"/>
			</div>
			
			<div class="mb-3">
			<label for="phone" class="form-label">Téléphone :</label> 
			<input type="text" id="phone" name="amapUser.phone" class="form-control"value="${amapUser.phone}"/>
			</div>

    <c:choose>
        <c:when test="${amapUser.type == 'INDIVIDUAL'}">
         
			
			<div class="mb-3">
				<label for="volunteer" class="form-label">Vous êtes bénévole :</label>
				<select id="volunteer" name="amapIndividualUser.volunteer" class="form-select">
					<option value="true" <c:if test="${amapIndividualUser.volunteer == true}">selected</c:if>>Oui</option>
					<option value="false" <c:if test="${amapIndividualUser.volunteer == false}">selected</c:if>>Non</option>
				</select>
			</div>
			

        </c:when>

        <c:when test="${amapUser.type == 'PRODUCER'}">
           <div class="mb-3">
			<label for="rib" class="form-label">RIB :</label> 
			<input type="text" id="rib" name="amapProducerUser.rib" class="form-control"value="${amapProducerUser.rib}"/>
			</div>
            
             <div class="mb-3">
			<label for="address" class="form-label">Adresse :</label> 
			<input type="text" id="rib" name="amapProducerUser.address" class="form-control"value="${amapProducerUser.address}"/>
			</div>
            
        </c:when>
        
           <c:when test="${amapUser.type == 'WORKS_COMITTEE'}">
            
               <div class="mb-3">
			<label for="companyName" class="form-label">Nom de l'entreprise :</label> 
			<input type="text" id="companyName" name="amaporksComitteeUser.companyName" class="form-control"value="${amapWorksComitteeUser.companyName}"/>
			</div>
			
			  <div class="mb-3">
			<label for="siret" class="form-label"> Numéro SIRET :</label> 
			<input type="text" id="siret" name="amapWorksComitteeUser.siret" class="form-control"value="${amapWorksComitteeUser.siret}"/>
			</div>
            
        </c:when>

        <c:otherwise>
            <p>Erreur : rôle inconnu. Veuillez contacter l'administrateur.</p>
        </c:otherwise>
    </c:choose>
    
    <div class="mt-4">
			<button type="submit" class="btn btn-primary">Modifier</button>
		</div>
    
</form>

</div>
