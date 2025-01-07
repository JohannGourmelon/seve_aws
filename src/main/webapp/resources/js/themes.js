document.getElementById("theme1").addEventListener("click", function () {
        // Valeurs prédéfinies pour le Thème 1
        const themeValues = {
            primaryColor: "#3498db",
            secondaryColor: "#2ecc71",
            tertiaryColor: "#e74c3c",
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