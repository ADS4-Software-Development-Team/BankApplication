// Modal functionality
const modal = document.getElementById('accountModal');

// Target all buttons that should open the modal
const openAccountBtns = document.querySelectorAll('#openAccountBtn, #openAccountBtn2, #openAccountBtn3, #loginBtn');
const closeModalBtn = document.querySelector('.close-modal');

// Open modal when any "Open Account" or "Login" button is clicked
openAccountBtns.forEach(btn => {
    btn.addEventListener('click', () => {
        modal.style.display = 'block';
        document.body.style.overflow = 'hidden'; // Prevent scrolling
    });
});

// Close modal when X is clicked
closeModalBtn.addEventListener('click', () => {
    modal.style.display = 'none';
    document.body.style.overflow = 'auto'; // Re-enable scrolling
});

// Close modal when clicking outside the modal content
window.addEventListener('click', (e) => {
    if (e.target === modal) {
        modal.style.display = 'none';
        document.body.style.overflow = 'auto';
    }
});
// Redirect all "Open Account" buttons to /openAccount page
const openAccountBtns = document.querySelectorAll('#openAccountBtn, #openAccountBtn2, #openAccountBtn3');

openAccountBtns.forEach(btn => {
    btn.addEventListener('click', () => {
        window.location.href = "/openAccount";
    });
});
