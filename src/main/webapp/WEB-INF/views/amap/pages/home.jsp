<head>
<style>

pre {
	font-family: ${amap.amapSpace.configuration.police};
            background-color: #f4f4f4;
            color: #333;
            margin: 0;
            padding: 0;
}
div {
padding: 5%;

}
</style>
</head>
<h1>Accueil</h1>


    <h2>D�tails de l'AMAP</h2>
    <p><strong>ID :</strong> ${amap.id}</p>
    <p><strong>Nom :</strong> ${amap.name}</p>
    <p><strong>Adresse :</strong> ${amap.address}</p>
    <p><strong>Num�ro Siret :</strong> ${amap.siret}</p>
    <p><strong>Logo : </strong></p>  <img src="${pageContext.request.contextPath}/configuration/logo/${amap.amapSpace.configuration.id}" alt="Logo de l'AMAP" />
    <p><strong>Texte de pr�sentation : </strong></p>
    <div><pre>${amap.amapSpace.configuration.presentationText}</pre></div>
    
