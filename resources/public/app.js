alert('here')

var l = window.location
var url = 'ws://' + l.host + '/chat' + l.pathname
var ws = new WebSocket(url)

  function byId(id){
    return document.getElementById(id)
  }

var out = byId('out')
var inp = byId('inp')

inp.onkeyup = function(e) {
  if (e.ctrlKey && e.keyCode == 13){
    ws.send(inp.value)
  }
}

ws.onmessage = function(e) {
  console.log(e.data)
  out.innerHTML += e.data
}

