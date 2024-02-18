let username;
let currPage = 1;
const tweetButton = document.querySelector(".tweet-btn")
const postInput = document.querySelector(".post-input")
const postsSection = document.querySelector(".posts");
const floatingTweetBtn = document.querySelector(".floating-tweet-box-icon");
const profileIcon = document.querySelector(".profile-icon");
const messageField = document.querySelector(".messages-field")
const postSectionWrapper = document.querySelector(".section-wrapper");
const chatSection = document.querySelector(".chat-section")
const chatProfiles = document.querySelector(".chat-profiles")

tweetButton.addEventListener("click", (event) => {
      event.preventDefault();
      console.log("Its clicked");
      ifSomething() && createPost();
})


function createPostElement(postDetails) {
  const postDiv = document.createElement('div');
  postDiv.className = 'post';

  const leftPostBoxDiv = document.createElement('div');
  leftPostBoxDiv.className = 'left-post-box';

  const profileImg = document.createElement('img');
  profileImg.src = postDetails.profileImgSrc;
  profileImg.alt = 'profile picture';
  leftPostBoxDiv.appendChild(profileImg);

  const rightPostBoxDiv = document.createElement('div');
  rightPostBoxDiv.className = 'right-post-box';

  const postTitleDiv = document.createElement('div');
  postTitleDiv.className = 'post-title';

  const userName = document.createElement('h3');
  userName.textContent = postDetails.name;
  const userHandle = document.createElement('h3');
  userHandle.className = 'user-name';
  userHandle.textContent = postDetails.username;

  // Append h3 elements to post title div
  postTitleDiv.appendChild(userName);
  postTitleDiv.appendChild(userHandle);

  // Create post content div
  const postContentDiv = document.createElement('div');
  postContentDiv.className = 'post-content';

  // Create h3 element for post text
  const postText = document.createElement('h3');
  postText.className = 'post-text';
  postText.textContent = postDetails.caption
  postContentDiv.appendChild(postText);

  if(postDetails.fileType){
    const videoElement = document.createElement(postDetails.fileType)
    videoElement.src = postDetails.fileSrc;
    videoElement.controls = true;
    videoElement.autoplay = true;
    videoElement.muted = true;
    videoElement.width = 320;
    videoElement.height = 240;
    videoElement.style.width = '100%';
    videoElement.style.height = '400px';

    postContentDiv.appendChild(videoElement);
  }


  const postIconsDiv = document.createElement('div');
  postIconsDiv.className = 'post-icons';

  const infoIconsDiv = document.createElement('div');
  infoIconsDiv.className = 'info-icons';

  infoIconsDiv.innerHTML = `<svg viewBox="0 0 24 24" aria-hidden="true">
  <path
    d="M1.751 10c0-4.42 3.584-8 8.005-8h4.366c4.49 0 8.129 3.64 8.129 8.13 0 2.96-1.607 5.68-4.196 7.11l-8.054 4.46v-3.69h-.067c-4.49.1-8.183-3.51-8.183-8.01zm8.005-6c-3.317 0-6.005 2.69-6.005 6 0 3.37 2.77 6.08 6.138 6.01l.351-.01h1.761v2.3l5.087-2.81c1.951-1.08 3.163-3.13 3.163-5.36 0-3.39-2.744-6.13-6.129-6.13H9.756z"
  ></path>
</svg>
<svg viewBox="0 0 24 24" aria-hidden="true">
  <path
    d="M4.5 3.88l4.432 4.14-1.364 1.46L5.5 7.55V16c0 1.1.896 2 2 2H13v2H7.5c-2.209 0-4-1.79-4-4V7.55L1.432 9.48.068 8.02 4.5 3.88zM16.5 6H11V4h5.5c2.209 0 4 1.79 4 4v8.45l2.068-1.93 1.364 1.46-4.432 4.14-4.432-4.14 1.364-1.46 2.068 1.93V8c0-1.1-.896-2-2-2z"
  ></path>
</svg>
<div>
<svg viewBox="0 0 24 24" aria-hidden="true" class="like-post">
  <path
    d="M16.697 5.5c-1.222-.06-2.679.51-3.89 2.16l-.805 1.09-.806-1.09C9.984 6.01 8.526 5.44 7.304 5.5c-1.243.07-2.349.78-2.91 1.91-.552 1.12-.633 2.78.479 4.82 1.074 1.97 3.257 4.27 7.129 6.61 3.87-2.34 6.052-4.64 7.126-6.61 1.111-2.04 1.03-3.7.477-4.82-.561-1.13-1.666-1.84-2.908-1.91zm4.187 7.69c-1.351 2.48-4.001 5.12-8.379 7.67l-.503.3-.504-.3c-4.379-2.55-7.029-5.19-8.382-7.67-1.36-2.5-1.41-4.86-.514-6.67.887-1.79 2.647-2.91 4.601-3.01 1.651-.09 3.368.56 4.798 2.01 1.429-1.45 3.146-2.1 4.796-2.01 1.954.1 3.714 1.22 4.601 3.01.896 1.81.846 4.17-.514 6.67z"
  ></path>
</svg>
<h1 class="likes-count"></h1>
</div>
<svg viewBox="0 0 24 24" aria-hidden="true">
  <path
    d="M8.75 21V3h2v18h-2zM18 21V8.5h2V21h-2zM4 21l.004-10h2L6 21H4zm9.248 0v-7h2v7h-2z"
  ></path>
</svg>
<svg
  viewBox="0 0 24 24"
  aria-hidden="true"
>
  <path
    d="M4 4.5C4 3.12 5.119 2 6.5 2h11C18.881 2 20 3.12 20 4.5v18.44l-8-5.71-8 5.71V4.5zM6.5 4c-.276 0-.5.22-.5.5v14.56l6-4.29 6 4.29V4.5c0-.28-.224-.5-.5-.5h-11z"
  ></path>
</svg>`

  const likesDiv = document.createElement('div');
  const likesCount = document.createElement('h1');
  likesCount.className = 'likes-count';
  likesDiv.appendChild(likesCount);

  postIconsDiv.appendChild(infoIconsDiv);
  postIconsDiv.appendChild(likesDiv);

  const downloadIconDiv = document.createElement('div');
  downloadIconDiv.className = 'download-icon';

  downloadIconDiv.innerHTML = `<svg viewBox="0 0 24 24" aria-hidden="true">
  <path
    d="M12 2.59l5.7 5.7-1.41 1.42L13 6.41V16h-2V6.41l-3.3 3.3-1.41-1.42L12 2.59zM21 15l-.02 3.51c0 1.38-1.12 2.49-2.5 2.49H5.5C4.11 21 3 19.88 3 18.5V15h2v3.5c0 .28.22.5.5.5h12.98c.28 0 .5-.22.5-.5L19 15h2z"
  ></path>
</svg>`

  postIconsDiv.appendChild(downloadIconDiv);

  rightPostBoxDiv.appendChild(postTitleDiv);
  rightPostBoxDiv.appendChild(postContentDiv);
  rightPostBoxDiv.appendChild(postIconsDiv);

  postDiv.appendChild(leftPostBoxDiv);
  postDiv.appendChild(rightPostBoxDiv);

  return postDiv;
}


