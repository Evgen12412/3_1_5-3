const urlUser = "http://localhost:34444/user";

fetch(urlUser)
    .then(response => response.json())
    .catch(error => console.log(error))

let userPageInfo = ' '
const showUserInfo = (user) => {
    const container = document.getElementById("tbody-user")
    userPageInfo +=
        `<tr>
            <td>${user.id}</td>
            <td>${user.username}</td>
            <td>${user.surname}</td>
            <td>${user.age}</td>
            <td>${user.roles.map(role => role.name)}</td>
        </tr>`
    container.innerHTML = userPageInfo
}


let userNavbar = '';
const detailsUser = (user) => {
    const containerNavbar = document.getElementById("navbarUser");
    userNavbar += `
         <span class="navbar-brand mb-0 h1" style="color:white; margin-right: 20px">${user.username}</span>
         <span class="navbar-brand mb-0 h1" style="color:white">${user.roles.map(role => role.name)}</span>
         <a href="/login">
         <button type="button" class="btn btn-primary mr float-right" style="margin-left: 800px">
         Выйти
         </button>
         </a>                                    
                                    
    `
    containerNavbar.innerHTML = userNavbar
}

fetch(urlUser)
    .then(response => response.json())
    .then(data => {
        showUserInfo(data);
        detailsUser(data)
    })
    .catch(error => console.log(error))

