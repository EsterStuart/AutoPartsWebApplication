fetch('footer.html')


  .then(res => res.text())
  .then(text => {
    let oldElement = document.querySelector("script#add_the_feet");
    let newElement = document.createElement("div");
    newElement.innerHTML = text;
    oldElement.parentNode.replaceChild(newElement,oldElement);
  })
