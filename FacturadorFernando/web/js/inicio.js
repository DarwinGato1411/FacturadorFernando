const deleteTags = (node) => {
  const container = document.querySelector(node);
  if (!container) {
    return;
  }
  const list = Array.from(container.querySelectorAll(".z-label"));
  list.forEach((e) => e.classList.remove("z-label"));
};

const stopLoading = () => {
  const loading = document.querySelector(".loading_inicio");
  if (loading) {
    loading.style.display = "none";
  }
};

const resolvePasswordInput = () => {
  if (typeof zk !== "undefined" && zk.Widget) {
    const widget = zk.Widget.$("$password");
    if (widget) {
      if (typeof widget.getInputNode === "function") {
        const node = widget.getInputNode();
        if (node) {
          return node;
        }
      }
      const root = typeof widget.$n === "function" ? widget.$n() : null;
      if (root) {
        if (root.tagName === "INPUT") {
          return root;
        }
        const nested = root.querySelector("input");
        if (nested) {
          return nested;
        }
      }
    }
  }

  const wrap = document.querySelector(".input_password");
  if (wrap) {
    if (wrap.tagName === "INPUT") {
      return wrap;
    }
    const nested = wrap.querySelector("input");
    if (nested) {
      return nested;
    }
  }

  return document.querySelector(".wrapper_input input[type='password']");
};

const showPassword = () => {
  const field = resolvePasswordInput();
  const icon = document.querySelector(".icon_eye");
  if (!field || !icon || icon.dataset.toggleBound === "1") {
    return;
  }
  icon.dataset.toggleBound = "1";
  icon.addEventListener("click", (event) => {
    event.preventDefault();
    event.stopPropagation();
    const hidden = field.getAttribute("type") === "password";
    field.setAttribute("type", hidden ? "text" : "password");
  });
};

const getLoginOverlay = () => document.querySelector(".container_wrapper_signin_root");

const openLoginPopup = (event) => {
  if (event) {
    event.preventDefault();
    event.stopPropagation();
  }
  const overlay = getLoginOverlay();
  if (!overlay) {
    return;
  }
  overlay.classList.add("is-open");
  overlay.style.display = "flex";
  const account = document.querySelector("#account input, input#account, .wrapper_input input");
  if (account && typeof account.focus === "function") {
    setTimeout(() => account.focus(), 50);
  }
};

window.tfOpenLogin = openLoginPopup;

const closeLoginPopup = () => {
  const overlay = getLoginOverlay();
  if (!overlay) {
    return;
  }
  overlay.classList.remove("is-open");
  overlay.style.display = "none";
};

const fireRegistro = () => {
  closeLoginPopup();
  if (typeof zk !== "undefined" && zk.Widget) {
    const widget = zk.Widget.$("$btnRegistra");
    if (widget) {
      widget.fire("onClick");
      return;
    }
  }
  const registro = document.querySelector("#btnRegistra button, button#btnRegistra, #btnRegistra");
  if (registro) {
    registro.click();
  }
};

const bindLandingActions = () => {
  const overlay = getLoginOverlay();
  const loginButtons = document.querySelectorAll(".login_btn, #btnMostrarLogin");
  const closeBtn = document.querySelector("#btnCerrarLogin");
  const registroPopup = document.querySelector("#linkRegistroPopup");

  loginButtons.forEach((btn) => {
    if (btn.dataset.bound === "1") {
      return;
    }
    btn.dataset.bound = "1";
    btn.addEventListener("click", openLoginPopup);
  });

  if (closeBtn && closeBtn.dataset.bound !== "1") {
    closeBtn.dataset.bound = "1";
    closeBtn.addEventListener("click", (event) => {
      event.stopPropagation();
      closeLoginPopup();
    });
  }

  if (overlay && overlay.dataset.bound !== "1") {
    overlay.dataset.bound = "1";
    overlay.addEventListener("click", (event) => {
      if (event.target.closest(".wrapper_signin")) {
        return;
      }
      closeLoginPopup();
    });
  }

  if (registroPopup && registroPopup.dataset.bound !== "1") {
    registroPopup.dataset.bound = "1";
    registroPopup.addEventListener("click", (event) => {
      event.stopPropagation();
      fireRegistro();
    });
  }
};

(() => {
  zk.afterMount(function () {
    showPassword();
    bindLandingActions();
    setTimeout(showPassword, 300);
    setTimeout(() => {
      deleteTags(".login_container");
      showPassword();
      bindLandingActions();
      stopLoading();
    }, 2000);
  });
})();
