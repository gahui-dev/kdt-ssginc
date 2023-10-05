Timer = function (discount) {
  this.myIntervalId;
  this.box;
  this.discount = discount;

  this.initTimer = function () {
    console.log('시작');
    this.box = document.getElementById('box-div');
    this.box.open = true;
    this.box.textContent = this.discount;
    this.box.className = 'on-box';

    // blinkOn();
    let $this = this;
    this.myIntervalId = setInterval(function () {
      $this.countDown();
    }, 1000);
  };

  this.countDown = function () {
    if (this.box.open) {
      this.box.open = false;
      this.blinkOff();
    } else {
      this.box.open = true;
      this.blinkOn();
    }

    this.discount--;
    this.box.textContent = this.discount;
    console.log(this.discount)

    if(this.discount == 0) {
      this.countCheck();
    }

  };

  // 
  this.countCheck = function () {
    if (this.discount < -1 || this.discount == 0) {
      console.log(this.discount)
      console.log("카운트 끝")
      this.finishCountDown();
    }
  };


  this.finishCountDown = function () {
    clearInterval(this.myIntervalId);
  };

  this.blinkOn = function () {
    this.box.className = 'on-box';
  };
  
  this.blinkOff = function () {
    this.box.className = 'off-box';
  };
};
