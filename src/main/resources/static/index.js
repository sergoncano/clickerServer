async function login() {
	let token = document.getElementById("login-textarea").value;
	const response = await fetch(
		"/api/authentication/login",
		{
			method: "POST",
			body: token,
			headers: {
				"Content-type": "text/plain; charset=UTF-8",
			},
		},
	);
	if (!response.ok) {
		const text = await response.text();
		alert(text);
	} else {
		opengame(token);
	}
}

async function register() {
	let username = document.getElementById("register-textarea").value;
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
		const text = await response.text();
		alert(text);
	} else {
		const text = await response.text();
		opengame(text);
	}
}

function opengame(uuid) {
	window.open("/main/main.html?uuid=" + uuid.replace(" ", "%20"), "_self");
}
