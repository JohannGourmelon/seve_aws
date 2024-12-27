<div class="secondary-nav">
    <ul>
        <li><a href="${pageContext.request.contextPath}/amap/info">Votre AMAP</a></li>
        
        <!-- Menu Configuration avec sous-menus -->
        <li class="dropdown">
            <a href="javascript:void(0)" class="dropbtn" onclick="toggleSubMenu()">Configuration</a>
            <ul class="dropdown-content">
                <li class="mt-2"><a href="${pageContext.request.contextPath}/configuration/design">> design</a></li>
                <li><a href="${pageContext.request.contextPath}/configuration/contenu">> contenu</a></li>
            </ul>
        </li>
        
        <!-- "Gestion des amaps" -->
        <li class="mt-5"><a href="${pageContext.request.contextPath}/amap">Gestion des amaps</a></li>
    </ul>
</div>
