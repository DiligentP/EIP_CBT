const headerTimer = document.querySelector(".header__timer");

const getTimer = () => {
  const startTime = new Date();

  timer = setInterval(() => {
    const now = new Date();
    // console.log(((now - startTime) / 1000).toFixed(2));
    headerTimer.innerText = `${((now - startTime) / 1000).toFixed(2)}`;
  });
};

getTimer();
