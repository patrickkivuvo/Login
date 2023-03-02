
const loginText = document.querySelector(".title-text .login");
const loginForm = document.querySelector("form.login");
const loginBtn = document.querySelector("label.login");
const signupBtn = document.querySelector("label.signup");
const signupLink = document.querySelector("form .signup-link a");
const username = document.getElementById('username');
const passw = document.getElementById('passw');

signupBtn.onclick = (()=>{
    loginForm.style.marginLeft = "-50%";
    loginText.style.marginLeft = "-50%";
});

loginBtn.onclick = (()=>{
    loginForm.style.marginLeft = "0%";
    loginText.style.marginLeft = "0%";
});

signupLink.onclick = (()=>{
    signupBtn.click();
    return false;
});

const handleSubmit = async (e) =>{
    try {
        e.preventDefault();
        if(username.value == '' || passw.value == ''){
            alert('All fields are required !!');
        }else{
            const res = await axios.get(`http://localhost:8080/user/username/${username.value}`);
            console.log(res.data);
            if(res.data == ''){
                alert('user does not exist, please signup!!!');
                window.location.reload(true);
            }else{
                location.href='./logged.html';
            }
        }
    } catch (error) {
        console.log(error)
    }
}

const postUser = async (e) =>{
    try {
        e.preventDefault();
        const username = document.getElementById('user').value;
        const password = document.getElementById('password').value;
        if(username == '' || password == ''){
            alert('All fields are required !!');
        }else{
            const data = {username,password};
            const res = await axios.post('http://localhost:8080/user', data);
            console.log(res);
            window.location.reload(true);
        }
    } catch (error) {
        alert('error');
    }
}
