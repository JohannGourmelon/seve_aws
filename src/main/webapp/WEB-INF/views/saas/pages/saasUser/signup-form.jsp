<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

	<div class="container">
		<div class="col-md-offset-2 col-md-7">

			<div class="panel panel-info">
				<div class="panel-heading">
					<div class="panel-title">Sign Up</div>
				</div>
				<div class="panel-body">
					<form:form action="saveSignUpForm" cssClass="form-horizontal"
						method="post" modelAttribute="saasUser">

						<div class="form-group">
							<label for="firstname" class="col-md-3 control-label">Prénom</label>
							<div class="col-md-9">
								<form:input path="firstname" cssClass="form-control" />
							</div>
						</div>
						<div class="form-group">
							<label for="name" class="col-md-3 control-label">Nom</label>
							<div class="col-md-9">
								<form:input path="name" cssClass="form-control" />
							</div>
						</div>
						
						<div class="form-group">
							<label for="phone" class="col-md-3 control-label">Téléphone</label>
							<div class="col-md-9">
								<form:input path="phone" cssClass="form-control" />
							</div>
						</div>
						
						<div class="form-group">
							<label for="email" class="col-md-3 control-label">Email</label>
							<div class="col-md-9">
								<form:input path="email" cssClass="form-control" />
							</div>
						</div>

						<div class="form-group">
							<label for="password" class="col-md-3 control-label">Mot de Passe</label>
							<div class="col-md-9">
								<form:password path="password" cssClass="form-control" />
							</div>
						</div>
						
						

						<div class="form-group">
							<!-- Button -->
							<div class="col-md-offset-3 col-md-9">
								<form:button cssClass="btn btn-primary" >Submit</form:button>
							</div>
						</div>

					</form:form>
				</div>
			</div>
		</div>
	</div>
