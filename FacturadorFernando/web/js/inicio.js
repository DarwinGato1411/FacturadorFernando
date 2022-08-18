const deleteTags = (node) => {
  /*
   *  Se eliminan todas las etiquetas que contengan z-label
   *    en el nodo padre pasado por argumento
   */

  const container = document.querySelector(node);

  const list = Array.from(container.querySelectorAll(".z-label"));
  list.forEach((e) => e.classList.remove("z-label"));
};

const stopLoading = () => {
  const loading = document.querySelector(".loading_inicio");
  loading.style.display = "none";
};

(() => {
  document.addEventListener("DOMContentLoaded", () => {
    setTimeout(() => {
      deleteTags(".container_landing"); //inicio.zul
      stopLoading();
    }, 2000);
  });
})();
