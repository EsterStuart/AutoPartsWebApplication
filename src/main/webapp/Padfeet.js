fetch('footer.html')

  .then(res => res.text())
  .then(text => {
    let oldElement = document.querySelector("script#replace_with_footer");
    let newElement = document.createElement("div");
    newElement.innerHTML = text;
    oldElement.parentNode.replaceChild(newElement,oldElement);
  })
