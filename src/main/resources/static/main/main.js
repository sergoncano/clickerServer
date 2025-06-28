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
	alert("Your login token is: " + uuid + ". Note it down or you will lose access to your account.");
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
	const response = await fetch(
	  "/api/game/click",
	  {
		method: "POST",
		body: uuid,
		headers: {
			  "Content-type": "text/plain; charset=UTF-8",
		},
	  },
	);
	if(response.ok) {
		await loadscore();
	} else {
		alert("There was a problem connecting to the server.")
	}
}

function increaseScore() {
	  const currentScore = document.getElementById("score-label").textContent;
	  document.getElementById("score-label").textContent = currentScore + 1;

}
