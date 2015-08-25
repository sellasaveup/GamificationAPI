function termometer(totalvalue,currentvalue,cb){
    var $thermo = $(".donation-meter .glass");
    var $progress = $(".amount", $thermo);

	if(isNaN(totalvalue) || isNaN(currentvalue) ){
    }
	
	termoPogress = Math.ceil((parseFloat(currentvalue)/parseFloat(totalvalue))*100);
	arrowProgress = termoPogress-5;
	
	termoPogress = (termoPogress>100) ? 100 : ((termoPogress<=0) ? 0 : termoPogress);	
	arrowProgress = (termoPogress>100) ? 95 : ((termoPogress<=5) ? 0 : termoPogress-5);
	
	$progress.animate({
        "height": termoPogress+"%"
    }, 1200, function(){
    	$(".total").html("&euro; "+currentvalue);
    	$(".goal").html("&euro; "+totalvalue);
    	 if(cb) cb();
    })
    
    $(".total").animate({
        "bottom": arrowProgress+"%"
    }, 1200);
}
