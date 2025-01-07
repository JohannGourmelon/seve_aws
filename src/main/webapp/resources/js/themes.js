document.getElementById("theme1").addEventListener("click", function () {
        // Valeurs prédéfinies pour le Thème 1
        const themeValues = {
            primaryColor: "#87CEEB",
            secondaryColor: "#ABD6D6",
            tertiaryColor: "#F8F9FA",
            police: "LATO",
            isRoundedBorders: false
        };

        // Applique les valeurs prédéfinies
        document.getElementById("primaryColor").value = themeValues.primaryColor;
        document.getElementById("secondaryColor").value = themeValues.secondaryColor;
        document.getElementById("tertiaryColor").value = themeValues.tertiaryColor;

        const policeSelect = document.getElementById("police");
        for (let i = 0; i < policeSelect.options.length; i++) {
            if (policeSelect.options[i].value === themeValues.police) {
                policeSelect.selectedIndex = i;
                break;
            }
        }

        const roundedYesRadio = document.getElementById("roundedYes");
        const roundedNoRadio = document.getElementById("roundedNo");
        if (themeValues.isRoundedBorders) {
            roundedYesRadio.checked = true;
        } else {
            roundedNoRadio.checked = true;
        }
    });
	
	document.getElementById("theme2").addEventListener("click", function () {
	        // Valeurs prédéfinies pour le Thème 2
	        const themeValues = {
	            primaryColor: "#D6B4E7",
	            secondaryColor: "#D1D1D1",
	            tertiaryColor: "#FAFAFA",
	            police: "CALIBRI",
	            isRoundedBorders: true
	        };

	        // Applique les valeurs prédéfinies
	        document.getElementById("primaryColor").value = themeValues.primaryColor;
	        document.getElementById("secondaryColor").value = themeValues.secondaryColor;
	        document.getElementById("tertiaryColor").value = themeValues.tertiaryColor;

	        const policeSelect = document.getElementById("police");
	        for (let i = 0; i < policeSelect.options.length; i++) {
	            if (policeSelect.options[i].value === themeValues.police) {
	                policeSelect.selectedIndex = i;
	                break;
	            }
	        }

	        const roundedYesRadio = document.getElementById("roundedYes");
	        const roundedNoRadio = document.getElementById("roundedNo");
	        if (themeValues.isRoundedBorders) {
	            roundedYesRadio.checked = true;
	        } else {
	            roundedNoRadio.checked = true;
	        }
	    });
		
		document.getElementById("theme3").addEventListener("click", function () {
		        // Valeurs prédéfinies pour le Thème 3
		        const themeValues = {
		            primaryColor: "#A8D5BA",
		            secondaryColor: "#F7D9C4",
		            tertiaryColor: "#FFF9F2",
		            police: "GARAMOND",
		            isRoundedBorders: true
		        };

		        // Applique les valeurs prédéfinies
		        document.getElementById("primaryColor").value = themeValues.primaryColor;
		        document.getElementById("secondaryColor").value = themeValues.secondaryColor;
		        document.getElementById("tertiaryColor").value = themeValues.tertiaryColor;

		        const policeSelect = document.getElementById("police");
		        for (let i = 0; i < policeSelect.options.length; i++) {
		            if (policeSelect.options[i].value === themeValues.police) {
		                policeSelect.selectedIndex = i;
		                break;
		            }
		        }

		        const roundedYesRadio = document.getElementById("roundedYes");
		        const roundedNoRadio = document.getElementById("roundedNo");
		        if (themeValues.isRoundedBorders) {
		            roundedYesRadio.checked = true;
		        } else {
		            roundedNoRadio.checked = true;
		        }
		    });