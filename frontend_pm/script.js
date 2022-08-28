
var content = document.getElementById("body_content");

var url = "http://localhost:8080/produtos";

function findProducts(){

  fetch(url)
    .then(data => data.json())
    .then(dataJson => dataJson.forEach(element => {

      let newLine = document.createElement("tr");
      
      let id = document.createElement("td");
      id.innerText = `${element.id}`;
      newLine.appendChild(id);

      let name = document.createElement("td");
      name.innerText = `${element.name}`;
      newLine.appendChild(name);

      let category = document.createElement("td");
      category.innerText = `${element.category}`;
      newLine.appendChild(category);

      let price = document.createElement("td");
      price.innerText = `R$${element.price}`;
      newLine.appendChild(price);

      content.appendChild(newLine);

    })) .catch(error => {
      console.log("Erro na requisição", error)
  });
}

