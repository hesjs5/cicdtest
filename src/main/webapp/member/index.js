let submit = document.getElementById('submitButton');
submit.onclick = showImage;

function showImage() {
    let newImage = document.getElementById('image-show').lastElementChild;
    newImage.style.visibility = 'visible';

    document.getElementById('image-upload').style.visibility = 'hidden';

    document.getElementById('fileName').textContent = null;
}

function loadFile(input) {
    let file = input.files[0];

    let name = document.getElementById('fileName');
    name.textContent = file.name;

    let newImage = document.createElement('img');
    newImage.setAttribute('class', 'img');

    newImage.src = URL.createObjectURL(file);

    newImage.style.width = "70%";
    newImage.style.height = "70%";
    newImage.style.visibility = "hidden";
    newImage.style.objectFit = "contain";

    let container = document.getElementById("image-show");
    container.appendChild(newImage);
}