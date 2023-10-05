window.onload = function () {
  const $h1 = document.querySelector('h1');

  const startButton = document.querySelector('#startButton');
  const checkButton = document.querySelector('#checkButton');

  const container = document.querySelector('.container');
  const buttonsContainer = document.querySelector('#buttonsContainer');
  const memo = document.querySelector('#memo');

  let minNumber = 0;
  let maxNumber = 0;
  let answerNumber = 0;
  let targetButton;

  // let answer = document.querySelector('#answer');
  let userSelect = document.querySelector('#userSelect');

  // console.log(answer);

  // 게임 시작하기
  startButton.addEventListener('click', () => {
    const inputNumber = parseInt(prompt('숫자를 입력해주세요', 120));

    if (inputNumber < 1 || isNaN(inputNumber)) {
      alert('0 이상의 숫자를 입력해주세요');
      return;
    }
    container.style.display = 'flex';
    minNumber = inputNumber;
    maxNumber = minNumber + 100;
    answerNumber = getAnswerNumber(minNumber, maxNumber);

    console.log(minNumber, maxNumber, answerNumber);

    $h1.textContent = '시스템이 숫자를 선택하였습니다.';
    startButton.textContent = '다시하기';
    startButton.disabled = true;

    // answer.textContent = answerNumber;

    // 버튼 그리기
    for (let row = 0; row < 10; row++) {
      for (let col = minNumber; col < minNumber + 10; col++) {
        let button = document.createElement('button');

        button.textContent = row * 10 + col + '';
        button.id = row * 10 + col;

        buttonsContainer.appendChild(button);

        button.addEventListener('click', () => {
          userSelect.textContent = button.id;
          this.targetButton = button;

          checkButton.onclick = checkResult(this.targetButton);
        });
      }
      buttonsContainer.appendChild(document.createElement('br'));
    }
  });

  const checkResult = (button) => {
    console.log(button)
    // const target = parseInt(button.id);
    // console.log(button.id);

    // 정답 < 사용자 입력
    // 정답 > 사용자 입력
    // 정답 == 사용자 입력
    // if (target > answerNumber) {
    //   memo.append(`정답 숫자는 ${target}보다 작은 숫자입니다. ` + '\n');
    // } else if (target < answerNumber) {
    //   memo.append(`정답 숫자는 ${target}보다 큰 숫자입니다. ` + '\n');
    // } else if (target === answerNumber) {
    //   memo.append('정답입니다. \n');
    // }
  };

  const getRandomNumber = (num) => {
    return Math.floor(Math.random() * num);
  };

  const getAnswerNumber = (min, max) => {
    return Math.floor(Math.random() * (max - min) + min);
  };
};
