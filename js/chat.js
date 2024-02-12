$(document).ready(function() {
    $('#exampleFormControlInput2').keypress(function(event) {
        if (event.which == 13) { // перевірка, чи натиснута клавіша Enter
            sendMessage();
        }
    });

    $('.fas.fa-paper-plane').click(function() {
        sendMessage();
    });
});

function sendMessage() {
    var message = $('#exampleFormControlInput2').val().trim(); // отримання тексту з поля введення та видалення зайвих пробілів
    if (message !== '') { // перевірка, чи не порожній рядок
        addMessageToChat(message); // додавання повідомлення до чату
        $('#exampleFormControlInput2').val(''); // очищення поля введення
    }
}

function addMessageToChat(message) {
    var currentTime = new Date().toLocaleTimeString(); // отримання поточного часу
    var currentDate = new Date().toLocaleDateString(); // отримання поточної дати
    var messageHTML = `
        <div class="d-flex flex-row justify-content-end">
            <div>
                <p class="small p-2 me-3 mb-1 text-white rounded-3 bg-dark">${message}</p>
                <p class="small me-3 mb-0 text-muted">${currentTime} - ${currentDate}</p>
            </div>
            <img src="https://mdbcdn.b-cdn.net/img/Photos/new-templates/bootstrap-chat/ava1-bg.webp" alt="avatar 1" style="width: 45px; height: 100%;">
        </div>
    `;
    $('.overflow-scroll').append(messageHTML); // додавання повідомлення до чату
}
