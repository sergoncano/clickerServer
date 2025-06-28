document.addEventListener('DOMContentLoaded', async () => {
	await autologin();
});

async function sendLogin() {
	const uuid = document.getElementById("login-textarea").value;
	await login(uuid);
}

async function login(uuid) {
	const response = await fetch(
		"/api/authentication/login",
		{
			method: "POST",
			body: uuid,
			headers: {
				"Content-type": "text/plain; charset=UTF-8",
			},
		},
	);
	if (!response.ok) {
		const text = await response.text();
		alert(text);
	} else {
		const username = await response.text();
		localStorage.setItem("uuid", uuid);
		localStorage.setItem("username", username);
		opengame();
	}
}

async function autologin() {
	const uuid = localStorage.getItem("uuid");
	if(uuid==null) { return; }
	await login(uuid);
}

async function sendRegister() {
	let username = document.getElementById("register-textarea").value;
	await register(username);
}

async function register(username) {
	const response = await fetch(
		"/api/authentication/register",
		{
			method: "POST",
			body: username,
			headers: {
				"Content-type": "text/plain; charset=UTF-8",
			},
		},
	);
	if (!response.ok) {
		const text = response.body;
		alert(text);
	} else {
		const uuid = await response.text();
		localStorage.setItem("uuid", uuid);
		localStorage.setItem("username", username);
		opengame();
	}
}

function opengame() {
	window.open("/main/main.html", "_self");
}
