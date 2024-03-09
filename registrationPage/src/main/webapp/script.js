document.getElementById("loginForm").addEventListener("post", function(event) {
    // Prevent the form from submitting
    event.preventDefault();
    
    // Reset the form fields
    document.getElementById("loginForm").reset();
});