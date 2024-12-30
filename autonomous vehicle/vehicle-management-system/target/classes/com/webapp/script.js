document.addEventListener("DOMContentLoaded", function() {
    const form = document.getElementById("loginForm");
    const usernameInput = document.getElementById("username");
    const passwordInput = document.getElementById("password");
    const usernameError = document.getElementById("usernameError");
    const passwordError = document.getElementById("passwordError");

    // Validation function for login form
    function validateForm(event) {
        let isValid = true;

        // Reset previous error messages
        usernameError.style.display = "none";
        passwordError.style.display = "none";

        // Validate username
        if (usernameInput.value.trim() === "") {
            usernameError.style.display = "block";
            usernameInput.classList.add("is-invalid");
            isValid = false;
        } else {
            usernameInput.classList.remove("is-invalid");
        }

        // Validate password
        if (passwordInput.value.trim() === "") {
            passwordError.style.display = "block";
            passwordInput.classList.add("is-invalid");
            isValid = false;
        } else {
            passwordInput.classList.remove("is-invalid");
        }

        // If form is invalid, prevent submission
        if (!isValid) {
            event.preventDefault();
        } else {
            alert("Form is valid! Submitting...");
        }
    }

    // Add event listener for form submission
    form.addEventListener("submit", validateForm);
});
