function playSound(urlstr){
	var so = new SWFObject("swf/play.swf", "play", "0", "0", "10", "#FFF");
	so.addParam("allowScriptAccess","always");
	so.addVariable("MP3url",urlstr);
	so.write("finishplayer");
}