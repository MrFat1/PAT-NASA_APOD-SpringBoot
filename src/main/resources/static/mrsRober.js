const form = document.querySelector("#submit"); //Get Form

form.addEventListener('submit', function (event) {

    event.preventDefault(); //Cancel event

    const fecha = form.elements['fecha'];
    let date = fecha.value;

    const camera = form.elements['select'];
    let cam = camera.value;

    //Lo que vamos a enviar al server con el POST (Con estos datos se creará el objeto IMGGallery.java)
    const data = {earth_date: date, camera: cam};

    var postOptions = {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(data)
    };

    urlspringBoot = "/mrsRober";

    fetch(urlspringBoot, postOptions)
        .then(response =>
            response.json())
        .then(result => {

            console.log(result);

            addToGallery(result);

        })
            
        .catch(error => 
            console.log('error', error));

});

async function addToGallery({photos}) {

    if (photos.length == 0) {
        alert("No hay fotos disponibles para esa fecha o esa cámara.");
    } else {

        for (let i = 0; i<photos.length; i++) { //hacerlo mejor con innerHTML

            var div = document.createElement("div")
            div.classList.add("col-md-4");

            var div2 = document.createElement("div");
            div2.classList.add("thumbnail");

            var divcaption = document.createElement("div");
            divcaption.classList.add("caption");

            var br = document.createElement("br");
            var br2 = document.createElement("br");

            var p = document.createElement("p");
            p.appendChild(document.createTextNode("Cámara: " + photos[i].camera.full_name));
            p.appendChild(br);
            p.appendChild(document.createTextNode("Fecha: " + photos[i].earth_date));
            p.appendChild(br2);
            p.appendChild(document.createTextNode("ID: " + photos[i].id));

            var a = document.createElement("a");
            var img = document.createElement("img");

            divcaption.appendChild(p);

            a.href = photos[i].img_src;
            img.src = photos[i].img_src;

            a.appendChild(img);
            a.appendChild(divcaption);
            div2.appendChild(a);
            div.appendChild(div2);
            document.getElementById("galeria").appendChild(div);
        }

    }

}

form.addEventListener("reset", function(event){ //clear

    event.preventDefault();

    var maindiv = document.getElementById("galeria");

    maindiv.innerHTML = "";

});