$(document).ready(function() {
    $('.card').on('click', '.post_button', function() {
        let card = $(this).closest('.card');
        let index = card.index();
        let commentInput = card.find('.comment_input');
        let commentBlock = card.find('.comment_block_' + index);
        let commentText = commentInput.val().trim();
        let commentAvatar = "https://mdbcdn.b-cdn.net/img/Photos/new-templates/bootstrap-chat/ava3.webp";
        let commentName = "New User";
        if (commentText !== '') {
            addComment(commentBlock, commentAvatar, commentName, commentText);
            clearTextarea(commentInput);
        }
    });
});



function changeButtonBold(btn) {
    btn.click(function() {
        if ($(this).hasClass('fa-regular')) {
            $(this).removeClass('fa-regular').addClass('fa-solid');
        } else {
            $(this).removeClass('fa-solid').addClass('fa-regular');
        }
    });
}

function clearTextarea(textarea) {
    textarea.val(''); // Очистити текстове поле
}

function addComment(commentBlock, commentAvatar, commentName, commentText) {
    let commentHTML = `
    <div class="d-flex flex-start mb-4">
        <img class="rounded-circle shadow-1-strong me-3" src="${commentAvatar}" alt="avatar" width="65" height="65" />
        <div>
            <div>
                <div class="d-flex justify-content-between align-items-center">
                    <p class="mb-1">
                        ${commentName} <span class="small">- 2 hours ago</span>
                    </p>
                </div>
                <p class="small mb-0">
                    ${commentText}
                </p>
            </div>
        </div>
    </div>
    `;
    commentBlock.append(commentHTML);
}

