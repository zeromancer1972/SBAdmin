// core app library
dojo._xhr = dojo.xhr;
var loadOld;
function hijacked(response, ioArgs) {
	// your code or function here (pre-processed)
	loadOld(response, ioArgs);
	// your code or function here (post-processed)
	$("table").tablesorter( {
		debug : false
	});
}
dojo.xhr = function(mode, args, bool) {
	loadOld = args["load"];
	args["load"] = hijacked;
	dojo._xhr(mode, args, bool);
}

dojo.addOnLoad( function() {
	$("table").tablesorter( {
		debug : false
	});
})