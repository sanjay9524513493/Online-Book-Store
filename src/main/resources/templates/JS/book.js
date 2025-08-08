// js/product.js
document.addEventListener("DOMContentLoaded", function () {
  const urlParams = new URLSearchParams(window.location.search);
  const isbn = urlParams.get('isbn');
  console.log(isbn);

  fetch(`http://localhost:8080/isbn/${isbn}`)
    .then(res => res.json())
    .then(book => {
		console.log("Full book object:", book);
		console.log(book.title);
      const container = document.getElementById("book-container");
      
      container.innerHTML = `
        <div class="book-card">
          <h2>${book.title}</h2>
          <p>${book.category}</p>
          <p>Price: ₹${book.price}</p>
          <button onclick="addToCart(${book.isbn})">Add to Cart</button>
        </div>
      `;
    })
    .catch(error => console.error("Error loading product:", error));
});

function addToCart(bookisbn) {
  // Simulating cart functionality with localStorage
  let cart = JSON.parse(localStorage.getItem("cart")) || [];
  cart.push(bookisbn);
  localStorage.setItem("cart", JSON.stringify(cart));
  alert("Product added to cart!");
}
