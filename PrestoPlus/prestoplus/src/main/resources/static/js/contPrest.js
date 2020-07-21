// Mudar cor inputs date
function MudarCorDaIni() {
    let dataIni = document.getElementById("dataIni");
    dataIni.style.color = "black";
  }
  
  function MudarCorDaTer() {
    let dataTer = document.getElementById("dataTer");
    dataTer.style.color = "black";
  }
  
  
  
  // Upload de imagens
  window.URL = window.URL || window.webkitURL;
  
  var fileSelect = document.getElementById("fileSelect"),
      fileElem = document.getElementById("fileElem");
  
  fileSelect.addEventListener("click", function (e) {
    if (fileElem) {
      fileElem.click();
    }
    e.preventDefault(); // prevent navigation to "#"
  }, false);
  
  function handleFiles(files) {
    if (!files.length) {
      console.log("<p>No files selected!</p>");
    } else {
      var list = document.createElement("ul");
      list.setAttribute("class", "ulImg");
      for (var i = 0; i < files.length; i++) {
        var li = document.createElement("li");
        li.setAttribute("class", "liImg");
        list.appendChild(li);
        
        var img = document.createElement("img");
        img.src = window.URL.createObjectURL(files[i]);
        img.setAttribute("class", "imgImg");
        // img.setAttribute("onclick", "verImg()");
        // img.height = 60;
        img.onload = function(e) {
          window.URL.revokeObjectURL(this.src);
        }
        li.appendChild(img);
        
        var info = document.createElement("span");
        info.setAttribute("class", "spanImg");
        info.innerHTML = files[i].name + ": " + files[i].size + " bytes";
        li.appendChild(info);
      }
      fileList.appendChild(list);
    }
  }