const createPost = (postData, flag=true) => {
      const postHtml = createPostElement(postData || {caption: postInput.value})

    postInput.value = "";
    flag && postsSection.insertAdjacentElement('afterbegin', postHtml);
    !flag && postsSection.insertAdjacentElement("beforeend", postHtml);

    postsSection.style.display = "block";

    let likeIcon = document.querySelector(".like-post");

    likeIcon.addEventListener("click", () => {

      calculateLikeCount(likeIcon);

      if (likeIcon.classList.contains('unlike-post')){
            likeIcon.innerHTML = `<path
                  d="M16.697 5.5c-1.222-.06-2.679.51-3.89 2.16l-.805 1.09-.806-1.09C9.984 6.01 8.526 5.44 7.304 5.5c-1.243.07-2.349.78-2.91 1.91-.552 1.12-.633 2.78.479 4.82 1.074 1.97 3.257 4.27 7.129 6.61 3.87-2.34 6.052-4.64 7.126-6.61 1.111-2.04 1.03-3.7.477-4.82-.561-1.13-1.666-1.84-2.908-1.91zm4.187 7.69c-1.351 2.48-4.001 5.12-8.379 7.67l-.503.3-.504-.3c-4.379-2.55-7.029-5.19-8.382-7.67-1.36-2.5-1.41-4.86-.514-6.67.887-1.79 2.647-2.91 4.601-3.01 1.651-.09 3.368.56 4.798 2.01 1.429-1.45 3.146-2.1 4.796-2.01 1.954.1 3.714 1.22 4.601 3.01.896 1.81.846 4.17-.514 6.67z"
            ></path>`;
            likeIcon.classList.remove("unlike-post")
            likeIcon.classList.add("like-post");
      }
      else{
            likeIcon.innerHTML = `<path
                  d="M20.884 13.19c-1.351 2.48-4.001 5.12-8.379 7.67l-.503.3-.504-.3c-4.379-2.55-7.029-5.19-8.382-7.67-1.36-2.5-1.41-4.86-.514-6.67.887-1.79 2.647-2.91 4.601-3.01 1.651-.09 3.368.56 4.798 2.01 1.429-1.45 3.146-2.1 4.796-2.01 1.954.1 3.714 1.22 4.601 3.01.896 1.81.846 4.17-.514 6.67z"
            ></path>`;
            likeIcon.classList.remove('like-post');
            likeIcon.classList.add("unlike-post");
      }
    })
}

