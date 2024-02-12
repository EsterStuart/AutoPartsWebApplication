fetch('nav.html')

    .then(res => res.text())
    .then(text => {
        let oldElement = document.querySelector("script#replace_with_navbar");
        let newElement = document.createElement("div");
        newElement.innerHTML = text;
        oldElement.parentNode.replaceChild(newElement,oldElement);
    })