function playSound(urlstr){
	alert("play");
	var so = new SWFObject("swf/play.swf", "play", "100", "100", "10", "#FFF");
	so.addParam("allowScriptAccess","always");
	so.addVariable("MP3url",urlstr);
	so.write("finishplayer");
	alert(urlstr);
}