Timer = function (disCount) {
  this.myIntervalId;
  this.box;
  this.disCount = disCount;

  this.initTimer = function () {
    console.log("시작")
    this.box = document.getElementById('box-div');
    this.box.open = true;
    this.box.textContent = this.disCount;
    this.box.className = 'on-box';

    let $this = this;
    this.myIntervalId = setInterval(function(){
      $this.countDown();
    }, 1000);
  };

  this.countDown = function () {
    // console.log(this.box.open)
    if (this.box.open) {
      this.box.open = false;
      this.blinkOff();
    } else {
      this.box.open = true;
      this.blinkOn();
    }

    this.disCount--;
    this.box.textContent = this.disCount;
    if (this.disCount == 0) {
      clearInterval(this.myIntervalId);
    }
  };

  this.blinkOn = function () {
    this.box.className = 'on-box';
  };
  
  this.blinkOff = function () {
    this.box.className = 'off-box';
  };
};
