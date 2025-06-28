let uuid;

document.addEventListener('DOMContentLoaded', async () => {
	loadstats();
	await loadscore();
});

function loadstats() {
	uuid = localStorage.getItem("uuid");
	username = localStorage.getItem("username");
	if(uuid == null) {
		alert("No uuid found");
		history.back();
	}
	if(username == null) {
		alert("No username found");
		history.back();
	}
	document.getElementById("username-label").textContent = username;
	document.getElementById("uuid-label").textContent = uuid;
}

function logout() {
	alert("Your user identifier is: " + uuid + ". Don't forget it or you will lose access to your account.");
	localStorage.removeItem("uuid");
	localStorage.removeItem("username");
	window.open("/index.html", "_self");
}

async function loadscore() {
	let response = await getscore();
	if (!response.ok) {
	  alert("An error occurred while fetching your score.");
	} else {
	  const score = await response.text();
	  document.getElementById("score-label").textContent = score;
	}
}

async function getscore() {
	const response = await fetch(
		"/api/game/score/" + uuid,
		{
			method: "GET",
			headers: {
				"Content-type": "text/plain; charset=UTF-8",
			},
		},
	);
	return response;
}

async function clickfunction() {
	await fetch(
	  "/api/game/click",
	  {
		method: "POST",
		body: uuid,
		headers: {
			  "Content-type": "text/plain; charset=UTF-8",
		},
	  },
	);
	await loadscore();
}

