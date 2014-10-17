console.log('ups')

var l = window.location
var ws = new WebSocket('ws://'+l.host + '/chat' + (l.pathname == '/' ? '/anonimous' : l.pathname))


var byId = function(id){
  return document.getElementById(id)
}

var inp = byId('inp')
var out = byId('out')

inp.onkeyup = function(e){
  if(e.ctrlKey && e.keyCode == 13){
    console.log('send', inp.value)
    ws.send(inp.value)
  }
}
ws.onmessage = function(e){
  console.log(e.data)
  out.innerHTML += e.data
}