const calculateLikeCount = (likeIcon) => {
      const likeCount = document.querySelector('.likes-count');
            if (likeIcon.classList.contains('unlike-post')){
                  likeCount.textContent = parseInt(likeCount.textContent) - 1;
                  likeCount.textContent == "0" && (likeCount.textContent = "");
            }
            else{
                  const likecount = parseInt(likeCount.textContent);
                  likeCount.textContent = isNaN(likecount)?1:likeCount + 1;
            }


}

postInput.addEventListener("input" , () => {
      tweetButton.style.backgroundColor = ifSomething()? "#1d9bf0":"#124e78";

})

const ifSomething = () =>{
      return postInput.value.trim().length > 0;
}

floatingTweetBtn.addEventListener("click", ()=>{
  document.querySelector(".tweet-box").style.display = "flex";
  floatingTweetBtn.style.display = "none";
})

profileIcon.addEventListener("click", () =>{
  document.querySelector(".navigation-section").style.display = "block";
  profileIcon.style.display = "none";
})

// Initial load
window.onload =  () => {
  verifyLogin();
  fetchPosts(currPage, 5);
}


function fetchPosts(page = 1, pageSize = 5) {
  console.log("fetched Posts");
  fetch(`http://localhost:5000/api/posts?page=${page}&pageSize=${pageSize}`)
    .then(response => response.json())
    .then(data => {
      data.posts.forEach(element => {
        createPost(element, false);
      });
    })
    .catch(error => {
      console.error('Error fetching posts:', error);
    });
}



window.onbeforeunload = function() {
  socket.emit('disconnect', username)
};


const verifyLogin = () => {
  username = sessionStorage.getItem("username");
  if(!username) {
    window.location.replace("http://localhost:5500/public/login-page")
  }
  socket.emit("new-user", username)
}


window.addEventListener('scroll', () => {
  const { scrollTop, scrollHeight, clientHeight } = document.documentElement;
  if (scrollTop + clientHeight >= scrollHeight - 100) {
  const currentScrollPosition = window.scrollY;
    setTimeout(()=>{}, 1000)
    fetchPosts(++currPage);
    window.scrollTo(0, currentScrollPosition);
  }
});


messageField.addEventListener("click", () => {
  console.log("its clicked");
  postSectionWrapper.style.display = "none";
  chatSection.style.opacity = "1";
})


const socket = io("http://127.0.0.1:5000");

socket.on("online-users", (userDetails) => userDetails.forEach(user => addNewUser(user)));


const addNewUser = (userDetails) => {
    console.log("message came to cliend side");

    const newProfile = document.createElement("div");
    newProfile.classList.add("profile")
    newProfile.classList.add("selected-profile")
    const userImage = document.createElement("img");
    if(userDetails == "kirtan")userImage.src = "./static/2.png";
    else userImage.src = "./static/1.png"
    userImage.alt = "profile photo"
    const userName = document.createElement("h1");
    if(userDetails == "kirtan")userName.textContent = "Kirtan Shah";
    else userName.textContent = "Nitesh Gupta"
    const userHandle = document.createElement("h3");
    if(userDetails == "kirtan")userHandle.textContent = "@kirtan"
    else userHandle.textContent = "@nit-hck";

    newProfile.appendChild(userImage);
    newProfile.appendChild(userName);
    newProfile.appendChild(userHandle);

    chatProfiles.appendChild(newProfile);
}



