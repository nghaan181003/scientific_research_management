function addRow() {
    const tbody = document.querySelector("tbody");
    const tr = document.createElement("tr");
    const rows = tbody.querySelectorAll(".member-row");
    const stt = rows[rows.length - 1].textContent;
    tr.className = "member-row"; // Add a class for identification

    // Add columns for the new row
    tr.innerHTML = `
    <td>${parseInt(stt)+1}</td>
    <td><input class="input-border-bottom p-1" size="10"></td>
																	<td><input class="input-border-bottom p-1" size="25"></td>
																	<td><input class="input-border-bottom p-1" size="15"></td>
																	<td><input class="input-border-bottom p-1"></td>
																	<td><input type="radio" name="group" id=""></td>
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
  function addLyDo() {
    // Tạo một đối tượng tr mới
  
    // Thêm hàng mới vào bảng
    var elems = document.querySelector(".div-ly-do");
    elems.style.display = "block";
  }
  function hideLyDo() {
    // Tạo một đối tượng tr mới
  
    // Thêm hàng mới vào bảng
    var elems = document.querySelector(".div-ly-do");
    elems.style.display = "none";
  }
