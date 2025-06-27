async function login() {
	let token = (<HTMLInputElement>document.getElementById("login-textarea"))?.value;
	const response = await fetch(
		"http://localhost:8080/api/authentication/login",
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
		const text = await response.text();
		alert(text);
	}
}

async function register() {
	let username = (<HTMLInputElement>document.getElementById("register-textarea"))?.value;
	const response = await fetch(
		"http://localhost:8080/api/authentication/register",
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
		alert(text);
	}
}
