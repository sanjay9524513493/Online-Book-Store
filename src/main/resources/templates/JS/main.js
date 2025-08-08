// js/main.js
document.addEventListener("DOMContentLoaded", function () {
  fetch('http://localhost:8080/bookshow') // Adjust to match your backend endpoint
    .then(response => response.json())
    .then(book => {
      const list = document.getElementById("book-list");
      book.forEach(book => {
        const card = document.createElement("div");
        card.className = "book-card";
        card.innerHTML = `
          <h3>${book.title}</h3>
          <p>Author: ${book.author}</p>
          <p>Price: ₹${book.price}</p>
          <p>isbn: ${book.isbn}</p>
          <a href="book.html?isbn=${book.isbn}">View Details</a>
        `;
        list.appendChild(card);
      });
    })
    .catch(error => console.error('Error fetching products:', error));
});
