(function($) {
	var FakePoller = function(options, callback) {
		var defaults = {
			frequency : 1,
			limit : 10
		};
		this.callback = callback;
		this.config = $.extend(defaults, options);
		var list = [];

		this.userCodeList = usercodeObjThisMonth;
		this.userPoints = pointsObjThisMonth;
		this.userAvatar = useravatarObjThisMonth;
		this.userRanks = userRankObjThisMonth;
	}

	FakePoller.prototype.getData = function() {
		var results = [];
		for (var i = 0, len = 10; i < len; i++) {
			
			
			results.push({
				
				userName : (this.userCodeList[i] ? this.userCodeList[i] : ""),
				userPoint : (this.userPoints[i] ? this.userPoints[i] : ""),
				userImage : ( this.userAvatar[i] ?  this.userAvatar[i] : ""),
				userRank : (this.userRanks[i] ? this.userRanks[i] : "")

			});
			
		}
		return results;
	};
	FakePoller.prototype.processData = function() {
		return this.sortData(this.getData()).slice(0, this.config.limit);
	};

	FakePoller.prototype.sortData = function(data) {
		return data.sort(function(a, b) {
			return b.count - a.count;
		});
	};
	FakePoller.prototype.start = function() {
		var _this = this;
		this.interval = setInterval((function() {
			_this.callback(_this.processData());
		}), this.config.frequency * 10);
		this.callback(this.processData());
		return this;
	};
	FakePoller.prototype.stop = function() {
		clearInterval(this.interval);
		return this;
	};
	window.FakePoller = FakePoller;

	var leaderboardthisMonth = function(elemId, options) {
		var _this = this;
		var defaults = {
			limit : 10,
			frequency : 15
		};
		this.currentItem = 0;
		this.currentCount = 0;
		this.config = $.extend(defaults, options);

		this.$elem = $(elemId);
		if (!this.$elem.length)
			this.$elem = $('<div>').appendTo($('body'));

		this.list = [];
		this.$contentthistime = $('<ul>');
		this.$elem.append(this.$contentthistime);

		this.poller = new FakePoller({
			frequency : this.config.frequency,
			limit : this.config.limit
		}, function(data) {
			if (data) {
				if (_this.currentCount != data.length) {
					_this.buildElements(_this.$contentthistime, data.length);
				}
				_this.currentCount = data.length;
				_this.data = data;
				_this.list[0].$item.addClass('animate');
			}
		});

		this.poller.start();
	};

	leaderboardthisMonth.prototype.buildElements = function($ul, elemSize) {
		var _this = this;
		$ul.empty();
		this.list = [];

		for (var i = 0; i < elemSize; i++) {
			var item = $('<li>').on(
					"animationend webkitAnimationEnd oAnimationEnd",
					eventAnimationEnd.bind(this)).appendTo($ul);
			this.list.push({
				$item : item,
				$userImage : $('<span class="userImage">Loading...</span>')
					.appendTo(item),
				$userName : $('<span class="userName" style="font-size:14px;">Loading...</span>')
					.appendTo(item),
				$userRank : $('<span class="userRank" style="font-size:14px;">Loading...</span>')
					.appendTo(item),
				$userPoint : $('<span class="userPoint" style="font-size:15px;">Loading...</span>')
					.appendTo(item)
			});
		}

		function eventAnimationEnd(evt) {
			this.list[this.currentItem].$userName
			.html(_this.data[this.currentItem].userName ? "<b>" +_this.data[this.currentItem].userName + " " : "</b>&nbsp;&nbsp;&nbsp;&nbsp;");
	
			this.list[this.currentItem].$userRank
			.html(_this.data[this.currentItem].userRank ? "<b>&nbsp;&nbsp;#" + _this.data[this.currentItem].userRank : "</b>&nbsp;&nbsp;&nbsp;&nbsp;");
	
			this.list[this.currentItem].$userPoint
			.html(_this.data[this.currentItem].userPoint ? "<b>&nbsp;&nbsp;&nbsp;&nbsp;" + _this.data[this.currentItem].userPoint + "&nbsp" + "points" : "</b>&nbsp;&nbsp;&nbsp;&nbsp;");
	
			this.list[this.currentItem].$userImage
			.html(_this.data[this.currentItem].userImage ? '<img src="./img/profile/' + _this.data[this.currentItem].userImage
			+ '" class="img-circle" width="50" height="50">' + ' ' : "&nbsp;&nbsp;&nbsp;&nbsp;");
	
			this.list[this.currentItem].$item.removeClass('animate');
			this.currentItem = this.currentItem >= this.currentCount - 1 ? 0
					: this.currentItem + 1;
			if (this.currentItem != 0) {
				this.list[this.currentItem].$item.addClass('animate');
			}
		}
	};

	Function.prototype.bind = function() {
		var fn = this, args = Array.prototype.slice.call(arguments), object = args
				.shift();
		return function() {
			return fn.apply(object, args.concat(Array.prototype.slice
					.call(arguments)));
		};
	};

	window.leaderboardthisMonth = leaderboardthisMonth;
	// Helper
	function rnd(min, max) {
		min = min || 100;
		if (!max) {
			max = min;
			min = 1;
		}
		return Math.floor(Math.random() * (max - min + 1) + min);
	}

	function numberFormat(num) {
		return num.toString().replace(/\B(?=(\d{3})+(?!\d))/g, ",");
	}
})(jQuery);

var usercodeObjThisMonth = [];
var pointsObjThisMonth = []
var useravatarObjThisMonth = [];
var userRankObjThisMonth = [];

function getThisMonthLeaderBoard(userCode, commonUrl) {

	var buildUrl = commonUrl + 'GET_LEADERBOARD?goalCode=';
	buildUrl = buildUrl + userCode + '&requestType=' + 'M';
	$.ajax({
		type : "GET",
		url : buildUrl,
		dataType : "json",
		contentType : "application/json; charset=UTF-8",
		success : function(data) {
			var challengeList = data.Result;
			for (i = 0; i < data.Result.length; i++) {
				usercodeObjThisMonth[i] = data.Result[i].name;
				useravatarObjThisMonth[i] = data.Result[i].userAvatar;
				userRankObjThisMonth[i] = data.Result[i].rank;
				pointsObjThisMonth[i] = data.Result[i].points;
			}
		},
		error : function(e) {
			console.log('leaderboard call failure : ' + e);
		}
	});
	
	var myLeaderboard = new leaderboardthisMonth(".contentthistime", {limit:10,frequency:10});
}