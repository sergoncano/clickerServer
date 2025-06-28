let uuid;

document.addEventListener('DOMContentLoaded', async () => {
	loaduuid();
	await loadscore();
});

function loaduuid() {
	const params = new URLSearchParams(window.location.search);
	uuid = params.get("uuid") || "Error: No uuid found";
	document.getElementById("uuid-label").textContent = decodeURIComponent(uuid);
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

