function addRow() {
	const tbody = document.querySelector("tbody");
	const tr = document.createElement("tr");
	const rows = tbody.querySelectorAll(".member-row");
	const stt = rows[rows.length - 1].textContent;
	tr.className = "member-row"; // Add a class for identification

	// Add columns for the new row
	tr.innerHTML = `
		<td>${parseInt(stt) + 1}</td>
		<td><input class="input-border-bottom p-1" id="input${parseInt(stt) + 1}"
		name="mssv${parseInt(stt) + 1}" size="10"</td>
		<td><input type="radio" onclick="setMaNT()" name="MaTrgNhom" id="${parseInt(stt) + 1
		}" value=""></td>
	`;

	// Add the new row to the table
	tbody.appendChild(tr);
}

function deleteLastRow() {
	const tbody = document.querySelector("tbody");
	const rows = tbody.querySelectorAll(".member-row");

	// Check if there are rows to delete
	if (rows.length > 1) {
		// Remove the last row
		tbody.removeChild(rows[rows.length - 1]);
	} else {
		console.log("No rows to delete.");
	}
}
function setMaNT() {

	const tbody = document.querySelector("tbody");
	const rows = tbody.querySelectorAll(".member-row");
	const input = "input";

	for (var i = 0; i < rows.length; i++) {
		let y = (i + 1).toString()
		let rs = input.concat(y);
		let x = document.getElementById(rs).value;
		if (document.getElementById(y).checked) {
			document.getElementById(y).value = x;
			document.getElementById(y).setAttribute("name",y);
		}
		else (document.getElementById(y).value = null);
	}

}
